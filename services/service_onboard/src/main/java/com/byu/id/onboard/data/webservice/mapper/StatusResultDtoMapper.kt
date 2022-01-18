package com.byu.id.onboard.data.webservice.mapper

import com.byu.id.onboard.data.webservice.dto.StatusDto
import com.byu.id.onboard.domain.entity.StatusEntity

class StatusResultDtoMapper(
    private val partialMaintenanceContentListMapper : PartialMaintenanceContentListDtoMapper
) {
    operator fun invoke(from : List<StatusDto>) : List<StatusEntity> {
        return if (from.isEmpty()) emptyList()
        else from.map {
            StatusEntity(
                code = it.code,
                englishDescription =  it.desc_en,
                bahasaDescription = it.desc_id,
                platform = it.platform,
                bahasaTitle = it.title_id,
                englishTitle = it.title_en,
                status = it.status,
                partialMaintenanceContentList = partialMaintenanceContentListMapper(it.partial_maintenance_content)
            )
        }
    }
}