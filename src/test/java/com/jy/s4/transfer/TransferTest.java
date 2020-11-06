package com.jy.s4.transfer;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jy.s4.MyTestCase;
import com.jy.s4.card.Card;

public class TransferTest extends MyTestCase {
	@Autowired
	private Bus bus;
	@Autowired
	private Subway subway;
	//@Autowired
	private Card card;
	@Autowired
	private Taxi taxi;
	
	@Test
	public void test() {
	//	card.cardCheck(); //advice? 어딘가에 설정해두면 spring이 보고 알아서 찍어줌,,
		bus.takeBus(30, "ll");	 //핵심 로직 or 공통관심사항
		
	
		subway.takeSubway();
		
		taxi.getTaxi();
		
	}

}
