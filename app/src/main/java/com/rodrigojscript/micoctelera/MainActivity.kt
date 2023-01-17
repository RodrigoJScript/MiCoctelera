package com.rodrigojscript.micoctelera

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.rodrigojscript.micoctelera.model.ApiService
import com.rodrigojscript.micoctelera.ui.screens.IngredientsScreen
import com.rodrigojscript.micoctelera.ui.screens.searchIngredient
import com.rodrigojscript.micoctelera.ui.theme.BaseAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    searchByName("Vodka")
                    searchIngredient()
                    IngredientsScreen()

                }
            }
        }
    }
}

fun getDrinksByIngredients(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

 fun searchByName(query: String) {
    CoroutineScope(Dispatchers.IO).launch {
        val call = getDrinksByIngredients().create(ApiService::class.java).getDrinksByIngredient("api/json/v1/1/filter.php?i=$query")
        val drinks = call.body()
        if (call.isSuccessful) {
            if (drinks != null) {
                Log.d("mainA", "urlDOgsIs: ${drinks.drinks}")
            }
        } else {
            //show error
            Log.d("mainA", "No encontrado")
        }
    }
}

