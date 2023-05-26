package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ByteChannels.kt */
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$1$2", f = "ByteChannels.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ByteChannelsKt$split$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f47022g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ByteChannel f47023h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteReadPacket f47024i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$split$1$1$2(ByteChannel byteChannel, ByteReadPacket byteReadPacket, Continuation<? super ByteChannelsKt$split$1$1$2> continuation) {
        super(2, continuation);
        this.f47023h = byteChannel;
        this.f47024i = byteReadPacket;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ByteChannelsKt$split$1$1$2(this.f47023h, this.f47024i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$split$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f47022g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ByteChannel byteChannel = this.f47023h;
            ByteReadPacket q12 = this.f47024i.q1();
            this.f47022g = 1;
            if (byteChannel.m(q12, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
