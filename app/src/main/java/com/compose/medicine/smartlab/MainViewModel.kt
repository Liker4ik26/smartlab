package com.compose.medicine.smartlab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.medicine.smartlab.datastore.repo.DatastoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val datastoreRepo: DatastoreRepo
) : ViewModel() {
    private val _state = MutableStateFlow(MainUiState.Empty)
    val state = _state.asStateFlow()

    private fun showOnboard() {
        viewModelScope.launch {
            datastoreRepo.showOnboard().collect { value ->
                _state.update {
                    it.copy(
                        showOnboard = value
                    )
                }
            }
        }
    }
}