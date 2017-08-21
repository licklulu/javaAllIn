package NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FinfFrequency {
  
public void buildFile(){
    
   
    new Thread((new Runnable() {
        
        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                String path="E:/file"+i+".txt";
                File f=new File(path);
                if(!f.exists()){
                    try {
                        f.createNewFile();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                
                char c;
                long j=0;
                StringBuffer sb=new StringBuffer();
                
                  while(j<10000000l){
                      c=(char)(int)(Math.random()*26+97);
                      sb.append(c);
                      if(sb.length()%4==0){
                          sb.append("   ");
                      } 
                      j++;
                  }
                 String s=sb.toString();
                 int l=s.length();
                 byte[] bytes=s.getBytes();
                 FileOutputStream fos = null;
                 try {
                    fos=new FileOutputStream(f);
                 } catch (FileNotFoundException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
                try {
                 fos.write(bytes);
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }finally{
                 try {
                     fos.close();
                 } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
             }
            }
        }
    })).start();;
}
public void readFile(Map<String,Integer> map) throws IOException{
  
    int tData;
   Reader reader=null;
   StringBuilder temp=new StringBuilder(" ");
   File file=new File("E:/test3.txt");
   try {
    reader=new InputStreamReader(new FileInputStream(file));
    while((tData=reader.read())!=-1){
        if(isCharactor(tData)){
            temp.append((char)tData);
        }else{
            addMap(temp.toString(),map);
            temp=new StringBuilder();
        }
    }
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
  
}
private void addMap(String string,Map<String,Integer> map) {
          Integer count=map.get(string);
          if(count==null){
              map.put(string,1 );
          }else{
              map.put(string, count+1);
          }
}
private boolean isCharactor(int tData) {
    if(tData>=65&&tData<=90){
        return true;
    }else if(tData>=97&&tData<=122){
        return true;
    }
    return false;
}
public void findFrequency(){
    Map<String,Integer> map=new TreeMap<String,Integer>();
    try {
        readFile(map);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    List<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String,Integer>>();
//    Collections.sort(list,new Comparator<Entry<String,Integer>>(){
//
//        @Override
//        public int compare(Entry<String,Integer> o1,Entry<String,Integer> o2) {
//            return o2.getValue().compareTo(o1.getValue());
//        }
//        
//    });
   int i=10;
    
   Iterator<String> iter=map.keySet().iterator();
   
   while(iter.hasNext()&&i>0){
       String temp=iter.next();
      System.out.println(temp+":"+map.get(temp));
      i--;
   }
}
public static void main(String[] args) {
    FinfFrequency ff=new FinfFrequency();
    ff.findFrequency();
}
}
