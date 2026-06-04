class Node {
    Node next;
    int data;
    Node prev;
    Node(int data1,Node next1,Node prev1)
    {
        this.data=data1;
        this.next=null;
        this.prev=null;

    }
};

public class Doubly {
    void print(Node head){
    Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

        private static Node Convert(int[] arr){       //conversion as done in hii.java
        Node head =new Node(arr[0],null,null);                
        Node prev=head;                            
        for(int i=1;i<arr.length;i++)  {            
        Node temp=new Node(arr[i],null,prev);                 
        prev.next=temp;                            
        prev=temp;                                 
        }
        return head;                                //this would return head only
    }
 private static Node inserstNodehead(Node head,int val){        //inserting at head
        Node temp= head;
        if(temp==null)                                            //empty ll case
        {
            return new Node(val,null,null);
        }
        Node newNode = new Node(val,null,null);                            //creating new node
        newNode.next=head;                                       //connecting new node before temp(temp has head)
        newNode.prev=null;
        head.prev=newNode;
        return newNode;                                                              //returning the new head 
    }

    private static Node insertatlastNode(Node head,int val){        //inserting at tail
        Node temp=head;
        if(temp==null)                                            //empty ll case
        {
            return new Node(val,null,null);
        }
        while(temp.next!=null){                                    //(temp.next!=null)so that we can reach the last node and not null
            temp=temp.next;                                        //traversing
        }
        Node newnNode=new Node(val,null,null);                               //creating new node
        temp.next=newnNode;                                        //(temp has last node)so attaching it to the new created node
        newnNode.prev=temp;
        return head;                                               //returning head after modification
    }
    private static Node insertatkthNode(Node head,int val,int k){        //inserting val at kth position in the ll
       int i=0;
       Node j;
       Node newNode=new Node(val,null,null);                                     //new node
       Node temp=head;
       if(temp==null){                                                //empty ll case
        return null;
       }
       if(k==1){                                                      //when adding at k=1 i.e, head                 
        newNode.next=head;     
        newNode.prev=null;          
        return newNode;
        
       }
        while(i<k-1 && temp!=null){                                               //reaching at the element just before kth element
            temp=temp.next;                                         //traversing
            i++;                                                  //''
         }
         j=temp.next;
         temp.next=newNode;
         newNode.next=j; 
         newNode.prev=temp;                           //  connecting this new node to the kth element
         j.prev=newNode;                               //connecting temp to newnode
         return head;
        
     }
     private static Node insertbeforevalue(Node head,int val,int k){
        Node temp=head;
        Node j;
        Node newNode=new Node(val,null,null);
        if(temp==null){
            return head;
        }
        if(temp.data==k){
        newNode.next=head;     
        newNode.prev=null;          
        return newNode;
        }
        while(temp.next!=null){
            {
             if(temp.next.data==k){
             j=temp.next;
             temp.next=newNode;
             newNode.next=j; 
            newNode.prev=temp;                           //  connecting this new node to the kth element
            j.prev=newNode;                               //connecting temp to newnode
            return head;

                }
                temp=temp.next;
            }
        }
         return head;
     }
    public static void main(String[] args){
        int[] array={2,5,6,8};
        Node head= Convert(array);
        Doubly obj=new Doubly();
        obj.print(head);
        System.out.println("insrtion at head:");
        head=inserstNodehead(head, 6);
        obj.print(head);
        System.out.println("insrtion at tail:");
        head=insertatlastNode(head, 9);
        obj.print(head);
        System.out.println("insrtion at kth:");
        head=insertatkthNode(head, 0 ,2);
        obj.print(head);
        System.out.println("insrtion before the value:");
        head=insertbeforevalue(head, 1 ,0);
        obj.print(head);

    }
}

    
    
