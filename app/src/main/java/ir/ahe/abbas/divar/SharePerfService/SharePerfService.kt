package ir.ahe.abbas.divar.SharePerfService

import android.content.Context
import android.content.SharedPreferences




class SharePerfService(context: Context) {
    val c=context
    var pref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    init {
        pref = context.getSharedPreferences("ACE", 0)
        editor = pref!!.edit()
    }



    fun saveLoginInfos(name: String?, phone: String?) {
        editor!!.putString("name", name)
        editor!!.putString("phone", phone)
        editor!!.commit()
    }

    fun getPass(): String? {
        return pref!!.getString("pass", "")
    }

    fun getName(): String? {
        return pref!!.getString("name", "")
    }

    fun updateName(name: String?) {
        editor!!.putString("name", name)
        editor!!.apply()
    }

    fun deleteSherKey() {
        editor!!.clear().commit()
    }
}