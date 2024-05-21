package org.my.ATMCore.Utils;

import io.qameta.allure.Step;
import org.my.ATMCore.AbstractATM;
import org.my.ATMCore.DepositAndWithdrawATM;
import org.my.ATMCore.DepositOnlyATM;
import org.my.ATMCore.NominalSlot;

import java.util.HashMap;
import java.util.List;

public class StandartSteps {

    @Step ("Создание банкомата")
    public static AbstractATM getATM(ATMType atmType, List<NominalSlot> slots, int banknoteCapacity) {
        AbstractATM atm = switch (atmType) {
            case DEPOSIT_ONLY -> new DepositOnlyATM(slots, banknoteCapacity);
            case DEPOSIT_AND_WITHDRAW -> new DepositAndWithdrawATM(slots, banknoteCapacity);
        };
        return atm;
    }

    @Step ("Вывод средств")
    public static void withdraw(AbstractATM atm, int moneyAmount) {
        atm.withdraw(moneyAmount);
    }

    @Step ("Ввод средств")
    public static void deposit(AbstractATM atm, HashMap<Integer, Integer> banknotes) {
        atm.deposit(banknotes);
    }

    @Step ("Получение остатка")
    public static int getTotalMoneyAmount(AbstractATM atm) {
        return atm.getTotalMoneyAmount();
    }
}
