package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.JobKt;
import okio.BufferedSource;

/* compiled from: OkHttpEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", l = {165}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class OkHttpEngineKt$toChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46193g;

    /* renamed from: h  reason: collision with root package name */
    Object f46194h;

    /* renamed from: i  reason: collision with root package name */
    Object f46195i;

    /* renamed from: j  reason: collision with root package name */
    Object f46196j;

    /* renamed from: k  reason: collision with root package name */
    Object f46197k;

    /* renamed from: l  reason: collision with root package name */
    int f46198l;

    /* renamed from: m  reason: collision with root package name */
    private /* synthetic */ Object f46199m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ BufferedSource f46200n;

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ CoroutineContext f46201o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ HttpRequestData f46202p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngineKt$toChannel$1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super OkHttpEngineKt$toChannel$1> continuation) {
        super(2, continuation);
        this.f46200n = bufferedSource;
        this.f46201o = coroutineContext;
        this.f46202p = httpRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OkHttpEngineKt$toChannel$1 okHttpEngineKt$toChannel$1 = new OkHttpEngineKt$toChannel$1(this.f46200n, this.f46201o, this.f46202p, continuation);
        okHttpEngineKt$toChannel$1.f46199m = obj;
        return okHttpEngineKt$toChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((OkHttpEngineKt$toChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        WriterScope writerScope;
        CoroutineContext coroutineContext;
        final Ref$IntRef ref$IntRef;
        OkHttpEngineKt$toChannel$1 okHttpEngineKt$toChannel$1;
        final HttpRequestData httpRequestData;
        final BufferedSource bufferedSource;
        BufferedSource bufferedSource2;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46198l;
        try {
            if (i8 != 0) {
                if (i8 == 1) {
                    ref$IntRef = (Ref$IntRef) this.f46197k;
                    bufferedSource = (BufferedSource) this.f46196j;
                    httpRequestData = (HttpRequestData) this.f46195i;
                    coroutineContext = (CoroutineContext) this.f46194h;
                    ?? r62 = (Closeable) this.f46193g;
                    writerScope = (WriterScope) this.f46199m;
                    ResultKt.b(obj);
                    okHttpEngineKt$toChannel$1 = this;
                    bufferedSource2 = r62;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                WriterScope writerScope2 = (WriterScope) this.f46199m;
                BufferedSource bufferedSource3 = this.f46200n;
                CoroutineContext coroutineContext2 = this.f46201o;
                HttpRequestData httpRequestData2 = this.f46202p;
                writerScope = writerScope2;
                coroutineContext = coroutineContext2;
                ref$IntRef = new Ref$IntRef();
                okHttpEngineKt$toChannel$1 = this;
                httpRequestData = httpRequestData2;
                bufferedSource = bufferedSource3;
                bufferedSource2 = bufferedSource3;
            }
            while (bufferedSource.isOpen() && JobKt.l(coroutineContext) && ref$IntRef.f51014f >= 0) {
                ByteWriteChannel channel = writerScope.getChannel();
                Function1<ByteBuffer, Unit> function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(ByteBuffer buffer) {
                        Intrinsics.f(buffer, "buffer");
                        try {
                            Ref$IntRef.this.f51014f = bufferedSource.read(buffer);
                        } catch (Throwable th) {
                            throw OkHttpEngineKt.b(th, httpRequestData);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                        b(byteBuffer);
                        return Unit.f50853a;
                    }
                };
                okHttpEngineKt$toChannel$1.f46199m = writerScope;
                okHttpEngineKt$toChannel$1.f46193g = bufferedSource2;
                okHttpEngineKt$toChannel$1.f46194h = coroutineContext;
                okHttpEngineKt$toChannel$1.f46195i = httpRequestData;
                okHttpEngineKt$toChannel$1.f46196j = bufferedSource;
                okHttpEngineKt$toChannel$1.f46197k = ref$IntRef;
                okHttpEngineKt$toChannel$1.f46198l = 1;
                if (ByteWriteChannel.DefaultImpls.a(channel, 0, function1, okHttpEngineKt$toChannel$1, 1, null) == d8) {
                    return d8;
                }
            }
            Unit unit = Unit.f50853a;
            CloseableKt.a(bufferedSource2, null);
            return Unit.f50853a;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(bufferedSource2, th);
                throw th2;
            }
        }
    }
}
