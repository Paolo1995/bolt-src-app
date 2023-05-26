package io.ktor.client.content;

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

/* compiled from: ObservableContent.kt */
@DebugMetadata(c = "io.ktor.client.content.ObservableContent$content$1", f = "ObservableContent.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ObservableContent$content$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46105g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46106h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OutgoingContent f46107i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableContent$content$1(OutgoingContent outgoingContent, Continuation<? super ObservableContent$content$1> continuation) {
        super(2, continuation);
        this.f46107i = outgoingContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ObservableContent$content$1 observableContent$content$1 = new ObservableContent$content$1(this.f46107i, continuation);
        observableContent$content$1.f46106h = obj;
        return observableContent$content$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ObservableContent$content$1) create(writerScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46105g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            ByteWriteChannel channel = ((WriterScope) this.f46106h).getChannel();
            this.f46105g = 1;
            if (((OutgoingContent.WriteChannelContent) this.f46107i).e(channel, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
