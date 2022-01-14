package com.santigo.tablaidiomas.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.rotate


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun MultiFloatingActionButton(
    modifier: Modifier = Modifier,
    items: List<MultiFabItem>,
    fabState: MutableState<MultiFabState> = rememberMultiFabState(),
    fabIcon: FabIcon,
    fabOption: FabOption = FabOption(),
    onFabItemClicked: (fabItem: MultiFabItem) -> Unit,
    stateChanged: (fabState: MultiFabState) -> Unit = {}
) {
    val rotation by animateFloatAsState(
        if (fabState.value == MultiFabState.Expand) fabIcon.iconRotate ?: 0f else 0f
    )

    Column(
        modifier = modifier.wrapContentSize(),
        horizontalAlignment = Alignment.End
    ) {
        AnimatedVisibility(
            visible = fabState.value.isExpanded(),
            enter = fadeIn() + expandVertically(),
            exit = fadeOut()
        ) {
            LazyColumn(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(items = items, key = { it.id }) { item ->
                    MiniFabItem(
                        item = item,
                        fabOption = fabOption,
                        onFabItemClicked = onFabItemClicked,
                        fabState = fabState
                    )
                }

                item {} // for Spacing
            }
        }
        FloatingActionButton(
            onClick = {
                fabState.value = fabState.value.toggleValue()
                stateChanged(fabState.value)
            },
            backgroundColor = fabOption.backgroundTint,
            contentColor = fabOption.iconTint
        ) {
            Icon(
                painter = painterResource(fabIcon.iconRes),
                modifier = Modifier.rotate(rotation),
                contentDescription = null,
                tint = fabOption.iconTint
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun MiniFabItem(
    item: MultiFabItem,
    fabOption: FabOption,
    onFabItemClicked: (item: MultiFabItem) -> Unit,
    fabState: MutableState<MultiFabState> = rememberMultiFabState()
) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(end = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (fabOption.showLabels) {
            Text(
                item.label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(color = MaterialTheme.colors.surface)
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            )
        }
        FloatingActionButton(
            modifier = Modifier.size(40.dp),
            onClick = {
                onFabItemClicked(item)
                fabState.value = fabState.value.toggleValue()
              },
            backgroundColor = fabOption.backgroundTint,
            contentColor = fabOption.iconTint
        ) {
            Icon(
                painter = painterResource(item.iconRes),
                contentDescription = null,
                tint = fabOption.iconTint
            )
        }
    }
}