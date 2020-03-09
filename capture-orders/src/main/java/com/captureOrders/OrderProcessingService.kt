package com.captureOrders

import com.dataDomain.CarOrderDetails
import org.springframework.stereotype.Component

@Component
class OrderProcessingService {
    fun processOrder(orderDetails: CarOrderDetails): String {
        return orderDetails.orderId
    }
}