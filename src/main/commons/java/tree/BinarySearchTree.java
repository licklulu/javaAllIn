package tree;

import java.util.Comparator;
import java.util.function.Consumer;

public class BinarySearchTree<K,V> implements IBinarySearchTree<K, V>{
    private Node<K,V> root;
    private int size;
    private Comparator comparator;
    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(Comparator comparator) {
        super();
        this.comparator = comparator;
    }

    @Override
    public void insert(K key, V value) {
        Node<K,V> current=root;
        Node<K,V> p=null;
      while(current!=null){
          p=current;
      if(compare(key, current.key)<0){
          current=current.left;
      }else if(compare(key,current.key)>0){
          current=current.right;
      }else{
          current.key=key;
          return;
      }
      }
      current=new Node<K, V>(key,value,null,null,null);
      current.parent=p;
      if(p==null){
          root=current;
      }else if(compare(key,p.key)<0){
          p.left=current;
          current.isLeftChild=true;
      }else{
         p.right=current;
          current.isLeftChild=false;
      }
      size++;
    }
    public void iinorder(Node<K,V> node){
        if(node.left!=null){
            iinorder(node.left);
        }
        System.out.println(node.key);
        
        if(node.right!=null){
            iinorder(node.right);
        }
    }
    public void pre(Node<K,V> node){
        
        System.out.println(node.key);
        if(node.left!=null){
            pre(node.left);
        }
        if(node.right!=null){
            pre(node.right);
        }
    }
    @Override
    public void inorder(Consumer<K> con) {
        if(root!=null){
            inorder(root,con);
        }
        
    }
    private void inorder(Node<K,V> p,Consumer<K> con) {
        inorder(p.left,con);
        con.accept(p.key);
        inorder(p.right,con);
    }
    @Override
    public V lookupValue(K key) {
        Node<K,V> p=root;
        while(p!=null){
        if(compare(key,p.key)==0){
            return p.value;
        }else if(compare(key,p.key)<0){
            p=p.left;
        }else{
            p=p.right;
        }
        }
        return null;
    }

    @Override
    public K min() {
        
        Node<K,V> p=root;
        Node<K,V> q=null;
        while(p!=null){
            q=p;
            p=p.left;
        }
        return q.key ;
    }
public Node<K,V> minNode(Node<K,V> node) {
        
        Node<K,V> p=root;
        Node<K,V> q=null;
        while(p!=null){
            q=p;
            p=p.left;
        }
        return q ;
    }
    @Override
    public K max() {
        Node<K,V> p=root;
        Node<K,V> q=null;
        while(p!=null){
            q=p;
            p=p.right;
        }
        return q.key;
    }
    public void removeNode(Node<K,V> nnode) {
        Node<K,V> node=lookupNode(nnode.key);
        if(node.isLeftChild){
        if((node.left==null)&&(node.right==null)){
            node.parent.left=null;
            size--;
        }else if(node.left==null&&node.right!=null){
            node.parent.left=null;
            node.right.parent=null;
            node.parent.left=node.right;
            node.right.parent=node.parent;
        }else if(node.right==null&&node.left!=null){
            node.parent.left=null;
            node.left.parent=null;
            node.parent.left=node.left;
            node.left.parent=node.parent;
        }else if(node.right!=null&&node.left!=null){
            Node<K,V> mNode=minNode(node.right);
            node.key=mNode.key;
            removeNode(mNode);
        }
    }
        
    }
    @Override
    public void remove(K key) {
        Node<K,V> node=lookupNode(key);
        if(node.isLeftChild){
        if((node.left==null)&&(node.right==null)){
            node.parent.left=null;
            size--;
        }else if(node.left==null&&node.right!=null){
            node.parent.left=null;
            node.right.parent=null;
            node.parent.left=node.right;
            node.right.parent=node.parent;
        }else if(node.right==null&&node.left!=null){
            node.parent.left=null;
            node.left.parent=null;
            node.parent.left=node.left;
            node.left.parent=node.parent;
        }else if(node.right!=null&&node.left!=null){
            Node<K,V> mNode=minNode(node.right);
            node.key=mNode.key;
            removeNode(mNode);
        }
    }
        
    }
    @Override
    public K successor(K x) {
        Node<K,V> xNode=lookupNode(x);
        if(xNode.right!=null){
            Node<K,V> rnode=xNode.right;
            K pre=null;
            while(rnode!=null){
               pre=rnode.key;
                rnode=rnode.left;
            }
            return pre;
        }else{
            Node<K,V> xParent=xNode.parent;
            if(xNode.isLeftChild){
                return xParent.key;
                
            }
            while(xParent!=null){
               
                if(xParent.isLeftChild){
                    return xParent.parent.key;
                }else if(!xParent.isLeftChild){
                    xParent=xParent.parent;
                }
            
            }
        }
        return null;
    }

    @Override
    public K predecessor(K x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return size;
    }
     Node<K,V> lookupNode(K key){
         Node<K,V> p=root;
         while(p!=null){
             if(compare(key,p.key)==0){
                 return p;
             }else if(compare(key,p.key)>0){
                 p=p.right;
             }else{
                 p=p.left;
             }
         }
        return null;
         
     }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private int compare(K key1, K key2) {
        if (null == comparator) {
          return ((Comparable) key1).compareTo((Comparable) key2);
        } else {
          return comparator.compare(key1, key2);
        }
      }
 
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> bt=new BinarySearchTree<>();
        bt.insert(3, 3);
        bt.insert(5, 5);
        bt.insert(11, 11);
        bt.insert(15, 15);
        bt.insert(7, 7);
        bt.insert(1, 1);
        bt.insert(6, 6);
        bt.insert(8, 8);
      bt.remove(7);
     bt.iinorder(bt.root);
     bt.pre(bt.root);
     
//        System.out.println(bt.successor(6));
    }
}
class Node<K,V>{
    K key;
    V value;
    Node<K,V> left;
    Node<K,V> right;
    Node<K,V> parent;
    boolean isLeftChild;
    public Node(K key, V value, Node<K, V> left, Node<K, V> right, Node<K, V> parent) {
        super();
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
    

