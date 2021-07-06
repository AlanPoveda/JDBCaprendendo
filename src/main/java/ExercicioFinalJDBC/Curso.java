package ExercicioFinalJDBC;

//Espelho da tabela do banco
public class Curso {
    int id;
    String nome;
    int duracaoHoras;

    //Select
    public Curso(int id, String nome, int duracaoHoras){
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;

    }

    //Selec id, delete, e update
    public Curso(String nome, int duracaoHoras){
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(){}

    //Getter and setters

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}

    public int getDuracaoHoras(){return duracaoHoras;}
    public void setDuracaoHoras(int duracaoHoras){this.duracaoHoras=duracaoHoras;}


    //Formatação da resposta

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Curso{ ");
        sb.append(" id= ").append(id);
        sb.append(" nome= ").append(nome);
        sb.append(" duracao_horas= ").append(duracaoHoras);
        sb.append(" }");

        return sb.toString();
    }



}
