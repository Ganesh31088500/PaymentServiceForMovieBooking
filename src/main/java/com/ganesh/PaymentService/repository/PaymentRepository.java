package com.ganesh.PaymentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.PaymentService.dto.PaymentServiceDTO;
import com.ganesh.PaymentService.entity.PaymentServicee;

public interface PaymentRepository extends JpaRepository<PaymentServicee, Integer>{

	
	@Query(nativeQuery = true,value = "SELECT ea.paymentid,ea.amount,ea.paymenttype FROM moviebooking.payment_servicee ea join moviebooking.contact_service e on e.contact_id=ea.paymentid where ea.paymentid=:payment_id")
	PaymentServicee findContactByPaymentId(@Param("payment_id") Integer payment_id);
}
