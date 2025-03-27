import java.io.*;
import java.util.concurrent.*;

public class ContadorPalavras {
    public static void main(String[] args) throws Exception {
	    System.out.println("Lab8");
        int total = 0;
        for (String file : args) {
            total += contarPalavras(file);
        }
        System.out.println("Palavras total: " + total);
    }

    static int contarPalavras(String nomeArquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        int count = 0;
        String linha;
        while ((linha = br.readLine()) != null) {
            count += linha.split("\\s+").length;
        }
        br.close();
        return count;
    }
}

