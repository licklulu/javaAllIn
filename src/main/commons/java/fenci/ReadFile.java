package fenci;

import com.alibaba.fastjson.JSON;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class ReadFile {
    static String TAG = ReadFile.class.getSimpleName();
    static String writePath = "C:\\Users\\lulia\\work\\work_me\\空姐滴滴打车遇害案\\Participle.txt";
    static String readFolder = "C:\\Users\\lulia\\work\\work_me\\空姐滴滴打车遇害案\\SinaMicroBlog";
    static Set set = new HashSet();
    static List list = new ArrayList();
    static List list1 = new ArrayList();
    static List listContent = new ArrayList();
    static Integer limit = 5;
    static Integer limitGetTop = 50;
    static Map<String, Integer> map = new HashMap();
    static Map<String, Integer> mapContent = new HashMap();
    public static void main(String[] args) {
        readfile(readFolder);
        jiebaParticiple(writePath);
        getTopWords();
        System.out.println(sortByValue7(mapContent).values());
        System.out.println(sortByValue7(mapContent));
    }
    public static boolean readfile(String filepath){
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory() && filelist[i].equals("weibo.txt")) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());
                        readAnFile(readfile.getPath());
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }


    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue7(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void readAnFile(String filePath){
        try {
            //读取a.txt
            File pathFile = new File(filePath);//可使用绝对或相对路径
            if (pathFile.isFile() && pathFile.exists()) {
                FileInputStream is = new FileInputStream(pathFile);
                InputStreamReader isReader = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isReader);
                //	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile),"utf-8"));
                File writeFl = new File(writePath);
                if (!writeFl.exists()) {//不存在则创建
                    writeFl.createNewFile();//创建新文件
                }
                    FileOutputStream fs = new FileOutputStream(writeFl, true);//true设置为追加内容 默认false;
                    OutputStreamWriter ow = new OutputStreamWriter(fs, "utf-8");
                    BufferedWriter bw = new BufferedWriter(ow);
                    //	BufferedWriter bw=	new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFl,true)));
                    StringBuffer nb = new StringBuffer();
                    String lineTxt = null;
                    WeiboEntity weiboEntity = null;
                    while ((lineTxt = br.readLine()) != null) {
                        weiboEntity = JSON.parseObject(lineTxt, WeiboEntity.class);
                        listContent.add(weiboEntity.getContent());
                        StringBuffer sb = new StringBuffer();
                        sb.append(weiboEntity.getContent() + "\n");//"\n"读取换行				//写入
                        bw.write(sb.toString() + "\r\n");//"\r\n" 写入换行
                    }
                    System.out.println(nb.toString());
                    isReader.close();
                    br.close();
                    bw.flush();
                    bw.close();

            }
        }catch (FileNotFoundException fe){
            System.out.println(fe.getMessage());
        }catch (UnsupportedOperationException ue){
            System.out.println(ue.getMessage());
        }catch (IOException ie){
            System.out.println(ie.getMessage());
        }
    }
    public static void jiebaParticiple(String writePath){
        try {
            File pathFile = new File(writePath);//可使用绝对或相对路径
            if (pathFile.isFile() && pathFile.exists()) {
                FileInputStream is = new FileInputStream(pathFile);
                InputStreamReader isReader = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isReader);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    List<Word> words = WordSegmenter.seg(lineTxt, SegmentationAlgorithm.MaximumMatching);
//                    JiebaSegmenter segmenter = new JiebaSegmenter();
//                    List<SegToken> words=segmenter.process(lineTxt, JiebaSegmenter.SegMode.INDEX);
//                    int i = words.size();
//                    int k =0;
//                    while (i >= limit){
//                        String subList = "";
//                        for(int j = k; j< k+limit; j++){
//                            subList = subList+words.get(j)+",";
//                        }
//                        k ++;
//                        list.add(subList);
//                        i--;
//                    }
                    for(Word word : words){
                        if(!isNumeric(word.toString())){
                            if(map.get(word.toString()) != null){
                                map.put(word.toString(), map.get(word.toString())+1);
                            } else {
                                map.put(word.toString(), 0);
                            }
                        }
                    }
                }
            }
        }catch (IOException ie){

        }

    }
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static void getTopWords(){
        Map<String, Integer> map1 = sortByValue7(map);
        int p = 1;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if(p <= limitGetTop){
                list1.add(entry.getKey());
                p++;
            }else {
                break;
            }
        }
        int i = list1.size();
        int k =0;
        while (i >= limit){
            String subList = "";
            for(int j = k; j< k+limit; j++){
                subList = subList+list1.get(j)+",";
            }
            k ++;
            list.add(subList);
            i--;
        }
        for (int m = 0; m < list.size(); m++) {
            String[] array = list.get(m).toString().split(",");
            if(array.length > 0){
                for (int j = 0; j < listContent.size(); j++) {
                        if(listContent.get(j).toString().contains(array[0])&&listContent.get(j).toString().contains(array[1])&&listContent.get(j).toString().contains(array[2])&&listContent.get(j).toString().contains(array[3])&&listContent.get(j).toString().contains(array[4])){
                            if(mapContent.get(list.get(m).toString()) != null){
                                mapContent.put(list.get(m).toString(), mapContent.get(list.get(m).toString())+1);
                            }else {
                                mapContent.put(list.get(m).toString(),1);
                            }
                        }
                }
            }
        }


    }
}
