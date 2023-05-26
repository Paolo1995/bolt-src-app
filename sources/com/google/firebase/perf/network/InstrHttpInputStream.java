package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class InstrHttpInputStream extends InputStream {

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f16791f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkRequestMetricBuilder f16792g;

    /* renamed from: h  reason: collision with root package name */
    private final Timer f16793h;

    /* renamed from: j  reason: collision with root package name */
    private long f16795j;

    /* renamed from: i  reason: collision with root package name */
    private long f16794i = -1;

    /* renamed from: k  reason: collision with root package name */
    private long f16796k = -1;

    public InstrHttpInputStream(InputStream inputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.f16793h = timer;
        this.f16791f = inputStream;
        this.f16792g = networkRequestMetricBuilder;
        this.f16795j = networkRequestMetricBuilder.e();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.f16791f.available();
        } catch (IOException e8) {
            this.f16792g.t(this.f16793h.b());
            NetworkRequestMetricBuilderUtil.d(this.f16792g);
            throw e8;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long b8 = this.f16793h.b();
        if (this.f16796k == -1) {
            this.f16796k = b8;
        }
        try {
            this.f16791f.close();
            long j8 = this.f16794i;
            if (j8 != -1) {
                this.f16792g.r(j8);
            }
            long j9 = this.f16795j;
            if (j9 != -1) {
                this.f16792g.u(j9);
            }
            this.f16792g.t(this.f16796k);
            this.f16792g.b();
        } catch (IOException e8) {
            this.f16792g.t(this.f16793h.b());
            NetworkRequestMetricBuilderUtil.d(this.f16792g);
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i8) {
        this.f16791f.mark(i8);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f16791f.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int read = this.f16791f.read();
            long b8 = this.f16793h.b();
            if (this.f16795j == -1) {
                this.f16795j = b8;
            }
            if (read == -1 && this.f16796k == -1) {
                this.f16796k = b8;
                this.f16792g.t(b8);
                this.f16792g.b();
            } else {
                long j8 = this.f16794i + 1;
                this.f16794i = j8;
                this.f16792g.r(j8);
            }
            return read;
        } catch (IOException e8) {
            this.f16792g.t(this.f16793h.b());
            NetworkRequestMetricBuilderUtil.d(this.f16792g);
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        try {
            this.f16791f.reset();
        } catch (IOException e8) {
            this.f16792g.t(this.f16793h.b());
            NetworkRequestMetricBuilderUtil.d(this.f16792g);
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j8) throws IOException {
        try {
            long skip = this.f16791f.skip(j8);
            long b8 = this.f16793h.b();
            if (this.f16795j == -1) {
                this.f16795j = b8;
            }
            if (skip == -1 && this.f16796k == -1) {
                this.f16796k = b8;
                this.f16792g.t(b8);
            } else {
                long j9 = this.f16794i + skip;
                this.f16794i = j9;
                this.f16792g.r(j9);
            }
            return skip;
        } catch (IOException e8) {
            this.f16792g.t(this.f16793h.b());
            NetworkRequestMetricBuilderUtil.d(this.f16792g);
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        try {
            int read = this.f16791f.read(bArr, i8, i9);
            long b8 = this.f16793h.b();
            if (this.f16795j == -1) {
                this.f16795j = b8;
            }
            if (read == -1 && this.f16796k == -1) {
                this.f16796k = b8;
                this.f16792g.t(b8);
                this.f16792g.b();
            } else {
                long j8 = this.f16794i + read;
                this.f16794i = j8;
                this.f16792g.r(j8);
            }
            return read;
        } catch (IOException e8) {
            this.f16792g.t(this.f16793h.b());
            NetworkRequestMetricBuilderUtil.d(this.f16792g);
            throw e8;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int read = this.f16791f.read(bArr);
            long b8 = this.f16793h.b();
            if (this.f16795j == -1) {
                this.f16795j = b8;
            }
            if (read == -1 && this.f16796k == -1) {
                this.f16796k = b8;
                this.f16792g.t(b8);
                this.f16792g.b();
            } else {
                long j8 = this.f16794i + read;
                this.f16794i = j8;
                this.f16792g.r(j8);
            }
            return read;
        } catch (IOException e8) {
            this.f16792g.t(this.f16793h.b());
            NetworkRequestMetricBuilderUtil.d(this.f16792g);
            throw e8;
        }
    }
}
