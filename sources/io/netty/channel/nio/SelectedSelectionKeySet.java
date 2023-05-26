package io.netty.channel.nio;

import j$.util.Iterator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SelectedSelectionKeySet extends AbstractSet<SelectionKey> {
    SelectionKey[] keys = new SelectionKey[Spliterator.IMMUTABLE];
    int size;

    /* renamed from: io.netty.channel.nio.SelectedSelectionKeySet$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Iterator<SelectionKey>, j$.util.Iterator {
        private int idx;

        AnonymousClass1() {
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super SelectionKey> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.idx < SelectedSelectionKeySet.this.size) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public SelectionKey next() {
            if (hasNext()) {
                SelectionKey[] selectionKeyArr = SelectedSelectionKeySet.this.keys;
                int i8 = this.idx;
                this.idx = i8 + 1;
                return selectionKeyArr[i8];
            }
            throw new NoSuchElementException();
        }
    }

    private void increaseCapacity() {
        SelectionKey[] selectionKeyArr = this.keys;
        SelectionKey[] selectionKeyArr2 = new SelectionKey[selectionKeyArr.length << 1];
        System.arraycopy(selectionKeyArr, 0, selectionKeyArr2, 0, this.size);
        this.keys = selectionKeyArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator<SelectionKey> iterator() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        reset(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(SelectionKey selectionKey) {
        if (selectionKey == null) {
            return false;
        }
        SelectionKey[] selectionKeyArr = this.keys;
        int i8 = this.size;
        int i9 = i8 + 1;
        this.size = i9;
        selectionKeyArr[i8] = selectionKey;
        if (i9 == selectionKeyArr.length) {
            increaseCapacity();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset(int i8) {
        Arrays.fill(this.keys, i8, this.size, (Object) null);
        this.size = 0;
    }
}
