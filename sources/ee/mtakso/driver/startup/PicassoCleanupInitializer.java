package ee.mtakso.driver.startup;

import android.content.Context;
import androidx.startup.Initializer;
import eu.bolt.kalev.Kalev;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PicassoCleanupInitializer.kt */
/* loaded from: classes3.dex */
public final class PicassoCleanupInitializer implements Initializer<Unit> {
    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit a(Context context) {
        b(context);
        return Unit.f50853a;
    }

    public void b(Context context) {
        Intrinsics.f(context, "context");
        try {
            new File(context.getApplicationContext().getCacheDir(), "picasso-cache").deleteOnExit();
        } catch (Exception e8) {
            Kalev.e(e8, "Failed to cleanup Picasso cache dir");
        }
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }
}
