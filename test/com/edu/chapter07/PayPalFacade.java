package com.edu.chapter07;

import com.edu.chapter07.dto.PaymentAdviceDto;

public interface PayPalFacade {

	void sendAdvice(PaymentAdviceDto paymentAdviceDto);

}
