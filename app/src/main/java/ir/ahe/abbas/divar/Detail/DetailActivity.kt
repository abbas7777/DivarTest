package ir.ahe.abbas.divar.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.ahe.abbas.divar.R

class DetailActivity : AppCompatActivity() {

    lateinit var txtTitle: TextView
    lateinit var txtDesc: TextView
    lateinit var txtPrice: TextView
    lateinit var pbLoading: ProgressBar
    lateinit var pbBtn: ProgressBar
    lateinit var rlLoading: RelativeLayout
    lateinit var linLoading: LinearLayout
    var detailViewModel = DetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpViews()
        getDetail()

    }

    fun setUpViews() {
        var btnChat: Button = findViewById(R.id.btn_DetailActivity_chat)
        var imvFav: ImageView = findViewById(R.id.imv_DetailActivity_addtofav)
        var imvClose: ImageView = findViewById(R.id.imv_DetailActivity_close)
        var txtTryAgain:TextView = findViewById(R.id.txt_DetailActivity_tryagain)
        txtTitle = findViewById(R.id.txt_DetailActivity_name)
        txtDesc = findViewById(R.id.txt_DetailActivity_infos)
        txtPrice = findViewById(R.id.txt_DetailActivity_price)
        pbLoading = findViewById(R.id.pb_DetailActivity_loading)
        pbBtn = findViewById(R.id.pb_DetailActivity_btnCartLoading)
        rlLoading = findViewById(R.id.rl_DetailActivity_parent)
        linLoading = findViewById(R.id.linlay_DetailActivity)

        txtTryAgain.setOnClickListener{
            rlLoading.visibility = View.GONE
            linLoading.visibility = View.GONE
            pbLoading.visibility = View.VISIBLE
            getDetail()
        }

        imvFav.setOnClickListener {
            if (getDrawableId(imvFav) == 1) {
                imvFav.setImageResource(R.drawable.ic_baseline_favorite_24);
                imvFav.setTag(2);

                detailViewModel.addToFav(intent.getStringExtra("id")!!,"531231231")!!.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        v->
                        if (v.message.equals("s")){
                            Toast.makeText(baseContext!!,"با موفقیت به لیست علاقه مندی ها اضافه شد!",Toast.LENGTH_SHORT).show()

                        }else{
                            Toast.makeText(baseContext!!,"مشکل ارتباط با سرور!",Toast.LENGTH_SHORT).show()
                        }

                    },{e->
                        Toast.makeText(baseContext!!,"مشکل ارتباط با سرور!",Toast.LENGTH_SHORT).show()
                        imvFav.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                        imvFav.setTag(1);

                    })



            } else {
                imvFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                imvFav.setTag(1)
                detailViewModel.deleteFav(intent.getStringExtra("id")!!,"")!!.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({v->
                        Toast.makeText(baseContext!!,"با موفقیت از لیست علاقه مندی ها حذف شد!",Toast.LENGTH_SHORT).show()

                    },{e->
                        Toast.makeText(baseContext!!,"مشکل ارتباط با سرور!",Toast.LENGTH_SHORT).show()
                        imvFav.setImageResource(R.drawable.ic_baseline_favorite_24);
                        imvFav.setTag(2);

                    })

            }
        }
        }


    fun getDetail() {
        detailViewModel.getDetail(intent.getStringExtra("id")!!).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ v ->
                rlLoading.visibility = View.GONE
                txtTitle.text = v.title
                txtDesc.text = v.description
                txtPrice.text = v.price

            }, { e ->
                rlLoading.visibility = View.VISIBLE
                linLoading.visibility = View.VISIBLE
                pbLoading.visibility = View.GONE

            })
    }

    fun getDrawableId( iv:ImageView) :Int{
        return Integer.parseInt(iv.getTag().toString());
    }
}