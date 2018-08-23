package vn.binhhq.fun.service.compare_constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 

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