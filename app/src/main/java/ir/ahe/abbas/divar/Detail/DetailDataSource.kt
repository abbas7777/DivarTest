package ir.ahe.abbas.divar.Detail

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.DetailModel
import ir.ahe.abbas.divar.Models.MessageModel

interface DetailDataSource {

    fun getDetail(id:String):Single<DetailModel>

    fun addToFav(idp:String,phone:String):Single<MessageModel>?

    fun deleteFav(idp:String,phone:String):Single<MessageModel>?
}