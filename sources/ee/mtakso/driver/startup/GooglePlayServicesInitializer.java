package ee.mtakso.driver.startup;

import android.content.Context;
import androidx.startup.Initializer;
import ee.mtakso.driver.di.Injector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GooglePlayServicesInitializer.kt */
/* loaded from: classes3.dex */
public final class GooglePlayServicesInitializer implements Initializer<Unit> {
    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit a(Context context) {
        b(context);
        return Unit.f50853a;
    }

    public void b(Context context) {
        Intrinsics.f(context, "context");
        Injector.f20166d.b().e2().B1().b();
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> n8;
        n8 = CollectionsKt__CollectionsKt.n(LogManagerInitializer.class, DaggerInitializer.class);
        return n8;
    }
}
