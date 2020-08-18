package id.refactory.myapplication.infrastructures.di.components

import dagger.Component
import id.refactory.myapplication.infrastructures.di.modules.*
import id.refactory.myapplication.ui.presenters.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidModule::class,
    ApiModule::class,
    MapperModule::class,
    PersistenceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)

    companion object {
        fun getComponent(): AppComponent {
            return DaggerAppComponent.create()
        }
    }
}