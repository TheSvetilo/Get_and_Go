package com.vbogd.getandgo.data

import com.vbogd.getandgo.domain.model.Order
import com.vbogd.getandgo.domain.model.OrderStatus

class OrderData {

    var orders = listOf<Order>()

    init {
        orders = makeTestData()
    }

    private fun makeTestData(): List<Order> {
        return listOf(
            Order(
                id = 1,
                number = "№56785928333456",
                status = OrderStatus.BOOKING_READY,
                shortDescription = "Личные вещи",
                comment = "Везите быстрее",
                price = 116.22,
                weight = 20,
                addressFrom = "Московский пр., д.33, корп.7, кв.21",
                addressTo = "Ленинградский пр., д.33, корп.7, кв.24",
                deliveryDate = "20/06",
                deliveryTimeFrom = "18:00",
                deliveryTimeTo = "22:00",
                contactPerson = "Владислав Богданов"
            ),
            Order(
                id = 2,
                number = "№34565928333456",
                status = OrderStatus.BOOKING_READY,
                shortDescription = "Мебель",
                comment = "Злая собака",
                price = 200.0,
                weight = 12,
                addressFrom = "Московский пр., д.33, корп.7, кв.21",
                addressTo = "Ленинградский пр., д.33, корп.7, кв.24",
                deliveryDate = "15/06",
                deliveryTimeFrom = "12:00",
                deliveryTimeTo = "13:00",
                contactPerson = "Владислав Богданов"
            ),
            Order(
                id = 3,
                number = "№85565928333456",
                status = OrderStatus.BOOKING_READY,
                shortDescription = "Хлам",
                comment = "Слепые",
                price = 1200.90,
                weight = 3,
                addressFrom = "Московский пр., д.33, корп.7, кв.21",
                addressTo = "Ленинградский пр., д.33, корп.7, кв.24",
                deliveryDate = "11/07",
                deliveryTimeFrom = "11:00",
                deliveryTimeTo = "19:00",
                contactPerson = "Владислав Богданов"
            ),
            Order(
                id = 4,
                number = "№79283928333456",
                status = OrderStatus.BOOKING_READY,
                shortDescription = "Документы",
                comment = "Только ночью",
                price = 1200.90,
                weight = 3,
                addressFrom = "Московский пр., д.33, корп.7, кв.21",
                addressTo = "Ленинградский пр., д.33, корп.7, кв.24",
                deliveryDate = "19/04",
                deliveryTimeFrom = "02:00",
                deliveryTimeTo = "04:00",
                contactPerson = "Владислав Богданов"
            )
        )
    }
}