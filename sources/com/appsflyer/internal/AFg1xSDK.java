package com.appsflyer.internal;

import com.google.android.gms.common.api.Api;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class AFg1xSDK extends FilterInputStream {
    private AFf1cSDK AFInAppEventParameterName;
    private byte[] AFInAppEventType;
    private final int AFKeystoreWrapper;
    private int AFLogger;
    private int[] afDebugLog;
    private int afErrorLog;
    private int afInfoLog;
    private int afRDLog;
    private byte[] valueOf;
    private byte[] values;

    public AFg1xSDK(InputStream inputStream, int[] iArr, byte[] bArr, int i8, boolean z7, int i9) throws IOException {
        super(inputStream);
        this.afErrorLog = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int min = Math.min(Math.max(i8, 3), 16);
        this.AFKeystoreWrapper = min;
        this.valueOf = new byte[8];
        byte[] bArr2 = new byte[8];
        this.AFInAppEventType = bArr2;
        this.values = new byte[8];
        this.afDebugLog = new int[2];
        this.afInfoLog = 8;
        this.afRDLog = 8;
        this.AFLogger = i9;
        if (i9 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.AFInAppEventParameterName = new AFf1cSDK(iArr, min, true, false);
    }

    private int AFKeystoreWrapper() throws IOException {
        if (this.afErrorLog == Integer.MAX_VALUE) {
            this.afErrorLog = ((FilterInputStream) this).in.read();
        }
        int i8 = 8;
        if (this.afInfoLog == 8) {
            byte[] bArr = this.valueOf;
            int i9 = this.afErrorLog;
            bArr[0] = (byte) i9;
            if (i9 >= 0) {
                int i10 = 1;
                do {
                    int read = ((FilterInputStream) this).in.read(this.valueOf, i10, 8 - i10);
                    if (read <= 0) {
                        break;
                    }
                    i10 += read;
                } while (i10 < 8);
                if (i10 >= 8) {
                    values();
                    int read2 = ((FilterInputStream) this).in.read();
                    this.afErrorLog = read2;
                    this.afInfoLog = 0;
                    if (read2 < 0) {
                        i8 = 8 - (this.valueOf[7] & 255);
                    }
                    this.afRDLog = i8;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.afRDLog;
    }

    private void values() {
        if (this.AFLogger == 2) {
            byte[] bArr = this.valueOf;
            System.arraycopy(bArr, 0, this.values, 0, bArr.length);
        }
        byte[] bArr2 = this.valueOf;
        int i8 = ((bArr2[0] << 24) & (-16777216)) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i9 = ((-16777216) & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i10 = this.AFKeystoreWrapper;
        AFf1cSDK aFf1cSDK = this.AFInAppEventParameterName;
        AFf1dSDK.AFInAppEventParameterName(i8, i9, false, i10, aFf1cSDK.values, aFf1cSDK.AFInAppEventParameterName, this.afDebugLog);
        int[] iArr = this.afDebugLog;
        int i11 = iArr[0];
        int i12 = iArr[1];
        byte[] bArr3 = this.valueOf;
        bArr3[0] = (byte) (i11 >> 24);
        bArr3[1] = (byte) (i11 >> 16);
        bArr3[2] = (byte) (i11 >> 8);
        bArr3[3] = (byte) i11;
        bArr3[4] = (byte) (i12 >> 24);
        bArr3[5] = (byte) (i12 >> 16);
        bArr3[6] = (byte) (i12 >> 8);
        bArr3[7] = (byte) i12;
        if (this.AFLogger == 2) {
            for (int i13 = 0; i13 < 8; i13++) {
                byte[] bArr4 = this.valueOf;
                bArr4[i13] = (byte) (bArr4[i13] ^ this.AFInAppEventType[i13]);
            }
            byte[] bArr5 = this.values;
            System.arraycopy(bArr5, 0, this.AFInAppEventType, 0, bArr5.length);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        AFKeystoreWrapper();
        return this.afRDLog - this.afInfoLog;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        AFKeystoreWrapper();
        int i8 = this.afInfoLog;
        if (i8 >= this.afRDLog) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.afInfoLog = i8 + 1;
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
            AFKeystoreWrapper();
            int i12 = this.afInfoLog;
            if (i12 >= this.afRDLog) {
                if (i11 == i8) {
                    return -1;
                }
                return i9 - (i10 - i11);
            }
            byte[] bArr2 = this.valueOf;
            this.afInfoLog = i12 + 1;
            bArr[i11] = bArr2[i12];
        }
        return i9;
    }
}
