package service

import model.Offices
import model.Properties
import model.Property
import model.Warehouses
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

    // TODO: the ResultRow also contains data from Office or Warehouse, also map that data
    private fun toProperty(row: ResultRow): Property {
        return Property(
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
        )
    }
}
