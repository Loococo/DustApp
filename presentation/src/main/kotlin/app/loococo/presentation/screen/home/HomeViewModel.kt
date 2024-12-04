package app.loococo.presentation.screen.home

import androidx.lifecycle.ViewModel
import app.loococo.domain.model.Resource
import app.loococo.domain.usecase.DustUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: DustUseCase) :
    ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(HomeState()) { loadDustInfo() }


    private fun loadDustInfo() = intent {
        useCase().collectLatest { result ->
            when (result) {
                is Resource.Success -> {
                    reduce { state.copy(isLoading = false, items = result.data.items) }
                }

                is Resource.Error -> {
                    reduce { state.copy(isLoading = false) }
                    postSideEffect(HomeSideEffect.ShowToast(result.error))
                }

                Resource.Loading -> {
                    reduce { state.copy(isLoading = true) }
                }
            }
        }
    }
}