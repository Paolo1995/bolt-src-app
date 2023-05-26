package io.ktor.serialization.kotlinx;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinxSerializationConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {67}, m = "deserialize")
/* loaded from: classes5.dex */
public final class KotlinxSerializationConverter$deserialize$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46978f;

    /* renamed from: g  reason: collision with root package name */
    Object f46979g;

    /* renamed from: h  reason: collision with root package name */
    Object f46980h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f46981i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ KotlinxSerializationConverter f46982j;

    /* renamed from: k  reason: collision with root package name */
    int f46983k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationConverter$deserialize$1(KotlinxSerializationConverter kotlinxSerializationConverter, Continuation<? super KotlinxSerializationConverter$deserialize$1> continuation) {
        super(continuation);
        this.f46982j = kotlinxSerializationConverter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46981i = obj;
        this.f46983k |= Integer.MIN_VALUE;
        return this.f46982j.a(null, null, null, this);
    }
}
