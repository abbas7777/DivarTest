package ir.ahe.abbas.divar.Regester

import android.content.Context
import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.MessageModel

interface RegesterDataSource {

    fun regster(phone:String,name:String,pass:String) : Single<MessageModel>?

    fun saveUser(phone: String,pass: String,c:Context)
}