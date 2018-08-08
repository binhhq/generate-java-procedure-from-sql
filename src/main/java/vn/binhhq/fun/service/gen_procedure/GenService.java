package vn.binhhq.fun.service.gen_procedure;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.gen_procedure.entity_result.GenEntityResultService;
import vn.binhhq.fun.service.gen_procedure.entity_result.ReadSelectQueryService;
import vn.binhhq.fun.service.gen_procedure.procedure.GenProcedure;
import vn.binhhq.fun.service.gen_procedure.service_call.GenServiceCall;

@Service
public class GenService {

	@Autowired
	private ReadSelectQueryService readSelectQueryService;
	@Autowired
	private GenEntityResultService genEntityResultService;
	@Autowired
	private GenProcedure genProcedure;
	@Autowired
	private GenServiceCall genServiceCall;

	public void gen() throws IOException {
		List<String> items = readSelectQueryService.read();
		genEntityResultService.gen(items);
		genProcedure.gen();
		genServiceCall.gen();
	}
	
 }
