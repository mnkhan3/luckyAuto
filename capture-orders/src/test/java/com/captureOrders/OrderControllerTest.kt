package com.captureOrders

import com.dataDomain.BuyerInformation
import com.dataDomain.CarOrderDetails
import com.dataDomain.DealershipInformation
import com.dataDomain.VehicleInformation
import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class OrderControllerTest {

    private var mockOrderProcessingService: OrderProcessingService = mock()

    private lateinit var orderController: OrderController
    private lateinit var mockMvc: MockMvc

    private val objectMapper = ObjectMapper()

    private lateinit var orderDetails: CarOrderDetails

    @BeforeEach
    fun setUp() {
        orderController = OrderController(mockOrderProcessingService)

        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build()

        orderDetails = CarOrderDetails(
            orderId = "id123"
        ).apply {
            buyerInformation = BuyerInformation()
            dealershipInformation = DealershipInformation()
            vehicleInformation = VehicleInformation()
        }
    }

    @Test
    fun `captureOrder invokes orderProcessingService and return orderId`() {
        whenever(mockOrderProcessingService.processOrder(orderDetails)).thenReturn("orderId123")

        mockMvc.perform(post("/captureOrder")
            .contentType(APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(this.orderDetails)))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(content().string("orderId123"))

        verify(mockOrderProcessingService).processOrder(orderDetails)
    }
}