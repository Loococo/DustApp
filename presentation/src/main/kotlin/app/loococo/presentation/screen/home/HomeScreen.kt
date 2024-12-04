package app.loococo.presentation.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.loococo.domain.model.DustItem
import app.loococo.domain.model.Pm10GradeEnum
import app.loococo.presentation.R
import app.loococo.presentation.component.CircularProgressBar
import app.loococo.presentation.component.DustBodyText
import app.loococo.presentation.component.DustLabelText
import app.loococo.presentation.component.DustTitleText
import app.loococo.presentation.component.HeightSpacer
import app.loococo.presentation.theme.Black
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun HomeRoute() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.collectAsState()
    val context = LocalContext.current

    viewModel.collectSideEffect {
        when (it) {
            is HomeSideEffect.ShowToast -> {
                Toast.makeText(context, it.res, Toast.LENGTH_SHORT).show()
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        HomeHeader()
        HeightSpacer(height = 1, backgroundColor = Black)
        HomeList(state.items)
    }
    CircularProgressBar(state.isLoading)
}

@Composable
fun HomeHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), contentAlignment = Alignment.Center
    ) {
        DustTitleText(text = stringResource(R.string.title), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun HomeList(items: List<DustItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(items) {
            HomeListItem(
                item = it,
            )
        }
    }
}

@Composable
fun HomeListItem(item: DustItem) {
    Column(modifier = Modifier.fillMaxWidth()) {
        DustLabelText(text = item.stationName ?: "", fontWeight = FontWeight.Bold)
        DustBodyText(text = stringResource(R.string.pm_value, item.pm10Value ?: ""))
        DustBodyText(
            text = stringResource(
                id = R.string.pm_grade,
                stringResource(getPm10GradeStringRes(item.getPm10GradeEnum(item.pm10Grade)))
            )
        )
    }
}

private fun getPm10GradeStringRes(grade: Pm10GradeEnum): Int {
    return when (grade) {
        Pm10GradeEnum.GOOD -> R.string.pm_grade_good
        Pm10GradeEnum.MODERATE -> R.string.pm_grade_moderate
        Pm10GradeEnum.UNHEALTHY -> R.string.pm_grade_unhealthy
        Pm10GradeEnum.VERY_UNHEALTHY -> R.string.pm_grade_very_unhealthy
        Pm10GradeEnum.UNKNOWN -> R.string.pm_grade_unknown
    }
}
