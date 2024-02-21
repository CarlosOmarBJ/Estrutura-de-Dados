public class EncontrarMenorMaior {

    public static void main(String[] args) {
        int[] numeros = new int[10];

        cadastrarNumeros(numeros);
        ordenarNumeros(numeros);

        int menorNumero = numeros[0];
        int contMenor = contarOcorrencias(numeros, menorNumero);

        System.out.println("Menor número: " + menorNumero);
        System.out.println("Quantidade de vezes que aparece: " + contMenor);

        int maiorNumero = numeros[numeros.length - 1];
        int contMaior = contarOcorrencias(numeros, maiorNumero);

        System.out.println("\nMaior número: " + maiorNumero);
        System.out.println("Quantidade de vezes que aparece: " + contMaior);
    }

    private static void cadastrarNumeros(int[] numeros) {
        System.out.println("Digite 10 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = new java.util.Scanner(System.in).nextInt();
        }
    }

    private static void ordenarNumeros(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
    }

    private static int contarOcorrencias(int[] numeros, int numero) {
        int cont = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                cont++;
            }
        }
        return cont;
    }
}
