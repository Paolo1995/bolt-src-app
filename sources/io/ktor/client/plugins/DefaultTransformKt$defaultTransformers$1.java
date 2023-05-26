package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultTransform.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", l = {53}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46255g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46256h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46257i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultTransformKt$defaultTransformers$1(Continuation<? super DefaultTransformKt$defaultTransformers$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(continuation);
        defaultTransformKt$defaultTransformers$1.f46256h = pipelineContext;
        defaultTransformKt$defaultTransformers$1.f46257i = obj;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        OutgoingContent a8;
        ContentType contentType;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46255g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            final PipelineContext pipelineContext = (PipelineContext) this.f46256h;
            final Object obj2 = this.f46257i;
            HeadersBuilder headers = ((HttpRequestBuilder) pipelineContext.c()).getHeaders();
            HttpHeaders httpHeaders = HttpHeaders.f46782a;
            if (headers.j(httpHeaders.c()) == null) {
                ((HttpRequestBuilder) pipelineContext.c()).getHeaders().f(httpHeaders.c(), "*/*");
            }
            final ContentType e8 = HttpMessagePropertiesKt.e((HttpMessageBuilder) pipelineContext.c());
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (e8 == null) {
                    e8 = ContentType.Text.f46754a.a();
                }
                a8 = new TextContent(str, e8, null, 4, null);
            } else if (obj2 instanceof byte[]) {
                a8 = new OutgoingContent.ByteArrayContent(e8, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1

                    /* renamed from: a  reason: collision with root package name */
                    private final ContentType f46258a;

                    /* renamed from: b  reason: collision with root package name */
                    private final long f46259b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ Object f46260c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f46260c = obj2;
                        this.f46258a = e8 == null ? ContentType.Application.f46731a.b() : e8;
                        this.f46259b = ((byte[]) obj2).length;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public Long a() {
                        return Long.valueOf(this.f46259b);
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public ContentType b() {
                        return this.f46258a;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                    public byte[] e() {
                        return (byte[]) this.f46260c;
                    }
                };
            } else if (obj2 instanceof ByteReadChannel) {
                a8 = new OutgoingContent.ReadChannelContent(pipelineContext, e8, obj2) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2

                    /* renamed from: a  reason: collision with root package name */
                    private final Long f46261a;

                    /* renamed from: b  reason: collision with root package name */
                    private final ContentType f46262b;

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ Object f46263c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        Long l8;
                        this.f46263c = obj2;
                        String j8 = pipelineContext.c().getHeaders().j(HttpHeaders.f46782a.h());
                        if (j8 != null) {
                            l8 = Long.valueOf(Long.parseLong(j8));
                        } else {
                            l8 = null;
                        }
                        this.f46261a = l8;
                        this.f46262b = e8 == null ? ContentType.Application.f46731a.b() : e8;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public Long a() {
                        return this.f46261a;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public ContentType b() {
                        return this.f46262b;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                    public ByteReadChannel e() {
                        return (ByteReadChannel) this.f46263c;
                    }
                };
            } else if (obj2 instanceof OutgoingContent) {
                a8 = (OutgoingContent) obj2;
            } else {
                a8 = DefaultTransformersJvmKt.a(e8, (HttpRequestBuilder) pipelineContext.c(), obj2);
            }
            if (a8 != null) {
                contentType = a8.b();
            } else {
                contentType = null;
            }
            if (contentType != null) {
                ((HttpRequestBuilder) pipelineContext.c()).getHeaders().l(httpHeaders.i());
                this.f46256h = null;
                this.f46255g = 1;
                if (pipelineContext.g(a8, this) == d8) {
                    return d8;
                }
            }
        }
        return Unit.f50853a;
    }
}
