sealed interface BaseVin

data class Vin internal constructor(val value: String) : BaseVin

data class InvalidVin internal constructor(val value: String, val message: String) : BaseVin
