object FastVinBuilder {

    fun parse(vin: String): BaseVin {
        return if (vin.matches(Regex("^[A-HJ-NPR-Z0-9]{17}$"))) Vin(vin)
        else InvalidVin(vin, "does not match expected format")
    }
}