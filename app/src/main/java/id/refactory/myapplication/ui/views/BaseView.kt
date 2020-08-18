package id.refactory.myapplication.ui.views

interface BaseView<T> {
    fun onPrepare()
    fun onError()
}

interface BasePresenter {
    fun onDestroy()
}