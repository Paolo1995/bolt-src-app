package io.ktor.client.engine.okhttp;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: OkUtils.kt */
/* loaded from: classes5.dex */
public final class OkUtilsKt {

    /* compiled from: OkUtils.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46221a;

        static {
            int[] iArr = new int[Protocol.values().length];
            iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            iArr[Protocol.HTTP_1_1.ordinal()] = 2;
            iArr[Protocol.SPDY_3.ordinal()] = 3;
            iArr[Protocol.HTTP_2.ordinal()] = 4;
            iArr[Protocol.H2_PRIOR_KNOWLEDGE.ordinal()] = 5;
            iArr[Protocol.QUIC.ordinal()] = 6;
            f46221a = iArr;
        }
    }

    public static final Object b(OkHttpClient okHttpClient, Request request, HttpRequestData httpRequestData, Continuation<? super Response> continuation) {
        Continuation c8;
        Object d8;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        final Call newCall = okHttpClient.newCall(request);
        FirebasePerfOkHttpClient.enqueue(newCall, new OkHttpCallback(httpRequestData, cancellableContinuationImpl));
        cancellableContinuationImpl.o(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.okhttp.OkUtilsKt$execute$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Call.this.cancel();
            }
        });
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        return v7;
    }

    public static final Headers c(final okhttp3.Headers headers) {
        Intrinsics.f(headers, "<this>");
        return new Headers() { // from class: io.ktor.client.engine.okhttp.OkUtilsKt$fromOkHttp$1

            /* renamed from: c  reason: collision with root package name */
            private final boolean f46223c = true;

            @Override // io.ktor.util.StringValues
            public Set<Map.Entry<String, List<String>>> a() {
                return okhttp3.Headers.this.toMultimap().entrySet();
            }

            @Override // io.ktor.util.StringValues
            public boolean b() {
                return this.f46223c;
            }

            @Override // io.ktor.util.StringValues
            public List<String> c(String name) {
                Intrinsics.f(name, "name");
                List<String> values = okhttp3.Headers.this.values(name);
                if (!(!values.isEmpty())) {
                    return null;
                }
                return values;
            }

            @Override // io.ktor.util.StringValues
            public void d(Function2<? super String, ? super List<String>, Unit> function2) {
                Headers.DefaultImpls.a(this, function2);
            }

            @Override // io.ktor.util.StringValues
            public String get(String str) {
                return Headers.DefaultImpls.b(this, str);
            }

            @Override // io.ktor.util.StringValues
            public Set<String> names() {
                return okhttp3.Headers.this.names();
            }
        };
    }

    public static final HttpProtocolVersion d(Protocol protocol) {
        Intrinsics.f(protocol, "<this>");
        switch (WhenMappings.f46221a[protocol.ordinal()]) {
            case 1:
                return HttpProtocolVersion.f46844d.a();
            case 2:
                return HttpProtocolVersion.f46844d.b();
            case 3:
                return HttpProtocolVersion.f46844d.e();
            case 4:
                return HttpProtocolVersion.f46844d.c();
            case 5:
                return HttpProtocolVersion.f46844d.c();
            case 6:
                return HttpProtocolVersion.f46844d.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean e(IOException iOException) {
        boolean O;
        String message = iOException.getMessage();
        if (message == null) {
            return false;
        }
        O = StringsKt__StringsKt.O(message, "connect", true);
        if (!O) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable f(HttpRequestData httpRequestData, IOException iOException) {
        Throwable b8;
        Throwable g8 = g(iOException);
        if (g8 instanceof SocketTimeoutException) {
            if (e((IOException) g8)) {
                b8 = HttpTimeoutKt.a(httpRequestData, g8);
            } else {
                b8 = HttpTimeoutKt.b(httpRequestData, g8);
            }
            return b8;
        }
        return g8;
    }

    private static final Throwable g(IOException iOException) {
        boolean z7;
        Throwable[] suppressed = iOException.getSuppressed();
        Intrinsics.e(suppressed, "suppressed");
        if (suppressed.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            Throwable th = iOException.getSuppressed()[0];
            Intrinsics.e(th, "suppressed[0]");
            return th;
        }
        return iOException;
    }
}
