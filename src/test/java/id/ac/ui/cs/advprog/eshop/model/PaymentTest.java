package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    @Test
    void testCreatePaymentSuccessStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP1234ABC5678");
        Payment payment = new Payment("abcdefg", "VoucherCode","SUCCESS", paymentData);

        assertSame(paymentData, payment.getPaymentData());
        assertEquals("abcdefg", payment.getId());
        assertEquals("VoucherCode", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
    }
    @Test
    void testCreatePaymentInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("abcdefg", "VoucherCode", "SCAMMED",
                    (new HashMap<>()).put("voucherCode","ESHOP1234ABC5678"));
        });
    }
    @Test
    void testCreatePaymentRejectedStatus() {
        Payment payment = new Payment("abcdefg", "VoucherCode", "REJECTED",
                (new HashMap<>()).put("voucherCode","ESHOP1234ABC5678"));
        assertEquals("REJECTED", payment.getStatus());
    }
    @Test
    void testCreatePaymentCashOnDeliveryMethod() {
        Payment payment = new Payment("abcdefg", "CashOnDelivery", "SUCCESS",
                (new HashMap<>()).put("voucherCode","ESHOP1234ABC5678"));
        assertEquals("CashOnDelivery", payment.getMethod());
    }
    @Test
    void testCreatePaymentInvalidMethod() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("abcdefg", "Ngutang", "SUCCESS",
                    (new HashMap<>()).put("voucherCode","ESHOP1234ABC5678"));
        });
    }
}
