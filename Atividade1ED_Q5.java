import java.util.Arrays;

class CadastroNumeros {

    public static void main(String[] args) {
        int[] numeros = {5, 8, 2, 14, 7, 9, 1, 11, 3, 6, 13, 4, 10, 12, 15};

        Arrays.sort(numeros);

        int numeroBuscadoSequencial = 14;
        int posicaoSequencial = -1;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroBuscadoSequencial) {
                posicaoSequencial = i;
                break;
            }
        }

        exibirResultado("Busca Sequencial", posicaoSequencial);

        // Busca binária
        int numeroBuscadoBinaria = 7;
        int inicio = 0;
        int fim = numeros.length - 1;
        int posicaoBinaria = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (numeros[meio] == numeroBuscadoBinaria) {
                posicaoBinaria = meio;
                break;
            } else if (numeros[meio] < numeroBuscadoBinaria) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        exibirResultado("Busca Binária", posicaoBinaria);
    }

    private static void exibirResultado(String tipoBusca, int posicao) {
        if (posicao != -1) {
            System.out.println(tipoBusca + ": O número está no vetor, na posição " + posicao + ".");
            System.out.println("A posição é " + (posicao % 2 == 0 ? "par." : "ímpar."));
        } else {
            System.out.println(tipoBusca + ": O número não está no vetor.");
        }
    }
}
