package com.appsflyer.internal;

import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class AFg1ySDK extends FilterInputStream {
    private final int AFInAppEventParameterName;
    private short AFInAppEventType;
    private long[] AFKeystoreWrapper;
    private int AFLogger;
    private int afErrorLog;
    private int afRDLog;
    private byte[] valueOf;
    private long[] values;

    public AFg1ySDK(InputStream inputStream, int i8, int i9, short s7, int i10, int i11) throws IOException {
        super(inputStream);
        this.AFLogger = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int min = Math.min(Math.max((int) s7, 4), 8);
        this.AFInAppEventParameterName = min;
        this.valueOf = new byte[min];
        this.values = new long[4];
        this.AFKeystoreWrapper = new long[4];
        this.afRDLog = min;
        this.afErrorLog = min;
        this.values = AFg1wSDK.values(i8 ^ i11, min ^ i11);
        this.AFKeystoreWrapper = AFg1wSDK.values(i9 ^ i11, i10 ^ i11);
    }

    private void AFInAppEventType() {
        long[] jArr = this.values;
        long[] jArr2 = this.AFKeystoreWrapper;
        short s7 = this.AFInAppEventType;
        long j8 = jArr2[(s7 + 2) % 4];
        int i8 = (s7 + 3) % 4;
        jArr2[i8] = ((jArr[i8] * 2147483085) + j8) / 2147483647L;
        jArr[i8] = ((jArr[s7 % 4] * 2147483085) + j8) % 2147483647L;
        for (int i9 = 0; i9 < this.AFInAppEventParameterName; i9++) {
            byte[] bArr = this.valueOf;
            bArr[i9] = (byte) (bArr[i9] ^ ((this.values[this.AFInAppEventType] >> (i9 << 3)) & 255));
        }
        this.AFInAppEventType = (short) ((this.AFInAppEventType + 1) % 4);
    }

    private int values() throws IOException {
        int i8;
        if (this.AFLogger == Integer.MAX_VALUE) {
            this.AFLogger = ((FilterInputStream) this).in.read();
        }
        if (this.afRDLog == this.AFInAppEventParameterName) {
            byte[] bArr = this.valueOf;
            int i9 = this.AFLogger;
            bArr[0] = (byte) i9;
            if (i9 >= 0) {
                int i10 = 1;
                do {
                    int read = ((FilterInputStream) this).in.read(this.valueOf, i10, this.AFInAppEventParameterName - i10);
                    if (read <= 0) {
                        break;
                    }
                    i10 += read;
                } while (i10 < this.AFInAppEventParameterName);
                if (i10 >= this.AFInAppEventParameterName) {
                    AFInAppEventType();
                    int read2 = ((FilterInputStream) this).in.read();
                    this.AFLogger = read2;
                    this.afRDLog = 0;
                    if (read2 < 0) {
                        int i11 = this.AFInAppEventParameterName;
                        i8 = i11 - (this.valueOf[i11 - 1] & 255);
                    } else {
                        i8 = this.AFInAppEventParameterName;
                    }
                    this.afErrorLog = i8;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.afErrorLog;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        values();
        return this.afErrorLog - this.afRDLog;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        values();
        int i8 = this.afRDLog;
        if (i8 >= this.afErrorLog) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.afRDLog = i8 + 1;
        return bArr[i8] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j8) throws IOException {
        long j9 = 0;
        while (j9 < j8 && read() != -1) {
            j9++;
        }
        return j9;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = i8 + i9;
        for (int i11 = i8; i11 < i10; i11++) {
            values();
            int i12 = this.afRDLog;
            if (i12 >= this.afErrorLog) {
                if (i11 == i8) {
                    return -1;
                }
                return i9 - (i10 - i11);
            }
            byte[] bArr2 = this.valueOf;
            this.afRDLog = i12 + 1;
            bArr[i11] = bArr2[i12];
        }
        return i9;
    }
}
