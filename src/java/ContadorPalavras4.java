import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ContadorPalavras4 {
    public static void main(String[] args) throws Exception {
	    System.out.println("Lab8");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<Integer>> futures = new ArrayList<>();
        for (String file : args) {
            Future<Integer> future = executor.submit(() -> {
                try {
                    return contarPalavras(file);
                } catch (Exception e) {
                    System.err.println("oops");
                    return 0;
                }
            });
            futures.add(future);
        }

        int total = 0;
        for (Future<Integer> future : futures) {
            total += future.get();
        }
        
        executor.shutdown();

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

