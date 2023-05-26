package ee.mtakso.driver.navigation.navigators;

import android.content.Context;
import android.content.Intent;
import ee.mtakso.driver.routing.command.IntentContextNavigationCommand;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.AppResolver;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalNavigator.kt */
/* loaded from: classes3.dex */
public abstract class ExternalNavigator implements Navigator {

    /* renamed from: f  reason: collision with root package name */
    protected static final Companion f21219f = new Companion(null);

    /* renamed from: g  reason: collision with root package name */
    private static final GeoCoordinate f21220g = new GeoCoordinate(0.0d, 0.0d);

    /* renamed from: a  reason: collision with root package name */
    private final AppResolver f21221a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21222b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21223c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f21224d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21225e;

    /* compiled from: ExternalNavigator.kt */
    /* loaded from: classes3.dex */
    protected static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GeoCoordinate a() {
            return ExternalNavigator.f21220g;
        }
    }

    public ExternalNavigator(AppResolver appResolver, String packageName, boolean z7) {
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(packageName, "packageName");
        this.f21221a = appResolver;
        this.f21222b = packageName;
        this.f21223c = z7;
    }

    public static /* synthetic */ Intent k(ExternalNavigator externalNavigator, GeoCoordinate geoCoordinate, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                geoCoordinate = f21220g;
            }
            return externalNavigator.j(geoCoordinate);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieveIntent");
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public String a(Context context) {
        Intrinsics.f(context, "context");
        String string = context.getString(e());
        Intrinsics.e(string, "context.getString(getNameId())");
        return string;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public boolean b() {
        return this.f21221a.c(k(this, null, 1, null));
    }

    public abstract int e();

    public final String f() {
        return this.f21222b;
    }

    public boolean g() {
        return this.f21225e;
    }

    public boolean h() {
        return this.f21224d;
    }

    public final boolean i() {
        return this.f21223c;
    }

    protected abstract Intent j(GeoCoordinate geoCoordinate);

    public NavigationCommand<Context> l(GeoCoordinate latLng) {
        Intrinsics.f(latLng, "latLng");
        return new IntentContextNavigationCommand(j(latLng), new int[]{67108864, 268435456});
    }

    public /* synthetic */ ExternalNavigator(AppResolver appResolver, String str, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(appResolver, str, (i8 & 4) != 0 ? false : z7);
    }
}
