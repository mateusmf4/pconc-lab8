import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorPalavras2 {
    public static final AtomicInteger total = new AtomicInteger(0);
    public static void main(String[] args) throws Exception {
	    System.out.println("Lab8");
        List<Thread> threads = new ArrayList<>();
        for (String file : args) {
            Thread t = new Thread(() -> {
                try {
                    total.addAndGet(contarPalavras(file));
                } catch (Exception e) {
                    System.err.println("oops");
                }
            });
            t.start();
            threads.add(t);
        }
        for (Thread t : threads) {
            t.join();
        }
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

