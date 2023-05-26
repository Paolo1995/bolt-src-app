package io.ktor.serialization;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ContentConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt$deserialize$result$2", f = "ContentConverter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ContentConverterKt$deserialize$result$2 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f46967g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f46968h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ByteReadChannel f46969i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentConverterKt$deserialize$result$2(ByteReadChannel byteReadChannel, Continuation<? super ContentConverterKt$deserialize$result$2> continuation) {
        super(2, continuation);
        this.f46969i = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentConverterKt$deserialize$result$2 contentConverterKt$deserialize$result$2 = new ContentConverterKt$deserialize$result$2(this.f46969i, continuation);
        contentConverterKt$deserialize$result$2.f46968h = obj;
        return contentConverterKt$deserialize$result$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(Object obj, Continuation<? super Boolean> continuation) {
        return ((ContentConverterKt$deserialize$result$2) create(obj, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z7;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f46967g == 0) {
            ResultKt.b(obj);
            if (this.f46968h == null && !this.f46969i.o()) {
                z7 = false;
            } else {
                z7 = true;
            }
            return Boxing.a(z7);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
