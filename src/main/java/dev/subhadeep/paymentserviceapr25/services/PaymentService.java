package dev.subhadeep.paymentserviceapr25.services;


import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

    public String generatePaymentLink(Long orderId) throws RazorpayException, StripeException;

}
