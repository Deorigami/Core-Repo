package com.byu.id.onboard.domain.entity

data class StatusEntity(
    val code: Int,
    val englishDescription: String,
    val bahasDescription: String,
    val partialMaintenanceContentList: List<PartialMaintenanceContentEntity>,
    val platform: String,
    val status: String,
    val englishTitle: String,
    val bahasaTitle: String
)