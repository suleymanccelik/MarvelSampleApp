package com.suleymancelik.marvelapp.list

import com.airbnb.mvrx.Fail
import com.suleymancelik.marvelapp.core.di.MvRxViewModel
import com.suleymancelik.marvelapp.core.di.viewmodel.AssistedViewModelFactory
import com.suleymancelik.marvelapp.core.di.viewmodel.DaggerMvRxViewModelFactory
import com.suleymancelik.marvelapp.core.network.launchObserve
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CharacterListViewModel @AssistedInject constructor(
    @Assisted state: CharacterListState,
    private val characterListWork: CharacterListWork
) : MvRxViewModel<CharacterListState>(state) {

    init {
        fetchCharacterList()
    }

    fun fetchCharacterList() {
        viewModelScope.launch {
            val job = async(characterListWork.dispatcher) {
                characterListWork(CharacterListWork.Params(0, 30))
            }
            job.await()
        }

        viewModelScope.launchObserve(characterListWork) {
            it.execute { result ->
                try {
                    val serviceList = result.invoke()?.getOrThrow()
                    if (serviceList != null) {
                        copy(characterListState = result, characterList = serviceList)
                    } else {
                        copy(characterListState = result)
                    }
                } catch (t: Throwable) {
                    copy(characterListState = Fail(t))
                }
            }
        }
    }


    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CharacterListViewModel, CharacterListState> {
        override fun create(state: CharacterListState): CharacterListViewModel
    }

    companion object :
        DaggerMvRxViewModelFactory<CharacterListViewModel, CharacterListState>(
            CharacterListViewModel::class.java
        )
}
