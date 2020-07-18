import java.util.*;
import java.io.*;

public class Deque<Item> implements Iterable<Item> {
    private Item[] s;
    private int head, tail, n;
    // construct an empty deque
    public Deque(){
        s = (Item[])new Object[1];
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return n == 0; // null
    }

    // resizing ther array
    public void resize(int capacity){
        Item[] copy = (Item[])new Object[capacity];
        for(int i = 0 ; i < n ; i++){
            copy[i] = s[i];
        }
        s = copy;
        tail = n;
    }
    // return the number of items on the deque
    public int size(){
        return n;
    }
    // push array elements right
    public void pushRight(Item[] s){
        for(int i = n ; i > 0 ; i++){
            s[i+1] = s[i];
        }
    }

    // add the item to the front
    public void addFirst(Item item){
        System.out.println("addfirst entering");
        if(item==null) throw new IllegalArgumentException("Provide proper input");
        if(n==s.length)
            resize(2*s.length);
        pushRight(s);
        s[0] = item;
        n++;
    }

    // add the item to the back
    public void addLast(Item item){
        System.out.println("addlast entering");
        if(item==null) throw new IllegalArgumentException("Provide proper input");
        if(n==s.length)
            resize(2*s.length);
        s[n++] = item; 
    }

    // remove and return the item from the front
    public Item removeFirst(){
        System.out.println("removefirst entering");
        if (isEmpty()) 
            throw new NoSuchElementException("Queue underflow");
        Item item = s[head];
        s[head--] = null;
        n--;
        if(head==s.length)
            head = 0;
        if(n>0 && n==s.length/2)
            resize(s.length/2);
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        System.out.println("removelast entering");
        if (isEmpty()) 
        throw new NoSuchElementException("Queue underflow");
        Item item = s[n];
        s[n--] = null;
        if(head==s.length)
            head = 0;
        if(n>0 && n==s.length/2)
            resize(s.length/2);
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ArrayIterator(); 
    }

    public class ArrayIterator() implements Iterable<Item>{
        private int i = n;
		public boolean hasNext(){
			return i>0;
		}
		public void remove(){
		}
		public Item next(){
			return s[--i];
		}
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque d = new Deque<Integer>();
        d.addFirst(3);
        d.addFirst(2);
        d.addFirst(1);
        d.addFirst(4);
    }

}