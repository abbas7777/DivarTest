package ir.ahe.abbas.divar.Regester

import android.content.Context
import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Api.ApiClient
import ir.ahe.abbas.divar.Api.ApiService
import ir.ahe.abbas.divar.Models.MessageModel

class RegesterApiDataSource :RegesterDataSource {
    override fun regster(phone: String, name: String, pass: String): Single<MessageModel>? {

        return ApiClient.getClient().create(ApiService::class.java).regester(phone, name, pass)
    }

    override fun saveUser(phone: String, pass: String, c: Context) {
        TODO("Not yet implemented")
    }
}