package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class NioByteString extends ByteString.LeafByteString {

    /* renamed from: j  reason: collision with root package name */
    private final ByteBuffer f17542j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NioByteString(ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        this.f17542j = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer S(int i8, int i9) {
        if (i8 >= this.f17542j.position() && i9 <= this.f17542j.limit() && i8 <= i9) {
            ByteBuffer slice = this.f17542j.slice();
            slice.position(i8 - this.f17542j.position());
            slice.limit(i9 - this.f17542j.position());
            return slice;
        }
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream B() {
        return CodedInputStream.l(this.f17542j, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int C(int i8, int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            i8 = (i8 * 31) + this.f17542j.get(i11);
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int D(int i8, int i9, int i10) {
        return Utf8.u(i8, this.f17542j, i9, i10 + i9);
    }

    @Override // com.google.protobuf.ByteString
    public ByteString G(int i8, int i9) {
        try {
            return new NioByteString(S(i8, i9));
        } catch (ArrayIndexOutOfBoundsException e8) {
            throw e8;
        } catch (IndexOutOfBoundsException e9) {
            throw new ArrayIndexOutOfBoundsException(e9.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    protected String K(Charset charset) {
        byte[] H;
        int i8;
        int length;
        if (this.f17542j.hasArray()) {
            H = this.f17542j.array();
            i8 = this.f17542j.arrayOffset() + this.f17542j.position();
            length = this.f17542j.remaining();
        } else {
            H = H();
            i8 = 0;
            length = H.length;
        }
        return new String(H, i8, length, charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void Q(ByteOutput byteOutput) throws IOException {
        byteOutput.a(this.f17542j.slice());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString.LeafByteString
    public boolean R(ByteString byteString, int i8, int i9) {
        return G(0, i9).equals(byteString.G(i8, i9 + i8));
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer d() {
        return this.f17542j.asReadOnlyBuffer();
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
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.f17542j.equals(((NioByteString) obj).f17542j);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.f17542j.equals(byteString.d());
    }

    @Override // com.google.protobuf.ByteString
    public byte g(int i8) {
        try {
            return this.f17542j.get(i8);
        } catch (ArrayIndexOutOfBoundsException e8) {
            throw e8;
        } catch (IndexOutOfBoundsException e9) {
            throw new ArrayIndexOutOfBoundsException(e9.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.f17542j.remaining();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public void u(byte[] bArr, int i8, int i9, int i10) {
        ByteBuffer slice = this.f17542j.slice();
        slice.position(i8);
        slice.get(bArr, i9, i10);
    }

    @Override // com.google.protobuf.ByteString
    public byte w(int i8) {
        return g(i8);
    }

    @Override // com.google.protobuf.ByteString
    public boolean y() {
        return Utf8.r(this.f17542j);
    }
}
