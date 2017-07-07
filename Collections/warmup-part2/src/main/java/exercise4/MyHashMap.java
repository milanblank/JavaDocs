package exercise4;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 * <p>
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>();
        for (int i = 0; i < 16; i++) {
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public String get(String key) {
        //
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
        //
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
        for (LinkedList<MyEntry> bucket: buckets) {
            ListIterator<MyEntry> it = bucket.listIterator();
            while (it.hasNext()){
                MyEntry myEntry = it.next();
                keys.add(myEntry.getKey());
            }
        }
        return keys;
    }

    public Collection<String> values() {
        // TODO
        Collection<String> values = new ArrayList<String>();
        for (LinkedList<MyEntry> bucket: buckets) {
            ListIterator<MyEntry> it = bucket.listIterator();
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
        for (LinkedList<MyEntry> bucket : buckets) {
            ListIterator<MyEntry> it = bucket.listIterator();
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
        for (LinkedList<MyEntry> bucket : buckets) {
            ListIterator<MyEntry> it = bucket.listIterator();
            while (it.hasNext()){
                counter++;
            }
        }
        return counter;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        for (LinkedList bucket : buckets) {
            bucket.clear();
        }
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects

        return null;
    }

    public boolean isEmpty() {
        // TODO
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
