package model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

object Offices : Table() {
    val property_id = integer("property_id")
    val capacity = integer("capacity")
    val kitchen = bool("kitchen").nullable()
    val gym = bool("gym").nullable()
    val parking = bool("parking").nullable()
    val mailservice = bool("mailservice").nullable()
    override val primaryKey = PrimaryKey(property_id)
}

@Serializable
data class Office(
    val propertyId: Int,
    val capacity: Int,
    val kitchen: Boolean?,
    val gym: Boolean?,
    val parking: Boolean?,
    val mailservice: Boolean?,
)
