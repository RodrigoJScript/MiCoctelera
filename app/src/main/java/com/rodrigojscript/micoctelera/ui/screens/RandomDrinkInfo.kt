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
        Text(text = "- ${drink.strIngredient1}")
        Text(text = "- ${drink.strIngredient2}")
        Text(text = "- ${drink.strIngredient3}")
        Text(text = "- ${drink.strIngredient4}")
        Text(text = "- ${drink.strIngredient5}")
        Text(text = "- ${drink.strIngredient6}")
        Text(text = "- ${drink.strIngredient7}")
        Text(text = "- ${drink.strIngredient8}")
        Text(text = "- ${drink.strIngredient9}")
        Text(text = "- ${drink.strIngredient10}")
        Text(text = "- ${drink.strIngredient11}")
        Text(text = "- ${drink.strIngredient12}")
        Text(text = "- ${drink.strIngredient13}")
        Text(text = "- ${drink.strIngredient14}")
        Text(text = "- ${drink.strIngredient15}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Instructions:", style = MaterialTheme.typography.h6)
        Text(text = drink.strInstructions)
    }
}
