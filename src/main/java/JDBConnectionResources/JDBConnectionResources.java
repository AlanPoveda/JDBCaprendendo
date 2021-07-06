package JDBConnectionResources;

import org.postgresql.core.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBConnectionResources {


    //Classe da connexão
    public static Connection getConnection(){
        Connection connection = null;

        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")){
            //Pegando as propriedade
            Properties prop = new Properties();
            prop.load(input);

            //Pegando as propriedades do banco
            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAdress = prop.getProperty("db.adress");
            String dataBasePort = prop.getProperty("bd.port");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            //Construindo a string de conexão

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAdress).append(":")
                    .append(dataBasePort).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            //Fazendo a connexão

            try{
                connection = DriverManager.getConnection(connectionUrl, user, password);
            }catch (SQLException e){
                System.out.println("Erro ao tentar conectar no banco");
                throw new RuntimeException(e);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
