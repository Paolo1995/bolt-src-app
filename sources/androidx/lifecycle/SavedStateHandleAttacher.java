package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {

    /* renamed from: f  reason: collision with root package name */
    private final SavedStateHandlesProvider f6754f;

    public SavedStateHandleAttacher(SavedStateHandlesProvider provider) {
        Intrinsics.f(provider, "provider");
        this.f6754f = provider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        boolean z7;
        Intrinsics.f(source, "source");
        Intrinsics.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            source.getLifecycle().c(this);
            this.f6754f.d();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}
