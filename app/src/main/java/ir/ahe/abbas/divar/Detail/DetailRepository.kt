package ir.ahe.abbas.divar.Detail

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.DetailModel
import ir.ahe.abbas.divar.Models.MessageModel

class DetailRepository :DetailDataSource {
    var detailApiDataSource=DetailApiDataSource()

    override fun getDetail(id: String): Single<DetailModel> {

        return detailApiDataSource.getDetail(id)
    }

    override fun addToFav(idp: String, phone: String): Single<MessageModel>? {
        return detailApiDataSource.addToFav(idp, phone)
    }

    override fun deleteFav(idp: String, phone: String): Single<MessageModel>? {
        return detailApiDataSource.deleteFav(idp, phone)
    }

}