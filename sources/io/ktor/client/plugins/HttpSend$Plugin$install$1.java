package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpSend.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", l = {104, 105}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class HttpSend$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46385g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f46386h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46387i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ HttpSend f46388j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ HttpClient f46389k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$Plugin$install$1(HttpSend httpSend, HttpClient httpClient, Continuation<? super HttpSend$Plugin$install$1> continuation) {
        super(3, continuation);
        this.f46388j = httpSend;
        this.f46389k = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpSend$Plugin$install$1 httpSend$Plugin$install$1 = new HttpSend$Plugin$install$1(this.f46388j, this.f46389k, continuation);
        httpSend$Plugin$install$1.f46386h = pipelineContext;
        httpSend$Plugin$install$1.f46387i = obj;
        return httpSend$Plugin$install$1.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, io.ktor.client.plugins.HttpSend$DefaultSender] */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, io.ktor.client.plugins.HttpSend$InterceptedSender] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        String h8;
        int i8;
        List list;
        int m8;
        IntProgression l8;
        PipelineContext pipelineContext;
        List list2;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i9 = this.f46385g;
        if (i9 != 0) {
            if (i9 != 1) {
                if (i9 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pipelineContext = (PipelineContext) this.f46386h;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.f46386h;
            Object obj2 = this.f46387i;
            if (obj2 instanceof OutgoingContent) {
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext2.c();
                if (obj2 == null) {
                    httpRequestBuilder.i(NullBody.f46943a);
                    KType i10 = Reflection.i(OutgoingContent.class);
                    httpRequestBuilder.j(TypeInfoJvmKt.b(TypesJVMKt.f(i10), Reflection.b(OutgoingContent.class), i10));
                } else if (obj2 instanceof OutgoingContent) {
                    httpRequestBuilder.i(obj2);
                    httpRequestBuilder.j(null);
                } else {
                    httpRequestBuilder.i(obj2);
                    KType i11 = Reflection.i(OutgoingContent.class);
                    httpRequestBuilder.j(TypeInfoJvmKt.b(TypesJVMKt.f(i11), Reflection.b(OutgoingContent.class), i11));
                }
                i8 = this.f46388j.f46372a;
                ?? defaultSender = new HttpSend.DefaultSender(i8, this.f46389k);
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.f51016f = defaultSender;
                list = this.f46388j.f46373b;
                m8 = CollectionsKt__CollectionsKt.m(list);
                l8 = RangesKt___RangesKt.l(m8, 0);
                HttpSend httpSend = this.f46388j;
                Iterator<Integer> it = l8.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    list2 = httpSend.f46373b;
                    ref$ObjectRef.f51016f = new HttpSend.InterceptedSender((Function3) list2.get(nextInt), (Sender) ref$ObjectRef.f51016f);
                }
                this.f46386h = pipelineContext2;
                this.f46385g = 1;
                Object a8 = ((Sender) ref$ObjectRef.f51016f).a((HttpRequestBuilder) pipelineContext2.c(), this);
                if (a8 == d8) {
                    return d8;
                }
                pipelineContext = pipelineContext2;
                obj = a8;
            } else {
                h8 = StringsKt__IndentKt.h("\n|Fail to prepare request body for sending. \n|The body type is: " + Reflection.b(obj2.getClass()) + ", with Content-Type: " + HttpMessagePropertiesKt.e((HttpMessageBuilder) pipelineContext2.c()) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header.", null, 1, null);
                throw new IllegalStateException(h8.toString());
            }
        }
        this.f46386h = null;
        this.f46385g = 2;
        if (pipelineContext.g((HttpClientCall) obj, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
