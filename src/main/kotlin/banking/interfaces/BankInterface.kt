package ru.doctorixx.banking.interfaces

interface BankInterface {
    fun sendRub(amount: Double): Double
    fun sendUsd(amount: Double): Double
    fun receiveRub(amount: Double)
    fun receiveUsd(amount: Double)
    fun createCashRegister(): CashRegisterInterface
}
