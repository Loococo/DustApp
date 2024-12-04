package app.loococo.domain.model

data class DustInfo(
    val items: List<DustItem>,
)

data class DustItem(
    val stationName: String?,
    val pm10Value: String?,
    val pm10Grade: String?,
) {
    fun getPm10GradeEnum(grade: String?): Pm10GradeEnum {
        return when (grade) {
            "1" -> Pm10GradeEnum.GOOD
            "2" -> Pm10GradeEnum.MODERATE
            "3" -> Pm10GradeEnum.UNHEALTHY
            "4" -> Pm10GradeEnum.VERY_UNHEALTHY
            else -> Pm10GradeEnum.UNKNOWN
        }
    }
}