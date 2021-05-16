package com.steleot.jetpackcompose.playground.compose.reusable

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.google.accompanist.insets.systemBarsPadding
import com.steleot.jetpackcompose.playground.LocalInAppReviewer
import java.util.*

@Composable
fun DefaultListItem(
    text: String,
    modifier: Modifier = Modifier,
    cardClickAction: () -> Unit = {},
) {
    DefaultListItem(
        AnnotatedString(text.capitalize(Locale.getDefault())), modifier, cardClickAction
    )
}

@Composable
fun DefaultListItem(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    cardClickAction: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable(onClick = cardClickAction)
    ) {
        Text(
            text,
            style = MaterialTheme.typography.body1,
            color = Color.White,
            modifier = modifier.padding(16.dp)
        )
    }
}

object DefaultListItemPreviewParameter : PreviewParameterProvider<String> {
    override val values: Sequence<String>
        get() = sequenceOf("Jetpack Compose Playground")

}

private const val BaseUrl =
    "https://github.com/Vivecstel/Jetpack-Compose-Playground/blob/master/app/" +
            "src/main/java/com/steleot/jetpackcompose/playground/compose/"

@Preview
@Composable
fun DefaultTopAppBar(
    @PreviewParameter(DefaultListItemPreviewParameter::class) title: String,
    showBackArrow: Boolean = false,
    navigateToSearch: (() -> Unit)? = null,
    link: String? = null
) {
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(
                text = title.capitalize(Locale.getDefault()),
                style = MaterialTheme.typography.h6,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (showBackArrow) BackArrow()
        },
        actions = {
            link?.let {
                IconButton(onClick = {
                    context.startActivity(Intent(Intent.ACTION_VIEW).apply {
                        data = "$BaseUrl$link".toUri()
                    })
                }) {
                    Icon(
                        imageVector = Icons.Filled.ExitToApp,
                        contentDescription = "Exit to App",
                        tint = Color.White
                    )
                }
            }
            navigateToSearch?.let {
                IconButton(onClick = it) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            }
        }
    )
}

@Composable
fun BackArrow() {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    IconButton(onClick = {
        backDispatcher?.onBackPressedDispatcher?.onBackPressed()
    }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Arrow",
            tint = Color.White
        )
    }
}

@Composable
fun DefaultScaffold(
    title: String,
    link: String? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    val context = LocalContext.current
    val inAppReviewer = LocalInAppReviewer.current
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultTopAppBar(
                title = title,
                showBackArrow = true,
                link = link,
            )
        },
        content = content,
    )
    LaunchedEffect(Unit) {
        if (context is Activity) inAppReviewer.requestReview(context)
    }
}
