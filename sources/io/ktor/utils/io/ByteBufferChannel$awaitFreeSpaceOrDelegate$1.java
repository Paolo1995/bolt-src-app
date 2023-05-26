package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1507, 1508}, m = "awaitFreeSpaceOrDelegate")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$awaitFreeSpaceOrDelegate$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47163f;

    /* renamed from: g  reason: collision with root package name */
    Object f47164g;

    /* renamed from: h  reason: collision with root package name */
    int f47165h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f47166i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47167j;

    /* renamed from: k  reason: collision with root package name */
    int f47168k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$awaitFreeSpaceOrDelegate$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$awaitFreeSpaceOrDelegate$1> continuation) {
        super(continuation);
        this.f47167j = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object L;
        this.f47166i = obj;
        this.f47168k |= Integer.MIN_VALUE;
        L = this.f47167j.L(0, null, this);
        return L;
    }
}
