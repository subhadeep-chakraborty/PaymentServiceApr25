package dev.subhadeep.paymentserviceapr25.controllers;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.subhadeep.paymentserviceapr25.dtos.GeneratePaymentLinkRequestDto;
import dev.subhadeep.paymentserviceapr25.services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(@Qualifier("razorpay")PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping("/payments")
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDto generatePaymentLinkRequestDto) throws RazorpayException, StripeException {

        //call payment service to get the link

        return paymentService.generatePaymentLink(generatePaymentLinkRequestDto.orderId); //Return the payment link
    }

}
