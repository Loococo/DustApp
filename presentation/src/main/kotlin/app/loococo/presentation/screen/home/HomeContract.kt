package app.loococo.presentation.screen.home


data class HomeState(
    val isLoading: Boolean = false,
)

sealed class HomeSideEffect {
}

sealed class HomeEvent {
}