package com.compose.medicine.smartlab.screens.onboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.datastore.repo.DatastoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val datastoreRepo: DatastoreRepo
) : ViewModel() {

    private val _effect = MutableSharedFlow<OnBoardUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: OnBoardUiEvent) {
        when (event) {
            is OnBoardUiEvent.OnNavigateToSignIn -> {
                viewModelScope.launch {
                    _effect.emit(OnBoardUiEffect.NavigateToSignIn)
                    datastoreRepo.changeShowOnboard()
                }
            }
        }
    }
}