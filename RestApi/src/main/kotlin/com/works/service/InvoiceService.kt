package com.works.service

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class InvoiceService {

    @Async
    fun asyncGenerateInvoice(orderId: Long) {
        Thread.sleep(3000)
        println("Async PDF: $orderId")
    }

}