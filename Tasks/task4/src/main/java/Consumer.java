package main.java;

import java.util.ArrayList;

/**
 * @author PythonMyLife
 * @date 2019/5/26
 */
public class Consumer {
    /**
     * consumer的个数
     */
    private Integer consumer;
    /**
     * 每个consumer发送请求的个数
     */
    private Integer request;
    /**
     * 请求之间间隔的时间
     */
    private Integer requestGap;
    static private Integer requestNum = 0;

    Consumer(){
        this.consumer = 0;
        this.request = 0;
        this.requestGap = 0;
    }

    Consumer(Integer consumer, Integer request, Integer requestGap){
        this.consumer = consumer;
        this.request = request;
        this.requestGap = requestGap;
    }

    public ArrayList<Integer> sendRequest(Integer time){
        ArrayList<Integer> requestList = new ArrayList<>();
        if(time % requestGap == 0 && request > 0){
            for(Integer i = 0; i < consumer; i++){
                requestList.add(requestNum);
                requestNum++;
            }
            request--;
        }
        return requestList;
    }

    public Integer all(){
        return consumer *request;
    }




}
