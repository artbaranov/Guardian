package artembaranov.guardian.databaseModule.converters

import androidx.room.TypeConverter
import artembaranov.guardian.entities.ObjectOfInfluence
import artembaranov.guardian.entities.ThreatConsequence
import artembaranov.guardian.entities.ThreatSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Artem Baranov on 21.04.2023.
 */

class ThreatConverter {
    @TypeConverter
    fun fromThreatSources(value: List<ThreatSource>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ThreatSource>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toThreatSources(value: String): List<ThreatSource> {
        val gson = Gson()
        val type = object : TypeToken<List<ThreatSource>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromObjectsOfInfluence(value: List<ObjectOfInfluence>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ObjectOfInfluence>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toObjectsOfInfluence(value: String): List<ObjectOfInfluence> {
        val gson = Gson()
        val type = object : TypeToken<List<ObjectOfInfluence>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromThreatConsequences(value: List<ThreatConsequence>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ThreatConsequence>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toThreatConsequences(value: String): List<ThreatConsequence> {
        val gson = Gson()
        val type = object : TypeToken<List<ThreatConsequence>>() {}.type
        return gson.fromJson(value, type)
    }
}