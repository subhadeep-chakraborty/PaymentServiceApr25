package dev.subhadeep.paymentserviceapr25.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePaymentLinkRequestDto {
    public Long orderId;
}
