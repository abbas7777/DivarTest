package ir.ahe.abbas.divar.PageAdver

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Api.ApiClient
import ir.ahe.abbas.divar.Api.ApiService
import ir.ahe.abbas.divar.Models.AdverModel

class PageAdverApiDataSource :PageAdverDataSource {
    override fun getADverForDaste(id: String): Single<List<AdverModel>> {

        return ApiClient.getClient().create(ApiService::class.java).getAdverForDaste(id)
    }
}