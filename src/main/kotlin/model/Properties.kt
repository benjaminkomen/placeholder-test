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
sealed class Property {
    abstract val propertyId: Int
    abstract val name: String
    abstract val address: String
    abstract val city: String
    abstract val province: String
    abstract val postal: String
    abstract val access247: Boolean?
    abstract val utilitiesIncluded: Boolean?

    @Serializable(with = LocalDateSerializer::class)
    abstract val availability: LocalDate?
    abstract val cost: Int?
}
