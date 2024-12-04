package app.loococo.data.model

import app.loococo.domain.model.DustInfo
import app.loococo.domain.model.DustItem

data class DustResponse(
    val response: DustApiResponse
)

data class DustApiResponse(
    val header: DustApiHeader,
    val body: DustApiBody
)

data class DustApiHeader(
    val resultMsg: String,
    val resultCode: String
)

data class DustApiBody(
    val totalCount: Int,
    val items: List<DustMeasurement>,
    val pageNo: Int,
    val numOfRows: Int
)

data class DustMeasurement(
    val so2Grade: String?,
    val coFlag: String?,
    val khaiValue: String?,
    val so2Value: String?,
    val coValue: String?,
    val pm10Flag: String?,
    val o3Grade: String?,
    val pm10Value: String?,
    val khaiGrade: String?,
    val sidoName: String?,
    val no2Flag: String?,
    val no2Grade: String?,
    val o3Flag: String?,
    val so2Flag: String?,
    val dataTime: String?,
    val coGrade: String?,
    val no2Value: String?,
    val stationName: String?,
    val pm10Grade: String?,
    val o3Value: String?
)

fun DustResponse.toDustInfo(): DustInfo {
    return DustInfo(
        items = response.body.items.map { it.toDustItem() }
    )
}

fun DustMeasurement.toDustItem(): DustItem {
    return DustItem(
        stationName = stationName,
        pm10Value = pm10Value,
        pm10Grade = pm10Grade
    )
}

