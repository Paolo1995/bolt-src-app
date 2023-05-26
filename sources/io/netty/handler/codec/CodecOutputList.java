package io.netty.handler.codec;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class CodecOutputList extends AbstractList<Object> implements RandomAccess {
    private Object[] array;
    private boolean insertSinceRecycled;
    private final CodecOutputListRecycler recycler;
    private int size;
    private static final CodecOutputListRecycler NOOP_RECYCLER = new CodecOutputListRecycler() { // from class: io.netty.handler.codec.CodecOutputList.1
        @Override // io.netty.handler.codec.CodecOutputList.CodecOutputListRecycler
        public void recycle(CodecOutputList codecOutputList) {
        }
    };
    private static final FastThreadLocal<CodecOutputLists> CODEC_OUTPUT_LISTS_POOL = new FastThreadLocal<CodecOutputLists>() { // from class: io.netty.handler.codec.CodecOutputList.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public CodecOutputLists initialValue() throws Exception {
            return new CodecOutputLists(16);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface CodecOutputListRecycler {
        void recycle(CodecOutputList codecOutputList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class CodecOutputLists implements CodecOutputListRecycler {
        private int count;
        private int currentIdx;
        private final CodecOutputList[] elements;
        private final int mask;

        CodecOutputLists(int i8) {
            this.elements = new CodecOutputList[MathUtil.safeFindNextPositivePowerOfTwo(i8)];
            int i9 = 0;
            while (true) {
                CodecOutputList[] codecOutputListArr = this.elements;
                if (i9 < codecOutputListArr.length) {
                    codecOutputListArr[i9] = new CodecOutputList(this, 16);
                    i9++;
                } else {
                    this.count = codecOutputListArr.length;
                    this.currentIdx = codecOutputListArr.length;
                    this.mask = codecOutputListArr.length - 1;
                    return;
                }
            }
        }

        public CodecOutputList getOrCreate() {
            int i8 = this.count;
            if (i8 == 0) {
                return new CodecOutputList(CodecOutputList.NOOP_RECYCLER, 4);
            }
            this.count = i8 - 1;
            int i9 = (this.currentIdx - 1) & this.mask;
            CodecOutputList codecOutputList = this.elements[i9];
            this.currentIdx = i9;
            return codecOutputList;
        }

        @Override // io.netty.handler.codec.CodecOutputList.CodecOutputListRecycler
        public void recycle(CodecOutputList codecOutputList) {
            int i8 = this.currentIdx;
            this.elements[i8] = codecOutputList;
            this.currentIdx = this.mask & (i8 + 1);
            this.count++;
        }
    }

    private void checkIndex(int i8) {
        if (i8 < this.size) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    private void expandArray() {
        Object[] objArr = this.array;
        int length = objArr.length << 1;
        if (length >= 0) {
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            this.array = objArr2;
            return;
        }
        throw new OutOfMemoryError();
    }

    private void insert(int i8, Object obj) {
        this.array[i8] = obj;
        this.insertSinceRecycled = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodecOutputList newInstance() {
        return CODEC_OUTPUT_LISTS_POOL.get().getOrCreate();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        try {
            insert(this.size, obj);
        } catch (IndexOutOfBoundsException unused) {
            expandArray();
            insert(this.size, obj);
        }
        this.size++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        checkIndex(i8);
        return this.array[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getUnsafe(int i8) {
        return this.array[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycle() {
        for (int i8 = 0; i8 < this.size; i8++) {
            this.array[i8] = null;
        }
        this.size = 0;
        this.insertSinceRecycled = false;
        this.recycler.recycle(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i8) {
        checkIndex(i8);
        Object[] objArr = this.array;
        Object obj = objArr[i8];
        int i9 = (this.size - i8) - 1;
        if (i9 > 0) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, i9);
        }
        Object[] objArr2 = this.array;
        int i10 = this.size - 1;
        this.size = i10;
        objArr2[i10] = null;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i8, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i8);
        Object obj2 = this.array[i8];
        insert(i8, obj);
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private CodecOutputList(CodecOutputListRecycler codecOutputListRecycler, int i8) {
        this.recycler = codecOutputListRecycler;
        this.array = new Object[i8];
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i8);
        if (this.size == this.array.length) {
            expandArray();
        }
        int i9 = this.size;
        if (i8 != i9) {
            Object[] objArr = this.array;
            System.arraycopy(objArr, i8, objArr, i8 + 1, i9 - i8);
        }
        insert(i8, obj);
        this.size++;
    }
}
