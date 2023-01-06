package ir.ahe.abbas.divar.Home

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.AdverModel

interface HomeDataSource {

    fun getAllAds():Single<List<AdverModel>>
}