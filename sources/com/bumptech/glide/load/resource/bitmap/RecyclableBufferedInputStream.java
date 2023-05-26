package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: f  reason: collision with root package name */
    private volatile byte[] f10485f;

    /* renamed from: g  reason: collision with root package name */
    private int f10486g;

    /* renamed from: h  reason: collision with root package name */
    private int f10487h;

    /* renamed from: i  reason: collision with root package name */
    private int f10488i;

    /* renamed from: j  reason: collision with root package name */
    private int f10489j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayPool f10490k;

    /* loaded from: classes.dex */
    static class InvalidMarkException extends IOException {
        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i8 = this.f10488i;
        if (i8 != -1) {
            int i9 = this.f10489j - i8;
            int i10 = this.f10487h;
            if (i9 < i10) {
                if (i8 == 0 && i10 > bArr.length && this.f10486g == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i10) {
                        i10 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f10490k.c(i10, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f10485f = bArr2;
                    this.f10490k.put(bArr);
                    bArr = bArr2;
                } else if (i8 > 0) {
                    System.arraycopy(bArr, i8, bArr, 0, bArr.length - i8);
                }
                int i11 = this.f10489j - this.f10488i;
                this.f10489j = i11;
                this.f10488i = 0;
                this.f10486g = 0;
                int read = inputStream.read(bArr, i11, bArr.length - i11);
                int i12 = this.f10489j;
                if (read > 0) {
                    i12 += read;
                }
                this.f10486g = i12;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f10488i = -1;
            this.f10489j = 0;
            this.f10486g = read2;
        }
        return read2;
    }

    private static IOException e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f10485f != null && inputStream != null) {
        } else {
            throw e();
        }
        return (this.f10486g - this.f10489j) + inputStream.available();
    }

    public synchronized void c() {
        this.f10487h = this.f10485f.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f10485f != null) {
            this.f10490k.put(this.f10485f);
            this.f10485f = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i8) {
        this.f10487h = Math.max(this.f10487h, i8);
        this.f10488i = this.f10489j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f10485f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f10489j < this.f10486g || a(inputStream, bArr) != -1) {
                if (bArr != this.f10485f && (bArr = this.f10485f) == null) {
                    throw e();
                }
                int i8 = this.f10486g;
                int i9 = this.f10489j;
                if (i8 - i9 > 0) {
                    this.f10489j = i9 + 1;
                    return bArr[i9] & 255;
                }
                return -1;
            }
            return -1;
        }
        throw e();
    }

    public synchronized void release() {
        if (this.f10485f != null) {
            this.f10490k.put(this.f10485f);
            this.f10485f = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f10485f != null) {
            int i8 = this.f10488i;
            if (-1 != i8) {
                this.f10489j = i8;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f10489j + " markLimit: " + this.f10487h);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j8) throws IOException {
        if (j8 < 1) {
            return 0L;
        }
        byte[] bArr = this.f10485f;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i8 = this.f10486g;
                int i9 = this.f10489j;
                if (i8 - i9 >= j8) {
                    this.f10489j = (int) (i9 + j8);
                    return j8;
                }
                long j9 = i8 - i9;
                this.f10489j = i8;
                if (this.f10488i != -1 && j8 <= this.f10487h) {
                    if (a(inputStream, bArr) == -1) {
                        return j9;
                    }
                    int i10 = this.f10486g;
                    int i11 = this.f10489j;
                    if (i10 - i11 >= j8 - j9) {
                        this.f10489j = (int) ((i11 + j8) - j9);
                        return j8;
                    }
                    long j10 = (j9 + i10) - i11;
                    this.f10489j = i10;
                    return j10;
                }
                long skip = inputStream.skip(j8 - j9);
                if (skip > 0) {
                    this.f10488i = -1;
                }
                return j9 + skip;
            }
            throw e();
        }
        throw e();
    }

    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i8) {
        super(inputStream);
        this.f10488i = -1;
        this.f10490k = arrayPool;
        this.f10485f = (byte[]) arrayPool.c(i8, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        int i11;
        byte[] bArr2 = this.f10485f;
        if (bArr2 == null) {
            throw e();
        }
        if (i9 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i12 = this.f10489j;
            int i13 = this.f10486g;
            if (i12 < i13) {
                int i14 = i13 - i12 >= i9 ? i9 : i13 - i12;
                System.arraycopy(bArr2, i12, bArr, i8, i14);
                this.f10489j += i14;
                if (i14 == i9 || inputStream.available() == 0) {
                    return i14;
                }
                i8 += i14;
                i10 = i9 - i14;
            } else {
                i10 = i9;
            }
            while (true) {
                if (this.f10488i == -1 && i10 >= bArr2.length) {
                    i11 = inputStream.read(bArr, i8, i10);
                    if (i11 == -1) {
                        return i10 != i9 ? i9 - i10 : -1;
                    }
                } else if (a(inputStream, bArr2) == -1) {
                    return i10 != i9 ? i9 - i10 : -1;
                } else {
                    if (bArr2 != this.f10485f && (bArr2 = this.f10485f) == null) {
                        throw e();
                    }
                    int i15 = this.f10486g;
                    int i16 = this.f10489j;
                    i11 = i15 - i16 >= i10 ? i10 : i15 - i16;
                    System.arraycopy(bArr2, i16, bArr, i8, i11);
                    this.f10489j += i11;
                }
                i10 -= i11;
                if (i10 == 0) {
                    return i9;
                }
                if (inputStream.available() == 0) {
                    return i9 - i10;
                }
                i8 += i11;
            }
        } else {
            throw e();
        }
    }
}
