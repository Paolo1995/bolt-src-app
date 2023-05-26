package org.simpleframework.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public class WeakCache<T> implements Cache<T> {
    private WeakCache<T>.SegmentList list;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Segment extends WeakHashMap<Object, T> {
        private Segment() {
        }

        public synchronized void cache(Object obj, T t7) {
            put(obj, t7);
        }

        public synchronized boolean contains(Object obj) {
            return containsKey(obj);
        }

        public synchronized T fetch(Object obj) {
            return get(obj);
        }

        public synchronized T take(Object obj) {
            return remove(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SegmentList implements Iterable<WeakCache<T>.Segment> {
        private List<WeakCache<T>.Segment> list = new ArrayList();
        private int size;

        public SegmentList(int i8) {
            this.size = i8;
            create(i8);
        }

        private void create(int i8) {
            while (true) {
                int i9 = i8 - 1;
                if (i8 > 0) {
                    this.list.add(new Segment());
                    i8 = i9;
                } else {
                    return;
                }
            }
        }

        private int segment(Object obj) {
            return Math.abs(obj.hashCode() % this.size);
        }

        public WeakCache<T>.Segment get(Object obj) {
            int segment = segment(obj);
            if (segment < this.size) {
                return this.list.get(segment);
            }
            return null;
        }

        @Override // java.lang.Iterable
        public Iterator<WeakCache<T>.Segment> iterator() {
            return this.list.iterator();
        }
    }

    public WeakCache() {
        this(10);
    }

    private WeakCache<T>.Segment map(Object obj) {
        return this.list.get(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public void cache(Object obj, T t7) {
        map(obj).cache(obj, t7);
    }

    @Override // org.simpleframework.xml.util.Cache
    public boolean contains(Object obj) {
        return map(obj).contains(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public T fetch(Object obj) {
        return map(obj).fetch(obj);
    }

    @Override // org.simpleframework.xml.util.Cache
    public boolean isEmpty() {
        Iterator<WeakCache<T>.Segment> it = this.list.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // org.simpleframework.xml.util.Cache
    public T take(Object obj) {
        return map(obj).take(obj);
    }

    public WeakCache(int i8) {
        this.list = new SegmentList(i8);
    }
}
