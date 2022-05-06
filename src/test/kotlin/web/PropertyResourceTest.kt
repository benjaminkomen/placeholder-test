package web

import common.ServerTest
import io.restassured.RestAssured.*
import model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class PropertyResourceTest: ServerTest() {

    @Test
    fun `should get office property successfully`() {
        val someProperty = get("/properties/1")
            .then()
            .statusCode(200)
            .extract().to<Property>()

        assertNotNull(someProperty)
        assertEquals(1, someProperty.propertyId)
        assertEquals("Ikea", someProperty.name)
    }

    @Test
    fun `should get warehouse property successfully`() {
        val someProperty = get("/properties/2")
            .then()
            .statusCode(200)
            .extract().to<Property>()

        assertNotNull(someProperty)
        assertEquals(2, someProperty.propertyId)
        assertEquals("Walmart", someProperty.name)
    }

    @Test
    fun `should not find non-existing property`() {
        get("/properties/3")
            .then()
            .statusCode(404)
    }

}