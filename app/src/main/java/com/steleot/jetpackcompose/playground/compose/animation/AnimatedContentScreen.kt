package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.navigation.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "animation/AnimatedContentScreen.kt"

@Composable
fun AnimatedContentScreen() {
    DefaultScaffold(
        title = AnimationNavRoutes.AnimatedContent,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimateIncrementDecrementExample()
            AnimatedContentTransitionSpecExample()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimateIncrementDecrementExample() {
    Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        var count by remember { mutableStateOf(0) }
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically(initialOffsetY = { it }) + fadeIn() with slideOutVertically(
                        targetOffsetY = { -it }) + fadeOut()
                } else {
                    slideInVertically(initialOffsetY = { -it }) + fadeIn() with slideOutVertically(
                        targetOffsetY = { it }) + fadeOut()
                }.using(SizeTransform(clip = false))
            }
        ) { targetCount ->
            Text("$targetCount", fontSize = 20.sp)
        }
        Spacer(Modifier.size(20.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { count-- }) { Text(stringResource(id = R.string.minus)) }
            Spacer(Modifier.size(60.dp))
            Button(onClick = { count++ }) { Text(stringResource(id = R.string.plus)) }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimatedContentTransitionSpecExample() {
    var cartState by remember { mutableStateOf(CartState.Collapsed) }
    val transitionSpec: AnimatedContentScope<CartState>.() -> ContentTransform =
        {
            fadeIn(animationSpec = tween(150, delayMillis = 150))
                .with(fadeOut(animationSpec = tween(150)))
                .using(
                    SizeTransform { initialSize, targetSize ->
                        if (CartState.Collapsed isTransitioningTo CartState.Expanded) {
                            keyframes {
                                durationMillis = 500
                                IntSize(targetSize.width, initialSize.height + 200) at 150
                            }
                        } else {
                            keyframes {
                                durationMillis = 500
                                IntSize(
                                    initialSize.width,
                                    (initialSize.height + targetSize.height) / 2
                                ) at 150
                            }
                        }
                    }
                )
        }
    AnimatedContent(
        targetState = cartState,
        transitionSpec = transitionSpec
    ) { state ->
        when (state) {
            CartState.Expanded -> ExpandedCart {
                cartState = CartState.Collapsed
            }
            CartState.Collapsed -> CollapsedCart {
                cartState = CartState.Expanded
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ExpandedCart(
    onClick: () -> Unit
) {
    val shoppingCart = stringResource(id = R.string.shopping_cart)
    Card(
        shape = CutCornerShape(12.dp),
        onClick = onClick,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.AddShoppingCart,
                contentDescription = shoppingCart
            )
            Text(
                text = shoppingCart,
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CollapsedCart(
    onClick: () -> Unit
) {
    Card(
        shape = CutCornerShape(12.dp),
        onClick = onClick,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(16.dp)
        )
    }
}

private enum class CartState {
    Expanded,
    Collapsed
}