package org.my.ATMCore;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

//    @Tag("MyTag1")
//    @Test
//    @Description("Первый тест")
//    void TestOne() {
//        HashMap<Integer, Integer> money = new HashMap<>(Map.of(100, 2, 500, 3, 50, 4, 5000, 4)); // 21900
//        List<NominalSlot> slots = Arrays.asList(
//                new NominalSlot(100),
//                new NominalSlot(500),
//                new NominalSlot(50),
//                new NominalSlot(5000)
//        );
//        AbstractATM atm = new DepositAndWithdrawATM(slots, 20);
//
//        atm.deposit(money);
//        atm.getTotalMoneyAmount();
//        atm.withdraw(100);
//        assertEquals(21800, atm.getTotalMoneyAmount());
//    }
//
//    @Tag("MyTag2")
//    @Description("Второй тест")
//    @ParameterizedTest
//    @ValueSource(ints = {200, 100})
//    void TestTwo(int testArgument) {
//        HashMap<Integer, Integer> money = new HashMap<>(Map.of(100, 2, 500, 3, 50, 4, 5000, 4)); // 21900
//        List<NominalSlot> slots = Arrays.asList(
//                new NominalSlot(100),
//                new NominalSlot(500),
//                new NominalSlot(50),
//                new NominalSlot(5000)
//        );
//        AbstractATM atm = new DepositAndWithdrawATM(slots, 20);
//
//        atm.deposit(money);
//        atm.getTotalMoneyAmount();
//        atm.withdraw(testArgument);
//        assertEquals(21700, atm.getTotalMoneyAmount());
//    }
}