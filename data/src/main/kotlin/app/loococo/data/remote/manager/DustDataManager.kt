package app.loococo.data.remote.manager

import app.loococo.data.model.toDustInfo
import app.loococo.data.remote.api.DustApi
import app.loococo.domain.model.DustInfo
import app.loococo.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DustDataManager @Inject constructor(private val dustApi: DustApi) {

    suspend fun dustInfo(): Flow<Resource<DustInfo>> =
        suspendResponseResultWithBackoff(
            execute = { dustApi.dustInfo("json", "서울", 40) },
            mapResponse = { it.toDustInfo() }
        )
}