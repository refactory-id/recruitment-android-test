package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.myapplication.infrastructures.api.UserApi
import id.refactory.myapplication.infrastructures.persistences.api.UserApiPersistence

@Module
class PersistenceModule {
    @Provides
    fun provideUserApiPersistence(service: UserApi): UserApiPersistence {
        return UserApiPersistence(service)
    }
}