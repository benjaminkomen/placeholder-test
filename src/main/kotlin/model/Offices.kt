package model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import util.LocalDateSerializer
import java.time.LocalDate

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
    override val propertyId: Int,
    override val name: String,
    override val address: String,
    override val city: String,
    override val province: String,
    override val postal: String,
    override val access247: Boolean?,
    override val utilitiesIncluded: Boolean?,
    @Serializable(with = LocalDateSerializer::class)
    override val availability: LocalDate?,
    override val cost: Int?,
    val capacity: Int,
    val kitchen: Boolean?,
    val gym: Boolean?,
    val parking: Boolean?,
    val mailservice: Boolean?,
    val meetingRooms: List<MeetingRoom> = emptyList(),
) : Property()
