package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
public class UserDAO {

	public UserDAO() {
	}

	public int createUser(User user) {
		String sqlInsert = "INSERT INTO tbusuario(matricula, nome,cpf,"+
				"rg,endereco,telefone,email,funcao,conjunto)"+
				"VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, user.getPlate());
			stm.setString(2, user.getName());
			stm.setString(3, user.getCpf());
			stm.setString(4, user.getRg());
			stm.setString(5, user.getAddress());
			stm.setString(6, user.getPhone());
			stm.setString(7, user.getEmail());
			stm.setString(8, user.getFunction());
			stm.setInt(9, user.getGroup());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if(rs.next()) {
					user.setId(rs.getInt(1));
				}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return user.getId();
	}

	public void updateUser(User user) {
		String sqlUpdate = "UPDATE tbusuario SET matricula=?, nome=?, cpf=?, rg=?, endereco=?, telefone=?, email=?, funcao=?, conjunto=? WHERE idusuario=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, user.getPlate());
			stm.setString(2, user.getName());
			stm.setString(3, user.getCpf());
			stm.setString(4, user.getRg());
			stm.setString(5, user.getAddress());
			stm.setString(6, user.getPhone());
			stm.setString(7, user.getEmail());
			stm.setString(8, user.getFunction());
			stm.setInt(9, user.getGroup());
			stm.setInt(10, user.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int idusuario) {
		String sqlDelete = "DELETE FROM tbusuario WHERE idusuario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, idusuario);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User selectUser(int idusuario) {
		User user = new User();
		user.setId(idusuario);
		String sqlSelect = "SELECT matricula, nome, cpf, rg, endereco, telefone, email, funcao, conjunto FROM tbusuario WHERE idusuario=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, user.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					user.setPlate(rs.getString("matricula"));
					user.setName(rs.getString("nome"));
					user.setCpf(rs.getString("cpf"));
					user.setRg(rs.getString("rg"));
					user.setAddress(rs.getString("endereco"));
					user.setPhone(rs.getString("telefone"));
					user.setEmail(rs.getString("email"));
					user.setFunction(rs.getString("funcao"));
					user.setGroup(rs.getInt("conjunto"));
				} else {
					user.setId(-1);
					user.setPlate(null);
					user.setName(null);
					user.setCpf(null);
					user.setRg(null);
					user.setAddress(null);
					user.setPhone(null);
					user.setEmail(null);
					user.setFunction(null);
					user.setGroup(-1);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException ex) {
			System.out.print(ex.getStackTrace());
		}
		return user;
	}
}