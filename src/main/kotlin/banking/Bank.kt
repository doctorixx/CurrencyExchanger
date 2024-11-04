package ru.doctorixx.banking

import ru.doctorixx.banking.interfaces.BankInterface
import ru.doctorixx.banking.interfaces.CashRegisterInterface

class Bank(_usdBalance: Double, _rubBalance: Double) : BankInterface {
    var rubBalance: Double = _usdBalance
        private set
    var usdBalance: Double = _rubBalance
        private set
    var exchangeRate: Double = 0.0
        private set

    constructor(_usdBalance: Double, _rubBalance: Double, _exchangeRate: Double) : this(_usdBalance, _rubBalance) {
        exchangeRate = _exchangeRate
    }

    override fun sendRub(amount: Double): Double {
        if (amount <= 0) {
            throw IllegalStateException("Amount must be greater than 0")
        }

        val newRubBalance = rubBalance - amount
        if (newRubBalance < 0) {
            throw IllegalStateException("Not enough money [RUB]")
        }

        rubBalance = newRubBalance
        return rubBalance
    }

    override fun sendUsd(amount: Double): Double {
        if (amount <= 0) {
            throw IllegalStateException("Amount must be greater than 0")
        }

        val newUsdBalance = usdBalance - amount
        if (newUsdBalance < 0) {
            throw IllegalStateException("Not enough money [USD]")
        }

        usdBalance = newUsdBalance
        return usdBalance
    }

    override fun receiveRub(amount: Double) {
        if (amount <= 0) {
            throw IllegalStateException("Amount must be greater than 0")
        }

        rubBalance += amount
    }

    override fun receiveUsd(amount: Double) {
        if (amount <= 0) {
            throw IllegalStateException("Amount must be greater than 0")
        }

        usdBalance += amount
    }

    override fun createCashRegister(): CashRegisterInterface {
        return CashRegister(this)
    }
}