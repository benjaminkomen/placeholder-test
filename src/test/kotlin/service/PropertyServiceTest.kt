package service

import common.ServerTest
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PropertyServiceTest : ServerTest() {

    private val propertyService = PropertyService()

    @Test
    fun `should get warehouse property`() = runTest {
        val property = propertyService.getProperty(1)

        assertNotNull(property)
        val resultAsJson = Json.encodeToString(property)

        val expectedResult = """{"type":"model.Warehouse","propertyId":1,"name":"Ikea","address":"102 Main Street","city":"Vancouver","province":"British Columbia","postal":"101 ABA","access247":null,"utilitiesIncluded":true,"availability":"2022-05-05","cost":null,"squareFootage":3500,"forklifts":false,"parkingTrailer":false,"fencedYard":true,"powerAmps":null,"loadingBays":[{"bayId":11,"propertyId":1,"truckLevel":true,"trailer53":true,"dockLock":true,"leveler":true},{"bayId":12,"propertyId":1,"truckLevel":false,"trailer53":false,"dockLock":false,"leveler":false}]}
        """.trimIndent()
        assertEquals(expectedResult, resultAsJson)
    }

    @Test
    fun `should get office property`() = runTest {
        val property = propertyService.getProperty(2)

        assertNotNull(property)
        val resultAsJson = Json.encodeToString(property)

        val expectedResult = """{"type":"model.Office","propertyId":2,"name":"Walmart","address":"991 Fraser Street","city":"Victoria","province":"British Columbia","postal":"991 ZZZ","access247":null,"utilitiesIncluded":false,"availability":"2022-09-01","cost":null,"capacity":999,"kitchen":true,"gym":false,"parking":true,"mailservice":null,"meetingRooms":[{"roomId":21,"propertyId":2,"capacity":5,"squareFootage":88,"avEquipment":false,"exclusive":true},{"roomId":22,"propertyId":2,"capacity":30,"squareFootage":999,"avEquipment":true,"exclusive":false}]}
        """.trimIndent()
        assertEquals(expectedResult, resultAsJson)
    }

    @Nested
    inner class ErrorCases {

        @Test
        fun `should not get invalid property`() = runTest {
            assertThat(propertyService.getProperty(-1)).isNull()
        }
    }
}