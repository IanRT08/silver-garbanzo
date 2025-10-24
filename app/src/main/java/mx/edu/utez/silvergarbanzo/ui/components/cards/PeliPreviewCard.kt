package mx.edu.utez.silvergarbanzo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.silvergarbanzo.R

@Composable
fun PeliPreviewCard(
    imageRes: Int,
    label: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(110.dp)
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
                contentDescription = label,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(145.dp)
            )
            Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(R.drawable.ojo),
                    contentDescription = "Vistas",
                    modifier = Modifier
                        .size(13.dp),
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = label,
                    fontSize = 12.sp,
                    color = Color.White,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewImageCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23)),
        contentAlignment = Alignment.Center
    ) {
        PeliPreviewCard(
            imageRes = R.drawable.wicked,
            label = "233K",
        )
    }
}
