package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {

	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of
	// elements is full
	public void growSize() {
		int newCapacity = elements.length * 2;

		E[] newElement = (E[]) new Object[newCapacity];

		for (int i = 0; i < newCapacity; i++) {
			newElement[i] = elements[i];
		}
		elements = newElement;
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {

		return elements[i];
	}

	// Replaces the element at index i with e, and
	// returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		elements[i] = e;
		return e;
	}

	// It is used to append the specified element at the
	// end of a list.
	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all
	// subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (size == elements.length) {
			growSize();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
	}

	// Removes and returns the element at index i,
	// shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {

		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}
		size--;
		return elements[i];
	}

	// Then implements other methods as in Java Collection Framework -
	// ArrayList.java
	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	// It is used to return the index in this list of the
	// last occurrence of the specified element, or -1 if the
	// list does not contain this element.
	public int lastIndexOf(Object o) {

		if (o != null) {

			for (int i = size - 1; i >= 0; i--) {
				if (elements[i].equals(o)) {
					return i;
				}
			}
		}

		return -1;
	}

	// It is used to return an array containing all of the
	// elements in this list in the correct order.DS - LAB - NLU
	// (Semester 1, 2023/2024)
	// 3
	public E[] toArray() {
		  return Arrays.copyOf(elements, size);
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> result = new MyArrayList<E>() ;
         result.elements = Arrays.copyOf(elements, size);
        
         return result;
	}

	// It returns true if the list contains the specified
	// element
	public boolean contains(E o) {
		if (o != null) {

			for (int i = 0; i < size; i++) {
				if (elements[i].equals(o)) {
					return true;
				}
			}
		}
		return false;
	}

	// It is used to return the index in this list of the
	// first occurrence of the specified element, or -1 if the
	// List does not contain this element.
	public int indexOf(E o) {
		if (o != null) {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(o)) {
					return i;
				}
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the
	// specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
	        if (e == null ? elements[i] == null : e.equals(elements[i])) {
	          
	            for (int j = i; j < size - 1; j++) {
	                elements[j] = elements[j + 1];
	            }
	            elements[size - 1] = null; 
	            size--; 
	            return true; 
	        }
	    }
	    return false;
	}

	// It is used to sort the elements of the list on the
	// basis of specified comparator.
	public void sort(Comparator<E> c) {
		 quickSort(0, size - 1, c);
	}
	private void quickSort(int low, int high, Comparator<E> c) {
        if (low < high) {
            int partitionIndex = partition(low, high, c);

            quickSort(low, partitionIndex - 1, c);
            quickSort(partitionIndex + 1, high, c);
        }
    }

    private int partition(int low, int high, Comparator<E> c) {
        E pivot = (E) elements[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (c.compare((E) elements[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    @SuppressWarnings("unchecked")
	private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = (E) temp;
    }
   

}
