package org.my.ATMCore.TestCases.BlackBox;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.my.ATMCore.AbstractATM;
import org.my.ATMCore.NominalSlot;
import org.my.ATMCore.Utils.ATMType;
import org.my.ATMCore.Utils.DataProvider;
import org.my.ATMCore.Utils.StandartSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultOperationsTest {

    @Tag("BBDepositWithdrawCheck")
    @Description("Пополнение - Вывод - Проверка")
    @ParameterizedTest
    @MethodSource("org.my.ATMCore.Utils.DataProvider#blackBoxDepositDataCaseOne")
    void standartOperationPipelineTest(HashMap<Integer, Integer> depositData) {
        AbstractATM atm = StandartSteps.getATM(ATMType.DEPOSIT_AND_WITHDRAW, Arrays.asList(
                new NominalSlot(100),
                new NominalSlot(500)), 100);
        StandartSteps.deposit(atm, depositData);
        int amount = StandartSteps.getTotalMoneyAmount(atm);
        StandartSteps.withdraw(atm, 100);
        assertEquals(StandartSteps.getTotalMoneyAmount(atm), amount - 100);
    }

}
