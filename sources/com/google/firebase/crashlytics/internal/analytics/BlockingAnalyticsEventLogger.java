package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsOriginAnalyticsEventLogger f15551a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15552b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeUnit f15553c;

    /* renamed from: e  reason: collision with root package name */
    private CountDownLatch f15555e;

    /* renamed from: d  reason: collision with root package name */
    private final Object f15554d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f15556f = false;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i8, TimeUnit timeUnit) {
        this.f15551a = crashlyticsOriginAnalyticsEventLogger;
        this.f15552b = i8;
        this.f15553c = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void a(@NonNull String str, Bundle bundle) {
        synchronized (this.f15554d) {
            Logger f8 = Logger.f();
            f8.i("Logging event " + str + " to Firebase Analytics with params " + bundle);
            this.f15555e = new CountDownLatch(1);
            this.f15556f = false;
            this.f15551a.a(str, bundle);
            Logger.f().i("Awaiting app exception callback from Analytics...");
            try {
                if (this.f15555e.await(this.f15552b, this.f15553c)) {
                    this.f15556f = true;
                    Logger.f().i("App exception callback received from Analytics listener.");
                } else {
                    Logger.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                }
            } catch (InterruptedException unused) {
                Logger.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
            }
            this.f15555e = null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void b(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.f15555e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
