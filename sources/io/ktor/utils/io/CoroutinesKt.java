package io.ktor.utils.io;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: Coroutines.kt */
/* loaded from: classes5.dex */
public final class CoroutinesKt {
    private static final <S extends CoroutineScope> ChannelJob a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, final ByteChannel byteChannel, boolean z7, Function2<? super S, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Job d8;
        d8 = BuildersKt__Builders_commonKt.d(coroutineScope, coroutineContext, null, new CoroutinesKt$launchChannel$job$1(z7, byteChannel, function2, (CoroutineDispatcher) coroutineScope.j().g(CoroutineDispatcher.f51241g), null), 2, null);
        d8.X(new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.CoroutinesKt$launchChannel$1
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
                ByteChannel.this.b(th);
            }
        });
        return new ChannelJob(d8, byteChannel);
    }

    public static final WriterJob b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z7, Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.f(coroutineScope, "<this>");
        Intrinsics.f(coroutineContext, "coroutineContext");
        Intrinsics.f(block, "block");
        return a(coroutineScope, coroutineContext, ByteChannelKt.a(z7), true, block);
    }

    public static /* synthetic */ WriterJob c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z7, Function2 function2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return b(coroutineScope, coroutineContext, z7, function2);
    }
}
