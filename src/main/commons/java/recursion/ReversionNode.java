package recursion;

public class ReversionNode {

static void reversionNode(Node node){
    if(node.next!=null){
    reversionNode(node.next);
    }
    System.out.println(node.value);
}
static Node buildNode(int[] a){
    Node node=new Node(a[0]);
    Node head=node;
    Node p=head;
   for (int i = 1; i < a.length; i++) {
    p.next=new Node(a[i]);
    p=p.next;
}
   return node;
}
public static void main(String[] args) {
    int[] a={1,3,5,7,9};
   Node node= buildNode(a);
        
reversionNode(node);   
    
}
}
class Node{
    int value;
    Node next;
    Node(int value){
        this.value=value;
    }
}