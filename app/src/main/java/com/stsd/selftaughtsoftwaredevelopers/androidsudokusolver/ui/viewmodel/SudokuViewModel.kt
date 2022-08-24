package com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.framework.manager.SudokuSolverWorker
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.model.BoardState
import com.stsd.selftaughtsoftwaredevelopers.androidsudokusolver.ui.model.TileState.Companion.EMPTY_TILE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SudokuViewModel @Inject constructor(
    private val worker: SudokuSolverWorker
) : ViewModel() {

    private val _sudokuBoardStateAlt = MutableStateFlow(BoardState())
    val sudokuBoardStateAlt : StateFlow<BoardState> = _sudokuBoardStateAlt.asStateFlow()

    fun updateSelectedPosition(
        newPosition: Pair<Int, Int>
    ) = _sudokuBoardStateAlt.value.selectPosition(newPosition)

    /**
     * Call this function when a numbered button is clicked.
     */
    fun enterNewValue(
        newValue: String
    ) = _sudokuBoardStateAlt.value.changeValue(newValue)

    fun undoLast() = _sudokuBoardStateAlt.value.undoLast()
    fun clearBoard() = _sudokuBoardStateAlt.value.clearBoard()

    fun solveBoard() = viewModelScope.launch(Dispatchers.Default) {

//        _sudokuBoardStateAlt.update { board ->
//
//            val solved = CompletableDeferred<BoardState>().apply {
//                worker.solveBoard(board.convertFromUiBoard())
//                    .also { deferred ->
//                        complete(deferred)
//                    }
//            }.await()
//
//            return@update solved
//
//        }

    }

}