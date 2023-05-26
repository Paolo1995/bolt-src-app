package com.clevertap.android.sdk.events;

import android.content.Context;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.FailureFlushListener;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.SessionManager;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.login.IdentityRepo;
import com.clevertap.android.sdk.login.IdentityRepoFactory;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.network.BaseNetworkManager;
import com.clevertap.android.sdk.network.NetworkManager;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.MainLooperHandler;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.google.android.gms.common.Scopes;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class EventQueueManager extends BaseEventQueueManager implements FailureFlushListener {

    /* renamed from: b  reason: collision with root package name */
    private final BaseDatabaseManager f11172b;

    /* renamed from: c  reason: collision with root package name */
    private final CoreMetaData f11173c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f11174d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f11175e;

    /* renamed from: f  reason: collision with root package name */
    private final CTLockManager f11176f;

    /* renamed from: g  reason: collision with root package name */
    private final DeviceInfo f11177g;

    /* renamed from: h  reason: collision with root package name */
    private final EventMediator f11178h;

    /* renamed from: i  reason: collision with root package name */
    private final LocalDataStore f11179i;

    /* renamed from: j  reason: collision with root package name */
    private final Logger f11180j;

    /* renamed from: k  reason: collision with root package name */
    private LoginInfoProvider f11181k;

    /* renamed from: l  reason: collision with root package name */
    private final MainLooperHandler f11182l;

    /* renamed from: m  reason: collision with root package name */
    private final BaseNetworkManager f11183m;

    /* renamed from: n  reason: collision with root package name */
    private final SessionManager f11184n;

    /* renamed from: o  reason: collision with root package name */
    private final ValidationResultStack f11185o;

    /* renamed from: a  reason: collision with root package name */
    private Runnable f11171a = null;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f11186p = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.clevertap.android.sdk.events.EventQueueManager$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements Callable<Void> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONObject f11194f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f11195g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Context f11196h;

        AnonymousClass4(JSONObject jSONObject, int i8, Context context) {
            this.f11194f = jSONObject;
            this.f11195g = i8;
            this.f11196h = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            if (EventQueueManager.this.f11178h.c(this.f11194f, this.f11195g)) {
                return null;
            }
            if (EventQueueManager.this.f11178h.b(this.f11194f, this.f11195g)) {
                Logger n8 = EventQueueManager.this.f11174d.n();
                String c8 = EventQueueManager.this.f11174d.c();
                n8.f(c8, "App Launched not yet processed, re-queuing event " + this.f11194f + "after 2s");
                EventQueueManager.this.f11182l.postDelayed(new Runnable() { // from class: com.clevertap.android.sdk.events.EventQueueManager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CTExecutorFactory.a(EventQueueManager.this.f11174d).c().d("queueEventWithDelay", new Callable<Void>() { // from class: com.clevertap.android.sdk.events.EventQueueManager.4.1.1
                            @Override // java.util.concurrent.Callable
                            /* renamed from: a */
                            public Void call() {
                                EventQueueManager.this.f11184n.d(AnonymousClass4.this.f11196h);
                                EventQueueManager.this.d();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                EventQueueManager.this.l(anonymousClass4.f11196h, anonymousClass4.f11194f, anonymousClass4.f11195g);
                                return null;
                            }
                        });
                    }
                }, 2000L);
            } else {
                int i8 = this.f11195g;
                if (i8 == 7) {
                    EventQueueManager.this.l(this.f11196h, this.f11194f, i8);
                } else {
                    EventQueueManager.this.f11184n.d(this.f11196h);
                    EventQueueManager.this.d();
                    EventQueueManager.this.l(this.f11196h, this.f11194f, this.f11195g);
                }
            }
            return null;
        }
    }

    public EventQueueManager(BaseDatabaseManager baseDatabaseManager, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, EventMediator eventMediator, SessionManager sessionManager, BaseCallbackManager baseCallbackManager, MainLooperHandler mainLooperHandler, DeviceInfo deviceInfo, ValidationResultStack validationResultStack, NetworkManager networkManager, CoreMetaData coreMetaData, CTLockManager cTLockManager, LocalDataStore localDataStore) {
        this.f11172b = baseDatabaseManager;
        this.f11175e = context;
        this.f11174d = cleverTapInstanceConfig;
        this.f11178h = eventMediator;
        this.f11184n = sessionManager;
        this.f11182l = mainLooperHandler;
        this.f11177g = deviceInfo;
        this.f11185o = validationResultStack;
        this.f11183m = networkManager;
        this.f11179i = localDataStore;
        this.f11180j = cleverTapInstanceConfig.n();
        this.f11173c = coreMetaData;
        this.f11176f = cTLockManager;
        baseCallbackManager.o(this);
    }

    private void m(JSONObject jSONObject, Context context) {
        try {
            jSONObject.put("mc", Utils.p());
        } catch (Throwable unused) {
        }
        try {
            jSONObject.put("nt", Utils.m(context));
        } catch (Throwable unused2) {
        }
    }

    private void n(Context context, JSONObject jSONObject) {
        try {
            if ("event".equals(jSONObject.getString("type")) && "App Launched".equals(jSONObject.getString("evtName"))) {
                jSONObject.put("pai", context.getPackageName());
            }
        } catch (Throwable unused) {
        }
    }

    private String p() {
        return this.f11177g.x();
    }

    private void u(final Context context) {
        if (this.f11186p == null) {
            this.f11186p = new Runnable() { // from class: com.clevertap.android.sdk.events.EventQueueManager.6
                @Override // java.lang.Runnable
                public void run() {
                    EventQueueManager.this.f11174d.n().s(EventQueueManager.this.f11174d.c(), "Pushing Notification Viewed event onto queue flush async");
                    EventQueueManager.this.o(context, EventGroup.PUSH_NOTIFICATION_VIEWED);
                }
            };
        }
        this.f11182l.removeCallbacks(this.f11186p);
        this.f11182l.post(this.f11186p);
    }

    private void x(Context context, JSONObject jSONObject, int i8) {
        if (i8 == 4) {
            this.f11179i.C(context, jSONObject, i8);
        }
    }

    @Override // com.clevertap.android.sdk.FailureFlushListener
    public void a(Context context) {
        v(context);
    }

    @Override // com.clevertap.android.sdk.events.BaseEventQueueManager
    public void b(final Context context, final EventGroup eventGroup) {
        if (!NetworkManager.x(context)) {
            this.f11180j.s(this.f11174d.c(), "Network connectivity unavailable. Will retry later");
        } else if (this.f11173c.D()) {
            this.f11180j.f(this.f11174d.c(), "CleverTap Instance has been set to offline, won't send events queue");
        } else if (this.f11183m.d(eventGroup)) {
            this.f11183m.c(eventGroup, new Runnable() { // from class: com.clevertap.android.sdk.events.EventQueueManager.2
                @Override // java.lang.Runnable
                public void run() {
                    EventQueueManager.this.f11183m.a(context, eventGroup);
                }
            });
        } else {
            this.f11180j.s(this.f11174d.c(), "Pushing Notification Viewed event onto queue DB flush");
            this.f11183m.a(context, eventGroup);
        }
    }

    @Override // com.clevertap.android.sdk.events.BaseEventQueueManager
    public void c(JSONObject jSONObject) {
        try {
            String p8 = p();
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null && jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                IdentityRepo a8 = IdentityRepoFactory.a(this.f11175e, this.f11174d, this.f11177g, this.f11185o);
                w(new LoginInfoProvider(this.f11175e, this.f11174d, this.f11177g));
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = null;
                    try {
                        try {
                            obj = jSONObject.getJSONObject(next);
                        } catch (JSONException unused) {
                        }
                    } catch (Throwable unused2) {
                        obj = jSONObject.get(next);
                    }
                    if (obj != null) {
                        jSONObject2.put(next, obj);
                        if (a8.a(next)) {
                            try {
                                q().a(p8, next, obj.toString());
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
            }
            try {
                String r7 = this.f11177g.r();
                if (r7 != null && !r7.equals("")) {
                    jSONObject2.put("Carrier", r7);
                }
                String u7 = this.f11177g.u();
                if (u7 != null && !u7.equals("")) {
                    jSONObject2.put("cc", u7);
                }
                jSONObject2.put("tz", TimeZone.getDefault().getID());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Scopes.PROFILE, jSONObject2);
                e(this.f11175e, jSONObject3, 3);
            } catch (JSONException unused4) {
                this.f11174d.n().s(this.f11174d.c(), "FATAL: Creating basic profile update event failed!");
            }
        } catch (Throwable th) {
            this.f11174d.n().t(this.f11174d.c(), "Basic profile sync", th);
        }
    }

    @Override // com.clevertap.android.sdk.events.BaseEventQueueManager
    public void d() {
        if (!this.f11173c.t()) {
            CTExecutorFactory.a(this.f11174d).c().d("CleverTapAPI#pushInitialEventsAsync", new Callable<Void>() { // from class: com.clevertap.android.sdk.events.EventQueueManager.3
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    try {
                        EventQueueManager.this.f11174d.n().s(EventQueueManager.this.f11174d.c(), "Queuing daily events");
                        EventQueueManager.this.c(null);
                    } catch (Throwable th) {
                        EventQueueManager.this.f11174d.n().t(EventQueueManager.this.f11174d.c(), "Daily profile sync failed", th);
                    }
                    return null;
                }
            });
        }
    }

    @Override // com.clevertap.android.sdk.events.BaseEventQueueManager
    public Future<?> e(Context context, JSONObject jSONObject, int i8) {
        return CTExecutorFactory.a(this.f11174d).c().j("queueEvent", new AnonymousClass4(jSONObject, i8, context));
    }

    public void l(Context context, JSONObject jSONObject, int i8) {
        if (i8 == 6) {
            this.f11174d.n().s(this.f11174d.c(), "Pushing Notification Viewed event onto separate queue");
            t(context, jSONObject);
            return;
        }
        s(context, jSONObject, i8);
    }

    public void o(final Context context, final EventGroup eventGroup) {
        CTExecutorFactory.a(this.f11174d).c().d("CommsManager#flushQueueAsync", new Callable<Void>() { // from class: com.clevertap.android.sdk.events.EventQueueManager.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                if (eventGroup == EventGroup.PUSH_NOTIFICATION_VIEWED) {
                    EventQueueManager.this.f11180j.s(EventQueueManager.this.f11174d.c(), "Pushing Notification Viewed event onto queue flush sync");
                } else {
                    EventQueueManager.this.f11180j.s(EventQueueManager.this.f11174d.c(), "Pushing event onto queue flush sync");
                }
                EventQueueManager.this.b(context, eventGroup);
                return null;
            }
        });
    }

    public LoginInfoProvider q() {
        return this.f11181k;
    }

    public int r() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public void s(Context context, JSONObject jSONObject, int i8) {
        String str;
        synchronized (this.f11176f.a()) {
            try {
                if (CoreMetaData.e() == 0) {
                    CoreMetaData.F(1);
                }
                if (i8 == 1) {
                    str = "page";
                } else if (i8 == 2) {
                    str = "ping";
                    m(jSONObject, context);
                    if (jSONObject.has("bk")) {
                        this.f11173c.J(true);
                        jSONObject.remove("bk");
                    }
                    if (this.f11173c.C()) {
                        jSONObject.put("gf", true);
                        this.f11173c.U(false);
                        jSONObject.put("gfSDKVersion", this.f11173c.k());
                        this.f11173c.Q(0);
                    }
                } else {
                    str = i8 == 3 ? Scopes.PROFILE : i8 == 5 ? "data" : "event";
                }
                String q8 = this.f11173c.q();
                if (q8 != null) {
                    jSONObject.put("n", q8);
                }
                jSONObject.put("s", this.f11173c.j());
                jSONObject.put("pg", CoreMetaData.e());
                jSONObject.put("type", str);
                jSONObject.put("ep", r());
                jSONObject.put("f", this.f11173c.A());
                jSONObject.put("lsl", this.f11173c.m());
                n(context, jSONObject);
                ValidationResult a8 = this.f11185o.a();
                if (a8 != null) {
                    jSONObject.put("wzrk_error", CTJsonConverter.c(a8));
                }
                this.f11179i.K(jSONObject);
                this.f11172b.d(context, jSONObject, i8);
                x(context, jSONObject, i8);
                v(context);
            }
        }
    }

    public void t(Context context, JSONObject jSONObject) {
        synchronized (this.f11176f.a()) {
            try {
                jSONObject.put("s", this.f11173c.j());
                jSONObject.put("type", "event");
                jSONObject.put("ep", r());
                ValidationResult a8 = this.f11185o.a();
                if (a8 != null) {
                    jSONObject.put("wzrk_error", CTJsonConverter.c(a8));
                }
                this.f11174d.n().s(this.f11174d.c(), "Pushing Notification Viewed event onto DB");
                this.f11172b.e(context, jSONObject);
                this.f11174d.n().s(this.f11174d.c(), "Pushing Notification Viewed event onto queue flush");
                u(context);
            }
        }
    }

    public void v(final Context context) {
        if (this.f11171a == null) {
            this.f11171a = new Runnable() { // from class: com.clevertap.android.sdk.events.EventQueueManager.5
                @Override // java.lang.Runnable
                public void run() {
                    EventQueueManager.this.o(context, EventGroup.REGULAR);
                    EventQueueManager.this.o(context, EventGroup.PUSH_NOTIFICATION_VIEWED);
                }
            };
        }
        this.f11182l.removeCallbacks(this.f11171a);
        this.f11182l.postDelayed(this.f11171a, this.f11183m.b());
        this.f11180j.s(this.f11174d.c(), "Scheduling delayed queue flush on main event loop");
    }

    public void w(LoginInfoProvider loginInfoProvider) {
        this.f11181k = loginInfoProvider;
    }
}
