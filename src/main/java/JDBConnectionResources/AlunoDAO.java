package JDBConnectionResources;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Toda vez que faz acesso um banco, se cria uma classe, com a sufixo DAO. Data Acess Object
public class AlunoDAO {
    //Fazer o SELECT do banco

    //Criando uma lista, aonde será o retorno
    public List<Aluno> list(){

        //Criação de lista
        List<Aluno> alunos = new ArrayList<>();

        //Conecxão como banco, feito em outro documento, desing patterns de factory
        try(Connection conn = JDBConnectionResources.getConnection()){

            //Consulta SQL, aqui será feito. prepareStatement
            PreparedStatement prst =  conn.prepareStatement("SELECT id, nome, idade, estado FROM aluno");

            //Executar a consulta! executeQuery, é para SELECT
            //ResultSet
            ResultSet rs = prst.executeQuery();

            //Percorrer os valores, o next, mostra o proximo resultado, o primeiro é vazio
            //Ele retorna um booleano, então é necessário usar ele com while
            while(rs.next()){
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("estado")
                );
                //Adicionando a resposta na lista
                alunos.add(aluno);
            }


        }catch(Exception e){
            System.out.println("Erro na conecxão com o banco");
            e.printStackTrace();
        }


        //O que vai retornar é alista completa de toda a tabela
        return alunos;




    };

    //Fazer um SELECT, porém uma pessoa específica, id
    public Aluno getId(int id){

        Aluno aluno = new Aluno();

        //Nesse casso tem que por ?, pois é padrão e o valor será inserido
        String sql = "SELECT id, nome, idade, estado FROM aluno WHERE id = ?";

        try(Connection conn = JDBConnectionResources.getConnection()){

            //Fazendo a consulta
            PreparedStatement prst = conn.prepareStatement(sql);
            //Precisa setar o id, dessa forma que é setado
            prst.setInt(1, id);

            //Necessário por que ainda é um SELECT executeQuery
            ResultSet rs = prst.executeQuery();

            //Como é somente uma resposta, não precisa de um while
            if(rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));

            }

        }catch(SQLException e) {
            e.printStackTrace();
        }


        //Vai retornar a consulta
        return aluno;

    };


    //Fazer um UPDATE, com uma pessoa espefíca
    

    //Fazer um DELETE, de uma pessoa específica



}
