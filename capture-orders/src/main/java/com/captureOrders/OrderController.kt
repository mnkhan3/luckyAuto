package com.captureOrders

import com.dataDomain.CarOrderDetails
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/captureOrder")
class OrderController(
   private val orderProcessingService: OrderProcessingService
) {
    @PostMapping
    fun captureOrder(@RequestBody carOrderDetails: CarOrderDetails): String  {
       return orderProcessingService.processOrder(carOrderDetails)
    }
}