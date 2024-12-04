package app.loococo.domain.repository

import app.loococo.domain.model.DustInfo
import app.loococo.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface DustRepository {
    suspend fun dustInfo():  Flow<Resource<DustInfo>>
}