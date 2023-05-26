package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final CrashListener f15677a;

    /* renamed from: b  reason: collision with root package name */
    private final SettingsProvider f15678b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f15679c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsNativeComponent f15680d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f15681e = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    interface CrashListener {
        void a(SettingsProvider settingsProvider, Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener, SettingsProvider settingsProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponent crashlyticsNativeComponent) {
        this.f15677a = crashListener;
        this.f15678b = settingsProvider;
        this.f15679c = uncaughtExceptionHandler;
        this.f15680d = crashlyticsNativeComponent;
    }

    private boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            Logger.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        } else if (th == null) {
            Logger.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        } else if (this.f15680d.b()) {
            Logger.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f15681e.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.firebase.crashlytics.internal.Logger] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.firebase.crashlytics.internal.Logger] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.atomic.AtomicBoolean] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ?? r02 = "Completed exception processing. Invoking default exception handler.";
        this.f15681e.set(true);
        try {
            try {
                if (b(thread, th)) {
                    this.f15677a.a(this.f15678b, thread, th);
                } else {
                    Logger.f().b("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e8) {
                Logger.f().e("An error occurred in the uncaught exception handler", e8);
            }
        } finally {
            Logger.f().b(r02);
            this.f15679c.uncaughtException(thread, th);
            this.f15681e.set(false);
        }
    }
}
