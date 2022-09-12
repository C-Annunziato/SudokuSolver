package com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.framework.manager.StoragePreferences
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.model.BoardActivityState
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.model.BoardActivityState.LOADED
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.model.BoardState
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.model.BoardActivityState.LOADING
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.model.TimeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SudokuViewModel @Inject constructor(
    private val storagePreferences: StoragePreferences
) : ViewModel() {

    private val scope = viewModelScope
    private val boardState = MutableStateFlow(BoardState(state = LOADING, scope = scope))
    val uiBoardState = boardState.asStateFlow()

    init {

        viewModelScope.launch {
            storagePreferences.solutionSpeed.collectLatest { speed ->
                boardState.update { oldState ->
                    oldState.copy(placementSpeed = speed).also { newState ->
                        newState.isPlacingTile = oldState.isPlacingTile
                    }
                }
            }
        }

    }

    fun loadingCompleted(state: BoardActivityState = LOADED) {
        boardState.update { it.copy(state = state) }
    }

    fun updatePlacementSpeed(value: TimeState) = viewModelScope.launch {
        storagePreferences.updateSolutionSpeed(value)
    }

}
