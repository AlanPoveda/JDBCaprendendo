package JDBConnectionResources;

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args){

        AlunoDAO alunoDAO = new AlunoDAO();

        //Consulta de todos os alunos da tabela --------------------------------------------
        List<Aluno> alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        //Consulta de somente um aluno da tabela ----------------------------------------------------
        Aluno aluno = alunoDAO.getId(7);
        System.out.println(aluno);

        //Adicionando um novo aluno ----------------------------------------------------------------
        //Adicionando as informações
        Aluno adicionandoAluno = new Aluno("Sebastian", 25, "SP");

        //Criando o aluno
        //alunoDAO.create(adicionandoAluno);

        //Deletando aluno --------------------------------------------------------------------------

        //alunoDAO.delete(2);

        //Atualizando informação--------------------------------------------------------------------

        //Pegar id
        Aluno updateAluno = alunoDAO.getId(3);
        updateAluno.setNome("Paulo");
        updateAluno.setIdade(50);
        updateAluno.setEstado("RJ");

        //Colocar o update
        alunoDAO.atualizacao(updateAluno);

        //Fazendo denovo o select para mostrar na base
        alunoDAO.list().stream().forEach(System.out::println);
    }
}
