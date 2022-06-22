package com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.theme.AndroidSudokuSolverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidSudokuSolverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


//test comment
@Composable
fun Greeting(name: String) {
    Text(text = "Dolphin $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidSudokuSolverTheme {
        Greeting("Android")
    }
}