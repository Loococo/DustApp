package app.loococo.presentation.screen.home

import app.loococo.domain.model.DustItem


data class HomeState(
    val isLoading: Boolean = false,
    val items: List<DustItem> = emptyList()
)

sealed class HomeSideEffect {
    data class ShowToast(val res: String) : HomeSideEffect()
}