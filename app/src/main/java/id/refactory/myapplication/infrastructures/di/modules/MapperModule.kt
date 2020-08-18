package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.data.persistences.mappers.UserDataMapper

@Module
class MapperModule {
    @Provides
    fun provideUserDataMapper(): UserDataMapper {
        return UserDataMapper()
    }
}