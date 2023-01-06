package ir.ahe.abbas.divar.Regester

import android.content.Context
import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.MessageModel

class RegesterRepository :RegesterDataSource {
    var regesterApiDataSource=RegesterApiDataSource()
    var regesterSharePerfDataSource=RegesterSharePerfDataSource()
    override fun regster(phone: String, name: String, pass: String): Single<MessageModel>? {

        return regesterApiDataSource.regster(phone, name, pass)
    }

    override fun saveUser(phone: String, pass: String, c: Context) {
        regesterSharePerfDataSource.saveUser(phone,pass,c)
    }
}