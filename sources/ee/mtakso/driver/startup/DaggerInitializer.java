package ee.mtakso.driver.startup;

import android.content.Context;
import androidx.startup.Initializer;
import ee.mtakso.App;
import ee.mtakso.driver.di.DaggerReleaseApplicationComponent;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.startup.DaggerInitializer;
import java.util.List;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DaggerInitalizer.kt */
/* loaded from: classes3.dex */
public final class DaggerInitializer implements Initializer<Unit> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationComponent.Builder d() {
        return DaggerReleaseApplicationComponent.a();
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit a(Context context) {
        c(context);
        return Unit.f50853a;
    }

    public void c(Context context) {
        Intrinsics.f(context, "context");
        Injector.Companion companion = Injector.f20166d;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.d(applicationContext, "null cannot be cast to non-null type ee.mtakso.App");
        companion.a((App) applicationContext, new Provider() { // from class: k2.a
            @Override // javax.inject.Provider
            public final Object get() {
                ApplicationComponent.Builder d8;
                d8 = DaggerInitializer.d();
                return d8;
            }
        });
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
