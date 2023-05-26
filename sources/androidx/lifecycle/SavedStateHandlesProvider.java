package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistry f6762a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6763b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f6764c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f6765d;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, final ViewModelStoreOwner viewModelStoreOwner) {
        Lazy b8;
        Intrinsics.f(savedStateRegistry, "savedStateRegistry");
        Intrinsics.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f6762a = savedStateRegistry;
        b8 = LazyKt__LazyJVMKt.b(new Function0<SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SavedStateHandlesVM invoke() {
                return SavedStateHandleSupport.e(ViewModelStoreOwner.this);
            }
        });
        this.f6765d = b8;
    }

    private final SavedStateHandlesVM c() {
        return (SavedStateHandlesVM) this.f6765d.getValue();
    }

    public final Bundle a(String key) {
        Bundle bundle;
        Intrinsics.f(key, "key");
        d();
        Bundle bundle2 = this.f6764c;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(key);
        } else {
            bundle = null;
        }
        Bundle bundle3 = this.f6764c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f6764c;
        boolean z7 = true;
        if ((bundle4 == null || !bundle4.isEmpty()) ? false : false) {
            this.f6764c = null;
        }
        return bundle;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle b() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f6764c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, SavedStateHandle> entry : c().a().entrySet()) {
            String key = entry.getKey();
            Bundle b8 = entry.getValue().d().b();
            if (!Intrinsics.a(b8, Bundle.EMPTY)) {
                bundle.putBundle(key, b8);
            }
        }
        this.f6763b = false;
        return bundle;
    }

    public final void d() {
        if (!this.f6763b) {
            this.f6764c = this.f6762a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            this.f6763b = true;
            c();
        }
    }
}
