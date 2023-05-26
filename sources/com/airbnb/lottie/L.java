package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import java.io.File;

/* loaded from: classes.dex */
public class L {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8841a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8842b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f8843c;

    /* renamed from: d  reason: collision with root package name */
    private static long[] f8844d;

    /* renamed from: e  reason: collision with root package name */
    private static int f8845e;

    /* renamed from: f  reason: collision with root package name */
    private static int f8846f;

    /* renamed from: g  reason: collision with root package name */
    private static LottieNetworkFetcher f8847g;

    /* renamed from: h  reason: collision with root package name */
    private static LottieNetworkCacheProvider f8848h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile NetworkFetcher f8849i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile NetworkCache f8850j;

    private L() {
    }

    public static void a(String str) {
        if (!f8842b) {
            return;
        }
        int i8 = f8845e;
        if (i8 == 20) {
            f8846f++;
            return;
        }
        f8843c[i8] = str;
        f8844d[i8] = System.nanoTime();
        TraceCompat.a(str);
        f8845e++;
    }

    public static float b(String str) {
        int i8 = f8846f;
        if (i8 > 0) {
            f8846f = i8 - 1;
            return 0.0f;
        } else if (!f8842b) {
            return 0.0f;
        } else {
            int i9 = f8845e - 1;
            f8845e = i9;
            if (i9 != -1) {
                if (str.equals(f8843c[i9])) {
                    TraceCompat.b();
                    return ((float) (System.nanoTime() - f8844d[f8845e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f8843c[f8845e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
    }

    @NonNull
    public static NetworkCache c(@NonNull Context context) {
        final Context applicationContext = context.getApplicationContext();
        NetworkCache networkCache = f8850j;
        if (networkCache == null) {
            synchronized (NetworkCache.class) {
                networkCache = f8850j;
                if (networkCache == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = f8848h;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new LottieNetworkCacheProvider() { // from class: com.airbnb.lottie.L.1
                            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
                            @NonNull
                            public File a() {
                                return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    networkCache = new NetworkCache(lottieNetworkCacheProvider);
                    f8850j = networkCache;
                }
            }
        }
        return networkCache;
    }

    @NonNull
    public static NetworkFetcher d(@NonNull Context context) {
        NetworkFetcher networkFetcher = f8849i;
        if (networkFetcher == null) {
            synchronized (NetworkFetcher.class) {
                networkFetcher = f8849i;
                if (networkFetcher == null) {
                    NetworkCache c8 = c(context);
                    LottieNetworkFetcher lottieNetworkFetcher = f8847g;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new DefaultLottieNetworkFetcher();
                    }
                    networkFetcher = new NetworkFetcher(c8, lottieNetworkFetcher);
                    f8849i = networkFetcher;
                }
            }
        }
        return networkFetcher;
    }
}
