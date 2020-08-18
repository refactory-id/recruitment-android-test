package id.refactory.data.persistences.contracts

import id.refactory.data.payload.contracts.GetUsersResponseInterface
import io.reactivex.Observable

interface UserPersistenceInterface {
    fun getUsers(params: Map<String, String>): Observable<GetUsersResponseInterface>
}