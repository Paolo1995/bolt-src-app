package ee.mtakso.driver.startup;

import android.content.Context;
import androidx.startup.Initializer;
import eu.bolt.driver.core.utils.AssertUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssertionInitializer.kt */
/* loaded from: classes3.dex */
public final class AssertionInitializer implements Initializer<Unit> {
    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit a(Context context) {
        b(context);
        return Unit.f50853a;
    }

    public void b(Context context) {
        Intrinsics.f(context, "context");
        AssertUtils.g(false);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
