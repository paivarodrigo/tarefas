package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.User;
import service.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {
	User user, copia;
	UserService userService;
	static int idusuario = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o idusuario igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * User. 
	 * Certifique-se que a fixture user1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		user = new User();
		user.setId(idusuario);
		user.setName("Batista Cepelos");
		user.setPhone("(11) 91234-4321");
		user.setEmail("(11) 91234-4321");
		user.setPlate("2862");
		user.setName("Rodrigo");
		user.setCpf("44243095841");
		user.setRg("386496419");
		user.setAddress("Rua Juquia, 1124 apto 83B Santo Andr�");
		user.setPhone("(11) 91234-4321");
		user.setEmail("rodrigo.buepa@gmail.com");
		user.setFunction("Pedreiro");
		user.setGroup(1);
		copia = new User();
		copia.setId(idusuario);
		copia.setName("Batista Cepelos");
		copia.setPhone("(11) 91234-4321");
		copia.setEmail("(11) 91234-4321");
		copia.setPlate("2862");
		copia.setName("Rodrigo");
		copia.setCpf("44243095841");
		copia.setRg("386496419");
		copia.setAddress("Rua Juquia, 1124 apto 83B Santo Andr�");
		copia.setPhone("(11) 91234-4321");
		copia.setEmail("rodrigo.buepa@gmail.com");
		copia.setFunction("Pedreiro");
		copia.setGroup(1);
		userService = new UserService();
		System.out.println(user);
		System.out.println(copia);
		System.out.println(idusuario);
	}
	
	@Test
	public void test00Select() {
		System.out.println("selectUser");
		//para funcionar o user 1 deve ter sido carregado no banco por fora
		User fixture = new User();
		fixture.setId(1);
		fixture.setName("Batista Cepelos");
		fixture.setPhone("(11) 91234-4321");
		fixture.setEmail("(11) 91234-4321");
		fixture.setPlate("2862");
		fixture.setName("Rodrigo");
		fixture.setCpf("44243095841");
		fixture.setRg("386496419");
		fixture.setAddress("Rua Juquia, 1124 apto 83B Santo Andr�");
		fixture.setPhone("(11) 91234-4321");
		fixture.setEmail("rodrigo.buepa@gmail.com");
		fixture.setFunction("Pedreiro");
		fixture.setGroup(1);
		UserService novoService = new UserService();
		User novo = novoService.selectUser(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Create() {
		System.out.println("createUser");
		idusuario = userService.createUser(user);
		System.out.println(idusuario);
		copia.setId(idusuario);
		assertEquals("testa criacao", user, copia);
	}

	@Test
	public void test02Update() {
		System.out.println("updateUser");
		user.setPhone("(11) 97553-5226");
		copia.setPhone("(11) 97553-5226");		
		userService.updateUser(user);
		user = userService.selectUser(user.getId());
		assertEquals("testa atualizacao", user, copia);
	}

	@Test
	public void test03Delete() {
		System.out.println("deleteUser");
		copia.setId(-1);
		copia.setName(null);
		copia.setPhone(null);
		copia.setEmail(null);
		copia.setPlate(null);
		copia.setName(null);
		copia.setCpf(null);
		copia.setRg(null);
		copia.setAddress(null);
		copia.setPhone(null);
		copia.setEmail(null);
		copia.setFunction(null);
		copia.setGroup(-1);
		userService.deleteUser(idusuario);
		user = userService.selectUser(idusuario);
		assertEquals("testa exclusao", user, copia);
	}
}