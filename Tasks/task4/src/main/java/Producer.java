package main.java;

import java.util.ArrayList;

/**
 * @author  PythonMyLife
 * @date 2019/5/26
 */
public class Producer {
    /**
     * producer的个数
     */
    private Integer producer;
    /**
     * producer等待执行时间的列表
     */
    private ArrayList<Integer> producerList;
    /**
     * 执行请求所需的时间
     */
    private Integer responseGap;

    Producer(){
        producer = 0;
        producerList = new ArrayList<>();
        responseGap = 0;
    }

    Producer(Integer producer, Integer responseGap){
        this.producer = producer;
        producerList = new ArrayList<>();
        for(Integer i = 0; i < producer; i++){
            producerList.add(i, 0);
        }
        this.responseGap = responseGap;
    }

    public Integer response(Integer wait){
        Integer deal, dealt = 0;
        if(wait > producer){
            deal = producer;
        }else{
            deal = wait;
        }
        for(Integer i = 0; i < deal; i++){
            if(producerList.get(i) == 0){
                dealt = dealt + 1;
                producerList.set(i, responseGap);
            }
        }
        return dealt;
    }

    public void decrease(){
        for(Integer i = 0; i < producer; i++){
            if(producerList.get(i) != 0){
                producerList.set(i, producerList.get(i)-1);
            }
        }
    }

}
