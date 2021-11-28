package com.suleymancelik.marvelapp.list

import com.suleymancelik.marvelapp.core.network.SuspendingWorkInteractor
import com.suleymancelik.marvelapp.data.CharacterListData
import com.suleymancelik.marvelapp.data.extension.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterListWork @Inject constructor(
    private val characterListRepository: CharacterListRepository
) : SuspendingWorkInteractor<CharacterListWork.Params, Result<CharacterListData>>() {
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun doWork(params: Params): Result<CharacterListData> {
        return characterListRepository.fetchCharacterList(params.offset, params.limit)
    }

    data class Params(val offset: Int = 0, val limit: Int = 0)
}