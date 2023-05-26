package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {

    /* renamed from: f  reason: collision with root package name */
    private final KClass<VM> f6786f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<ViewModelStore> f6787g;

    /* renamed from: h  reason: collision with root package name */
    private final Function0<ViewModelProvider.Factory> f6788h;

    /* renamed from: i  reason: collision with root package name */
    private final Function0<CreationExtras> f6789i;

    /* renamed from: j  reason: collision with root package name */
    private VM f6790j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(KClass<VM> viewModelClass, Function0<? extends ViewModelStore> storeProducer, Function0<? extends ViewModelProvider.Factory> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        Intrinsics.f(viewModelClass, "viewModelClass");
        Intrinsics.f(storeProducer, "storeProducer");
        Intrinsics.f(factoryProducer, "factoryProducer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(KClass<VM> viewModelClass, Function0<? extends ViewModelStore> storeProducer, Function0<? extends ViewModelProvider.Factory> factoryProducer, Function0<? extends CreationExtras> extrasProducer) {
        Intrinsics.f(viewModelClass, "viewModelClass");
        Intrinsics.f(storeProducer, "storeProducer");
        Intrinsics.f(factoryProducer, "factoryProducer");
        Intrinsics.f(extrasProducer, "extrasProducer");
        this.f6786f = viewModelClass;
        this.f6787g = storeProducer;
        this.f6788h = factoryProducer;
        this.f6789i = extrasProducer;
    }

    @Override // kotlin.Lazy
    /* renamed from: a */
    public VM getValue() {
        VM vm = this.f6790j;
        if (vm == null) {
            VM vm2 = (VM) new ViewModelProvider(this.f6787g.invoke(), this.f6788h.invoke(), this.f6789i.invoke()).a(JvmClassMappingKt.a(this.f6786f));
            this.f6790j = vm2;
            return vm2;
        }
        return vm;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.f6790j != null) {
            return true;
        }
        return false;
    }

    public /* synthetic */ ViewModelLazy(KClass kClass, Function0 function0, Function0 function02, Function0 function03, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, function0, function02, (i8 & 8) != 0 ? new Function0<CreationExtras.Empty>() { // from class: androidx.lifecycle.ViewModelLazy.1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CreationExtras.Empty invoke() {
                return CreationExtras.Empty.f6812b;
            }
        } : function03);
    }
}
