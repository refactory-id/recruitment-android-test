package id.refactory.myapplication.data

import id.refactory.myapplication.di.TestComponent
import id.refactory.myapplication.infrastructures.api.UserApi
import id.refactory.myapplication.infrastructures.persistences.api.SummaryApiPersistence
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.*
import javax.inject.Inject

class SummaryPersistenceTest {

    init {
        TestComponent.getComponent().inject(this)
    }

    @Inject lateinit var summaryApiPersistence: SummaryApiPersistence

    @Test
    fun `API queryData should always return SummaryApiQueryResult`() {
        val apiService = mock(UserApi::class.java)
        `when`(apiService.listRepos()).then {
            Observable.create<id.refactory.data.SummaryApiQueryResult> {  }
        }
        val sap =
            SummaryApiPersistence(
                apiService
            )
        Assert.assertSame(true, sap.queryData() is Observable<id.refactory.data.SummaryQueryResult>)
    }

    @Test
    fun `API queryData using RxJava should works properly`() {
        val subscriber = TestObserver<id.refactory.data.SummaryQueryResult>()
        summaryApiPersistence.queryData().subscribe(subscriber)

        subscriber.assertComplete()
    }
}