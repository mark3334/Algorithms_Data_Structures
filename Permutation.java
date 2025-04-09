import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int numWords = 0;
        String word;
        while (!StdIn.isEmpty()) {
            word = StdIn.readString();
            numWords++;
            if (numWords <= k) {
                rq.enqueue(word);
            }
            else if (StdRandom.bernoulli((double) k / (numWords))) {
                rq.dequeue();
                rq.enqueue(word);
            }

        }
        for (String s : rq) {
            System.out.println(s);
        }
    }
}