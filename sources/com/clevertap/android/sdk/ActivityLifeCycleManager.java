package com.clevertap.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActivityLifeCycleManager {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsManager f10795a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseEventQueueManager f10796b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseCallbackManager f10797c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f10798d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f10799e;

    /* renamed from: f  reason: collision with root package name */
    private final CoreMetaData f10800f;

    /* renamed from: g  reason: collision with root package name */
    private final InAppController f10801g;

    /* renamed from: h  reason: collision with root package name */
    private final PushProviders f10802h;

    /* renamed from: i  reason: collision with root package name */
    private final SessionManager f10803i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityLifeCycleManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, AnalyticsManager analyticsManager, CoreMetaData coreMetaData, SessionManager sessionManager, PushProviders pushProviders, BaseCallbackManager baseCallbackManager, InAppController inAppController, BaseEventQueueManager baseEventQueueManager) {
        this.f10799e = context;
        this.f10798d = cleverTapInstanceConfig;
        this.f10795a = analyticsManager;
        this.f10800f = coreMetaData;
        this.f10803i = sessionManager;
        this.f10802h = pushProviders;
        this.f10797c = baseCallbackManager;
        this.f10801g = inAppController;
        this.f10796b = baseEventQueueManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f10798d.n().s(this.f10798d.c(), "Starting to handle install referrer");
        try {
            final InstallReferrerClient build = InstallReferrerClient.newBuilder(this.f10799e).build();
            build.startConnection(new InstallReferrerStateListener() { // from class: com.clevertap.android.sdk.ActivityLifeCycleManager.2
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    if (!ActivityLifeCycleManager.this.f10800f.B()) {
                        ActivityLifeCycleManager.this.g();
                    }
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int i8) {
                    if (i8 != 0) {
                        if (i8 != 1) {
                            if (i8 == 2) {
                                ActivityLifeCycleManager.this.f10798d.n().f(ActivityLifeCycleManager.this.f10798d.c(), "Install Referrer data not set, API not supported by Play Store on device");
                                return;
                            }
                            return;
                        }
                        ActivityLifeCycleManager.this.f10798d.n().f(ActivityLifeCycleManager.this.f10798d.c(), "Install Referrer data not set, connection to Play Store unavailable");
                        return;
                    }
                    try {
                        ReferrerDetails installReferrer = build.getInstallReferrer();
                        String installReferrer2 = installReferrer.getInstallReferrer();
                        ActivityLifeCycleManager.this.f10800f.X(installReferrer.getReferrerClickTimestampSeconds());
                        ActivityLifeCycleManager.this.f10800f.H(installReferrer.getInstallBeginTimestampSeconds());
                        ActivityLifeCycleManager.this.f10795a.E(installReferrer2);
                        ActivityLifeCycleManager.this.f10800f.S(true);
                        Logger n8 = ActivityLifeCycleManager.this.f10798d.n();
                        String c8 = ActivityLifeCycleManager.this.f10798d.c();
                        n8.f(c8, "Install Referrer data set [Referrer URL-" + installReferrer2 + "]");
                    } catch (RemoteException e8) {
                        Logger n9 = ActivityLifeCycleManager.this.f10798d.n();
                        String c9 = ActivityLifeCycleManager.this.f10798d.c();
                        n9.f(c9, "Remote exception caused by Google Play Install Referrer library - " + e8.getMessage());
                        build.endConnection();
                        ActivityLifeCycleManager.this.f10800f.S(false);
                    } catch (NullPointerException e9) {
                        Logger n10 = ActivityLifeCycleManager.this.f10798d.n();
                        String c10 = ActivityLifeCycleManager.this.f10798d.c();
                        n10.f(c10, "Install referrer client null pointer exception caused by Google Play Install Referrer library - " + e9.getMessage());
                        build.endConnection();
                        ActivityLifeCycleManager.this.f10800f.S(false);
                    }
                }
            });
        } catch (Throwable th) {
            Logger n8 = this.f10798d.n();
            String c8 = this.f10798d.c();
            n8.s(c8, "Google Play Install Referrer's InstallReferrerClient Class not found - " + th.getLocalizedMessage() + " \n Please add implementation 'com.android.installreferrer:installreferrer:2.1' to your build.gradle");
        }
    }

    public void e() {
        CoreMetaData.G(false);
        this.f10803i.e(System.currentTimeMillis());
        this.f10798d.n().s(this.f10798d.c(), "App in background");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (this.f10800f.t()) {
            try {
                StorageHelper.n(this.f10799e, StorageHelper.s(this.f10798d, "sexe"), currentTimeMillis);
                Logger n8 = this.f10798d.n();
                String c8 = this.f10798d.c();
                n8.s(c8, "Updated session time: " + currentTimeMillis);
            } catch (Throwable th) {
                Logger n9 = this.f10798d.n();
                String c9 = this.f10798d.c();
                n9.s(c9, "Failed to update session time time: " + th.getMessage());
            }
        }
    }

    public void f(Activity activity) {
        this.f10798d.n().s(this.f10798d.c(), "App in foreground");
        this.f10803i.a();
        if (!this.f10800f.w()) {
            this.f10795a.y();
            this.f10795a.a();
            this.f10802h.K();
            CTExecutorFactory.a(this.f10798d).c().d("HandlingInstallReferrer", new Callable<Void>() { // from class: com.clevertap.android.sdk.ActivityLifeCycleManager.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    if (!ActivityLifeCycleManager.this.f10800f.B() && ActivityLifeCycleManager.this.f10800f.A()) {
                        ActivityLifeCycleManager.this.g();
                        return null;
                    }
                    return null;
                }
            });
            try {
                if (this.f10797c.e() != null) {
                    this.f10797c.e().a();
                }
            } catch (IllegalStateException e8) {
                this.f10798d.n().s(this.f10798d.c(), e8.getLocalizedMessage());
            } catch (Exception unused) {
                this.f10798d.n().s(this.f10798d.c(), "Failed to trigger location");
            }
        }
        this.f10796b.d();
        this.f10801g.k(activity);
        this.f10801g.l(activity);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r2.f10798d.t() == false) goto L3;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(android.os.Bundle r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r2 = this;
            r0 = 0
            if (r5 != 0) goto Lb
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.f10798d     // Catch: java.lang.Throwable -> L39
            boolean r1 = r1.t()     // Catch: java.lang.Throwable -> L39
            if (r1 != 0) goto L17
        Lb:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.f10798d     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L39
            boolean r5 = r1.equals(r5)     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L19
        L17:
            r5 = 1
            goto L1a
        L19:
            r5 = 0
        L1a:
            if (r5 == 0) goto L52
            if (r3 == 0) goto L31
            boolean r5 = r3.isEmpty()     // Catch: java.lang.Throwable -> L39
            if (r5 != 0) goto L31
            java.lang.String r5 = "wzrk_pn"
            boolean r5 = r3.containsKey(r5)     // Catch: java.lang.Throwable -> L39
            if (r5 == 0) goto L31
            com.clevertap.android.sdk.AnalyticsManager r5 = r2.f10795a     // Catch: java.lang.Throwable -> L39
            r5.F(r3)     // Catch: java.lang.Throwable -> L39
        L31:
            if (r4 == 0) goto L52
            com.clevertap.android.sdk.AnalyticsManager r3 = r2.f10795a     // Catch: java.lang.Throwable -> L52
            r3.A(r4, r0)     // Catch: java.lang.Throwable -> L52
            goto L52
        L39:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Throwable - "
            r4.append(r5)
            java.lang.String r3 = r3.getLocalizedMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.clevertap.android.sdk.Logger.n(r3)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.ActivityLifeCycleManager.h(android.os.Bundle, android.net.Uri, java.lang.String):void");
    }
}
