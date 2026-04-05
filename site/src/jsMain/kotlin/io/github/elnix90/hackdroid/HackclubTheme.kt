package io.github.elnix90.hackdroid

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color

/**
 * Site palette using Hack Club branding
 * @property nearBackground A useful color to apply to a container that should differentiate itself from the background
 *   but just a little.
 * @property brand Hack Club brand colors
 */
class SitePalette(
    val nearBackground: Color,
    val brand: Brand,
) {
    class Brand(
        // Hack Club primary red
        val primary: Color = Color.rgb(0xEC3750),
        // Hack Club accent blue
        val accent: Color = Color.rgb(0x338eda),
    )
}

/**
 * Hack Club color palette
 *
 * Primary colors from Hack Club brand guide:
 * - Red: #EC3750 (primary call-to-action)
 * - Blue: #338eda (accent, secondary CTAs)
 * - Orange: #ff8c37
 * - Yellow: #f1c40f
 * - Green: #33d6a6
 * - Cyan: #5bc0de
 * - Purple: #a633d6
 * - Muted: #8492a6
 */
object SitePalettes {
    val dark = SitePalette(
        // Dark background for dark mode
        nearBackground = Color.rgb(0x1a1d23),
        brand = SitePalette.Brand(
            primary = Color.rgb(0xFF4757),  // Slightly brighter red for dark mode
            accent = Color.rgb(0x4ba3ff),   // Slightly brighter blue for dark mode
        )
    )
}

fun ColorMode.toSitePalette() = SitePalettes.dark

@InitSilk
fun initHackClubTheme(ctx: InitSilkContext) {
    // Light mode: clean white background with dark text
    ctx.theme.palettes.light.background = Color.rgb(0x0d0f14)
    ctx.theme.palettes.light.color = Color.rgb(0xf0f1f3)

    // Dark mode: dark background with light text
    ctx.theme.palettes.dark.background = Color.rgb(0x0d0f14)
    ctx.theme.palettes.dark.color = Color.rgb(0xf0f1f3)
}