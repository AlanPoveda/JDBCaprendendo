package ExercicioFinalJDBC;

import java.util.List;

public class ExecuteQueries {

    public static void main(String[] args){

        //Select-------------------------------------------------------------------------------
        CursoDAO cursosDAO = new CursoDAO();
        List<Curso> cursosExistentes = cursosDAO.list();
        cursosExistentes.stream().forEach(System.out::println);

        //Select id---------------------------------------------------------------------------
        Curso cursoExistente = cursosDAO.getId(2);
        System.out.println(cursoExistente);

        //Criando um novo----------------------------------------------------------------------
        Curso novoCurso = new Curso("Filosofia", 68);

        //cursosDAO.create(novoCurso);

        //Deletando-----------------------------------------------------------------------------

        //cursosDAO.delete(2);

        //Update--------------------------------------------------------------------------------
        //Precisa primeiro pegar o curso, para depois setar a mudança
        Curso mudandoCurso = cursosDAO.getId(1);
        mudandoCurso.setNome("Redacao");
        mudandoCurso.setDuracaoHoras(20);

        cursosDAO.update(mudandoCurso);



    }

}
