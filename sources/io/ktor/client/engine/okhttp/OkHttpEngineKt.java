package io.ktor.client.engine.okhttp;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;

/* compiled from: OkHttpEngine.kt */
/* loaded from: classes5.dex */
public final class OkHttpEngineKt {
    public static final /* synthetic */ Throwable b(Throwable th, HttpRequestData httpRequestData) {
        return g(th, httpRequestData);
    }

    public static final RequestBody e(final OutgoingContent outgoingContent, final CoroutineContext callContext) {
        Intrinsics.f(outgoingContent, "<this>");
        Intrinsics.f(callContext, "callContext");
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] e8 = ((OutgoingContent.ByteArrayContent) outgoingContent).e();
            return RequestBody.Companion.create(e8, (MediaType) null, 0, e8.length);
        } else if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(outgoingContent.a(), new Function0<ByteReadChannel>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final ByteReadChannel invoke() {
                    return ((OutgoingContent.ReadChannelContent) OutgoingContent.this).e();
                }
            });
        } else {
            if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
                return new StreamRequestBody(outgoingContent.a(), new Function0<ByteReadChannel>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: OkHttpEngine.kt */
                    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1", f = "OkHttpEngine.kt", l = {211}, m = "invokeSuspend")
                    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1  reason: invalid class name */
                    /* loaded from: classes5.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

                        /* renamed from: g  reason: collision with root package name */
                        int f46189g;

                        /* renamed from: h  reason: collision with root package name */
                        private /* synthetic */ Object f46190h;

                        /* renamed from: i  reason: collision with root package name */
                        final /* synthetic */ OutgoingContent f46191i;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(OutgoingContent outgoingContent, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.f46191i = outgoingContent;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f46191i, continuation);
                            anonymousClass1.f46190h = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        /* renamed from: h */
                        public final Object s(WriterScope writerScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.f50853a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object d8;
                            d8 = IntrinsicsKt__IntrinsicsKt.d();
                            int i8 = this.f46189g;
                            if (i8 != 0) {
                                if (i8 == 1) {
                                    ResultKt.b(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.b(obj);
                                ByteWriteChannel channel = ((WriterScope) this.f46190h).getChannel();
                                this.f46189g = 1;
                                if (((OutgoingContent.WriteChannelContent) this.f46191i).e(channel, this) == d8) {
                                    return d8;
                                }
                            }
                            return Unit.f50853a;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* renamed from: b */
                    public final ByteReadChannel invoke() {
                        return CoroutinesKt.c(GlobalScope.f51286f, CoroutineContext.this, false, new AnonymousClass1(outgoingContent, null), 2, null).getChannel();
                    }
                });
            }
            if (outgoingContent instanceof OutgoingContent.NoContent) {
                return RequestBody.Companion.create(new byte[0], (MediaType) null, 0, 0);
            }
            throw new UnsupportedContentTypeException(outgoingContent);
        }
    }

    public static final Request f(HttpRequestData httpRequestData, CoroutineContext coroutineContext) {
        RequestBody requestBody;
        final Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.h().toString());
        UtilsKt.d(httpRequestData.e(), httpRequestData.b(), new Function2<String, String, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpRequest$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void b(String key, String value) {
                Intrinsics.f(key, "key");
                Intrinsics.f(value, "value");
                if (Intrinsics.a(key, HttpHeaders.f46782a.h())) {
                    return;
                }
                Request.Builder.this.addHeader(key, value);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(String str, String str2) {
                b(str, str2);
                return Unit.f50853a;
            }
        });
        if (HttpMethod.permitsRequestBody(httpRequestData.f().c())) {
            requestBody = e(httpRequestData.b(), coroutineContext);
        } else {
            requestBody = null;
        }
        builder.method(httpRequestData.f().c(), requestBody);
        return builder.build();
    }

    public static final Throwable g(Throwable th, HttpRequestData httpRequestData) {
        if (th instanceof SocketTimeoutException) {
            return HttpTimeoutKt.b(httpRequestData, th);
        }
        return th;
    }

    public static final OkHttpClient.Builder h(OkHttpClient.Builder builder, HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        Long c8 = httpTimeoutCapabilityConfiguration.c();
        if (c8 != null) {
            builder.connectTimeout(HttpTimeoutKt.c(c8.longValue()), TimeUnit.MILLISECONDS);
        }
        Long e8 = httpTimeoutCapabilityConfiguration.e();
        if (e8 != null) {
            long longValue = e8.longValue();
            long c9 = HttpTimeoutKt.c(longValue);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder.readTimeout(c9, timeUnit);
            builder.writeTimeout(HttpTimeoutKt.c(longValue), timeUnit);
        }
        return builder;
    }

    public static final ByteReadChannel i(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        return CoroutinesKt.c(GlobalScope.f51286f, coroutineContext, false, new OkHttpEngineKt$toChannel$1(bufferedSource, coroutineContext, httpRequestData, null), 2, null).getChannel();
    }
}
