package com.spring.di;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringDiEx01 {
	
	@RequestMapping(value="/springDiEx01" , method=RequestMethod.GET)
	public String springDiEx01() {
		
		// 일체형 객체 생성 예시
		ProductManagerEx1 pmEx01 = new ProductManagerEx1();
		pmEx01.printInfo();
		// setter 메서드를 이용한 객체 주입 예시
		
		ProductManagerEx2 pmEx02 = new ProductManagerEx2();
		Product product = new Product();
		pmEx02.setProduct(product);
		pmEx02.printInfo();
		
		// 생성자를 이용한 객체 주입 예시
		product = new Product();
		ProductManagerEx3 pmEx03 = new ProductManagerEx3(product);
		pmEx03.printInfo();
		return "home";
	}
	
}
