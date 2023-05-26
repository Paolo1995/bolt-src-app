package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public final class ExceptionPassthroughInputStream extends InputStream {

    /* renamed from: h  reason: collision with root package name */
    private static final Queue<ExceptionPassthroughInputStream> f10770h = Util.f(0);

    /* renamed from: f  reason: collision with root package name */
    private InputStream f10771f;

    /* renamed from: g  reason: collision with root package name */
    private IOException f10772g;

    ExceptionPassthroughInputStream() {
    }

    @NonNull
    public static ExceptionPassthroughInputStream c(@NonNull InputStream inputStream) {
        ExceptionPassthroughInputStream poll;
        Queue<ExceptionPassthroughInputStream> queue = f10770h;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionPassthroughInputStream();
        }
        poll.e(inputStream);
        return poll;
    }

    public IOException a() {
        return this.f10772g;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f10771f.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10771f.close();
    }

    void e(@NonNull InputStream inputStream) {
        this.f10771f = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i8) {
        this.f10771f.mark(i8);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f10771f.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f10771f.read();
        } catch (IOException e8) {
            this.f10772g = e8;
            throw e8;
        }
    }

    public void release() {
        this.f10772g = null;
        this.f10771f = null;
        Queue<ExceptionPassthroughInputStream> queue = f10770h;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f10771f.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j8) throws IOException {
        try {
            return this.f10771f.skip(j8);
        } catch (IOException e8) {
            this.f10772g = e8;
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f10771f.read(bArr);
        } catch (IOException e8) {
            this.f10772g = e8;
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        try {
            return this.f10771f.read(bArr, i8, i9);
        } catch (IOException e8) {
            this.f10772g = e8;
            throw e8;
        }
    }
}
