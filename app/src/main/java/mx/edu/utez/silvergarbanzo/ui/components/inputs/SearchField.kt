package mx.edu.utez.silvergarbanzo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.silvergarbanzo.R


@Composable
fun SearchField(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: Int = 10
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.Gray),
        contentPadding = PaddingValues(0.dp) // 🔹 elimina el padding interno por defecto
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize() // 🔹 hace que la fila ocupe todo el botón
                .padding(horizontal = 8.dp), // pequeño margen interno
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.lupa),
                contentDescription = "Icono de búsqueda",
                modifier = Modifier.size(10.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Buscar...",
                fontSize = fontSize.sp,
                color = Color.White // 🔹 asegura contraste si el fondo es oscuro
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSearchField() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1d23)),
        contentAlignment = Alignment.Center
    ) {
        SearchField(
            onClick = {},
            modifier = Modifier
                .width(180.dp)
                .height(45.dp),
            fontSize = 12
        )
    }
}
