package com.suleymancelik.marvelapp.list.ui

import androidx.paging.PageKeyedDataSource
import com.suleymancelik.marvelapp.data.CharacterListResult

class CharacterDataSource(private val characterList: List<CharacterListResult>) :
    PageKeyedDataSource<Int, CharacterListResult>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharacterListResult>
    ) {
        callback.onResult(characterList, 1, 2)
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, CharacterListResult>
    ) {
        callback.onResult(characterList, params.key + 1)
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, CharacterListResult>
    ) {
        val nextIndex = if (params.key > 1) params.key - 1 else null
        callback.onResult(characterList, nextIndex)
    }
}