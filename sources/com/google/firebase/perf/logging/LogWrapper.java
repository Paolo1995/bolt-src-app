package com.google.firebase.perf.logging;

import android.util.Log;

/* loaded from: classes3.dex */
class LogWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static LogWrapper f16758a;

    private LogWrapper() {
    }

    public static synchronized LogWrapper c() {
        LogWrapper logWrapper;
        synchronized (LogWrapper.class) {
            if (f16758a == null) {
                f16758a = new LogWrapper();
            }
            logWrapper = f16758a;
        }
        return logWrapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        Log.d("FirebasePerformance", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        Log.e("FirebasePerformance", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        Log.i("FirebasePerformance", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        Log.w("FirebasePerformance", str);
    }
}
