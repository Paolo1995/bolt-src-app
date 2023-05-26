package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
class NativeSessionFileGzipper {
    NativeSessionFileGzipper() {
    }

    private static void a(InputStream inputStream, @NonNull File file) throws IOException {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        gZIPOutputStream2.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream2.finish();
                        CommonUtils.f(gZIPOutputStream2);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    CommonUtils.f(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(File file, List<NativeSessionFile> list) {
        for (NativeSessionFile nativeSessionFile : list) {
            InputStream inputStream = null;
            try {
                inputStream = nativeSessionFile.c();
                if (inputStream != null) {
                    a(inputStream, new File(file, nativeSessionFile.b()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                CommonUtils.f(null);
                throw th;
            }
            CommonUtils.f(inputStream);
        }
    }
}
