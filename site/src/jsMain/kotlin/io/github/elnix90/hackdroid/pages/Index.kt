package io.github.elnix90.hackdroid.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Transition
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
import io.github.elnix90.hackdroid.components.FeatureCard
import io.github.elnix90.hackdroid.components.RewardCard
import io.github.elnix90.hackdroid.components.layouts.PageLayoutData
import io.github.elnix90.hackdroid.toSitePalette
import io.github.elnix90.hackdroid.utils.hackclubIcon
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
            .minWidth(16.cssRem)
            .transition(
                Transition.of("all", 200.ms)
            )

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
            .transition(
                Transition.of("all", 200.ms)
            )
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

                Row(HeroCTAStyle.toModifier()) {
                    Button(
                        onClick = {/* ctx.router.tryRoutingTo("/getting-started")*/ },
                        colorPalette = ColorPalettes.Red
                    ) {
                        Text("Get Started")
                    }
                }
            }

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

            Row(
                FeaturesGridStyle.toModifier()
                    .gap(2.cssRem)
                    .alignItems(AlignItems.Stretch)
            ) {
                val features = listOf(
                    Triple(
                        "list-checked".hackclubIcon,
                        "Setup your environment basics",
                        "Install Android Studio or Intellij IDEA to start developing "
                    ),
                    Triple(
                        "settings".hackclubIcon,
                        "Build your app",
                        "Learn Kotlin + Jetpack Compose to build your incredible idea"
                    ),
                    Triple(
                        "badge-check".hackclubIcon,
                        "Deploy to F-Droid",
                        "Submit your app to F-Droid reviewers and pray it is accepted! We'll help you for this step"
                    ),
                )


                features.forEachIndexed { index, (icon, title, desc) ->
                    FeatureCard(
                        number = index + 1,
                        icon = icon,
                        title = title,
                        description = desc,
                        backgroundColor = sitePalette.nearBackground,
                        modifier = Modifier.flex(1)
                    )
                }
            }
        }



        Div(Modifier.gap(3.cssRem).fillMaxWidth().toAttrs()) {
            H2(SectionTitleStyle.toAttrs()) {
                Text("Earn Rewards")
            }


            Row(
                RewardsContainerStyle.toModifier()
                    .fillMaxWidth()
                    .alignItems(AlignItems.Stretch)
            ) {
                RewardCard(
                    icon = "/vps.png",
                    reward = "$10 VPS grant for backend servers",
                    duration = 5,
                    description = "Building an app that needs a backend? Get help covering hosting costs with our VPS grant",
                    color = Color.rgb(0x33d6a6),
                    modifier = Modifier.flex(1)
                )
                RewardCard(
                    icon = "/google-play.png",
                    reward = "$25 Google Play license",
                    duration = 10,
                    description = "Not accepted to F-Droid yet? Publish on Google Play and get a $25 license grant to help cover the developer account fee",
                    color = Color.rgb(0x338eda),
                    modifier = Modifier.flex(1)
                )
                RewardCard(
                    icon = "/graphene-phone.png",
                    reward = "$50 phone grant",
                    duration = 20,
                    description = "Successfully publish your app to F-Droid and earn a $50 grant towards a new device",
                    color = Color.rgb(0xEC3750),
                    modifier = Modifier.flex(1)
                )
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
                Text("Join #Hackdroid on Slack and start your journey into Android dev!")
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