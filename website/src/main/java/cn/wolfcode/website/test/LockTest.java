package cn.wolfcode.website.test;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Apple implements Runnable {
    private int num = 50;
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        eating();
    }

    private void eating() {
        for (int i = 0; i < 50; i++) {
//            lock.lock();
            if (num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "吃了的苹果编号: " + num--);
            }
//            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Apple a = new Apple();
        new Thread(a, "littleA").start();
        new Thread(a, "littleB").start();
        new Thread(a, "littleC").start();
    }
}


public class LockTest {
    @Test
    public void test() {
        Apple a = new Apple();
        new Thread(a, "littleA").start();
        new Thread(a, "littleB").start();
        new Thread(a, "littleC").start();
    }
}

/*SqlBuilder handleSql = sql;
handleSql.appendSql(" LIMIT ").appendValue((head - 1) * pageSize).appendSql(",").appendValue(pageSize);
List<MasterInfo> masterInfoList = jdbcTemplate.queryForList(handleSql.getSql(), MasterInfo.class, handleSql.getValues());*/
