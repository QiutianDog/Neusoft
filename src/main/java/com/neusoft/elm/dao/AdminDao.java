package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Admin;

public interface AdminDao {

    Admin getAdminByNameAndPassword(String adminName, String password);

}
