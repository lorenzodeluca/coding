import java.io.*;
import java.util.*;

public class Solution {
    public static class TextEditor {
    List<Integer> deleted;
    List<String> text;
    StringBuilder fullText; //StringBuilder è più efficiente di String perchè String è immutabile

    TextEditor() {
        deleted = new ArrayList<>();
        text = new ArrayList<>();
        fullText = new StringBuilder();
    }

    void append(String w) {
        deleted.add(w.length());
        text.add(w);
        fullText.append(w);
    }

    void delete(int k) {
        String removed = fullText.substring(fullText.length() - k);
        deleted.add(-k);
        text.add(removed);
        fullText.delete(fullText.length() - k, fullText.length());
    }

    void print(int k) {
        System.out.println(fullText.charAt(k - 1));
    }

    void undo() {
        int index = deleted.size() - 1;
        int lastChange = deleted.get(index);

        if (lastChange >= 0) {
            fullText.setLength(fullText.length() - lastChange);
        } else {
            fullText.append(text.get(index));
        }

        deleted.remove(index);
        text.remove(index);
    }
}
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int opsNum=s.nextInt();
        TextEditor ed=new TextEditor();
        while(opsNum>0){
            int op=s.nextInt();
            switch(op){
                case 1:
                    ed.append(s.next());
                    break;
                case 2:
                    ed.delete(s.nextInt());
                    break;
                case 3:
                    ed.print(s.nextInt());
                    break;
                case 4:
                    ed.undo();
                    break;
                default:
                    System.out.println("unsupported operation");
            }
            opsNum--;
        }
    }
}