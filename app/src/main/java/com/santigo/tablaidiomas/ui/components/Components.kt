package com.santigo.tablaidiomas.ui.components

import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.santigo.tablaidiomas.R
import com.santigo.tablaidiomas.ui.theme.TablaIdiomasTheme


class MinFabItem(
    val icon: ImageBitmap,
    val label: String,
    val id: String
)

enum class MultiFloatingState{
    Expanded,
    Collapsed
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TablaIdiomasTheme {
        Greeting("Android")
        BotonElegirIdioma()
    }
}
//ImageBitmap.imageResource(id = R.drawable.ic_baseline_attachment_24)
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun BotonElegirIdioma(){

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    var multiFloatingState by remember { mutableStateOf(MultiFloatingState.Collapsed)}

    Box(){

        Scaffold(
            floatingActionButton = {
               MultiFloatingButton(
//                   multiFloatingState = multiFloatingState,
//                   onMultiFabStateChange = {
//                       multiFloatingState = it
//                   },
//                   items = items
               )
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,


        ) {

        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MultiFloatingButton() {
    @DrawableRes var itemClicked: Int = R.drawable.ic_espana
    val items = listOf(
        MultiFabItem(
            id = 1,
            iconRes = R.drawable.ic_espana,
            label = "asd"
        ),
        MultiFabItem(
            id = 2,
            iconRes = R.drawable.ic_brasil,
            label = "asd"
        ),
        MultiFabItem(
            id = 3,
            iconRes = R.drawable.ic_reinounido,
            label = "asd"
        ),
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(PaddingValues(30.dp)),
        contentAlignment = Alignment.BottomEnd
    ){
        MultiFloatingActionButton(items = items,
            fabIcon = FabIcon(iconRes = R.drawable.ic_launcher_foreground, iconRotate = 45f),
            onFabItemClicked = {
                println(it)
            },
            stateChanged = {

            },
            fabOption = FabOption(
                iconTint = Color.White,
                showLabels = true
            )
        )

    }
}