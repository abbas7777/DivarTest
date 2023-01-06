package ir.ahe.abbas.divar.Api

import retrofit2.create

class ApiProvider {

    companion object{

        var apiService: ApiService? =null

        fun apiService():ApiService{
            if (apiService==null){

                apiService=ApiClient.getClient()!!.create(ApiService::class.java)
            }

            return apiService!!
        }
    }

}