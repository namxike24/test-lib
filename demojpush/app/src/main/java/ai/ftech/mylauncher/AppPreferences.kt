package ai.ftech.mylauncher

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import kotlin.reflect.KClass


object AppPreferences {
    private const val TAG = "AppPreferences"

    private lateinit var prefsShared: SharedPreferences

    fun init(application: Application) {
        prefsShared =
            application.getSharedPreferences(application.packageName, Context.MODE_PRIVATE)
    }

    private fun edit(operator: (SharedPreferences.Editor) -> Unit) {
        try {
            val prefsEditor = prefsShared.edit()
            operator(prefsEditor)
            prefsEditor.apply()
        } catch (e: Exception) {

        }
    }

    fun setInt(key: String, value: Int) = edit {
        it.putInt(key, value)
    }

    fun getInt(key: String, defaultValue: Int = 0): Int = prefsShared.getInt(key, defaultValue)

    fun setLong(key: String, value: Long) = edit {
        it.putLong(key, value)
    }

    fun getLong(key: String, defaultValue: Long = 0): Long = prefsShared.getLong(key, defaultValue)

    fun setFloat(key: String, value: Float) = edit {
        it.putFloat(key, value)
    }

    fun getFloat(key: String, defaultValue: Float = 0f): Float =
        prefsShared.getFloat(key, defaultValue)

    fun setBoolean(key: String, value: Boolean) = edit {
        it.putBoolean(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean =
        prefsShared.getBoolean(key, defaultValue)

    fun setString(key: String, value: String?) = edit {
        it.putString(key, value)
    }

    fun getString(key: String, defaultValue: String? = null): String? =
        prefsShared.getString(key, defaultValue)

    fun setValue(key: String, value: Any) {
        when (value) {
            is String -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Long -> edit { it.putLong(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            else -> UnsupportedOperationException("Not yet implemented!!!")
        }
    }

    fun setValueJson(key: String, value: Any) {
        edit { it.putString(key, Gson().toJson(value)) }
    }


    @Suppress("UNCHECKED_CAST")
    fun <T> getValue(key: String, clazz: KClass<*>, defaultValue: T? = null): T? {
        return when (clazz) {
            String::class -> prefsShared.getString(key, defaultValue as? String) as? T?
            Int::class -> prefsShared.getInt(key, defaultValue as? Int ?: -1) as? T?
            Long::class -> prefsShared.getLong(key, defaultValue as? Long ?: -1) as? T?
            Float::class -> prefsShared.getFloat(key, defaultValue as? Float ?: -1f) as? T?
            Boolean::class -> prefsShared.getBoolean(key, defaultValue as? Boolean ?: false) as? T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    fun <T> getValueArrayList(key: String) : ArrayList<T> {
        val json: String? = prefsShared.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<T?>?>() {}.type
        if(json.isNullOrEmpty())
            return arrayListOf()
        return Gson().fromJson(json, type)
    }

    fun clear() = prefsShared.edit().clear().commit()
}