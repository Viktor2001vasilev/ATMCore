package org.my.ATMCore;

public class NominalSlot {
    private final int nominal;
    private int banknotesCount;

    public NominalSlot(int nominal) {
        this.nominal = nominal;
        this.banknotesCount = 0;
    }

    public int getNominal() {
        return nominal;
    }
    public int getBanknotesCount() {
        return banknotesCount;
    }

    public void addBanknotesToSlot(int count) {
        banknotesCount += count;
    }

    public boolean removeBanknotesFromSlot(int count) {
        if (count <= banknotesCount) {
            banknotesCount -= count;
            return true;
        }
        return false;
    }

    public int getTotalAmount() {
        return nominal * banknotesCount;
    }
}