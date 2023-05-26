package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateUpdateHandler;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.internal.SessionAwareObject;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class Trace extends AppStateUpdateHandler implements Parcelable, SessionAwareObject {

    /* renamed from: f  reason: collision with root package name */
    private final Trace f16778f;

    /* renamed from: g  reason: collision with root package name */
    private final GaugeManager f16779g;

    /* renamed from: h  reason: collision with root package name */
    private final String f16780h;

    /* renamed from: i  reason: collision with root package name */
    private final List<PerfSession> f16781i;

    /* renamed from: j  reason: collision with root package name */
    private final List<Trace> f16782j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, Counter> f16783k;

    /* renamed from: l  reason: collision with root package name */
    private final Clock f16784l;

    /* renamed from: m  reason: collision with root package name */
    private final TransportManager f16785m;

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, String> f16786n;

    /* renamed from: o  reason: collision with root package name */
    private Timer f16787o;

    /* renamed from: p  reason: collision with root package name */
    private Timer f16788p;

    /* renamed from: q  reason: collision with root package name */
    private final WeakReference<SessionAwareObject> f16789q;

    /* renamed from: r  reason: collision with root package name */
    private static final AndroidLogger f16775r = AndroidLogger.e();

    /* renamed from: s  reason: collision with root package name */
    private static final Map<String, Trace> f16776s = new ConcurrentHashMap();
    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new Parcelable.Creator<Trace>() { // from class: com.google.firebase.perf.metrics.Trace.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Trace createFromParcel(@NonNull Parcel parcel) {
            return new Trace(parcel, false);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Trace[] newArray(int i8) {
            return new Trace[i8];
        }
    };
    @VisibleForTesting

    /* renamed from: t  reason: collision with root package name */
    static final Parcelable.Creator<Trace> f16777t = new Parcelable.Creator<Trace>() { // from class: com.google.firebase.perf.metrics.Trace.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Trace createFromParcel(Parcel parcel) {
            return new Trace(parcel, true);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Trace[] newArray(int i8) {
            return new Trace[i8];
        }
    };

    private void b(@NonNull String str, @NonNull String str2) {
        if (!n()) {
            if (!this.f16786n.containsKey(str) && this.f16786n.size() >= 5) {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", 5));
            }
            String d8 = PerfMetricValidator.d(new AbstractMap.SimpleEntry(str, str2));
            if (d8 == null) {
                return;
            }
            throw new IllegalArgumentException(d8);
        }
        throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Trace '%s' has been stopped", this.f16780h));
    }

    @NonNull
    public static Trace c(@NonNull String str) {
        return new Trace(str);
    }

    @NonNull
    private Counter o(@NonNull String str) {
        Counter counter = this.f16783k.get(str);
        if (counter == null) {
            Counter counter2 = new Counter(str);
            this.f16783k.put(str, counter2);
            return counter2;
        }
        return counter;
    }

    private void p(Timer timer) {
        if (this.f16782j.isEmpty()) {
            return;
        }
        Trace trace = this.f16782j.get(this.f16782j.size() - 1);
        if (trace.f16788p == null) {
            trace.f16788p = timer;
        }
    }

    @Override // com.google.firebase.perf.internal.SessionAwareObject
    public void a(PerfSession perfSession) {
        if (perfSession == null) {
            f16775r.f("Unable to add new SessionId to the Trace. Continuing without it.");
        } else if (j() && !n()) {
            this.f16781i.add(perfSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public Map<String, Counter> d() {
        return this.f16783k;
    }

    @Override // android.os.Parcelable
    @Keep
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public Timer e() {
        return this.f16788p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public String f() {
        return this.f16780h;
    }

    protected void finalize() throws Throwable {
        try {
            if (l()) {
                f16775r.j("Trace '%s' is started but not stopped when it is destructed!", this.f16780h);
                incrementTsnsCount(1);
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public List<PerfSession> g() {
        List<PerfSession> unmodifiableList;
        synchronized (this.f16781i) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession perfSession : this.f16781i) {
                if (perfSession != null) {
                    arrayList.add(perfSession);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    @Keep
    public String getAttribute(@NonNull String str) {
        return this.f16786n.get(str);
    }

    @NonNull
    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.f16786n);
    }

    @Keep
    public long getLongMetric(@NonNull String str) {
        Counter counter;
        if (str != null) {
            counter = this.f16783k.get(str.trim());
        } else {
            counter = null;
        }
        if (counter == null) {
            return 0L;
        }
        return counter.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public Timer h() {
        return this.f16787o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public List<Trace> i() {
        return this.f16782j;
    }

    @Keep
    public void incrementMetric(@NonNull String str, long j8) {
        String e8 = PerfMetricValidator.e(str);
        if (e8 != null) {
            f16775r.d("Cannot increment metric '%s'. Metric name is invalid.(%s)", str, e8);
        } else if (!j()) {
            f16775r.j("Cannot increment metric '%s' for trace '%s' because it's not started", str, this.f16780h);
        } else if (n()) {
            f16775r.j("Cannot increment metric '%s' for trace '%s' because it's been stopped", str, this.f16780h);
        } else {
            Counter o8 = o(str.trim());
            o8.c(j8);
            f16775r.b("Incrementing metric '%s' to %d on trace '%s'", str, Long.valueOf(o8.a()), this.f16780h);
        }
    }

    @VisibleForTesting
    boolean j() {
        if (this.f16787o != null) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    boolean l() {
        if (j() && !n()) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    boolean n() {
        if (this.f16788p != null) {
            return true;
        }
        return false;
    }

    @Keep
    public void putAttribute(@NonNull String str, @NonNull String str2) {
        boolean z7 = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            b(str, str2);
            f16775r.b("Setting attribute '%s' to '%s' on trace '%s'", str, str2, this.f16780h);
            z7 = true;
        } catch (Exception e8) {
            f16775r.d("Can not set attribute '%s' with value '%s' (%s)", str, str2, e8.getMessage());
        }
        if (z7) {
            this.f16786n.put(str, str2);
        }
    }

    @Keep
    public void putMetric(@NonNull String str, long j8) {
        String e8 = PerfMetricValidator.e(str);
        if (e8 != null) {
            f16775r.d("Cannot set value for metric '%s'. Metric name is invalid.(%s)", str, e8);
        } else if (!j()) {
            f16775r.j("Cannot set value for metric '%s' for trace '%s' because it's not started", str, this.f16780h);
        } else if (n()) {
            f16775r.j("Cannot set value for metric '%s' for trace '%s' because it's been stopped", str, this.f16780h);
        } else {
            o(str.trim()).d(j8);
            f16775r.b("Setting metric '%s' to '%s' on trace '%s'", str, Long.valueOf(j8), this.f16780h);
        }
    }

    @Keep
    public void removeAttribute(@NonNull String str) {
        if (n()) {
            f16775r.c("Can't remove a attribute from a Trace that's stopped.");
        } else {
            this.f16786n.remove(str);
        }
    }

    @Keep
    public void start() {
        if (!ConfigResolver.f().I()) {
            f16775r.f("Trace feature is disabled.");
            return;
        }
        String f8 = PerfMetricValidator.f(this.f16780h);
        if (f8 != null) {
            f16775r.d("Cannot start trace '%s'. Trace name is invalid.(%s)", this.f16780h, f8);
        } else if (this.f16787o != null) {
            f16775r.d("Trace '%s' has already started, should not start again!", this.f16780h);
        } else {
            this.f16787o = this.f16784l.a();
            registerForAppState();
            PerfSession perfSession = SessionManager.getInstance().perfSession();
            SessionManager.getInstance().registerForSessionUpdates(this.f16789q);
            a(perfSession);
            if (perfSession.f()) {
                this.f16779g.collectGaugeMetricOnce(perfSession.d());
            }
        }
    }

    @Keep
    public void stop() {
        if (!j()) {
            f16775r.d("Trace '%s' has not been started so unable to stop!", this.f16780h);
        } else if (n()) {
            f16775r.d("Trace '%s' has already stopped, should not stop again!", this.f16780h);
        } else {
            SessionManager.getInstance().unregisterForSessionUpdates(this.f16789q);
            unregisterForAppState();
            Timer a8 = this.f16784l.a();
            this.f16788p = a8;
            if (this.f16778f == null) {
                p(a8);
                if (!this.f16780h.isEmpty()) {
                    this.f16785m.w(new TraceMetricBuilder(this).a(), getAppState());
                    if (SessionManager.getInstance().perfSession().f()) {
                        this.f16779g.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().d());
                        return;
                    }
                    return;
                }
                f16775r.c("Trace name is empty, no log is sent to server");
            }
        }
    }

    @Override // android.os.Parcelable
    @Keep
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        parcel.writeParcelable(this.f16778f, 0);
        parcel.writeString(this.f16780h);
        parcel.writeList(this.f16782j);
        parcel.writeMap(this.f16783k);
        parcel.writeParcelable(this.f16787o, 0);
        parcel.writeParcelable(this.f16788p, 0);
        synchronized (this.f16781i) {
            parcel.writeList(this.f16781i);
        }
    }

    private Trace(@NonNull String str) {
        this(str, TransportManager.e(), new Clock(), AppStateMonitor.b(), GaugeManager.getInstance());
    }

    public Trace(@NonNull String str, @NonNull TransportManager transportManager, @NonNull Clock clock, @NonNull AppStateMonitor appStateMonitor) {
        this(str, transportManager, clock, appStateMonitor, GaugeManager.getInstance());
    }

    public Trace(@NonNull String str, @NonNull TransportManager transportManager, @NonNull Clock clock, @NonNull AppStateMonitor appStateMonitor, @NonNull GaugeManager gaugeManager) {
        super(appStateMonitor);
        this.f16789q = new WeakReference<>(this);
        this.f16778f = null;
        this.f16780h = str.trim();
        this.f16782j = new ArrayList();
        this.f16783k = new ConcurrentHashMap();
        this.f16786n = new ConcurrentHashMap();
        this.f16784l = clock;
        this.f16785m = transportManager;
        this.f16781i = Collections.synchronizedList(new ArrayList());
        this.f16779g = gaugeManager;
    }

    private Trace(@NonNull Parcel parcel, boolean z7) {
        super(z7 ? null : AppStateMonitor.b());
        this.f16789q = new WeakReference<>(this);
        this.f16778f = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.f16780h = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.f16782j = arrayList;
        parcel.readList(arrayList, Trace.class.getClassLoader());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f16783k = concurrentHashMap;
        this.f16786n = new ConcurrentHashMap();
        parcel.readMap(concurrentHashMap, Counter.class.getClassLoader());
        this.f16787o = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        this.f16788p = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
        List<PerfSession> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.f16781i = synchronizedList;
        parcel.readList(synchronizedList, PerfSession.class.getClassLoader());
        if (z7) {
            this.f16785m = null;
            this.f16784l = null;
            this.f16779g = null;
            return;
        }
        this.f16785m = TransportManager.e();
        this.f16784l = new Clock();
        this.f16779g = GaugeManager.getInstance();
    }
}
