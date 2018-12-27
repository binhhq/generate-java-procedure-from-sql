package vn.binhhq.fun.service.validate_driven.inout;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UpdateDrivenReq implements Serializable {
    private long channelId;
    private List<MethodData> methods;
    private List<ProductData> products;
    private MethodData method;
}
