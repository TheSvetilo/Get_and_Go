package com.vbogd.getandgo.data

import com.vbogd.getandgo.domain.model.Address
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
                comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                price = 116.22,
                weight = 20.3,
                height = 0.5,
                width = 1.1,
                length = 2.2,
                addressFrom = Address(
                    id = 1,
                    city = "г. Санкт - Петербург",
                    street = "Московский пр.",
                    homeNumber = "33",
                    floor = 6,
                    flatNumber = 33,
                    longitude = "60.05967680955991",
                    latitude = "30.334754426123975"
                ),
                addressTo = Address(
                    id = 2,
                    city = "г. Санкт - Петербург",
                    street = "Елагин остров",
                    homeNumber = "4",
                    floor = 1,
                    flatNumber = 32,
                    longitude = "30.283287744957498",
                    latitude = "59.97947861580965"
                ),
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
                weight = 12.2,
                height = 0.5,
                width = 1.1,
                length = 2.2,
                addressFrom = Address(
                    id = 3,
                    city = "г. Пушкин",
                    street = "Московский пр.",
                    homeNumber = "33",
                    floor = 6,
                    flatNumber = 33,
                    longitude = "60.05967680955991",
                    latitude = "30.334754426123975"
                ),
                addressTo = Address(
                    id = 4,
                    city = "г. Санкт - Петербург",
                    street = "Ленинский пр.",
                    homeNumber = "22",
                    floor = 1,
                    flatNumber = 32,
                    longitude = "30.3006042081831",
                    latitude = "60.00557237785357"
                ),
                deliveryDate = "15/06",
                deliveryTimeFrom = "12:00",
                deliveryTimeTo = "13:00",
                contactPerson = "Владислав Богданов"
            ),
            Order(
                id = 3,
                number = "№85565928333456",
                status = OrderStatus.RESERVED,
                shortDescription = "Хлам",
                comment = "Слепые",
                price = 1200.90,
                weight = 3.1,
                height = 0.5,
                width = 1.1,
                length = 2.2,
                addressFrom = Address(
                    id = 5,
                    city = "г. Москва",
                    street = "Московский пр.",
                    homeNumber = "1",
                    floor = 6,
                    flatNumber = 33,
                    longitude = "60.05967680955991",
                    latitude = "30.334754426123975"
                ),
                addressTo = Address(
                    id = 6,
                    city = "г. Санкт - Петербург",
                    street = "Коломяжский пр.",
                    homeNumber = "17",
                    floor = 1,
                    flatNumber = 32,
                    longitude = "30.3006042081831",
                    latitude = "60.00557237785357"
                ),
                deliveryDate = "11/07",
                deliveryTimeFrom = "11:00",
                deliveryTimeTo = "19:00",
                contactPerson = "Владислав Богданов"
            ),
            Order(
                id = 4,
                number = "№79283928333456",
                status = OrderStatus.DELIVERY,
                shortDescription = "Документы",
                comment = "Только ночью",
                price = 400.00,
                weight = 54.9,
                height = 0.5,
                width = 1.1,
                length = 2.2,
                addressFrom = Address(
                    id = 7,
                    city = "г. Санкт - Петербург",
                    street = "Московский пр.",
                    homeNumber = "33",
                    floor = 6,
                    flatNumber = 33,
                    longitude = "60.05967680955991",
                    latitude = "30.334754426123975"
                ),
                addressTo = Address(
                    id = 8,
                    city = "г. Санкт - Петербург",
                    street = "ул. Льва Толстого",
                    homeNumber = "122",
                    floor = 1,
                    flatNumber = 332,
                    longitude = "30.31272992467957",
                    latitude = "59.96538752680515"
                ),
                deliveryDate = "19/04",
                deliveryTimeFrom = "02:00",
                deliveryTimeTo = "04:00",
                contactPerson = "Владислав Богданов"
            ),
            Order(
                id = 5,
                number = "№79283928333456",
                status = OrderStatus.DELIVERY,
                shortDescription = "Рассол",
                comment = "Только летом",
                price = 400.00,
                weight = 54.9,
                height = 0.5,
                width = 1.1,
                length = 2.2,
                addressFrom = Address(
                    id = 9,
                    city = "г. Санкт - Петербург",
                    street = "Московский пр.",
                    homeNumber = "33",
                    floor = 6,
                    flatNumber = 33,
                    longitude = "60.05967680955991",
                    latitude = "30.334754426123975"
                ),
                addressTo = Address(
                    id = 10,
                    city = "г. Санкт - Петербург",
                    street = "Пулковское шоссе",
                    homeNumber = "122",
                    floor = 1,
                    flatNumber = 2,
                    longitude = "30.31821350128469",
                    latitude = "59.819289641095125"
                ),
                deliveryDate = "19/04",
                deliveryTimeFrom = "02:00",
                deliveryTimeTo = "04:00",
                contactPerson = "Владислав Богданов"
            )
        )
    }
}