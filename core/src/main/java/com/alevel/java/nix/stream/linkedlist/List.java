package com.alevel.java.nix.stream.linkedlist;

import java.util.AbstractList;
import java.util.Objects;

public class List<E> extends AbstractList<E> {

    private static final Object[] DEFAULT_EMPTY_ARRAY = {};

    transient Object[] elementData;
    private int size = 0;

    private ListElement<E> head;
    private ListElement<E> tail;

    public List() {
        this.elementData = DEFAULT_EMPTY_ARRAY;
    }

    public List(int size) {
        this.size = size;
    }


    void addFront(E data) {
        ListElement<E> element = new ListElement<>();
        element.data = data;
        if (head == null) {
            head = element;
            tail = element;
        } else {
            element.next = head;
            head = element;
        }
        size++;
    }

    void addBack(E data) {
        ListElement<E> element = new ListElement<>();
        element.data = data;
        if (tail == null) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
        size++;
    }

    void printList() {
        ListElement<E> head = this.head;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    void delete(E data) {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        ListElement<E> head = this.head;
        while (head.next != null) {
            if (head.next.data == data) {
                if (tail == head.next) {
                    tail = head;
                }
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }
        size--;
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    @Override
    public int size() {
        return size;
    }
}
