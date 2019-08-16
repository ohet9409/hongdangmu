package users.controller;

import java.util.List;

import users.bean.UsersDTO;

public interface UsersService {
	public int write(UsersDTO usersDTO);
	public String login(int user_code);
	public String isExistId(int user_code);
	public UsersDTO selectOne(int user_code);
	public int modify(UsersDTO usersDTO);
	public int delete(int user_code);
	public List<UsersDTO> selectList(int startNum, int endNum);
	public int getTotalMember();
	public List<UsersDTO> list();
}
