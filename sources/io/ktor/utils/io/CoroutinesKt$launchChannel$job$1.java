package io.ktor.utils.io;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Coroutines.kt */
@DebugMetadata(c = "io.ktor.utils.io.CoroutinesKt$launchChannel$job$1", f = "Coroutines.kt", l = {134}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CoroutinesKt$launchChannel$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f47348g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f47349h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ boolean f47350i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ByteChannel f47351j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Function2<S, Continuation<? super Unit>, Object> f47352k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ CoroutineDispatcher f47353l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesKt$launchChannel$job$1(boolean z7, ByteChannel byteChannel, Function2<? super S, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineDispatcher coroutineDispatcher, Continuation<? super CoroutinesKt$launchChannel$job$1> continuation) {
        super(2, continuation);
        this.f47350i = z7;
        this.f47351j = byteChannel;
        this.f47352k = function2;
        this.f47353l = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutinesKt$launchChannel$job$1 coroutinesKt$launchChannel$job$1 = new CoroutinesKt$launchChannel$job$1(this.f47350i, this.f47351j, this.f47352k, this.f47353l, continuation);
        coroutinesKt$launchChannel$job$1.f47349h = obj;
        return coroutinesKt$launchChannel$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutinesKt$launchChannel$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f47348g;
        try {
            if (i8 != 0) {
                if (i8 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f47349h;
                if (this.f47350i) {
                    ByteChannel byteChannel = this.f47351j;
                    CoroutineContext.Element g8 = coroutineScope.j().g(Job.f51296d);
                    Intrinsics.c(g8);
                    byteChannel.j((Job) g8);
                }
                ChannelScope channelScope = new ChannelScope(coroutineScope, this.f47351j);
                Function2<S, Continuation<? super Unit>, Object> function2 = this.f47352k;
                this.f47348g = 1;
                if (function2.s(channelScope, this) == d8) {
                    return d8;
                }
            }
        } catch (Throwable th) {
            if (!Intrinsics.a(this.f47353l, Dispatchers.d()) && this.f47353l != null) {
                throw th;
            }
            this.f47351j.h(th);
        }
        return Unit.f50853a;
    }
}
