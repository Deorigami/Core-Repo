package com.byu.id.onboard.data.webservice.mapper

import com.byu.id.onboard.data.webservice.dto.PartialMaintenanceContentDto
import com.byu.id.onboard.domain.entity.PartialMaintenanceContentEntity

class PartialMaintenanceContentListDtoMapper {
    operator fun invoke(from : List<PartialMaintenanceContentDto>) : List<PartialMaintenanceContentEntity> {
        return if (from.isEmpty()) emptyList()
        else from.map {
            PartialMaintenanceContentEntity(
                bahasaTitle = it.title_id,
                bahasaDescription = it.desc_id,
                englishTitle = it.title_en,
                englishDescription = it.desc_en,
                image = it.image,
                name = it.name
            )
        }
    }
}