package ir.ahe.abbas.divar.Home

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.AdverModel

class HomeViewModel  {

    var homeRepository=HomeRepository()

    fun getAllAds(): Single<List<AdverModel>> {

        return homeRepository.getAllAds()
    }
}