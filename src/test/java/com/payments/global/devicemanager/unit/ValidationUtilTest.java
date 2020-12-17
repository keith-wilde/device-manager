package com.payments.global.devicemanager.unit;

import com.payments.global.devicemanager.util.ValidationUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilTest {

    @Test
    void Should_Accept_Valid_Serial_Nos(){
        String test1 = "12-1222";
        String test2 ="3455670-22222";
        String test3 = "1-00022221";

        assertThat(ValidationUtil.isSerialNumberValid(test1)).isTrue();
        assertThat(ValidationUtil.isSerialNumberValid(test2)).isTrue();
        assertThat(ValidationUtil.isSerialNumberValid(test3)).isTrue();
    }
}
