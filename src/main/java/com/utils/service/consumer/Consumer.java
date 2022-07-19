package com.utils.service.consumer;

import com.utils.service.dto.sms.SMSResponseWrapperDTO;
import com.utils.service.dto.sms.SendSMSRequestDTO;
import com.utils.service.dto.sms.SendSMSResponseDTO;
import com.utils.service.dto.sms.ServiceResponse;
import com.utils.service.facade.ReceiveSMSFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);


	private final ReceiveSMSFacade receiveSMSFacade;

	public Consumer(ReceiveSMSFacade receiveSMSFacade) {
		this.receiveSMSFacade = receiveSMSFacade;
	}

	@JmsListener(destination = "sms-in-queue")
	public void consumeMessage(String message) {
		logger.info("Message received from activemq queue---" + message);
		Gson gson = new Gson();
		SendSMSRequestDTO smsMsg = gson.fromJson(message, SendSMSRequestDTO.class);
		ServiceResponse res = receiveSMSFacade.processSMS(smsMsg);
//		System.out.println("SENT? =========>>>>>>>>>>   " + res.getServiceHeader().getResponseCode());

	}
}
