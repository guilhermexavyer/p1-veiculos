package prog2_projeto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBConnection {

	Logger logger = Logger.getLogger(DBConnection.class);
	private static DBConnection instance = null;
	private Connection conn;

	private String url = "jdbc:postgresql://localhost:5432/prog2_xavier";
	private String usuario = "postgres";
	private String senha = "123456";

	private DBConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, usuario, senha);
			logger.info("Sucesso na conexão");
		} catch (Exception ex) {
			logger.error("Erro ao conectar com o BD: " +
					ex.getMessage());
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public static DBConnection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}

		return instance;
	}
}
