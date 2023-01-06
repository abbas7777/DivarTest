package ir.ahe.abbas.divar.Category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.ahe.abbas.divar.Models.CatModel
import ir.ahe.abbas.divar.R

class RvCatsAdapter(var c:Context,var catList: List<CatModel> ,var OnClick:OnClickCatListner) :RecyclerView.Adapter<RvCatsAdapter.RvCatsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvCatsViewHolder {

        return RvCatsViewHolder(LayoutInflater.from(c).inflate(R.layout.item_cat,parent,false))
    }

    override fun onBindViewHolder(holder: RvCatsViewHolder, position: Int) {
        var catmodel=catList.get(position)
        holder.txtTiltle.text=catmodel.cattitle
        holder.parent.setOnClickListener{
            OnClick.onClick(catmodel)
        }
    }

    override fun getItemCount(): Int {
        return catList.size
    }


    inner class RvCatsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var txtTiltle=itemView.findViewById<TextView>(R.id.txt_itemCat_title)
        var parent=itemView.findViewById<RelativeLayout>(R.id.rl_itemCat_parent)
    }

    interface OnClickCatListner{
        fun onClick(catModel: CatModel)
    }
}