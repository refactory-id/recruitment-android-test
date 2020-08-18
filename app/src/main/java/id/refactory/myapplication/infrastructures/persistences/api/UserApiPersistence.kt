package id.refactory.myapplication.infrastructures.persistences.api

import id.refactory.data.payload.api.user.GetUsersApiResponse
import id.refactory.data.persistences.contracts.UserPersistenceInterface
import id.refactory.myapplication.infrastructures.api.UserApi
import io.reactivex.Observable

// get from api
class UserApiPersistence(private var userApi: UserApi): UserPersistenceInterface {
    override fun getUsers(params: Map<String, String>): Observable<GetUsersApiResponse> {
        return userApi.getUsers(params)
    }
}