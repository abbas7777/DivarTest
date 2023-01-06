package ir.ahe.abbas.divar.Detail

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.DetailModel
import ir.ahe.abbas.divar.Models.MessageModel

class DetailViewModel {
    var detailRepository=DetailRepository()
    fun getDetail(id: String): Single<DetailModel> {

        return detailRepository.getDetail(id)
    }

    fun addToFav(idp: String, phone: String): Single<MessageModel>? {
        return detailRepository.addToFav(idp, phone)
    }

    fun deleteFav(idp: String, phone: String): Single<MessageModel>? {
        return detailRepository.deleteFav(idp, phone)
    }

}