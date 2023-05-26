package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultResponseValidation.kt */
/* loaded from: classes5.dex */
public final class DefaultResponseValidationKt {

    /* renamed from: a  reason: collision with root package name */
    private static final AttributeKey<Unit> f46250a = new AttributeKey<>("ValidateMark");

    public static final void b(final HttpClientConfig<?> httpClientConfig) {
        Intrinsics.f(httpClientConfig, "<this>");
        HttpCallValidatorKt.b(httpClientConfig, new Function1<HttpCallValidator.Config, Unit>() { // from class: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DefaultResponseValidation.kt */
            @DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", l = {39, 45}, m = "invokeSuspend")
            /* renamed from: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {

                /* renamed from: g  reason: collision with root package name */
                int f46252g;

                /* renamed from: h  reason: collision with root package name */
                int f46253h;

                /* renamed from: i  reason: collision with root package name */
                /* synthetic */ Object f46254i;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.f46254i = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: h */
                public final Object s(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(httpResponse, continuation)).invokeSuspend(Unit.f50853a);
                }

                /* JADX WARN: Can't wrap try/catch for region: R(6:1|(1:(1:(7:5|6|7|8|9|(1:34)(1:12)|(3:14|(1:31)(1:17)|(2:(1:28)|(2:23|24)(2:26|27))(2:29|30))(2:32|33))(2:38|39))(1:40))(2:49|(2:51|52)(4:53|(2:55|(2:57|(1:59)))|60|61))|41|42|43|(1:45)(6:46|8|9|(0)|34|(0)(0))) */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
                    r0 = r1;
                    r1 = r9;
                 */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[ADDED_TO_REGION] */
                /* JADX WARN: Removed duplicated region for block: B:39:0x00ab  */
                /* JADX WARN: Removed duplicated region for block: B:57:0x00d2  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                    /*
                        Method dump skipped, instructions count: 219
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(HttpCallValidator.Config HttpResponseValidator) {
                Intrinsics.f(HttpResponseValidator, "$this$HttpResponseValidator");
                HttpResponseValidator.d(httpClientConfig.c());
                HttpResponseValidator.e(new AnonymousClass1(null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpCallValidator.Config config) {
                b(config);
                return Unit.f50853a;
            }
        });
    }
}
