class carTransactionDetails(val orderId: String) {
    val creationTimestamp: Long = Clock.systemUTC().millis()
    var buyerInformation: BuyerInformation
    var dealershipInformation: DealershipInformation
    var vehicleInformation: VehicleInformation
}

data class BuyerInformation {
    val firstName: String
    val lastName: String
    val streetAddress: String
    val city: String? = null
    val state: String? = null
    val zipCode: String? = null
}

data class DealershipInformation {
    val city: String
    val dealerShipName: String
}

data class VehicleInformation {
    val make: String
    val modal: String
    val year: String//Maybe change Type to YEAR....
    val acutalPrice: Number
    val priceSoldFor: Number
    val condition: Condition? = null
}

enum class Condition {
    NEW("Brend New"), USED("Used"), BROKEN("Broken")
}


