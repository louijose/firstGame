public class ResizedCapacityQueueOfString{
    private String[] s;
    private int head,tail,n;

    public ResizedCapacityStackOfString(){
        s = new String[1];
        n = 0;
        head = 0;
        tail = 0;
    }

    public void resize(int capacity){
        String copy = new String[capacity];
        for(int i = 0 ; i < n ; i++){
            copy[i] = s[i];
        }
        s = copy;
        tail = n;
    }

    public boolean isEmpty(){
        return head==tail;
    }

    public void enqueue(String item){
        if(n==s.length)
            resize(2*s.length);
        s[tail++]=item;
        if(tail==s.length)
            tail = 0;
        n++;
    }

    public String pop(){
        if (isEmpty()) 
            throw new NoSuchElementException("Queue underflow");
        String item = s[head];
        s[head--] = null;
        n--;
        if(head==s.length)
            head = 0;
		if(n>0 && n==s.length/2)
			resize(s.length/2);
        return item;
    }
}