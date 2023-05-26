package io.ktor.serialization.kotlinx;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;

/* compiled from: KotlinxSerializationBase.kt */
/* loaded from: classes5.dex */
public abstract class KotlinxSerializationBase<T> {

    /* renamed from: a  reason: collision with root package name */
    private final SerialFormat f46970a;

    public KotlinxSerializationBase(SerialFormat format) {
        Intrinsics.f(format, "format");
        this.f46970a = format;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(io.ktor.serialization.kotlinx.SerializationParameters r7, kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.serialization.kotlinx.KotlinxSerializationBase$serialize$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.serialization.kotlinx.KotlinxSerializationBase$serialize$1 r0 = (io.ktor.serialization.kotlinx.KotlinxSerializationBase$serialize$1) r0
            int r1 = r0.f46975j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46975j = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.KotlinxSerializationBase$serialize$1 r0 = new io.ktor.serialization.kotlinx.KotlinxSerializationBase$serialize$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f46973h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f46975j
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.b(r8)
            goto L8a
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.f46972g
            io.ktor.serialization.kotlinx.SerializationParameters r7 = (io.ktor.serialization.kotlinx.SerializationParameters) r7
            java.lang.Object r2 = r0.f46971f
            io.ktor.serialization.kotlinx.KotlinxSerializationBase r2 = (io.ktor.serialization.kotlinx.KotlinxSerializationBase) r2
            kotlin.ResultKt.b(r8)     // Catch: kotlinx.serialization.SerializationException -> L41
            goto L69
        L41:
            goto L68
        L43:
            kotlin.ResultKt.b(r8)
            io.ktor.util.reflect.TypeInfo r8 = r7.d()     // Catch: kotlinx.serialization.SerializationException -> L66
            kotlinx.serialization.SerialFormat r2 = r6.f46970a     // Catch: kotlinx.serialization.SerializationException -> L66
            kotlinx.serialization.modules.SerializersModule r2 = r2.a()     // Catch: kotlinx.serialization.SerializationException -> L66
            kotlinx.serialization.KSerializer r8 = io.ktor.serialization.kotlinx.SerializerLookupKt.d(r8, r2)     // Catch: kotlinx.serialization.SerializationException -> L66
            r7.f(r8)     // Catch: kotlinx.serialization.SerializationException -> L66
            r0.f46971f = r6     // Catch: kotlinx.serialization.SerializationException -> L66
            r0.f46972g = r7     // Catch: kotlinx.serialization.SerializationException -> L66
            r0.f46975j = r4     // Catch: kotlinx.serialization.SerializationException -> L66
            java.lang.Object r8 = r6.b(r7, r0)     // Catch: kotlinx.serialization.SerializationException -> L66
            if (r8 != r1) goto L64
            return r1
        L64:
            r2 = r6
            goto L69
        L66:
            r2 = r6
        L68:
            r8 = r5
        L69:
            if (r8 == 0) goto L6c
            return r8
        L6c:
            java.lang.Object r8 = r7.e()
            kotlinx.serialization.SerialFormat r4 = r2.f46970a
            kotlinx.serialization.modules.SerializersModule r4 = r4.a()
            kotlinx.serialization.KSerializer r8 = io.ktor.serialization.kotlinx.SerializerLookupKt.b(r8, r4)
            r7.f(r8)
            r0.f46971f = r5
            r0.f46972g = r5
            r0.f46975j = r3
            java.lang.Object r8 = r2.b(r7, r0)
            if (r8 != r1) goto L8a
            return r1
        L8a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationBase.a(io.ktor.serialization.kotlinx.SerializationParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object b(SerializationParameters serializationParameters, Continuation<? super T> continuation);
}
