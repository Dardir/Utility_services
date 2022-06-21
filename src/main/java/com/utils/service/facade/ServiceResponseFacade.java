package com.utils.service.facade;


import com.utils.service.camel.common.FlowRouteNames;
import com.utils.service.camel.common.SMSServiceStatusEnum;
import com.utils.service.dto.sms.SMSResponseWrapperDTO;
import com.utils.service.dto.sms.SendSMSResponseDTO;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseFacade {

	private final ProducerTemplate template;

	public ServiceResponseFacade(ProducerTemplate template) {
		this.template = template;
	}

	public static boolean isSuccessResponseCode(String response) {
		return response.contains(SMSServiceStatusEnum.SUCCESS.getErrorDescription());
	}
	public static boolean isInternalErrorHappen(String response) {
		return response.contains(SMSServiceStatusEnum.ERROR_FIRE.getErrorDescription());
	}

	public SMSResponseWrapperDTO generateSMSResponse(String responseStatus, String responseCode) {
		SMSResponseWrapperDTO smsResponseWrapperDTO = new SMSResponseWrapperDTO();
		SendSMSResponseDTO sendSMSResponseDTO = new SendSMSResponseDTO();
		sendSMSResponseDTO.setResponseCode(responseCode);
		sendSMSResponseDTO.setResponseDescription(responseStatus);
		smsResponseWrapperDTO.setSendSMSResponseDTO(sendSMSResponseDTO);
		return smsResponseWrapperDTO;
	}

	public void prepareServiceResponseRedirection(Object response, Exchange exchange) {
		this.prepareInternalRouteRedirection(response, exchange, FlowRouteNames.GENERATE_SERVICE_RESPONSE_ROUTE_NAME);
	}

	public void prepareInternalRouteRedirection(Object object, Exchange exchange, String flowName) {
		exchange.getMessage().setBody(object);
		template.send(flowName, exchange);
	}







}
