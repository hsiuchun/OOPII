public class A1073316_checkpoint7_RouteLinkedList{
    private A1073316_checkpoint7_Node head;
    //Description : the constructor of leading the head Node as null.
    public A1073316_checkpoint7_RouteLinkedList(){
        this.head = null;
    }
    //Description : the constructor of input a Node as the head node.
    public A1073316_checkpoint7_RouteLinkedList(A1073316_checkpoint7_Node head){
        this.head = head;
    }
    public void delete(int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint5)******************************
        //TODO(1):      Input value of Node as the reference Node,
        //              you have to delete the first Node that is same as the reference Node,
        //              and connect the following one and the previous one.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073316_checkpoint7_Node previous= null;
        A1073316_checkpoint7_Node current=head;
        // if(head==null) System.out.println("The list is empty!");
        // else{
        if(head!=null){
            // if(head.getNext()==null && head.getAxis()==axis && head.getDirection()==direction){
            //     head=null;
            // }else{
                while(!(current.getAxis()==axis && current.getDirection()==direction) && current.getNext()!=null){
                    previous=current;
                    current=current.getNext();
                    // System.out.println("Find next!");
                }
                if(current.getAxis()==axis && current.getDirection()==direction){
                    // if(current.getNext()!=null){
                        if(previous==null){
                            // System.out.println("Find it on the head!");
                            head=current.getNext();
                        }else{
                            // System.out.println("Find it!");
                            previous.setNext(current.getNext());
                        }
                } 
            // }
            
        }
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }

    public A1073316_checkpoint7_Node search(int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint5)********************************
        //TODO(2):      Input value of Node as the reference Node,
        //              you have to find the first Node that is same as the reference Node,
        //              and return it.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/

        A1073316_checkpoint7_Node current=head;
        if(head==null) return null; //the list is empty!
        else if(current.getAxis()==axis && current.getDirection()==direction){ // the first node is target!
            return current;
        }
        else{ // target is in the nodes after first node.
            while(current.getNext()!=null){
                
                if(current.getAxis()==axis && current.getDirection()==direction){ // target is in the middle of list.
                    return current;
                }
                current=current.getNext();
            }
            if(current.getNext()==null){ 
                if(current.getAxis()==axis && current.getDirection()==direction){ // target is the last node of list.
                    return current;
                }
                return null;
            }
            return null;
        }
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public void insert(int referenceAxis, int referenceDirection, int axis, int direction){ 
        /*********************************The Past TODO (Checkpoint6)********************************
        //TODO(3):      Input value of Node as the reference Node,
        //              and insert a Node BEFORE the first Node same as the reference Node,
        //              and connect the following one and the previous one.
        //Hint          The value of the Node is int variable axis and dirsction.
        //Hint2         If there is no reference node in linkedlist, print "Insertion null".
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073316_checkpoint7_Node temp=new A1073316_checkpoint7_Node(direction, axis);
        A1073316_checkpoint7_Node previous = null;
        A1073316_checkpoint7_Node current=head;
        if(head==null){
            System.out.println("Insertion null");
            // head=temp;
        }
        else{
            while(!(current.getAxis()==referenceAxis && current.getDirection()==referenceDirection) && current.getNext()!=null){
                previous=current;
                current=current.getNext();
            }
            if(current.getAxis()==referenceAxis && current.getDirection()==referenceDirection){
                temp.setNext(current);
                if(previous==null){
                    head=temp;
                }
                else{
                    previous.setNext(temp);
                }    
            }else{
                System.out.println("Insertion null");
            }
        }

        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public int length(){
        /*********************************The Past TODO (Checkpoint5)********************************
        //TODO(4):      return how long the LinkedList is.
        /********************************************************************************************
         START OF YOUR CODE
        ********************************************************************************************/
        A1073316_checkpoint7_Node current=head;
        int size=0; // without insert way
        if(head==null) return size;
        else if(head!=null) size+=1;
        while(current.getNext()!=null){
            size+=1;
            current=current.getNext();
        }
        return size;
        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
    public void append(int axis, int direction){
        A1073316_checkpoint7_Node temp=new A1073316_checkpoint7_Node(direction, axis);
        A1073316_checkpoint7_Node current=head;
        if(head==null) head=temp;
        else{
            while(current.getNext()!=null){
                current=current.getNext();
            }
            if(current.getNext()==null) current.setNext(temp);
        }
        // A1073316_checkpoint7_Node node = this.head;
        // while(node.getNext() != null){
        //     node = node.getNext();
        // }
        // node.setNext(new A1073316_checkpoint7_Node(direction, axis));
    }
    public A1073316_checkpoint7_Node getHead(){
        return this.head;
    }
    public void setHead(A1073316_checkpoint7_Node head){
        this.head = head;
    }
}
    

