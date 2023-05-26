package eu.bolt.chat.util;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CountLatch.kt */
@DebugMetadata(c = "eu.bolt.chat.util.CountLatch$countUp$1", f = "CountLatch.kt", l = {31}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CountLatch$countUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39692g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ CountLatch f39693h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountLatch$countUp$1(CountLatch countLatch, Continuation<? super CountLatch$countUp$1> continuation) {
        super(2, continuation);
        this.f39693h = countLatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CountLatch$countUp$1(this.f39693h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CountLatch$countUp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object f8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39692g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            final CountLatch countLatch = this.f39693h;
            Function0<Integer> function0 = new Function0<Integer>() { // from class: eu.bolt.chat.util.CountLatch$countUp$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final Integer invoke() {
                    AtomicInt atomicInt;
                    atomicInt = CountLatch.this.f39688e;
                    return Integer.valueOf(atomicInt.b());
                }
            };
            this.f39692g = 1;
            f8 = countLatch.f(function0, this);
            if (f8 == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
