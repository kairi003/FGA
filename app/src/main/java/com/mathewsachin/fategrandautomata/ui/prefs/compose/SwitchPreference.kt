package com.mathewsachin.fategrandautomata.ui.prefs.compose

import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.mathewsachin.fategrandautomata.prefs.core.Pref

@Composable
fun Pref<Boolean>.SwitchPreference(
    title: String,
    summary: String = "",
    singleLineTitle: Boolean = true,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    hint: String = ""
) {
    val onClicked: (Boolean) -> Unit = { set(it) }
    val state by asFlow().collectAsState(defaultValue)

    Preference(
        title = title,
        summary = summary,
        singleLineTitle = singleLineTitle,
        icon = icon,
        enabled = enabled,
        onClick = { onClicked(!state) },
        hint = hint
    ) { modifier ->

        // Not using Switch for now due to a weird error on Activity recreation
//        Switch(
//            checked = state,
//            onCheckedChange = { onClicked(it) },
//            enabled = enabled,
//            modifier = modifier
//        )

        Checkbox(
            checked = state,
            onCheckedChange = { onClicked(it) },
            enabled = enabled,
            modifier = modifier
        )
    }
}