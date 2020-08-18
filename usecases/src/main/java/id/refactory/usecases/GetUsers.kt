package id.refactory.usecases

import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.domain.User
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class GetUsers(private var repository: UserRepository,
                private var compositeDisposable: CompositeDisposable,
                private var observerScheduler: Scheduler) {
    fun getUsers(observer: DisposableObserver<List<User>>, params: Map<String, String>) {
         val observable = repository.getUsers(params)
            .subscribeOn(Schedulers.newThread())
            .observeOn(observerScheduler)

        compositeDisposable.add(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose();
        }
    }
}