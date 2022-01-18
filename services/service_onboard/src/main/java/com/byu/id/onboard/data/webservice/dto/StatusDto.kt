package com.byu.id.onboard.data.webservice.dto

data class StatusDto(
    val code: Int,
    val desc_en: String,
    val desc_id: String,
    val partial_maintenance_content: List<PartialMaintenanceContentDto>,
    val platform: String,
    val status: String,
    val title_en: String,
    val title_id: String
)