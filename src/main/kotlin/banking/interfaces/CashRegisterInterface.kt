package ru.doctorixx.banking.interfaces

interface CashRegisterInterface {
    fun exchangeRubToUsd(amount: Double): Double
    fun exchangeUsdToRub(amount: Double): Double
}
