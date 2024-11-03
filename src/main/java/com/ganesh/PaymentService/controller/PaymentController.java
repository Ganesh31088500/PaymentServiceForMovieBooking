package com.ganesh.PaymentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.PaymentService.dto.PaymentServiceDTO;
import com.ganesh.PaymentService.exception.PaymentException;
import com.ganesh.PaymentService.service.PaymentServiceImpl;

@RestController
public class PaymentController {

	@Autowired
	PaymentServiceImpl impl;
	@Autowired
	Environment environment;
	@PostMapping("/payments")
	public ResponseEntity<String> addPayment(@RequestBody PaymentServiceDTO dto) throws PaymentException{
		Integer paymentId=impl.addPayment(dto);
		String message=environment.getProperty("Payment added successfully");
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	@GetMapping("/payments/{id}")
	public ResponseEntity<PaymentServiceDTO> getPayemntById(@PathVariable("id") Integer id) throws PaymentException{
		PaymentServiceDTO dto=impl.getPaymentById(id);
		//String message=environment.getProperty("getting results from payment ");
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@GetMapping("/payments")
	public ResponseEntity<List<PaymentServiceDTO>> getAllPayments() throws PaymentException{
		List<PaymentServiceDTO>  dto=impl.getAllPayments();
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/payment/{id}")
	public ResponseEntity<PaymentServiceDTO> getContactByPaymentId(@PathVariable("id") Integer id) throws PaymentException{
		PaymentServiceDTO dto=impl.getContactByPaymentId(id);
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
}
