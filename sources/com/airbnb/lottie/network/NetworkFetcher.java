package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class NetworkFetcher {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NetworkCache f9522a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final LottieNetworkFetcher f9523b;

    public NetworkFetcher(@NonNull NetworkCache networkCache, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.f9522a = networkCache;
        this.f9523b = lottieNetworkFetcher;
    }

    private LottieComposition a(@NonNull String str, String str2) {
        Pair<FileExtension, InputStream> a8;
        LottieResult<LottieComposition> o8;
        if (str2 == null || (a8 = this.f9522a.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a8.first;
        InputStream inputStream = (InputStream) a8.second;
        if (fileExtension == FileExtension.ZIP) {
            o8 = LottieCompositionFactory.y(new ZipInputStream(inputStream), str);
        } else {
            o8 = LottieCompositionFactory.o(inputStream, str);
        }
        if (o8.b() == null) {
            return null;
        }
        return o8.b();
    }

    @NonNull
    private LottieResult<LottieComposition> b(@NonNull String str, String str2) {
        boolean z7;
        Logger.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult a8 = this.f9523b.a(str);
                if (a8.isSuccessful()) {
                    LottieResult<LottieComposition> d8 = d(str, a8.T(), a8.P(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    if (d8.b() != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    sb.append(z7);
                    Logger.a(sb.toString());
                    try {
                        a8.close();
                    } catch (IOException e8) {
                        Logger.d("LottieFetchResult close failed ", e8);
                    }
                    return d8;
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(new IllegalArgumentException(a8.i()));
                try {
                    a8.close();
                } catch (IOException e9) {
                    Logger.d("LottieFetchResult close failed ", e9);
                }
                return lottieResult;
            } catch (Exception e10) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e10);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e11) {
                        Logger.d("LottieFetchResult close failed ", e11);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e12) {
                    Logger.d("LottieFetchResult close failed ", e12);
                }
            }
            throw th;
        }
    }

    @NonNull
    private LottieResult<LottieComposition> d(@NonNull String str, @NonNull InputStream inputStream, String str2, String str3) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> f8;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            Logger.a("Received json response.");
            fileExtension = FileExtension.JSON;
            f8 = e(str, inputStream, str3);
        } else {
            Logger.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            f8 = f(str, inputStream, str3);
        }
        if (str3 != null && f8.b() != null) {
            this.f9522a.e(str, fileExtension);
        }
        return f8;
    }

    @NonNull
    private LottieResult<LottieComposition> e(@NonNull String str, @NonNull InputStream inputStream, String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.o(inputStream, null);
        }
        return LottieCompositionFactory.o(new FileInputStream(this.f9522a.f(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    private LottieResult<LottieComposition> f(@NonNull String str, @NonNull InputStream inputStream, String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.y(new ZipInputStream(inputStream), null);
        }
        return LottieCompositionFactory.y(new ZipInputStream(new FileInputStream(this.f9522a.f(str, inputStream, FileExtension.ZIP))), str);
    }

    @NonNull
    public LottieResult<LottieComposition> c(@NonNull String str, String str2) {
        LottieComposition a8 = a(str, str2);
        if (a8 != null) {
            return new LottieResult<>(a8);
        }
        Logger.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }
}
