sealed interface Vin

data class ValidVin(val value: String) : Vin

data class InvalidVin(val value: String) : Vin
