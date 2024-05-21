package org.my.ATMCore;

import java.util.HashMap;
import java.util.List;

public abstract class AbstractATM {
    protected final ATMOperationManager operationManager;
    public AbstractATM(List<NominalSlot> nominalSlotList, int banknoteAcceptorCapacity) {
        if (nominalSlotList.isEmpty()) throw new IllegalArgumentException("У банка должен быть хотябы 1 слот.");
        if (banknoteAcceptorCapacity == 0) throw new IllegalArgumentException("У банка должен быть купюроприемник.");
        operationManager = new ATMOperationManager(nominalSlotList, banknoteAcceptorCapacity);
    }

    public void deposit(HashMap<Integer, Integer> banknotes) {
        operationManager.deposit(banknotes);
        System.out.println("Пополнение успешно.");
    }
    public abstract void withdraw(int moneyAmount);
    public int getTotalMoneyAmount() {
        int amount = operationManager.getTotalATMMoneyAmount();
        System.out.println("Сумма в банкомате = " + amount + ".");
        return amount;
    }
}