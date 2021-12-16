package es.mnceleiro.pmdm.listagot.model.dao.restapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://stackoverflow.com/questions/61729790/retrofit-singleton-in-kotlin
// https://www.section.io/engineering-education/making-api-requests-using-retrofit-android/
object RetrofitClient {
    private fun retrofitClient(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("https://thronesapi.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    val retrofitService: GotApiService by lazy {
        retrofitClient().create(GotApiService::class.java)
    }
}