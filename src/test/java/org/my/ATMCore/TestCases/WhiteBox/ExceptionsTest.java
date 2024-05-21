package org.my.ATMCore.TestCases.WhiteBox;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.my.ATMCore.AbstractATM;
import org.my.ATMCore.DepositAndWithdrawATM;
import org.my.ATMCore.NominalSlot;
import org.my.ATMCore.Utils.ATMType;
import org.my.ATMCore.Utils.StandartSteps;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionsTest {

    @Tag("ExceptionsCheck")
    @Tag("WBSlotsExceptionCheck")
    @Test
    @Description("Ноль слотов")
    void slotsExceptionCheck() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StandartSteps.getATM(ATMType.DEPOSIT_AND_WITHDRAW, new ArrayList<>(), 10);
        });
        assertEquals("У банка должен быть хотябы 1 слот.", exception.getMessage());
    }

    @Tag("ExceptionsCheck")
    @Tag("WBBanknotesCapacityExceptionCheck")
    @Test
    @Description("Нет купюроприемника")
    void banknotesCapacityExceptionCheck() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StandartSteps.getATM(ATMType.DEPOSIT_AND_WITHDRAW, Arrays.asList(
                    new NominalSlot(100),
                    new NominalSlot(500)), 0);
        });
        assertEquals("У банка должен быть купюроприемник.", exception.getMessage());
    }

    @Tag("ExceptionsCheck")
    @Tag("WBNoWithdrawExceptionCheck")
    @Test
    @Description("Нет поддержки вывода средств")
    void noWithdrawExceptionCheck() {

        AbstractATM atm = StandartSteps.getATM(ATMType.DEPOSIT_ONLY, Arrays.asList(
                new NominalSlot(100),
                new NominalSlot(500)), 5);

        UnsupportedOperationException exception = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            StandartSteps.withdraw(atm, 100);
        });
        assertEquals("Данный банкомат не поддерживает вывод средств.", exception.getMessage());
    }
}
