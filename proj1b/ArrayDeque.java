public class ArrayDeque<Item> implements Deque<Item>{
    private Item[] items;
    private int size;
    private int nextFirst,nextLast;
    private int max;
    public ArrayDeque(){
        items=(Item[]) new Object[8];
        size=0;
        nextFirst=0;
        nextLast=1;
        //max=8;
    }
    public ArrayDeque(ArrayDeque other){
        items=(Item[]) new Object[other.size];
        nextFirst=other.nextFirst;
        nextLast=other.nextLast;
        size=other.size;
        System.arraycopy(other.items,0,items,0,other.size);
    }
    private int plusone(int x){
        return (x+1)%items.length;
    }
    private int minusone(int x){
        return (x-1+items.length)%items.length;
    }
    private void resize(int capacity){
        Item[] a=(Item[]) new Object[capacity];
        int oldFirst=plusone(nextFirst);//first item in the previous deque
        for(int i=0;i<size;i++){
            a[i]=items[oldFirst];
            oldFirst=plusone(oldFirst);
        }
        items=a;
        nextFirst=capacity-1;
        nextLast=size;
    }

    @Override
    public void addFirst(Item x){
        if(isFull()){
            resize(size*2);
        }
        items[nextFirst]=x;
        nextFirst=minusone(nextFirst);
        size++;
    }

    @Override
    public void addLast(Item x){
        if(isFull()){
            resize(size*2);
        }
        items[nextLast]=x;
        nextLast=plusone(nextLast);
        size++;
    }
    public boolean isFull(){
        return (size==items.length)?(true):(false);
    }
    /*public boolean isEmpty(){
        return (size==0)?(true):(false);
    }*/
    public boolean isParse(){
        if(items.length>=16&&(size)<(items.length/4)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        int start=plusone(nextFirst);
        for(int i=start;i!=nextLast;i=plusone(i)){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    @Override
    public Item removeFirst(){
        nextFirst=plusone(nextFirst);
        Item x=items[nextFirst];
        items[nextFirst]=null;
        size--;
        if(size>=0) {
            if (isParse()) {
                resize(items.length / 2);
            }
            return x;
        }
        else return null;
    }

    @Override
    public Item removeLast(){
        nextLast=minusone(nextLast);
        Item x=items[nextLast];
        items[nextLast]=null;
        size--;
        if(size>=0){
            if(isParse()){
                resize(items.length/2);
            }
            return x;
        }
        else {
            return null;
        }
    }

    @Override
    public Item get(int x){
        if(x>=0&&x<size)
        {
            int num = nextFirst;
            for (int i = 0; i <= x; i++) {
                num = plusone(num);
            }
            return items[num];
        }else return null;
    }
    /*public static void main(String[] args){
        ArrayDeque<Integer> a=new ArrayDeque<>();
        a.addFirst(2);
        a.addFirst(1);
        a.addLast(3);
        a.printDeque();
        a.removeFirst();
        a.printDeque();
        System.out.println(a.get(1));
    }*/
}
