package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannels.kt */
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", l = {24, 28}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ByteChannelsKt$split$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f47012g;

    /* renamed from: h  reason: collision with root package name */
    int f47013h;

    /* renamed from: i  reason: collision with root package name */
    int f47014i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f47015j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ByteReadChannel f47016k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ ByteChannel f47017l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ ByteChannel f47018m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$split$1(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation<? super ByteChannelsKt$split$1> continuation) {
        super(2, continuation);
        this.f47016k = byteReadChannel;
        this.f47017l = byteChannel;
        this.f47018m = byteChannel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ByteChannelsKt$split$1 byteChannelsKt$split$1 = new ByteChannelsKt$split$1(this.f47016k, this.f47017l, this.f47018m, continuation);
        byteChannelsKt$split$1.f47015j = obj;
        return byteChannelsKt$split$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$split$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d A[Catch: all -> 0x00dc, TryCatch #8 {all -> 0x00dc, blocks: (B:19:0x0045, B:21:0x004d, B:24:0x005e, B:46:0x00c8, B:49:0x00db, B:43:0x00c5, B:38:0x00bc), top: B:70:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8 A[Catch: all -> 0x00dc, TRY_LEAVE, TryCatch #8 {all -> 0x00dc, blocks: (B:19:0x0045, B:21:0x004d, B:24:0x005e, B:46:0x00c8, B:49:0x00db, B:43:0x00c5, B:38:0x00bc), top: B:70:0x0045 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a4 -> B:64:0x00aa). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$split$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
