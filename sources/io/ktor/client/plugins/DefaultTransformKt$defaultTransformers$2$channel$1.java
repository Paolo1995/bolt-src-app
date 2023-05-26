package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelJVMKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: DefaultTransform.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$channel$1", f = "DefaultTransform.kt", l = {94}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class DefaultTransformKt$defaultTransformers$2$channel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46268g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46269h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ Object f46270i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpResponse f46271j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTransformKt$defaultTransformers$2$channel$1(Object obj, HttpResponse httpResponse, Continuation<? super DefaultTransformKt$defaultTransformers$2$channel$1> continuation) {
        super(2, continuation);
        this.f46270i = obj;
        this.f46271j = httpResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultTransformKt$defaultTransformers$2$channel$1 defaultTransformKt$defaultTransformers$2$channel$1 = new DefaultTransformKt$defaultTransformers$2$channel$1(this.f46270i, this.f46271j, continuation);
        defaultTransformKt$defaultTransformers$2$channel$1.f46269h = obj;
        return defaultTransformKt$defaultTransformers$2$channel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((DefaultTransformKt$defaultTransformers$2$channel$1) create(writerScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46268g;
        try {
            if (i8 != 0) {
                try {
                    if (i8 == 1) {
                        ResultKt.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th) {
                    HttpResponseKt.c(this.f46271j);
                    throw th;
                }
            } else {
                ResultKt.b(obj);
                ByteWriteChannel channel = ((WriterScope) this.f46269h).getChannel();
                this.f46268g = 1;
                if (ByteReadChannelJVMKt.b((ByteReadChannel) this.f46270i, channel, Long.MAX_VALUE, this) == d8) {
                    return d8;
                }
            }
            HttpResponseKt.c(this.f46271j);
            return Unit.f50853a;
        } catch (CancellationException e8) {
            CoroutineScopeKt.c(this.f46271j, e8);
            throw e8;
        } catch (Throwable th2) {
            CoroutineScopeKt.b(this.f46271j, "Receive failed", th2);
            throw th2;
        }
    }
}
