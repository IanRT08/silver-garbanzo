package mx.edu.utez.silvergarbanzo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mx.edu.utez.silvergarbanzo.ui.Navigation
import mx.edu.utez.silvergarbanzo.ui.theme.SilverGarbanzoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SilverGarbanzoTheme {
                Navigation()
            }
            }
        }
    }