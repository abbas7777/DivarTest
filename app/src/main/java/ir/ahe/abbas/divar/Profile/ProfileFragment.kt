package ir.ahe.abbas.divar.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.ahe.abbas.divar.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
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

     var v:View? = null
    lateinit var txtName:TextView
    lateinit var rvButton:RecyclerView
    lateinit var rlLoading:RelativeLayout
    lateinit var linCheck:LinearLayout
    lateinit var linConnetc:LinearLayout
    lateinit var txtTryAgain:TextView
    lateinit var txtEnter:TextView
    lateinit var pb:ProgressBar
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (v==null){
            v=inflater.inflate(R.layout.fragment_profile, container, false)
        }

        setUpViews()
        return v
    }

    fun setUpViews(){
        txtName=v!!.findViewById(R.id.txt_ProfileFragment_name)
        rvButton=v!!.findViewById(R.id.rv_ProfileFragment_items)
        rlLoading=v!!.findViewById(R.id.rl_ProfileFragment_parent)
        linCheck=v!!.findViewById(R.id.linlay_ProfileFragment_check)
        linConnetc=v!!.findViewById(R.id.linlay_ProfileFragment_connect)
        txtTryAgain=v!!.findViewById(R.id.txt_ProfileFragment_tryagain)
        txtEnter=v!!.findViewById(R.id.btn_ProfileFragment_enter)
        pb=v!!.findViewById(R.id.pb_HomeFragment_loading)

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}