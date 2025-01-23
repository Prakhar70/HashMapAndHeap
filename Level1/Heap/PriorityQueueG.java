package Level1.Heap;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueueG<T> {
    ArrayList<T> data;
    Comparator<T> comp;

    public PriorityQueueG() {
        data = new ArrayList<T>();
        comp = null;
    }

    public PriorityQueueG(Comparator<T> comp) {
        data = new ArrayList<T>();
        this.comp = comp;
    }

    public void add(T val) {
        this.data.add(val);
        upheapify(this.data.size() - 1);
    }

    private boolean isSmaller(int i, int j) {
        if (this.comp == null) {
            Comparable ith = (Comparable) data.get(i);
            Comparable jth = (Comparable) data.get(j);
            if (ith.compareTo(jth) < 0) {
                return true;
            }
            return false;
        } else {
            T ith = data.get(i);
            T jth = data.get(j);
            if (comp.compare(ith, jth) < 0) {
                return true;
            }
            return false;
        }

    }

    private void upheapify(int ci) {
        if (ci == 0) {
            return;
        }
        int pi = ci - 1 / 2;
        if (isSmaller(ci, pi) == true) {
            swap(pi, ci);
            upheapify(pi);
        }

    }

    private void swap(int i, int j) {
        T temp = this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, temp);

    }

    public T remove() {
        if (size() == 0) {
            System.out.println("Underflow");
            return null;
        }
        swap(0, size() - 1);
        T val = data.remove(this.size() - 1);
        downheapify(0);
        return val;
    }

    private void downheapify(int pi) {
        int mini = pi;
        int lci = pi * 2 + 1;
        int rci = pi * 2 + 2;
        if (lci < size() - 1 && isSmaller(lci, mini) == true) {
            mini = lci;
        }
        if (rci < size() - 1 && isSmaller(rci, mini) == true) {
            mini = rci;
        }
        if (mini != pi) {
            swap(mini, pi);
            downheapify(mini);
        }
    }

    public T peek() {
        if (size() != 0) {
            System.out.println("No Element present");
            return null;
        }
        return this.data.get(0);
    }

    public int size() {
        return this.data.size();
    }
}
