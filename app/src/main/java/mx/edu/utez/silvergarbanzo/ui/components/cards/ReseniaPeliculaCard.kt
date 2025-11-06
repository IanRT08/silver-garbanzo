package mx.edu.utez.silvergarbanzo.ui.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import mx.edu.utez.silvergarbanzo.R
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPelicula

@Composable
fun ReseniaPeliculaCard(
    resenia: ReseniaPelicula,
    onEditClick: (ReseniaPelicula) -> Unit,
    onDeleteClick: (ReseniaPelicula) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onEditClick(resenia) },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2a2c33)
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = resenia.tituloPelicula,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Row {
                    IconButton(
                        onClick = { onEditClick(resenia) },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_edit),
                            contentDescription = "Editar",
                            tint = Color(0xFF4CAF50)
                        )
                    }
                    IconButton(
                        onClick = { onDeleteClick(resenia) },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_delete),
                            contentDescription = "Eliminar",
                            tint = Color(0xFFF44336)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Calificación: ",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
                Row {
                    for (i in 1..5) {
                        Icon(
                            painter = painterResource(
                                if (i <= resenia.calificacion) R.drawable.star_filled else R.drawable.corazon
                            ),
                            contentDescription = "Estrella",
                            tint = if (i <= resenia.calificacion) Color(0xFFFFD700) else Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
                Text(
                    text = " (${resenia.calificacion}/5)",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            //Reseña (si existe)
            if (resenia.resenia.isNotBlank()) {
                Text(
                    text = resenia.resenia,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFd0d0d0),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(
                            if (resenia.like) R.drawable.likes else R.drawable.corazon
                        ),
                        contentDescription = "Like",
                        tint = if (resenia.like) Color(0xFFF44336) else Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (resenia.like) "Me gusta" else "No me gusta",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(
                    text = if (resenia.yaLaVi) "✓ Vista" else "No vista",
                    color = if (resenia.yaLaVi) Color(0xFF4CAF50) else Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}