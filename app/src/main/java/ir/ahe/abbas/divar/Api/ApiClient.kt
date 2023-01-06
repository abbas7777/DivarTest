package ir.ahe.abbas.divar.Api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient  {


    companion object factory{
        var BASE_URL="http://192.168.43.127/divar/"

        fun getClient():Retrofit{

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }

    }
}