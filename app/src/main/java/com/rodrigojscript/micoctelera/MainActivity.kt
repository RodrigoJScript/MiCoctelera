package com.rodrigojscript.micoctelera

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.rodrigojscript.micoctelera.model.ApiService
import com.rodrigojscript.micoctelera.model.RandomDrink
import com.rodrigojscript.micoctelera.ui.theme.BaseAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
                    RandomDrinkScreen()
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

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RandomDrinkScreen() {
    var randomDrink by remember { mutableStateOf<RandomDrink?>(null) }
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
            //show error
            Log.d("mainA", "No encontrado")
        }
    }
    if (randomDrink != null) {
        RandomDrinkInfo(randomDrink!!)
    } else {
        Text("Loading...")
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RandomDrinkInfo(drink: RandomDrink) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = drink.strDrink, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = rememberImagePainter(drink.strDrinkThumb),
            contentDescription = drink.strDrink,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Ingredients:", style = MaterialTheme.typography.h6)
        Text(text = "- ${drink.strIngredient1}")
        Text(text = "- ${drink.strIngredient2}")
        Text(text = "- ${drink.strIngredient3}")
        Text(text = "- ${drink.strIngredient4}")
        if (drink.strIngredient5 != null) {
            Text(text = "- ${drink.strIngredient5}")
        }
        if (drink.strIngredient6 != null) {
            Text(text = "- ${drink.strIngredient6}")
        }
        if (drink.strIngredient7 != null) {
            Text(text = "- ${drink.strIngredient7}")
        }
        if (drink.strIngredient8 != null) {
            Text(text = "- ${drink.strIngredient8}")
        }
        if (drink.strIngredient9 != null) {
            Text(text = "- ${drink.strIngredient9}")
        }
        if (drink.strIngredient10 != null) {
            Text(text = "- ${drink.strIngredient10}")
        }
        if (drink.strIngredient11 != null) {
            Text(text = "- ${drink.strIngredient11}")
        }
        if (drink.strIngredient12 != null) {
            Text(text = "- ${drink.strIngredient12}")
        }
        if (drink.strIngredient13 != null) {
            Text(text = "- ${drink.strIngredient13}")
        }
        if (drink.strIngredient14 != null) {
            Text(text = "- ${drink.strIngredient14}")
        }
        if (drink.strIngredient15 != null) {
            Text(text = "- ${drink.strIngredient15}")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Instructions:", style = MaterialTheme.typography.h6)
        Text(text = drink.strInstructions)
    }
}