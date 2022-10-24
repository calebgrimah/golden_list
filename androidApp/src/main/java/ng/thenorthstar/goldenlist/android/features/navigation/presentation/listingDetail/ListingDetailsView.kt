package ng.thenorthstar.goldenlist.android.features.navigation.presentation.listingDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import io.github.aakira.napier.Napier
import ng.thenorthstar.goldenlist.android.features.GoldenListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ListingDetailsRoute(onBackClick: () -> Unit, args : String? ,viewModel: GoldenListViewModel = getViewModel()) {
    val mUrl = rememberWebViewState(url = args!!)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val loadingState = mUrl.loadingState
        if (loadingState is LoadingState.Loading) {
            LinearProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier.fillMaxWidth()
            )
        }
        WebView(
            state = mUrl,
            onCreated = { it.settings.javaScriptEnabled = true },
            captureBackPresses = false,
            modifier = Modifier.fillMaxSize()
        )
    }
}
