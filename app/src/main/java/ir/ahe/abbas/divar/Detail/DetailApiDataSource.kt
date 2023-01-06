package ir.ahe.abbas.divar.Detail

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Api.ApiClient
import ir.ahe.abbas.divar.Api.ApiService
import ir.ahe.abbas.divar.Models.DetailModel
import ir.ahe.abbas.divar.Models.MessageModel

class DetailApiDataSource:DetailDataSource {
    override fun getDetail(id: String): Single<DetailModel> {

        return ApiClient.getClient().create(ApiService::class.java).getDetailAds(id)
    }

    override fun addToFav(idp: String, phone: String): Single<MessageModel>? {
        return ApiClient.getClient().create(ApiService::class.java).addToFav(idp, phone)
    }

    override fun deleteFav(idp: String, phone: String): Single<MessageModel>? {
        return ApiClient.getClient().create(ApiService::class.java).deleteFav(idp, phone)

    }
}