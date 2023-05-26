package com.google.crypto.tink.shaded.protobuf;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final ByteString f14989g = new LiteralByteString(Internal.f15117c);

    /* renamed from: h  reason: collision with root package name */
    private static final ByteArrayCopier f14990h;

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<ByteString> f14991i;

    /* renamed from: f  reason: collision with root package name */
    private int f14992f = 0;

    /* loaded from: classes.dex */
    static abstract class AbstractByteIterator implements ByteIterator, Iterator {
        AbstractByteIterator() {
        }

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

    /* loaded from: classes.dex */
    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] a(byte[] bArr, int i8, int i9) {
            return Arrays.copyOfRange(bArr, i8, i9 + i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BoundedByteString extends LiteralByteString {

        /* renamed from: k  reason: collision with root package name */
        private final int f14996k;

        /* renamed from: l  reason: collision with root package name */
        private final int f14997l;

        BoundedByteString(byte[] bArr, int i8, int i9) {
            super(bArr);
            ByteString.g(i8, i8 + i9, bArr.length);
            this.f14996k = i8;
            this.f14997l = i9;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        protected int I() {
            return this.f14996k;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public byte d(int i8) {
            ByteString.f(i8, size());
            return this.f15000j[this.f14996k + i8];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        protected void n(byte[] bArr, int i8, int i9, int i10) {
            System.arraycopy(this.f15000j, I() + i8, bArr, i9, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        byte o(int i8) {
            return this.f15000j[this.f14996k + i8];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.f14997l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface ByteArrayCopier {
        byte[] a(byte[] bArr, int i8, int i9);
    }

    /* loaded from: classes.dex */
    public interface ByteIterator extends java.util.Iterator<Byte> {
        byte a();
    }

    /* loaded from: classes.dex */
    static final class CodedBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final CodedOutputStream f14998a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f14999b;

        public ByteString a() {
            this.f14998a.c();
            return new LiteralByteString(this.f14999b);
        }

        public CodedOutputStream b() {
            return this.f14998a;
        }

        private CodedBuilder(int i8) {
            byte[] bArr = new byte[i8];
            this.f14999b = bArr;
            this.f14998a = CodedOutputStream.d0(bArr);
        }
    }

    /* loaded from: classes.dex */
    static abstract class LeafByteString extends ByteString {
        LeafByteString() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LiteralByteString extends LeafByteString {

        /* renamed from: j  reason: collision with root package name */
        protected final byte[] f15000j;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f15000j = bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final String B(Charset charset) {
            return new String(this.f15000j, I(), size(), charset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void G(ByteOutput byteOutput) throws IOException {
            byteOutput.a(this.f15000j, I(), size());
        }

        final boolean H(ByteString byteString, int i8, int i9) {
            if (i9 <= byteString.size()) {
                int i10 = i8 + i9;
                if (i10 <= byteString.size()) {
                    if (byteString instanceof LiteralByteString) {
                        LiteralByteString literalByteString = (LiteralByteString) byteString;
                        byte[] bArr = this.f15000j;
                        byte[] bArr2 = literalByteString.f15000j;
                        int I = I() + i9;
                        int I2 = I();
                        int I3 = literalByteString.I() + i8;
                        while (I2 < I) {
                            if (bArr[I2] != bArr2[I3]) {
                                return false;
                            }
                            I2++;
                            I3++;
                        }
                        return true;
                    }
                    return byteString.x(i8, i10).equals(x(0, i9));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i8 + ", " + i9 + ", " + byteString.size());
            }
            throw new IllegalArgumentException("Length too large: " + i9 + size());
        }

        protected int I() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte d(int i8) {
            return this.f15000j[i8];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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
                int w7 = w();
                int w8 = literalByteString.w();
                if (w7 != 0 && w8 != 0 && w7 != w8) {
                    return false;
                }
                return H(literalByteString, 0, size());
            }
            return obj.equals(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected void n(byte[] bArr, int i8, int i9, int i10) {
            System.arraycopy(this.f15000j, i8, bArr, i9, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        byte o(int i8) {
            return this.f15000j[i8];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean p() {
            int I = I();
            return Utf8.n(this.f15000j, I, size() + I);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.f15000j.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final CodedInputStream u() {
            return CodedInputStream.h(this.f15000j, I(), size(), true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int v(int i8, int i9, int i10) {
            return Internal.i(i8, this.f15000j, I() + i9, i10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteString x(int i8, int i9) {
            int g8 = ByteString.g(i8, i9, size());
            if (g8 == 0) {
                return ByteString.f14989g;
            }
            return new BoundedByteString(this.f15000j, I() + i8, g8);
        }
    }

    /* loaded from: classes.dex */
    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
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
        f14990h = arraysByteArrayCopier;
        f14991i = new Comparator<ByteString>() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.2
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(ByteString byteString, ByteString byteString2) {
                ByteIterator it = byteString.iterator();
                ByteIterator it2 = byteString2.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    int compare = Integer.compare(ByteString.z(it.a()), ByteString.z(it2.a()));
                    if (compare != 0) {
                        return compare;
                    }
                }
                return Integer.compare(byteString.size(), byteString2.size());
            }
        };
    }

    ByteString() {
    }

    private String D() {
        if (size() <= 50) {
            return TextFormatEscaper.a(this);
        }
        return TextFormatEscaper.a(x(0, 47)) + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString E(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString F(byte[] bArr, int i8, int i9) {
        return new BoundedByteString(bArr, i8, i9);
    }

    static void f(int i8, int i9) {
        if (((i9 - (i8 + 1)) | i8) < 0) {
            if (i8 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i8);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i8 + ", " + i9);
        }
    }

    static int g(int i8, int i9, int i10) {
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

    public static ByteString i(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static ByteString k(byte[] bArr, int i8, int i9) {
        g(i8, i8 + i9, bArr.length);
        return new LiteralByteString(f14990h.a(bArr, i8, i9));
    }

    public static ByteString m(String str) {
        return new LiteralByteString(str.getBytes(Internal.f15115a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedBuilder s(int i8) {
        return new CodedBuilder(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int z(byte b8) {
        return b8 & 255;
    }

    public final String A(Charset charset) {
        if (size() == 0) {
            return "";
        }
        return B(charset);
    }

    protected abstract String B(Charset charset);

    public final String C() {
        return A(Internal.f15115a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void G(ByteOutput byteOutput) throws IOException;

    public abstract byte d(int i8);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i8 = this.f14992f;
        if (i8 == 0) {
            int size = size();
            i8 = v(size, 0, size);
            if (i8 == 0) {
                i8 = 1;
            }
            this.f14992f = i8;
        }
        return i8;
    }

    protected abstract void n(byte[] bArr, int i8, int i9, int i10);

    abstract byte o(int i8);

    public abstract boolean p();

    @Override // java.lang.Iterable
    /* renamed from: r */
    public ByteIterator iterator() {
        return new AbstractByteIterator() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.1

            /* renamed from: f  reason: collision with root package name */
            private int f14993f = 0;

            /* renamed from: g  reason: collision with root package name */
            private final int f14994g;

            {
                this.f14994g = ByteString.this.size();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteIterator
            public byte a() {
                int i8 = this.f14993f;
                if (i8 < this.f14994g) {
                    this.f14993f = i8 + 1;
                    return ByteString.this.o(i8);
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator, j$.util.Iterator
            public boolean hasNext() {
                if (this.f14993f < this.f14994g) {
                    return true;
                }
                return false;
            }
        };
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), D());
    }

    public abstract CodedInputStream u();

    protected abstract int v(int i8, int i9, int i10);

    protected final int w() {
        return this.f14992f;
    }

    public abstract ByteString x(int i8, int i9);

    public final byte[] y() {
        int size = size();
        if (size == 0) {
            return Internal.f15117c;
        }
        byte[] bArr = new byte[size];
        n(bArr, 0, 0, size);
        return bArr;
    }
}
