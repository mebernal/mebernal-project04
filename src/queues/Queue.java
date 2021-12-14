package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class Queue which implements Iterable. Objects of type Queue manage items in a
 * singly linked list where we can enqueue() from the front and dequeue() from the
 * rear of the queue.
 *
 * @author Foothill College, Michael Bernal
 */
public class Queue<E> implements Iterable<E>
{
    /**
     * class attributes
     */
    private String name;
    private Node head;
    private Node tail;
    private int size;

    /**
     * A constructor which takes in a user assigned name and initializes the class attributes.
     * @param name user assigned name.
     */
    Queue(String name)
    {
        this.name = name;
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * method enqueue() which takes a generic item as the argument and adds the item to the end of the queue.
     * @param item the generic item.
     */
    public void enqueue(E item)
    {
        if(item == null)
            return;

        Node tailNode = tail;
        tail = new Node(item);
        tail.next = null;

        if(isEmpty())
            head = tail;
        else
            tailNode.next = tail;

        size++;
    }

    /**
     * method dequeue which receives no argument and removes the item from the front of the queue.
     * throws NoSuchElementException() is the queue is empty.
     * @return generic item dequeued.
     */
    public E dequeue()
    {
        Node tmp = head;

        if(isEmpty())
           throw new NoSuchElementException();

        head = head.next;
        tmp.next = null;
        size--;

        return tmp.item;
    }

    /**
     * method peek() which looks at the least recently added item of the queue and returns an object of the
     * generic type for the data seen at the front of the queue.
     * @return an object of the generic type for the data seen at the front.
     */
    public E peek()
    {
        if(isEmpty())
            return null;

        return head.item;
    }

    /**
     * isEmpty() method checks to see if the queue is empty.
     * @return null
     */
    public boolean isEmpty()
    {
        return(head == null);
    }

    /**
     * method size() returns playlist size.
     * @return size of the playlist.
     */
    public int size()
    {
        return size;
    }

    /**
     * method to format output.
     * @return returns String output.
     */
    public String toString()
    {
        Node n;
        String str = this.name + ":\n";

        for(n = head; n != null; n = n.next)
        {
            str += "[" + n.toString() + ",]\n";
        }

        return str;
    }

    /**
     * accessor method.
     * @return name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * an inner class Node with attributes next of type Node and data of a generic type.
     */
    private class Node
    {
        Node next;
        E item;

        Node(E x)
        {
            next = null;
            item = x;
        }

        public String toString()
        {
            String str = item.toString();
            return str;
        }
    }

    /**
     * The inner QueueIterator parametrized class which implements an the Iterator interface.
     */
    private class QueueIterator implements Iterator<E>
    {
        private Node cur = tail;

        public boolean hasNext()
        {
            return cur != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public E next()
        {
            if(!hasNext())
                throw new NoSuchElementException();

            E tmp = cur.item;
            cur = cur.next;

            return tmp;
        }
    }

    public Iterator<E> iterator()
    {
        return new QueueIterator();
    }
}
