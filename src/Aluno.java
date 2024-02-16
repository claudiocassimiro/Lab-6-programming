import java.util.Arrays;

public class Aluno {
    private String matricula;
    private String nome;
    private String email;
    private String curso;
    private String telefone;
    private int numeroDeFaltas;
    private double[] notas = new double[3];

    public String getMatricula () {
        return this.matricula;
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
        this.numeroDeFaltas = numeroDeFaltas;
    }

    public double[] getNotas () {
        return notas;
    }

    public void setNotas(double[] notas) {
        if (notas.length != this.notas.length) {
            System.out.println("O número de notas fornecidas não corresponde ao esperado.");
            return;
        }

        for (double nota : notas) {
            if (nota < 0 || nota > 100) {
                System.out.println("Só é permitido notas entre 0 e 100. Nota fornecida fora do intervalo: " + nota);
                return;
            }
        }

        this.notas = Arrays.copyOf(notas, notas.length);
    }

    public double calcularPercentualDeFalta () {
        int numeroMaximoDeFaltas = 16;
        return (double) this.numeroDeFaltas / numeroMaximoDeFaltas * 100;
    }

    public double calcularMedia () {
        double sumNotas = 0.0;

        for (Double nota : this.notas) {
            sumNotas += nota;
        }

        return sumNotas / this.notas.length;
    }

    public String alunoFoiAprovado () {
        double media = calcularMedia();

        if (media >= 70 && this.numeroDeFaltas <= 15) {
            return "Aprovado";
        } else if (media >= 50 && media < 70 && this.numeroDeFaltas <= 15) {
            return "Exame";
        }

        return "Reprovado";
    }
}
