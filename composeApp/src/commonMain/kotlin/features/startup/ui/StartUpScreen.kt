package features.startup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import features.startup.ui.uimodel.StartUpUiModel
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.start_up_dounts
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppColors

@OptIn(ExperimentalResourceApi::class)
@Composable
fun StartUpScreen(
    uiModel: StartUpUiModel = StartUpUiModel(),
    onClick: () -> Unit = {},
) {

    val localDensity = LocalDensity.current

    var topPadding by remember {
        mutableStateOf(0.dp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.startUpScreenColor)
    ) {
        Image(
            painter = painterResource(Res.drawable.start_up_dounts),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    topPadding = with(localDensity) { (coordinates.size.height - 300).toDp() }
                },
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(top = topPadding)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            MainTitle(
                text = uiModel.mainTitle,
                modifier = Modifier.padding(horizontal = 25.dp)
            )
            Text(
                text = uiModel.description,
                modifier = Modifier.padding(start = 18.dp, end = 55.dp),
                style = TextStyle.Default.copy(
                    color = AppColors.decraptionTextColor,
                    fontSize = 18.sp
                )
            )
            GetStartButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                onClick = onClick
            )
        }
    }

}

@Composable
private fun MainTitle(
    text: String,
    modifier: Modifier
) {
    Box(modifier = modifier) {
        Text(
            text = text,
            style = TextStyle.Default.copy(
                fontSize = 54.sp,
                fontWeight = FontWeight.Bold,
                drawStyle = Stroke(
                    miter = 10f,
                    width = 4f,
                    join = StrokeJoin.Round
                ),
                shadow = Shadow(
                    offset = Offset(8f, 8f),
                    blurRadius = 6f,
                    color = Color.LightGray
                ),
            )
        )
        Text(
            text = text,
            style = TextStyle.Default.copy(
                fontSize = 54.sp,
                color = AppColors.mainTitleColor,
                fontWeight = FontWeight.Bold,
            )
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GetStartButton(
    text: String = "Get Started",
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(bottom = 18.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = TextStyle.Default.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(vertical = 18.dp)
        )
    }
}

@Preview
@Composable
fun StartUpScreenPreviw() {
    StartUpScreen()
}