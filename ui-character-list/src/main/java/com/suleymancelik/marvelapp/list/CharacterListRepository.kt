package com.suleymancelik.marvelapp.list

import com.suleymancelik.marvelapp.core.network.NetworkHelper
import com.suleymancelik.marvelapp.data.CharacterListData
import com.suleymancelik.marvelapp.data.MarvelAPI
import com.suleymancelik.marvelapp.data.extension.*
import retrofit2.Retrofit
import javax.inject.Inject

class CharacterListRepository @Inject constructor() {

    @Inject
    lateinit var mApiClient: Retrofit

    @Inject
    lateinit var mNetworkHelper: NetworkHelper

    suspend fun fetchCharacterList(offset: Int, limit: Int): Result<CharacterListData> =
        try {
            if (mNetworkHelper.isNetworkConnected()) {
                val service: MarvelAPI = mApiClient.create(MarvelAPI::class.java)
                val serviceCall = service.fetchAllCharacters(offset, limit)
                when (val resultOfService = serviceCall.executeForResult()) {
                    is Success -> {
                        when (resultOfService.data.completeRequest()) {
                            is SuccessResult -> {
                                Success(resultOfService.data.characterListData)
                            }
                            is LoginFail -> {
                                ErrorResult(LoginException())
                            }
                            is EmptyResult -> {
                                ErrorResult(EmptyListException())
                            }
                            else -> {
                                ErrorResult(ServiceErrorException())
                            }
                        }
                    }
                    is ErrorResult -> {
                        ErrorResult(ServiceErrorException())
                    }
                }
            } else {
                ErrorResult(NetworkErrorException())
            }
        } catch (e: Exception) {
            ErrorResult(ServiceErrorException())
        }
}

