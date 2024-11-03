package com.ganesh.PaymentService.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.PaymentService.dto.PaymentServiceDTO;
import com.ganesh.PaymentService.entity.PaymentServicee;
import com.ganesh.PaymentService.exception.PaymentException;
import com.ganesh.PaymentService.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {

	
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	ModelMapper mapper;
	
	public Integer addPayment(PaymentServiceDTO dto) throws PaymentException{
		PaymentServicee paymentServicee=new PaymentServicee();
		paymentServicee.setPaymentid(dto.getPaymentid());
		paymentServicee.setPaymenttype(dto.getPaymenttype());
		paymentServicee.setAmount(dto.getAmount());
		PaymentServicee servicee=paymentRepository.save(paymentServicee);
		return servicee.getPaymentid();
	}
	public PaymentServiceDTO getPaymentById(Integer id) throws PaymentException{
		PaymentServicee paymentServicee=paymentRepository.findById(id).get();
		PaymentServiceDTO dto=mapper.map(paymentServicee, PaymentServiceDTO.class);
		return dto;
	}
	public List<PaymentServiceDTO> getAllPayments() throws PaymentException{
		Iterable<PaymentServicee>  payments=paymentRepository.findAll();
		List<PaymentServiceDTO> dtos=new ArrayList<PaymentServiceDTO>();
		dtos.forEach( t ->
		{
			PaymentServiceDTO dto=new PaymentServiceDTO();
			dto.setPaymentid(t.getPaymentid());
			dto.setPaymenttype(t.getPaymenttype());
			dto.setAmount(t.getAmount());
			dtos.add(dto);
		}
				);
		return dtos;
	}
	
	
	public PaymentServiceDTO getContactByPaymentId(Integer payment_id) throws PaymentException{
		
		PaymentServicee paymentServicee=paymentRepository.findContactByPaymentId(payment_id);
		PaymentServiceDTO dto=mapper.map(paymentServicee, PaymentServiceDTO.class);
		return dto;
	}
}
