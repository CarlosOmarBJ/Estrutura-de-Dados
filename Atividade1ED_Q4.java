class Aluno {
    String nome;
    double nota1;
    double nota2;

    Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    double getMediaPonderada() {
        return (nota1 * 2 + nota2 * 3) / 5;
    }
}

class CadastroAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aluno[] alunos = new Aluno[8];

        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno(scanner.nextLine(), scanner.nextDouble(), scanner.nextDouble());
            scanner.nextLine();
        }

        Arrays.sort(alunos, (a1, a2) -> Double.compare(a2.getMediaPonderada(), a1.getMediaPonderada()));
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.nome + ", Média Ponderada: " + aluno.getMediaPonderada());
        }

        Arrays.sort(alunos, (a1, a2) -> Double.compare(a1.nota1, a2.nota1));
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.nome + ", Nota 1: " + aluno.nota1);
        }

        Arrays.sort(alunos, (a1, a2) -> a1.nome.compareToIgnoreCase(a2.nome));
        for (Aluno aluno : alunos) {
            if (aluno.getMediaPonderada() < 7) {
                System.out.println("Nome: " + aluno.nome + ", Média Ponderada: " + aluno.getMediaPonderada());
            }
        }

        scanner.close();
    }
}
