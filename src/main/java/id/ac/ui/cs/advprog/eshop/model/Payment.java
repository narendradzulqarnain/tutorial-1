package id.ac.ui.cs.advprog.eshop.model;

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
        this.id = id;
        String[] statusList = {"SUCCESS", "REJECTED"};
        String[] methodList = {"VoucherCode", "CashOnDelivery"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        }   else if (Arrays.stream(methodList).noneMatch(item ->(item.equals(method)))){
            throw new IllegalArgumentException();
        } else {
            this.method = method;
            this.status = status;
            this.paymentData = paymentData;
        }

    }

}
