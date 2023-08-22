@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.rodrigojscript.micoctelera.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.rodrigojscript.micoctelera.model.RandomDrink

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
        for (i in 1..15) {
            val ingredient = when (i) {
                1 -> drink.strIngredient1
                2 -> drink.strIngredient2
                3 -> drink.strIngredient3
                4 -> drink.strIngredient4
                5 -> drink.strIngredient5
                6 -> drink.strIngredient6
                7 -> drink.strIngredient7
                8 -> drink.strIngredient8
                9 -> drink.strIngredient9
                10 -> drink.strIngredient10
                11 -> drink.strIngredient11
                12 -> drink.strIngredient12
                13 -> drink.strIngredient13
                14 -> drink.strIngredient14
                15 -> drink.strIngredient15
                else -> null
            }
            ingredient?.let {
                Text(text = "- $ingredient")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Instructions:", style = MaterialTheme.typography.h6)
        Text(text = drink.strInstructions)
    }
}
