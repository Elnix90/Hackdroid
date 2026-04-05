package io.github.elnix90.hackdroid.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier

val NavHeaderStyle = CssStyle.base {
    Modifier.fillMaxWidth()
}


@Composable
fun NavHeader(modifier: Modifier) {
    Row(NavHeaderStyle.toModifier().then(modifier)) {
        Link("https://ysws.hackclub.com/") {
            // Block display overrides inline display of the <img> tag, so it calculates centering better
            Image("flag-orpheus-top.svg", "Hackclub logo")
        }
    }
}
