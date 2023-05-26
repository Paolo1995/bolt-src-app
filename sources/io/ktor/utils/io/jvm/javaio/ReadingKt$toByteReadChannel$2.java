package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Reading.kt */
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2", f = "Reading.kt", l = {89}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class ReadingKt$toByteReadChannel$2 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f47503g;

    /* renamed from: h  reason: collision with root package name */
    int f47504h;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ Object f47505i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ObjectPool<byte[]> f47506j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ InputStream f47507k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingKt$toByteReadChannel$2(ObjectPool<byte[]> objectPool, InputStream inputStream, Continuation<? super ReadingKt$toByteReadChannel$2> continuation) {
        super(2, continuation);
        this.f47506j = objectPool;
        this.f47507k = inputStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReadingKt$toByteReadChannel$2 readingKt$toByteReadChannel$2 = new ReadingKt$toByteReadChannel$2(this.f47506j, this.f47507k, continuation);
        readingKt$toByteReadChannel$2.f47505i = obj;
        return readingKt$toByteReadChannel$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ReadingKt$toByteReadChannel$2) create(writerScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        byte[] u02;
        WriterScope writerScope;
        Throwable th;
        ReadingKt$toByteReadChannel$2 readingKt$toByteReadChannel$2;
        InputStream inputStream;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f47504h;
        if (i8 != 0) {
            if (i8 == 1) {
                u02 = (byte[]) this.f47503g;
                writerScope = (WriterScope) this.f47505i;
                try {
                    ResultKt.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    readingKt$toByteReadChannel$2 = this;
                    try {
                        writerScope.getChannel().b(th);
                        readingKt$toByteReadChannel$2.f47506j.recycle(u02);
                        inputStream = readingKt$toByteReadChannel$2.f47507k;
                        inputStream.close();
                        return Unit.f50853a;
                    } catch (Throwable th3) {
                        readingKt$toByteReadChannel$2.f47506j.recycle(u02);
                        readingKt$toByteReadChannel$2.f47507k.close();
                        throw th3;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            u02 = this.f47506j.u0();
            writerScope = (WriterScope) this.f47505i;
        }
        while (true) {
            try {
                int read = this.f47507k.read(u02, 0, u02.length);
                if (read >= 0) {
                    if (read != 0) {
                        ByteWriteChannel channel = writerScope.getChannel();
                        this.f47505i = writerScope;
                        this.f47503g = u02;
                        this.f47504h = 1;
                        if (channel.i(u02, 0, read, this) == d8) {
                            return d8;
                        }
                    }
                } else {
                    this.f47506j.recycle(u02);
                    inputStream = this.f47507k;
                    break;
                }
            } catch (Throwable th4) {
                readingKt$toByteReadChannel$2 = this;
                th = th4;
                writerScope.getChannel().b(th);
                readingKt$toByteReadChannel$2.f47506j.recycle(u02);
                inputStream = readingKt$toByteReadChannel$2.f47507k;
                inputStream.close();
                return Unit.f50853a;
            }
        }
    }
}
