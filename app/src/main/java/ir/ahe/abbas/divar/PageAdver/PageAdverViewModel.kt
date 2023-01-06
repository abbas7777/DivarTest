package ir.ahe.abbas.divar.PageAdver

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.AdverModel

class PageAdverViewModel {
    val pageAdverRepository=PageAdverRepository()

    fun getADverForDaste(id: String): Single<List<AdverModel>> {

        return pageAdverRepository.getADverForDaste(id)
    }
}