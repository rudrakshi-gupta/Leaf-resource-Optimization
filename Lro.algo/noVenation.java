package lro.algo;

protected class noVenation{
    private long net;
    private long storage;
    private long mem;
    private long pp;
    private long ma;

    protected void noVenation(long[] data,long[] t){
        this.net = data[0];
        this.storage = data[1];
        this.mem = data[2];
        this.pp = data[3];
        this.ma = data[4];

        checkP(net,storage,mem,pp,ma,t);
    }

    private boolean checkForEnoughMemory(int mem,int t){
        if(mem<t){
            return false;
        }
        return true;
    }
    private boolean checkForEnoughStorage(int size,int t){
        //Windows
        // File file = new File("C:\\");
          
        // double size = file.getFreeSpace() / (1024.0 * 1024 * 1024);
        // // System.out.printf( "%.3f GB\n", size);
        if(size<t){
            return false;
        }
        return true;
    }
    private boolean checkForAutomation(){
        boolean deviceAttached = true;
        boolean automationPossible = true;
        if(deviceAttached && automationPossible){
            return true;
        }
        return false;
    }
    public void Thread(){
        System.out.println("--------------------------------------Thread generation with highest PRIORITY-----------------------------------------------");
    }
    public int scaleAutomatically(){
        storage = storage*2;
        System.out.println("Automation Successful.\nDevice attached.");
        return storage;
    }
    public int spaceAllocation(int mem,int storage){
        mem = mem + storage/3;
        System.out.println("Virtal Memory Created.");
        return mem;
    }
    public void storingTasksInMemory(){
        System.out.println("Data stored in Memory in Progress..........");
    }

    private void checkP(long net,long storage,long mem,long pp,long ma,long[] t){
        int[] priorityArray = {3,1,2,4,5};
        if(net<t[0]){
            boolean em = checkForEnoughMemory(mem,t[2]);//--->(mem<t[2])
            if(!em){
                memScarcity(mem,storage);
            }
            netScarcity();
        }
        if(mem<t[2]){
            boolean es = checkForEnoughStorage(storage,t[1]);//--->(storage<t[1])
            if(!es){
                storeScarcity(storage);
            }
            memScarcity(mem,storage);
        }
        if(storage<t[1]){
            storeScarcity(storage);
        }
        if(pp<t[4]){
            processingPowerScarcity(pp);
        }
    }

    private void netScarcity(){
        //thread generation
        //assigning priority
        Thread();
        //Storing
        storingTasksInMemory();
    }
    private void memScarcity(int mem,int storage){
        boolean es = checkForEnoughStorage(storage,t[1]);//--->(storage<t[1])
        if(!es){
            storeScarcity(storage);
        }
        //thread generation
        //assigning priority
        Thread();
        //using some space from storage as memory(creation of virtual memory)
        spaceAllocation(mem,storage);
    }
    private void storeScarcity(int storage){
        boolean auto = checkForAutomation();
        if(auto){
            //thread generation
            //assigning priority
            Thread();
            scaleAutomatically(storage);
        }
        else{
            // suspend Process Or Thread and Notify User
            System.err.println("NOTIFICATION:\nPlease attached a storage device and enable its automation!!");
            //terminate program
        }
    }
    private int processingPowerScarcity(int pp){
        // pp = random
        //thread generation
        //assigning priority
        Thread();
        // checkForProcessesRunning();
        System.out.println("Checking for process currently running........");
        // extractLowPriorityProcesses();
        System.out.println("Low level priority process/thread extracted!!");
        // suspendProcessOrThread();
        System.out.println("Suspension Successful.");
        // powerManagement();
        System.out.println("Power Management in process........\nBalanced mode ON.");
        // runImortantTasks();
        System.out.println("Execution of Important Tasks in progress........");
        return pp;
    }

}