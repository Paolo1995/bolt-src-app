package com.bumptech.glide.disklrucache;

import androidx.fragment.app.FragmentTransaction;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
class StrictLineReader implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f9842f;

    /* renamed from: g  reason: collision with root package name */
    private final Charset f9843g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f9844h;

    /* renamed from: i  reason: collision with root package name */
    private int f9845i;

    /* renamed from: j  reason: collision with root package name */
    private int f9846j;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, FragmentTransaction.TRANSIT_EXIT_MASK, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f9842f;
        byte[] bArr = this.f9844h;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f9845i = 0;
            this.f9846j = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f9842f) {
            if (this.f9844h != null) {
                this.f9844h = null;
                this.f9842f.close();
            }
        }
    }

    public boolean e() {
        if (this.f9846j == -1) {
            return true;
        }
        return false;
    }

    public String g() throws IOException {
        int i8;
        byte[] bArr;
        int i9;
        synchronized (this.f9842f) {
            if (this.f9844h != null) {
                if (this.f9845i >= this.f9846j) {
                    c();
                }
                for (int i10 = this.f9845i; i10 != this.f9846j; i10++) {
                    byte[] bArr2 = this.f9844h;
                    if (bArr2[i10] == 10) {
                        int i11 = this.f9845i;
                        if (i10 != i11) {
                            i9 = i10 - 1;
                            if (bArr2[i9] == 13) {
                                String str = new String(bArr2, i11, i9 - i11, this.f9843g.name());
                                this.f9845i = i10 + 1;
                                return str;
                            }
                        }
                        i9 = i10;
                        String str2 = new String(bArr2, i11, i9 - i11, this.f9843g.name());
                        this.f9845i = i10 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f9846j - this.f9845i) + 80) { // from class: com.bumptech.glide.disklrucache.StrictLineReader.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i12 = ((ByteArrayOutputStream) this).count;
                        if (i12 > 0 && ((ByteArrayOutputStream) this).buf[i12 - 1] == 13) {
                            i12--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i12, StrictLineReader.this.f9843g.name());
                        } catch (UnsupportedEncodingException e8) {
                            throw new AssertionError(e8);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.f9844h;
                    int i12 = this.f9845i;
                    byteArrayOutputStream.write(bArr3, i12, this.f9846j - i12);
                    this.f9846j = -1;
                    c();
                    i8 = this.f9845i;
                    while (i8 != this.f9846j) {
                        bArr = this.f9844h;
                        if (bArr[i8] == 10) {
                            break loop1;
                        }
                        i8++;
                    }
                }
                int i13 = this.f9845i;
                if (i8 != i13) {
                    byteArrayOutputStream.write(bArr, i13, i8 - i13);
                }
                this.f9845i = i8 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public StrictLineReader(InputStream inputStream, int i8, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i8 >= 0) {
            if (charset.equals(Util.f9848a)) {
                this.f9842f = inputStream;
                this.f9843g = charset;
                this.f9844h = new byte[i8];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
