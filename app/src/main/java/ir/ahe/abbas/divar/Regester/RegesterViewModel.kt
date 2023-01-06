package ir.ahe.abbas.divar.Regester

import android.content.Context
import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.MessageModel

class RegesterViewModel {

    var regesterRepository = RegesterRepository()
    fun regster(phone: String, name: String, pass: String): Single<MessageModel>? {

        return regesterRepository.regster(phone, name, pass)
    }

    fun saveUser(phone: String, pass: String, c: Context) {
        regesterRepository.saveUser(phone,pass,c)
    }
}