package ir.ahe.abbas.divar.Regester

import android.content.Context
import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.MessageModel
import ir.ahe.abbas.divar.SharePerfService.SharePerfService

class RegesterSharePerfDataSource :RegesterDataSource {
    override fun regster(phone: String, name: String, pass: String): Single<MessageModel>? {
        TODO("Not yet implemented")
    }

    override fun saveUser(phone: String, pass: String, c: Context) {
        var sh = SharePerfService(c)
        sh.saveLoginInfos(phone,pass )
    }
}