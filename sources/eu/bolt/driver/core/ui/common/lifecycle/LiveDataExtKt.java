package eu.bolt.driver.core.ui.common.lifecycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: LiveDataExt.kt */
/* loaded from: classes5.dex */
public final class LiveDataExtKt {
    public static final <T, R> LiveData<T> b(LiveData<T> liveData, final Function1<? super T, ? extends R> selector) {
        Intrinsics.f(liveData, "<this>");
        Intrinsics.f(selector, "selector");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Function1<T, Unit> function1 = new Function1<T, Unit>() { // from class: eu.bolt.driver.core.ui.common.lifecycle.LiveDataExtKt$distinctUntilChangedBy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(T t7) {
                T t8 = (T) selector.invoke(t7);
                if (!Intrinsics.a(ref$ObjectRef.f51016f, t8) || !ref$BooleanRef.f51012f) {
                    ref$BooleanRef.f51012f = true;
                    ref$ObjectRef.f51016f = t8;
                    mediatorLiveData.o(t7);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                b(obj);
                return Unit.f50853a;
            }
        };
        mediatorLiveData.p(liveData, new Observer() { // from class: eu.bolt.driver.core.ui.common.lifecycle.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveDataExtKt.c(Function1.this, obj);
            }
        });
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
