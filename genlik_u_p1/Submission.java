
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Submission {

    public static void main(String[] args) {
        try {
            BufferedReader bufRead = new BufferedReader(new FileReader("input.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("output.txt"), true); 
            
            String line;

            line = bufRead.readLine();

            while (line != null) {
                String[] v = line.split(" ");
                int nj = Integer.valueOf(v[0]);
                int Wj = Integer.valueOf(v[1]);

                int wi[] = new int[nj];
                int pi[] = new int[nj];

                for (int i = 0; i < nj; i++) {
                    line = bufRead.readLine();
                    v = line.split(" ");
                    wi[i] = Integer.valueOf(v[0]);
                    pi[i] = Integer.valueOf(v[1]);
                }

                long startTime = System.nanoTime();
                int best = solve(nj, Wj, wi, pi);
                long estimatedTime = System.nanoTime() - startTime;

                pw.println(nj + " " + best + " " + (estimatedTime / 1000000000));

                line = bufRead.readLine();
            }

            bufRead.close();
            pw.close();
            
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static int solve(int nj, int Wj, int[] wi, int[] pi) {
        BigInteger last = BigInteger.ONE.shiftLeft(nj);
        int bestProfit = -1;
        
        
        

        for (BigInteger i = BigInteger.ZERO; i.compareTo(last) < 0; i = i.add(BigInteger.ONE)) {
            int totalWeight = 0;
            int totalProfit = 0;
            for (int j = 0; j < nj; j++) {
                if (i.testBit(j)) {
                    totalWeight += wi[j];
                    totalProfit += pi[j];
                }
            }
            if (totalWeight <= Wj) {
                if (totalProfit > bestProfit) {
                    bestProfit = totalProfit;
                }
            }
        }

        return bestProfit;
    }
}
