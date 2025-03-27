import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorPalavras3 {
    public static final AtomicInteger total = new AtomicInteger(0);
    public static void main(String[] args) throws Exception {
	    System.out.println("Lab8");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (String file : args) {
            executor.execute(() -> {
                try {
                    total.addAndGet(contarPalavras(file));
                } catch (Exception e) {
                    System.err.println("oops");
                }
            });
        }

        executor.shutdown();
        // uai
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("Palavras total: " + total.get());
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

