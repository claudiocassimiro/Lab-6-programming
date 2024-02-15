public class Aluno {
    private String matricula;
    private String nome;
    private String email;
    private String curso;
    private String telefone;
    private int numeroDeFaltas;
    private Double[] notas = new Double[3];

    public String getMatricula () {
        return matricula;
    }

    public void setMatricula (String matricula) {
        this.matricula = matricula;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getCurso () {
        return curso;
    }

    public void setCurso (String curso) {
        this.curso = curso;
    }

    public String getTelefone () {
        return telefone;
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    public int getNumeroDeFaltas () {
        return numeroDeFaltas;
    }

    public void setNumeroDeFaltas (int numeroDeFaltas) {
        this.numeroDeFaltas += numeroDeFaltas;
    }

    public Double[] getNotas () {
        return notas;
    }

    public void setNotas (double nota, int index) {
        if (this.notas.length - 1 <= index) {
            this.notas[index] = nota;
            return;
        }

        System.out.println("O index escolhido está fora do comprimento do array");

    }

    public String alunoFoiAprovado () {
        double media = 0.0;
        double sumNotas = 0.0;

        for (Double nota : this.notas) {
            sumNotas += nota;
        }

        media = sumNotas / this.notas.length;

        if (media >= 70 && this.numeroDeFaltas <= 15) {
            return "Aprovado";
        } else if (media >= 50 && media < 70 && this.numeroDeFaltas <= 15) {
            return "Exame";
        }

        return "Reprovado";
    }
}
