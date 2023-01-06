package ir.ahe.abbas.divar.Category

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.CatModel

interface CategoryDataSource  {

    fun getCats():Single<List<CatModel>>
}