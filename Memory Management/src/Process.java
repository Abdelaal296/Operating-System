public class Process {
    public String name;
    public int size;
    public boolean isAllocated;

    public Process(String name, int size) {
        this.name = name;
        this.size = size;
        this.isAllocated=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void setAllocated(boolean allocated) {
        isAllocated = allocated;
    }

}
