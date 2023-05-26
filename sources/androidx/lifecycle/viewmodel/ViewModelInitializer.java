package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f6816a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<CreationExtras, T> f6817b;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelInitializer(Class<T> clazz, Function1<? super CreationExtras, ? extends T> initializer) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(initializer, "initializer");
        this.f6816a = clazz;
        this.f6817b = initializer;
    }

    public final Class<T> a() {
        return this.f6816a;
    }

    public final Function1<CreationExtras, T> b() {
        return this.f6817b;
    }
}
