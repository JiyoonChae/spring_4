package com.jy.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Subway {
	
	public void buyBang() {
		System.out.println("빵먹고싶다");
	}
	
	public void takeSubway() {
		System.out.println("--------------");
		System.out.println("지하철타서 게임");
		System.out.println("지하철에서 자기");
		System.out.println("---------------");
	}
}
