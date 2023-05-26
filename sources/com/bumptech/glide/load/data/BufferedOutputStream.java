package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class BufferedOutputStream extends OutputStream {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final OutputStream f9936f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f9937g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayPool f9938h;

    /* renamed from: i  reason: collision with root package name */
    private int f9939i;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void a() throws IOException {
        int i8 = this.f9939i;
        if (i8 > 0) {
            this.f9936f.write(this.f9937g, 0, i8);
            this.f9939i = 0;
        }
    }

    private void c() throws IOException {
        if (this.f9939i == this.f9937g.length) {
            a();
        }
    }

    private void release() {
        byte[] bArr = this.f9937g;
        if (bArr != null) {
            this.f9938h.put(bArr);
            this.f9937g = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f9936f.close();
            release();
        } catch (Throwable th) {
            this.f9936f.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f9936f.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        byte[] bArr = this.f9937g;
        int i9 = this.f9939i;
        this.f9939i = i9 + 1;
        bArr[i9] = (byte) i8;
        c();
    }

    BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i8) {
        this.f9936f = outputStream;
        this.f9938h = arrayPool;
        this.f9937g = (byte[]) arrayPool.c(i8, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i8, int i9) throws IOException {
        int i10 = 0;
        do {
            int i11 = i9 - i10;
            int i12 = i8 + i10;
            int i13 = this.f9939i;
            if (i13 == 0 && i11 >= this.f9937g.length) {
                this.f9936f.write(bArr, i12, i11);
                return;
            }
            int min = Math.min(i11, this.f9937g.length - i13);
            System.arraycopy(bArr, i12, this.f9937g, this.f9939i, min);
            this.f9939i += min;
            i10 += min;
            c();
        } while (i10 < i9);
    }
}
