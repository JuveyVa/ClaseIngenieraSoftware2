package com.juvey.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juvey.examen.act1.SumView
import com.juvey.examen.act1.SumViewModel
import com.juvey.examen.act3.GameView
import com.juvey.examen.act3.GameViewModel
import com.juvey.examen.act4.ImcView
import com.juvey.examen.act4.ImcViewModel
import com.juvey.examen.examen3er.ExamenView
import com.juvey.examen.examen3er.ExamenViewModel
import com.juvey.examen.screensexam.viewmodel.RestViewModel
import com.juvey.examen.screensexam.views.MyApp
import com.juvey.examen.screensexam.views.RestView
import com.juvey.examen.ui.theme.ExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenTheme {
        Greeting("Android")
    }
}