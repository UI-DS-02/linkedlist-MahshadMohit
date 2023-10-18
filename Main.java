
class DoubleList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element , Node<E> prev , Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        public E getElement(){return element;}
        public Node<E> getPrev(){return prev;}
        public Node<E> getNext(){return next;}
        public void setPrev(Node<E> p){this.prev = p;}
        public void setNext(Node<E> n){this.next = n;}


    }
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0 ;
    public DoubleList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }
    // size
    public int size(){return size;}
    // isEmpty
    public boolean isEmpty(){return size==0;}
    // first
    public E first(){
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }
    // last
    public E last(){
        if (isEmpty()) return null;
        return trailer.getNext().getElement();
    }
    // add first
    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }
    // add last
    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }
    public void addBetween(E e,Node<E> pre , Node<E> s){
        Node<E> newst = new Node<>(e,pre,s);
        pre.setNext(newst);
        s.setPrev(newst);
        size++;
    }
    // remove first
    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(header.getNext());
    }
    // remove last
    public E removeLast(){
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }
    // sort
    public void sort(DoubleList<Integer> list){
        Node<Integer> current = null;
        current = list.header;
        Node<Integer> next = null;
        int temp;
        if(isEmpty()){
            //  ...
        }else{
            for (;current.next!=null;current = current.next){
                for(next = current.next;next!=null;next=next.next){
                    if (current.getElement() > next.getElement()){
                        temp = current.element;
                        current.element = next.element;
                        next.element = temp;
                    }
                }
            }
        }
    }

    // add an element to the i-th position
    public void add(int i , E e){
        int j = 1;
        Node<E> current = header;
        Node<E> node = new Node<>(e,null,null);
        while (j <= i){
            current = current.next;
            j++;
        }
        Node<E> pervious = current.next;
        current.next = node;
        node.prev = current;
        node.next = pervious;
        pervious.prev = node;
    }
    //remove the i-th position of a list and return it

    // get the i-th position
    public Node<E> getIndex(int i){
        Node<E> current = header;
        Node<E> prev = null;
        for (int j = 1; j <= i; j++) {
            prev = current;
            current = current.next;
        }
        return current;
    }
    public E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }



}


public class Main {
    public static void main(String[] args) {

    }
}