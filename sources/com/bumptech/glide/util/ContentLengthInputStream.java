package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: f  reason: collision with root package name */
    private final long f10768f;

    /* renamed from: g  reason: collision with root package name */
    private int f10769g;

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j8) {
        super(inputStream);
        this.f10768f = j8;
    }

    private int a(int i8) throws IOException {
        if (i8 >= 0) {
            this.f10769g += i8;
        } else if (this.f10768f - this.f10769g > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f10768f + ", but read: " + this.f10769g);
        }
        return i8;
    }

    @NonNull
    public static InputStream c(@NonNull InputStream inputStream, long j8) {
        return new ContentLengthInputStream(inputStream, j8);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f10768f - this.f10769g, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i8, int i9) throws IOException {
        return a(super.read(bArr, i8, i9));
    }
}
