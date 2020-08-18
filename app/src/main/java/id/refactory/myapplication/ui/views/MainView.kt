package id.refactory.myapplication.ui.views

import id.refactory.domain.User

interface MainView {
    interface View: BaseView<Presenter> {
        fun onSuccessLoadUsers(users: List<User>)
    }

    interface Presenter: BasePresenter {
        fun onLoadUsers(params: Map<String, String>)
    }
}