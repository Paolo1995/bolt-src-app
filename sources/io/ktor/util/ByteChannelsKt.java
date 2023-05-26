package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: ByteChannels.kt */
/* loaded from: classes5.dex */
public final class ByteChannelsKt {
    public static final void a(ByteReadChannel byteReadChannel, final ByteWriteChannel first, final ByteWriteChannel second) {
        Job d8;
        Intrinsics.f(byteReadChannel, "<this>");
        Intrinsics.f(first, "first");
        Intrinsics.f(second, "second");
        d8 = BuildersKt__Builders_commonKt.d(GlobalScope.f51286f, Dispatchers.d(), null, new ByteChannelsKt$copyToBoth$1(byteReadChannel, first, second, null), 2, null);
        d8.X(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt$copyToBoth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (th == null) {
                    return;
                }
                ByteWriteChannel.this.b(th);
                second.b(th);
            }
        });
    }

    public static final Pair<ByteReadChannel, ByteReadChannel> b(ByteReadChannel byteReadChannel, CoroutineScope coroutineScope) {
        Job d8;
        Intrinsics.f(byteReadChannel, "<this>");
        Intrinsics.f(coroutineScope, "coroutineScope");
        final ByteChannel a8 = ByteChannelKt.a(true);
        final ByteChannel a9 = ByteChannelKt.a(true);
        d8 = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ByteChannelsKt$split$1(byteReadChannel, a8, a9, null), 3, null);
        d8.X(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt$split$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (th == null) {
                    return;
                }
                ByteChannel.this.h(th);
                a9.h(th);
            }
        });
        return TuplesKt.a(a8, a9);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(io.ktor.utils.io.ByteReadChannel r8, kotlin.coroutines.Continuation<? super byte[]> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.util.ByteChannelsKt$toByteArray$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = (io.ktor.util.ByteChannelsKt$toByteArray$1) r0
            int r1 = r0.f47028g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47028g = r1
            goto L18
        L13:
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = new io.ktor.util.ByteChannelsKt$toByteArray$1
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.f47027f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r1 = r4.f47028g
            r7 = 1
            if (r1 == 0) goto L32
            if (r1 != r7) goto L2a
            kotlin.ResultKt.b(r9)
            goto L43
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            kotlin.ResultKt.b(r9)
            r2 = 0
            r5 = 1
            r6 = 0
            r4.f47028g = r7
            r1 = r8
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.a(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L43
            return r0
        L43:
            io.ktor.utils.io.core.ByteReadPacket r9 = (io.ktor.utils.io.core.ByteReadPacket) r9
            r8 = 0
            r0 = 0
            byte[] r8 = io.ktor.utils.io.core.StringsKt.c(r9, r8, r7, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.c(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
