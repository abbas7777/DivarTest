package ir.ahe.abbas.divar.PageAdver

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.AdverModel

interface PageAdverDataSource {

    fun getADverForDaste(id:String):Single<List<AdverModel>>
}