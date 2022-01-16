package com.bs.service;

import com.bs.bean.User;

public interface LoginService {
public boolean isLogined(User user);
public User saveCred(User user);
public String deleteCred(User user);

	
}
