package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.mixpanel.android.R$animator;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.DecideMessages;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.InstallReferrerPlay;
import com.mixpanel.android.mpmetrics.SharedPreferencesLoader;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import com.mixpanel.android.util.ActivityImageUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.TrackingDebug;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import com.mixpanel.android.viewcrawler.ViewCrawler;
import com.sinch.android.rtc.internal.client.DeviceInformation;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MixpanelAPI {

    /* renamed from: q  reason: collision with root package name */
    private static final Map<String, Map<Context, MixpanelAPI>> f19229q = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    private static final SharedPreferencesLoader f19230r = new SharedPreferencesLoader();

    /* renamed from: s  reason: collision with root package name */
    private static final Tweaks f19231s = new Tweaks();

    /* renamed from: t  reason: collision with root package name */
    private static Future<SharedPreferences> f19232t;

    /* renamed from: a  reason: collision with root package name */
    private final Context f19233a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticsMessages f19234b;

    /* renamed from: c  reason: collision with root package name */
    private final MPConfig f19235c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19236d;

    /* renamed from: e  reason: collision with root package name */
    private final PeopleImpl f19237e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Object> f19238f;

    /* renamed from: g  reason: collision with root package name */
    private final UpdatesFromMixpanel f19239g;

    /* renamed from: h  reason: collision with root package name */
    private final PersistentIdentity f19240h;

    /* renamed from: i  reason: collision with root package name */
    private final UpdatesListener f19241i;

    /* renamed from: j  reason: collision with root package name */
    private final TrackingDebug f19242j;

    /* renamed from: k  reason: collision with root package name */
    private final ConnectIntegrations f19243k;

    /* renamed from: l  reason: collision with root package name */
    private final DecideMessages f19244l;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, String> f19245m;

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, Long> f19246n;

    /* renamed from: o  reason: collision with root package name */
    private MixpanelActivityLifecycleCallbacks f19247o;

    /* renamed from: p  reason: collision with root package name */
    private final SessionMetadata f19248p;

    /* renamed from: com.mixpanel.android.mpmetrics.MixpanelAPI$6  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19252a;

        static {
            int[] iArr = new int[InAppNotification.Type.values().length];
            f19252a = iArr;
            try {
                iArr[InAppNotification.Type.MINI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19252a[InAppNotification.Type.TAKEOVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface InstanceProcessor {
        void a(MixpanelAPI mixpanelAPI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class NoOpUpdatesFromMixpanel implements UpdatesFromMixpanel {

        /* renamed from: a  reason: collision with root package name */
        private final Tweaks f19253a;

        public NoOpUpdatesFromMixpanel(Tweaks tweaks) {
            this.f19253a = tweaks;
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public void a(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public void b() {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public void d(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public void f(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public void g() {
        }
    }

    /* loaded from: classes3.dex */
    public interface People {
        void a(InAppNotification inAppNotification, Activity activity);

        People b(String str);

        boolean c();

        void d(String str, JSONObject jSONObject);

        void e(String str);

        void f();

        void g(String str, Object obj);

        void h();

        void i(String str, InAppNotification inAppNotification, JSONObject jSONObject);

        void j(Activity activity);

        void k(String str, Object obj);

        void l(String str);

        void m(String str, double d8);

        void n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class PeopleImpl implements People {
        private PeopleImpl() {
        }

        private void s(final InAppNotification inAppNotification, final Activity activity) {
            activity.runOnUiThread(new Runnable() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl.2
                @Override // java.lang.Runnable
                @TargetApi(16)
                public void run() {
                    ReentrantLock c8 = UpdateDisplayState.c();
                    c8.lock();
                    try {
                        if (UpdateDisplayState.e()) {
                            MPLog.i("MixpanelAPI.API", "DisplayState is locked, will not show notifications.");
                            return;
                        }
                        InAppNotification inAppNotification2 = inAppNotification;
                        if (inAppNotification2 == null) {
                            inAppNotification2 = PeopleImpl.this.p();
                        }
                        if (inAppNotification2 == null) {
                            MPLog.i("MixpanelAPI.API", "No notification available, will not show.");
                            return;
                        }
                        InAppNotification.Type n8 = inAppNotification2.n();
                        if (n8 == InAppNotification.Type.TAKEOVER && !ConfigurationChecker.d(activity.getApplicationContext())) {
                            MPLog.i("MixpanelAPI.API", "Application is not configured to show takeover notifications, none will be shown.");
                            return;
                        }
                        int f8 = UpdateDisplayState.f(new UpdateDisplayState.DisplayState.InAppNotificationState(inAppNotification2, ActivityImageUtils.b(activity)), PeopleImpl.this.o(), MixpanelAPI.this.f19236d);
                        if (f8 <= 0) {
                            MPLog.c("MixpanelAPI.API", "DisplayState Lock in inconsistent state! Please report this issue to Mixpanel");
                            return;
                        }
                        int i8 = AnonymousClass6.f19252a[n8.ordinal()];
                        if (i8 != 1) {
                            if (i8 != 2) {
                                MPLog.c("MixpanelAPI.API", "Unrecognized notification type " + n8 + " can't be shown");
                            } else {
                                MPLog.i("MixpanelAPI.API", "Sending intent for takeover notification.");
                                Intent intent = new Intent(activity.getApplicationContext(), TakeoverInAppActivity.class);
                                intent.addFlags(268435456);
                                intent.addFlags(131072);
                                intent.putExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", f8);
                                activity.startActivity(intent);
                            }
                        } else {
                            UpdateDisplayState a8 = UpdateDisplayState.a(f8);
                            if (a8 == null) {
                                MPLog.i("MixpanelAPI.API", "Notification's display proposal was already consumed, no notification will be shown.");
                                return;
                            }
                            InAppFragment inAppFragment = new InAppFragment();
                            inAppFragment.i(MixpanelAPI.this, f8, (UpdateDisplayState.DisplayState.InAppNotificationState) a8.b());
                            inAppFragment.setRetainInstance(true);
                            MPLog.i("MixpanelAPI.API", "Attempting to show mini notification.");
                            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
                            beginTransaction.setCustomAnimations(0, R$animator.com_mixpanel_android_slide_down);
                            beginTransaction.add(16908290, inAppFragment);
                            try {
                                beginTransaction.commit();
                            } catch (IllegalStateException unused) {
                                MPLog.i("MixpanelAPI.API", "Unable to show notification.");
                                MixpanelAPI.this.f19244l.h(inAppNotification2);
                            }
                        }
                        if (!MixpanelAPI.this.f19235c.E()) {
                            PeopleImpl.this.u(inAppNotification2);
                        }
                    } finally {
                        c8.unlock();
                    }
                }
            });
        }

        private JSONObject t(String str, Object obj) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            String o8 = o();
            String v7 = MixpanelAPI.this.v();
            jSONObject.put(str, obj);
            jSONObject.put("$token", MixpanelAPI.this.f19236d);
            jSONObject.put("$time", System.currentTimeMillis());
            jSONObject.put("$had_persisted_distinct_id", MixpanelAPI.this.f19240h.l());
            if (v7 != null) {
                jSONObject.put("$device_id", v7);
            }
            if (o8 != null) {
                jSONObject.put("$distinct_id", o8);
                jSONObject.put("$user_id", o8);
            }
            jSONObject.put("$mp_metadata", MixpanelAPI.this.f19248p.b());
            return jSONObject;
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void a(InAppNotification inAppNotification, Activity activity) {
            if (inAppNotification != null) {
                s(inAppNotification, activity);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public People b(final String str) {
            if (str == null) {
                return null;
            }
            return new PeopleImpl() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl, com.mixpanel.android.mpmetrics.MixpanelAPI.People
                public void l(String str2) {
                    throw new RuntimeException("This MixpanelPeople object has a fixed, constant distinctId");
                }

                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl
                public String o() {
                    return str;
                }
            };
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public boolean c() {
            if (o() != null) {
                return true;
            }
            return false;
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void d(String str, JSONObject jSONObject) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(str, jSONObject);
                MixpanelAPI.this.N(t("$merge", jSONObject2));
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.API", "Exception merging a property", e8);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void e(String str) {
            synchronized (MixpanelAPI.this.f19240h) {
                MPLog.a("MixpanelAPI.API", "Setting push token on people profile: " + str);
                MixpanelAPI.this.f19240h.L(str);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                v("$android_devices", jSONArray);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void f() {
            MixpanelAPI.this.f19239g.d(MixpanelAPI.this.f19244l.f());
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void g(String str, Object obj) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            try {
                r(new JSONObject().put(str, obj));
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.API", "set", e8);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void h() {
            w("$transactions");
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void i(String str, InAppNotification inAppNotification, JSONObject jSONObject) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            JSONObject d8 = inAppNotification.d();
            if (jSONObject != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        d8.put(next, jSONObject.get(next));
                    }
                } catch (JSONException e8) {
                    MPLog.d("MixpanelAPI.API", "Exception merging provided properties with notification properties", e8);
                }
            }
            MixpanelAPI.this.V(str, d8);
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void j(Activity activity) {
            s(null, activity);
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void k(String str, Object obj) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                MixpanelAPI.this.N(t("$append", jSONObject));
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.API", "Exception appending a property", e8);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void l(String str) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            if (str != null) {
                synchronized (MixpanelAPI.this.f19240h) {
                    MixpanelAPI.this.f19240h.K(str);
                    MixpanelAPI.this.f19244l.j(str);
                }
                MixpanelAPI.this.M(str);
                return;
            }
            MPLog.c("MixpanelAPI.API", "Can't identify with null distinct_id.");
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void m(String str, double d8) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(str, Double.valueOf(d8));
            q(hashMap);
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void n() {
            try {
                MixpanelAPI.this.N(t("$delete", JSONObject.NULL));
            } catch (JSONException unused) {
                MPLog.c("MixpanelAPI.API", "Exception deleting a user");
            }
        }

        public String o() {
            return MixpanelAPI.this.f19240h.n();
        }

        public InAppNotification p() {
            return MixpanelAPI.this.f19244l.d(MixpanelAPI.this.f19235c.E());
        }

        public void q(Map<String, ? extends Number> map) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            try {
                MixpanelAPI.this.N(t("$add", new JSONObject(map)));
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.API", "Exception incrementing properties", e8);
            }
        }

        public void r(JSONObject jSONObject) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(MixpanelAPI.this.f19245m);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                MixpanelAPI.this.N(t("$set", jSONObject2));
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.API", "Exception setting people properties", e8);
            }
        }

        public void u(InAppNotification inAppNotification) {
            if (inAppNotification == null) {
                return;
            }
            MixpanelAPI.this.f19240h.E(Integer.valueOf(inAppNotification.f()));
            if (MixpanelAPI.this.F()) {
                return;
            }
            i("$campaign_delivery", inAppNotification, null);
            People b8 = MixpanelAPI.this.C().b(o());
            if (b8 != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                JSONObject d8 = inAppNotification.d();
                try {
                    d8.put("$time", simpleDateFormat.format(new Date()));
                } catch (JSONException e8) {
                    MPLog.d("MixpanelAPI.API", "Exception trying to track an in-app notification seen", e8);
                }
                b8.k("$campaigns", Integer.valueOf(inAppNotification.f()));
                b8.k("$notifications", d8);
                return;
            }
            MPLog.c("MixpanelAPI.API", "No identity found. Make sure to call getPeople().identify() before showing in-app notifications.");
        }

        public void v(String str, JSONArray jSONArray) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, jSONArray);
                MixpanelAPI.this.N(t("$union", jSONObject));
            } catch (JSONException unused) {
                MPLog.c("MixpanelAPI.API", "Exception unioning a property");
            }
        }

        public void w(String str) {
            if (MixpanelAPI.this.F()) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                MixpanelAPI.this.N(t("$unset", jSONArray));
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.API", "Exception unsetting a property", e8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class SupportedUpdatesListener implements UpdatesListener, Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final Set<OnMixpanelUpdatesReceivedListener> f19261f;

        /* renamed from: g  reason: collision with root package name */
        private final Executor f19262g;

        private SupportedUpdatesListener() {
            this.f19261f = Collections.newSetFromMap(new ConcurrentHashMap());
            this.f19262g = Executors.newSingleThreadExecutor();
        }

        @Override // com.mixpanel.android.mpmetrics.DecideMessages.OnNewResultsListener
        public void a() {
            this.f19262g.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            for (OnMixpanelUpdatesReceivedListener onMixpanelUpdatesReceivedListener : this.f19261f) {
                onMixpanelUpdatesReceivedListener.a();
            }
            MixpanelAPI.this.f19243k.e(MixpanelAPI.this.f19244l.b());
        }
    }

    /* loaded from: classes3.dex */
    private interface UpdatesListener extends DecideMessages.OnNewResultsListener {
    }

    MixpanelAPI(Context context, Future<SharedPreferences> future, String str, boolean z7, JSONObject jSONObject) {
        this(context, future, str, MPConfig.s(context), z7, jSONObject);
    }

    public static MixpanelAPI A(Context context, String str, boolean z7, JSONObject jSONObject) {
        MixpanelAPI mixpanelAPI;
        if (str == null || context == null) {
            return null;
        }
        Map<String, Map<Context, MixpanelAPI>> map = f19229q;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (f19232t == null) {
                f19232t = f19230r.a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
            }
            Map<Context, MixpanelAPI> map2 = map.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(str, map2);
            }
            mixpanelAPI = map2.get(applicationContext);
            if (mixpanelAPI == null && ConfigurationChecker.a(applicationContext)) {
                MixpanelAPI mixpanelAPI2 = new MixpanelAPI(applicationContext, f19232t, str, z7, jSONObject);
                O(context, mixpanelAPI2);
                map2.put(applicationContext, mixpanelAPI2);
                if (ConfigurationChecker.c(applicationContext)) {
                    try {
                        MixpanelFCMMessagingService.c();
                    } catch (Exception e8) {
                        MPLog.d("MixpanelAPI.API", "Push notification could not be initialized", e8);
                    }
                }
                mixpanelAPI = mixpanelAPI2;
            }
            n(context);
        }
        return mixpanelAPI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MixpanelAPI B(Context context, String str) {
        try {
            String optString = new JSONObject(str).optString("token");
            if (optString == null) {
                return null;
            }
            return z(context, optString);
        } catch (JSONException unused) {
            return null;
        }
    }

    private void H(String str, boolean z7) {
        if (F()) {
            return;
        }
        if (str == null) {
            MPLog.c("MixpanelAPI.API", "Can't identify with null distinct_id.");
            return;
        }
        synchronized (this.f19240h) {
            String j8 = this.f19240h.j();
            this.f19240h.F(j8);
            this.f19240h.G(str);
            if (z7) {
                this.f19240h.x();
            }
            String n8 = this.f19240h.n();
            if (n8 == null) {
                n8 = this.f19240h.j();
            }
            this.f19244l.j(n8);
            if (!str.equals(j8)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$anon_distinct_id", j8);
                    V("$identify", jSONObject);
                } catch (JSONException unused) {
                    MPLog.c("MixpanelAPI.API", "Could not track $identify event");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str) {
        this.f19234b.p(new AnalyticsMessages.PushAnonymousPeopleDescription(str, this.f19236d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(JSONObject jSONObject) {
        if (F()) {
            return;
        }
        this.f19234b.n(new AnalyticsMessages.PeopleDescription(jSONObject, this.f19236d));
    }

    private static void O(Context context, MixpanelAPI mixpanelAPI) {
        try {
            int i8 = LocalBroadcastManager.f6858b;
            LocalBroadcastManager.class.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(LocalBroadcastManager.class.getMethod("getInstance", Context.class).invoke(null, context), new BroadcastReceiver() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.5
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    JSONObject jSONObject = new JSONObject();
                    Bundle bundleExtra = intent.getBundleExtra("event_args");
                    if (bundleExtra != null) {
                        for (String str : bundleExtra.keySet()) {
                            try {
                                jSONObject.put(str, bundleExtra.get(str));
                            } catch (JSONException e8) {
                                MPLog.d("MixpanelAPI.AL", "failed to add key \"" + str + "\" to properties for tracking bolts event", e8);
                            }
                        }
                    }
                    MixpanelAPI mixpanelAPI2 = MixpanelAPI.this;
                    mixpanelAPI2.V("$" + intent.getStringExtra("event_name"), jSONObject);
                }
            }, new IntentFilter("com.parse.bolts.measurement_event"));
        } catch (ClassNotFoundException e8) {
            MPLog.a("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + e8.getMessage());
        } catch (IllegalAccessException e9) {
            MPLog.a("MixpanelAPI.AL", "App Links tracking will not be enabled due to this exception: " + e9.getMessage());
        } catch (NoSuchMethodException e10) {
            MPLog.a("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + e10.getMessage());
        } catch (InvocationTargetException e11) {
            MPLog.b("MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void X(Context context, Integer num, Integer num2, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject2.optString("token") == null) {
                MPLog.c("MixpanelAPI.API", "\"token\" not found in mp payload, not tracking event: \"" + str3 + "\"");
                return;
            }
            jSONObject2.remove("token");
            if (jSONObject2.optString("distinct_id") == null) {
                MPLog.c("MixpanelAPI.API", "\"distinct_id\" not found in mp payload, not tracking event: \"" + str3 + "\"");
                return;
            }
            jSONObject2.remove("distinct_id");
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                jSONObject2.put("message_id", num2);
                jSONObject2.put("campaign_id", num);
                jSONObject2.put("$android_notification_id", str);
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.API", "Error setting tracking JSON properties.", e8);
            }
            MixpanelAPI B = B(context, str2);
            if (B == null) {
                MPLog.c("MixpanelAPI.API", "Got null instance, not tracking \"" + str3 + "\"");
                return;
            }
            B.V(str3, jSONObject2);
            B.t();
        } catch (JSONException e9) {
            MPLog.d("MixpanelAPI.API", "Exception parsing mp payload from intent extras, not tracking event: \"" + str3 + "\"", e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Y(Context context, Intent intent, String str) {
        Z(context, intent, str, new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Z(Context context, Intent intent, String str, JSONObject jSONObject) {
        if (intent.hasExtra("mp") && intent.hasExtra("mp_campaign_id") && intent.hasExtra("mp_message_id")) {
            String stringExtra = intent.getStringExtra("mp_message_id");
            String stringExtra2 = intent.getStringExtra("mp_campaign_id");
            X(context, Integer.valueOf(stringExtra2), Integer.valueOf(stringExtra), intent.getStringExtra("mp_canonical_notification_id"), intent.getStringExtra("mp"), str, jSONObject);
            return;
        }
        MPLog.c("MixpanelAPI.API", "Intent is missing Mixpanel notification metadata, not tracking event: \"" + str + "\"");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(InstanceProcessor instanceProcessor) {
        Map<String, Map<Context, MixpanelAPI>> map = f19229q;
        synchronized (map) {
            for (Map<Context, MixpanelAPI> map2 : map.values()) {
                for (MixpanelAPI mixpanelAPI : map2.values()) {
                    instanceProcessor.a(mixpanelAPI);
                }
            }
        }
    }

    private static void n(Context context) {
        if (context instanceof Activity) {
            try {
                Class.forName("bolts.AppLinks").getMethod("getTargetUrlFromInboundIntent", Context.class, Intent.class).invoke(null, context, ((Activity) context).getIntent());
                return;
            } catch (ClassNotFoundException e8) {
                MPLog.a("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e8.getMessage());
                return;
            } catch (IllegalAccessException e9) {
                MPLog.a("MixpanelAPI.AL", "Unable to detect inbound App Links: " + e9.getMessage());
                return;
            } catch (NoSuchMethodException e10) {
                MPLog.a("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e10.getMessage());
                return;
            } catch (InvocationTargetException e11) {
                MPLog.b("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", e11);
                return;
            }
        }
        MPLog.a("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
    }

    public static MixpanelAPI z(Context context, String str) {
        return A(context, str, false, null);
    }

    public People C() {
        return this.f19237e;
    }

    PersistentIdentity D(Context context, Future<SharedPreferences> future, String str) {
        SharedPreferencesLoader.OnPrefsLoadedListener onPrefsLoadedListener = new SharedPreferencesLoader.OnPrefsLoadedListener() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.4
            @Override // com.mixpanel.android.mpmetrics.SharedPreferencesLoader.OnPrefsLoadedListener
            public void a(SharedPreferences sharedPreferences) {
                String o8 = PersistentIdentity.o(sharedPreferences);
                if (o8 != null) {
                    MixpanelAPI.this.M(o8);
                }
            }
        };
        SharedPreferencesLoader sharedPreferencesLoader = f19230r;
        return new PersistentIdentity(future, sharedPreferencesLoader.a(context, "com.mixpanel.android.mpmetrics.MixpanelAPI_" + str, onPrefsLoadedListener), sharedPreferencesLoader.a(context, "com.mixpanel.android.mpmetrics.MixpanelAPI.TimeEvents_" + str, null), sharedPreferencesLoader.a(context, "com.mixpanel.android.mpmetrics.Mixpanel", null));
    }

    protected String E() {
        return this.f19240h.k();
    }

    public boolean F() {
        return this.f19240h.m(this.f19236d);
    }

    public void G(String str) {
        H(str, true);
    }

    public boolean I() {
        MixpanelActivityLifecycleCallbacks mixpanelActivityLifecycleCallbacks = this.f19247o;
        if (mixpanelActivityLifecycleCallbacks != null) {
            return mixpanelActivityLifecycleCallbacks.h();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        if (this.f19235c.o()) {
            s();
        }
        this.f19239g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        this.f19248p.d();
    }

    public void L() {
        u().e(new AnalyticsMessages.MixpanelDescription(this.f19236d));
        if (C().c()) {
            C().n();
            C().h();
        }
        this.f19240h.f();
        synchronized (this.f19246n) {
            this.f19246n.clear();
            this.f19240h.h();
        }
        this.f19240h.g();
        this.f19240h.J(true, this.f19236d);
    }

    @TargetApi(14)
    void P() {
        if (this.f19233a.getApplicationContext() instanceof Application) {
            MixpanelActivityLifecycleCallbacks mixpanelActivityLifecycleCallbacks = new MixpanelActivityLifecycleCallbacks(this, this.f19235c);
            this.f19247o = mixpanelActivityLifecycleCallbacks;
            ((Application) this.f19233a.getApplicationContext()).registerActivityLifecycleCallbacks(mixpanelActivityLifecycleCallbacks);
            return;
        }
        MPLog.e("MixpanelAPI.API", "Context is not an Application, Mixpanel will not automatically show in-app notifications or A/B test experiments. We won't be able to automatically flush on an app background.");
    }

    public void Q(JSONObject jSONObject) {
        if (F()) {
            return;
        }
        this.f19240h.C(jSONObject);
    }

    public void R() {
        this.f19240h.f();
        u().c(new AnalyticsMessages.MixpanelDescription(this.f19236d));
        H(y(), false);
        this.f19243k.b();
        this.f19239g.f(new JSONArray());
        this.f19239g.b();
        s();
    }

    boolean S() {
        return !this.f19235c.e();
    }

    public void T(String str) {
        if (F()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f19246n) {
            this.f19246n.put(str, Long.valueOf(currentTimeMillis));
            this.f19240h.e(str, Long.valueOf(currentTimeMillis));
        }
    }

    public void U(String str) {
        if (F()) {
            return;
        }
        V(str, null);
    }

    public void V(String str, JSONObject jSONObject) {
        if (F()) {
            return;
        }
        W(str, jSONObject, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(String str, JSONObject jSONObject, boolean z7) {
        Long l8;
        if (!F()) {
            if (!z7 || this.f19244l.k()) {
                synchronized (this.f19246n) {
                    l8 = this.f19246n.get(str);
                    this.f19246n.remove(str);
                    this.f19240h.D(str);
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : this.f19240h.p().entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    this.f19240h.d(jSONObject2);
                    double currentTimeMillis = System.currentTimeMillis() / 1000.0d;
                    String y7 = y();
                    String v7 = v();
                    String E = E();
                    jSONObject2.put("time", (long) currentTimeMillis);
                    jSONObject2.put("distinct_id", y7);
                    jSONObject2.put("$had_persisted_distinct_id", this.f19240h.l());
                    if (v7 != null) {
                        jSONObject2.put("$device_id", v7);
                    }
                    if (E != null) {
                        jSONObject2.put("$user_id", E);
                    }
                    if (l8 != null) {
                        jSONObject2.put("$duration", currentTimeMillis - (l8.longValue() / 1000.0d));
                    }
                    if (jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!jSONObject.isNull(next)) {
                                jSONObject2.put(next, jSONObject.get(next));
                            }
                        }
                    }
                    AnalyticsMessages.EventDescription eventDescription = new AnalyticsMessages.EventDescription(str, jSONObject2, this.f19236d, z7, this.f19248p.a());
                    this.f19234b.f(eventDescription);
                    if (this.f19247o.g() != null) {
                        C().a(this.f19244l.c(eventDescription, this.f19235c.E()), this.f19247o.g());
                    }
                    TrackingDebug trackingDebug = this.f19242j;
                    if (trackingDebug != null) {
                        trackingDebug.e(str);
                    }
                } catch (JSONException e8) {
                    MPLog.d("MixpanelAPI.API", "Exception tracking event " + str, e8);
                }
            }
        }
    }

    public void a0(SuperPropertyUpdate superPropertyUpdate) {
        if (F()) {
            return;
        }
        this.f19240h.N(superPropertyUpdate);
    }

    public void l(String str, String str2) {
        if (F()) {
            return;
        }
        if (str2 == null) {
            str2 = y();
        }
        if (str.equals(str2)) {
            MPLog.k("MixpanelAPI.API", "Attempted to alias identical distinct_ids " + str + ". Alias message will not be sent.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alias", str);
            jSONObject.put("original", str2);
            V("$create_alias", jSONObject);
        } catch (JSONException e8) {
            MPLog.d("MixpanelAPI.API", "Failed to alias", e8);
        }
        s();
    }

    DecideMessages o(String str, DecideMessages.OnNewResultsListener onNewResultsListener, UpdatesFromMixpanel updatesFromMixpanel) {
        return new DecideMessages(this.f19233a, str, onNewResultsListener, updatesFromMixpanel, this.f19240h.q());
    }

    TrackingDebug p() {
        UpdatesFromMixpanel updatesFromMixpanel = this.f19239g;
        if (updatesFromMixpanel instanceof ViewCrawler) {
            return (TrackingDebug) updatesFromMixpanel;
        }
        return null;
    }

    UpdatesFromMixpanel q(Context context, String str) {
        if (!this.f19235c.j() && !Arrays.asList(this.f19235c.k()).contains(str)) {
            return new ViewCrawler(this.f19233a, this.f19236d, this, f19231s);
        }
        MPLog.e("MixpanelAPI.API", "DisableViewCrawler is set to true. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
        return new NoOpUpdatesFromMixpanel(f19231s);
    }

    UpdatesListener r() {
        return new SupportedUpdatesListener();
    }

    public void s() {
        if (F()) {
            return;
        }
        this.f19234b.o(new AnalyticsMessages.FlushDescription(this.f19236d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        if (F()) {
            return;
        }
        this.f19234b.o(new AnalyticsMessages.FlushDescription(this.f19236d, false));
    }

    AnalyticsMessages u() {
        return AnalyticsMessages.h(this.f19233a);
    }

    protected String v() {
        return this.f19240h.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context w() {
        return this.f19233a;
    }

    public Map<String, String> x() {
        return this.f19245m;
    }

    public String y() {
        return this.f19240h.j();
    }

    MixpanelAPI(Context context, Future<SharedPreferences> future, String str, MPConfig mPConfig, boolean z7, JSONObject jSONObject) {
        this.f19233a = context;
        this.f19236d = str;
        this.f19237e = new PeopleImpl();
        this.f19238f = new HashMap();
        this.f19235c = mPConfig;
        HashMap hashMap = new HashMap();
        hashMap.put("$android_lib_version", "5.8.5");
        hashMap.put("$android_os", DeviceInformation.osName);
        String str2 = Build.VERSION.RELEASE;
        hashMap.put("$android_os_version", str2 == null ? "UNKNOWN" : str2);
        String str3 = Build.MANUFACTURER;
        hashMap.put("$android_manufacturer", str3 == null ? "UNKNOWN" : str3);
        String str4 = Build.BRAND;
        hashMap.put("$android_brand", str4 == null ? "UNKNOWN" : str4);
        String str5 = Build.MODEL;
        hashMap.put("$android_model", str5 != null ? str5 : "UNKNOWN");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            hashMap.put("$android_app_version", packageInfo.versionName);
            hashMap.put("$android_app_version_code", Integer.toString(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException e8) {
            MPLog.d("MixpanelAPI.API", "Exception getting app version name", e8);
        }
        this.f19245m = Collections.unmodifiableMap(hashMap);
        this.f19248p = new SessionMetadata();
        UpdatesFromMixpanel q8 = q(context, str);
        this.f19239g = q8;
        this.f19242j = p();
        AnalyticsMessages u7 = u();
        this.f19234b = u7;
        PersistentIdentity D = D(context, future, str);
        this.f19240h = D;
        this.f19246n = D.s();
        if (z7 && (F() || !D.t(str))) {
            L();
        }
        if (jSONObject != null) {
            Q(jSONObject);
        }
        UpdatesListener r7 = r();
        this.f19241i = r7;
        DecideMessages o8 = o(str, r7, q8);
        this.f19244l = o8;
        this.f19243k = new ConnectIntegrations(this, this.f19233a);
        String n8 = D.n();
        o8.j(n8 == null ? D.j() : n8);
        boolean exists = MPDbAdapter.s(this.f19233a).r().exists();
        P();
        if (ConfigurationChecker.b(f19232t)) {
            new InstallReferrerPlay(w(), new InstallReferrerPlay.ReferrerCallback() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.1
                @Override // com.mixpanel.android.mpmetrics.InstallReferrerPlay.ReferrerCallback
                public void a() {
                    MixpanelAPI.this.f19234b.q(new AnalyticsMessages.UpdateEventsPropertiesDescription(MixpanelAPI.this.f19236d, MixpanelAPI.this.f19240h.p()));
                }
            }).a();
        }
        if (D.v(exists, this.f19236d)) {
            W("$ae_first_open", null, true);
            D.H(this.f19236d);
        }
        if (!this.f19235c.f()) {
            u7.j(o8);
        }
        if (S()) {
            V("$app_open", null);
        }
        if (!D.u(this.f19236d)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mp_lib", DeviceInformation.osName);
                jSONObject2.put("lib", DeviceInformation.osName);
                jSONObject2.put("distinct_id", str);
                jSONObject2.put("$lib_version", "5.8.5");
                jSONObject2.put("$user_id", str);
                u7.f(new AnalyticsMessages.EventDescription("Integration", jSONObject2, "85053bf24bba75239b16a601d9387e17"));
                u7.o(new AnalyticsMessages.FlushDescription("85053bf24bba75239b16a601d9387e17", false));
                D.I(this.f19236d);
            } catch (JSONException unused) {
            }
        }
        if (this.f19240h.w((String) hashMap.get("$android_app_version_code"))) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("$ae_updated_version", hashMap.get("$android_app_version"));
                W("$ae_updated", jSONObject3, true);
            } catch (JSONException unused2) {
            }
        }
        this.f19239g.g();
        if (this.f19235c.h()) {
            return;
        }
        ExceptionHandler.a();
    }
}
