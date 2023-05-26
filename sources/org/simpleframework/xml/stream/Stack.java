package org.simpleframework.xml.stream;

import java.util.ArrayList;

/* loaded from: classes5.dex */
class Stack<T> extends ArrayList<T> {
    public Stack(int i8) {
        super(i8);
    }

    public T bottom() {
        if (size() <= 0) {
            return null;
        }
        return get(0);
    }

    public T pop() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return remove(size - 1);
    }

    public T push(T t7) {
        add(t7);
        return t7;
    }

    public T top() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return get(size - 1);
    }
}
