package io.ktor.serialization.kotlinx;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinxSerializationBase.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationBase", f = "KotlinxSerializationBase.kt", l = {23, 36}, m = "serialize$ktor_serialization_kotlinx")
/* loaded from: classes5.dex */
public final class KotlinxSerializationBase$serialize$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46971f;

    /* renamed from: g  reason: collision with root package name */
    Object f46972g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46973h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ KotlinxSerializationBase<T> f46974i;

    /* renamed from: j  reason: collision with root package name */
    int f46975j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationBase$serialize$1(KotlinxSerializationBase<T> kotlinxSerializationBase, Continuation<? super KotlinxSerializationBase$serialize$1> continuation) {
        super(continuation);
        this.f46974i = kotlinxSerializationBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46973h = obj;
        this.f46975j |= Integer.MIN_VALUE;
        return this.f46974i.a(null, this);
    }
}
