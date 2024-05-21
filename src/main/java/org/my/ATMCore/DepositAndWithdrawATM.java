package org.my.ATMCore;

import java.util.List;

public class DepositAndWithdrawATM extends AbstractATM {

    public DepositAndWithdrawATM(List<NominalSlot> nominalSlotList, int banknoteAcceptorCapacity) {
        super(nominalSlotList, banknoteAcceptorCapacity);
    }

    @Override
    public void withdraw(int moneyAmount) {
        operationManager.withdraw(moneyAmount);
        System.out.println("Вывод средств прошел успешно.");
    }
}