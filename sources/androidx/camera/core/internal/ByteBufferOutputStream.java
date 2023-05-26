package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ByteBufferOutputStream extends OutputStream {

    /* renamed from: f  reason: collision with root package name */
    private final ByteBuffer f3891f;

    public ByteBufferOutputStream(@NonNull ByteBuffer byteBuffer) {
        this.f3891f = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        if (this.f3891f.hasRemaining()) {
            this.f3891f.put((byte) i8);
            return;
        }
        throw new EOFException("Output ByteBuffer has no bytes remaining.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        bArr.getClass();
        if (i8 < 0 || i8 > bArr.length || i9 < 0 || (i10 = i8 + i9) > bArr.length || i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i9 == 0) {
            return;
        }
        if (this.f3891f.remaining() >= i9) {
            this.f3891f.put(bArr, i8, i9);
            return;
        }
        throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
    }
}
