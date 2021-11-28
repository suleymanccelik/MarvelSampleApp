package com.suleymancelik.marvelapp.list

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.suleymancelik.marvelapp.data.extension.Result
import com.suleymancelik.marvelapp.data.CharacterListData

data class CharacterListState(
    val characterListState: Async<Result<CharacterListData>> = Uninitialized,
    val characterList: CharacterListData? = null
) : MavericksState