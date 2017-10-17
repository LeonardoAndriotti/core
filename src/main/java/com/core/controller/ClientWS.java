package com.core.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.core.model.Carrer;
import com.core.model.JuridicalPerson;
import com.core.model.Orders;
import com.core.model.PhysicalPerson;

public class ClientWS {

	private RestTemplate restTemplate = new RestTemplate();
	private final String HOST_CARRER = "http://localhost:8091/carrer/";
	private final String HOST_ORDERS = "http://localhost:8091/orders/";
	private final String HOST_USER = "http://localhost:8091/user/";

	public List<Carrer> findAllCarrer() {
		return Arrays.asList(restTemplate.getForObject(HOST_CARRER, Carrer[].class));
	}
	
	public List<PhysicalPerson> findAllPhysicalPerson() {
		return Arrays.asList(restTemplate.getForObject(HOST_USER, PhysicalPerson[].class));
	}
	
	public List<JuridicalPerson> findAllJuridicalPerson() {
		return Arrays.asList(restTemplate.getForObject(HOST_USER, JuridicalPerson[].class));
	}

	public List<Orders> findAllOrders() {
		return Arrays.asList(restTemplate.getForObject(HOST_ORDERS, Orders[].class));
	}

	public Orders findOrderById(BigDecimal id) {
		return restTemplate.getForObject(HOST_ORDERS + id.toString(), Orders.class);
	}

	public Carrer findCarrerById(BigDecimal id) {
		return restTemplate.getForObject(HOST_CARRER + id.toString(), Carrer.class);
	}

	public void postCarrer(Carrer carrer) {
		restTemplate.postForEntity(HOST_CARRER, carrer, Carrer.class);
	}

	public void postOrder(Orders order) {
		restTemplate.postForEntity(HOST_ORDERS, order, Orders.class);
	}
	
	public void postOrder(JuridicalPerson person) {
		restTemplate.postForEntity(HOST_USER, person, JuridicalPerson.class);
	}
	
	public void postOrder(PhysicalPerson person) {
		restTemplate.postForEntity(HOST_USER, person, PhysicalPerson.class);
	}
}