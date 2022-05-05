package model

import org.jetbrains.exposed.sql.Table

object LoadingBays : Table() {
    val bay_id = integer("bay_id")
    val property_id = integer("property_id")
    val truck_level = bool("truck_level")
    val trailer_53 = bool("trailer_53")
    val dock_lock = bool("dock_lock")
    val leveler = bool("leveler")
    override val primaryKey = PrimaryKey(bay_id)
}
