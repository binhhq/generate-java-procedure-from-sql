package vn.binhhq.fun.service.validate_driven.inout;

import lombok.Data;

import java.io.Serializable;

@Data
public class MethodData implements Serializable{
	private long id;
	private long methodId;
	private String status;
}
