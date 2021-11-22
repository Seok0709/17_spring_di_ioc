package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 
 * xml 파일을 이용한 객체 주입 예시
 * 
 * */

@Controller
public class SpringDiEx02 {
	
	@RequestMapping(value="/springDiEx02" , method=RequestMethod.GET)
	public String springDiEx02() {
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:ProductApplicationContext.xml"); // classpath = src/main/resources
		
		// ProductManagerEx2 pdMgr = context.getBean("pdMgr" , ProductManagerEx2.class); // getBean("bean의 id값" , 클래스명.class);
		// ProductManagerEx2 pdMgr = (ProductManagerEx2)context.getBean("pdMgr"); 		// (클래스명)getBean("bean의 id값");
		ProductManagerEx2 pdMgr = context.getBean(ProductManagerEx2.class);				// 클래스가 유일한 경우만 bean의 id값을 생략가능				
		
		// pdMgr.setProduct(context.getBean(Product.class)); // 클래스가 유일하지 않으므로 error
		// pdMgr.printInfo();
		
		pdMgr.setProduct(context.getBean("product1" , Product.class));
		pdMgr.printInfo();
		
		pdMgr.setProduct(context.getBean("product2", Product.class));
		pdMgr.printInfo();
		
		pdMgr.setProduct(context.getBean("product3", Product.class));
		pdMgr.printInfo();
		
		
		return "home";
	}
}
