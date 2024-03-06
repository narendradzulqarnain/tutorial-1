package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{
    Map<Payment,Order> paymentOrderMap = new HashMap<>();
    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        Payment payment = new Payment(UUID.randomUUID().toString(), method, "", paymentData);
        Payment result = paymentRepository.save(payment);
        paymentOrderMap.put(result, order);
        return payment;
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        Payment temp = paymentRepository.findById(payment.getId());
        Payment result = paymentRepository.save(new Payment(payment.getId(), payment.getMethod(), temp.getStatus(),payment.getPaymentData()));
        return result;
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
