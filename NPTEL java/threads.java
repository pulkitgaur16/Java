public class threads {
    static class ThreadA extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("ThreadA: Sending email " + i);
            try {
                sleep(500); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println("ThreadA interrupted");
            }
        }
        System.out.println("ThreadA: Finished sending emails.");
    }
}

static class ThreadB extends Thread {
    public void run() {
        for (int j = 1; j <= 5; j++) {
            System.out.println("ThreadB: Syncing contacts " + j);
            try {
                sleep(700); // Simulate longer delay
            } catch (InterruptedException e) {
                System.out.println("ThreadB interrupted");
            }
        }
        System.out.println("ThreadB: Finished syncing contacts.");
    }
}

static class ThreadId extends Thread{
    public void run(){
        try {
            System.out.println("Thread "+ Thread.currentThread().getId()+ " is running");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}

    public static void main(String[] args) {
        // MultiThreadDemo 

        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();

        System.out.println("Main thread: Gmail tasks started...");

        a.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(b.getPriority()+1); // random priority

        // getId() method

        int n=8; // no. of threads
        for(int i=0;i<8;i++){
            ThreadId object= new ThreadId();
            object.setPriority(Thread.MIN_PRIORITY);
            object.start();
        }

        a.start();
        b.start();
    }
}
