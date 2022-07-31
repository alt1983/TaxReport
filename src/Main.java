import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    private static LongAdder report;

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static void main(String[] args) throws InterruptedException {

        report = new LongAdder();
        final int MINSALE = 1;
        final int MAXSALE = 100;
        final int SALESNUMBER = 3;
        final int SHOPSNUMBER = 3;
        List<Thread> threadList = new ArrayList<>();
        for(int i=1;i<=SHOPSNUMBER;i++){
            final Thread shop = new Thread(null, new Shop("Магазин"+i, MINSALE, MAXSALE, SALESNUMBER, report));
            threadList.add(shop);
            shop.start();
        }
        for(Thread thread: threadList){
            thread.join();
        }


        //final Thread shop1 = new Thread(null, new Shop("Магазин1", MINSALE, MAXSALE, SALESNUMBER, report));
        //final Thread shop2 = new Thread(null, new Shop("Магазин2", MINSALE, MAXSALE, SALESNUMBER, report));
        //final Thread shop3 = new Thread(null, new Shop("Магазин3", MINSALE, MAXSALE, SALESNUMBER, report));

//        shop1.start();
//        shop2.start();
//        shop3.start();
//        shop1.join();
//        shop2.join();
//        shop3.join();
        System.out.println("Итоговый результат: " + report);
    }

}
