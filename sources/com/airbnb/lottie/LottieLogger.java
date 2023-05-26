package com.airbnb.lottie;

/* loaded from: classes.dex */
public interface LottieLogger {
    void a(String str);

    void b(String str, Throwable th);

    void debug(String str);

    void error(String str, Throwable th);
}
