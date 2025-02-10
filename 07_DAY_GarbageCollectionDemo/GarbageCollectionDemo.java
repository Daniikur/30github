import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class GarbageCollectionDemo {
    static class TestObject {
        private int id;

        public TestObject(int id) {
            this.id = id;
            System.out.println("Object " + id + " created.");
        }
    }

    public static void main(String[] args) {
        ReferenceQueue<TestObject> refQueue = new ReferenceQueue<>();
        TestObject obj1 = new TestObject(1);
        TestObject obj2 = new TestObject(2);
        
        PhantomReference<TestObject> ref1 = new PhantomReference<>(obj1, refQueue);
        PhantomReference<TestObject> ref2 = new PhantomReference<>(obj2, refQueue);

        obj1 = null; // Dereferencing obj1
        obj2 = null; // Dereferencing obj2
        
        System.gc(); // Request garbage collection
        
        System.out.println("End of main method.");
    }
}
