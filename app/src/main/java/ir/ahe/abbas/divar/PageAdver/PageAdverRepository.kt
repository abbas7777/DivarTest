package ir.ahe.abbas.divar.PageAdver

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.AdverModel

class PageAdverRepository :PageAdverDataSource {
    val pageAdverApiDataSource=PageAdverApiDataSource()
    override fun getADverForDaste(id: String): Single<List<AdverModel>> {

        return pageAdverApiDataSource.getADverForDaste(id)
    }
}