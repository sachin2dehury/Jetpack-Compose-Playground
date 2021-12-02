package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/ComposeRichTextUiMaterialScreen.kt"

@Composable
fun ComposeRichTextUiMaterialScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.ComposeRichTextUiMaterial,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BasicRichTextExample()
        }
    }
}

@Composable
private fun BasicRichTextExample() {
    /*MaterialRichText(modifier = Modifier.padding(16.dp)) {
        Heading(0, stringResource(id = R.string.paragraphs))
        Text(stringResource(id = R.string.simple_paragraph))
        Text(stringResource(id = R.string.paragraph_multiple_lines))
        Text(stringResource(id = R.string.paragraph_long_text))
        Heading(0, stringResource(id = R.string.horizontal_line))
        Text(stringResource(id = R.string.paragraph_long_text))
        Text(stringResource(id = R.string.above_line))
        HorizontalRule()
        Text(stringResource(id = R.string.below_line))

        Heading(0, stringResource(id = R.string.code_block))
        CodeBlock(
            """
      {
        "Hello": "world!"
      }
    """.trimIndent()
        )
        Heading(0, stringResource(id = R.string.block_quote))
        BlockQuote {
            Text(stringResource(id = R.string.quoted_paragraphs))
            Text(stringResource(id = R.string.more_text))
            BlockQuote {
                Text(stringResource(id = R.string.nester_block_quote))
            }
        }
        Heading(0, stringResource(id = R.string.table))
        Table(headerRow = {
            cell { Text(stringResource(id = R.string.column_args, 1)) }
            cell { Text(stringResource(id = R.string.column_args, 2)) }
        }) {
            row {
                cell { Text(stringResource(id = R.string.hello)) }
                cell {
                    CodeBlock(stringResource(id = R.string.app_name))
                }
            }
            row {
                cell {
                    BlockQuote {
                        Text(stringResource(id = R.string.stuff))
                    }
                }
                cell { Text(stringResource(id = R.string.hello_word_wrap)) }
            }
        }
    }*/
}