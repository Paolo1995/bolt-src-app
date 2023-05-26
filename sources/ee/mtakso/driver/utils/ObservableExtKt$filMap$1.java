package ee.mtakso.driver.utils;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: ObservableExt.kt */
/* loaded from: classes5.dex */
final class ObservableExtKt$filMap$1<R, T> extends Lambda implements Function1<T, Optional<R>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Function1<T, R> f36309f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ObservableExtKt$filMap$1(Function1<? super T, ? extends R> function1) {
        super(1);
        this.f36309f = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final Optional<R> invoke(T t7) {
        Optional f8 = Optional.f(t7);
        final Function1<T, R> function1 = this.f36309f;
        return f8.e(new Function() { // from class: ee.mtakso.driver.utils.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Object d8;
                d8 = ObservableExtKt$filMap$1.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
