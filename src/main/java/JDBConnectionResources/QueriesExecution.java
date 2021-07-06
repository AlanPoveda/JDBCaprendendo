package JDBConnectionResources;

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args){

        AlunoDAO alunoDAO = new AlunoDAO();

        //Consulta de todos os alunos da tabela
        List<Aluno> alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        //Consulta de somente um aluno da tabela
        Aluno aluno = alunoDAO.getId(8);
        System.out.println(aluno);


    }
}
