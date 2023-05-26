package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
class FileBackedNativeSessionFile implements NativeSessionFile {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final File f15704a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f15705b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f15706c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f15705b = str;
        this.f15706c = str2;
        this.f15704a = file;
    }

    private byte[] d() {
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        try {
            InputStream c8 = c();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            if (c8 == null) {
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                if (c8 != null) {
                    c8.close();
                }
                return null;
            }
            while (true) {
                try {
                    int read = c8.read(bArr);
                    if (read > 0) {
                        gZIPOutputStream.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        c8.close();
                        return byteArray;
                    }
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public CrashlyticsReport.FilesPayload.File a() {
        byte[] d8 = d();
        if (d8 != null) {
            return CrashlyticsReport.FilesPayload.File.a().b(d8).c(this.f15705b).a();
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @NonNull
    public String b() {
        return this.f15706c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public InputStream c() {
        if (this.f15704a.exists() && this.f15704a.isFile()) {
            try {
                return new FileInputStream(this.f15704a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
