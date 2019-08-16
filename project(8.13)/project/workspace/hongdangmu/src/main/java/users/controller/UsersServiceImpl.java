package users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import users.bean.UsersDTO;
import users.dao.UsersDAO;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDAO dao;

	public int write(UsersDTO usersDTO) {
		// TODO Auto-generated method stub
		return dao.write(usersDTO);
	}

	public String login(int user_code) {
		// TODO Auto-generated method stub
		return dao.login(user_code);
	}

	public String isExistId(int user_code) {
		// TODO Auto-generated method stub
		return dao.isExistId(user_code);
	}

	public UsersDTO selectOne(int user_code) {
		// TODO Auto-generated method stub
		return dao.selectOne(user_code);
	}

	public int modify(UsersDTO usersDTO) {
		// TODO Auto-generated method stub
		return dao.modify(usersDTO);
	}

	public int delete(int user_code) {
		// TODO Auto-generated method stub
		return dao.delete(user_code);
	}

	public List<UsersDTO> selectList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return dao.selectList(startNum, endNum);
	}

	public int getTotalMember() {
		// TODO Auto-generated method stub
		return dao.getTotalMember();
	}

	public List<UsersDTO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
