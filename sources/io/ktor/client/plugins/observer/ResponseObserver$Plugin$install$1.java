package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.ByteChannelsKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResponseObserver.kt */
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1", f = "ResponseObserver.kt", l = {68, 80}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ResponseObserver$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46593g;

    /* renamed from: h  reason: collision with root package name */
    Object f46594h;

    /* renamed from: i  reason: collision with root package name */
    int f46595i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f46596j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f46597k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ ResponseObserver f46598l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ HttpClient f46599m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResponseObserver.kt */
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1", f = "ResponseObserver.kt", l = {70, 76}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f46600g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ResponseObserver f46601h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ HttpResponse f46602i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ResponseObserver responseObserver, HttpResponse httpResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.f46601h = responseObserver;
            this.f46602i = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.f46601h, this.f46602i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            Function2 function2;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f46600g;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 == 2) {
                        ResultKt.b(obj);
                        return Unit.f50853a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            } else {
                ResultKt.b(obj);
                function2 = this.f46601h.f46588a;
                HttpResponse httpResponse = this.f46602i;
                this.f46600g = 1;
                if (function2.s(httpResponse, this) == d8) {
                    return d8;
                }
            }
            ByteReadChannel a8 = this.f46602i.a();
            if (!a8.o()) {
                this.f46600g = 2;
                if (ByteReadChannelKt.b(a8, this) == d8) {
                    return d8;
                }
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseObserver$Plugin$install$1(ResponseObserver responseObserver, HttpClient httpClient, Continuation<? super ResponseObserver$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46598l = responseObserver;
        this.f46599m = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        ResponseObserver$Plugin$install$1 responseObserver$Plugin$install$1 = new ResponseObserver$Plugin$install$1(this.f46598l, this.f46599m, continuation);
        responseObserver$Plugin$install$1.f46596j = pipelineContext;
        responseObserver$Plugin$install$1.f46597k = httpResponse;
        return responseObserver$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [kotlinx.coroutines.CoroutineScope] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Function1 function1;
        HttpResponse httpResponse;
        PipelineContext pipelineContext;
        HttpResponse httpResponse2;
        HttpClient httpClient;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46595i;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            HttpResponse httpResponse3 = (HttpResponse) this.f46593g;
            ResultKt.b(obj);
            httpResponse = (HttpResponse) this.f46597k;
            pipelineContext = (PipelineContext) this.f46596j;
            httpClient = (CoroutineScope) this.f46594h;
            httpResponse2 = httpResponse3;
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.f46596j;
            HttpResponse httpResponse4 = (HttpResponse) this.f46597k;
            function1 = this.f46598l.f46589b;
            boolean z7 = false;
            if (function1 != null && !((Boolean) function1.invoke(httpResponse4.Y())).booleanValue()) {
                z7 = true;
            }
            if (z7) {
                return Unit.f50853a;
            }
            Pair<ByteReadChannel, ByteReadChannel> b8 = ByteChannelsKt.b(httpResponse4.a(), httpResponse4);
            HttpResponse f8 = DelegatedCallKt.a(httpResponse4.Y(), b8.b()).f();
            HttpResponse f9 = DelegatedCallKt.a(httpResponse4.Y(), b8.a()).f();
            HttpClient httpClient2 = this.f46599m;
            this.f46596j = pipelineContext2;
            this.f46597k = f8;
            this.f46593g = f9;
            this.f46594h = httpClient2;
            this.f46595i = 1;
            Object a8 = ResponseObserverContextJvmKt.a(this);
            if (a8 == d8) {
                return d8;
            }
            httpResponse = f8;
            pipelineContext = pipelineContext2;
            httpResponse2 = f9;
            obj = a8;
            httpClient = httpClient2;
        }
        BuildersKt__Builders_commonKt.d(httpClient, (CoroutineContext) obj, null, new AnonymousClass1(this.f46598l, httpResponse2, null), 2, null);
        this.f46596j = null;
        this.f46597k = null;
        this.f46593g = null;
        this.f46594h = null;
        this.f46595i = 2;
        if (pipelineContext.g(httpResponse, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
