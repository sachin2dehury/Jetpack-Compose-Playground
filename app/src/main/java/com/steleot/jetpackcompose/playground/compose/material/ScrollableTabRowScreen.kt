package com.steleot.jetpackcompose.playground.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.MaterialNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold

private const val Url = "material/ScrollableTabRowScreen.kt"

@Composable
fun ScrollableTabRowScreen() {
    DefaultScaffold(
        title = MaterialNavRoutes.ScrollableTabRow,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScrollableTabRowExample()
            EdgePaddingTabRowExample()
            BackgroundColorScrollableTabRow()
            ContentColorScrollableTabRow()
            DividerScrollableTabRow()
            IndicatorScrollableTabRow()
        }
    }
}

private val tabs = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight")

@Preview
@Composable
private fun ScrollableTabRowExample() {
    val selectedTab = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.value
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun EdgePaddingTabRowExample() {
    val selectedTab = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.value,
        edgePadding = 0.dp
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun BackgroundColorScrollableTabRow() {
    val selectedTab = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.value,
        backgroundColor = Color.Yellow
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ContentColorScrollableTabRow() {
    val selectedTab = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.value,
        backgroundColor = Color.Red
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun DividerScrollableTabRow() {
    val selectedTab = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.value,
        divider = {
            Divider(
                modifier = Modifier
                    .requiredHeight(8.dp)
                    .fillMaxWidth()
                    .background(color = Color.Red)
            )
        }
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun IndicatorScrollableTabRow() {
    val selectedTab = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTab.value,
        indicator = { tabPositions: List<TabPosition> ->
            val modifier = Modifier.tabIndicatorOffset(
                tabPositions[selectedTab.value]
            )
            Box(
                modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    ),
            )
        }
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                selected = selectedTab.value == index,
                onClick = {
                    selectedTab.value = index
                }) {
                Text(
                    text = text,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}