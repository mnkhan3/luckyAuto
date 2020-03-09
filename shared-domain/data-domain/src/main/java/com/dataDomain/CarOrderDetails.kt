package com.dataDomain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Clock

@JsonIgnoreProperties(ignoreUnknown = true)
data class CarOrderDetails(val orderId: String) {
    val creationTimestamp: Long = Clock.systemUTC().millis()
    var buyerInformation: BuyerInformation? = null
    var dealershipInformation: DealershipInformation? = null
    var vehicleInformation: VehicleInformation? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class BuyerInformation (
    var firstName: String? = null,
    var lastName: String? = null,
    var streetAddress: String? = null,
    var city: String? = null,
    var state: String? = null,
    var zipCode: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class DealershipInformation (
    var city: String? = null,
    var dealerShipName: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class VehicleInformation (
    var make: String? = null,
    var modal: String? = null,
    var year: String? = null,//Maybe change Type to YEAR....
    var acutalPrice: Number? = null,
    var priceSoldFor: Number? = null,
    var condition: Condition? = null
)

enum class Condition(value: String) {
    NEW("Brend New"), USED("Used"), BROKEN("Broken")
}


