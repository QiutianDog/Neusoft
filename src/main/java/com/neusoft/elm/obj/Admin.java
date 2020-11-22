package com.neusoft.elm.obj;

import lombok.Data;

/**
 * 管理员对象
 * @author QiutianDog
 */
@Data
public class Admin {
    /**
     * 信息
      */
    private Integer adminId;
    private String adminName;
    private String password;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
