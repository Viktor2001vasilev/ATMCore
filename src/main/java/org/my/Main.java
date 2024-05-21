package org.my;

import org.my.ATMCore.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> money = new HashMap<>(Map.of(100, 2, 500, 3, 50, 4, 5000, 4)); // 21900
        List<NominalSlot> slots = Arrays.asList(
                new NominalSlot(100),
                new NominalSlot(500),
                new NominalSlot(50),
                new NominalSlot(5000)
        );
        AbstractATM atm = new DepositAndWithdrawATM(slots, 20);

        atm.deposit(money);
        atm.getTotalMoneyAmount();
        atm.withdraw(100);
        atm.getTotalMoneyAmount();

    }
}