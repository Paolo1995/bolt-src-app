package io.ktor.serialization;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt", f = "ContentConverter.kt", l = {128}, m = "deserialize")
/* loaded from: classes5.dex */
public final class ContentConverterKt$deserialize$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46963f;

    /* renamed from: g  reason: collision with root package name */
    Object f46964g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46965h;

    /* renamed from: i  reason: collision with root package name */
    int f46966i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentConverterKt$deserialize$1(Continuation<? super ContentConverterKt$deserialize$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46965h = obj;
        this.f46966i |= Integer.MIN_VALUE;
        return ContentConverterKt.a(null, null, null, null, this);
    }
}
