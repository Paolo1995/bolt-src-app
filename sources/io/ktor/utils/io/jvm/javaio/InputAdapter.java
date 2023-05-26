package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: Blocking.kt */
/* loaded from: classes5.dex */
final class InputAdapter extends InputStream {

    /* renamed from: f  reason: collision with root package name */
    private final ByteReadChannel f47491f;

    /* renamed from: g  reason: collision with root package name */
    private final CompletableJob f47492g;

    /* renamed from: h  reason: collision with root package name */
    private final InputAdapter$loop$1 f47493h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f47494i;

    public InputAdapter(Job job, ByteReadChannel channel) {
        Intrinsics.f(channel, "channel");
        this.f47491f = channel;
        this.f47492g = JobKt.a(job);
        this.f47493h = new InputAdapter$loop$1(job, this);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f47491f.d();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
        ByteReadChannelKt.a(this.f47491f);
        if (!this.f47492g.c()) {
            Job.DefaultImpls.a(this.f47492g, null, 1, null);
        }
        this.f47493h.k();
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f47494i;
        if (bArr == null) {
            bArr = new byte[1];
            this.f47494i = bArr;
        }
        int m8 = this.f47493h.m(bArr, 0, 1);
        if (m8 == -1) {
            return -1;
        }
        if (m8 == 1) {
            return bArr[0] & 255;
        }
        throw new IllegalStateException(("Expected a single byte or EOF. Got " + m8 + " bytes.").toString());
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i8, int i9) {
        InputAdapter$loop$1 inputAdapter$loop$1;
        inputAdapter$loop$1 = this.f47493h;
        Intrinsics.c(bArr);
        return inputAdapter$loop$1.m(bArr, i8, i9);
    }
}
