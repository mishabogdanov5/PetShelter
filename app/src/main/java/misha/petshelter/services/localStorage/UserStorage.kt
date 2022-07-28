package misha.petshelter.services.localStorage

import misha.petshelter.models.UserTokens

interface UserStorage {
    fun saveTokens(tokens: UserTokens)

    fun getTokens(): UserTokens?
}