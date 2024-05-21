package org.my.ATMCore.Utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.HashMap;
import java.util.stream.Stream;

public class DataProvider {
    static Stream<Arguments> blackBoxDepositDataCaseOne() {
        return Stream.of(
                Arguments.of(
                        new HashMap<Integer, Integer>() {{
                            put(100, 10);
                            put(500, 10);
                        }}
                ),
                Arguments.of(
                        new HashMap<Integer, Integer>() {{
                            put(100, 1);
                            put(500, 2);
                        }}
                )
        );
    }
}
