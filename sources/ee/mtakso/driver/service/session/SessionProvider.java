package ee.mtakso.driver.service.session;

import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import eu.bolt.kalev.Kalev;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionProvider.kt */
@Singleton
/* loaded from: classes3.dex */
public final class SessionProvider {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f25911f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TrueTimeProvider f25912a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceInfo f25913b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverAnalytics f25914c;

    /* renamed from: d  reason: collision with root package name */
    private String f25915d;

    /* renamed from: e  reason: collision with root package name */
    private volatile SessionModel f25916e;

    /* compiled from: SessionProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SessionProvider.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25917a;

        static {
            int[] iArr = new int[SessionType.values().length];
            try {
                iArr[SessionType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionType.DEVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25917a = iArr;
        }
    }

    @Inject
    public SessionProvider(TrueTimeProvider trueTimeProvider, DeviceInfo deviceInfo, DriverAnalytics driverAnalytics) {
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(deviceInfo, "deviceInfo");
        Intrinsics.f(driverAnalytics, "driverAnalytics");
        this.f25912a = trueTimeProvider;
        this.f25913b = deviceInfo;
        this.f25914c = driverAnalytics;
    }

    private final String a(SessionType sessionType) {
        int i8 = WhenMappings.f25917a[sessionType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return this.f25913b.c();
            }
            throw new NoWhenBranchMatchedException();
        }
        String str = this.f25915d;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final SessionModel b() {
        SessionType d8 = d();
        long e8 = e();
        String str = a(d8) + "d" + e8;
        SessionModel sessionModel = new SessionModel(e8, str, d8);
        Kalev.h("Created new session = " + sessionModel);
        this.f25914c.B0(str);
        return sessionModel;
    }

    private final SessionType d() {
        if (this.f25915d != null) {
            return SessionType.USER;
        }
        return SessionType.DEVICE;
    }

    private final long e() {
        return this.f25912a.b();
    }

    private final boolean f(SessionModel sessionModel) {
        if (TimeUnit.MINUTES.convert(this.f25912a.b() - sessionModel.b(), TimeUnit.MILLISECONDS) > 30) {
            return true;
        }
        return false;
    }

    public final synchronized SessionModel c() {
        SessionModel sessionModel = null;
        if (!g()) {
            this.f25916e = b();
            SessionModel sessionModel2 = this.f25916e;
            if (sessionModel2 == null) {
                Intrinsics.w("sessionModel");
            } else {
                sessionModel = sessionModel2;
            }
            return sessionModel;
        }
        SessionModel sessionModel3 = this.f25916e;
        if (sessionModel3 == null) {
            Intrinsics.w("sessionModel");
            sessionModel3 = null;
        }
        if (f(sessionModel3)) {
            this.f25916e = b();
            SessionModel sessionModel4 = this.f25916e;
            if (sessionModel4 == null) {
                Intrinsics.w("sessionModel");
            } else {
                sessionModel = sessionModel4;
            }
            return sessionModel;
        }
        SessionType d8 = d();
        SessionModel sessionModel5 = this.f25916e;
        if (sessionModel5 == null) {
            Intrinsics.w("sessionModel");
            sessionModel5 = null;
        }
        if (d8 != sessionModel5.c()) {
            this.f25916e = b();
            SessionModel sessionModel6 = this.f25916e;
            if (sessionModel6 == null) {
                Intrinsics.w("sessionModel");
            } else {
                sessionModel = sessionModel6;
            }
            return sessionModel;
        }
        SessionModel sessionModel7 = this.f25916e;
        if (sessionModel7 == null) {
            Intrinsics.w("sessionModel");
            sessionModel7 = null;
        }
        Kalev.h("Returning session " + sessionModel7);
        SessionModel sessionModel8 = this.f25916e;
        if (sessionModel8 == null) {
            Intrinsics.w("sessionModel");
        } else {
            sessionModel = sessionModel8;
        }
        return sessionModel;
    }

    public final boolean g() {
        if (this.f25916e != null) {
            return true;
        }
        return false;
    }

    public final void h() {
        this.f25916e = b();
    }

    public final void i(String str) {
        this.f25915d = str;
    }
}
