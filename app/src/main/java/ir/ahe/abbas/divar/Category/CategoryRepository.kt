package ir.ahe.abbas.divar.Category

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.CatModel

class CategoryRepository : CategoryDataSource {

    var categoryApiDataSource=CategoryApiDataSource()
    override fun getCats(): Single<List<CatModel>> {

        return categoryApiDataSource.getCats()
    }
}