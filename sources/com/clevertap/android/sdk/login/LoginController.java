package com.clevertap.android.sdk.login;

import android.content.Context;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.SessionManager;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.db.DBManager;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import com.clevertap.android.sdk.product_config.CTProductConfigFactory;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LoginController {

    /* renamed from: q  reason: collision with root package name */
    private static final Object f11603q = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticsManager f11605b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseEventQueueManager f11606c;

    /* renamed from: d  reason: collision with root package name */
    private final CTLockManager f11607d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseCallbackManager f11608e;

    /* renamed from: f  reason: collision with root package name */
    private final CleverTapInstanceConfig f11609f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f11610g;

    /* renamed from: h  reason: collision with root package name */
    private final ControllerManager f11611h;

    /* renamed from: i  reason: collision with root package name */
    private final CoreMetaData f11612i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseDatabaseManager f11613j;

    /* renamed from: k  reason: collision with root package name */
    private final DeviceInfo f11614k;

    /* renamed from: l  reason: collision with root package name */
    private final LocalDataStore f11615l;

    /* renamed from: m  reason: collision with root package name */
    private final PushProviders f11616m;

    /* renamed from: n  reason: collision with root package name */
    private final SessionManager f11617n;

    /* renamed from: o  reason: collision with root package name */
    private final ValidationResultStack f11618o;

    /* renamed from: a  reason: collision with root package name */
    private String f11604a = null;

    /* renamed from: p  reason: collision with root package name */
    private String f11619p = null;

    public LoginController(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, ValidationResultStack validationResultStack, BaseEventQueueManager baseEventQueueManager, AnalyticsManager analyticsManager, CoreMetaData coreMetaData, ControllerManager controllerManager, SessionManager sessionManager, LocalDataStore localDataStore, BaseCallbackManager baseCallbackManager, DBManager dBManager, CTLockManager cTLockManager) {
        this.f11609f = cleverTapInstanceConfig;
        this.f11610g = context;
        this.f11614k = deviceInfo;
        this.f11618o = validationResultStack;
        this.f11606c = baseEventQueueManager;
        this.f11605b = analyticsManager;
        this.f11612i = coreMetaData;
        this.f11616m = controllerManager.i();
        this.f11617n = sessionManager;
        this.f11615l = localDataStore;
        this.f11608e = baseCallbackManager;
        this.f11613j = dBManager;
        this.f11611h = controllerManager;
        this.f11607d = cTLockManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        synchronized (this.f11607d.b()) {
            this.f11611h.m(null);
        }
        this.f11611h.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f11609f.p()) {
            this.f11609f.n().f(this.f11609f.c(), "Product Config is not enabled for this instance");
            return;
        }
        if (this.f11611h.f() != null) {
            this.f11611h.f().t();
        }
        this.f11611h.n(CTProductConfigFactory.a(this.f11610g, this.f11614k, this.f11609f, this.f11605b, this.f11612i, this.f11608e));
        this.f11609f.n().s(this.f11609f.c(), "Product Config reset");
    }

    private void a(Map<String, Object> map, String str) {
        if (map == null) {
            return;
        }
        try {
            String x7 = this.f11614k.x();
            if (x7 == null) {
                return;
            }
            boolean z7 = false;
            LoginInfoProvider loginInfoProvider = new LoginInfoProvider(this.f11610g, this.f11609f, this.f11614k);
            IdentityRepo a8 = IdentityRepoFactory.a(this.f11610g, this.f11609f, this.f11614k, this.f11618o);
            for (String str2 : map.keySet()) {
                Object obj = map.get(str2);
                if (a8.a(str2)) {
                    String str3 = null;
                    if (obj != null) {
                        try {
                            str3 = obj.toString();
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                    if (str3 != null && str3.length() > 0) {
                        z7 = true;
                        String e8 = loginInfoProvider.e(str2, str3);
                        this.f11604a = e8;
                        if (e8 != null) {
                            break;
                        }
                    }
                }
            }
            if (!this.f11614k.R() && (!z7 || loginInfoProvider.f())) {
                this.f11609f.n().f(this.f11609f.c(), "onUserLogin: no identifier provided or device is anonymous, pushing on current user profile");
                this.f11605b.H(map);
                return;
            }
            String str4 = this.f11604a;
            if (str4 != null && str4.equals(x7)) {
                Logger n8 = this.f11609f.n();
                String c8 = this.f11609f.c();
                n8.f(c8, "onUserLogin: " + map.toString() + " maps to current device id " + x7 + " pushing on current profile");
                this.f11605b.H(map);
                return;
            }
            String obj2 = map.toString();
            if (v(obj2)) {
                Logger n9 = this.f11609f.n();
                String c9 = this.f11609f.c();
                n9.f(c9, "Already processing onUserLogin for " + obj2);
                return;
            }
            synchronized (f11603q) {
                this.f11619p = obj2;
            }
            Logger n10 = this.f11609f.n();
            String c10 = this.f11609f.c();
            StringBuilder sb = new StringBuilder();
            sb.append("onUserLogin: queuing reset profile for ");
            sb.append(obj2);
            sb.append(" with Cached GUID ");
            String str5 = this.f11604a;
            if (str5 == null) {
                str5 = "NULL";
            }
            sb.append(str5);
            n10.s(c10, sb.toString());
            u(map, this.f11604a, str);
        } catch (Throwable th) {
            this.f11609f.n().t(this.f11609f.c(), "onUserLogin failed", th);
        }
    }

    private boolean v(String str) {
        boolean z7;
        synchronized (f11603q) {
            String str2 = this.f11619p;
            if (str2 != null && str2.equals(str)) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.f11611h.c() != null) {
            this.f11611h.c().a();
        } else {
            this.f11609f.n().s(this.f11609f.c(), "DisplayUnit : Can't reset Display Units, DisplayUnitcontroller is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        CTFeatureFlagsController d8 = this.f11611h.d();
        if (d8 != null && d8.m()) {
            d8.o(this.f11614k.x());
            d8.e();
        }
    }

    public void u(final Map<String, Object> map, final String str, final String str2) {
        CTExecutorFactory.a(this.f11609f).c().d("resetProfile", new Callable<Void>() { // from class: com.clevertap.android.sdk.login.LoginController.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                String str3;
                try {
                    Logger n8 = LoginController.this.f11609f.n();
                    String c8 = LoginController.this.f11609f.c();
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncProfileSwitchUser:[profile ");
                    sb.append(map);
                    sb.append(" with Cached GUID ");
                    if (str != null) {
                        str3 = LoginController.this.f11604a;
                    } else {
                        str3 = "NULL and cleverTapID " + str2;
                    }
                    sb.append(str3);
                    n8.s(c8, sb.toString());
                    LoginController.this.f11612i.N(false);
                    LoginController.this.f11616m.x(false);
                    LoginController.this.f11606c.b(LoginController.this.f11610g, EventGroup.REGULAR);
                    LoginController.this.f11606c.b(LoginController.this.f11610g, EventGroup.PUSH_NOTIFICATION_VIEWED);
                    LoginController.this.f11613j.a(LoginController.this.f11610g);
                    LoginController.this.f11615l.m();
                    CoreMetaData.F(1);
                    LoginController.this.f11617n.c();
                    if (str != null) {
                        LoginController.this.f11614k.j(str);
                        LoginController.this.f11608e.n(str);
                    } else if (LoginController.this.f11609f.i()) {
                        LoginController.this.f11614k.i(str2);
                    } else {
                        LoginController.this.f11614k.h();
                    }
                    LoginController.this.f11608e.n(LoginController.this.f11614k.x());
                    LoginController.this.f11614k.Y();
                    LoginController.this.f11605b.w();
                    if (map != null) {
                        LoginController.this.f11605b.H(map);
                    }
                    LoginController.this.f11616m.x(true);
                    synchronized (LoginController.f11603q) {
                        LoginController.this.f11619p = null;
                    }
                    LoginController.this.A();
                    LoginController.this.z();
                    LoginController.this.B();
                    LoginController.this.x();
                    LoginController.this.y();
                    LoginController.this.f11611h.h().e(LoginController.this.f11614k.x());
                } catch (Throwable th) {
                    LoginController.this.f11609f.n().t(LoginController.this.f11609f.c(), "Reset Profile error", th);
                }
                return null;
            }
        });
    }

    public void w(Map<String, Object> map, String str) {
        if (this.f11609f.i()) {
            if (str == null) {
                Logger.j("CLEVERTAP_USE_CUSTOM_ID has been specified in the AndroidManifest.xml Please call onUserlogin() and pass a custom CleverTap ID");
            }
        } else if (str != null) {
            Logger.j("CLEVERTAP_USE_CUSTOM_ID has not been specified in the AndroidManifest.xml Please call CleverTapAPI.defaultInstance() without a custom CleverTap ID");
        }
        a(map, str);
    }

    public void x() {
        Iterator<ValidationResult> it = this.f11614k.M().iterator();
        while (it.hasNext()) {
            this.f11618o.b(it.next());
        }
    }
}
