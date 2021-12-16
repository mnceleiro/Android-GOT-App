package es.mnceleiro.pmdm.listagot.model.dao.restapi

import es.mnceleiro.pmdm.listagot.model.entities.GotCharacter
import retrofit2.Call
import retrofit2.http.GET

interface GotApiService {
    @GET("Characters")
    fun getAllCharacters(): Call<List<GotCharacter>>
}