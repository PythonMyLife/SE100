package main.java;

/**
 * @author PythonMyLife
 * @date 2019/5/26
 */
public class Application {
    public static void main(String[] args) {
        Producer producer = new Producer(5, 50);
        Consumer consumer = new Consumer(5, 10,20);
        Container container = new Container(35, 20);
        container.dealRequest(consumer,producer);
        container.print();
    }
}
