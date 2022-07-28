package misha.petshelter.services.localStorage

import android.content.Context
import com.google.gson.Gson
import misha.petshelter.models.UserTokens
import misha.petshelter.ui.theme.TOKENS_NAME
import misha.petshelter.ui.theme.USER_PREFERENCES_NAME
import javax.inject.Inject

class SharedPreferencesStorage @Inject constructor(
    context: Context,
) : UserStorage {
    private val converter = Gson()
    private val storage = context.getSharedPreferences(USER_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveTokens(tokens: UserTokens) {
        storage.edit()
            .putString(TOKENS_NAME, converter.toJson(tokens))
            .apply()
    }

    override fun getTokens(): UserTokens? {
        return when(storage.getString(TOKENS_NAME, null)) {
            null -> null
            else -> converter.fromJson(storage.getString(TOKENS_NAME, null), UserTokens::class.java)
        }
    }
}