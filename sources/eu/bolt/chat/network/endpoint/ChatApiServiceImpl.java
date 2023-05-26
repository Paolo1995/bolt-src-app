package eu.bolt.chat.network.endpoint;

import eu.bolt.chat.data.util.MessageDirectionDetector;
import io.ktor.client.HttpClient;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatApiServiceImpl.kt */
/* loaded from: classes5.dex */
public final class ChatApiServiceImpl implements ChatApiService {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f39348d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final MessageDirectionDetector f39349a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpClient f39350b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatApiPathResolver f39351c;

    /* compiled from: ChatApiServiceImpl.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChatApiServiceImpl(MessageDirectionDetector messageDirectionDetector, HttpClient httpClient, ChatApiPathResolver pathResolver) {
        Intrinsics.f(messageDirectionDetector, "messageDirectionDetector");
        Intrinsics.f(httpClient, "httpClient");
        Intrinsics.f(pathResolver, "pathResolver");
        this.f39349a = messageDirectionDetector;
        this.f39350b = httpClient;
        this.f39351c = pathResolver;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093 A[Catch: JsonConvertException -> 0x0037, TRY_ENTER, TryCatch #0 {JsonConvertException -> 0x0037, blocks: (B:13:0x0032, B:31:0x00c3, B:33:0x00cf, B:34:0x00d6, B:26:0x0093), top: B:38:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3 A[Catch: JsonConvertException -> 0x0037, TRY_LEAVE, TryCatch #0 {JsonConvertException -> 0x0037, blocks: (B:13:0x0032, B:31:0x00c3, B:33:0x00cf, B:34:0x00d6, B:26:0x0093), top: B:38:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf A[Catch: JsonConvertException -> 0x0037, TRY_ENTER, TryCatch #0 {JsonConvertException -> 0x0037, blocks: (B:13:0x0032, B:31:0x00c3, B:33:0x00cf, B:34:0x00d6, B:26:0x0093), top: B:38:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f8  */
    @Override // eu.bolt.chat.network.endpoint.ChatApiService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(final java.lang.String r8, kotlin.coroutines.Continuation<? super eu.bolt.chat.util.Outcome<eu.bolt.chat.data.ChatHistory, eu.bolt.chat.network.endpoint.EndpointError>> r9) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.endpoint.ChatApiServiceImpl.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(2:11|(3:13|14|15)(2:17|18))(2:19|20))(1:21))(2:30|(1:32))|22|(3:24|(1:26)|(0)(0))(3:27|28|29)))|35|6|7|(0)(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b7, code lost:
        r0 = new eu.bolt.chat.util.Outcome.Failure(new eu.bolt.chat.network.endpoint.EndpointError.InvalidResponse("Invalid server response -> " + r8.getMessage()));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[Catch: JsonConvertException -> 0x002e, TRY_ENTER, TryCatch #0 {JsonConvertException -> 0x002e, blocks: (B:12:0x002a, B:28:0x00a3, B:30:0x00af, B:31:0x00b6, B:24:0x0078), top: B:36:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3 A[Catch: JsonConvertException -> 0x002e, TRY_LEAVE, TryCatch #0 {JsonConvertException -> 0x002e, blocks: (B:12:0x002a, B:28:0x00a3, B:30:0x00af, B:31:0x00b6, B:24:0x0078), top: B:36:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af A[Catch: JsonConvertException -> 0x002e, TRY_ENTER, TryCatch #0 {JsonConvertException -> 0x002e, blocks: (B:12:0x002a, B:28:0x00a3, B:30:0x00af, B:31:0x00b6, B:24:0x0078), top: B:36:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    @Override // eu.bolt.chat.network.endpoint.ChatApiService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(kotlin.coroutines.Continuation<? super eu.bolt.chat.util.Outcome<java.util.List<eu.bolt.chat.data.Chat>, eu.bolt.chat.network.endpoint.EndpointError>> r8) {
        /*
            r7 = this;
            java.lang.Class<eu.bolt.chat.network.data.ServerResponse> r0 = eu.bolt.chat.network.data.ServerResponse.class
            boolean r1 = r8 instanceof eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$1
            if (r1 == 0) goto L15
            r1 = r8
            eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$1 r1 = (eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$1) r1
            int r2 = r1.f39356h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f39356h = r2
            goto L1a
        L15:
            eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$1 r1 = new eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$1
            r1.<init>(r7, r8)
        L1a:
            java.lang.Object r8 = r1.f39354f
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r3 = r1.f39356h
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L3d
            if (r3 == r5) goto L39
            if (r3 != r4) goto L31
            kotlin.ResultKt.b(r8)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            goto La1
        L2e:
            r8 = move-exception
            goto Lb7
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            kotlin.ResultKt.b(r8)
            goto L66
        L3d:
            kotlin.ResultKt.b(r8)
            io.ktor.client.HttpClient r8 = r7.f39350b
            io.ktor.client.request.HttpRequestBuilder r3 = new io.ktor.client.request.HttpRequestBuilder
            r3.<init>()
            eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$response$1$1 r6 = new eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$response$1$1
            r6.<init>()
            r3.p(r6)
            io.ktor.http.HttpMethod$Companion r6 = io.ktor.http.HttpMethod.f46834b
            io.ktor.http.HttpMethod r6 = r6.a()
            r3.m(r6)
            io.ktor.client.statement.HttpStatement r6 = new io.ktor.client.statement.HttpStatement
            r6.<init>(r3, r8)
            r1.f39356h = r5
            java.lang.Object r8 = r6.c(r1)
            if (r8 != r2) goto L66
            return r2
        L66:
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            io.ktor.http.HttpStatusCode r3 = r8.e()
            io.ktor.http.HttpStatusCode$Companion r5 = io.ktor.http.HttpStatusCode.f46855c
            io.ktor.http.HttpStatusCode r5 = r5.A()
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r5)
            if (r3 == 0) goto Ld7
            io.ktor.client.call.HttpClientCall r8 = r8.Y()     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            kotlin.reflect.KTypeProjection$Companion r3 = kotlin.reflect.KTypeProjection.f51072c     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            java.lang.Class<eu.bolt.chat.network.data.ActiveChatListNet> r5 = eu.bolt.chat.network.data.ActiveChatListNet.class
            kotlin.reflect.KType r5 = kotlin.jvm.internal.Reflection.i(r5)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            kotlin.reflect.KTypeProjection r3 = r3.a(r5)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.j(r0, r3)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.f(r3)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.b(r0)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            io.ktor.util.reflect.TypeInfo r0 = io.ktor.util.reflect.TypeInfoJvmKt.b(r5, r0, r3)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            r1.f39356h = r4     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            java.lang.Object r8 = r8.a(r0, r1)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            if (r8 != r2) goto La1
            return r2
        La1:
            if (r8 == 0) goto Laf
            eu.bolt.chat.network.data.ServerResponse r8 = (eu.bolt.chat.network.data.ServerResponse) r8     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$$inlined$process$1 r0 = new eu.bolt.chat.network.endpoint.ChatApiServiceImpl$getActiveChats$$inlined$process$1
            r0.<init>()
            eu.bolt.chat.util.Outcome r8 = eu.bolt.chat.network.endpoint.ServerResponseMapperKt.a(r8, r0)
            goto Le7
        Laf:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            java.lang.String r0 = "null cannot be cast to non-null type eu.bolt.chat.network.data.ServerResponse<ServerModel>"
            r8.<init>(r0)     // Catch: io.ktor.serialization.JsonConvertException -> L2e
            throw r8     // Catch: io.ktor.serialization.JsonConvertException -> L2e
        Lb7:
            eu.bolt.chat.util.Outcome$Failure r0 = new eu.bolt.chat.util.Outcome$Failure
            eu.bolt.chat.network.endpoint.EndpointError$InvalidResponse r1 = new eu.bolt.chat.network.endpoint.EndpointError$InvalidResponse
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid server response -> "
            r2.append(r3)
            java.lang.String r8 = r8.getMessage()
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8)
            r0.<init>(r1)
            goto Le6
        Ld7:
            eu.bolt.chat.util.Outcome$Failure r0 = new eu.bolt.chat.util.Outcome$Failure
            eu.bolt.chat.network.endpoint.EndpointError$Companion r1 = eu.bolt.chat.network.endpoint.EndpointError.f39364a
            io.ktor.http.HttpStatusCode r8 = r8.e()
            eu.bolt.chat.network.endpoint.EndpointError r8 = r1.b(r8)
            r0.<init>(r8)
        Le6:
            r8 = r0
        Le7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.network.endpoint.ChatApiServiceImpl.b(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
