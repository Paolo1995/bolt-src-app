package ee.mtakso.driver.service.analytics;

/* compiled from: Scopes.kt */
/* loaded from: classes3.dex */
public final class Scopes {

    /* renamed from: a  reason: collision with root package name */
    public static final Scopes f23428a = new Scopes();

    /* renamed from: b  reason: collision with root package name */
    private static final AnalyticScope f23429b = new AnalyticScope(0);

    /* renamed from: c  reason: collision with root package name */
    private static final AnalyticScope f23430c;

    /* renamed from: d  reason: collision with root package name */
    private static final AnalyticScope f23431d;

    /* renamed from: e  reason: collision with root package name */
    private static final AnalyticScope f23432e;

    /* renamed from: f  reason: collision with root package name */
    private static final AnalyticScope f23433f;

    /* renamed from: g  reason: collision with root package name */
    private static final AnalyticScope f23434g;

    /* renamed from: h  reason: collision with root package name */
    private static final AnalyticScope f23435h;

    /* renamed from: i  reason: collision with root package name */
    private static final AnalyticScope f23436i;

    /* renamed from: j  reason: collision with root package name */
    private static final AnalyticScope f23437j;

    /* renamed from: k  reason: collision with root package name */
    private static final AnalyticScope f23438k;

    static {
        AnalyticScope analyticScope = new AnalyticScope(1);
        f23430c = analyticScope;
        AnalyticScope analyticScope2 = new AnalyticScope(2);
        f23431d = analyticScope2;
        f23432e = new AnalyticScope(4);
        AnalyticScope analyticScope3 = new AnalyticScope(8);
        f23433f = analyticScope3;
        AnalyticScope analyticScope4 = new AnalyticScope(32);
        f23434g = analyticScope4;
        AnalyticScope analyticScope5 = new AnalyticScope(127);
        f23435h = analyticScope5;
        AnalyticScope a8 = analyticScope5.a(analyticScope4);
        f23436i = a8;
        f23437j = a8.a(analyticScope2);
        f23438k = analyticScope.c(analyticScope3);
    }

    private Scopes() {
    }

    public final AnalyticScope a() {
        return f23431d;
    }

    public final AnalyticScope b() {
        return f23436i;
    }

    public final AnalyticScope c() {
        return f23437j;
    }

    public final AnalyticScope d() {
        return f23430c;
    }

    public final AnalyticScope e() {
        return f23432e;
    }

    public final AnalyticScope f() {
        return f23434g;
    }

    public final AnalyticScope g() {
        return f23433f;
    }
}
