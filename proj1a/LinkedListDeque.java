public class LinkedListDeque<Akira> {
    private class StuffNode{
        public Akira item;
        public StuffNode prev,next;
        public StuffNode(Akira i,StuffNode n,StuffNode m){
            item=i;
            prev=n;
            next=m;
        }

        public Akira getRecursive(int i) {
            if(i==0){
                return this.item;
            }
            else {
                return this.next.getRecursive(--i);
            }
        }
    }

    private StuffNode sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel=new StuffNode(null,null,null);
        size=0;
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }
    public void addFirst(Akira x){
    StuffNode temp=new StuffNode(x,sentinel,sentinel.next);
    sentinel.next.prev=temp;
    sentinel.next=temp;
    size++;
    }
    public void addLast(Akira x){
        StuffNode temp=new StuffNode(x,sentinel.prev,sentinel);
        sentinel.prev.next=temp;
        sentinel.prev=temp;
        size++;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        StuffNode temp=sentinel.next;
        while(temp!=sentinel){
            System.out.print(temp.item+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public Akira removeFirst(){
        if(size==0){
            return null;
        }
        else {
            Akira temp=sentinel.next.item;
            sentinel.next.next.prev=sentinel;
            sentinel.next=sentinel.next.next;
            size--;
            return temp;
        }
    }
    public Akira removeLast(){
        if(size==0){
            return null;
        }
        else {
            Akira temp=sentinel.prev.item;
            sentinel.prev.prev.next=sentinel;
            sentinel.prev=sentinel.prev.prev;
            size--;
            return temp;
        }
    }
    public Akira get(int index){
        if(index>size-1){
            return null;
        }
        else{
            StuffNode temp=sentinel.next;
            for (int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp.item;
        }
    }
    public LinkedListDeque(LinkedListDeque other){
        sentinel=new StuffNode(null,null,null);
        size=0;
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        StuffNode p=other.sentinel.next;
         for(int i=0;i<size;i++){
        this.addLast(p.item);
        p=p.next;
        }
    }
    public Akira getRecursive(int index){
        if(index>size-1){
            return null;
        }
        if(size==0){
            return null;
        }
        else {
            //LinkedListDeque temp=new LinkedListDeque();
            //temp.sentinel=this.sentinel.next;
            //temp.size=this.size--;
            return sentinel.next.getRecursive(index);
        }
    }
    public static void main(String[] args){
        LinkedListDeque<Integer> a=new LinkedListDeque<>();
        a.addFirst(3);
        a.addFirst(5);
        a.addLast(6);
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        System.out.println(a.get(2));
        System.out.println(a.size());
        a.printDeque();
        System.out.println(a.getRecursive(1));
        int b1=a.removeFirst();
        int b2=a.removeLast();
        System.out.println(b1+" "+b2);
        a.printDeque();
    }
}
