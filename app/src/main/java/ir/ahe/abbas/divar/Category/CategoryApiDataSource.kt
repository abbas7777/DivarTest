package ir.ahe.abbas.divar.Category

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Api.ApiClient
import ir.ahe.abbas.divar.Api.ApiService
import ir.ahe.abbas.divar.Models.CatModel

class CategoryApiDataSource :CategoryDataSource {
    override fun getCats(): Single<List<CatModel>> {

        return ApiClient.getClient().create(ApiService::class.java).getAllCats()
    }
}