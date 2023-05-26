package ee.mtakso.driver.navigation.navigators;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaxifyNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class TaxifyNavigator extends InternalNavigator {

    /* renamed from: b  reason: collision with root package name */
    private final Navigator.Type f21255b = Navigator.Type.TAXIFY_NAVIGATION;

    /* renamed from: c  reason: collision with root package name */
    private final int f21256c = R.drawable.ic_active_order_default_nav;

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public String a(Context context) {
        Intrinsics.f(context, "context");
        String string = context.getString(R.string.taxify_navigation);
        Intrinsics.e(string, "context.getString(R.string.taxify_navigation)");
        return string;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21256c;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21255b;
    }
}
