package dev.subhadeep.paymentserviceapr25.configs;


import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayClientConfig {
//    @Value("${razorpay.key.id}")
//    private String razorpayKeyId;
//    @Value("${razorpay.secret.key}")
//    private String razorpaySecretKey;

    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient("rzp_test_q0lsIzlF1aJWzB","5H8NmemiNVldyTWnFT57AC9l");
    }
}
