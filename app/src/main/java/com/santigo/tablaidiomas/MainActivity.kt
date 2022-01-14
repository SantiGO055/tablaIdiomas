package com.santigo.tablaidiomas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.santigo.tablaidiomas.model.ImageButton
import com.santigo.tablaidiomas.model.ImageClass
import com.santigo.tablaidiomas.ui.components.BotonElegirIdioma
import com.santigo.tablaidiomas.ui.theme.TablaIdiomasTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TablaIdiomasTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val viewModel: ImageClass by viewModels()

                    var listaImagenes by remember{ mutableStateOf(listOf<ImageButton>()) }
                    val isLoading by viewModel.isLoading().observeAsState()
                    BotonElegirIdioma()


                }
            }
        }
    }
}

