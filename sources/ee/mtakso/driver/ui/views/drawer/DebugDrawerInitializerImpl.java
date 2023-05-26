package ee.mtakso.driver.ui.views.drawer;

import android.app.Activity;
import ee.mtakso.driver.features.Features;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugDrawerInitializerImpl.kt */
/* loaded from: classes5.dex */
public final class DebugDrawerInitializerImpl implements DebugDrawerInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final Features f34357a;

    @Inject
    public DebugDrawerInitializerImpl(Features features) {
        Intrinsics.f(features, "features");
        this.f34357a = features;
    }

    @Override // ee.mtakso.driver.ui.views.drawer.DebugDrawerInitializer
    public void a(Activity activity) {
        Intrinsics.f(activity, "activity");
    }
}
