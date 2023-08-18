package Fui.com.github.www;
import java.util.Scanner;

public class Fui {
    public static void main(String[] args) {
        /** Chama o Scanner */
        Scanner turbao = new Scanner(System.in);

        /** Captura os Dados do Motor */
        System.out.println();
        System.out.print("Digite o Diametro do Pistao: ");
        float diametroPistao = turbao.nextFloat();
        System.out.print("Digite o Curso do Pistao: ");
        float cursoPistao = turbao.nextFloat();
        System.out.print("Digite quantos cilindros tem seu veiculo: ");
        int nCilindros = turbao.nextInt();
        System.out.print("Digite a Espessura da Junta de Cabeçote em mm: ");
        float mmJuntaCabeçote = turbao.nextFloat();
        System.out.print("Digite a Taxa de Compressao Desejada: ");
        float txCompressaoDesejada = turbao.nextFloat();
        System.out.print("Digite a Taxa de Compressao Atual: ");
        float txCompressaoAtual = turbao.nextFloat();

        /** Calcula o Raio do Pistão*/
        float raioPistao = diametroPistao / 2;

        /** Faz o Calculo de Cilindrada e Area do Pistão */
        float pi = 3.141592F;
        float volumePistao = raioPistao * raioPistao * cursoPistao * pi / 1000 ;
        float cilindrada =  volumePistao * nCilindros;
        float areaPistao = raioPistao * raioPistao * pi;

        /** Calcula a Area da Junta */
        float areaJunta = areaPistao * mmJuntaCabeçote / 1000;

        /** Calcula o Volume da Camera Desejado */
        float volCameraDesejado = volumePistao / (txCompressaoDesejada - 1);
        float volCameraDesejadoCorr = volCameraDesejado - areaJunta;

        /** Calcula o Volume da Camera Atual */
        float volCameraAtual = volumePistao / (txCompressaoAtual - 1);
        float volCameraAtualCorr = volCameraAtual - areaJunta;

        /** Calcula o Valor da Camera em cm */
        double cameraAtual = Math.cbrt(volCameraAtualCorr);
        double cameraDesejada = Math.cbrt(volCameraDesejadoCorr);
        System.out.println(volCameraAtualCorr);
        System.out.println(volCameraDesejadoCorr);

        /** Calcula o quanto tem que rebaixar */
         float cabecote = (float) ((cameraAtual - cameraDesejada) * 10);

        /** Printa na Tela os Resultados **/
        System.out.println();
        System.out.println("*********** RESULTADOS ***********");
        System.out.println();
        System.out.println("O valor da cilindrada é: " + cilindrada);
        System.out.println("Sua taxa de Compressão atual é: " + txCompressaoAtual);
        System.out.println("A sua Taxa da Compressão desejada é: " + txCompressaoDesejada);
        System.out.println("Rebaixe o cabeçote em: " + cabecote + " mm");
        System.out.println();
        System.out.println("*********** PAULO HENRIQUE AZEVEDO DO NASCIMENTO ***********");
    }
}
