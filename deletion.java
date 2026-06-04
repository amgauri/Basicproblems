class Node{
    int data;
    Node next;
    Node(int data1){
        this.data=data1;
        this.next=null;
        
    }
}
public class deletion {

     private static Node Convert(int[] arr){       //conversion as done in hii.java
        Node head =new Node(arr[0]);                
        Node mover=head;                            
        for(int i=1;i<arr.length;i++)  {            
        Node temp=new Node(arr[i]);                 
        mover.next=temp;                            
        mover=temp;                                 
        }
        return head;                                //this would return head only
    }

    void print(Node head){                       //function to print the elements of an array
      Node temp=head;                            //local variable temp
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
       private static Node removNode(Node head){            //function that would delete the head as in java we dont need to free the node Garbadge collector does that work!
        if(head==null)
            return head;
        else{
        head=head.next;                                  //simply shift the head to the next location
        return head;                                    //this function returns new head
        }
    }
      private static Node removetailNode(Node head){             //removing the last node      
    if(head == null || head.next == null)
        return null;  // empty ya single node case

    Node temp = head;

    while(temp.next.next != null){
        temp = temp.next;
    }

    temp.next = null;  // last node hata diya
    return head;

}
private static Node removebyValuNode(Node head, int value){          //removing the node by value
    Node temp=head;
    if(head==null)
        return null;
    if(head.data ==value){
        head=head.next;
        return head;
    }
    while(temp.next!=null){                //temp.next taki last node ki bhi value delete ho ske
    if( temp.next.data == value)            //checking the value by staying 1 steps back
    {   
       temp.next=temp.next.next;
    }
    temp=temp.next;
}
return head;
}
      private static Node kthelemnetNode(Node head,int k){               //deleting kth element
        int i=1;
        Node temp= head;
        if(head==null){                  //empty linkedlist
            return null;
        }
        else if(k==1)                   //head removal case!
        {   
            return head.next;
        }
        else{
        while(i<k-1) {                       //so that we can get to the prev node!
       temp=temp.next;                     
       i++;
        }
        temp.next=temp.next.next;
        return head;
      }
    }

        public static void main(){                    //main function
            int [] arr={12,5,6,8,9,13,5};                    //array
            Node y= Convert(arr);                     //y stored the head of the new linkedlist
            Node head=removNode(y);                   //head gets the new head after deletion 
           deletion obj=new deletion();               //creating object of the class
            System.out.println("after head removal");           
            obj.print(head);  
            System.out.println("\n after kth element removal");         
            Node w=kthelemnetNode(y, 1);
            obj.print(w);
            System.out.println("delete by value");
            Node z=removebyValuNode(y, 13);
            obj.print(z);
            Node tail=removetailNode(y);
            System.out.println("\n after tail removal");
            obj.print(tail);          
           
           
        }
    }
