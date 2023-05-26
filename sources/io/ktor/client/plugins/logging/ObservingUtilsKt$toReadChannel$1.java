package io.ktor.client.plugins.logging;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ObservingUtils.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1", f = "ObservingUtils.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ObservingUtilsKt$toReadChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46577g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46578h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OutgoingContent.WriteChannelContent f46579i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservingUtilsKt$toReadChannel$1(OutgoingContent.WriteChannelContent writeChannelContent, Continuation<? super ObservingUtilsKt$toReadChannel$1> continuation) {
        super(2, continuation);
        this.f46579i = writeChannelContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ObservingUtilsKt$toReadChannel$1 observingUtilsKt$toReadChannel$1 = new ObservingUtilsKt$toReadChannel$1(this.f46579i, continuation);
        observingUtilsKt$toReadChannel$1.f46578h = obj;
        return observingUtilsKt$toReadChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ObservingUtilsKt$toReadChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46577g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            OutgoingContent.WriteChannelContent writeChannelContent = this.f46579i;
            ByteWriteChannel channel = ((WriterScope) this.f46578h).getChannel();
            this.f46577g = 1;
            if (writeChannelContent.e(channel, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
