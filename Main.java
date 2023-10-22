import java.util.Scanner;

class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElemnt() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // size function

    public int size() {
        return size;
    }

    // isEmpty function

    public boolean isEmpty() {
        return size == 0;
    }

    // first function

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElemnt();
    }

    // last function

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElemnt();
    }

    // addFirst function

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    // addLast function

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public void addBetween(E e, Node<E> p, Node<E> s) {
        Node<E> newst = new Node<>(e, p, s);
        p.setNext(newst);
        s.setPrev(newst);
        size++;
    }

    // removeFirst function

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    // removeLast function

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    public E remove(Node<E> node) {
        Node<E> p = node.getPrev();
        Node<E> s = node.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return node.getElemnt();
    }

    public void traverse() {
        Node<E> node = header.getNext();
        while (node != trailer) {
            System.out.println(node.getElemnt());
            node = node.getNext();
        }
    }

    // sort function

    public void sort(DoublyLinkedList<Integer> list) {
        Node<Integer> current;
        current = list.header.next;
        Node<Integer> next;
        int temp;
        if (isEmpty()) {
            return;
        } else {
            for (; current.next != null; current = current.next) {
                for (next = current.next; next != null; next = next.next) {
                    if (current.getElemnt() > next.getElemnt()) {
                        temp = current.element;
                        current.element = next.element;
                        next.element = temp;
                    }
                }
            }
        }
    }

    // get function

    public Node<E> getIndex(int i) {
        Node<E> current = header;

        for (int j = 1; j <= i; j++) {
            current = current.next;
        }
        return current;
    }

    // remove element by its index function

    public E removeByIndex(int i) {
        Node<E> node = getIndex(i);
        return remove(node);
    }

    // add an element to given index

    public void add(int i, E e) {
        int j = 1;
        Node<E> current = header;
        Node<E> node = new Node<>(e, null, null);
        while (j <= i) {
            current = current.next;
            j++;
        }
        Node<E> pervious = current.next;
        current.next = node;
        node.prev = current;
        node.next = pervious;
        pervious.prev = node;
    }

    public void print(){
        Node<E> current = header.next;
        while (current!=null){
            System.out.println(current.getElemnt());
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.startsWith("size")){
                sb.append(list.size()).append("\n");
            }else if (command.startsWith("isEmpty")){
                sb.append(list.isEmpty()).append("\n");
            } else if (command.startsWith("first")) {
                sb.append(list.first()).append("\n");
            } else if (command.startsWith("last")) {
                sb.append(list.last()).append("\n");
            } else if (command.startsWith("addFirst")) {
                int a = sc.nextInt();
                list.addFirst(a);
            } else if (command.startsWith("addLast")) {
                int a = sc.nextInt();
                list.addLast(a);

            } else if (command.startsWith("removeFirst")) {
                sb.append(list.removeFirst()).append("\n");
            } else if (command.startsWith("removeLast")) {
                sb.append(list.removeLast()).append("\n");
            } else if (command.startsWith("sort")) {
                list.sort(list);
            }else if(command.startsWith("add")){
                int a = sc.nextInt();
                int b = sc.nextInt();
                list.add(a,b);
            } else if (command.startsWith("remove")) {
                int a = sc.nextInt();
                sb.append(list.removeByIndex(a)).append("\n");
            } else if (command.startsWith("get")) {
                int a = sc.nextInt();
                sb.append(list.getIndex(a)).append("\n");
            }
        }
        System.out.println(sb.toString());
        list.print();




    }


}