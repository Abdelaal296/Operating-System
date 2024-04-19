import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Partition> pa=new ArrayList<>();
        ArrayList<Process> pr=new ArrayList<>();
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter number of partition: ");
//        int n=sc.nextInt();
//        for (int i=0;i<n;i++){
//            System.out.println("Enter partition and his size: ");
//            String name=sc.next();
//            int size= sc.nextInt();
//            Partition p=new Partition(name,size);
//            pa.add(p);
//        }
//        System.out.println("Enter number of processes: ");
//        int np=sc.nextInt();
//        for (int i=0;i<np;i++){
//            System.out.println("Enter process and his size: ");
//            String name=sc.next();
//            int size= sc.nextInt();
//            Process p=new Process(name,size);
//            pr.add(p);
//        }
//        System.out.println("Select the policy you want to apply:\n" +
//                "1. First fit\n" +
//                "2. Best fit\n" +
//                "3. Worst fit");
//        int policy=sc.nextInt();
//        if (policy==1){
//            FirstFit ff=new FirstFit(pr,pa);
//            ff.result();
//            System.out.println("Do you want to compact? 1.yes 2.no");
//            int ch=sc.nextInt();
//            if(ch==1)ff.compact();
//        }else if(policy==2){
//            BestFit bf=new BestFit(pr,pa);
//            bf.result();
//            System.out.println("Do you want to compact? 1.yes 2.no");
//            int ch=sc.nextInt();
//            if(ch==1)bf.compact();
//        }else{
//            WorstFit wf=new WorstFit(pr,pa);
//            wf.result();
//            System.out.println("Do you want to compact? 1.yes 2.no");
//            int ch=sc.nextInt();
//            if(ch==1)wf.compact();
//        }
        Partition p1=new Partition("Partition 0",90);
        pa.add(p1);
        Partition p2=new Partition("Partition 1",20);
        pa.add(p2);
        Partition p3=new Partition("Partition 2",5);
        pa.add(p3);
        Partition p4=new Partition("Partition 3",30);
        pa.add(p4);
        Partition p5=new Partition("Partition 4",120);
        pa.add(p5);
        Partition p6=new Partition("Partition 5",80);
        pa.add(p6);

        Process pp1=new Process("Process 1",15);
        pr.add(pp1);
        Process pp2=new Process("Process 2",90);
        pr.add(pp2);
        Process pp3=new Process("Process 3",30);
        pr.add(pp3);
        Process pp4=new Process("Process 4",100);
        pr.add(pp4);

        FirstFit ff=new FirstFit(pr,pa);
        BestFit bf=new BestFit(pr,pa);
        WorstFit wf=new WorstFit(pr,pa);
        ff.result();
        ff.compact();
    }
}
