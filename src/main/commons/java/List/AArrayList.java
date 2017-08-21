package List;

public class AArrayList implements IList{
private Object[] data;
private int size;
private final int DEPTH=20;

    @Override
    public Object search(Object key) {
       for (int i = 0; i < data.length; i++) {
           if(key.equals(data[i])){
               return data[i];
           }
    }
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(data.length==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object key) {
        for (int i = 0; i < data.length; i++) {
            if(key.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object e) {
        if(size==data.length){
            Object[] data2=new Object[size+DEPTH];
            for (int i = 0; i < data2.length; i++) {
                data2[i]=data[i];
            }
            data=data2;
        }
     data[size]=e;   
     size++;
    }

    @Override
    public void remove(Object key) {
        for (int i = 0; i < data.length; i++) {
            if(data[i]==null&&key==null||key.equals(data[i])){
                data[i]=null;
                
                for (int j = i; j < size-1; j++) {
                    data[j]=data[j+1];
                }
                size--;
                return;//只删除一个，如果不加会把所有key相同的值都删除
            }
           
        }
    }

    @Override
    public int indexOf(Object e) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Object e, int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object delete(int index) {
        // TODO Auto-generated method stub
        return null;
    }

}
