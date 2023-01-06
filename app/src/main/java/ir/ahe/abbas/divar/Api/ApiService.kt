package ir.ahe.abbas.divar.Api

import io.reactivex.rxjava3.core.Single
import ir.ahe.abbas.divar.Models.AdverModel
import ir.ahe.abbas.divar.Models.CatModel
import ir.ahe.abbas.divar.Models.DetailModel
import ir.ahe.abbas.divar.Models.MessageModel
import retrofit2.http.*

interface ApiService {

    @GET("allads.php")
    fun getAllAds():Single<List<AdverModel>>

    @GET("cat.php")
    fun getAllCats():Single<List<CatModel>>

    @GET("uniqecat.php")
    fun getAdverForDaste(@Query("id") id:String):Single<List<AdverModel>>

    @GET("uniqeads.php")
    fun getDetailAds(@Query("id") id:String):Single<DetailModel>

    @FormUrlEncoded
    @POST("addtofavorlist.php")
    fun addToFav(@Field("idp") idp:String,@Field("phone") phone:String):Single<MessageModel>

    @FormUrlEncoded
    @POST("deletefav.php")
    fun deleteFav(@Field("idp") idp:String,@Field("phone") phone:String):Single<MessageModel>

    @FormUrlEncoded
    @POST("regester.php")
    fun regester(@Field("phone") phone:String,@Field("name") name:String,@Field("pass") pass:String):Single<MessageModel>
}