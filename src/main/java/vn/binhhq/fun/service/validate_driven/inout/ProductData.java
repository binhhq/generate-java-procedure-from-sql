package vn.binhhq.fun.service.validate_driven.inout;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductData implements Serializable {
    private long id;
    private long productId;
    private String status;
    private String queryStatus;
}
