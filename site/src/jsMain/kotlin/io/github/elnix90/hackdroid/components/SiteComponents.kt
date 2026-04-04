package io.github.elnix90.hackdroid.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import io.github.elnix90.hackdroid.pages.FeatureCardStyle
import io.github.elnix90.hackdroid.pages.RewardItemStyle
import io.github.elnix90.hackdroid.toSitePalette
import io.github.elnix90.hackdroid.utils.copyA
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

/**
 * Feature Card Component
 * 
 * Displays a feature with an icon, title, and description
 */
@Composable
fun FeatureCard(
    number: Int,
    icon: String,
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier
) {
    val sitePalette = ColorMode.current.toSitePalette()

    Column(
        modifier
            .gap(1.5.cssRem)
    ) {
        // Numbered icon badge above card
        Box(
            Modifier
                .size(4.cssRem)
                .aspectRatio(1f)
                .backgroundColor(sitePalette.brand.primary)
                .borderRadius(100.percent)
                .display(DisplayStyle.Flex)
                .justifyContent(JustifyContent.Center),
            contentAlignment = Alignment.Center
        ) {
            Div(
                Modifier
                    .fontSize(1.8.cssRem)
                    .fontWeight(700)
                    .toAttrs()
            ) {
                Text(number.toString())
            }
        }

        // THe Card itself
        Column(
            FeatureCardStyle.toModifier()
                .fillMaxHeight()
                .padding(2.4.cssRem)
                .borderRadius(1.2.cssRem)
                .backgroundColor(backgroundColor)
                .gap(1.2.cssRem)
        ) {
            Image(
                icon,
                Modifier
                    .width(3.2.cssRem)
                    .height(3.2.cssRem)
                    .objectFit(ObjectFit.Contain)
            )
            Spacer()
            H3 { Text(title) }
            P { Text(description) }
        }
    }
}

/**
 * Reward Card Component
 *
 * Displays a reward tier with icon, title, amount, and description
 */
@Composable
fun RewardCard(
    icon: String,
    reward: String,
    duration: Int,
    description: String,
    color: Color,
    modifier: Modifier
) {
    val bgColor = color.copyA(0.5f)

    Column(
        modifier
            .then(
                RewardItemStyle.toModifier()
            )
            .border(2.px, LineStyle.Solid, color)
            .backgroundColor(bgColor)
            .gap(1.2.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Column(
            Modifier
                .gap(0.5.cssRem)
        ) {
            P(
                Modifier
                    .fontSize(1.5.cssRem)
                    .fontWeight(600)
                    .toAttrs()
            ) {
                Text(reward)
            }

            P(
                Modifier
                    .fontSize(1.1.cssRem)
                    .fontWeight(800)
                    .toAttrs()
            ) {
                Text("~ $duration hours")
            }
        }

        Image(
            icon,
            Modifier
                .width(6.cssRem)
                .height(6.cssRem)
                .objectFit(ObjectFit.Contain)
        )

        Spacer()

        P(
            Modifier.fontSize(0.95.cssRem).opacity(0.8f).toAttrs()
        ) {
            Text(description)
        }
    }
}

/**
 * Step Card Component
 * 
 * Displays a numbered step in a process/timeline
 */
@Composable
fun StepCard(
    stepNumber: Int,
    title: String,
    description: String
) {
    val sitePalette = ColorMode.current.toSitePalette()

    Row(
        Modifier
            .gap(2.cssRem)
            .alignItems(AlignItems.Start)
            .padding(2.cssRem)
            .backgroundColor(sitePalette.nearBackground)
            .borderRadius(1.2.cssRem)
    ) {
        // Step circle
        Div(
            Modifier
                .size(3.2.cssRem)
                .backgroundColor(sitePalette.brand.primary)
                .borderRadius(50.percent)
                .display(DisplayStyle.Flex)
                .alignItems(AlignItems.Center)
                .justifyContent(JustifyContent.Center)
                .color(Colors.White)
                .fontSize(1.5.cssRem)
                .fontWeight(700)
                .flexShrink(0)
                .toAttrs()
        ) {
            Text(stepNumber.toString())
        }

        Column(Modifier.gap(0.5.cssRem)) {
            H3 { Text(title) }
            P(Modifier.opacity(0.85f).toAttrs()) { Text(description) }
        }
    }
}

/**
 * Section Header Component
 * 
 * Displays a section title with optional description
 */
@Composable
fun SectionHeader(
    title: String,
    description: String? = null
) {
    Column(Modifier.gap(1.2.cssRem)) {
        H2(Modifier.fontSize(3.2.cssRem).fontWeight(700).lineHeight(1.2f).toAttrs()) {
            Text(title)
        }
        if (description != null) {
            P(Modifier.fontSize(1.1.cssRem).lineHeight(1.6f).opacity(0.85f).toAttrs()) {
                Text(description)
            }
        }
    }
}

/**
 * Highlight Box Component
 * 
 * Displays a highlighted point with icon and text
 */
@Composable
fun HighlightBox(
    icon: String,
    text: String
) {
    val sitePalette = ColorMode.current.toSitePalette()

    Row(
        Modifier
            .gap(1.2.cssRem)
            .padding(1.5.cssRem)
            .backgroundColor(sitePalette.nearBackground)
            .borderRadius(0.8.cssRem)
            .alignItems(AlignItems.Center)
    ) {
        Div(Modifier.fontSize(1.5.cssRem).flexShrink(0).toAttrs()) {
            Text(icon)
        }
        P { Text(text) }
    }
}

/**
 * CTA Section Component
 * 
 * Large call-to-action section with title and description
 */
@Composable
fun CTASection(
    title: String,
    description: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    val sitePalette = ColorMode.current.toSitePalette()

    Column(
        Modifier
            .padding(3.5.cssRem)
            .borderRadius(1.6.cssRem)
            .textAlign(TextAlign.Center)
            .gap(2.cssRem)
            .backgroundColor(sitePalette.brand.primary)
            .color(Colors.White)
            .margin(topBottom = 4.cssRem)
    ) {
        H2(Modifier.fontSize(3.2.cssRem).fontWeight(700).toAttrs()) {
            Text(title)
        }
        P(Modifier.fontSize(1.1.cssRem).lineHeight(1.6f).toAttrs()) {
            Text(description)
        }
        Button(
            onClick = { onButtonClick() }
        ) {
            Text(buttonText)
        }
    }
}

// ============================================================================
// Styling utilities
// ============================================================================

//val BadgeStyle = CssStyle.base {
//    Modifier
//        .padding(0.4.cssRem, 0.8.cssRem)
//        .backgroundColor(ColorMode.current.toSitePalette().brand.primary)
//        .color(com.varabyte.kobweb.compose.ui.graphics.Colors.White)
//        .borderRadius(0.4.cssRem)
//        .fontSize(0.85.cssRem)
//        .fontWeight(700)
//}
//
//val CodeBlockStyle = CssStyle.base {
//    Modifier
//        .padding(1.5.cssRem)
//        .borderRadius(0.8.cssRem)
//        .backgroundColor(ColorMode.current.toSitePalette().nearBackground)
//        .fontSize(0.95.cssRem)
//        .overflow(Overflow.Auto)
//        .fontFamily("JetBrains Mono", "Courier New", "monospace")
//}
