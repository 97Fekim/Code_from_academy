package com.green.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
@Getter
@ToString
public class Restaurant {
	@Setter(onMethod_=@Autowired)	// �������� �����Ѵ� (�ڵ� ����)
	private Chef chef;				// setChef �޼���
	
}
