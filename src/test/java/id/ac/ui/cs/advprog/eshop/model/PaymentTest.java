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
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP1234ABC5678");
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("abcdefg", "VoucherCode", "SCAMMED",
                    paymentData);
        });
    }
    @Test
    void testCreatePaymentRejectedStatus() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP1234ABC5678");
        Payment payment = new Payment("abcdefg", "VoucherCode", "REJECTED",
                paymentData);
        assertEquals("REJECTED", payment.getStatus());
    }
    @Test
    void testCreatePaymentCashOnDeliveryMethod() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("address","Depok");
        paymentData.put("deliveryFee", "1000000");
        Payment payment = new Payment("abcdefg", "CashOnDelivery", "SUCCESS",
                paymentData);
        assertEquals("CashOnDelivery", payment.getMethod());
    }
    @Test
    void testCreatePaymentInvalidMethod() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP1234ABC5678");
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("abcdefg", "Ngutang", "SUCCESS",
                    paymentData);
        });
    }
}
