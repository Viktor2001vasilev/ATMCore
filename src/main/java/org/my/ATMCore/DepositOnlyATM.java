package org.my.ATMCore;

import java.util.List;

public class DepositOnlyATM extends AbstractATM {

    public DepositOnlyATM(List<NominalSlot> nominalSlotList, int banknoteAcceptorCapacity) {
        super(nominalSlotList, banknoteAcceptorCapacity);
    }

    @Override
    public void withdraw(int moneyAmount) {
        throw new UnsupportedOperationException("Данный банкомат не поддерживает вывод средств.");
    }
}