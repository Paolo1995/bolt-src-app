package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f17244c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f17245d = UnsafeUtil.I();

    /* renamed from: a  reason: collision with root package name */
    CodedOutputStreamWriter f17246a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17247b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        final byte[] f17248e;

        /* renamed from: f  reason: collision with root package name */
        final int f17249f;

        /* renamed from: g  reason: collision with root package name */
        int f17250g;

        /* renamed from: h  reason: collision with root package name */
        int f17251h;

        AbstractBufferedEncoder(int i8) {
            super();
            if (i8 >= 0) {
                byte[] bArr = new byte[Math.max(i8, 20)];
                this.f17248e = bArr;
                this.f17249f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void b1(byte b8) {
            byte[] bArr = this.f17248e;
            int i8 = this.f17250g;
            this.f17250g = i8 + 1;
            bArr[i8] = b8;
            this.f17251h++;
        }

        final void c1(int i8) {
            byte[] bArr = this.f17248e;
            int i9 = this.f17250g;
            int i10 = i9 + 1;
            bArr[i9] = (byte) (i8 & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((i8 >> 8) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((i8 >> 16) & 255);
            this.f17250g = i12 + 1;
            bArr[i12] = (byte) ((i8 >> 24) & 255);
            this.f17251h += 4;
        }

        final void d1(long j8) {
            byte[] bArr = this.f17248e;
            int i8 = this.f17250g;
            int i9 = i8 + 1;
            bArr[i8] = (byte) (j8 & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((j8 >> 8) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((j8 >> 16) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (255 & (j8 >> 24));
            int i13 = i12 + 1;
            bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
            this.f17250g = i15 + 1;
            bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            this.f17251h += 8;
        }

        final void e1(int i8) {
            if (i8 >= 0) {
                g1(i8);
            } else {
                h1(i8);
            }
        }

        final void f1(int i8, int i9) {
            g1(WireFormat.c(i8, i9));
        }

        final void g1(int i8) {
            if (CodedOutputStream.f17245d) {
                long j8 = this.f17250g;
                while ((i8 & (-128)) != 0) {
                    byte[] bArr = this.f17248e;
                    int i9 = this.f17250g;
                    this.f17250g = i9 + 1;
                    UnsafeUtil.O(bArr, i9, (byte) ((i8 & 127) | 128));
                    i8 >>>= 7;
                }
                byte[] bArr2 = this.f17248e;
                int i10 = this.f17250g;
                this.f17250g = i10 + 1;
                UnsafeUtil.O(bArr2, i10, (byte) i8);
                this.f17251h += (int) (this.f17250g - j8);
                return;
            }
            while ((i8 & (-128)) != 0) {
                byte[] bArr3 = this.f17248e;
                int i11 = this.f17250g;
                this.f17250g = i11 + 1;
                bArr3[i11] = (byte) ((i8 & 127) | 128);
                this.f17251h++;
                i8 >>>= 7;
            }
            byte[] bArr4 = this.f17248e;
            int i12 = this.f17250g;
            this.f17250g = i12 + 1;
            bArr4[i12] = (byte) i8;
            this.f17251h++;
        }

        final void h1(long j8) {
            if (CodedOutputStream.f17245d) {
                long j9 = this.f17250g;
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.f17248e;
                    int i8 = this.f17250g;
                    this.f17250g = i8 + 1;
                    UnsafeUtil.O(bArr, i8, (byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.f17248e;
                int i9 = this.f17250g;
                this.f17250g = i9 + 1;
                UnsafeUtil.O(bArr2, i9, (byte) j8);
                this.f17251h += (int) (this.f17250g - j9);
                return;
            }
            while ((j8 & (-128)) != 0) {
                byte[] bArr3 = this.f17248e;
                int i10 = this.f17250g;
                this.f17250g = i10 + 1;
                bArr3[i10] = (byte) ((((int) j8) & 127) | 128);
                this.f17251h++;
                j8 >>>= 7;
            }
            byte[] bArr4 = this.f17248e;
            int i11 = this.f17250g;
            this.f17250g = i11 + 1;
            bArr4[i11] = (byte) j8;
            this.f17251h++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int i0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ArrayEncoder extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f17252e;

        /* renamed from: f  reason: collision with root package name */
        private final int f17253f;

        /* renamed from: g  reason: collision with root package name */
        private final int f17254g;

        /* renamed from: h  reason: collision with root package name */
        private int f17255h;

        ArrayEncoder(byte[] bArr, int i8, int i9) {
            super();
            if (bArr != null) {
                int i10 = i8 + i9;
                if ((i8 | i9 | (bArr.length - i10)) >= 0) {
                    this.f17252e = bArr;
                    this.f17253f = i8;
                    this.f17255h = i8;
                    this.f17254g = i10;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void E0(int i8, int i9) throws IOException {
            W0(i8, 0);
            F0(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void F0(int i8) throws IOException {
            if (i8 >= 0) {
                Y0(i8);
            } else {
                a1(i8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void I0(int i8, MessageLite messageLite, Schema schema) throws IOException {
            W0(i8, 2);
            Y0(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.f(messageLite, this.f17246a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void J0(MessageLite messageLite) throws IOException {
            Y0(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void K0(int i8, MessageLite messageLite) throws IOException {
            W0(1, 3);
            X0(2, i8);
            d1(3, messageLite);
            W0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void L0(int i8, ByteString byteString) throws IOException {
            W0(1, 3);
            X0(2, i8);
            o0(3, byteString);
            W0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void U0(int i8, String str) throws IOException {
            W0(i8, 2);
            V0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void V0(String str) throws IOException {
            int i8 = this.f17255h;
            try {
                int X = CodedOutputStream.X(str.length() * 3);
                int X2 = CodedOutputStream.X(str.length());
                if (X2 == X) {
                    int i9 = i8 + X2;
                    this.f17255h = i9;
                    int i10 = Utf8.i(str, this.f17252e, i9, i0());
                    this.f17255h = i8;
                    Y0((i10 - i8) - X2);
                    this.f17255h = i10;
                } else {
                    Y0(Utf8.j(str));
                    this.f17255h = Utf8.i(str, this.f17252e, this.f17255h, i0());
                }
            } catch (Utf8.UnpairedSurrogateException e8) {
                this.f17255h = i8;
                d0(str, e8);
            } catch (IndexOutOfBoundsException e9) {
                throw new OutOfSpaceException(e9);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void W0(int i8, int i9) throws IOException {
            Y0(WireFormat.c(i8, i9));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void X0(int i8, int i9) throws IOException {
            W0(i8, 0);
            Y0(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void Y0(int i8) throws IOException {
            while ((i8 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f17252e;
                    int i9 = this.f17255h;
                    this.f17255h = i9 + 1;
                    bArr[i9] = (byte) ((i8 & 127) | 128);
                    i8 >>>= 7;
                } catch (IndexOutOfBoundsException e8) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17255h), Integer.valueOf(this.f17254g), 1), e8);
                }
            }
            byte[] bArr2 = this.f17252e;
            int i10 = this.f17255h;
            this.f17255h = i10 + 1;
            bArr2[i10] = (byte) i8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void Z0(int i8, long j8) throws IOException {
            W0(i8, 0);
            a1(j8);
        }

        @Override // com.google.protobuf.ByteOutput
        public final void a(ByteBuffer byteBuffer) throws IOException {
            b1(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void a1(long j8) throws IOException {
            if (CodedOutputStream.f17245d && i0() >= 10) {
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.f17252e;
                    int i8 = this.f17255h;
                    this.f17255h = i8 + 1;
                    UnsafeUtil.O(bArr, i8, (byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.f17252e;
                int i9 = this.f17255h;
                this.f17255h = i9 + 1;
                UnsafeUtil.O(bArr2, i9, (byte) j8);
                return;
            }
            while ((j8 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f17252e;
                    int i10 = this.f17255h;
                    this.f17255h = i10 + 1;
                    bArr3[i10] = (byte) ((((int) j8) & 127) | 128);
                    j8 >>>= 7;
                } catch (IndexOutOfBoundsException e8) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17255h), Integer.valueOf(this.f17254g), 1), e8);
                }
            }
            byte[] bArr4 = this.f17252e;
            int i11 = this.f17255h;
            this.f17255h = i11 + 1;
            bArr4[i11] = (byte) j8;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void b(byte[] bArr, int i8, int i9) throws IOException {
            c1(bArr, i8, i9);
        }

        public final void b1(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f17252e, this.f17255h, remaining);
                this.f17255h += remaining;
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17255h), Integer.valueOf(this.f17254g), Integer.valueOf(remaining)), e8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void c0() {
        }

        public final void c1(byte[] bArr, int i8, int i9) throws IOException {
            try {
                System.arraycopy(bArr, i8, this.f17252e, this.f17255h, i9);
                this.f17255h += i9;
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17255h), Integer.valueOf(this.f17254g), Integer.valueOf(i9)), e8);
            }
        }

        public final void d1(int i8, MessageLite messageLite) throws IOException {
            W0(i8, 2);
            J0(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int i0() {
            return this.f17254g - this.f17255h;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void j0(byte b8) throws IOException {
            try {
                byte[] bArr = this.f17252e;
                int i8 = this.f17255h;
                this.f17255h = i8 + 1;
                bArr[i8] = b8;
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17255h), Integer.valueOf(this.f17254g), 1), e8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void k0(int i8, boolean z7) throws IOException {
            W0(i8, 0);
            j0(z7 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void n0(byte[] bArr, int i8, int i9) throws IOException {
            Y0(i9);
            c1(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void o0(int i8, ByteString byteString) throws IOException {
            W0(i8, 2);
            p0(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void p0(ByteString byteString) throws IOException {
            Y0(byteString.size());
            byteString.Q(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void u0(int i8, int i9) throws IOException {
            W0(i8, 5);
            v0(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void v0(int i8) throws IOException {
            try {
                byte[] bArr = this.f17252e;
                int i9 = this.f17255h;
                int i10 = i9 + 1;
                bArr[i9] = (byte) (i8 & 255);
                int i11 = i10 + 1;
                bArr[i10] = (byte) ((i8 >> 8) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) ((i8 >> 16) & 255);
                this.f17255h = i12 + 1;
                bArr[i12] = (byte) ((i8 >> 24) & 255);
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17255h), Integer.valueOf(this.f17254g), 1), e8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void w0(int i8, long j8) throws IOException {
            W0(i8, 1);
            x0(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void x0(long j8) throws IOException {
            try {
                byte[] bArr = this.f17252e;
                int i8 = this.f17255h;
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((int) j8) & 255);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((int) (j8 >> 8)) & 255);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((int) (j8 >> 16)) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((int) (j8 >> 24)) & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
                this.f17255h = i15 + 1;
                bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17255h), Integer.valueOf(this.f17254g), 1), e8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* loaded from: classes3.dex */
    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {

        /* renamed from: i  reason: collision with root package name */
        private final OutputStream f17256i;

        OutputStreamEncoder(OutputStream outputStream, int i8) {
            super(i8);
            if (outputStream != null) {
                this.f17256i = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void i1() throws IOException {
            this.f17256i.write(this.f17248e, 0, this.f17250g);
            this.f17250g = 0;
        }

        private void j1(int i8) throws IOException {
            if (this.f17249f - this.f17250g < i8) {
                i1();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void E0(int i8, int i9) throws IOException {
            j1(20);
            f1(i8, 0);
            e1(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void F0(int i8) throws IOException {
            if (i8 >= 0) {
                Y0(i8);
            } else {
                a1(i8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        void I0(int i8, MessageLite messageLite, Schema schema) throws IOException {
            W0(i8, 2);
            n1(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void J0(MessageLite messageLite) throws IOException {
            Y0(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void K0(int i8, MessageLite messageLite) throws IOException {
            W0(1, 3);
            X0(2, i8);
            m1(3, messageLite);
            W0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void L0(int i8, ByteString byteString) throws IOException {
            W0(1, 3);
            X0(2, i8);
            o0(3, byteString);
            W0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void U0(int i8, String str) throws IOException {
            W0(i8, 2);
            V0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void V0(String str) throws IOException {
            int j8;
            try {
                int length = str.length() * 3;
                int X = CodedOutputStream.X(length);
                int i8 = X + length;
                int i9 = this.f17249f;
                if (i8 > i9) {
                    byte[] bArr = new byte[length];
                    int i10 = Utf8.i(str, bArr, 0, length);
                    Y0(i10);
                    b(bArr, 0, i10);
                    return;
                }
                if (i8 > i9 - this.f17250g) {
                    i1();
                }
                int X2 = CodedOutputStream.X(str.length());
                int i11 = this.f17250g;
                try {
                    if (X2 == X) {
                        int i12 = i11 + X2;
                        this.f17250g = i12;
                        int i13 = Utf8.i(str, this.f17248e, i12, this.f17249f - i12);
                        this.f17250g = i11;
                        j8 = (i13 - i11) - X2;
                        g1(j8);
                        this.f17250g = i13;
                    } else {
                        j8 = Utf8.j(str);
                        g1(j8);
                        this.f17250g = Utf8.i(str, this.f17248e, this.f17250g, j8);
                    }
                    this.f17251h += j8;
                } catch (Utf8.UnpairedSurrogateException e8) {
                    this.f17251h -= this.f17250g - i11;
                    this.f17250g = i11;
                    throw e8;
                } catch (ArrayIndexOutOfBoundsException e9) {
                    throw new OutOfSpaceException(e9);
                }
            } catch (Utf8.UnpairedSurrogateException e10) {
                d0(str, e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void W0(int i8, int i9) throws IOException {
            Y0(WireFormat.c(i8, i9));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void X0(int i8, int i9) throws IOException {
            j1(20);
            f1(i8, 0);
            g1(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void Y0(int i8) throws IOException {
            j1(5);
            g1(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void Z0(int i8, long j8) throws IOException {
            j1(20);
            f1(i8, 0);
            h1(j8);
        }

        @Override // com.google.protobuf.ByteOutput
        public void a(ByteBuffer byteBuffer) throws IOException {
            k1(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void a1(long j8) throws IOException {
            j1(10);
            h1(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void b(byte[] bArr, int i8, int i9) throws IOException {
            l1(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void c0() throws IOException {
            if (this.f17250g > 0) {
                i1();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void j0(byte b8) throws IOException {
            if (this.f17250g == this.f17249f) {
                i1();
            }
            b1(b8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void k0(int i8, boolean z7) throws IOException {
            j1(11);
            f1(i8, 0);
            b1(z7 ? (byte) 1 : (byte) 0);
        }

        public void k1(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i8 = this.f17249f;
            int i9 = this.f17250g;
            if (i8 - i9 >= remaining) {
                byteBuffer.get(this.f17248e, i9, remaining);
                this.f17250g += remaining;
                this.f17251h += remaining;
                return;
            }
            int i10 = i8 - i9;
            byteBuffer.get(this.f17248e, i9, i10);
            int i11 = remaining - i10;
            this.f17250g = this.f17249f;
            this.f17251h += i10;
            i1();
            while (true) {
                int i12 = this.f17249f;
                if (i11 > i12) {
                    byteBuffer.get(this.f17248e, 0, i12);
                    this.f17256i.write(this.f17248e, 0, this.f17249f);
                    int i13 = this.f17249f;
                    i11 -= i13;
                    this.f17251h += i13;
                } else {
                    byteBuffer.get(this.f17248e, 0, i11);
                    this.f17250g = i11;
                    this.f17251h += i11;
                    return;
                }
            }
        }

        public void l1(byte[] bArr, int i8, int i9) throws IOException {
            int i10 = this.f17249f;
            int i11 = this.f17250g;
            if (i10 - i11 >= i9) {
                System.arraycopy(bArr, i8, this.f17248e, i11, i9);
                this.f17250g += i9;
                this.f17251h += i9;
                return;
            }
            int i12 = i10 - i11;
            System.arraycopy(bArr, i8, this.f17248e, i11, i12);
            int i13 = i8 + i12;
            int i14 = i9 - i12;
            this.f17250g = this.f17249f;
            this.f17251h += i12;
            i1();
            if (i14 <= this.f17249f) {
                System.arraycopy(bArr, i13, this.f17248e, 0, i14);
                this.f17250g = i14;
            } else {
                this.f17256i.write(bArr, i13, i14);
            }
            this.f17251h += i14;
        }

        public void m1(int i8, MessageLite messageLite) throws IOException {
            W0(i8, 2);
            J0(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void n0(byte[] bArr, int i8, int i9) throws IOException {
            Y0(i9);
            l1(bArr, i8, i9);
        }

        void n1(MessageLite messageLite, Schema schema) throws IOException {
            Y0(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.f(messageLite, this.f17246a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void o0(int i8, ByteString byteString) throws IOException {
            W0(i8, 2);
            p0(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void p0(ByteString byteString) throws IOException {
            Y0(byteString.size());
            byteString.Q(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void u0(int i8, int i9) throws IOException {
            j1(14);
            f1(i8, 5);
            c1(i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void v0(int i8) throws IOException {
            j1(4);
            c1(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void w0(int i8, long j8) throws IOException {
            j1(18);
            f1(i8, 1);
            d1(j8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void x0(long j8) throws IOException {
            j1(8);
            d1(j8);
        }
    }

    public static int A(int i8, LazyFieldLite lazyFieldLite) {
        return (V(1) * 2) + W(2, i8) + B(3, lazyFieldLite);
    }

    public static int B(int i8, LazyFieldLite lazyFieldLite) {
        return V(i8) + C(lazyFieldLite);
    }

    public static int C(LazyFieldLite lazyFieldLite) {
        return D(lazyFieldLite.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i8) {
        return X(i8) + i8;
    }

    public static int E(int i8, MessageLite messageLite) {
        return (V(1) * 2) + W(2, i8) + F(3, messageLite);
    }

    public static int F(int i8, MessageLite messageLite) {
        return V(i8) + H(messageLite);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i8, MessageLite messageLite, Schema schema) {
        return V(i8) + I(messageLite, schema);
    }

    public static int H(MessageLite messageLite) {
        return D(messageLite.getSerializedSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(MessageLite messageLite, Schema schema) {
        return D(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(int i8) {
        if (i8 > 4096) {
            return 4096;
        }
        return i8;
    }

    public static int K(int i8, ByteString byteString) {
        return (V(1) * 2) + W(2, i8) + h(3, byteString);
    }

    public static int L(int i8, int i9) {
        return V(i8) + M(i9);
    }

    public static int M(int i8) {
        return 4;
    }

    public static int N(int i8, long j8) {
        return V(i8) + O(j8);
    }

    public static int O(long j8) {
        return 8;
    }

    public static int P(int i8, int i9) {
        return V(i8) + Q(i9);
    }

    public static int Q(int i8) {
        return X(a0(i8));
    }

    public static int R(int i8, long j8) {
        return V(i8) + S(j8);
    }

    public static int S(long j8) {
        return Z(b0(j8));
    }

    public static int T(int i8, String str) {
        return V(i8) + U(str);
    }

    public static int U(String str) {
        int length;
        try {
            length = Utf8.j(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f17450b).length;
        }
        return D(length);
    }

    public static int V(int i8) {
        return X(WireFormat.c(i8, 0));
    }

    public static int W(int i8, int i9) {
        return V(i8) + X(i9);
    }

    public static int X(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int Y(int i8, long j8) {
        return V(i8) + Z(j8);
    }

    public static int Z(long j8) {
        int i8;
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (j8 < 0) {
            return 10;
        }
        if (((-34359738368L) & j8) != 0) {
            i8 = 6;
            j8 >>>= 28;
        } else {
            i8 = 2;
        }
        if (((-2097152) & j8) != 0) {
            i8 += 2;
            j8 >>>= 14;
        }
        return (j8 & (-16384)) != 0 ? i8 + 1 : i8;
    }

    public static int a0(int i8) {
        return (i8 >> 31) ^ (i8 << 1);
    }

    public static long b0(long j8) {
        return (j8 >> 63) ^ (j8 << 1);
    }

    public static int e(int i8, boolean z7) {
        return V(i8) + f(z7);
    }

    public static int f(boolean z7) {
        return 1;
    }

    public static CodedOutputStream f0(OutputStream outputStream, int i8) {
        return new OutputStreamEncoder(outputStream, i8);
    }

    public static int g(byte[] bArr) {
        return D(bArr.length);
    }

    public static CodedOutputStream g0(byte[] bArr) {
        return h0(bArr, 0, bArr.length);
    }

    public static int h(int i8, ByteString byteString) {
        return V(i8) + i(byteString);
    }

    public static CodedOutputStream h0(byte[] bArr, int i8, int i9) {
        return new ArrayEncoder(bArr, i8, i9);
    }

    public static int i(ByteString byteString) {
        return D(byteString.size());
    }

    public static int j(int i8, double d8) {
        return V(i8) + k(d8);
    }

    public static int k(double d8) {
        return 8;
    }

    public static int l(int i8, int i9) {
        return V(i8) + m(i9);
    }

    public static int m(int i8) {
        return x(i8);
    }

    public static int n(int i8, int i9) {
        return V(i8) + o(i9);
    }

    public static int o(int i8) {
        return 4;
    }

    public static int p(int i8, long j8) {
        return V(i8) + q(j8);
    }

    public static int q(long j8) {
        return 8;
    }

    public static int r(int i8, float f8) {
        return V(i8) + s(f8);
    }

    public static int s(float f8) {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int t(int i8, MessageLite messageLite, Schema schema) {
        return (V(i8) * 2) + v(messageLite, schema);
    }

    @Deprecated
    public static int u(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    @Deprecated
    static int v(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public static int w(int i8, int i9) {
        return V(i8) + x(i9);
    }

    public static int x(int i8) {
        if (i8 >= 0) {
            return X(i8);
        }
        return 10;
    }

    public static int y(int i8, long j8) {
        return V(i8) + z(j8);
    }

    public static int z(long j8) {
        return Z(j8);
    }

    @Deprecated
    public final void A0(int i8, MessageLite messageLite) throws IOException {
        W0(i8, 3);
        C0(messageLite);
        W0(i8, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void B0(int i8, MessageLite messageLite, Schema schema) throws IOException {
        W0(i8, 3);
        D0(messageLite, schema);
        W0(i8, 4);
    }

    @Deprecated
    public final void C0(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    @Deprecated
    final void D0(MessageLite messageLite, Schema schema) throws IOException {
        schema.f(messageLite, this.f17246a);
    }

    public abstract void E0(int i8, int i9) throws IOException;

    public abstract void F0(int i8) throws IOException;

    public final void G0(int i8, long j8) throws IOException {
        Z0(i8, j8);
    }

    public final void H0(long j8) throws IOException {
        a1(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void I0(int i8, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void J0(MessageLite messageLite) throws IOException;

    public abstract void K0(int i8, MessageLite messageLite) throws IOException;

    public abstract void L0(int i8, ByteString byteString) throws IOException;

    public final void M0(int i8, int i9) throws IOException {
        u0(i8, i9);
    }

    public final void N0(int i8) throws IOException {
        v0(i8);
    }

    public final void O0(int i8, long j8) throws IOException {
        w0(i8, j8);
    }

    public final void P0(long j8) throws IOException {
        x0(j8);
    }

    public final void Q0(int i8, int i9) throws IOException {
        X0(i8, a0(i9));
    }

    public final void R0(int i8) throws IOException {
        Y0(a0(i8));
    }

    public final void S0(int i8, long j8) throws IOException {
        Z0(i8, b0(j8));
    }

    public final void T0(long j8) throws IOException {
        a1(b0(j8));
    }

    public abstract void U0(int i8, String str) throws IOException;

    public abstract void V0(String str) throws IOException;

    public abstract void W0(int i8, int i9) throws IOException;

    public abstract void X0(int i8, int i9) throws IOException;

    public abstract void Y0(int i8) throws IOException;

    public abstract void Z0(int i8, long j8) throws IOException;

    public abstract void a1(long j8) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void b(byte[] bArr, int i8, int i9) throws IOException;

    public abstract void c0() throws IOException;

    public final void d() {
        if (i0() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    final void d0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f17244c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f17450b);
        try {
            Y0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e8) {
            throw new OutOfSpaceException(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e0() {
        return this.f17247b;
    }

    public abstract int i0();

    public abstract void j0(byte b8) throws IOException;

    public abstract void k0(int i8, boolean z7) throws IOException;

    public final void l0(boolean z7) throws IOException {
        j0(z7 ? (byte) 1 : (byte) 0);
    }

    public final void m0(byte[] bArr) throws IOException {
        n0(bArr, 0, bArr.length);
    }

    abstract void n0(byte[] bArr, int i8, int i9) throws IOException;

    public abstract void o0(int i8, ByteString byteString) throws IOException;

    public abstract void p0(ByteString byteString) throws IOException;

    public final void q0(int i8, double d8) throws IOException {
        w0(i8, Double.doubleToRawLongBits(d8));
    }

    public final void r0(double d8) throws IOException {
        x0(Double.doubleToRawLongBits(d8));
    }

    public final void s0(int i8, int i9) throws IOException {
        E0(i8, i9);
    }

    public final void t0(int i8) throws IOException {
        F0(i8);
    }

    public abstract void u0(int i8, int i9) throws IOException;

    public abstract void v0(int i8) throws IOException;

    public abstract void w0(int i8, long j8) throws IOException;

    public abstract void x0(long j8) throws IOException;

    public final void y0(int i8, float f8) throws IOException {
        u0(i8, Float.floatToRawIntBits(f8));
    }

    public final void z0(float f8) throws IOException {
        v0(Float.floatToRawIntBits(f8));
    }

    private CodedOutputStream() {
    }
}
