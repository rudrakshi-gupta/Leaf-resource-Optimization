// package lro.algo;

public class noVenation{
    private long net;
    private long storage;
    private long mem;
    private long pp;
    private long ma;

    public noVenation(long[] data, long[] threshold) {
        this.net = data[0];
        this.storage = data[1];
        this.mem = data[2];
        this.pp = data[3];
        this.ma = data[4];

        checkP(net,storage,mem,pp,ma,threshold);
    }

    private boolean checkForEnoughMemory(long mem,long t){
        if(mem<t){
            System.out.println("----------FOUND MEMORY SCARCITY----------");
            return false;
        }
        return true;
    }
    private boolean checkForEnoughStorage(long size,long t){
        if(size<t){
            System.out.println("----------FOUND STORAGE SCARCITY----------");
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
    public long scaleAutomatically(long storage){
        storage = storage*2;
        System.out.println("Automation Successful.\nDevice attached.");
        return storage;
    }
    public long spaceAllocation(long mem,long storage){
        mem = mem + storage/3;
        System.out.println("Virtal Memory Created.");
        return mem;
    }
    public void storingTasksInMemory(){
        System.out.println("Data stored in Memory in Progress..........");
    }

    private void checkP(long net,long storage,long mem,long pp,long ma,long[] threshold){
        long[] priorityArray = {3,1,2,4,5};
        if(net<threshold[0]){
            System.out.println("----------FOUND NETWORK SCARCITY----------");
            boolean em = checkForEnoughMemory(mem,threshold[2]);//--->(mem<t[2])
            if(!em){
                memScarcity(mem,storage,threshold);
            }
            netScarcity();
        }
        if(mem<threshold[2]){
            System.out.println("----------FOUND MEMORY SCARCITY----------");
            boolean es = checkForEnoughStorage(storage,threshold[1]);//--->(storage<t[1])
            if(!es){
                storeScarcity(storage);
            }
            memScarcity(mem,storage,threshold);
        }
        if(storage<threshold[1]){
            System.out.println("----------FOUND STORAGE SCARCITY----------");
            storeScarcity(storage);
        }
        if(pp<threshold[4]){
            System.out.println("----------FOUND PROCESSING POWER SCARCITY----------");
            processingPowerScarcity(pp);
        }

        if(net>=threshold[0] & mem>=threshold[2] & storage>=threshold[1] & pp>=threshold[4]){
            System.out.println("Everythiong OK!!");
        }
    }

    private void netScarcity(){
        //thread generation
        //assigning priority
        Thread();
        //Storing
        storingTasksInMemory();
    }
    private void memScarcity(long mem,long storage,long[] threshold){
        boolean es = checkForEnoughStorage(storage,threshold[1]);//--->(storage<t[1])
        if(!es){
            storeScarcity(storage);
        }
        //thread generation
        //assigning priority
        Thread();
        //using some space from storage as memory(creation of virtual memory)
        spaceAllocation(mem,storage);
    }
    private void storeScarcity(long storage){
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
    private long processingPowerScarcity(long pp){
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