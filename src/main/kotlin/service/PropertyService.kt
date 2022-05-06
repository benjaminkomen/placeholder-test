package service

import model.*
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import service.DatabaseFactory.dbQuery

class PropertyService {

    suspend fun getAll(): List<Property> = dbQuery {
        Properties.selectAll().map { toProperty(it) }
    }

    suspend fun getProperty(propertyId: Int): Property? = dbQuery {
        Properties.join(Offices, JoinType.LEFT, Properties.property_id, Offices.property_id)
            .join(Warehouses, JoinType.LEFT, Properties.property_id, Warehouses.property_id)
            .select {
                (Properties.property_id eq propertyId)
            }.map { toProperty(it) }
            .singleOrNull()
    }

    private fun toProperty(row: ResultRow): Property {
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
            )
        } else {
            TODO()
        }
    }
}
