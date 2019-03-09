package WordLadder;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class WorldLadderTest {

    @Test
    public void readFile(){
        //标准读入文件生成的dict
        HashSet<String> dict = new HashSet<>();
        dict.add("code");
        dict.add("cade");
        dict.add("dade");
        dict.add("date");
        dict.add("data");
        dict.add("doto");
        //检查函数生成dict的正确性
        WorldLadder ladder = new WorldLadder("","");
        ladder.readFile();
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

        WorldLadder ladder = new WorldLadder("code","data");
        ladder.queue.addFirst("code");
        ladder.readFile();
        ladder.setStep();
        assertEquals(step,ladder.step);
    }

    @Test
    public void hasone() {
        //str1与str2只有一个字母不同,str2与str3有两个字母不同
        String str1 = "abcde";
        String str2 = "abcdf";
        WorldLadder ladder = new WorldLadder(str1,str2);
        assertEquals(true,ladder.hasone(str1,str2));
        String str3 = "abcee";
        assertEquals(false,ladder.hasone(str2,str3));
    }

    @Test
    public void word_ladder() {
        //单词不在字典里
        WorldLadder ladder1 = new WorldLadder("dtat","ccda");
        ladder1.readFile();
        String message1 = "请保证输入的两个单词长度长度相同并都在字典中！";
        assertEquals(message1,ladder1.word_ladder());
        //长度不相同
        WorldLadder ladder2 = new WorldLadder("data","datae");
        ladder2.readFile();
        String message2 = "请保证输入的两个单词长度长度相同并都在字典中！";
        assertEquals(message2,ladder2.word_ladder());
        //单词之间没有ladder
        WorldLadder ladder3 = new WorldLadder("code","doto");
        ladder3.readFile();
        String message3 = "这两个单词之间没有ladder";
        assertEquals(message3,ladder3.word_ladder());
        //ladder
        WorldLadder ladder4 = new WorldLadder("code","data");
        ladder4.readFile();
        String message4 = "data->date->dade->cade->code";
        assertEquals(message4,ladder4.word_ladder());
    }
}