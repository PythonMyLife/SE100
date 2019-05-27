package main.java;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author PythonMyLife
 * @date 2019/5/26
 */
public class Container {
    /**
     * 请求超时的时间
     */
    private Integer timeout;
    /**
     * 达到最长长度时，将处理策略由queue改为stack
     */
    private Integer maxLen;
    private ArrayList<Integer> requests;
    private ArrayList<Integer> waittime;
    private HashMap<Integer, String> responses;

    Container(Integer timeout, Integer maxLen){
        this.timeout = timeout;
        this.maxLen = maxLen;
        requests = new ArrayList<>();
        waittime = new ArrayList<>();
        responses = new HashMap<>();
    }

    public void dealRequest(Consumer consumer, Producer producer){
        String success = "success";
        String failure = "timeout";
        Integer time = 0, all = consumer.all();
        while(true){
            for(Integer i = 0; i < waittime.size(); i++){
                waittime.set(i, waittime.get(i) + 1);
            }
            producer.decrease();
            ArrayList<Integer> newRequests = consumer.sendRequest(time);
            requests.addAll(newRequests);
            for(Integer i = 0; i < newRequests.size(); i++){
                waittime.add(waittime.size(), 0);
            }
            Integer requestNum = requests.size();
            Integer dealt = producer.response(requestNum);
            if(requestNum > maxLen){
                for(Integer i = 0; i < dealt; i++){
                    responses.put(requests.get(requests.size()-1), success);
                    requests.remove(requests.size()-1);
                    waittime.remove(waittime.size()-1);
                }
            }else{
                for(Integer i = 0; i < dealt; i++){
                    responses.put(requests.get(0), success);
                    requests.remove(0);
                    waittime.remove(0);
                }
            }

            for(Integer j = 0; j < requests.size(); j++){
                if(waittime.get(j) > timeout){
                    responses.put(requests.get(j), failure);
                    requests.remove((int)j);
                    waittime.remove((int)j);
                    j--;
                }
            }
            time++;
            if(responses.size() >= all){
                break;
            }
        }
    }

    public void print(){
        System.out.println("requests are dealt,results are as bellow:");
        for(Integer i = 0; i < responses.size(); i++){
            String result = "request " + i.toString() + ":" + responses.get(i);
            System.out.println(result);
        }
    }
}
