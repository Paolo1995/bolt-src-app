package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* loaded from: classes3.dex */
final class LengthCountingOutputStream extends OutputStream {

    /* renamed from: f  reason: collision with root package name */
    private long f16228f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f16228f;
    }

    @Override // java.io.OutputStream
    public void write(int i8) {
        this.f16228f++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f16228f += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i8, int i9) {
        int i10;
        if (i8 >= 0 && i8 <= bArr.length && i9 >= 0 && (i10 = i8 + i9) <= bArr.length && i10 >= 0) {
            this.f16228f += i9;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
