package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentRepository paymentRepository;
    List<Payment> payments;
    Map<Payment,Order> paymentOrderMap;

    @BeforeEach
    void setup() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        payments = new ArrayList<>();
        Payment payment1 = new Payment("abcd", PaymentMethod.VOUCHER_CODE.getValue(),
                PaymentStatus.SUCCESS.getValue(), paymentData);
        payments.add(payment1);
        Payment payment2 = new Payment("efgh", PaymentMethod.VOUCHER_CODE.getValue(),
                PaymentStatus.REJECTED.getValue(), paymentData);
        payments.add(payment2);
    }
    @Test
    void testAddPayment() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b", products, 1708560000L, "Safira Sudrajat");

        Payment result = paymentService.addPayment(order, "VoucherCode", payments.get(1).getPaymentData());
        Payment findResult = paymentRepository.findById(result.getId());
        assertNotNull(findResult);
    }
    @Test
    void testSetStatusSuccess() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b", products, 1708560000L, "Safira Sudrajat");
        Payment payment = paymentService.addPayment(order, "VoucherCode", payments.get(1).getPaymentData());
        Payment result = paymentService.setStatus(payment, PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        assertEquals(OrderStatus.SUCCESS.getValue(), order.getStatus());
    }
    @Test
    void testSetStatusRejected() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);
        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b", products, 1708560000L, "Safira Sudrajat");
        Payment payment = paymentService.addPayment(order, "VoucherCode", payments.getFirst().getPaymentData());
        Payment result = paymentService.setStatus(payment, PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(OrderStatus.FAILED.getValue(), order.getStatus());
    }
    @Test
    void testGetPayment() {
        Payment payment = payments.getFirst();
        Payment result = paymentService.getPayment(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }
    @Test
    void testGetPaymentIfIdNotExist() {
        Payment payment = payments.getFirst();
        Payment result = paymentService.getPayment(payment.getId());
        assertNull(result);
    }
    @Test
    void testGetAllPayments() {
        List<Payment> results = paymentService.getAllPayments();
        List<Payment> temp = paymentRepository.findAll();
        assertEquals(results.size(), temp.size());
    }
}
