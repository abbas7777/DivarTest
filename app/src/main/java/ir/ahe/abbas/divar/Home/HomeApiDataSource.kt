package ir.ahe.abbas.divar.Home

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Api.ApiClient
import ir.ahe.abbas.divar.Api.ApiProvider
import ir.ahe.abbas.divar.Api.ApiService
import ir.ahe.abbas.divar.Models.AdverModel

class HomeApiDataSource :HomeDataSource {
    override fun getAllAds(): Single<List<AdverModel>> {
        return ApiClient.getClient().create(ApiService::class.java).getAllAds()
    }
}