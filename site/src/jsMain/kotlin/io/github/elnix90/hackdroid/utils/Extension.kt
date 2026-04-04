package io.github.elnix90.hackdroid.utils

import com.varabyte.kobweb.compose.ui.graphics.Color


fun Color.copyA(alpha: Float): Color {
    val initial = this.toRgb()
    return Color.rgba(initial.red, initial.blue, initial.green, alpha)
}