package ir.ahe.abbas.divar.PageAdver

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.ahe.abbas.divar.Models.AdverModel
import ir.ahe.abbas.divar.R

class RvLinearAdsAdapter (var context:Context, var ads:List<AdverModel>, internal var onClickAdsItemListner: OnClickAdsItemListner) : RecyclerView.Adapter<RvLinearAdsAdapter.RvAdsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdsViewHolder {

        return RvAdsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_lin_ads,parent,false))
    }

    override fun onBindViewHolder(h: RvAdsViewHolder, p: Int) {

        var a=ads.get(p)
        Picasso.get().load(a.url).into(h.imvImage)
        h.txtTilte.text=a.title
        h.txtPrice.text=a.price
        h.cvParent.setOnClickListener{
            onClickAdsItemListner.onClick(a.id.toString())
        }

    }


    override fun getItemCount(): Int {
        return ads.size
    }

    inner class RvAdsViewHolder(view: View): RecyclerView.ViewHolder(view){
        var imvImage=view.findViewById<ImageView>(R.id.imv_itemAds_image)
        var txtTilte=view.findViewById<TextView>(R.id.txt_itemAds_title)
        var txtPrice=view.findViewById<TextView>(R.id.txt_itemAds_price)
        var cvParent=view.findViewById<RelativeLayout>(R.id.cv_itemAds_parent)
    }


     interface OnClickAdsItemListner{
        fun onClick(id:String)
    }
}