package ir.ahe.abbas.divar.Category

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.CatModel

class CategoryViewModel {

    var categoryRepository=CategoryRepository()
    fun getCats(): Single<List<CatModel>> {

        return categoryRepository.getCats()
    }
}