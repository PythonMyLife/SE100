import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

public class WorldLadder {
    //储存字典文件
    HashSet<String> dict = new HashSet<>();
    LinkedList<String> queue = new LinkedList<>();
    LinkedList<LinkedList> step = new LinkedList<>();
    String begin;
    String end;

    public WorldLadder(String str1,String str2){
        begin = str1;
        end = str2;
    }

    public void readFile(){
        String pathname = "dictionary.txt";

        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                dict.add(line);
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStep(){
        dict.remove(begin);
        while(queue.size() > 0){
            LinkedList<String> layer = new LinkedList<>();
            int n = queue.size();

            while(n != 0){
                n--;
                String w = queue.getFirst();
                queue.removeFirst();
                layer.addFirst(w);

                if(hasone(w,end) && !w.equals(begin)){
                    step.addFirst(layer);
                    return;
                }

                for(int i =0; i < w.length();i++){
                    for(int j = 'a';j <= 'z';j++){
                        String tmp = w;
                        StringBuilder sb = new StringBuilder();
                        sb.append((char)j);
                        String j_str = sb.toString();
                        StringBuilder tmp_sb = new StringBuilder(tmp);
                        tmp_sb.replace(i,i+1,j_str);
                        tmp = tmp_sb.toString();
                        if(dict.contains(tmp)){
                            queue.addLast(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            step.addFirst(layer);
        }
    }

    public boolean hasone(String str1,String str2){
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        if(array1.length != array2.length) return false;
        int n = 0;
        for(int i = 0; i < array1.length;i++){
            if(array1[i] != array2[i]) n++;
        }
        return (n==1);
    }

    public String word_ladder(){
        String ladder;
        if(dict.contains(begin)&&dict.contains(end)&&begin.length() == end.length()){
            queue.addFirst(begin);
            dict.remove(begin);

            ladder = end;
            if(begin.equals(end)){
                ladder = end;
            }
            else if(hasone(begin,end)){
                ladder += "->" + begin;
            }
            else{
                boolean flag = false;
                setStep();
                for(int i = 0; i< step.size(); i++){
                    LinkedList<String> layer = new LinkedList<>();
                    layer = step.get(i);
                    for(int j = layer.size() - 1; j >= 0; j--){
                        if(hasone(layer.get(j),end)){
                            ladder += "->" + layer.get(j);
                            end = layer.get(j);
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        ladder = "这两个单词之间没有ladder";
                        break;
                    }
                }
            }

        }
        else{
            ladder="请保证输入的两个单词长度长度相同并都在字典中！";
        }
        return ladder;
    }

    public static void main(String[] args){
        System.out.println("请输入起始单词");
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try{
            String begin = br.readLine();
            System.out.println("请输入终止单词");
            String end = br.readLine();
            System.out.println("begin at:" + begin);
            System.out.println("end at:" + end);
            WorldLadder ladder = new WorldLadder(begin,end);
            ladder.readFile();
            String wordladder = ladder.word_ladder();
            System.out.println(wordladder);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
