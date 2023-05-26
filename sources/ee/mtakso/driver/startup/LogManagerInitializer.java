package ee.mtakso.driver.startup;

import android.content.Context;
import androidx.startup.Initializer;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.log.LogManager;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogManagerInitializer.kt */
/* loaded from: classes3.dex */
public final class LogManagerInitializer implements Initializer<Unit> {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public LogManager f26219a;

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit a(Context context) {
        b(context);
        return Unit.f50853a;
    }

    public void b(Context context) {
        Intrinsics.f(context, "context");
        Injector.f20166d.b().M0(this);
        c().d();
    }

    public final LogManager c() {
        LogManager logManager = this.f26219a;
        if (logManager != null) {
            return logManager;
        }
        Intrinsics.w("logManager");
        return null;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> e8;
        e8 = CollectionsKt__CollectionsJVMKt.e(DaggerInitializer.class);
        return e8;
    }
}
