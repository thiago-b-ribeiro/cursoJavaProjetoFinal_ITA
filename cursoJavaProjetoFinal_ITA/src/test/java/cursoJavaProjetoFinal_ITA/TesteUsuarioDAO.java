package cursoJavaProjetoFinal_ITA;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import model.DAO;
import model.Usuario;

public class TesteUsuarioDAO {

	JdbcDatabaseTester jdt;
	
	@BeforeEach
	void setUp() throws Exception {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/areadetestes04?Timezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "*******";
		
		jdt = new JdbcDatabaseTester(driver, url, user, password);
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("src/test/resources/inicio.xml"));
		jdt.onSetup();
		
	}

	@Test
	public void testeConsultarUsuario() {
		Usuario usuario = new Usuario();
		DAO dao = new DAO();
		usuario = dao.consultarUsuario("teste.silva");
		assertEquals("teste.silva", usuario.getLogin());
	}

}
