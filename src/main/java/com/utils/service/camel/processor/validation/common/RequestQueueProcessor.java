package com.utils.service.camel.processor.validation.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.utils.service.dto.sms.AuditLogDto;
import com.utils.service.util.ObjectUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.ArrayList;
import java.util.List;

@Component
//@Async
public class RequestQueueProcessor implements Processor {

	@Value("${activemq.broker.url}")
	private String brokerUrl;
	private final ActiveMQConnectionFactory activeMQConnectionFactory;
	private final Queue queue;
	private final JmsTemplate jmsTemplate;

	public RequestQueueProcessor(ActiveMQConnectionFactory activeMQConnectionFactory, Queue queue,
                                 JmsTemplate jmsTemplate) {
		this.activeMQConnectionFactory = activeMQConnectionFactory;
		this.queue = queue;
		this.jmsTemplate = jmsTemplate;

	}

	@Override
	public void process(Exchange exchange) {
//		try {
//			Object request = exchange.getIn().getBody();
//			AuditLogDto logDto = new AuditLogDto();
//
//			String serviceName = ObjectUtil.getServiceName(exchange);
//			logDto.setServiceName(serviceName);
//			if (request instanceof IpnCommonRequestDto) {
//				logDto.setRequestId(((IpnCommonRequestDto) request).getRequestId());
//				logDto.setAuditRequestType(AuditRequestTypeEnum.REQUEST.getValue());
//			} else if (request instanceof IpnCommonResponseDto) {
//				logDto.setRequestId(((IpnCommonResponseDto) request).getRequestId());
//				logDto.setAuditRequestType(AuditRequestTypeEnum.RESPONSE.getValue());
//			}
//
//			if (request instanceof IMaskedAccountNumber) {
//				IMaskedAccountNumber accountReq = ((IMaskedAccountNumber) request);
//				String accountId = accountReq.getAccountId();
//				accountReq.setAccountId(ObjectUtil.maskAccountNumber(accountReq.getAccountId(), 4, '*'));
//				Gson g = new Gson();
//				logDto.setContent(g.toJson(request));
//				accountReq.setAccountId(accountId);
//			} else if (request instanceof IpnFundTransferRequestDto) {
//				IpnFundTransferRequestDto transferRequestDTO = ((IpnFundTransferRequestDto) request);
//				if (!ObjectUtil.isNullOrEmpty(transferRequestDTO.getDebitAccountId())) {
//					String accountId = transferRequestDTO.getDebitAccountId();
//					transferRequestDTO.setDebitAccountId(
//							ObjectUtil.maskAccountNumber(transferRequestDTO.getDebitAccountId(), 4, '*'));
//					Gson g = new Gson();
//					logDto.setContent(g.toJson(request));
//					transferRequestDTO.setDebitAccountId(accountId);
//				}
//				if (!ObjectUtil.isNullOrEmpty(transferRequestDTO.getCreditAccountId())) {
//
//					String accountId = transferRequestDTO.getCreditAccountId();
//					transferRequestDTO.setCreditAccountId(
//							ObjectUtil.maskAccountNumber(transferRequestDTO.getCreditAccountId(), 4, '*'));
//					Gson g = new Gson();
//					logDto.setContent(g.toJson(request));
//					transferRequestDTO.setCreditAccountId(accountId);
//				}
//			} else if (request instanceof IPNCheckStatusRequestDto) {
//				IPNCheckStatusRequestDto checkStatusRequestDto = ((IPNCheckStatusRequestDto) request);
//				String debitAccountId = checkStatusRequestDto.getDebitAccountId();
//				String creditAccountId = checkStatusRequestDto.getCreditAccountId();
//				checkStatusRequestDto.setCreditAccountId(
//						ObjectUtil.maskAccountNumber(checkStatusRequestDto.getCreditAccountId(), 4, '*'));
//				checkStatusRequestDto.setDebitAccountId(
//						ObjectUtil.maskAccountNumber(checkStatusRequestDto.getDebitAccountId(), 4, '*'));
//				Gson g = new Gson();
//				logDto.setContent(g.toJson(request));
//				checkStatusRequestDto.setCreditAccountId(creditAccountId);
//				checkStatusRequestDto.setDebitAccountId(debitAccountId);
//
//			} else if (request instanceof IpnAuthRequestDto) {
//				IpnAuthRequestDto authRequestDto = ((IpnAuthRequestDto) request);
//				if (!ObjectUtil.isNullOrEmpty(authRequestDto.getAC())) {
//
//					String accountId = authRequestDto.getAC().getAccountId();
//					authRequestDto.getAC()
//							.setAccountId(ObjectUtil.maskAccountNumber(authRequestDto.getAC().getAccountId(), 4, '*'));
//					Gson g = new Gson();
//					logDto.setContent(g.toJson(request));
//					authRequestDto.getAC().setAccountId(accountId);
//				}
//				if (!ObjectUtil.isNullOrEmpty(authRequestDto.getCredmessage())) {
//
//					String accountId = authRequestDto.getCredmessage().getAuthAccountId();
//					authRequestDto.getCredmessage().setAuthAccountId(
//							ObjectUtil.maskAccountNumber(authRequestDto.getCredmessage().getAuthAccountId(), 4, '*'));
//					Gson g = new Gson();
//					logDto.setContent(g.toJson(request));
//					authRequestDto.getCredmessage().setAuthAccountId(accountId);
//				}
//			} else if (request instanceof IpnAccountListResponseDto) {
//				IpnAccountListResponseDto authRequestDto = ((IpnAccountListResponseDto) request);
//				if (!ObjectUtil.isNullOrEmpty(authRequestDto.getAccountList())) {
//					List<String> accountList = new ArrayList<>();
//					authRequestDto.getAccountList().stream().forEach(account -> {
//						String accountId = account.getAccountId();
//						accountList.add(accountId);
//						account.setAccountId(ObjectUtil.maskAccountNumber(accountId, 4, '*'));
//					});
//
//					Gson g = new Gson();
//					logDto.setContent(g.toJson(request));
//					for (int i = 0; i < authRequestDto.getAccountList().size(); i++) {
//						AC account = authRequestDto.getAccountList().get(i);
//						String accountId = accountList.get(i);
//						account.setAccountId(accountId);
//					}
//				}
//			} else {
//				Gson g = new Gson();
//				logDto.setContent(g.toJson(request));
//			}
//			logDto.setDateTime(new DateTime().toString());
//			ObjectMapper mapper = new ObjectMapper();
//			String requestJsonString = mapper.writeValueAsString(logDto);
//			jmsTemplate.convertAndSend(queue, requestJsonString);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
