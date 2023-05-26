package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.Logger;
import j$.util.Spliterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class NetworkCache {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LottieNetworkCacheProvider f9521a;

    public NetworkCache(@NonNull LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.f9521a = lottieNetworkCacheProvider;
    }

    private static String b(String str, FileExtension fileExtension, boolean z7) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        if (z7) {
            str2 = fileExtension.a();
        } else {
            str2 = fileExtension.f9520f;
        }
        sb.append(str2);
        return sb.toString();
    }

    private File c(String str) throws FileNotFoundException {
        File file = new File(d(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File a8 = this.f9521a.a();
        if (a8.isFile()) {
            a8.delete();
        }
        if (!a8.exists()) {
            a8.mkdirs();
        }
        return a8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<FileExtension, InputStream> a(String str) {
        FileExtension fileExtension;
        try {
            File c8 = c(str);
            if (c8 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c8);
            if (c8.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            Logger.a("Cache hit for " + str + " at " + c8.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileExtension fileExtension) {
        File file = new File(d(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        Logger.a("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            Logger.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File f(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(d(), b(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[Spliterator.IMMUTABLE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
