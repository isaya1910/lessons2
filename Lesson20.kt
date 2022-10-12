// 1. Наследование вариаций
open class BaseAirPort {
    open fun onAirplaneArrived() {
        println("base airport")
    }
}

open class MilitaryAirPort: BaseAirPort() {
    override fun onAirplaneArrived() {
        println("military airport")
    }
}

// Наследование с конкретизацией
abstract class Fragment {
    abstract fun onCreateView(view: View)
}

class NewsFragment {
    override fun onCreateView(view: View) {
      println("realization")
    }
}

// Структурное наследование

interface DialogView {
    fun showDialog()
}

interface ProgressView {
    fun showProgressView()
}

interface NewsView: DialogView, ProgressView

class NewsFragment: NewsView {
    override fun showDialog() {
    }

    override fun showProgressView() {
    }

}
