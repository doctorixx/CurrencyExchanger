package ru.doctorixx.banking

import logging.Logger
import ru.doctorixx.banking.interfaces.CashRegisterInterface
import ru.doctorixx.logging.LoggingLevel

class CashRegister(private val bank: Bank) : CashRegisterInterface {
    private var exchangeRate: Double = bank.exchangeRate
    private var logger = Logger()

    override fun exchangeRubToUsd(amount: Double): Double {
        val amountInUsd = amount / exchangeRate
        if (bank.rubBalance < amount) {
            throw IllegalStateException("Not enough money [RUB]")
        }

        bank.sendRub(amount)
        bank.receiveUsd(amountInUsd)

        exchangeRate = bank.exchangeRate

        logger.log(LoggingLevel.INFO, " $amount RUB exchanged to $amountInUsd USD (with rate $exchangeRate)")

        return amountInUsd

    }

    override fun exchangeUsdToRub(amount: Double): Double {
        val amountInRub = amount * exchangeRate
        if (bank.usdBalance < amount) {
            throw IllegalStateException("Not enough money [RUB]")
        }

        bank.sendUsd(amount)
        bank.receiveRub(amountInRub)

        exchangeRate = bank.exchangeRate

        logger.log(LoggingLevel.INFO, " $amount USD exchanged to $amountInRub RUB (with rate $exchangeRate)")
        return amountInRub

    }
}