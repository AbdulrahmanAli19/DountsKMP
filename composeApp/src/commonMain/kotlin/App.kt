import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import features.startup.ui.StartUpScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        StartUpScreen()
    }
}