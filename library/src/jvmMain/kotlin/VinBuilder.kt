object VinBuilder {

    fun fastVin(vin: String): Vin {
        return if (vin.matches(Regex("^[A-HJ-NPR-Z0-9]{17}$"))) ValidVin(vin)
        else InvalidVin(vin)
    }
}