package hello;

import org.junit.Test;
import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class GreetingTest {

    @Test
    public void readFile() {
        //标准读入文件生成的dict
        HashSet<String> dict = new HashSet<>();
        dict.add("code");
        dict.add("cade");
        dict.add("dade");
        dict.add("date");
        dict.add("data");
        dict.add("doto");
        //检查函数生成dict的正确性
        Greeting ladder = new Greeting(0,"str1","str2");
        String pathname = "smalldict.txt";
        ladder.readFile(pathname);
        assertEquals(dict,ladder.dict);
    }

    @Test
    public void setStep() {
        //生成正确的step
        LinkedList<String> queue0 = new LinkedList<>();
        LinkedList<LinkedList> step = new LinkedList<>();
        queue0.addFirst("code");
        step.addFirst(queue0);
        LinkedList<String> queue1 = new LinkedList<>();
        queue1.addFirst("cade");
        step.addFirst(queue1);
        LinkedList<String> queue2 = new LinkedList<>();
        queue2.addFirst("dade");
        step.addFirst(queue2);
        LinkedList<String> queue3 = new LinkedList<>();
        queue3.addFirst("date");
        step.addFirst(queue3);


        Greeting ladder = new Greeting(0,"code","data");
        ladder.queue.clear();
        ladder.dict.clear();
        ladder.step.clear();
        ladder.queue.addFirst("code");
        String pathname = "smalldict.txt";
        ladder.readFile(pathname);
        ladder.setStep();
        assertEquals(step,ladder.step);
    }

    @Test
    public void hasone() {
        String str1 = "abcde";
        String str2 = "abcdf";
        Greeting ladder = new Greeting(0,str1,str2);
        assertEquals(true,ladder.hasone(str1,str2));
        String str3 = "abcee";
        assertEquals(false,ladder.hasone(str2,str3));
        assertEquals(false,ladder.hasone(str3,str3));
        assertEquals(true,ladder.hasone(str1,str3));
    }

    @Test
    public void word_ladder() {
        //单词不在字典里
        Greeting ladder1 = new Greeting(0,"dtat","ccda");
        String message1 = "请保证输入的两个单词长度长度相同并都在字典中！";
        assertEquals(message1,ladder1.word_ladder());
        //长度不相同
        Greeting ladder2 = new Greeting(0,"data","datae");
        String message2 = "请保证输入的两个单词长度长度相同并都在字典中！";
        assertEquals(message2,ladder2.word_ladder());
        //单词之间没有ladder
        Greeting ladder3 = new Greeting(0,"code","zzzs");
        String message3 = "这两个单词之间没有ladder";
        assertEquals(message3,ladder3.getContent());
        //ladder
        Greeting ladder4 = new Greeting(0,"code","data");
        String message4 = "data->date->cate->cade->code";
        assertEquals(message4,ladder4.getContent());
    }

    @Test
    public void getId() {
        Greeting ladder = new Greeting(1, "data", "code");
        assertEquals(1, ladder.getId());
    }

    @Test
    public void getBeg() {
        Greeting ladder = new Greeting(1, "data", "code");
        assertEquals("data", ladder.getBegin());
    }

    @Test
    public void getEnd() {
        Greeting ladder = new Greeting(1, "data", "code");
        assertEquals("code", ladder.getEnd());
    }

}