package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;

/* compiled from: DefaultTransformersJvm.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1", f = "DefaultTransformersJvm.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46276g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46277h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46278i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(Continuation<? super DefaultTransformersJvmKt$platformResponseDefaultTransformers$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 defaultTransformersJvmKt$platformResponseDefaultTransformers$1 = new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(continuation);
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.f46277h = pipelineContext;
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.f46278i = httpResponseContainer;
        return defaultTransformersJvmKt$platformResponseDefaultTransformers$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46276g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            final PipelineContext pipelineContext = (PipelineContext) this.f46277h;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.f46278i;
            TypeInfo a8 = httpResponseContainer.a();
            Object b8 = httpResponseContainer.b();
            if (!(b8 instanceof ByteReadChannel)) {
                return Unit.f50853a;
            }
            if (Intrinsics.a(a8.b(), Reflection.b(InputStream.class))) {
                final InputStream c8 = BlockingKt.c((ByteReadChannel) b8, (Job) ((HttpClientCall) pipelineContext.c()).j().g(Job.f51296d));
                HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(a8, new InputStream() { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1$response$1
                    @Override // java.io.InputStream
                    public int available() {
                        return c8.available();
                    }

                    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        super.close();
                        c8.close();
                        HttpResponseKt.c(pipelineContext.c().f());
                    }

                    @Override // java.io.InputStream
                    public int read() {
                        return c8.read();
                    }

                    @Override // java.io.InputStream
                    public int read(byte[] b9, int i9, int i10) {
                        Intrinsics.f(b9, "b");
                        return c8.read(b9, i9, i10);
                    }
                });
                this.f46277h = null;
                this.f46276g = 1;
                if (pipelineContext.g(httpResponseContainer2, this) == d8) {
                    return d8;
                }
            }
        }
        return Unit.f50853a;
    }
}
