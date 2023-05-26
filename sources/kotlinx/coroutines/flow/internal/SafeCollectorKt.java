package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SafeCollector.kt */
/* loaded from: classes5.dex */
public final class SafeCollectorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> f51758a = (Function3) TypeIntrinsics.e(SafeCollectorKt$emitFun$1.f51759o, 3);

    public static final /* synthetic */ Function3 a() {
        return f51758a;
    }
}
