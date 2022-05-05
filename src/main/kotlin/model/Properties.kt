package model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date
import util.LocalDateSerializer
import java.time.LocalDate

object Properties : Table() {
    val property_id = integer("property_id")
    val name = varchar("name", 255)
    val address = varchar("address", 255)
    val city = varchar("city", 255)
    val province = varchar("province", 255)
    val postal = varchar("postal", 255)
    val access_247 = bool("access_247").nullable()
    val utilities_included = bool("utilities_included").nullable()
    val availability = date("availability").nullable()
    val cost = integer("cost").nullable()
    override val primaryKey = PrimaryKey(property_id)
}

@Serializable
data class Property(
    val propertyId: Int,
    val name: String,
    val address: String,
    val city: String,
    val province: String,
    val postal: String,
    val access247: Boolean?,
    val utilitiesIncluded: Boolean?,
    @Serializable(with = LocalDateSerializer::class)
    val availability: LocalDate?,
    val cost: Int?,
)
