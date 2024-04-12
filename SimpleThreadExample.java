public class SimpleThreadExample {

    private final Object lock = new Object();  // 用于线程同步的对象
    private boolean ready = false;  // 用于线程同步的标志

    public void runTask() throws InterruptedException {
        System.out.println("work Thread is starting...");
        synchronized (lock) {  //如果没有锁，就会进入BLOCKED状态，等待获取锁
            //如果得到锁，调用wait方法，线程进入WAITING状态
            ready = true;
            System.out.println("work Thread is now waiting on lock object");
            lock.wait(); // 线程的等待状态（WAITING）
        }
        System.out.println("work Thread is out of the waiting loop");
    }

    public void mainMethod(){
        System.out.println("Main thread is starting...");
        Thread workerThread = new Thread(() -> {
            try {
                runTask();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });  // 线程的新建状态（NEW）
        workerThread.start(); // 线程的就绪状态（RUNNABLE）

        // Simulate some work
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is signaling the worker thread to exit");
        synchronized (lock) {
            ready = false;
            lock.notify(); // Moves the worker thread from WAITING to RUNNABLE
        }

        // Wait for the worker thread to finish
        try {
            workerThread.join();  // 等待workerThread线程结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is now TERMINATED");
    }

    public static void main(String[] args) {
        new SimpleThreadExample().mainMethod();

    }

}

//public class SimpleThreadExample {
//    public static void main(String[] args) {
//        // 创建一个实现了Runnable接口的SimpleTask类实例
//        SimpleTask task = new SimpleTask();
//
//        // 创建一个Thread对象，将SimpleTask实例作为目标（Runnable）传递给它
//        Thread thread = new Thread(task);
//
//        // 启动线程
//        thread.start();
//
//        // 为了观察线程的执行，这里简单地让主线程休眠一段时间
//        try {
//            Thread.sleep(1000); // 休眠1秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Main thread is finishing its execution.");
//    }
//
//    // 一个实现了Runnable接口的内部类，用于执行具体的任务
//    static class SimpleTask implements Runnable {
//        @Override
//        public void run() {
//            for (int i = 1; i <= 10; i++) {
//                System.out.println("Thread is printing: " + i);
//            }
//        }
//    }
//}
