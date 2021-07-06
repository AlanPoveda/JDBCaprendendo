package JDBCapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {

        String urlDataBase = "jdbc:postgresql://127.0.0.1:5432/dogotalinovationone";
        String username = "postgres";
        Connection bd = null;

        try{
            bd = DriverManager.getConnection(urlDataBase, username, "test.123");
            System.out.println("Conectado com sucesso");
        }catch( Exception e) {
            System.out.println("Deu erro na conexão");
            e.printStackTrace();
        } finally {
            assert bd != null;
            bd.close();
        }



        //Tem outra forma de conecção sem precisar do finally
        /*
        try(bd = DriverManager.getConnection(urlDataBase, username, "test.123")){
            System.out.println("Conectado com sucesso");
        } catch{
            System.out.println("Falha na connexão");
        }*/

    }







}
