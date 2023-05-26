package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import com.google.android.gms.common.GoogleApiAvailability;
import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.mixpanel.android.util.HttpService;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import com.sinch.android.rtc.internal.client.DeviceInformation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AnalyticsMessages {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Context, AnalyticsMessages> f19066d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Worker f19067a = d();

    /* renamed from: b  reason: collision with root package name */
    protected final Context f19068b;

    /* renamed from: c  reason: collision with root package name */
    protected final MPConfig f19069c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class EventDescription extends MixpanelMessageDescription {

        /* renamed from: c  reason: collision with root package name */
        private final String f19070c;

        /* renamed from: d  reason: collision with root package name */
        private final JSONObject f19071d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f19072e;

        public EventDescription(String str, JSONObject jSONObject, String str2) {
            this(str, jSONObject, str2, false, new JSONObject());
        }

        public String c() {
            return this.f19070c;
        }

        public JSONObject d() {
            return b();
        }

        public JSONObject e() {
            return this.f19071d;
        }

        public boolean f() {
            return this.f19072e;
        }

        public EventDescription(String str, JSONObject jSONObject, String str2, boolean z7, JSONObject jSONObject2) {
            super(str2, jSONObject);
            this.f19070c = str;
            this.f19072e = z7;
            this.f19071d = jSONObject2;
        }
    }

    /* loaded from: classes3.dex */
    static class FlushDescription extends MixpanelDescription {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f19073b;

        public FlushDescription(String str) {
            this(str, true);
        }

        public boolean b() {
            return this.f19073b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public FlushDescription(String str, boolean z7) {
            super(str);
            this.f19073b = z7;
        }
    }

    /* loaded from: classes3.dex */
    static class GroupDescription extends MixpanelMessageDescription {
        public String toString() {
            return b().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class MixpanelDescription {

        /* renamed from: a  reason: collision with root package name */
        private final String f19074a;

        public MixpanelDescription(String str) {
            this.f19074a = str;
        }

        public String a() {
            return this.f19074a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class MixpanelMessageDescription extends MixpanelDescription {

        /* renamed from: b  reason: collision with root package name */
        private final JSONObject f19075b;

        public MixpanelMessageDescription(String str, JSONObject jSONObject) {
            super(str);
            if (jSONObject != null && jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.get(next).toString();
                    } catch (AssertionError e8) {
                        jSONObject.remove(next);
                        MPLog.d("MixpanelAPI.Messages", "Removing people profile property from update (see https://github.com/mixpanel/mixpanel-android/issues/567)", e8);
                    } catch (JSONException unused) {
                    }
                }
            }
            this.f19075b = jSONObject;
        }

        public JSONObject b() {
            return this.f19075b;
        }
    }

    /* loaded from: classes3.dex */
    static class PeopleDescription extends MixpanelMessageDescription {
        public PeopleDescription(JSONObject jSONObject, String str) {
            super(str, jSONObject);
        }

        public boolean c() {
            return !b().has("$distinct_id");
        }

        public String toString() {
            return b().toString();
        }
    }

    /* loaded from: classes3.dex */
    static class PushAnonymousPeopleDescription extends MixpanelDescription {

        /* renamed from: b  reason: collision with root package name */
        private final String f19076b;

        public PushAnonymousPeopleDescription(String str, String str2) {
            super(str2);
            this.f19076b = str;
        }

        public String b() {
            return this.f19076b;
        }

        public String toString() {
            return this.f19076b;
        }
    }

    /* loaded from: classes3.dex */
    static class UpdateEventsPropertiesDescription extends MixpanelDescription {

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f19077b;

        public UpdateEventsPropertiesDescription(String str, Map<String, String> map) {
            super(str);
            this.f19077b = map;
        }

        public Map<String, String> b() {
            return this.f19077b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class Worker {

        /* renamed from: f  reason: collision with root package name */
        private SystemInformation f19083f;

        /* renamed from: a  reason: collision with root package name */
        private final Object f19078a = new Object();

        /* renamed from: c  reason: collision with root package name */
        private long f19080c = 0;

        /* renamed from: d  reason: collision with root package name */
        private long f19081d = 0;

        /* renamed from: e  reason: collision with root package name */
        private long f19082e = -1;

        /* renamed from: b  reason: collision with root package name */
        private Handler f19079b = f();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class AnalyticsMessageHandler extends Handler {

            /* renamed from: a  reason: collision with root package name */
            private MPDbAdapter f19085a;

            /* renamed from: b  reason: collision with root package name */
            private final DecideChecker f19086b;

            /* renamed from: c  reason: collision with root package name */
            private final long f19087c;

            /* renamed from: d  reason: collision with root package name */
            private long f19088d;

            /* renamed from: e  reason: collision with root package name */
            private long f19089e;

            /* renamed from: f  reason: collision with root package name */
            private int f19090f;

            public AnalyticsMessageHandler(Looper looper) {
                super(looper);
                this.f19085a = null;
                Worker.this.f19083f = SystemInformation.g(AnalyticsMessages.this.f19068b);
                this.f19086b = a();
                this.f19087c = AnalyticsMessages.this.f19069c.n();
            }

            private JSONObject b() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mp_lib", "android");
                jSONObject.put("$lib_version", "5.8.5");
                jSONObject.put("$os", DeviceInformation.osName);
                String str = Build.VERSION.RELEASE;
                String str2 = "UNKNOWN";
                if (str == null) {
                    str = "UNKNOWN";
                }
                jSONObject.put("$os_version", str);
                String str3 = Build.MANUFACTURER;
                if (str3 == null) {
                    str3 = "UNKNOWN";
                }
                jSONObject.put("$manufacturer", str3);
                String str4 = Build.BRAND;
                if (str4 == null) {
                    str4 = "UNKNOWN";
                }
                jSONObject.put("$brand", str4);
                String str5 = Build.MODEL;
                if (str5 != null) {
                    str2 = str5;
                }
                jSONObject.put("$model", str2);
                try {
                    try {
                        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(AnalyticsMessages.this.f19068b);
                        if (isGooglePlayServicesAvailable != 0) {
                            if (isGooglePlayServicesAvailable != 1) {
                                if (isGooglePlayServicesAvailable != 2) {
                                    if (isGooglePlayServicesAvailable != 3) {
                                        if (isGooglePlayServicesAvailable == 9) {
                                            jSONObject.put("$google_play_services", "invalid");
                                        }
                                    } else {
                                        jSONObject.put("$google_play_services", "disabled");
                                    }
                                } else {
                                    jSONObject.put("$google_play_services", "out of date");
                                }
                            } else {
                                jSONObject.put("$google_play_services", "missing");
                            }
                        } else {
                            jSONObject.put("$google_play_services", "available");
                        }
                    } catch (RuntimeException unused) {
                        jSONObject.put("$google_play_services", "not configured");
                    }
                } catch (NoClassDefFoundError unused2) {
                    jSONObject.put("$google_play_services", "not included");
                }
                DisplayMetrics f8 = Worker.this.f19083f.f();
                jSONObject.put("$screen_dpi", f8.densityDpi);
                jSONObject.put("$screen_height", f8.heightPixels);
                jSONObject.put("$screen_width", f8.widthPixels);
                String c8 = Worker.this.f19083f.c();
                if (c8 != null) {
                    jSONObject.put("$app_version", c8);
                    jSONObject.put("$app_version_string", c8);
                }
                Integer b8 = Worker.this.f19083f.b();
                if (b8 != null) {
                    jSONObject.put("$app_release", b8);
                    jSONObject.put("$app_build_number", b8);
                }
                Boolean valueOf = Boolean.valueOf(Worker.this.f19083f.i());
                if (valueOf != null) {
                    jSONObject.put("$has_nfc", valueOf.booleanValue());
                }
                Boolean valueOf2 = Boolean.valueOf(Worker.this.f19083f.j());
                if (valueOf2 != null) {
                    jSONObject.put("$has_telephone", valueOf2.booleanValue());
                }
                String e8 = Worker.this.f19083f.e();
                if (e8 != null && !e8.trim().isEmpty()) {
                    jSONObject.put("$carrier", e8);
                }
                Boolean l8 = Worker.this.f19083f.l();
                if (l8 != null) {
                    jSONObject.put("$wifi", l8.booleanValue());
                }
                String h8 = Worker.this.f19083f.h(AnalyticsMessages.this.f19068b);
                if (h8 != null) {
                    jSONObject.put("$radio", h8);
                }
                Boolean k8 = Worker.this.f19083f.k();
                if (k8 != null) {
                    jSONObject.put("$bluetooth_enabled", k8);
                }
                String d8 = Worker.this.f19083f.d();
                if (d8 != null) {
                    jSONObject.put("$bluetooth_version", d8);
                }
                return jSONObject;
            }

            private JSONObject c(EventDescription eventDescription) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject d8 = eventDescription.d();
                JSONObject b8 = b();
                b8.put("token", eventDescription.a());
                if (d8 != null) {
                    Iterator<String> keys = d8.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        b8.put(next, d8.get(next));
                    }
                }
                jSONObject.put("event", eventDescription.c());
                jSONObject.put("properties", b8);
                jSONObject.put("$mp_metadata", eventDescription.e());
                return jSONObject;
            }

            private void d(MPDbAdapter mPDbAdapter, String str) {
                RemoteService i8 = AnalyticsMessages.this.i();
                AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                if (!i8.b(analyticsMessages.f19068b, analyticsMessages.f19069c.z())) {
                    AnalyticsMessages.this.k("Not flushing data to Mixpanel because the device is not connected to the internet.");
                    return;
                }
                e(mPDbAdapter, str, MPDbAdapter.Table.EVENTS, AnalyticsMessages.this.f19069c.m());
                e(mPDbAdapter, str, MPDbAdapter.Table.PEOPLE, AnalyticsMessages.this.f19069c.A());
                e(mPDbAdapter, str, MPDbAdapter.Table.GROUPS, AnalyticsMessages.this.f19069c.p());
            }

            /* JADX WARN: Removed duplicated region for block: B:66:0x01a4  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x01c5 A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void e(com.mixpanel.android.mpmetrics.MPDbAdapter r18, java.lang.String r19, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r20, java.lang.String r21) {
                /*
                    Method dump skipped, instructions count: 541
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.e(com.mixpanel.android.mpmetrics.MPDbAdapter, java.lang.String, com.mixpanel.android.mpmetrics.MPDbAdapter$Table, java.lang.String):void");
            }

            protected DecideChecker a() {
                AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                return new DecideChecker(analyticsMessages.f19068b, analyticsMessages.f19069c);
            }

            /* JADX WARN: Removed duplicated region for block: B:123:0x02ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:127:0x035f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void handleMessage(android.os.Message r11) {
                /*
                    Method dump skipped, instructions count: 896
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.handleMessage(android.os.Message):void");
            }
        }

        public Worker() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            long currentTimeMillis = System.currentTimeMillis();
            long j8 = this.f19080c;
            long j9 = 1 + j8;
            long j10 = this.f19082e;
            if (j10 > 0) {
                long j11 = ((currentTimeMillis - j10) + (this.f19081d * j8)) / j9;
                this.f19081d = j11;
                AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                analyticsMessages.k("Average send frequency approximately " + (j11 / 1000) + " seconds.");
            }
            this.f19082e = currentTimeMillis;
            this.f19080c = j9;
        }

        protected Handler f() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
            handlerThread.start();
            return new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        public void g(Message message) {
            synchronized (this.f19078a) {
                Handler handler = this.f19079b;
                if (handler == null) {
                    AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                    analyticsMessages.k("Dead mixpanel worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }
    }

    AnalyticsMessages(Context context) {
        this.f19068b = context;
        this.f19069c = g(context);
        i().c();
    }

    public static AnalyticsMessages h(Context context) {
        AnalyticsMessages analyticsMessages;
        Map<Context, AnalyticsMessages> map = f19066d;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                analyticsMessages = new AnalyticsMessages(applicationContext);
                map.put(applicationContext, analyticsMessages);
            } else {
                analyticsMessages = map.get(applicationContext);
            }
        }
        return analyticsMessages;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        MPLog.i("MixpanelAPI.Messages", str + " (Thread " + Thread.currentThread().getId() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, Throwable th) {
        MPLog.j("MixpanelAPI.Messages", str + " (Thread " + Thread.currentThread().getId() + ")", th);
    }

    public void c(MixpanelDescription mixpanelDescription) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = mixpanelDescription;
        this.f19067a.g(obtain);
    }

    protected Worker d() {
        return new Worker();
    }

    public void e(MixpanelDescription mixpanelDescription) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = mixpanelDescription;
        this.f19067a.g(obtain);
    }

    public void f(EventDescription eventDescription) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = eventDescription;
        this.f19067a.g(obtain);
    }

    protected MPConfig g(Context context) {
        return MPConfig.s(context);
    }

    protected RemoteService i() {
        return new HttpService();
    }

    public void j(DecideMessages decideMessages) {
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = decideMessages;
        this.f19067a.g(obtain);
    }

    protected MPDbAdapter m(Context context) {
        return MPDbAdapter.s(context);
    }

    public void n(PeopleDescription peopleDescription) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = peopleDescription;
        this.f19067a.g(obtain);
    }

    public void o(FlushDescription flushDescription) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = flushDescription.a();
        obtain.arg1 = flushDescription.b() ? 1 : 0;
        this.f19067a.g(obtain);
    }

    public void p(PushAnonymousPeopleDescription pushAnonymousPeopleDescription) {
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = pushAnonymousPeopleDescription;
        this.f19067a.g(obtain);
    }

    public void q(UpdateEventsPropertiesDescription updateEventsPropertiesDescription) {
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = updateEventsPropertiesDescription;
        this.f19067a.g(obtain);
    }
}
