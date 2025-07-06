package myiconpack

import MyIconPack
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.Unit

public val MyIconPack.IcBackground: ImageVector
    get() {
        if (_icBackground != null) {
            return _icBackground!!
        }
        _icBackground = Builder(name = "IcBackground", defaultWidth = 360.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 360.0f, viewportHeight = 640.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(20.0f, 0.0f)
                    lineTo(340.0f, 0.0f)
                    arcTo(20.0f, 20.0f, 0.0f, false, true, 360.0f, 20.0f)
                    lineTo(360.0f, 620.0f)
                    arcTo(20.0f, 20.0f, 0.0f, false, true, 340.0f, 640.0f)
                    lineTo(20.0f, 640.0f)
                    arcTo(20.0f, 20.0f, 0.0f, false, true, 0.0f, 620.0f)
                    lineTo(0.0f, 20.0f)
                    arcTo(20.0f, 20.0f, 0.0f, false, true, 20.0f, 0.0f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFFC123)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(252.01f, 25.73f)
                    curveTo(89.52f, 78.97f, 232.0f, 142.0f, 115.51f, 150.73f)
                    curveTo(35.9f, 156.7f, 26.18f, 244.09f, 28.01f, 298.82f)
                    curveTo(28.64f, 317.79f, 9.11f, 332.98f, -8.43f, 325.73f)
                    lineTo(-122.81f, 278.49f)
                    curveTo(-135.06f, 273.43f, -140.89f, 259.4f, -135.83f, 247.15f)
                    lineTo(-16.7f, -41.28f)
                    curveTo(-12.76f, -50.83f, -3.22f, -56.78f, 7.08f, -55.94f)
                    curveTo(84.9f, -49.64f, 394.64f, -21.0f, 252.01f, 25.73f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFFF4D6)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(202.61f, 26.82f)
                    curveTo(66.5f, 75.99f, 183.86f, 128.13f, 86.82f, 137.82f)
                    curveTo(22.57f, 144.24f, 11.49f, 215.79f, 11.33f, 263.42f)
                    curveTo(11.27f, 282.11f, -8.03f, 296.71f, -25.31f, 289.58f)
                    lineTo(-109.82f, 254.68f)
                    curveTo(-122.07f, 249.62f, -127.9f, 235.58f, -122.84f, 223.33f)
                    lineTo(-20.36f, -24.8f)
                    curveTo(-16.48f, -34.2f, -7.23f, -40.13f, 2.92f, -39.48f)
                    curveTo(71.43f, -35.09f, 320.58f, -15.79f, 202.61f, 26.82f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFFC123)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(-44.49f, 95.56f)
                    lineTo(92.24f, 12.46f)
                    arcTo(24.0f, 24.0f, 102.25f, false, true, 125.21f, 20.51f)
                    lineTo(152.75f, 65.82f)
                    arcTo(24.0f, 24.0f, 108.98f, false, true, 144.7f, 98.79f)
                    lineTo(7.97f, 181.89f)
                    arcTo(24.0f, 24.0f, 127.05f, false, true, -25.0f, 173.84f)
                    lineTo(-52.54f, 128.54f)
                    arcTo(24.0f, 24.0f, 94.98f, false, true, -44.49f, 95.56f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFFC123)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(-44.49f, -1.44f)
                    lineTo(92.24f, -84.54f)
                    arcTo(24.0f, 24.0f, 52.47f, false, true, 125.21f, -76.49f)
                    lineTo(152.75f, -31.18f)
                    arcTo(24.0f, 24.0f, 107.54f, false, true, 144.7f, 1.79f)
                    lineTo(7.97f, 84.89f)
                    arcTo(24.0f, 24.0f, 82.15f, false, true, -25.0f, 76.84f)
                    lineTo(-52.54f, 31.54f)
                    arcTo(24.0f, 24.0f, 102.54f, false, true, -44.49f, -1.44f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFFFC123)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(236.51f, 585.56f)
                    lineTo(373.24f, 502.46f)
                    arcTo(24.0f, 24.0f, 86.81f, false, true, 406.21f, 510.51f)
                    lineTo(433.75f, 555.82f)
                    arcTo(24.0f, 24.0f, 103.66f, false, true, 425.7f, 588.79f)
                    lineTo(288.97f, 671.89f)
                    arcTo(24.0f, 24.0f, 130.77f, false, true, 256.0f, 663.84f)
                    lineTo(228.46f, 618.54f)
                    arcTo(24.0f, 24.0f, 99.51f, false, true, 236.51f, 585.56f)
                    close()
                }
            }
        }
        .build()
        return _icBackground!!
    }

private var _icBackground: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = MyIconPack.IcBackground, contentDescription = "")
    }
}
