package id.refactory.data.persistences.mappers

import id.refactory.data.payload.api.user.GetUsersApiResponse
import id.refactory.data.payload.contracts.GetUsersResponseInterface
import id.refactory.domain.User

class UserDataMapper {

    fun convertUserList(result: GetUsersResponseInterface?): List<User> {
        val response = mutableListOf<User>()

        if (result is GetUsersApiResponse) {
            result.data.forEach {
                response.add(
                    User(null, it.name, it.phone)
                )
            }
        }
        return response
    }
}