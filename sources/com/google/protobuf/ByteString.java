package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f17177g = new LiteralByteString(Internal.f17452d);

    /* renamed from: h  reason: collision with root package name */
    private static final ByteArrayCopier f17178h;

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<ByteString> f17179i;

    /* renamed from: f  reason: collision with root package name */
    private int f17180f = 0;

    /* loaded from: classes3.dex */
    static abstract class AbstractByteIterator implements ByteIterator, Iterator {
        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public final Byte next() {
            return Byte.valueOf(a());
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Byte> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] a(byte[] bArr, int i8, int i9) {
            return Arrays.copyOfRange(bArr, i8, i9 + i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class BoundedByteString extends LiteralByteString {

        /* renamed from: k  reason: collision with root package name */
        private final int f17184k;

        /* renamed from: l  reason: collision with root package name */
        private final int f17185l;

        BoundedByteString(byte[] bArr, int i8, int i9) {
            super(bArr);
            ByteString.k(i8, i8 + i9, bArr.length);
            this.f17184k = i8;
            this.f17185l = i9;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        protected int S() {
            return this.f17184k;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte g(int i8) {
            ByteString.i(i8, size());
            return this.f17188j[this.f17184k + i8];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.f17185l;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        protected void u(byte[] bArr, int i8, int i9, int i10) {
            System.arraycopy(this.f17188j, S() + i8, bArr, i9, i10);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        byte w(int i8) {
            return this.f17188j[this.f17184k + i8];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface ByteArrayCopier {
        byte[] a(byte[] bArr, int i8, int i9);
    }

    /* loaded from: classes3.dex */
    public interface ByteIterator extends java.util.Iterator<Byte> {
        byte a();
    }

    /* loaded from: classes3.dex */
    static final class CodedBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final CodedOutputStream f17186a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f17187b;

        public ByteString a() {
            this.f17186a.d();
            return new LiteralByteString(this.f17187b);
        }

        public CodedOutputStream b() {
            return this.f17186a;
        }

        private CodedBuilder(int i8) {
            byte[] bArr = new byte[i8];
            this.f17187b = bArr;
            this.f17186a = CodedOutputStream.g0(bArr);
        }
    }

    /* loaded from: classes3.dex */
    static abstract class LeafByteString extends ByteString {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean R(ByteString byteString, int i8, int i9);

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ java.util.Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // com.google.protobuf.ByteString
        protected final int v() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        protected final boolean x() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class LiteralByteString extends LeafByteString {

        /* renamed from: j  reason: collision with root package name */
        protected final byte[] f17188j;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f17188j = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream B() {
            return CodedInputStream.o(this.f17188j, S(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        protected final int C(int i8, int i9, int i10) {
            return Internal.i(i8, this.f17188j, S() + i9, i10);
        }

        @Override // com.google.protobuf.ByteString
        protected final int D(int i8, int i9, int i10) {
            int S = S() + i9;
            return Utf8.v(i8, this.f17188j, S, i10 + S);
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString G(int i8, int i9) {
            int k8 = ByteString.k(i8, i9, size());
            if (k8 == 0) {
                return ByteString.f17177g;
            }
            return new BoundedByteString(this.f17188j, S() + i8, k8);
        }

        @Override // com.google.protobuf.ByteString
        protected final String K(Charset charset) {
            return new String(this.f17188j, S(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        final void Q(ByteOutput byteOutput) throws IOException {
            byteOutput.b(this.f17188j, S(), size());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean R(ByteString byteString, int i8, int i9) {
            if (i9 <= byteString.size()) {
                int i10 = i8 + i9;
                if (i10 <= byteString.size()) {
                    if (byteString instanceof LiteralByteString) {
                        LiteralByteString literalByteString = (LiteralByteString) byteString;
                        byte[] bArr = this.f17188j;
                        byte[] bArr2 = literalByteString.f17188j;
                        int S = S() + i9;
                        int S2 = S();
                        int S3 = literalByteString.S() + i8;
                        while (S2 < S) {
                            if (bArr[S2] != bArr2[S3]) {
                                return false;
                            }
                            S2++;
                            S3++;
                        }
                        return true;
                    }
                    return byteString.G(i8, i10).equals(G(0, i9));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i8 + ", " + i9 + ", " + byteString.size());
            }
            throw new IllegalArgumentException("Length too large: " + i9 + size());
        }

        protected int S() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer d() {
            return ByteBuffer.wrap(this.f17188j, S(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof LiteralByteString) {
                LiteralByteString literalByteString = (LiteralByteString) obj;
                int E = E();
                int E2 = literalByteString.E();
                if (E != 0 && E2 != 0 && E != E2) {
                    return false;
                }
                return R(literalByteString, 0, size());
            }
            return obj.equals(this);
        }

        @Override // com.google.protobuf.ByteString
        public byte g(int i8) {
            return this.f17188j[i8];
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.f17188j.length;
        }

        @Override // com.google.protobuf.ByteString
        protected void u(byte[] bArr, int i8, int i9, int i10) {
            System.arraycopy(this.f17188j, i8, bArr, i9, i10);
        }

        @Override // com.google.protobuf.ByteString
        byte w(int i8) {
            return this.f17188j[i8];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean y() {
            int S = S();
            return Utf8.t(this.f17188j, S, size() + S);
        }
    }

    /* loaded from: classes3.dex */
    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] a(byte[] bArr, int i8, int i9) {
            byte[] bArr2 = new byte[i9];
            System.arraycopy(bArr, i8, bArr2, 0, i9);
            return bArr2;
        }
    }

    static {
        ByteArrayCopier arraysByteArrayCopier;
        if (Android.c()) {
            arraysByteArrayCopier = new SystemByteArrayCopier();
        } else {
            arraysByteArrayCopier = new ArraysByteArrayCopier();
        }
        f17178h = arraysByteArrayCopier;
        f17179i = new Comparator<ByteString>() { // from class: com.google.protobuf.ByteString.2
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ByteString byteString, ByteString byteString2) {
                ByteIterator it = byteString.iterator();
                ByteIterator it2 = byteString2.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    int compareTo = Integer.valueOf(ByteString.I(it.a())).compareTo(Integer.valueOf(ByteString.I(it2.a())));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedBuilder A(int i8) {
        return new CodedBuilder(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(byte b8) {
        return b8 & 255;
    }

    private String M() {
        if (size() <= 50) {
            return TextFormatEscaper.a(this);
        }
        return TextFormatEscaper.a(G(0, 47)) + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString N(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return P(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new NioByteString(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString O(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString P(byte[] bArr, int i8, int i9) {
        return new BoundedByteString(bArr, i8, i9);
    }

    private static ByteString f(java.util.Iterator<ByteString> it, int i8) {
        if (i8 >= 1) {
            if (i8 == 1) {
                return it.next();
            }
            int i9 = i8 >>> 1;
            return f(it, i9).m(f(it, i8 - i9));
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i8)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(int i8, int i9) {
        if (((i9 - (i8 + 1)) | i8) < 0) {
            if (i8 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i8);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i8 + ", " + i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) < 0) {
            if (i8 >= 0) {
                if (i9 < i8) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i8 + ", " + i9);
                }
                throw new IndexOutOfBoundsException("End index: " + i9 + " >= " + i10);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i8 + " < 0");
        }
        return i11;
    }

    public static ByteString n(Iterable<ByteString> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            size = 0;
            java.util.Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return f17177g;
        }
        return f(iterable.iterator(), size);
    }

    public static ByteString o(byte[] bArr) {
        return p(bArr, 0, bArr.length);
    }

    public static ByteString p(byte[] bArr, int i8, int i9) {
        k(i8, i8 + i9, bArr.length);
        return new LiteralByteString(f17178h.a(bArr, i8, i9));
    }

    public static ByteString r(String str) {
        return new LiteralByteString(str.getBytes(Internal.f17450b));
    }

    public abstract CodedInputStream B();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int C(int i8, int i9, int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int D(int i8, int i9, int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int E() {
        return this.f17180f;
    }

    public final ByteString F(int i8) {
        return G(i8, size());
    }

    public abstract ByteString G(int i8, int i9);

    public final byte[] H() {
        int size = size();
        if (size == 0) {
            return Internal.f17452d;
        }
        byte[] bArr = new byte[size];
        u(bArr, 0, 0, size);
        return bArr;
    }

    public final String J(Charset charset) {
        if (size() == 0) {
            return "";
        }
        return K(charset);
    }

    protected abstract String K(Charset charset);

    public final String L() {
        return J(Internal.f17450b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void Q(ByteOutput byteOutput) throws IOException;

    public abstract ByteBuffer d();

    public abstract boolean equals(Object obj);

    public abstract byte g(int i8);

    public final int hashCode() {
        int i8 = this.f17180f;
        if (i8 == 0) {
            int size = size();
            i8 = C(size, 0, size);
            if (i8 == 0) {
                i8 = 1;
            }
            this.f17180f = i8;
        }
        return i8;
    }

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final ByteString m(ByteString byteString) {
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - size() >= byteString.size()) {
            return RopeByteString.U(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    @Deprecated
    public final void s(byte[] bArr, int i8, int i9, int i10) {
        k(i8, i8 + i10, size());
        k(i9, i9 + i10, bArr.length);
        if (i10 > 0) {
            u(bArr, i8, i9, i10);
        }
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), M());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void u(byte[] bArr, int i8, int i9, int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int v();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte w(int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean x();

    public abstract boolean y();

    @Override // java.lang.Iterable
    /* renamed from: z */
    public ByteIterator iterator() {
        return new AbstractByteIterator() { // from class: com.google.protobuf.ByteString.1

            /* renamed from: f  reason: collision with root package name */
            private int f17181f = 0;

            /* renamed from: g  reason: collision with root package name */
            private final int f17182g;

            {
                this.f17182g = ByteString.this.size();
            }

            @Override // com.google.protobuf.ByteString.ByteIterator
            public byte a() {
                int i8 = this.f17181f;
                if (i8 < this.f17182g) {
                    this.f17181f = i8 + 1;
                    return ByteString.this.w(i8);
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                if (this.f17181f < this.f17182g) {
                    return true;
                }
                return false;
            }
        };
    }
}
