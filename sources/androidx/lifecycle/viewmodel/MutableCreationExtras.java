package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this(null, 1, null);
    }

    public MutableCreationExtras(CreationExtras initialExtras) {
        Intrinsics.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public <T> T a(CreationExtras.Key<T> key) {
        Intrinsics.f(key, "key");
        return (T) b().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(CreationExtras.Key<T> key, T t7) {
        Intrinsics.f(key, "key");
        b().put(key, t7);
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? CreationExtras.Empty.f6812b : creationExtras);
    }
}
