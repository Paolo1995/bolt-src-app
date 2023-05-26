package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
final class SavedStateHandleController implements LifecycleEventObserver {

    /* renamed from: f  reason: collision with root package name */
    private final String f6755f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6756g = false;

    /* renamed from: h  reason: collision with root package name */
    private final SavedStateHandle f6757h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.f6755f = str;
        this.f6757h = savedStateHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (!this.f6756g) {
            this.f6756g = true;
            lifecycle.a(this);
            savedStateRegistry.h(this.f6755f, this.f6757h.d());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateHandle c() {
        return this.f6757h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f6756g;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f6756g = false;
            lifecycleOwner.getLifecycle().c(this);
        }
    }
}
