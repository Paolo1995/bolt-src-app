package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
class BytesBackedNativeSessionFile implements NativeSessionFile {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f15571a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f15572b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f15573c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BytesBackedNativeSessionFile(@NonNull String str, @NonNull String str2, byte[] bArr) {
        this.f15572b = str;
        this.f15573c = str2;
        this.f15571a = bArr;
    }

    private byte[] d() {
        if (e()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(this.f15571a);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean e() {
        byte[] bArr = this.f15571a;
        if (bArr != null && bArr.length != 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public CrashlyticsReport.FilesPayload.File a() {
        byte[] d8 = d();
        if (d8 == null) {
            return null;
        }
        return CrashlyticsReport.FilesPayload.File.a().b(d8).c(this.f15572b).a();
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @NonNull
    public String b() {
        return this.f15573c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public InputStream c() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f15571a);
    }
}
