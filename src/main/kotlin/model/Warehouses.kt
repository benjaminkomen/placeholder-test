package model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import util.LocalDateSerializer
import java.time.LocalDate

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
    val squareFootage: Int,
    val forklifts: Boolean?,
    val parkingTrailer: Boolean?,
    val fencedYard: Boolean?,
    val powerAmps: Int?,
    val loadingBays: List<LoadingBay> = emptyList(),
) : Property()
