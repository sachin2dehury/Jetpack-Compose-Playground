package com.steleot.jetpackcompose.playground.compose.animation

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.graph.AnimationNavRoutes
import com.steleot.jetpackcompose.playground.navigation.graph.MainNavRoutes

val routes = listOf(
    AnimationNavRoutes.Animatable,
    AnimationNavRoutes.AnimatedContent,
    AnimationNavRoutes.AnimatedValues,
    AnimationNavRoutes.AnimatedVector,
    AnimationNavRoutes.AnimatedVisibility,
    AnimationNavRoutes.AnimateEnterExit,
    AnimationNavRoutes.AnimationModifier,
    AnimationNavRoutes.CrossfadeAnimation,
    AnimationNavRoutes.DoubleTapToLike,
    AnimationNavRoutes.ElevationAnimation,
    AnimationNavRoutes.GestureAnimation,
    AnimationNavRoutes.InfiniteTransition,
    AnimationNavRoutes.RotateAnimation,
    AnimationNavRoutes.ScaleAnimation,
    AnimationNavRoutes.SingleValueColorAnimation,
    AnimationNavRoutes.SingleValueFloatAnimation,
    AnimationNavRoutes.SuspendAnimation,
)

@Composable
fun AnimationScreen() {
    MainScreen(
        title = MainNavRoutes.Animation,
        list = routes,
    )
}