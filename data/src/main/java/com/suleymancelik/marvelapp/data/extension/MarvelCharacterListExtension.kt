package com.suleymancelik.marvelapp.data.extension

import com.suleymancelik.marvelapp.data.CharacterListModel

fun CharacterListModel.completeRequest(): ServiceResult<CharacterListModel> =
    if (this.code == 200) {
        SuccessResult(this)
    } else {
        ServerError(ServiceErrorException())
    }