package app.loococo.data.repository

import app.loococo.data.remote.manager.DustDataManager
import app.loococo.domain.model.DustInfo
import app.loococo.domain.model.Resource
import app.loococo.domain.repository.DustRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DustRepositoryImpl @Inject constructor(
    private val dustDataManager: DustDataManager
) : DustRepository {
    override suspend fun dustInfo(): Flow<Resource<DustInfo>> {
        return dustDataManager.dustInfo()
    }
}