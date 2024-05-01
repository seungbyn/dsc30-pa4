//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        DoublyLinkedList test1 = new DoublyLinkedList();
        test1.add(1);
        test1.add(2);
        test1.add(0, 0);
        test1.set(0, 7);
        System.out.println(test1.get(0));
        System.out.println(test1.get(1));
        System.out.println(test1.get(2));
        System.out.println(test1);
        System.out.println(test1.contains(2));
        System.out.println(test1.remove(1));


        test1.clear();
        System.out.println(test1.size());
    }
}