package service

import model.Properties
import model.Property
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import service.DatabaseFactory.dbQuery

class PropertyService {

    suspend fun getAll(): List<Property> = dbQuery {
        Properties.selectAll().map { toProperty(it) }
    }

//    suspend fun getWidget(id: Int): Widget? = dbQuery {
//        Widgets.select {
//            (Widgets.id eq id)
//        }.map { toWidget(it) }
//            .singleOrNull()
//    }

    private fun toProperty(row: ResultRow): Property =
        Property(
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
