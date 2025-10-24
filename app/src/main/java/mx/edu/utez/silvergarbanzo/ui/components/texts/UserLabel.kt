package mx.edu.utez.silvergarbanzo.ui.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun UserLabel(
    text: String,
    fontSize: Int = 15,
    color: Color = Color(0xFF087E8B),
    textAlign: TextAlign = TextAlign.Left,
    modifier: Modifier = Modifier
){
    Text(
        text = "@$text",
        fontSize = fontSize.sp,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}