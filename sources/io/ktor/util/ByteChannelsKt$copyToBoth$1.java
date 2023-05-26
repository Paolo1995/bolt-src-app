package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannels.kt */
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", l = {58, 60, 61}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ByteChannelsKt$copyToBoth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f46999g;

    /* renamed from: h  reason: collision with root package name */
    Object f47000h;

    /* renamed from: i  reason: collision with root package name */
    Object f47001i;

    /* renamed from: j  reason: collision with root package name */
    Object f47002j;

    /* renamed from: k  reason: collision with root package name */
    Object f47003k;

    /* renamed from: l  reason: collision with root package name */
    int f47004l;

    /* renamed from: m  reason: collision with root package name */
    int f47005m;

    /* renamed from: n  reason: collision with root package name */
    private /* synthetic */ Object f47006n;

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ ByteReadChannel f47007o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ ByteWriteChannel f47008p;

    /* renamed from: q  reason: collision with root package name */
    final /* synthetic */ ByteWriteChannel f47009q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$copyToBoth$1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super ByteChannelsKt$copyToBoth$1> continuation) {
        super(2, continuation);
        this.f47007o = byteReadChannel;
        this.f47008p = byteWriteChannel;
        this.f47009q = byteWriteChannel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ByteChannelsKt$copyToBoth$1 byteChannelsKt$copyToBoth$1 = new ByteChannelsKt$copyToBoth$1(this.f47007o, this.f47008p, this.f47009q, continuation);
        byteChannelsKt$copyToBoth$1.f47006n = obj;
        return byteChannelsKt$copyToBoth$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$copyToBoth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:(1:(11:6|7|8|9|10|11|12|13|14|15|(5:40|(1:45)|46|47|48)(2:21|(1:23)(21:25|26|27|28|29|30|(1:32)|33|(1:35)|10|11|12|13|14|15|(2:17|19)|40|(2:42|45)|46|47|48)))(2:68|69))(18:70|71|72|73|33|(0)|10|11|12|13|14|15|(0)|40|(0)|46|47|48)|59|60|61|13|14|15|(0)|40|(0)|46|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013e, code lost:
        r15 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087 A[Catch: all -> 0x013e, TryCatch #9 {all -> 0x013e, blocks: (B:50:0x0110, B:25:0x007f, B:27:0x0087, B:29:0x008f, B:31:0x0097, B:35:0x00b2, B:62:0x0125, B:64:0x0129, B:67:0x0132, B:59:0x0122, B:55:0x011a), top: B:89:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0129 A[Catch: all -> 0x013e, TryCatch #9 {all -> 0x013e, blocks: (B:50:0x0110, B:25:0x007f, B:27:0x0087, B:29:0x008f, B:31:0x0097, B:35:0x00b2, B:62:0x0125, B:64:0x0129, B:67:0x0132, B:59:0x0122, B:55:0x011a), top: B:89:0x0110 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f2 -> B:83:0x00f5). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$copyToBoth$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
