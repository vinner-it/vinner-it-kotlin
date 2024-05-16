import org.junit.Test
import kotlin.test.assertEquals

class VinBuilderTest {

    @Test
    fun `fastVin should return ValidVin when valid`() {
        assertEquals(ValidVin("PKHFLA82V45103WHC"), VinBuilder.fastVin("PKHFLA82V45103WHC"))
    }

    @Test
    fun `fastVin should return InvalidVin when invalid`() {
        assertEquals(InvalidVin("PKHFLA82VBLABLA45103WHC"), VinBuilder.fastVin("PKHFLA82VBLABLA45103WHC"))
    }
}