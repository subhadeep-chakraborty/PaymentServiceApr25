package dev.subhadeep.paymentserviceapr25.services;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorpayPaymentGateway  implements PaymentService{
        private RazorpayClient razorpayClient;

        public RazorpayPaymentGateway(RazorpayClient razorpayClient){
            this.razorpayClient = razorpayClient;
        }

    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000); // amount in paisa, 1000  = 10 rs
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis() + 10*60*1000); //epoch time
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Payment for kitkat wafers");


        JSONObject customer = new JSONObject();
        customer.put("name","Subhadeep Chakraborty");
        customer.put("contact","+155 101231233");
        customer.put("email","subhadeepc298@gmail.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);


        paymentLinkRequest.put("reminder_enable",true);
        //JSONObject notes = new JSONObject();
       // notes.put("policy_name","Jeevan Bima");
        //paymentLinkRequest.put("notes",notes);

        paymentLinkRequest.put("callback_url","https://razorpay.com");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }
}
