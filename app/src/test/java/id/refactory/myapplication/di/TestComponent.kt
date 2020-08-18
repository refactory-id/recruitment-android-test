package id.refactory.myapplication.di

import dagger.Component
import id.refactory.data.SummaryDataMapper
import id.refactory.myapplication.data.SummaryDataMapperTest
import id.refactory.myapplication.data.SummaryPersistenceTest
import id.refactory.myapplication.infrastructures.di.modules.ApiModule
import id.refactory.myapplication.infrastructures.di.modules.PersistenceModule
import id.refactory.myapplication.infrastructures.persistences.api.SummaryApiPersistence

@Component(modules = [PersistenceModule::class, ApiModule::class])
interface TestComponent {
    fun getDataMapper(): id.refactory.data.SummaryDataMapper
    fun getSummaryApiPersistence(): SummaryApiPersistence

    fun inject(summaryDataMapperTest: SummaryDataMapperTest)
    fun inject(summaryPersistenceTest: SummaryPersistenceTest)

    companion object {
        fun getComponent(): TestComponent {
            return DaggerTestComponent.create()
        }
    }
}