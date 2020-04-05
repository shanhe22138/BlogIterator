package com.blog.Mapper;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shanhe
 * @className SynchronizedExample
 * @date 2020-03-29 21:27
 **/
public class SynchronizedExample/* implements Comparable */{

    private int d = 0;

    public SynchronizedExample() {

    }

    public SynchronizedExample(int d) {
        this.d = d;
    }

    public void func1() {
        synchronized (this) {
            for(int i = 0; i < 10; i++) {
                System.out.println(i+ " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> e1.func1());
        executorService.execute(()-> e1.func1());
        SynchronizedExample e2 = new SynchronizedExample(2);
        SynchronizedExample[] e = new SynchronizedExample[2];
        e[0] = e1;
        e[1] = e2;
        //Arrays.sort(e);
        Arrays.sort(e, (o1, o2)->((SynchronizedExample)o1).d-((SynchronizedExample)o2).d);
        for (SynchronizedExample x:
             e) {
            System.out.println(x.d);
        }
        try{
            for(int i = 0; i < 10; i++) {
                System.out.println(e[i].d);
            }
        } catch (Throwable a) {
            System.out.println("success");
            a.printStackTrace();
        }
    }

//    @Override
//    public int compareTo(Object e) {
//        return this.d-((SynchronizedExample)e).d;
//    }
}
