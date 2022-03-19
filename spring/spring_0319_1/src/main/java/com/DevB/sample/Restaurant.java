package com.DevB.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Setter 주입
// 생성자 주입
// 필드 주입


@Component
@ToString
@Getter
@RequiredArgsConstructor
public class Restaurant {
	
	// 필드 주입
	// @Autowired
	private final Chef chef;
	
	// Setter 주입
	/* 
	 * @Autowired public void setRestaurant(Chef chef) { this.chef = chef; }
	 */
}
