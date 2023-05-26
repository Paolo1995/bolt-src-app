package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class InitializerViewModelFactoryBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewModelInitializer<?>> f6814a = new ArrayList();

    public final <T extends ViewModel> void a(KClass<T> clazz, Function1<? super CreationExtras, ? extends T> initializer) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(initializer, "initializer");
        this.f6814a.add(new ViewModelInitializer<>(JvmClassMappingKt.a(clazz), initializer));
    }

    public final ViewModelProvider.Factory b() {
        Object[] array = this.f6814a.toArray(new ViewModelInitializer[0]);
        if (array != null) {
            ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) array;
            return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
