package service

import model.*
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import service.DatabaseFactory.dbQuery

class PropertyService {

    suspend fun getAll(): List<Property> = emptyList() // Not implemented, outside of scope

    suspend fun getProperty(propertyId: Int): Property? = dbQuery {
        Properties.join(Offices, JoinType.LEFT, Properties.property_id, Offices.property_id)
            .join(Warehouses, JoinType.LEFT, Properties.property_id, Warehouses.property_id)
            .select {
                (Properties.property_id eq propertyId)
            }.map { toProperty(it) }
            .singleOrNull()
    }

    private suspend fun toProperty(row: ResultRow): Property {
        if (row[Warehouses.square_footage] != null) {
            return Warehouse(
                propertyId = row[Properties.property_id],
                name = row[Properties.name],
                address = row[Properties.address],
                city = row[Properties.city],
                province = row[Properties.province],
                postal = row[Properties.postal],
                access247 = row[Properties.access_247],
                utilitiesIncluded = row[Properties.utilities_included],
                availability = row[Properties.availability],
                cost = row[Properties.cost],
                squareFootage = row[Warehouses.square_footage],
                forklifts = row[Warehouses.forklifts],
                parkingTrailer = row[Warehouses.parking_trailer],
                fencedYard = row[Warehouses.fenced_yard],
                powerAmps = row[Warehouses.power_amps],
                loadingBays = getLoadingBays(row[Properties.property_id])
            )
        } else if (row[Offices.capacity] != null) {
            return Office(
                propertyId = row[Properties.property_id],
                name = row[Properties.name],
                address = row[Properties.address],
                city = row[Properties.city],
                province = row[Properties.province],
                postal = row[Properties.postal],
                access247 = row[Properties.access_247],
                utilitiesIncluded = row[Properties.utilities_included],
                availability = row[Properties.availability],
                cost = row[Properties.cost],
                capacity = row[Offices.capacity],
                kitchen = row[Offices.kitchen],
                gym = row[Offices.gym],
                parking = row[Offices.parking],
                mailservice = row[Offices.mailservice],
                meetingRooms = getMeetingRooms(row[Properties.property_id]),
            )
        } else {
            throw IllegalStateException("Property must either be a Warehouse or Office")
        }
    }

    private suspend fun getLoadingBays(propertyId: Int): List<LoadingBay> {
        return dbQuery {
            LoadingBays.select {
                (LoadingBays.property_id eq propertyId)
            }.map { toLoadingBay(it) }
        }
    }

    private fun toLoadingBay(row: ResultRow): LoadingBay {
        return LoadingBay(
            bayId = row[LoadingBays.bay_id],
            propertyId = row[LoadingBays.property_id],
            truckLevel = row[LoadingBays.truck_level],
            trailer53 = row[LoadingBays.trailer_53],
            dockLock = row[LoadingBays.dock_lock],
            leveler = row[LoadingBays.leveler],
        )
    }

    private suspend fun getMeetingRooms(propertyId: Int): List<MeetingRoom> {
        return dbQuery {
            MeetingRooms.select {
                (MeetingRooms.property_id eq propertyId)
            }.map { toMeetingRoom(it) }
        }
    }

    private fun toMeetingRoom(row: ResultRow): MeetingRoom {
        return MeetingRoom(
            roomId = row[MeetingRooms.room_id],
            propertyId = row[MeetingRooms.property_id],
            capacity = row[MeetingRooms.capacity],
            squareFootage = row[MeetingRooms.square_footage],
            avEquipment = row[MeetingRooms.av_equipment],
            exclusive = row[MeetingRooms.exclusive],
        )
    }
}
