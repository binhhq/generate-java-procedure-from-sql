package vn.binhhq.fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import vn.binhhq.fun.service.compare_constructor.CompareConstructorService;
import vn.binhhq.fun.service.compare_constructor.ReadResultMapping;
 

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompareConstructorServiceTest {

	@Autowired
	private CompareConstructorService service;
	@Autowired
	private ReadResultMapping readResultMapping;

	@Test
	public void testList() {
		try {
			service.run();
			readResultMapping.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}