package eu.bolt.chat.async;

import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowBufferedChunks.kt */
@DebugMetadata(c = "eu.bolt.chat.async.TimedChunkFlow$resultFlow$2", f = "FlowBufferedChunks.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TimedChunkFlow$resultFlow$2<T> extends SuspendLambda implements Function2<List<T>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f37873g;

    /* renamed from: h  reason: collision with root package name */
    Object f37874h;

    /* renamed from: i  reason: collision with root package name */
    int f37875i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ TimedChunkFlow<T> f37876j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimedChunkFlow$resultFlow$2(TimedChunkFlow<T> timedChunkFlow, Continuation<? super TimedChunkFlow$resultFlow$2> continuation) {
        super(2, continuation);
        this.f37876j = timedChunkFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TimedChunkFlow$resultFlow$2(this.f37876j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(List<T> list, Continuation<? super Unit> continuation) {
        return ((TimedChunkFlow$resultFlow$2) create(list, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Mutex mutex;
        TimedChunkFlow<T> timedChunkFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37875i;
        if (i8 != 0) {
            if (i8 == 1) {
                timedChunkFlow = (TimedChunkFlow) this.f37874h;
                mutex = (Mutex) this.f37873g;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            mutex = ((TimedChunkFlow) this.f37876j).f37857a;
            TimedChunkFlow<T> timedChunkFlow2 = this.f37876j;
            this.f37873g = mutex;
            this.f37874h = timedChunkFlow2;
            this.f37875i = 1;
            if (mutex.a(null, this) == d8) {
                return d8;
            }
            timedChunkFlow = timedChunkFlow2;
        }
        try {
            ((TimedChunkFlow) timedChunkFlow).f37858b = new ArrayList();
            Unit unit = Unit.f50853a;
            mutex.b(null);
            return Unit.f50853a;
        } catch (Throwable th) {
            mutex.b(null);
            throw th;
        }
    }
}
