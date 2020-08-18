package id.refactory.data.payload.api.user

import com.google.gson.annotations.SerializedName
import id.refactory.data.payload.contracts.GetUsersResponseInterface

data class Company(val name: String, val catchPhrase: String, val bs: String)
data class Geo(val lat: Float, val lng: Float)
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    @SerializedName("zipcode") val zipCode: String,
    val geo: Geo
)

data class UserResponseData(
    val id: Long,
    val name: String,
    val username: String,
    val address: Address,
    val phone: String,
    val email: String,
    val website: String,
    val company: Company
)

data class GetUsersApiResponse(val data: List<UserResponseData>) : GetUsersResponseInterface