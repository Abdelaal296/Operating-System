import java.util.ArrayList;
import java.util.Vector;

public class FirstFit {
    public ArrayList<Process> processes;
    public Vector<Partition> partitions;
    public int currentSize;

    public FirstFit(ArrayList<Process> pr, ArrayList<Partition> pa) {
        processes=new ArrayList<>();
        partitions=new Vector<>();
        processes.addAll(pr);
        partitions.addAll(pa);
        currentSize=partitions.size();
    }
    public void firstFit(){
        for (int i=0;i<processes.size();i++){
            if(processes.get(i).isAllocated)continue;
            for (int j=0;j<partitions.size();j++){
                if(partitions.get(j).isBusy()) continue;
                if(processes.get(i).size<=partitions.get(j).size){
                    partitions.get(j).setProcessName(processes.get(i).getName());
                    partitions.get(j).setBusy(true);
                    processes.get(i).setAllocated(true);
                    if(partitions.get(j).size-processes.get(i).size>0){
                        String s="Partition "+currentSize;
                        int si=partitions.get(j).size-processes.get(i).size;
                        Partition p=new Partition(s,si);
                        partitions.get(j).size=processes.get(i).size;
                        partitions.insertElementAt(p,j+1);
                        currentSize++;
                    }
                    break;
                }
            }
        }
    }

    public void result(){
        firstFit();
        for (int i=0;i<partitions.size();i++){
            if(!partitions.get(i).isBusy()){
                partitions.get(i).setProcessName("External fragment");
            }
        }
        for (int i=0;i<partitions.size();i++){
            System.out.println(partitions.get(i).name+" ("+partitions.get(i).size+" KB) --> "+partitions.get(i).processName);
        }
        System.out.println();
        for (int i=0;i<processes.size();i++){
            if(!processes.get(i).isAllocated){
                System.out.println(processes.get(i).name+" can not be allocated");
            }
        }
        System.out.println("-------------------------------------------------------------");
    }
    public void compact(){
        int compactSize=0;
        String s="Partition "+currentSize;
        currentSize++;
        for (int i=0;i<partitions.size();i++){
            if(!partitions.get(i).isBusy()){
                compactSize+=partitions.get(i).size;
                partitions.remove(i);
                i--;
            }
        }
        Partition p=new Partition(s,compactSize);
        partitions.add(p);
        firstFit();
       result();
    }
}
