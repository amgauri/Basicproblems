class Node {
    int data;
    Node next; 
    Node(int data1)
    {
        this.data=data1;
        this.next=null;
    }
};
public class insertion {
    private static Node Convert(int[] arr){       //function to convert array to ll
        Node head= new Node(arr[0]);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
            Node temp= new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;

    }
    void print(Node head){                       //function to print the elements of an array
      Node temp=head;                            //local variable temp
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    private static Node inserstNodehead(Node head,int val){        //inserting at head
        Node temp= head;
        if(temp==null)                                            //empty ll case
        {
            return new Node(val);
        }
        Node newNode = new Node(val);                            //creating new node
        newNode.next=temp;                                       //connecting new node before temp(temp has head)
        return newNode;                                         //returning the new head 

    }
    private static Node insertatlastNode(Node head,int val){        //inserting at tail
        Node temp=head;
        if(temp==null)                                            //empty ll case
        {
            return new Node(val);
        }
        while(temp.next!=null){                                    //(temp.next!=null)so that we can reach the last node and not null
            temp=temp.next;                                        //traversing
        }
        Node newnNode=new Node(val);                               //creating new node
        temp.next=newnNode;                                        //(temp has last node)so attaching it to the new created node
        return head;                                               //returning head after modification
    }
    private static Node insertatkthNode(Node head,int val,int k){        //inserting val at kth position in the ll
       int i=0;
       Node newNode=new Node(val);                                     //new node
       Node temp=head;
       if(temp==null){                                                //empty ll case
        return null;
       }
       if(k==1){                                                      //when adding at k=1 i.e, head                 
        newNode.next=head;               
        return newNode;
        
       }
        while(i<k-1 && temp!=null){                                               //reaching at the element just before kth element
            temp=temp.next;                                         //traversing
            i++;                                                  //''
         }
         newNode.next=temp.next;                            //  connecting this new node to the kth element
         temp.next=newNode;                                //connecting temp to newnode
         return head;
        
     }
     private static Node insertbeforevaluNode(Node head,int val,int k){    //inserting val before an elemnt K given in the ll
        Node temp=head;
        Node newNode= new Node(val);                                   //creating new node
        if(temp==null)                                              //null case
            return head;
        if(temp.data==k){                               //if data is at first node only
            newNode.next=head;                         //adding at head
            return newNode;

        }
        while(temp.next!=null){                 //so that we camn reach till last element and not null
            if(temp.next.data==k){             //so that i can reach the node that is just before the node which has the element K 
           newNode.next=temp.next;
           temp.next=newNode;
           return head;
            }
            temp=temp.next;
        }
        return null;
    
     }
    public static void main(String[] args) {
        insertion obj=new insertion();
        int a[]={2,3,4,5,6};
        Node head= Convert(a);
        System.out.println("the original linkedlist:");
        obj.print(head);
        System.out.println("insertion at kth element");
        head=insertatkthNode(head, 5, 1);
        obj.print(head);
        System.out.println("insertion at head");
        head= inserstNodehead(head, 7);
        obj.print(head);
        System.out.println("insertion at tail:");
        head=insertatlastNode(head, 10);
        obj.print(head);
        System.out.println("insertion before value k:");
        head=insertbeforevaluNode(head, 7, 10);
        obj.print(head);
 }
    
}
