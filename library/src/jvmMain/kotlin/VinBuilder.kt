object VinBuilder {

    fun fastVin(s: String): Vin {
        if (s.matches(Regex("^[A-HJ-NPR-Z0-9]{17}$"))) return ValidVin(s)
        else return InvalidVin(s)
    }
}