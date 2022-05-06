package model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

object Warehouses : Table() {
    val property_id = integer("property_id")
    val square_footage = integer("square_footage")
    val forklifts = bool("forklifts").nullable()
    val parking_trailer = bool("parking_trailer").nullable()
    val fenced_yard = bool("fenced_yard").nullable()
    val power_amps = integer("power_amps").nullable()
    override val primaryKey = PrimaryKey(property_id)
}

@Serializable
data class Warehouse(
    val propertyId: Int,
    val squareFootage: Int,
    val forklifts: Boolean?,
    val parkingTrailer: Boolean?,
    val fencedYard: Boolean?,
    val powerAmps: Int?,
)
