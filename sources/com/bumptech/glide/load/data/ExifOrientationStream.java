package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ExifOrientationStream extends FilterInputStream {

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f9943h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f9944i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f9945j;

    /* renamed from: f  reason: collision with root package name */
    private final byte f9946f;

    /* renamed from: g  reason: collision with root package name */
    private int f9947g;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f9943h = bArr;
        int length = bArr.length;
        f9944i = length;
        f9945j = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i8) {
        super(inputStream);
        if (i8 >= -1 && i8 <= 8) {
            this.f9946f = (byte) i8;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i8);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i8;
        int i9 = this.f9947g;
        if (i9 < 2 || i9 > (i8 = f9945j)) {
            read = super.read();
        } else if (i9 == i8) {
            read = this.f9946f;
        } else {
            read = f9943h[i9 - 2] & 255;
        }
        if (read != -1) {
            this.f9947g++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j8) throws IOException {
        long skip = super.skip(j8);
        if (skip > 0) {
            this.f9947g = (int) (this.f9947g + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        int i11 = this.f9947g;
        int i12 = f9945j;
        if (i11 > i12) {
            i10 = super.read(bArr, i8, i9);
        } else if (i11 == i12) {
            bArr[i8] = this.f9946f;
            i10 = 1;
        } else if (i11 < 2) {
            i10 = super.read(bArr, i8, 2 - i11);
        } else {
            int min = Math.min(i12 - i11, i9);
            System.arraycopy(f9943h, this.f9947g - 2, bArr, i8, min);
            i10 = min;
        }
        if (i10 > 0) {
            this.f9947g += i10;
        }
        return i10;
    }
}
