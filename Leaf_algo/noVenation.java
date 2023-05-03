import java.io.File;

public class noVenation {
    private int net;
    private int storage;
    private int mem;
    private int pp;
    private int ma;

    private int[] arr;

    public  noVenation(int[] p,int choose) {
        this.arr = p;
        this.net = p[0];
        this.storage = p[1];
        this.mem = p[2];
        this.pp = p[3];
        this.ma = p[4];

        checkP(net,storage,mem,pp,ma,choose);
    }

    private boolean checkForEnoughMemory(int mem,int t){
        long totalmem = Runtime.getRuntime().totalMemory();
        if(mem<t && totalmem>0){
            System.out.println("----------FOUND MEMORY SCARCITY----------");
            return false;
        }
        return true;
    }
    private boolean checkForEnoughStorage(int size,int t){
        if(size<t){
            System.out.println("----------FOUND STORAGE SCARCITY----------");
            return false;
        }
        return true;
    }
    private boolean checkForAutomation(){
        File f = new File("C:\\Users\\shamb\\Desktop\\program.txt");
        long var = f.getTotalSpace();
        boolean deviceAttached = false;
        boolean automationPossible = false;
        if(var>0){
            deviceAttached = true;
            automationPossible = true;
        }
        if(deviceAttached && automationPossible){
            return true;
        }
        return false;
    }
    public void Thread(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        System.out.println("--------------------------------------Thread generated with highest PRIORITY-----------------------------------------------");
    }
    public int scaleAutomatically(int storage,int c){
        storage = c;
        System.out.println("Automation Successful.\nDevice attached.");
        return storage;
    }
    public int spaceAllocation(int mem,int c){
        mem = c;
        System.out.println("Virtal Memory Created.");
        return mem;
    }
    public int storingTasksInMemory(int net,int c){
        //Cache the data use ecache
        var myCache = new MyCache();
        myCache.Add("myKey", "myValue");
        net = c;
        System.out.println("Data stored in Memory in Progress..........");

        return net;
    }

    private void checkP(int net,int storage,int mem,int pp,int ma,int c){
        int[] priorityArray = {3,1,2,4,5};
        if(net<c){
            System.out.println("----------FOUND NETWORK SCARCITY----------");
            boolean em = checkForEnoughMemory(mem,c);//--->(mem<t[2])
            if(!em){
                mem = memScarcity(mem,storage,c);
            }
            net = netScarcity(net,c);
        }
        if(mem<c){
            System.out.println("----------FOUND MEMORY SCARCITY----------");
            boolean es = checkForEnoughStorage(storage,c);//--->(storage<t[1])
            if(!es){
                storage = storeScarcity(storage,c);
            }
            mem = memScarcity(mem,storage,c);
        }
        if(storage<c){
            System.out.println("----------FOUND STORAGE SCARCITY----------");
            storage = storeScarcity(storage,c);
        }
        if(pp<c){
            System.out.println("----------FOUND PROCESSING POWER SCARCITY----------");
            pp = processingPowerScarcity(pp,c);
        }

        if(net>=c & mem>=c & storage>=c & pp>=c){
            System.out.println("New Adjustments made.......");
            System.out.println("New Network : "+ net);
            arr[0] = net;
            System.out.println("New Memory : "+ mem);
            arr[1] = mem;
            System.out.println("New Storage : "+ storage);
            arr[2] = storage;
            System.out.println("New Processing Power : "+ pp);
            arr[3] = pp;
            System.out.println("Management : "+ ma);
            System.out.println("Everythiong OK!!");
        }
    }

    private int netScarcity(int net,int c){
        //thread generation
        //assigning priority
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread NETWORK!!");
            }
        };
        Thread(myRunnable);
        //Storing
        net = storingTasksInMemory(net,c);
        return net;
    }
    private int memScarcity(int mem,int storage,int c){
        boolean es = checkForEnoughStorage(storage,c);//--->(storage<t[1])
        if(!es){
            storage = storeScarcity(storage,c);
        }
        //thread generation
        //assigning priority
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread MEMORY!!");
            }
        };
        Thread(myRunnable);
        //using some space from storage as memory(creation of virtual memory)
        mem = spaceAllocation(mem,c);
//        System.out.println("New Memory : "+ mem);

        return mem;
    }
    private int storeScarcity(int storage,int c){
        boolean auto = checkForAutomation();
        if(auto){
            //thread generation
            //assigning priority
            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread STORAGE!!");
                }
            };
            Thread(myRunnable);
            storage = scaleAutomatically(storage,c);
        }
        else{
            // suspend Process Or Thread and Notify User
            System.err.println("NOTIFICATION:\nPlease attached a storage device and enable its automation!!");
            //terminate program
        }
        return storage;
    }
    private int processingPowerScarcity(int pp,int c){
        // pp = random
        //thread generation
        //assigning priority
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread PROCESSING POWER!!");
            }
        };
        Thread(myRunnable);
        pp=c;
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
