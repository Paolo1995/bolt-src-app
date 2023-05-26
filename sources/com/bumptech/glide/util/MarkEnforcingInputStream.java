package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: f  reason: collision with root package name */
    private int f10782f;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f10782f = Integer.MIN_VALUE;
    }

    private long a(long j8) {
        int i8 = this.f10782f;
        if (i8 == 0) {
            return -1L;
        }
        if (i8 != Integer.MIN_VALUE && j8 > i8) {
            return i8;
        }
        return j8;
    }

    private void c(long j8) {
        int i8 = this.f10782f;
        if (i8 != Integer.MIN_VALUE && j8 != -1) {
            this.f10782f = (int) (i8 - j8);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i8 = this.f10782f;
        if (i8 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i8, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i8) {
        super.mark(i8);
        this.f10782f = i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        c(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f10782f = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j8) throws IOException {
        long a8 = a(j8);
        if (a8 == -1) {
            return 0L;
        }
        long skip = super.skip(a8);
        c(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i8, int i9) throws IOException {
        int a8 = (int) a(i9);
        if (a8 == -1) {
            return -1;
        }
        int read = super.read(bArr, i8, a8);
        c(read);
        return read;
    }
}
