package io.ktor.client.plugins.logging;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$logRequestBody$2", f = "Logging.kt", l = {237}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class Logging$logRequestBody$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46543g;

    /* renamed from: h  reason: collision with root package name */
    int f46544h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteChannel f46545i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Charset f46546j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ StringBuilder f46547k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$logRequestBody$2(ByteChannel byteChannel, Charset charset, StringBuilder sb, Continuation<? super Logging$logRequestBody$2> continuation) {
        super(2, continuation);
        this.f46545i = byteChannel;
        this.f46546j = charset;
        this.f46547k = sb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Logging$logRequestBody$2(this.f46545i, this.f46546j, this.f46547k, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Logging$logRequestBody$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Charset charset;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f46544h;
        String str = null;
        try {
            if (i8 != 0) {
                if (i8 == 1) {
                    charset = (Charset) this.f46543g;
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                ByteChannel byteChannel = this.f46545i;
                Charset charset2 = this.f46546j;
                this.f46543g = charset2;
                this.f46544h = 1;
                obj = ByteReadChannel.DefaultImpls.a(byteChannel, 0L, this, 1, null);
                if (obj == d8) {
                    return d8;
                }
                charset = charset2;
            }
            str = StringsKt.e((Input) obj, charset, 0, 2, null);
        } catch (Throwable unused) {
        }
        if (str == null) {
            str = "[request body omitted]";
        }
        StringBuilder sb = this.f46547k;
        sb.append("BODY START");
        Intrinsics.e(sb, "append(value)");
        sb.append('\n');
        Intrinsics.e(sb, "append('\\n')");
        StringBuilder sb2 = this.f46547k;
        sb2.append(str);
        Intrinsics.e(sb2, "append(value)");
        sb2.append('\n');
        Intrinsics.e(sb2, "append('\\n')");
        this.f46547k.append("BODY END");
        return Unit.f50853a;
    }
}
