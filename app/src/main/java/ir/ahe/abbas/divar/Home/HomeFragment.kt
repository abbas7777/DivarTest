package ir.ahe.abbas.divar.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.ahe.abbas.divar.Detail.DetailActivity
import ir.ahe.abbas.divar.Models.AdverModel
import ir.ahe.abbas.divar.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var viewModel = HomeViewModel()
    private lateinit var recyclerView:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    var v:View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (v==null) {
            v = inflater.inflate(R.layout.fragment_home, container, false)

        }

        setUpViews()
        getAllAds()
        return v
    }

    fun setUpViews() {

        recyclerView=v!!.findViewById(R.id.rv_HomeFragment_ads)

        recyclerView.layoutManager = GridLayoutManager(activity, 2)
    }

    fun getAllAds(){

        viewModel.getAllAds(). subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {  v->
                recyclerView.adapter=RvAdsAdapter(requireContext(),v,  object : RvAdsAdapter.OnClickAdsItemListner{
                    override fun onClick(id: String) {
                        var i=Intent(requireActivity(),DetailActivity::class.java)
                        i.putExtra("id",id)
                        startActivity(i)
                    }

                })
            },
            { e ->
                requireActivity().runOnUiThread(Runnable {
                    Toast.makeText(activity, e.toString(),Toast.LENGTH_SHORT).show()

                })
            }
        )
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}