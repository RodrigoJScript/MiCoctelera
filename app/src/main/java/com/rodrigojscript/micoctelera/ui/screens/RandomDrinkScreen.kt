package com.rodrigojscript.micoctelera.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rodrigojscript.micoctelera.model.ApiService
import com.rodrigojscript.micoctelera.model.RandomDrink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun RandomDrinkScreen() {
    var randomDrink by remember { mutableStateOf<RandomDrink?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    fun loadRandomDrink() {
        isLoading = true
        CoroutineScope(Dispatchers.IO).launch {
            val call = getDrinksByIngredients().create(ApiService::class.java)
                .getRandomDrink("api/json/v1/1/random.php")
            val drinks = call.body()
            if (call.isSuccessful) {
                if (drinks != null) {
                    randomDrink = drinks.drinks.first()
                    Log.d("mainA", "Random drink: $randomDrink")
                }
            } else {
                Log.d("mainA", "No encontrado")
            }
            isLoading = false
        }
    }

    LaunchedEffect(key1 = true) {
        loadRandomDrink()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            if (randomDrink != null) {
                RandomDrinkInfo(randomDrink!!)
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { loadRandomDrink() },
                ) {
                    Text(text = "Cargar otro coctel aleatorio")
                }
            } else if (isLoading) {
                Text("Loading...")
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
