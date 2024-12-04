package app.loococo.domain.usecase

import app.loococo.domain.model.DustInfo
import app.loococo.domain.model.Resource
import app.loococo.domain.repository.DustRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DustUseCase @Inject constructor(private val dustRepository: DustRepository) {
    suspend operator fun invoke(): Flow<Resource<DustInfo>> {
        return dustRepository.dustInfo()
    }
}