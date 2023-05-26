package ee.mtakso.driver.startup;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.work.WorkerFactorImpl;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkManagerInitializer.kt */
/* loaded from: classes3.dex */
public final class WorkManagerInitializer implements Initializer<Unit> {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public WorkerFactorImpl f26220a;

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit a(Context context) {
        b(context);
        return Unit.f50853a;
    }

    public void b(Context context) {
        Intrinsics.f(context, "context");
        Injector.Companion companion = Injector.f20166d;
        companion.b().R1();
        companion.b().B(this);
        Configuration a8 = new Configuration.Builder().c(c()).b(4).a();
        Intrinsics.e(a8, "Builder()\n              …\n                .build()");
        WorkManager.e(context, a8);
    }

    public final WorkerFactorImpl c() {
        WorkerFactorImpl workerFactorImpl = this.f26220a;
        if (workerFactorImpl != null) {
            return workerFactorImpl;
        }
        Intrinsics.w("workerFactory");
        return null;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> e8;
        e8 = CollectionsKt__CollectionsJVMKt.e(DaggerInitializer.class);
        return e8;
    }
}
