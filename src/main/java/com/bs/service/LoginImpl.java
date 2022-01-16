package com.bs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bs.bean.User;
import com.bs.repo.LoginDAO;

@Service
public class LoginImpl implements LoginService {

	@Autowired
	private LoginDAO dao;

	@Override
	public boolean isLogined(User user) {
		boolean flag = false;
		// get all credentials
		List<User> usersFromDB = dao.findAll();

		for (User users : usersFromDB) {
			// check username and password one by one
			if (users.getPassword().equalsIgnoreCase(user.getPassword())
					&& users.getUsername().equalsIgnoreCase(user.getUsername())) {
				flag = true;
				break;

			}
		}
		return flag;

	}

	@Override
	public User saveCred(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	public String deleteCred(User user) {
		User userExist = new User();
		boolean flag = false;
		// get all credentials
		List<User> usersFromDB = dao.findAll();
		// checking username wise
		for (User users : usersFromDB) {
			// check username and password one by one
			if (users.getPassword() == user.getPassword() && users.getUsername() == user.getUsername()) {
				userExist = users;
				flag = true;
				break;
			}
		}
		// deleting based on username password
		dao.deleteById(userExist.getId());

		if (flag)
			return "deleted";
		else
			return "not found";
	}

}
