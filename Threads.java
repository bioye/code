/*
 * Ways to instantiate a thread.
 * Thread.wait, join
 * volatile - to prevent caching in thread & keep 1 copy in main
 * synchronized - race conditions, only a thread can access block - slower. default lock
 * multiple locks
 */
public class Threads extends Thread{

    public static void main(String[] args) {
        System.out.println("Main.");

        Threads thread = new Threads();
        thread.start();

        Thread thread2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                System.out.println("In second thread");
                for (int i = 0; i < 1000; i++) {
                    count1++;
                }
            }
        });
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println("thread 1 count: " + count1);
        System.out.println("thread 2 count: " + count2);
    }

    public void run(){
        System.out.println("In first thread");
        for (int i = 0; i < 1000; i++) {
            count2++;
        }
    }
    static int count1, count2 = 0;
}