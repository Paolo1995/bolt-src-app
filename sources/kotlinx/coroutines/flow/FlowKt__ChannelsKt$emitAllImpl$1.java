package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {51, 62}, m = "emitAllImpl$FlowKt__ChannelsKt")
/* loaded from: classes5.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51456f;

    /* renamed from: g  reason: collision with root package name */
    Object f51457g;

    /* renamed from: h  reason: collision with root package name */
    boolean f51458h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f51459i;

    /* renamed from: j  reason: collision with root package name */
    int f51460j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ChannelsKt$emitAllImpl$1(Continuation<? super FlowKt__ChannelsKt$emitAllImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c8;
        this.f51459i = obj;
        this.f51460j |= Integer.MIN_VALUE;
        c8 = FlowKt__ChannelsKt.c(null, null, false, this);
        return c8;
    }
}
