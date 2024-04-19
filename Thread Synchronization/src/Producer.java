import static java.lang.Math.sqrt;

public class Producer implements Runnable{
    public  int  N;
    public  boolean is_prime[];
    protected static int counter;
    Buffer b;
    Producer(Buffer b,int n){
        this.N=n;
        this.b=b;
        counter=0;
        is_prime=new boolean[N+5];
        for (int i = 2; i < N; ++i) {
            is_prime[i] = true;
        }
        for (int i = 2; i <= sqrt(N); ++i) {
            if (!is_prime[i])continue;
            for (int j = 2 * i; j < N; j += i) {
                is_prime[j] = false;
            }
        }
        for (int i = 1; i <= N; ++i) {
            if(is_prime[i]){
                counter++;
            }
        }
    }
    public void run(){

        for (int i = 2; i <= N; ++i) {
            if(is_prime[i]){
                    b.push(i);
            }
        }

    }
}
