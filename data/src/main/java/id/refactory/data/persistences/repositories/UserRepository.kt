package id.refactory.data.persistences.repositories

import id.refactory.data.payload.contracts.RepositoryInterface
import id.refactory.data.persistences.contracts.UserPersistenceInterface
import id.refactory.data.persistences.mappers.UserDataMapper
import id.refactory.domain.User
import io.reactivex.Observable

class UserRepository(private val persistence: UserPersistenceInterface, private val mapper: UserDataMapper): RepositoryInterface {
    fun getUsers(params: Map<String, String>): Observable<List<User>> {
        return persistence.getUsers(params).map {
            mapper.convertUserList(it)
        }
    }
}