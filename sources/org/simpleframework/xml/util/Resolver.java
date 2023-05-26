package org.simpleframework.xml.util;

import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.util.Match;

/* loaded from: classes5.dex */
public class Resolver<M extends Match> extends AbstractSet<M> {
    protected final Resolver<M>.Stack stack = new Stack();
    protected final Resolver<M>.Cache cache = new Cache();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Cache extends LimitedCache<List<M>> {
        public Cache() {
            super(Spliterator.IMMUTABLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Stack extends LinkedList<M> {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public class Sequence implements Iterator<M>, j$.util.Iterator {
            private int cursor;

            public Sequence() {
                this.cursor = Stack.this.size();
            }

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                if (this.cursor > 0) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public void remove() {
                Stack.this.purge(this.cursor);
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public M next() {
                if (hasNext()) {
                    Stack stack = Stack.this;
                    int i8 = this.cursor - 1;
                    this.cursor = i8;
                    return (M) stack.get(i8);
                }
                return null;
            }
        }

        private Stack() {
        }

        public void purge(int i8) {
            Resolver.this.cache.clear();
            remove(i8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.LinkedList, java.util.Deque
        public /* bridge */ /* synthetic */ void push(Object obj) {
            push((Stack) ((Match) obj));
        }

        public java.util.Iterator<M> sequence() {
            return new Sequence();
        }

        public void push(M m8) {
            Resolver.this.cache.clear();
            addFirst(m8);
        }
    }

    private boolean match(char[] cArr, char[] cArr2) {
        return match(cArr, 0, cArr2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Resolver<M>) ((Match) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.cache.clear();
        this.stack.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator<M> iterator() {
        return (java.util.Iterator<M>) this.stack.sequence();
    }

    public boolean remove(M m8) {
        this.cache.clear();
        return this.stack.remove(m8);
    }

    public M resolve(String str) {
        List<M> list = (List) this.cache.get(str);
        if (list == null) {
            list = resolveAll(str);
        }
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<M> resolveAll(String str) {
        List<M> list = (List) this.cache.get(str);
        if (list != null) {
            return list;
        }
        char[] charArray = str.toCharArray();
        if (charArray == null) {
            return null;
        }
        return resolveAll(str, charArray);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.stack.size();
    }

    private boolean match(char[] cArr, int i8, char[] cArr2, int i9) {
        while (i9 < cArr2.length && i8 < cArr.length) {
            if (cArr2[i9] == '*') {
                while (true) {
                    char c8 = cArr2[i9];
                    if (c8 == '*') {
                        i9++;
                        if (i9 >= cArr2.length) {
                            return true;
                        }
                    } else if (c8 == '?' && (i9 = i9 + 1) >= cArr2.length) {
                        return true;
                    } else {
                        while (i8 < cArr.length) {
                            char c9 = cArr[i8];
                            char c10 = cArr2[i9];
                            if (c9 == c10 || c10 == '?') {
                                if (cArr2[i9 - 1] == '?') {
                                    break;
                                } else if (match(cArr, i8, cArr2, i9)) {
                                    return true;
                                }
                            }
                            i8++;
                        }
                        if (cArr.length == i8) {
                            return false;
                        }
                    }
                }
            }
            int i10 = i8 + 1;
            int i11 = i9 + 1;
            if (cArr[i8] != cArr2[i9] && cArr2[i11 - 1] != '?') {
                return false;
            }
            i8 = i10;
            i9 = i11;
        }
        if (cArr2.length == i9) {
            return cArr.length == i8;
        }
        while (cArr2[i9] == '*') {
            i9++;
            if (i9 >= cArr2.length) {
                return true;
            }
        }
        return false;
    }

    public boolean add(M m8) {
        this.stack.push((Resolver<M>.Stack) m8);
        return true;
    }

    private List<M> resolveAll(String str, char[] cArr) {
        ArrayList arrayList = new ArrayList();
        java.util.Iterator<M> it = this.stack.iterator();
        while (it.hasNext()) {
            Match match = (Match) it.next();
            if (match(cArr, match.getPattern().toCharArray())) {
                this.cache.put(str, arrayList);
                arrayList.add(match);
            }
        }
        return arrayList;
    }
}
