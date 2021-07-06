package ExercicioFinalJDBC;

import org.postgresql.core.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBConnection {

    public static Connection getConnection(){
        Connection db = null;

        try(InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")){
            //Pegando as propriedades de conexão
            Properties prop = new Properties();

            //Transformar essa prop na conexão do banco
            prop.load(input);

            //Pegar informações do banco
            String driver = prop.getProperty("jdbc.driver");
            String dbAdress = prop.getProperty("db.adress");
            String dbPort = prop.getProperty("bd.port");
            String dbName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String pasword = prop.getProperty("db.user.password");

            //transformar tudo isso numa única string

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dbAdress).append(":")
                    .append(dbPort).append("/")
                    .append(dbName);

            //Url para fazer a conexão
            String urlString = sb.toString();

            //Fazendo a Concxão
            try {
                db = DriverManager.getConnection(urlString,user,pasword);
            } catch (SQLException throwables) {
                System.out.println("Deu erro na conexão do banco");
                throw new RuntimeException(throwables);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return db;

    }



}
