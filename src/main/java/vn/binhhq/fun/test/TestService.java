package vn.binhhq.fun.test;

import org.springframework.beans.BeanUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class TestService {

	public static void main(String [] agrs){
		Person p = new Person();
		p.setId("1");
		p.setName("Bingo");
		
		Developer d = new Developer();
		BeanUtils.copyProperties(p, d);
		System.out.println(d);
	}
}
