import java.util.concurrent.atomic.LongAdder;

public class Shop extends Thread {

    private int minSale;
    private int maxSale;
    private int salesNumber;
    private LongAdder report;

    public Shop(String name, int minSale, int maxSale, int salesNumber, LongAdder report) {
        this.setName(name);
        this.maxSale = maxSale;
        this.minSale = minSale;
        this.salesNumber = salesNumber;
        this.report = report;
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    @Override
    public void run() {
        int[] sales = new int[salesNumber];
        for (int i = 0; i < sales.length; i++) {
            sales[i] = rnd(minSale, maxSale);
        }
        for (int i = 0; i < sales.length; i++) {
            report.add(sales[i]);
        }
        System.out.printf("%s завершил подсчет\n", getName());
    }

}
