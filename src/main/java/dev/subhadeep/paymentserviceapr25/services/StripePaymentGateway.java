package dev.subhadeep.paymentserviceapr25.services;

import com.razorpay.RazorpayException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentGateway implements PaymentService {

    @Override
    public String generatePaymentLink(Long orderId) throws StripeException {

        Stripe.apiKey = "sk_test_51RJepvR7OXGY2GkuB2LdGCp8ooEldiNvT3RFD97hxLtwLjzsWsaTMekVct2F5sSR1R2FG12BDjVeVuRAlmqtZIW200uE9jID6M";

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("eur")
                        .setUnitAmount(1000L)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Payment for an website").build()
                        )
                        .build();
        Price price = Price.create(priceCreateParams);

        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);

     return paymentLink.toString();
    }
}
