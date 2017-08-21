package List;

import java.util.Iterator;

public class LinkedList implements IList,Iterable<Object> {
    private LinkedNode head;
    private LinkedNode last;
    private int size = 0;

    @Override
    public Object search(Object key) {
        LinkedNode temp = head;
        while (temp != null) {
            if (temp.value == null && key == null || key.equals(temp.value)) {
                return temp.value;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object key) {
        LinkedNode temp = head;
        while (temp.next != null) {
            if (temp.value == null && key == null || key.equals(temp.value)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public void add(Object e) {
        if (size == 0) {
            head = new LinkedNode(e, null, null);
            last = head;
        } else {
            LinkedNode temp = new LinkedNode(e, last, null);
            last.next=temp;
            last = temp;
        }
        size++;
    }

    @Override
    public void add(Object e, int index) {
        if (index == size) {
            add(e);
        } else if (index < size) {
            LinkedNode temp = new LinkedNode(e,null,null);
            if (index == 0) {
                head.pre = temp;
                temp.next = head;
                head = temp;
                size++;
            } else if (index < 0) {
                System.out.println("输入异常");
            } else {
                int i = 1;
                LinkedNode p = head;
                while (true) {
                    p = p.next;
                    if(p==null){
                        return;
                    }
                    if (index == i) {
                     p.pre.next=temp;//
                     temp.pre=p.pre;
                     p.pre=temp;
                     temp.next=p;
                     
                        break;
                    }
                    i++;

                }
                size++;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(Object key) {
        if (size == 0) {
            throw new NullPointerException();
        } else {
            if (key == null) {
                return;
            } else if (head.value != null && key == head.value) {
                head.next.pre = null;
                head = head.next;
                size--;
                return;//跳出函数
            } else if (last.value != null && key == last.value) {
                last.pre.next = null;
                last = last.pre;
                size--;
                return;
            } else {
                LinkedNode p = head;
                while (true) {
                    
                    p=p.next;
                    if(p==null){
                        return;
                    }
                    if (key == p.value) {
                        LinkedNode q=p.pre;
                        q.next=null;
                        p.next.pre=null;
                        p.pre.next=p.next;
                        size--;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public int indexOf(Object e) {
        int i=0;
        LinkedNode p=head;
        while(i<size){
            if(e==p.value){
                return i;
            }
            i++;
            p=p.next;
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        int i=0;
        LinkedNode p=head;
        if(index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        while(i<size){
            if(i==index){
                return p.value;
            }
            p=p.next;
            i++;
        }
        return null;
    }

    @Override
    public Object delete(int index) {
        if(index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
       if(index==0){
           LinkedNode p=head;
           head.next.pre=null;
           head=head.next;
           size--;
           return p.value;
       }else if(index==size-1){
           LinkedNode p=last;
           last.pre.next=null;
           last=last.pre;
           size--;
           return p.value;
       }else{
           int i=1;
           LinkedNode p=head;
           Object q;
           while(i<size-1){
               p=p.next;
               q=p.value;
               if(i==index){
                
                   p.next.pre=null;
                   p.pre.next=null;
                   p.pre.next=p.next;
                  
                   size--;
                   return q;
               }
               i++;
           }
       }
        return null;
    }
   

    public static void main(String[] args) {
        //        int[] a=IUtil.getNotRepetationRandom(10, 20, 0);
        //        for (int i = 0; i < a.length; i++) {
        //            System.out.print(a[i]+" ");
        //        }
        //        System.out.println();
        //        LinkedNode node=new LinkedNode(a[0]);
        //        LinkedNode head=node;
        //        LinkedNode p=head;
        //        for (int i = 1; i < a.length; i++) {
        //            p.next=new LinkedNode(a[i]);
        //            p=p.next;
        //        }
        //       
        LinkedList lnode = new LinkedList();
        lnode.add(2);
        lnode.add(1);
        lnode.add(3);
        lnode.add(6,1 );
        lnode.add(7);
//        lnode.delete(1);
//      lnode.remove(6);
        Iterator< Object> iter=lnode.iterator();
       while(iter.hasNext()){
           System.out.println(iter.next());
       }
        
        //        System.out.println(lnode.contains(10));
    }
    
    @Override
  
    public Iterator<Object> iterator() {
      
        return new Iterator<Object>() {
            LinkedNode p=head;
            @Override
            public boolean hasNext() {
                
                return p!=null;
            }

            @Override
            public Object next() {
                LinkedNode pre=p;
                p=p.next;
                return pre.value;
            }
            
        };
    } 
}




class LinkedNode {
    Object value;
    LinkedNode pre;
    LinkedNode next;

    public LinkedNode(Object value) {
        super();
        this.value = value;
    }

    public LinkedNode(Object value, LinkedNode pre, LinkedNode next) {
        super();
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}