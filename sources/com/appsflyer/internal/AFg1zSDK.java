package com.appsflyer.internal;

import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class AFg1zSDK extends FilterInputStream {
    private static final short AFInAppEventParameterName = (short) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d));
    private byte[] AFInAppEventType;
    private byte[] AFKeystoreWrapper;
    private int AFLogger;
    private int AFVersionDeclaration;
    private int afDebugLog;
    private int afErrorLog;
    private int afErrorLogForExcManagerOnly;
    private int afInfoLog;
    private int afRDLog;
    private int afWarnLog;
    private int valueOf;
    private byte[] values;

    public AFg1zSDK(InputStream inputStream, int[] iArr, int i8, byte[] bArr, int i9, int i10) throws IOException {
        super(inputStream);
        this.AFLogger = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.values = new byte[8];
        this.AFKeystoreWrapper = new byte[8];
        this.AFInAppEventType = new byte[8];
        this.valueOf = 8;
        this.afErrorLog = 8;
        this.afRDLog = Math.min(Math.max(i9, 5), 16);
        this.afDebugLog = i10;
        if (i10 == 3) {
            System.arraycopy(bArr, 0, this.AFKeystoreWrapper, 0, 8);
        }
        long j8 = ((iArr[0] & 4294967295L) << 32) | (4294967295L & iArr[1]);
        if (i8 == 0) {
            this.afInfoLog = (int) j8;
            long j9 = j8 >> 3;
            short s7 = AFInAppEventParameterName;
            this.AFVersionDeclaration = (int) ((s7 * j9) >> 32);
            this.afWarnLog = (int) (j8 >> 32);
            this.afErrorLogForExcManagerOnly = (int) (j9 + s7);
            return;
        }
        int i11 = (int) j8;
        this.afInfoLog = i11;
        this.AFVersionDeclaration = i11 * i8;
        this.afWarnLog = i11 ^ i8;
        this.afErrorLogForExcManagerOnly = (int) (j8 >> 32);
    }

    private int AFInAppEventType() throws IOException {
        if (this.AFLogger == Integer.MAX_VALUE) {
            this.AFLogger = ((FilterInputStream) this).in.read();
        }
        int i8 = 8;
        if (this.valueOf == 8) {
            byte[] bArr = this.values;
            int i9 = this.AFLogger;
            bArr[0] = (byte) i9;
            if (i9 >= 0) {
                int i10 = 1;
                do {
                    int read = ((FilterInputStream) this).in.read(this.values, i10, 8 - i10);
                    if (read <= 0) {
                        break;
                    }
                    i10 += read;
                } while (i10 < 8);
                if (i10 >= 8) {
                    valueOf();
                    int read2 = ((FilterInputStream) this).in.read();
                    this.AFLogger = read2;
                    this.valueOf = 0;
                    if (read2 < 0) {
                        i8 = 8 - (this.values[7] & 255);
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

    private void valueOf() {
        if (this.afDebugLog == 3) {
            byte[] bArr = this.values;
            System.arraycopy(bArr, 0, this.AFInAppEventType, 0, bArr.length);
        }
        byte[] bArr2 = this.values;
        int i8 = ((bArr2[0] << 24) & (-16777216)) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i9 = ((-16777216) & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i10 = 0;
        while (true) {
            int i11 = this.afRDLog;
            if (i10 >= i11) {
                break;
            }
            short s7 = AFInAppEventParameterName;
            i9 -= ((((i11 - i10) * s7) + i8) ^ ((i8 << 4) + this.afWarnLog)) ^ ((i8 >>> 5) + this.afErrorLogForExcManagerOnly);
            i8 -= (((i9 << 4) + this.afInfoLog) ^ ((s7 * (i11 - i10)) + i9)) ^ ((i9 >>> 5) + this.AFVersionDeclaration);
            i10++;
        }
        byte[] bArr3 = this.values;
        bArr3[0] = (byte) (i8 >> 24);
        bArr3[1] = (byte) (i8 >> 16);
        bArr3[2] = (byte) (i8 >> 8);
        bArr3[3] = (byte) i8;
        bArr3[4] = (byte) (i9 >> 24);
        bArr3[5] = (byte) (i9 >> 16);
        bArr3[6] = (byte) (i9 >> 8);
        bArr3[7] = (byte) i9;
        if (this.afDebugLog == 3) {
            for (int i12 = 0; i12 < 8; i12++) {
                byte[] bArr4 = this.values;
                bArr4[i12] = (byte) (bArr4[i12] ^ this.AFKeystoreWrapper[i12]);
            }
            byte[] bArr5 = this.AFInAppEventType;
            System.arraycopy(bArr5, 0, this.AFKeystoreWrapper, 0, bArr5.length);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        AFInAppEventType();
        return this.afErrorLog - this.valueOf;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        AFInAppEventType();
        int i8 = this.valueOf;
        if (i8 >= this.afErrorLog) {
            return -1;
        }
        byte[] bArr = this.values;
        this.valueOf = i8 + 1;
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
            AFInAppEventType();
            int i12 = this.valueOf;
            if (i12 >= this.afErrorLog) {
                if (i11 == i8) {
                    return -1;
                }
                return i9 - (i10 - i11);
            }
            byte[] bArr2 = this.values;
            this.valueOf = i12 + 1;
            bArr[i11] = bArr2[i12];
        }
        return i9;
    }
}
