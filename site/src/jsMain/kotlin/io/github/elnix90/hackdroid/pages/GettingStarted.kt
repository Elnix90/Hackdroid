package io.github.elnix90.hackdroid.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import io.github.elnix90.hackdroid.components.layouts.PageLayoutData
import io.github.elnix90.hackdroid.toSitePalette
import io.github.elnix90.hackdroid.utils.copyA
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.*

val GettingStartedStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(3.cssRem)
            .padding(topBottom = 2.cssRem)
    }
}

val StepBoxStyle = CssStyle {
    base {
        Modifier
            .padding(2.4.cssRem)
            .borderRadius(1.2.cssRem)
            .gap(1.2.cssRem)
            .margin(bottom = 2.cssRem)
    }
}

@InitRoute
fun initGettingStartedPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Getting Started"))
}

@Page("getting-started")
@Layout(".components.layouts.PageLayout")
@Composable
fun GettingStartedPage() {
    val sitePalette = ColorMode.current.toSitePalette()

    Column(GettingStartedStyle.toModifier()) {
        // Header
        Div {
            H1(
                Modifier
                    .fontSize(3.5.cssRem)
                    .fontWeight(700)
                    .margin(bottom = 1.5.cssRem)
                    .toAttrs()
            ) {
                Text("Getting Started with Hackdroid")
            }
            P(
                Modifier
                    .fontSize(1.15.cssRem)
                    .opacity(0.85f)
                    .maxWidth(50.cssRem)
                    .lineHeight(1.6f)
                    .toAttrs()
            ) {
                Text(
                    "Follow these steps to begin your Android app development journey. We'll guide you through " +
                            "choosing your tools, setting up your environment, and shipping your first app to F-Droid."
                )
            }
        }

        // Prerequisites
        Div(
            StepBoxStyle
                .toModifier()
                .backgroundColor(sitePalette.nearBackground)
                .toAttrs()
        ) {
            H2(
                Modifier
                    .fontSize(2.2.cssRem)
                    .fontWeight(700)
                    .toAttrs()
            ) {
                Text("Prerequisites")
            }
            P {
                Text("Before you start, make sure you have:")
            }
            Ul {
                Li { Text("A computer with Windows, macOS, or Linux") }
                Li { Text("Basic knowledge of programming concepts") }
                Li { Text("About 5-10 hours to complete your project") }
                Li { Text("An F-Droid developer account (free)") }
            }
        }

        // Step 1: Choose Your Framework
        Div(
            StepBoxStyle
                .toModifier()
                .backgroundColor(sitePalette.brand.primary.copyA(alpha = 0.08f))
                .toAttrs()
        ) {
            H2(
                Modifier
                    .fontSize(2.2.cssRem)
                    .fontWeight(700)
                    .margin(bottom = 1.cssRem)
                    .toAttrs()
            ) {
                SpanText(
                    "1",
                    Modifier
                        .backgroundColor(sitePalette.brand.primary)
                        .color(Colors.White)
                        .padding(0.5.cssRem, 1.cssRem)
                        .borderRadius(0.4.cssRem)
                        .display(DisplayStyle.InlineBlock)
                        .margin(right = 1.cssRem)
                )
                Text("Choose Your Framework")
            }

            H3(
                Modifier
                    .fontSize(1.4.cssRem)
                    .fontWeight(600)
                    .margin(top = 1.5.cssRem, bottom = 0.5.cssRem)
                    .toAttrs()
            ) {
                Text("Recommended: Kotlin + Jetpack Compose")
            }
            Ul {
                Li {
                    Text("Modern, expressive UI framework built by Google")
                }
                Li {
                    Text("Declarative syntax makes UI development intuitive")
                }
                Li {
                    Text("Official support and rich ecosystem")
                }
            }

            H3(
                Modifier
                    .fontSize(1.4.cssRem)
                    .fontWeight(600)
                    .margin(top = 1.5.cssRem, bottom = 0.5.cssRem)
                    .toAttrs()
            ) {
                Text("Or try alternatives:")
            }
            Ul {
                Li { Text("Flutter + Dart – Cross-platform, fast development") }
                Li { Text("React Native – JavaScript, large community") }
                Li { Text("Native Android (Java/XML) – Traditional but powerful") }
            }
        }

        // Step 2: Set Up Your Environment
        Div(
            StepBoxStyle
                .toModifier()
                .backgroundColor(sitePalette.nearBackground)
                .toAttrs()
        ) {
            H2(
                Modifier
                    .fontSize(2.2.cssRem)
                    .fontWeight(700)
                    .margin(bottom = 1.cssRem)
                    .toAttrs()
            ) {
                SpanText(
                    "2",
                    Modifier
                        .backgroundColor(sitePalette.brand.primary)
                        .color(Colors.White)
                        .padding(0.5.cssRem, 1.cssRem)
                        .borderRadius(0.4.cssRem)
                        .display(DisplayStyle.InlineBlock)
                        .margin(right = 1.cssRem)
                )
                Text("Set Up Your Development Environment")
            }

            Ol {
                Li {
                    B { Text("Install Android Studio") }
                    P { Text("Download from developer.android.com/studio") }
                }
                Li {
                    B { Text("Choose your SDK version") }
                    P { Text("Target Android 12 or later for modern features") }
                }
                Li {
                    B { Text("Create an emulator") }
                    P { Text("Or use a physical device via USB debugging") }
                }
                Li {
                    B { Text("Create a new project") }
                    P { Text("Select 'Empty Activity' and choose Kotlin") }
                }
            }
        }

        // Step 3: Learn & Build
        Div(
            StepBoxStyle
                .toModifier()
                .backgroundColor(sitePalette.brand.primary.copyA(alpha = 0.08f))
                .toAttrs()
        ) {
            H2(
                Modifier
                    .fontSize(2.2.cssRem)
                    .fontWeight(700)
                    .margin(bottom = 1.cssRem)
                    .toAttrs()
            ) {
                SpanText(
                    "3",
                    Modifier
                        .backgroundColor(sitePalette.brand.accent)
                        .color(Colors.White)
                        .padding(0.5.cssRem, 1.cssRem)
                        .borderRadius(0.4.cssRem)
                        .display(DisplayStyle.InlineBlock)
                        .margin(right = 1.cssRem)
                )
                Text("Learn & Build Your App")
            }

            P {
                Text("Follow our step-by-step guides:")
            }
            Ul {
                Li { Text("UI Basics with Jetpack Compose") }
                Li { Text("Working with Data & State Management") }
                Li { Text("Connecting to an API (optional, we provide templates)") }
                Li { Text("Storage & Local Data") }
                Li { Text("Testing Your App") }
            }

            Div(
                Modifier
                    .padding(1.5.cssRem)
                    .backgroundColor(sitePalette.nearBackground)
                    .borderRadius(0.8.cssRem)
                    .margin(top = 1.5.cssRem)
                    .toAttrs()
            ) {
                P(Modifier.fontWeight(600).toAttrs()) {
                    Text("💡 Pro Tip: Keep your project small")
                }
                P(Modifier.margin(top = 0.5.cssRem).opacity(0.85f).toAttrs()) {
                    Text(
                        "Focus on one core feature: a note app, todo list, habit tracker, or simple game. " +
                                "This makes development manageable and your app more polished."
                    )
                }
            }
        }

        // Step 4: Package Your App
        Div(
            StepBoxStyle
                .toModifier()
                .backgroundColor(sitePalette.nearBackground)
                .toAttrs()
        ) {
            H2(Modifier.fontSize(2.2.cssRem).fontWeight(700).margin(bottom = 1.cssRem).toAttrs()) {
                SpanText(
                    "4",
                    Modifier
                        .backgroundColor(sitePalette.brand.primary)
                        .color(Colors.White)
                        .padding(0.5.cssRem, 1.cssRem)
                        .borderRadius(0.4.cssRem)
                        .display(DisplayStyle.InlineBlock)
                        .margin(right = 1.cssRem)
                )
                Text("Package Your App")
            }

            P {
                Text("When you're ready to deploy:")
            }
            Ol {
                Li {
                    B { Text("Create a release keystore") }
                    P { Text("Sign your app with your own certificate") }
                }
                Li {
                    B { Text("Generate a release APK/AAB") }
                    P { Text("Build → Generate Signed Bundle/APK") }
                }
                Li {
                    B { Text("Test on multiple devices") }
                    P { Text("Use the Android emulator or real devices") }
                }
                Li {
                    B { Text("Write compelling app metadata") }
                    P { Text("Description, screenshots, category") }
                }
            }
        }

        // Step 5: Deploy to F-Droid
        Div(
            StepBoxStyle
                .toModifier()
                .backgroundColor(sitePalette.brand.primary.copyA(alpha = 0.08f))
                .toAttrs()
        ) {
            H2(Modifier.fontSize(2.2.cssRem).fontWeight(700).margin(bottom = 1.cssRem).toAttrs()) {
                SpanText(
                    "5",
                    Modifier
                        .backgroundColor(sitePalette.brand.accent)
                        .color(Colors.White)
                        .padding(0.5.cssRem, 1.cssRem)
                        .borderRadius(0.4.cssRem)
                        .display(DisplayStyle.InlineBlock)
                        .margin(right = 1.cssRem)
                )
                Text("Deploy to F-Droid")
            }

            P {
                Text("F-Droid is the largest app store for free and open-source Android apps:")
            }
            Ol {
                Li {
                    B { Text("Upload your source code to GitHub") }
                    P { Text("F-Droid builds from source, so your code must be public") }
                }
                Li {
                    B { Text("Create a Metadata file") }
                    P { Text("Describe your app, set version info, and add screenshots") }
                }
                Li {
                    B { Text("Submit to F-Droid") }
                    P { Text("Follow their submission guidelines and wait for review") }
                }
                Li {
                    B { Text("Get published!") }
                    P { Text("Once approved, your app appears in the F-Droid store 🎉") }
                }
            }
        }

        // Next Steps
        Div(
            Modifier
                .padding(2.4.cssRem)
                .backgroundColor(sitePalette.brand.primary)
                .color(Colors.White)
                .borderRadius(1.2.cssRem)
                .textAlign(TextAlign.Center)
                .gap(1.5.cssRem)
                .margin(top = 3.cssRem)
                .toAttrs()
        ) {
            H2(Modifier.fontSize(2.2.cssRem).toAttrs()) {
                Text("Ready to start?")
            }
            P {
                Text("Join our community and begin building. Track your progress with Hakatime and get support from fellow developers.")
            }
            Button(Modifier.padding(1.cssRem, 2.cssRem).fontSize(1.1.cssRem).toAttrs()) {
                Text("Access Guides & Templates")
            }
        }
    }
}