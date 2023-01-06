package ir.ahe.abbas.divar.Home

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.AdverModel

class HomeRepository :HomeDataSource {
    var homeApiDataSource=HomeApiDataSource()
    override fun getAllAds(): Single<List<AdverModel>> {

        return homeApiDataSource.getAllAds()
    }
}