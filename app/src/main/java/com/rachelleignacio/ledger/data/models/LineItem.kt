package com.rachelleignacio.ledger.data.models

sealed class LineItem {
    data class Daily(val dailyLineItem: DailyLineItem = DailyLineItem()) : LineItem()

    data class Package(val packageLineItem: PackageLineItem = PackageLineItem()) : LineItem()

    data class Invoice(val invoice: InvoiceDetail = InvoiceDetail()) : LineItem()
}

