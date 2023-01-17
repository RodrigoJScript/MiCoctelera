package com.rodrigojscript.micoctelera.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getDrinksByIngredient(@Url url:String): Response<DrinksByIngredientsResult>

    @GET
    suspend fun getIngredient(@Url url:String): Response<IngredientsResult>

}