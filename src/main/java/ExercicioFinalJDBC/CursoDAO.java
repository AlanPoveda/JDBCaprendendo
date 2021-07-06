package ExercicioFinalJDBC;


import JDBConnectionResources.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    //Select
    public List<Curso> list(){

        //Lista pois vai pegar todas as informações e mostrar no banco
        List<Curso> cursos = new ArrayList<>();

        try(Connection conn = JDBConnection.getConnection()){
            //SQL, preapre state
            String sql = "SELECT id, nome, duracao_horas FROM curso";

            PreparedStatement prst = conn.prepareStatement(sql);

            //Executar a query, ResultSet
            ResultSet rs = prst.executeQuery();

            while(rs.next()){
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("duracao_horas")
                );

                cursos.add(curso);
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao mostrar os usuarios");
        }

        return cursos;


    }

    //Select id
    public Curso getId(int id){
        Curso curso = new Curso();

        String sql = "SELECT id, nome, duracao_horas FROM curso WHERE id = ?";

        try(Connection conn = JDBConnection.getConnection()){

            //Preparando o State
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);

            //Executar
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getInt("duracao_horas"));
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Aconteceu um erro ao mostrar esse curso");
        }return curso;



    }


    //Insert
    public void create(Curso curso){
        //SQL
        String slq = "INSERT INTO curso(nome, duracao_horas) VALUES(?, ?)";

        try(Connection conn = JDBConnection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(slq);
            stmt.setString(1,curso.getNome());
            stmt.setInt(2,curso.getDuracaoHoras());

            //Execute

            int rowAffected = stmt.executeUpdate();

            System.out.println("Criação feita com sucesso! Adiconado "+rowAffected+" linha");

        }catch (SQLException e){
            System.out.println("Ocorreu um erro ao adicionar um novo curso");
            e.printStackTrace();
        }

    }


    //Delete
    public void delete(int id){
        String sql = "DELETE FROM curso where id = ?";

        try(Connection conn = JDBConnection.getConnection()){
            //Preparando o SQL
            PreparedStatement state = conn.prepareStatement(sql);
            state.setInt(1,id);

            //Executando
            int rowAffected = state.executeUpdate();

            System.out.println("Foi deletado com sucesso do banco! Linha "+rowAffected);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao deletar alguém");
        }


    }

    //Update informarion
    public void update(Curso curso){
        //Comando SQL
        String sql = "UPDATE curso SET nome = ? , duracao_horas = ? WHERE id = ?";

        try(Connection conn = JDBConnection.getConnection()){
            //Preparar
            PreparedStatement state = conn.prepareStatement(sql);
            state.setString(1,curso.getNome());
            state.setInt(2,curso.getDuracaoHoras());
            state.setInt(3,curso.getId());

            //Execute
            int rowAffected = state.executeUpdate();

            System.out.println("Update feito com sucesso! Mundaça na linha "+rowAffected);

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao fazer o update");
        }



    }
}
