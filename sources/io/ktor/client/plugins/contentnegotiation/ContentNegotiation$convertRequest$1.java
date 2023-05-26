package io.ktor.client.plugins.contentnegotiation;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentNegotiation.kt */
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation", f = "ContentNegotiation.kt", l = {156}, m = "convertRequest$ktor_client_content_negotiation")
/* loaded from: classes5.dex */
public final class ContentNegotiation$convertRequest$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46484f;

    /* renamed from: g  reason: collision with root package name */
    Object f46485g;

    /* renamed from: h  reason: collision with root package name */
    Object f46486h;

    /* renamed from: i  reason: collision with root package name */
    Object f46487i;

    /* renamed from: j  reason: collision with root package name */
    Object f46488j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f46489k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ ContentNegotiation f46490l;

    /* renamed from: m  reason: collision with root package name */
    int f46491m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$convertRequest$1(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$convertRequest$1> continuation) {
        super(continuation);
        this.f46490l = contentNegotiation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46489k = obj;
        this.f46491m |= Integer.MIN_VALUE;
        return this.f46490l.b(null, null, this);
    }
}
