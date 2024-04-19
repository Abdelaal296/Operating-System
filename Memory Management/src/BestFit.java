import java.util.ArrayList;
import java.util.Vector;

public class BestFit {
    public ArrayList<Process> processes;
    public Vector<Partition> partitions;
    public int currentSize;

    public BestFit(ArrayList<Process> pr, ArrayList<Partition> pa) {
        processes=new ArrayList<>();
        partitions=new Vector<>();
        processes.addAll(pr);
        partitions.addAll(pa);
        currentSize=partitions.size();
    }

    public void bestFit(){

        for (int i=0;i<processes.size();i++){
            if(processes.get(i).isAllocated)continue;
            int mn=Integer.MAX_VALUE,pos=0;
            for (int j=0;j<partitions.size();j++){
                if(partitions.get(j).isBusy()) continue;
                if(processes.get(i).size<=partitions.get(j).size){
                    if(partitions.get(j).size-processes.get(i).size<mn){
                        mn=partitions.get(j).size-processes.get(i).size;
                        pos=j;
                    }
                }
            }
            partitions.get(pos).setProcessName(processes.get(i).getName());
            partitions.get(pos).setBusy(true);
            processes.get(i).setAllocated(true);
            if(partitions.get(pos).size-processes.get(i).size>0){
                String s="Partition "+currentSize;
                int si=partitions.get(pos).size-processes.get(i).size;
                Partition p=new Partition(s,si);
                partitions.get(pos).size=processes.get(i).size;
                partitions.insertElementAt(p,pos+1);
                currentSize++;
            }
        }
    }
    public void result(){
        bestFit();
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
        bestFit();
        result();
    }
}
