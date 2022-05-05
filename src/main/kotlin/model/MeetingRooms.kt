package model

import org.jetbrains.exposed.sql.Table

object MeetingRooms : Table() {
    val room_id = integer("room_id")
    val property_id = integer("property_id")
    val capacity = integer("capacity")
    val square_footage = integer("square_footage")
    val av_equipment = bool("av_equipment")
    val exclusive = bool("exclusive")
    override val primaryKey = PrimaryKey(room_id)
}
