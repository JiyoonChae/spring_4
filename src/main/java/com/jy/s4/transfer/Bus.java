package com.jy.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Bus {

	public void takeBus(int money, String name) {
		System.out.println("--------------");
		System.out.println("버스타서 음악 듣기");
		System.out.println("버스에서 창밖 보기");
		System.out.println("---------------");
	}
}
