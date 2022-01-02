package com.eyedea.pokedex.domain.usecase

import com.eyedea.core.base.BaseUseCase
import com.eyedea.core.model.Result
import com.eyedea.pokedex.domain.entity.PokedexListEntity
import com.eyedea.pokedex.domain.repository.PokedexRepository

class GetPokedexListUseCase (
    val pokedex: PokedexRepository
) : BaseUseCase<Unit, PokedexListEntity>() {
    override val default: PokedexListEntity
        get() = PokedexListEntity.DEFAULT

    override suspend fun build(param: Unit): Result<PokedexListEntity> {
        return pokedex.getPokedexList()
    }


}