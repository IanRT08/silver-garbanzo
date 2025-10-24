package mx.edu.utez.silvergarbanzo.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.ui.components.texts.Label

@Composable
fun ReseñaCard(
    imageRes: Int,
    modifier: Modifier = Modifier,
    nombrePeli: String,
    username: String,
    desc: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2a2c33)
        ),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Pelicula",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Label(text = nombrePeli, fontSize = 15)
                Label(text = "@$username", fontSize = 9)
                Spacer(modifier = Modifier.height(3.dp))
                Image(
                    painter = painterResource(R.drawable.rate4),
                    contentDescription = "Rating",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(60.dp)
                        .height(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Label(text = desc, fontSize = 10, modifier = Modifier
                .padding(5.dp).fillMaxHeight())
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReseñaPreviewCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23)),
        contentAlignment = Alignment.Center
    ) {
        ReseñaCard(
            imageRes = R.drawable.wicked,
            nombrePeli = "Wicked",
            username = "silvergarbanzo",
            desc = "De las mejores películas que he visto este año",
        )
    }
}