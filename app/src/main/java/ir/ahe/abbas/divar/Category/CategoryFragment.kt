package ir.ahe.abbas.divar.Category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.ahe.abbas.divar.Models.CatModel
import ir.ahe.abbas.divar.PageAdver.PageAdverFragment
import ir.ahe.abbas.divar.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {
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

    lateinit var rvCats: RecyclerView
    var v:View? = null
    var categoryViewModel = CategoryViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (v==null){
            v=inflater.inflate(R.layout.fragment_category, container, false)
        }

        setUpViews()
        getCats()
        return v
    }






    fun setUpViews() {
        rvCats = v!!.findViewById(R.id.rv_CategoryFragment)
        rvCats.layoutManager = LinearLayoutManager(activity)


    }

    fun getCats() {
        categoryViewModel.getCats().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ v ->
                rvCats.adapter = RvCatsAdapter(
                    requireActivity(),
                    v,
                    object : RvCatsAdapter.OnClickCatListner {
                        override fun onClick(catModel: CatModel) {
                            var manger = activity!!.supportFragmentManager
                            val tra = manger.beginTransaction()
                            var fr = PageAdverFragment()
                            var bundel = Bundle()
                            bundel.putString("id", catModel.id)
                            bundel.putString("title", catModel.cattitle)
                            fr.arguments = bundel
                            tra.replace(R.id.fl_CategoryFragment_host, fr)
                            tra.addToBackStack(null)
                            tra.commit()

                        }

                    })
            },
                { e ->

                    Toast.makeText(requireActivity(), e.toString(), Toast.LENGTH_SHORT).show()
                })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}