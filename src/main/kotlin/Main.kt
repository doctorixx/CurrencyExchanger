package ru.doctorixx

import ru.doctorixx.banking.Bank


fun main() {
    // Создаем банк с каким-то кол-вом денег
    val bank = Bank(100000.0, 6000.0, 70.0)

    // Создаем кассу
    val cashRegister = bank.createCashRegister()

    // Тестируем обмен рублей на доллары
    val dollars = cashRegister.exchangeRubToUsd(70.0)
    println("Получено долларов: $dollars")

    // Тестируем обмен долларов на рубли
    val rubles = cashRegister.exchangeUsdToRub(2.0)
    println("Получено рублей: $rubles")

    // Проверяем остатки в банке
    println("Остаток рублей в банке: ${bank.rubBalance}")
    println("Остаток долларов в банке: ${bank.usdBalance}")
}
