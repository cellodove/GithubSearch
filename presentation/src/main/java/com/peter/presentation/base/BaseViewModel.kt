package com.peter.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

abstract class BaseViewModel : ViewModel() {

    private val _isLoading by lazy { MutableLiveData(false) }
    val isLoading: LiveData<Boolean> by lazy { _isLoading }

    private val _toast by lazy { MutableLiveData<Event<String>>() }
    val toast: LiveData<Event<String>> by lazy { _toast }

    fun handleLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }

    fun showToast(message: String) {
        _toast.postValue(Event(message))
    }
}