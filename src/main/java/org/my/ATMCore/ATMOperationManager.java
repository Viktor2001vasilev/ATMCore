package org.my.ATMCore;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATMOperationManager {
    private List<NominalSlot> nominalSlotList;
    private final int banknoteAcceptorCapacity;

    public ATMOperationManager(List<NominalSlot> nominalSlotList, int banknoteAcceptorCapacity) {
        this.nominalSlotList = nominalSlotList;
        this.banknoteAcceptorCapacity = banknoteAcceptorCapacity;
    }

    public void deposit(HashMap<Integer, Integer> banknotes) {
        if (banknotes.values().stream().reduce(0, Integer::sum) <= banknoteAcceptorCapacity) {
            for (Map.Entry<Integer, Integer> entry : banknotes.entrySet()) {
                int nominal = entry.getKey();
                int count = entry.getValue();
                boolean slotFound = false;

                for (NominalSlot slot : nominalSlotList) {
                    if (slot.getNominal() == nominal) {
                        slot.addBanknotesToSlot(count);
                        slotFound = true;
                        break;
                    }
                }

                if (!slotFound) {
                    throw new IllegalArgumentException("Данный банкомат не поддерживает купюры номиналом в " + nominal + ".");
                }
            }
        }
        else {
            throw new IllegalArgumentException("Курюроприемник не закрывается. Слишком много банкнот.");
        }
    }

    public void withdraw(int moneyAmount) {
        if (moneyAmount == 0) return;
        if (getTotalATMMoneyAmount() >= moneyAmount) {
            Collections.sort(nominalSlotList, (a, b) -> b.getNominal() - a.getNominal());
            int remain = moneyAmount;
            for (NominalSlot slot : nominalSlotList) {
                int nominal = slot.getNominal();
                int moneyNeed = remain / nominal;
                int avalible = Math.min(moneyNeed, slot.getBanknotesCount());
                if (avalible > 0) {
                    slot.removeBanknotesFromSlot(avalible);
                    remain -= nominal * avalible;
                }
                if (remain == 0) break;
            }
        }
        else throw new IllegalArgumentException("Такой суммы нет в этом банкомате");
    }

    public int getTotalATMMoneyAmount() {
        return nominalSlotList.stream().mapToInt(NominalSlot::getTotalAmount).sum();
    }
}