import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Consumer implements Runnable{
    Buffer b;
    FileWriter myWriter;
    BufferedWriter writer;
    static int largest;
    Consumer(Buffer b,String fileName){
        this.b=b;
        try {
            writer=new BufferedWriter( new FileWriter(fileName));
        }catch (IOException e){}
    }
    public void run(){
        for(int i=1;i<=Producer.counter;i++) {
            try {
                int x = b.pop();
                largest=x;
                String s = String.valueOf(x);
                writer.write(s);
                writer.write(" ,");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
