package vn.binhhq.fun.service.validate_driven.inout;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UpdateDrivenReqList implements Serializable {

	private List<UpdateDrivenReq> drivens;
	private long serviceId;

}
