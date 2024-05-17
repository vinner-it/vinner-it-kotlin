import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FastVinBuilderTest {

    @Test
    fun `fastVin should return ValidVin when valid`() {
        val actual = FastVinBuilder.parse("PKHFLA82V45103WHC")
        assertThat(actual).isInstanceOf(Vin::class.java)
    }

    @Test
    fun `fastVin should return InvalidVin when invalid`() {
        val actual = FastVinBuilder.parse("PKHFLA82VBLABLA45103WHC")
        assertThat(actual).isInstanceOf(InvalidVin::class.java)
    }
}