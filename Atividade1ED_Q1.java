class Funcionario {
    String nome;
    double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
}

public class OrdenacaoFuncionarios {

    public static void main(String[] args) {
        Funcionario[] funcionarios = cadastrarFuncionarios();

        System.out.println("a) Em ordem crescente de salário:");
        ordenarPorSalarioCrescente(funcionarios);
        exibirFuncionarios(funcionarios);

        System.out.println("\nb) Em ordem decrescente de salário:");
        ordenarPorSalarioDecrescente(funcionarios);
        exibirFuncionarios(funcionarios);

        System.out.println("\nc) Em ordem alfabética:");
        ordenarPorNome(funcionarios);
        exibirFuncionarios(funcionarios);
    }

    private static Funcionario[] cadastrarFuncionarios() {
        return new Funcionario[]{
            new Funcionario("Alice", 5000.0),
            new Funcionario("Bob", 4500.0),
            new Funcionario("Charlie", 6000.0),
            new Funcionario("David", 5200.0),
            new Funcionario("Eva", 4800.0)
        };
    }

    private static void ordenarPorSalarioCrescente(Funcionario[] funcionarios) {
        Arrays.sort(funcionarios, Comparator.comparingDouble(f -> f.salario));
    }

    private static void ordenarPorSalarioDecrescente(Funcionario[] funcionarios) {
        Arrays.sort(funcionarios, (f1, f2) -> Double.compare(f2.salario, f1.salario));
    }

    private static void ordenarPorNome(Funcionario[] funcionarios) {
        Arrays.sort(funcionarios, Comparator.comparing(f -> f.nome));
    }

    private static void exibirFuncionarios(Funcionario[] funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.nome + ", Salário: " + funcionario.salario);
        }
    }
}
