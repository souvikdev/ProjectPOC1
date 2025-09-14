package com.poc.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@Service
public class SQSSenderService {
	@Autowired
	private SqsClient sqsClient;
	
	@Value("${aws.sqs.queue-url}") 
	private String queueUrl;

	public String send(String body) {
		SendMessageRequest req = SendMessageRequest.builder().queueUrl(queueUrl).messageBody(body).build();
		SendMessageResponse resp = sqsClient.sendMessage(req);
		return resp.messageId();
	}
}