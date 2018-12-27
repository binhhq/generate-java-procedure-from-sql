package vn.binhhq.fun.service.test_override;

public class Father {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        System.out.println("Father");
        return id;
    }
}
