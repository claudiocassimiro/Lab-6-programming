import javax.swing.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        List<Aluno> alunos = new ArrayList<>();

        while (!sair) {
            System.out.println("\n### Menu ###");
            System.out.println("1. Cadastrar novo aluno");
            System.out.println("2. Lançar notas");
            System.out.println("3. Lançar faltas");
            System.out.println("4. Exibir informações dos alunos");
            System.out.println("5. Exibir lista de alunos ordenada por mádia");
            System.out.println("6. Sair");
            System.out.println("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Aluno novoAluno = cadastrarNovoAluno();
                    alunos.add(novoAluno);
                    break;

                case 2:
                    lancarNotas(alunos);
                    break;

                case 3:
                    lancarFaltas(alunos);
                    break;

                case 4:
                    exibirInformacoesAlunos(alunos);
                    break;

                case 5:
                    ordernarAlunosPorMedia(alunos);
                    break;

                case 6:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static Aluno cadastrarNovoAluno() {
        Aluno novoAluno = new Aluno();

        System.out.println("Matrícula: ");
        novoAluno.setMatricula(JOptionPane.showInputDialog("Digite o número de Matrícula"));

        System.out.println("Nome: ");
        novoAluno.setNome(JOptionPane.showInputDialog("Digite o nome do Aluno"));

        System.out.println("Curso: ");
        novoAluno.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno: "));

        System.out.println("Telefone: ");
        novoAluno.setTelefone(JOptionPane.showInputDialog("Digite o telefone do aluno: "));

        return novoAluno;
    }

    private static void lancarNotas (List<Aluno> alunos) {
        String matricula = JOptionPane.showInputDialog("Digite o número de Matrícula");

        Optional<Aluno> alunoOpt = alunos.stream()
                .filter(aluno -> aluno.getMatricula().equals(matricula))
                .findFirst();

        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();

            String input = JOptionPane.showInputDialog("Informe as notas (separadas por espaço): ").trim();
            if (input.isEmpty()) {
                System.out.println("Nenhuma nota fornecida. Encerrando o programa.");
            } else {
                double[] notas = Arrays.stream(input.split("\\s+"))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                aluno.setNotas(notas);
            }

            System.out.println("Notas lançadas para o aluno " + aluno.getNome());
        } else {
            System.out.println("Aluno não encontrado com a matrícula informada.");
        }
    }

    private static void lancarFaltas (List<Aluno> alunos) {
        String matricula = JOptionPane.showInputDialog("Digite o número de Matrícula");

        Optional<Aluno> alunoOpt = alunos.stream()
                .filter(aluno -> aluno.getMatricula().equals(matricula))
                .findFirst();

        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();

            aluno.setNumeroDeFaltas();

            System.out.println("Faltas lançadas para o aluno " + aluno.getNome());
        } else {
            System.out.println("Aluno não encontrado com a matrícula informada.");
        }
    }

    private static void ordernarAlunosPorMedia (List<Aluno> alunos) {
        alunos.sort(Comparator.comparing(Aluno::calcularMedia));

        exibirInformacoesAlunos(alunos);
    }

    private static void exibirInformacoesAlunos(List<Aluno> alunos) {
        System.out.println("\n### Informações dos Alunos ###");
        for (Aluno aluno : alunos) {
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Curso: " + aluno.getCurso());
            System.out.println("Telefone: " + aluno.getTelefone());
            System.out.println("Notas: " + Arrays.toString(aluno.getNotas()));
            System.out.println("Número de Faltas: " + aluno.getNumeroDeFaltas());
            System.out.println("Status de Aprovação: " + aluno.alunoFoiAprovado());
            System.out.println("Percentual de faltas: " + aluno.calcularPercentualDeFalta());
            System.out.println("------------------------");
        }
    }
}
