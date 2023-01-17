package com.rodrigojscript.micoctelera.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.unit.dp
import com.rodrigojscript.micoctelera.getDrinksByIngredients
import com.rodrigojscript.micoctelera.model.ApiService
import com.rodrigojscript.micoctelera.model.Ingredients
import com.rodrigojscript.micoctelera.ui.components.IngredientsComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var list =

@Composable
fun IngredientsScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Ingredientes") }) }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {

                items (ingredients) { contacto->
                    MostrarContacto(contacto)
                }

        }
    }
}

fun searchIngredient() {
    CoroutineScope(Dispatchers.IO).launch {
        val call = getDrinksByIngredients().create(ApiService::class.java).getIngredient("api/json/v1/1/list.php?i=list")
        val ingredient = call.body()
        if (call.isSuccessful) {
            if (ingredient != null) {
                ingredient.ingredients
            }
        } else {
            //show error
            Log.d("mainA", "No encontrado")
        }
    }
}