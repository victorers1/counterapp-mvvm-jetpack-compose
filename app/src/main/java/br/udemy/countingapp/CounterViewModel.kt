package br.udemy.countingapp

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _repository: CounterRepository = CounterRepository()
    private val _countRepository: MutableIntState = mutableIntStateOf(_repository.getCounter())

    fun getCount(): Int = _countRepository.intValue

    fun increment() {
        _repository.incrementBy2()
        _countRepository.intValue = _repository.getCounter()
    }

    fun decrement() {
        _repository.decrementUntil0()
        _countRepository.intValue = _repository.getCounter()
    }
}