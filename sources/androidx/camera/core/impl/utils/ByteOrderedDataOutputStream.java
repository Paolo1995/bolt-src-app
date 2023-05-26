package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
class ByteOrderedDataOutputStream extends FilterOutputStream {

    /* renamed from: f  reason: collision with root package name */
    final OutputStream f3759f;

    /* renamed from: g  reason: collision with root package name */
    private ByteOrder f3760g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f3759f = outputStream;
        this.f3760g = byteOrder;
    }

    public void a(ByteOrder byteOrder) {
        this.f3760g = byteOrder;
    }

    public void c(int i8) throws IOException {
        this.f3759f.write(i8);
    }

    public void e(int i8) throws IOException {
        ByteOrder byteOrder = this.f3760g;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.f3759f.write((i8 >>> 0) & 255);
            this.f3759f.write((i8 >>> 8) & 255);
            this.f3759f.write((i8 >>> 16) & 255);
            this.f3759f.write((i8 >>> 24) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.f3759f.write((i8 >>> 24) & 255);
            this.f3759f.write((i8 >>> 16) & 255);
            this.f3759f.write((i8 >>> 8) & 255);
            this.f3759f.write((i8 >>> 0) & 255);
        }
    }

    public void g(short s7) throws IOException {
        ByteOrder byteOrder = this.f3760g;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.f3759f.write((s7 >>> 0) & 255);
            this.f3759f.write((s7 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.f3759f.write((s7 >>> 8) & 255);
            this.f3759f.write((s7 >>> 0) & 255);
        }
    }

    public void h(long j8) throws IOException {
        e((int) j8);
    }

    public void j(int i8) throws IOException {
        g((short) i8);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f3759f.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        this.f3759f.write(bArr, i8, i9);
    }
}
