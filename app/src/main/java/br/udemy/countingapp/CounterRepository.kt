package br.udemy.countingapp

class CounterRepository {
    private var _counter = CounterModel(0)

    fun getCounter() = _counter.count

    fun incrementBy2() {
        _counter.count++
        _counter.count++
    }

    fun decrementUntil0() {
        if (_counter.count > 0) {
            _counter.count--
        }
    }
}