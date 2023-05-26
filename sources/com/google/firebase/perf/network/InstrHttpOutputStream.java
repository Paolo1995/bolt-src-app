package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class InstrHttpOutputStream extends OutputStream {

    /* renamed from: f  reason: collision with root package name */
    private OutputStream f16797f;

    /* renamed from: g  reason: collision with root package name */
    long f16798g = -1;

    /* renamed from: h  reason: collision with root package name */
    NetworkRequestMetricBuilder f16799h;

    /* renamed from: i  reason: collision with root package name */
    private final Timer f16800i;

    public InstrHttpOutputStream(OutputStream outputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.f16797f = outputStream;
        this.f16799h = networkRequestMetricBuilder;
        this.f16800i = timer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long j8 = this.f16798g;
        if (j8 != -1) {
            this.f16799h.o(j8);
        }
        this.f16799h.s(this.f16800i.b());
        try {
            this.f16797f.close();
        } catch (IOException e8) {
            this.f16799h.t(this.f16800i.b());
            NetworkRequestMetricBuilderUtil.d(this.f16799h);
            throw e8;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.f16797f.flush();
        } catch (IOException e8) {
            this.f16799h.t(this.f16800i.b());
            NetworkRequestMetricBuilderUtil.d(this.f16799h);
            throw e8;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        try {
            this.f16797f.write(i8);
            long j8 = this.f16798g + 1;
            this.f16798g = j8;
            this.f16799h.o(j8);
        } catch (IOException e8) {
            this.f16799h.t(this.f16800i.b());
            NetworkRequestMetricBuilderUtil.d(this.f16799h);
            throw e8;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.f16797f.write(bArr);
            long length = this.f16798g + bArr.length;
            this.f16798g = length;
            this.f16799h.o(length);
        } catch (IOException e8) {
            this.f16799h.t(this.f16800i.b());
            NetworkRequestMetricBuilderUtil.d(this.f16799h);
            throw e8;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        try {
            this.f16797f.write(bArr, i8, i9);
            long j8 = this.f16798g + i9;
            this.f16798g = j8;
            this.f16799h.o(j8);
        } catch (IOException e8) {
            this.f16799h.t(this.f16800i.b());
            NetworkRequestMetricBuilderUtil.d(this.f16799h);
            throw e8;
        }
    }
}
