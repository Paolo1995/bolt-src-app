package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteBufferChannel.kt */
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1195, 1266, 1274}, m = "copyDirect$ktor_io")
/* loaded from: classes5.dex */
public final class ByteBufferChannel$copyDirect$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47169f;

    /* renamed from: g  reason: collision with root package name */
    Object f47170g;

    /* renamed from: h  reason: collision with root package name */
    Object f47171h;

    /* renamed from: i  reason: collision with root package name */
    Object f47172i;

    /* renamed from: j  reason: collision with root package name */
    Object f47173j;

    /* renamed from: k  reason: collision with root package name */
    Object f47174k;

    /* renamed from: l  reason: collision with root package name */
    Object f47175l;

    /* renamed from: m  reason: collision with root package name */
    Object f47176m;

    /* renamed from: n  reason: collision with root package name */
    Object f47177n;

    /* renamed from: o  reason: collision with root package name */
    Object f47178o;

    /* renamed from: p  reason: collision with root package name */
    long f47179p;

    /* renamed from: q  reason: collision with root package name */
    long f47180q;

    /* renamed from: r  reason: collision with root package name */
    boolean f47181r;

    /* renamed from: s  reason: collision with root package name */
    /* synthetic */ Object f47182s;

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ ByteBufferChannel f47183t;

    /* renamed from: u  reason: collision with root package name */
    int f47184u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$copyDirect$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$copyDirect$1> continuation) {
        super(continuation);
        this.f47183t = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47182s = obj;
        this.f47184u |= Integer.MIN_VALUE;
        return this.f47183t.P(null, 0L, null, this);
    }
}
