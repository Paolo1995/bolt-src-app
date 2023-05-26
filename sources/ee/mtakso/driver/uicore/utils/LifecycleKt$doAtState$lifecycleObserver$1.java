package ee.mtakso.driver.uicore.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lifecycle.kt */
/* loaded from: classes5.dex */
public final class LifecycleKt$doAtState$lifecycleObserver$1 implements LifecycleEventObserver {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f35727f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f35728g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f35729h;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.f(source, "source");
        Intrinsics.f(event, "event");
        if (this.f35727f.getLifecycle().b().a(this.f35728g)) {
            this.f35729h.invoke();
            this.f35727f.getLifecycle().c(this);
        }
    }
}
