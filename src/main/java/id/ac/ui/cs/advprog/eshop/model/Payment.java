package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;


@Getter
public class Payment {
    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    public Payment(String id, String method, String status, Map<String,String> paymentData) {

        if (!PaymentStatus.contains(status)) {
            throw new IllegalArgumentException();
        }
        else if (!PaymentMethod.contains(method)) {
            throw new IllegalArgumentException();
        }
        else {
            this.id = id;
            this.method = method;
            this.status = status;
            this.paymentData = paymentData;
        }

    }

}
