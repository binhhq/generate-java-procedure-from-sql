package vn.binhhq.fun.service.gen_procedure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 

@SpringBootTest
@RunWith(SpringRunner.class)
public class GenServiceTest {
	
	@Autowired
	private GenService service;

	@Test
	public void testList() {
		try{
			service.gen();
		} catch(Exception e){
			e.printStackTrace();
		}
	}


}
