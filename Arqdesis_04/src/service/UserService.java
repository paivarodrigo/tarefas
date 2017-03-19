package service;

import dao.UserDAO;
import model.User;


public class UserService {
	UserDAO dao = new UserDAO();
	
	public int createUser(User user) {
		return dao.createUser(user);
	}
	
	public void updateUser(User user){
		dao.updateUser(user);;
	}
	
	public void deleteUser(int idusuario){
		dao.deleteUser(idusuario);
	}
	
	public User selectUser(int idusuario){
		return dao.selectUser(idusuario);
	}

}
