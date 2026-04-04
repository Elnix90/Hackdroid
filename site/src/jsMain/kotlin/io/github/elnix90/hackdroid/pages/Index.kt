package io.github.elnix90.hackdroid.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.ColorPalettes
import io.github.elnix90.hackdroid.Constants
import io.github.elnix90.hackdroid.components.layouts.PageLayoutData
import io.github.elnix90.hackdroid.toSitePalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.dom.*

val HeroContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(3.cssRem)
            .padding(top = 4.cssRem, bottom = 6.cssRem)
            .position(Position.Relative)
    }
}

val HeroContentStyle = CssStyle {
    base {
        Modifier
            .maxWidth(45.cssRem)
            .gap(1.5.cssRem)
    }
}

val HeroTitleStyle = CssStyle {
    base {
        Modifier
            .fontSize(4.5.cssRem)
            .fontWeight(900)
            .lineHeight(1.1)
            .fontFamily("JetBrains Mono")
            .textDecorationLine(TextDecorationLine.Underline)
            .textAlign(TextAlign.Start)
    }
    Breakpoint.SM {
        Modifier.fontSize(2.8.cssRem)
    }
}

val HeroSubtitleStyle = CssStyle {
    base {
        Modifier
            .fontSize(3.cssRem)
            .lineHeight(1.4)
            .textAlign(TextAlign.Start)
    }
}

val HeroDescStyle = CssStyle {
    base {
        Modifier
            .fontSize(1.1.cssRem)
            .lineHeight(1.6)
            .maxWidth(50.cssRem)
            .opacity(0.85)
    }
}

val HeroDescStyleSpecial = CssStyle {
    base {
        Modifier
            .fontWeight(FontWeight.Bold)
    }
}

val HeroCTAStyle = CssStyle {
    base {
        Modifier
            .gap(1.2.cssRem)
            .flexWrap(FlexWrap.Wrap)
    }
    Breakpoint.SM {
        Modifier.gap(0.8.cssRem)
    }
}

val FeaturesGridStyle = CssStyle {
    base {
        Modifier
            .gap(2.cssRem)
            .margin(topBottom = 4.cssRem)
    }
}

val FeatureCardStyle = CssStyle {
    base {
        Modifier
            .padding(2.4.cssRem)
            .borderRadius(1.2.cssRem)
            .gap(1.2.cssRem)
            .cursor(Cursor.Pointer)
            .position(Position.Relative)
            .overflow(Overflow.Hidden)
    }

    hover {
        Modifier.transform { scale(1.05) }
    }
}

val FeatureIconStyle = CssStyle {
    base {
        Modifier
            .fontSize(3.2.cssRem)
            .lineHeight(1)
    }
}

val FeatureTextStyle = CssStyle {
    base {
        Modifier.gap(0.8.cssRem)
    }
}

val SectionHeaderStyle = CssStyle {
    base {
        Modifier
            .gap(1.2.cssRem)
            .margin(bottom = 3.5.cssRem)
            .textAlign(TextAlign.Start)
    }
}

val SectionTitleStyle = CssStyle {
    base {
        Modifier
            .fontSize(3.2.cssRem)
            .fontWeight(700)
            .lineHeight(1.2)
    }
    Breakpoint.SM {
        Modifier.fontSize(2.2.cssRem)
    }
}

val RewardsContainerStyle = CssStyle {
    base {
        Modifier
            .gap(2.5.cssRem)
            .margin(topBottom = 4.cssRem)
    }
}

val RewardItemStyle = CssStyle {
    base {
        Modifier
            .padding(2.2.cssRem)
            .borderRadius(1.2.cssRem)
            .border(2.px, LineStyle.Solid)
            .gap(1.2.cssRem)
    }
    hover {
        Modifier.transform { scale(1.05) }
    }
}

val CTASectionStyle = CssStyle {
    base {
        Modifier
            .padding(3.5.cssRem)
            .borderRadius(1.6.cssRem)
            .textAlign(TextAlign.Center)
            .gap(2.cssRem)
            .margin(topBottom = 4.cssRem)
    }
}

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Hackdroid"))
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    val ctx = rememberPageContext()
    val sitePalette = ColorMode.current.toSitePalette()

    Column(
        Modifier
            .fillMaxWidth()
            .gap(0.5.cssRem)
    ) {

        Row(HeroContainerStyle.toModifier()) {
            Column(HeroContentStyle.toModifier()) {
                H1(HeroTitleStyle.toAttrs()) {
                    Text(Constants.SITE_NAME)
                }

                // Subtitle/Tagline
                Div(
                    HeroSubtitleStyle
                        .toModifier()
                        .color(sitePalette.brand.primary)
                        .toAttrs()
                ) {
                    SpanText("Build a useful ")
                    Link("https://f-droid.org/") {
                        SpanText("Android", HeroDescStyleSpecial.toModifier())
                    }
                    SpanText(" app and deploy it on ")
                    Link("https://f-droid.org/") {
                        SpanText("F-Droid", HeroDescStyleSpecial.toModifier().whiteSpace(WhiteSpace.NoWrap))
                    }
                    SpanText(" to get rewards!")
                }

                // Description
                P(HeroDescStyle.toAttrs()) {
                    Text(
                        "Learn to build complete Android apps using modern development tools. " +
                                "Combine polished UI with app logic, deploy to F-Droid, and earn rewards " +
                                "while promoting free and open-source software."
                    )
                }

                Row(HeroCTAStyle.toModifier()) {
                    Button(
                        onClick = { ctx.router.tryRoutingTo("/getting-started") },
                        colorPalette = ColorPalettes.Red
                    ) {
                        Text("Get Started")
                    }
                }
            }

            // Decorative grid (only on desktop)
            Div(
                Modifier
                    .displayIfAtLeast(Breakpoint.MD)
                    .width(20.cssRem)
                    .height(20.cssRem)
                    .gap(0.4.cssRem)
                    .toAttrs()
            ) {
                Link("https://f-droid.org/") {
                    Image("/ugly-fdroid.png")
                }
            }
        }

        Div(Modifier.gap(3.cssRem).fillMaxWidth().toAttrs()) {
            Div(SectionHeaderStyle.toAttrs()) {
                H2(SectionTitleStyle.toAttrs()) {
                    Text("What You'll Learn")
                }
                P(HeroDescStyle.toAttrs()) {
                    Text(
                        "Hackdroid guides you through every step of app development, " +
                                "from choosing your framework to deploying on F-Droid."
                    )
                }
            }

            Row(
                FeaturesGridStyle.toModifier()
                    .gap(2.cssRem)
            ) {
                val features = listOf(
                    Triple(
                        "📚",
                        "Step-by-Step Guides",
                        "Learn Kotlin + Jetpack Compose or your framework of choice with clear, practical tutorials"
                    ),
                    Triple(
                        "⚙️",
                        "Backend Templates",
                        "Use pre-built API templates and example services so you focus on UI and logic"
                    ),
                    Triple(
                        "📦",
                        "Deploy to F-Droid",
                        "Complete walkthroughs on packaging your app (.apk/.aab) and publishing to F-Droid"
                    ),
                )

                features.forEach { (icon, title, desc) ->
                    Column(
                        FeatureCardStyle.toModifier()
                            .backgroundColor(sitePalette.nearBackground)
                            .flex(1)
                            .minWidth(16.cssRem)
                    ) {
                        Div(FeatureIconStyle.toAttrs()) {
                            Text(icon)
                        }
                        Column(FeatureTextStyle.toModifier()) {
                            H3 { Text(title) }
                            P { Text(desc) }
                        }
                    }
                }
            }
        }


        Div(Modifier.gap(3.cssRem).fillMaxWidth().toAttrs()) {
            Div(SectionHeaderStyle.toAttrs()) {
                H2(SectionTitleStyle.toAttrs()) {
                    Text("Why Hackdroid?")
                }
            }

            Column(Modifier.gap(1.5.cssRem)) {
                val reasons = listOf(
                    "Real-world skills using modern frameworks like Jetpack Compose",
                    "Deploy actual software that people use – get it published on F-Droid",
                    "Time-tracked progression with Hakatime – prove your impact",
                    "Keep projects small and focused (under 5 hours) – discover Android dev",
                    "Join a community of student developers building FOSS",
                )

                reasons.forEach { reason ->
                    Row(
                        Modifier
                            .gap(1.2.cssRem)
                            .padding(1.5.cssRem)
                            .backgroundColor(sitePalette.nearBackground)
                            .borderRadius(0.8.cssRem)
                            .alignItems(AlignItems.Center)
                    ) {
                        Div(
                            Modifier
                                .fontSize(1.5.cssRem)
                                .flexShrink(0)
                                .toAttrs()
                        ) {
                            Text("✨")
                        }
                        P { Text(reason) }
                    }
                }
            }
        }


        Div(Modifier.gap(3.cssRem).fillMaxWidth().toAttrs()) {
            Div(SectionHeaderStyle.toAttrs()) {
                H2(SectionTitleStyle.toAttrs()) {
                    Text("Earn Rewards")
                }
                P(HeroDescStyle.toAttrs()) {
                    Text("Complete challenges and get rewarded for your hard work")
                }
            }

            Column(RewardsContainerStyle.toModifier()) {
                // F-Droid Published Reward
                Column(
                    RewardItemStyle.toModifier()
                        .border(2.px, LineStyle.Solid, sitePalette.brand.primary)
                        .backgroundColor(
                            Color.rgb(0xEC3750).copyf(alpha = 0.08f)
                        )
                ) {
                    Row(Modifier.gap(1.5.cssRem).alignItems(AlignItems.Center)) {
                        Div(Modifier.fontSize(2.8.cssRem).toAttrs()) { Text("🎁") }
                        Column(Modifier.gap(0.5.cssRem)) {
                            H3 { Text("Published to F-Droid") }
                            P { Text("$50 phone grant (10 hours)") }
                        }
                    }
                    P(Modifier.fontSize(0.95.cssRem).opacity(0.8f).toAttrs()) {
                        Text("Successfully publish your app to F-Droid and earn a $50 grant towards a new device")
                    }
                }

                // Play Store Reward
                Column(
                    RewardItemStyle.toModifier()
                        .border(2.px, LineStyle.Solid, Color.rgb(0x338eda))
                        .backgroundColor(Color.rgb(0x338eda).copyf(alpha = 0.08f))
                ) {
                    Row(Modifier.gap(1.5.cssRem).alignItems(AlignItems.Center)) {
                        Div(Modifier.fontSize(2.8.cssRem).toAttrs()) { Text("📱") }
                        Column(Modifier.gap(0.5.cssRem)) {
                            H3 { Text("Publish to Google Play") }
                            P { Text("$25 Google Play license (5 hours)") }
                        }
                    }
                    P(Modifier.fontSize(0.95.cssRem).opacity(0.8f).toAttrs()) {
                        Text("Not accepted to F-Droid yet? Publish on Google Play and get a $25 license grant to help cover the developer account fee")
                    }
                }

                // VPS Grant
                Column(
                    RewardItemStyle.toModifier()
                        .border(2.px, LineStyle.Solid, Color.rgb(0x33d6a6))
                        .backgroundColor(Color.rgb(0x33d6a6).copyf(alpha = 0.08f))
                ) {
                    Row(Modifier.gap(1.5.cssRem).alignItems(AlignItems.Center)) {
                        Div(Modifier.fontSize(2.8.cssRem).toAttrs()) { Text("🖥️") }
                        Column(Modifier.gap(0.5.cssRem)) {
                            H3 { Text("VPS Grant (Optional)") }
                            P { Text("$10 cumulative VPS grant for backend servers") }
                        }
                    }
                    P(Modifier.fontSize(0.95.cssRem).opacity(0.8f).toAttrs()) {
                        Text("Building an app that needs a backend? Get help covering hosting costs with our VPS grant")
                    }
                }
            }
        }


        Div(Modifier.gap(3.cssRem).fillMaxWidth().toAttrs()) {
            Div(SectionHeaderStyle.toAttrs()) {
                H2(SectionTitleStyle.toAttrs()) {
                    Text("How It Works")
                }
            }

            Column(Modifier.gap(2.cssRem)) {
                val steps = listOf(
                    "Learn" to "Follow our guides and choose your framework (Kotlin + Jetpack Compose or alternatives)",
                    "Build" to "Use backend templates and focus on creating a small, polished app",
                    "Deploy" to "Package your app and submit it to F-Droid with our step-by-step guide",
                    "Track" to "Use Hakatime to log your hours and document your progress",
                    "Earn" to "Get rewarded based on your achievement level",
                )

                steps.forEachIndexed { idx, (step, desc) ->
                    Row(
                        Modifier
                            .gap(2.cssRem)
                            .alignItems(AlignItems.Start)
                            .padding(2.cssRem)
                            .backgroundColor(sitePalette.nearBackground)
                            .borderRadius(1.2.cssRem)
                    ) {
                        // Step number circle
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
                            Text((idx + 1).toString())
                        }
                        Column(Modifier.gap(0.5.cssRem)) {
                            H3 { Text(step) }
                            P(Modifier.opacity(0.85f).toAttrs()) { Text(desc) }
                        }
                    }
                }
            }
        }


        Column(
            CTASectionStyle.toModifier()
                .backgroundColor(sitePalette.brand.primary)
                .color(Colors.White)
        ) {
            H2(SectionTitleStyle.toAttrs()) {
                Text("Ready to build your first app?")
            }
            P(HeroDescStyle.toAttrs()) {
                Text("Join Hackdroid and start your journey as a student developer")
            }
            Row(HeroCTAStyle.toModifier().justifyContent(JustifyContent.Center)) {
                Button(
                    onClick = { ctx.router.tryRoutingTo("/getting-started") },
                    colorPalette = ColorPalettes.Yellow
                ) {
                    Text("Get Started Now")
                }
            }
        }
    }
}