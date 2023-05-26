package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateRegistryController.kt */
/* loaded from: classes.dex */
public final class SavedStateRegistryController {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f7707d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistryOwner f7708a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f7709b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7710c;

    /* compiled from: SavedStateRegistryController.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SavedStateRegistryController a(SavedStateRegistryOwner owner) {
            Intrinsics.f(owner, "owner");
            return new SavedStateRegistryController(owner, null);
        }
    }

    private SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.f7708a = savedStateRegistryOwner;
        this.f7709b = new SavedStateRegistry();
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this(savedStateRegistryOwner);
    }

    public static final SavedStateRegistryController a(SavedStateRegistryOwner savedStateRegistryOwner) {
        return f7707d.a(savedStateRegistryOwner);
    }

    public final SavedStateRegistry b() {
        return this.f7709b;
    }

    public final void c() {
        boolean z7;
        Lifecycle lifecycle = this.f7708a.getLifecycle();
        Intrinsics.e(lifecycle, "owner.lifecycle");
        if (lifecycle.b() == Lifecycle.State.INITIALIZED) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            lifecycle.a(new Recreator(this.f7708a));
            this.f7709b.e(lifecycle);
            this.f7710c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    public final void d(Bundle bundle) {
        if (!this.f7710c) {
            c();
        }
        Lifecycle lifecycle = this.f7708a.getLifecycle();
        Intrinsics.e(lifecycle, "owner.lifecycle");
        if (!lifecycle.b().a(Lifecycle.State.STARTED)) {
            this.f7709b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        Intrinsics.f(outBundle, "outBundle");
        this.f7709b.g(outBundle);
    }
}
