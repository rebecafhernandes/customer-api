package com.customdev.customer.api;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApiApplication {

	@Value("${aws.region}")
	private String awsRegion;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);
	}

	@Bean
	public AmazonSQS createSQSClient() {
		return AmazonSQSClient.builder()
				.withCredentials(new ProfileCredentialsProvider())
				.withRegion(awsRegion)
				.build();
	}
}
