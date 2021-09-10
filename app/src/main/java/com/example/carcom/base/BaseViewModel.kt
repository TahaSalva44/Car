package com.example.carcom.base

import androidx.lifecycle.ViewModel
import com.example.carcom.model.ErrorPopUpMessage
import com.example.carcom.service.INetworkResponseHandling
import com.example.carcom.util.SingleLiveEvent

open class BaseViewModel : ViewModel(), INetworkResponseHandling {
    val errorMessage: SingleLiveEvent<ErrorPopUpMessage> = SingleLiveEvent()

    val loading: SingleLiveEvent<Boolean> = SingleLiveEvent()

    //region interface
    override fun loading(switch: Boolean) {
        loading.postValue(switch)
    }

    override fun onGenericErrorTaken(message: String) {
        errorMessage.postValue(ErrorPopUpMessage("error", message))
    }

    override fun onErrorPopUp(header: String, body: String) {
        errorMessage.postValue(ErrorPopUpMessage(header, body))
    }
    //endregion

}
