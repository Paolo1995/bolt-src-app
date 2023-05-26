package com.google.firebase.perf.impl;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateUpdateHandler;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.internal.SessionAwareObject;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class NetworkRequestMetricBuilder extends AppStateUpdateHandler implements SessionAwareObject {

    /* renamed from: n  reason: collision with root package name */
    private static final AndroidLogger f16703n = AndroidLogger.e();

    /* renamed from: f  reason: collision with root package name */
    private final List<PerfSession> f16704f;

    /* renamed from: g  reason: collision with root package name */
    private final GaugeManager f16705g;

    /* renamed from: h  reason: collision with root package name */
    private final TransportManager f16706h;

    /* renamed from: i  reason: collision with root package name */
    private final NetworkRequestMetric.Builder f16707i;

    /* renamed from: j  reason: collision with root package name */
    private String f16708j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16709k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16710l;

    /* renamed from: m  reason: collision with root package name */
    private final WeakReference<SessionAwareObject> f16711m;

    private NetworkRequestMetricBuilder(TransportManager transportManager) {
        this(transportManager, AppStateMonitor.b(), GaugeManager.getInstance());
    }

    public static NetworkRequestMetricBuilder c(TransportManager transportManager) {
        return new NetworkRequestMetricBuilder(transportManager);
    }

    private boolean g() {
        return this.f16707i.z();
    }

    private boolean h() {
        return this.f16707i.B();
    }

    private static boolean i(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i8 = 0; i8 < str.length(); i8++) {
            char charAt = str.charAt(i8);
            if (charAt <= 31 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.firebase.perf.internal.SessionAwareObject
    public void a(PerfSession perfSession) {
        if (perfSession == null) {
            f16703n.f("Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else if (g() && !h()) {
            this.f16704f.add(perfSession);
        }
    }

    public NetworkRequestMetric b() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.f16711m);
        unregisterForAppState();
        com.google.firebase.perf.v1.PerfSession[] b8 = PerfSession.b(d());
        if (b8 != null) {
            this.f16707i.u(Arrays.asList(b8));
        }
        NetworkRequestMetric build = this.f16707i.build();
        if (!NetworkRequestMetricBuilderUtil.c(this.f16708j)) {
            f16703n.a("Dropping network request from a 'User-Agent' that is not allowed");
            return build;
        } else if (!this.f16709k) {
            this.f16706h.v(build, getAppState());
            this.f16709k = true;
            return build;
        } else {
            if (this.f16710l) {
                f16703n.f("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
            }
            return build;
        }
    }

    List<PerfSession> d() {
        List<PerfSession> unmodifiableList;
        synchronized (this.f16704f) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession perfSession : this.f16704f) {
                if (perfSession != null) {
                    arrayList.add(perfSession);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public long e() {
        return this.f16707i.x();
    }

    public boolean f() {
        return this.f16707i.A();
    }

    public NetworkRequestMetricBuilder j(String str) {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod2 = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c8 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c8 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals("TRACE")) {
                        c8 = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c8 = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c8 = '\b';
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case 1:
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case 2:
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case 3:
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case 4:
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case 5:
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case 6:
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case 7:
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case '\b':
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
                    httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.f16707i.D(httpMethod);
        }
        return this;
    }

    public NetworkRequestMetricBuilder l(int i8) {
        this.f16707i.E(i8);
        return this;
    }

    public NetworkRequestMetricBuilder n() {
        this.f16707i.G(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    public NetworkRequestMetricBuilder o(long j8) {
        this.f16707i.H(j8);
        return this;
    }

    public NetworkRequestMetricBuilder p(long j8) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.f16711m);
        this.f16707i.C(j8);
        a(perfSession);
        if (perfSession.f()) {
            this.f16705g.collectGaugeMetricOnce(perfSession.d());
        }
        return this;
    }

    public NetworkRequestMetricBuilder q(String str) {
        if (str == null) {
            this.f16707i.v();
            return this;
        }
        if (i(str)) {
            this.f16707i.J(str);
        } else {
            AndroidLogger androidLogger = f16703n;
            androidLogger.f("The content type of the response is not a valid content-type:" + str);
        }
        return this;
    }

    public NetworkRequestMetricBuilder r(long j8) {
        this.f16707i.K(j8);
        return this;
    }

    public NetworkRequestMetricBuilder s(long j8) {
        this.f16707i.L(j8);
        return this;
    }

    public NetworkRequestMetricBuilder t(long j8) {
        this.f16707i.M(j8);
        if (SessionManager.getInstance().perfSession().f()) {
            this.f16705g.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().d());
        }
        return this;
    }

    public NetworkRequestMetricBuilder u(long j8) {
        this.f16707i.N(j8);
        return this;
    }

    public NetworkRequestMetricBuilder v(String str) {
        if (str != null) {
            this.f16707i.O(Utils.e(Utils.d(str), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE));
        }
        return this;
    }

    public NetworkRequestMetricBuilder x(String str) {
        this.f16708j = str;
        return this;
    }

    public NetworkRequestMetricBuilder(TransportManager transportManager, AppStateMonitor appStateMonitor, GaugeManager gaugeManager) {
        super(appStateMonitor);
        this.f16707i = NetworkRequestMetric.newBuilder();
        this.f16711m = new WeakReference<>(this);
        this.f16706h = transportManager;
        this.f16705g = gaugeManager;
        this.f16704f = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }
}
