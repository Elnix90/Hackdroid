package io.github.elnix90.hackdroid.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import io.github.elnix90.hackdroid.components.widgets.IconButton
import org.jetbrains.compose.web.css.cssRem

val NavHeaderStyle = CssStyle.base {
    Modifier.fillMaxWidth()
}


@Composable
private fun ColorModeButton() {
    var colorMode by ColorMode.currentState
    IconButton(onClick = { colorMode = colorMode.opposite }) {
        if (colorMode.isLight) MoonIcon() else SunIcon()
    }
    Tooltip(ElementTarget.PreviousSibling, "Toggle color mode", placement = PopupPlacement.BottomRight)
}

@Composable
fun NavHeader(modifier: Modifier) {
    Row(NavHeaderStyle.toModifier().then(modifier)) {
        Link("https://ysws.hackclub.com/") {
            // Block display overrides inline display of the <img> tag, so it calculates centering better
            Image("/flag-orpheus-top.svg", "Hackclub logo")
        }

        Spacer()

        Row(
            Modifier.gap(1.5.cssRem),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ColorModeButton()
        }
    }
}
