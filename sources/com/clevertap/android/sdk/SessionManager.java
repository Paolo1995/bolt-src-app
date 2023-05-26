package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.events.EventDetail;
import com.clevertap.android.sdk.validation.Validator;

/* loaded from: classes.dex */
public class SessionManager extends BaseSessionManager {

    /* renamed from: a  reason: collision with root package name */
    private long f11085a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f11086b;

    /* renamed from: c  reason: collision with root package name */
    private final CoreMetaData f11087c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f11088d;

    /* renamed from: e  reason: collision with root package name */
    private final LocalDataStore f11089e;

    /* renamed from: f  reason: collision with root package name */
    private final Validator f11090f;

    public SessionManager(CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, Validator validator, LocalDataStore localDataStore) {
        this.f11088d = cleverTapInstanceConfig;
        this.f11087c = coreMetaData;
        this.f11090f = validator;
        this.f11089e = localDataStore;
    }

    private void b(Context context) {
        this.f11087c.M((int) (System.currentTimeMillis() / 1000));
        Logger n8 = this.f11088d.n();
        String c8 = this.f11088d.c();
        n8.s(c8, "Session created with ID: " + this.f11087c.j());
        SharedPreferences g8 = StorageHelper.g(context);
        int d8 = StorageHelper.d(context, this.f11088d, "lastSessionId", 0);
        int d9 = StorageHelper.d(context, this.f11088d, "sexe", 0);
        if (d9 > 0) {
            this.f11087c.T(d9 - d8);
        }
        Logger n9 = this.f11088d.n();
        String c9 = this.f11088d.c();
        n9.s(c9, "Last session length: " + this.f11087c.m() + " seconds");
        if (d8 == 0) {
            this.f11087c.P(true);
        }
        StorageHelper.l(g8.edit().putInt(StorageHelper.s(this.f11088d, "lastSessionId"), this.f11087c.j()));
    }

    public void a() {
        if (this.f11085a > 0 && System.currentTimeMillis() - this.f11085a > 1200000) {
            this.f11088d.n().s(this.f11088d.c(), "Session Timed Out");
            c();
            CoreMetaData.L(null);
        }
    }

    public void c() {
        this.f11087c.M(0);
        this.f11087c.I(false);
        if (this.f11087c.A()) {
            this.f11087c.P(false);
        }
        this.f11088d.n().s(this.f11088d.c(), "Session destroyed; Session ID is now 0");
        this.f11087c.c();
        this.f11087c.b();
        this.f11087c.a();
        this.f11087c.d();
    }

    public void d(Context context) {
        if (!this.f11087c.t()) {
            this.f11087c.O(true);
            Validator validator = this.f11090f;
            if (validator != null) {
                validator.l(null);
            }
            b(context);
        }
    }

    public void e(long j8) {
        this.f11085a = j8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        EventDetail r7 = this.f11089e.r("App Launched");
        if (r7 == null) {
            this.f11086b = -1;
        } else {
            this.f11086b = r7.c();
        }
    }
}
