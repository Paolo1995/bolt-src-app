package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.protobuf.ByteString;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RopeByteString extends ByteString {

    /* renamed from: o  reason: collision with root package name */
    static final int[] f17562o = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Api.BaseClientBuilder.API_PRIORITY_OTHER};

    /* renamed from: j  reason: collision with root package name */
    private final int f17563j;

    /* renamed from: k  reason: collision with root package name */
    private final ByteString f17564k;

    /* renamed from: l  reason: collision with root package name */
    private final ByteString f17565l;

    /* renamed from: m  reason: collision with root package name */
    private final int f17566m;

    /* renamed from: n  reason: collision with root package name */
    private final int f17567n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Balancer {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<ByteString> f17571a;

        private Balancer() {
            this.f17571a = new ArrayDeque<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.f17571a.pop();
            while (!this.f17571a.isEmpty()) {
                pop = new RopeByteString(this.f17571a.pop(), pop);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.x()) {
                e(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.f17564k);
                c(ropeByteString.f17565l);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int d(int i8) {
            int binarySearch = Arrays.binarySearch(RopeByteString.f17562o, i8);
            if (binarySearch < 0) {
                return (-(binarySearch + 1)) - 1;
            }
            return binarySearch;
        }

        private void e(ByteString byteString) {
            int d8 = d(byteString.size());
            int X = RopeByteString.X(d8 + 1);
            if (!this.f17571a.isEmpty() && this.f17571a.peek().size() < X) {
                int X2 = RopeByteString.X(d8);
                ByteString pop = this.f17571a.pop();
                while (!this.f17571a.isEmpty() && this.f17571a.peek().size() < X2) {
                    pop = new RopeByteString(this.f17571a.pop(), pop);
                }
                RopeByteString ropeByteString = new RopeByteString(pop, byteString);
                while (!this.f17571a.isEmpty()) {
                    if (this.f17571a.peek().size() >= RopeByteString.X(d(ropeByteString.size()) + 1)) {
                        break;
                    }
                    ropeByteString = new RopeByteString(this.f17571a.pop(), ropeByteString);
                }
                this.f17571a.push(ropeByteString);
                return;
            }
            this.f17571a.push(byteString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class PieceIterator implements Iterator<ByteString.LeafByteString>, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private final ArrayDeque<RopeByteString> f17572f;

        /* renamed from: g  reason: collision with root package name */
        private ByteString.LeafByteString f17573g;

        private ByteString.LeafByteString b(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f17572f.push(ropeByteString);
                byteString = ropeByteString.f17564k;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString c() {
            ByteString.LeafByteString b8;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.f17572f;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    b8 = b(this.f17572f.pop().f17565l);
                } else {
                    return null;
                }
            } while (b8.isEmpty());
            return b8;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: d */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f17573g;
            if (leafByteString != null) {
                this.f17573g = c();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super ByteString.LeafByteString> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f17573g != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.v());
                this.f17572f = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.f17573g = b(ropeByteString.f17564k);
                return;
            }
            this.f17572f = null;
            this.f17573g = (ByteString.LeafByteString) byteString;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString U(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return V(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.f17565l.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.f17564k, V(ropeByteString.f17565l, byteString2));
            } else if (ropeByteString.f17564k.v() > ropeByteString.f17565l.v() && ropeByteString.v() > byteString2.v()) {
                return new RopeByteString(ropeByteString.f17564k, new RopeByteString(ropeByteString.f17565l, byteString2));
            }
        }
        if (size < X(Math.max(byteString.v(), byteString2.v()) + 1)) {
            return new Balancer().b(byteString, byteString2);
        }
        return new RopeByteString(byteString, byteString2);
    }

    private static ByteString V(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.s(bArr, 0, 0, size);
        byteString2.s(bArr, 0, size, size2);
        return ByteString.O(bArr);
    }

    private boolean W(ByteString byteString) {
        boolean R;
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString next = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString next2 = pieceIterator2.next();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int size = next.size() - i8;
            int size2 = next2.size() - i9;
            int min = Math.min(size, size2);
            if (i8 == 0) {
                R = next.R(next2, i9, min);
            } else {
                R = next2.R(next, i8, min);
            }
            if (!R) {
                return false;
            }
            i10 += min;
            int i11 = this.f17563j;
            if (i10 >= i11) {
                if (i10 == i11) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                i8 = 0;
                next = pieceIterator.next();
            } else {
                i8 += min;
                next = next;
            }
            if (min == size2) {
                next2 = pieceIterator2.next();
                i9 = 0;
            } else {
                i9 += min;
            }
        }
    }

    static int X(int i8) {
        int[] iArr = f17562o;
        if (i8 >= iArr.length) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return iArr[i8];
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream B() {
        return CodedInputStream.j(T(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int C(int i8, int i9, int i10) {
        int i11 = i9 + i10;
        int i12 = this.f17566m;
        if (i11 <= i12) {
            return this.f17564k.C(i8, i9, i10);
        }
        if (i9 >= i12) {
            return this.f17565l.C(i8, i9 - i12, i10);
        }
        int i13 = i12 - i9;
        return this.f17565l.C(this.f17564k.C(i8, i9, i13), 0, i10 - i13);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int D(int i8, int i9, int i10) {
        int i11 = i9 + i10;
        int i12 = this.f17566m;
        if (i11 <= i12) {
            return this.f17564k.D(i8, i9, i10);
        }
        if (i9 >= i12) {
            return this.f17565l.D(i8, i9 - i12, i10);
        }
        int i13 = i12 - i9;
        return this.f17565l.D(this.f17564k.D(i8, i9, i13), 0, i10 - i13);
    }

    @Override // com.google.protobuf.ByteString
    public ByteString G(int i8, int i9) {
        int k8 = ByteString.k(i8, i9, this.f17563j);
        if (k8 == 0) {
            return ByteString.f17177g;
        }
        if (k8 == this.f17563j) {
            return this;
        }
        int i10 = this.f17566m;
        if (i9 <= i10) {
            return this.f17564k.G(i8, i9);
        }
        if (i8 >= i10) {
            return this.f17565l.G(i8 - i10, i9 - i10);
        }
        return new RopeByteString(this.f17564k.F(i8), this.f17565l.G(0, i9 - this.f17566m));
    }

    @Override // com.google.protobuf.ByteString
    protected String K(Charset charset) {
        return new String(H(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void Q(ByteOutput byteOutput) throws IOException {
        this.f17564k.Q(byteOutput);
        this.f17565l.Q(byteOutput);
    }

    public List<ByteBuffer> T() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().d());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer d() {
        return ByteBuffer.wrap(H()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.f17563j != byteString.size()) {
            return false;
        }
        if (this.f17563j == 0) {
            return true;
        }
        int E = E();
        int E2 = byteString.E();
        if (E != 0 && E2 != 0 && E != E2) {
            return false;
        }
        return W(byteString);
    }

    @Override // com.google.protobuf.ByteString
    public byte g(int i8) {
        ByteString.i(i8, this.f17563j);
        return w(i8);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.f17563j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public void u(byte[] bArr, int i8, int i9, int i10) {
        int i11 = i8 + i10;
        int i12 = this.f17566m;
        if (i11 <= i12) {
            this.f17564k.u(bArr, i8, i9, i10);
        } else if (i8 >= i12) {
            this.f17565l.u(bArr, i8 - i12, i9, i10);
        } else {
            int i13 = i12 - i8;
            this.f17564k.u(bArr, i8, i9, i13);
            this.f17565l.u(bArr, 0, i9 + i13, i10 - i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int v() {
        return this.f17567n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public byte w(int i8) {
        int i9 = this.f17566m;
        if (i8 < i9) {
            return this.f17564k.w(i8);
        }
        return this.f17565l.w(i8 - i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public boolean x() {
        if (this.f17563j >= X(this.f17567n)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public boolean y() {
        int D = this.f17564k.D(0, 0, this.f17566m);
        ByteString byteString = this.f17565l;
        if (byteString.D(D, 0, byteString.size()) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: z */
    public ByteString.ByteIterator iterator() {
        return new ByteString.AbstractByteIterator() { // from class: com.google.protobuf.RopeByteString.1

            /* renamed from: f  reason: collision with root package name */
            final PieceIterator f17568f;

            /* renamed from: g  reason: collision with root package name */
            ByteString.ByteIterator f17569g = c();

            {
                this.f17568f = new PieceIterator(RopeByteString.this);
            }

            private ByteString.ByteIterator c() {
                if (this.f17568f.hasNext()) {
                    return this.f17568f.next().iterator();
                }
                return null;
            }

            @Override // com.google.protobuf.ByteString.ByteIterator
            public byte a() {
                ByteString.ByteIterator byteIterator = this.f17569g;
                if (byteIterator != null) {
                    byte a8 = byteIterator.a();
                    if (!this.f17569g.hasNext()) {
                        this.f17569g = c();
                    }
                    return a8;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                if (this.f17569g != null) {
                    return true;
                }
                return false;
            }
        };
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.f17564k = byteString;
        this.f17565l = byteString2;
        int size = byteString.size();
        this.f17566m = size;
        this.f17563j = size + byteString2.size();
        this.f17567n = Math.max(byteString.v(), byteString2.v()) + 1;
    }
}
