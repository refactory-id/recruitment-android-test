package id.refactory.myapplication.ui.presenters

import id.refactory.domain.User
import id.refactory.myapplication.ui.views.MainView
import id.refactory.usecases.GetUsers
import io.reactivex.observers.DisposableObserver

class MainPresenter (var view: MainView.View?): MainView.Presenter {
    lateinit var getUsers: GetUsers

    override fun onLoadUsers(params: Map<String, String>) {
        getUsers.getUsers(GetUsersObserver(), params)
    }

    override fun onDestroy() {
        view = null
        getUsers.dispose()
    }

    inner class GetUsersObserver: DisposableObserver<List<User>>() {
        override fun onComplete() {}
        override fun onNext(t: List<User>) {
            view?.onSuccessLoadUsers(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }
}