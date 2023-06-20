/**
 * @author Selim Aynigul
 */
package package3;

import java.util.AbstractList;
import java.util.List;

public class LDLinkedList<E> extends AbstractList<E> implements List<E> {
    private Node<E> head;
    private int size;
    private int deletedCount;
    
    private class Node<E> {
        E data;
        Node<E> next;
        boolean isDeleted;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.isDeleted = false;
        }
    }

    public LDLinkedList() {
        head = new Node<>(null);
        size = 0;
        deletedCount = 0;
    }
    
    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);
        Node<E> lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        Node<E> current = head.next;
        for (int i = 0; i < index; i++) {
            // if a node is deleted increase index by one and pass that node
            if(current.next.isDeleted) {
                index++;
            }   
            current = current.next;  
        }                                
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object object) {
        Node<E> prev = head;
        Node<E> current = prev.next;
        while (current != null) {
            if (current.data == object) {
                size--;
                deletedCount++;
                current.isDeleted = true;
                // if 2 nodes deleted, remove them physically
                if (deletedCount == 2) {
                    deleteNodes();
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }
    
    private void deleteNodes() {
        Node<E> prev = head;
        Node<E> current = prev.next;
        while (current != null) {
            // if marked as lazily deleted remove physically
            if (current.isDeleted) {
                prev.next = current.next;
                current.next = null;
                current = prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        // Reset the counter after removing the lazily deleted nodes
        deletedCount = 0; 
    }

    @Override
    public boolean contains(Object object) {
        Node<E> current = head.next;
        while (current != null) {
            if (!current.isDeleted && current.data == object) { 
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
}
