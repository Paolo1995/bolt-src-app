package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateRegistry.kt */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: g  reason: collision with root package name */
    private static final Companion f7700g = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private boolean f7702b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f7703c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7704d;

    /* renamed from: e  reason: collision with root package name */
    private Recreator.SavedStateProvider f7705e;

    /* renamed from: a  reason: collision with root package name */
    private final SafeIterableMap<String, SavedStateProvider> f7701a = new SafeIterableMap<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f7706f = true;

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void a(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: classes.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SavedStateRegistry.kt */
    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        Bundle b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SavedStateRegistry this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.f(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.f7706f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.f7706f = false;
        }
    }

    public final Bundle b(String key) {
        Bundle bundle;
        Intrinsics.f(key, "key");
        if (this.f7704d) {
            Bundle bundle2 = this.f7703c;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(key);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.f7703c;
            if (bundle3 != null) {
                bundle3.remove(key);
            }
            Bundle bundle4 = this.f7703c;
            boolean z7 = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z7 = true;
            }
            if (!z7) {
                this.f7703c = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final SavedStateProvider c(String key) {
        Intrinsics.f(key, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.f7701a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, SavedStateProvider> components = it.next();
            Intrinsics.e(components, "components");
            SavedStateProvider value = components.getValue();
            if (Intrinsics.a(components.getKey(), key)) {
                return value;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        Intrinsics.f(lifecycle, "lifecycle");
        if (!this.f7702b) {
            lifecycle.a(new LifecycleEventObserver() { // from class: l.a
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    SavedStateRegistry.d(SavedStateRegistry.this, lifecycleOwner, event);
                }
            });
            this.f7702b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void f(Bundle bundle) {
        Bundle bundle2;
        if (this.f7702b) {
            if (!this.f7704d) {
                if (bundle != null) {
                    bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                } else {
                    bundle2 = null;
                }
                this.f7703c = bundle2;
                this.f7704d = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
    }

    public final void g(Bundle outBundle) {
        Intrinsics.f(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f7703c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions f8 = this.f7701a.f();
        Intrinsics.e(f8, "this.components.iteratorWithAdditions()");
        while (f8.hasNext()) {
            Map.Entry next = f8.next();
            bundle.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).b());
        }
        if (!bundle.isEmpty()) {
            outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
        }
    }

    public final void h(String key, SavedStateProvider provider) {
        boolean z7;
        Intrinsics.f(key, "key");
        Intrinsics.f(provider, "provider");
        if (this.f7701a.k(key, provider) == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
    }

    public final void i(Class<? extends AutoRecreated> clazz) {
        Intrinsics.f(clazz, "clazz");
        if (this.f7706f) {
            Recreator.SavedStateProvider savedStateProvider = this.f7705e;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.f7705e = savedStateProvider;
            try {
                clazz.getDeclaredConstructor(new Class[0]);
                Recreator.SavedStateProvider savedStateProvider2 = this.f7705e;
                if (savedStateProvider2 != null) {
                    String name = clazz.getName();
                    Intrinsics.e(name, "clazz.name");
                    savedStateProvider2.a(name);
                    return;
                }
                return;
            } catch (NoSuchMethodException e8) {
                throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e8);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }
}
