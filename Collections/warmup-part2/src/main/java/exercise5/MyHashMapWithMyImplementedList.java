package exercise5;

import java.util.*;

/**
 * Create a HashMap that uses to store the buckets your implementation of MyImplementedList that you
 * created in the Collections I workshop.
 *
 * Created by Radu.Hoaghe on 7/6/2017.
 */
public class MyHashMapWithMyImplementedList {

    // uncomment the following line and add your MyImplementedList implementation to the project
    private MyImplementedList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMapWithMyImplementedList() {
        // TODO
        buckets = new MyImplementedList<LinkedList<MyEntry>>();
        for (int i = 0; i < 16; i++) {
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public String get(String key) {
        // TODO
        int bucketNumber = 0;
        if(key != null) {
            bucketNumber = Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;
        }
        LinkedList<MyEntry> myEntries = buckets.get(bucketNumber);
        ListIterator<MyEntry> it = myEntries.listIterator();
        while (it.hasNext()) {
            MyEntry myEntry = it.next();
            if (myEntry.getKey().equals(key))
                return myEntry.getValue();
        }
        return null;
    }

    public void put(String key, String value) {
        // TODO
        int bucketNumber = 0;
        if (key != null) {
            bucketNumber = Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;
        }
        MyEntry myEntry = new MyEntry(key, value);
        buckets.get(bucketNumber).add(myEntry);
    }

    public Set<String> keySet() {
        // TODO
        Set<String> keys = new HashSet<String>();
        Iterator<LinkedList<MyEntry>> iterator = buckets.iterator();
        while(iterator.hasNext()){
            final LinkedList<MyEntry> myEntries = iterator.next();
            ListIterator<MyEntry> it = myEntries.listIterator();
            while (it.hasNext()){
                MyEntry myEntry = it.next();
                keys.add(myEntry.getKey());
            }
        }
        return keys;
//        return null;
    }

    public Collection<String> values() {
        // TODO
        Collection<String> values = new ArrayList<String>();
        Iterator<LinkedList<MyEntry>> iterator = buckets.iterator();
        while (iterator.hasNext()){
            LinkedList<MyEntry> myEntries = iterator.next();
            ListIterator<MyEntry> it = myEntries.listIterator();
            while (it.hasNext()){
                MyEntry myEntry = it.next();
                values.add(myEntry.getValue());
            }
        }
        return values;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        int bucketNumber = 0;
        if(key != null) {
            bucketNumber = Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;
        }
        LinkedList<MyEntry> myEntries = buckets.get(bucketNumber);
        ListIterator<MyEntry> it = myEntries.listIterator();
        while (it.hasNext()) {
            MyEntry myEntry = it.next();
            String value = "";
            if (myEntry.getKey().equals(key)){
                value = myEntry.getValue();
                it.remove();
            }
            return value;
        }
        return null;
    }

    public boolean containsKey(String key) {
        // TODO
        int bucketNumber = 0;
        if(key != null) {
            bucketNumber = Math.abs(key.hashCode()) % BUCKET_ARRAY_SIZE;
        }
        LinkedList<MyEntry> myEntries = buckets.get(bucketNumber);
        ListIterator<MyEntry> it = myEntries.listIterator();
        while (it.hasNext()) {
            MyEntry myEntry = it.next();
            if (myEntry.getKey().equals(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        Iterator<LinkedList<MyEntry>> iterator = buckets.iterator();
        while(iterator.hasNext()){
            LinkedList<MyEntry> myEntries = iterator.next();
            ListIterator<MyEntry> it = myEntries.listIterator();
            while (it.hasNext()) {
                MyEntry myEntry = it.next();
                if(myEntry.getValue().equals(value))
                    return true;
            }
        }
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        int counter = 0;
        Iterator<LinkedList<MyEntry>> iterator = buckets.iterator();
        while (iterator.hasNext()){
            LinkedList<MyEntry> myEntries = iterator.next();
            ListIterator<MyEntry> it = myEntries.listIterator();
            while (it.hasNext()){
                counter++;
            }
        }
        return counter;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        Iterator<LinkedList<MyEntry>> iterator = buckets.iterator();
        while (iterator.hasNext())
            iterator.next().clear();
    }

    // I HAVE CHANGED MyHashMap.MyEntry to MyEntry
    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects

        Set<MyEntry> myEntrySet = new HashSet<MyEntry>();
        Iterator<LinkedList<MyEntry>> iterator = buckets.iterator();
        while (iterator.hasNext()){
            LinkedList<MyEntry> myEntries = iterator.next();
            ListIterator<MyEntry> it = myEntries.listIterator();
            while (it.hasNext()){
                MyEntry myEntry = it.next();
                myEntrySet.add(myEntry);
            }
        }
        return myEntrySet;
    }

    public boolean isEmpty() {
        // TODO
        Set<MyEntry> myEntrySet = new HashSet<MyEntry>();
        Iterator<LinkedList<MyEntry>> iterator = buckets.iterator();
        while (iterator.hasNext()){
            LinkedList<MyEntry> myEntries = iterator.next();
            ListIterator<MyEntry> it = myEntries.listIterator();
            while(it.hasNext()){
                MyEntry myEntry = it.next();
                myEntrySet.add(myEntry);
            }
        }
        if (myEntrySet.isEmpty())
            return true;
        return false;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

class MyImplementedList<E> {

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * The array buffer into which the elements of the {@link MyImplementedList} are stored.
     */
    private Object[] elementData;

    /**
     * Property to keep the extended capacity.
     *  if you choose another way to implement the extending capacity you can define your own properties,
     *  but the rest of them must remain as they are.
     */
    private int capacityAfterExtending;

    // a) implement the empty constructor for the your data structure
    public MyImplementedList() {
        // a) HINT - DEFAULT_CAPACITY, capacityAfterExtending and elementData properties
        size = 0;
        capacityAfterExtending =DEFAULT_CAPACITY;
        elementData = new Object[DEFAULT_CAPACITY];
    }

    // b) create the int size() method that returns the size of the data structure
    public int size(){
        return size;
    }

    // c) create the boolean add(E e) method that adds at the end of the data structure an element
    // pay attention to the LOAD_FACTOR of the data structure

    public boolean add(E e){
        extendCapacity();
        this.elementData[size++] = e;
        return true;
    }

    // d) create the boolean isEmpty() method that checks if the data structure have elements

    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    // e) create the boolean contains(Object o_O) method that checks if the data structure contains the object o_O

    public boolean contains(Object o_0){
        for (Object el : elementData){
            if(el.equals(o_0))
                return true;
        }
        return false;
    }

    // f) create the int indexOf(Object o_O) method that returns the position in the data structure of the object o_O
    // if exists, otherwise return -1

    public int indexOf(Object o_0){
        for (int i=0; i< elementData.length; i++){
            if(elementData[i].equals(o_0))
                return i;
        }
        return -1;
    }
    // g) create the int lastIndexOf(Object o_O) method that returns the last position in the data structure of the object o_O
    // if exists, otherwise return -1
    public int lastIndexOf(Object o_0){
        int position = -1;
        for (int i=0; i< elementData.length; i++){
            if(elementData[i].equals(o_0))
                position = i;
        }
        return position;
    }

    // h) create the E get(int index) method that returns the object from the given index
    // pay attention to the size property

    public E get(int index) throws MyImplementedListIndexOutOfBoundsException{
        if(index >= size)
            throw new MyImplementedListIndexOutOfBoundsException("Index at " + index + " is out of bounds." +
                    "Size of list is " + size +".");
        return (E)elementData[index];
    }

    // i) create the E set(int index, E element) method that updates the value of the element from the given index
    // pay attention to the size property

    public E set(int index, E element) throws MyImplementedListIndexOutOfBoundsException{
        Object previousElement = null;
        if(index > size) {
            throw new MyImplementedListIndexOutOfBoundsException("Index at " + index + " is out of bounds." +
                    "Size of list is " + size + ".");
        } else {
            extendCapacity();
            previousElement = elementData[index];
            elementData[index] = element;
            size++;
        }
        return (E)previousElement;
    }

    // j) create the E remove(int index) method that removes the element from the given index

    public E remove(int index) throws MyImplementedListIndexOutOfBoundsException{
        Object removedElement = null;
        if(index > size) {
            throw new MyImplementedListIndexOutOfBoundsException("Index at " + index + " is out of bounds." +
                    "Size of list is " + size + ".");
        } else {
            removedElement = elementData[index];
//            Object[] elementsToShift = new Object[size-index-1];
//            System.arraycopy(elementData, index+1, elementsToShift, 0, size-index-1);
            System.arraycopy(elementData, index+1, elementData, index, size-index-1);
            elementData[size-1] = null;
            size--;
        }
        return (E)removedElement;
    }

    // k) extend the current default capacity, if the number of elements in the data structure is > 75% of it
    // you should name it: void extendCapacity() - HINT use capacity, DEFAULT_CAPACITY, LOAD_FACTOR and INCREASE_SIZE_FACTOR
    private void extendCapacity(){
        if(this.size / this.DEFAULT_CAPACITY > this.LOAD_FACTOR){
            capacityAfterExtending *= INCREASE_SIZE_FACTOR;
            Object[] aux = new Object[size];
            System.arraycopy(elementData, 0, aux, 0, size);
            elementData = new Object[capacityAfterExtending];
            System.arraycopy(aux, 0, elementData, 0, size);
        }
    }


    // l) implement the iterator() method in order to use the foreach statement over your data structure - HINT Iterable interface
    // and implement a custom iterator for your custom data structure - methods boolean hasNext(), Object next() and void remove()

    public Iterator<E> iterator(){
        Iterator it = new Iterator() {
            int position = 0;
            public void remove() {
                MyImplementedList.this.remove(--position);
            }

            public boolean hasNext() {
                if (position == size)
                    return false;
                return true;
            }

            public Object next() {
                return elementData[position++];
            }
        };
        return it;
    }

    // m) implement a method, that uses a Comparator, for your data structure to sort the elements
    // you should name it: void sort(Comparator<? super E> c)
    // create a custom comparator that compares objects by their "what you want" :D - HINT Comparator interface

    public void sort(Comparator<? super E> c){
        Comparator com = new Comparator() {
            public int compare(Object o1, Object o2) {
                if (o1.hashCode() == o2.hashCode())
                    return 1;
                return 0;
            }
        };

    }
}
