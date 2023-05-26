package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class IterableByteBufferInputStream extends InputStream {

    /* renamed from: f  reason: collision with root package name */
    private Iterator<ByteBuffer> f17459f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f17460g;

    /* renamed from: h  reason: collision with root package name */
    private int f17461h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f17462i;

    /* renamed from: j  reason: collision with root package name */
    private int f17463j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17464k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f17465l;

    /* renamed from: m  reason: collision with root package name */
    private int f17466m;

    /* renamed from: n  reason: collision with root package name */
    private long f17467n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.f17459f = iterable.iterator();
        for (ByteBuffer byteBuffer : iterable) {
            this.f17461h++;
        }
        this.f17462i = -1;
        if (!a()) {
            this.f17460g = Internal.f17453e;
            this.f17462i = 0;
            this.f17463j = 0;
            this.f17467n = 0L;
        }
    }

    private boolean a() {
        this.f17462i++;
        if (!this.f17459f.hasNext()) {
            return false;
        }
        ByteBuffer next = this.f17459f.next();
        this.f17460g = next;
        this.f17463j = next.position();
        if (this.f17460g.hasArray()) {
            this.f17464k = true;
            this.f17465l = this.f17460g.array();
            this.f17466m = this.f17460g.arrayOffset();
        } else {
            this.f17464k = false;
            this.f17467n = UnsafeUtil.k(this.f17460g);
            this.f17465l = null;
        }
        return true;
    }

    private void c(int i8) {
        int i9 = this.f17463j + i8;
        this.f17463j = i9;
        if (i9 == this.f17460g.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f17462i == this.f17461h) {
            return -1;
        }
        if (this.f17464k) {
            int i8 = this.f17465l[this.f17463j + this.f17466m] & 255;
            c(1);
            return i8;
        }
        int w7 = UnsafeUtil.w(this.f17463j + this.f17467n) & 255;
        c(1);
        return w7;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        if (this.f17462i == this.f17461h) {
            return -1;
        }
        int limit = this.f17460g.limit();
        int i10 = this.f17463j;
        int i11 = limit - i10;
        if (i9 > i11) {
            i9 = i11;
        }
        if (this.f17464k) {
            System.arraycopy(this.f17465l, i10 + this.f17466m, bArr, i8, i9);
            c(i9);
        } else {
            int position = this.f17460g.position();
            this.f17460g.position(this.f17463j);
            this.f17460g.get(bArr, i8, i9);
            this.f17460g.position(position);
            c(i9);
        }
        return i9;
    }
}
