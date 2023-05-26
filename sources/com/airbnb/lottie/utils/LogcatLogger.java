package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class LogcatLogger implements LottieLogger {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f9639a = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public void a(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void b(String str, Throwable th) {
        Set<String> set = f9639a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    public void c(String str, Throwable th) {
        if (L.f8841a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void debug(String str) {
        c(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void error(String str, Throwable th) {
        if (L.f8841a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
