package mx.edu.utez.silvergarbanzo.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import mx.edu.utez.silvergarbanzo.R

@Composable
fun RecentCardLike(
    imageRes: Int,
    rate: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(100.dp)
            .height(180.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2a2c33)
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Pelicula",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(145.dp)
            )
            Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(rate),
                    contentDescription = "Rating",
                    modifier = Modifier
                        .size(60.dp),
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.drawable.corazon),
                    contentDescription = "Like",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(2.dp)
                )
            }
        }
    }
}