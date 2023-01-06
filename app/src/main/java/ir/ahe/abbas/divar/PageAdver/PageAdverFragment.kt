package ir.ahe.abbas.divar.PageAdver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.ahe.abbas.divar.Home.RvAdsAdapter
import ir.ahe.abbas.divar.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PageAdverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageAdverFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var rvAdvers: RecyclerView
    lateinit var id: String
    val pVM = PageAdverViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_page_adver, container, false)
        id = requireArguments().getString("id")!!

        setUpViews(view)
        getAdvers()

        return view
    }

    fun setUpViews(view: View) {
        rvAdvers = view.findViewById(R.id.rv_PageAdverFragment_list)
        var txtTitle: TextView = view.findViewById(R.id.txt_PageAdverFragment_title)
        var imvBack: ImageView = view.findViewById(R.id.imv_PageAdverFragment_back)
        var toolbar:RelativeLayout= view.findViewById(R.id.rl_PageAdverFragment_toolbar)
        rvAdvers.layoutManager = LinearLayoutManager(requireActivity())

        txtTitle.text = requireArguments().getString("title")!!
        toolbar.setOnClickListener{

        }
    }

    fun getAdvers() {
        pVM.getADverForDaste(id).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ v ->

                rvAdvers.adapter=RvLinearAdsAdapter(requireActivity(),v,object :RvLinearAdsAdapter.OnClickAdsItemListner{
                    override fun onClick(id: String) {
                        TODO("Not yet implemented")
                    }

                })
            }, { e ->
                Toast.makeText(requireContext(),e.toString(),Toast.LENGTH_SHORT).show()
            })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PageAdverFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PageAdverFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}