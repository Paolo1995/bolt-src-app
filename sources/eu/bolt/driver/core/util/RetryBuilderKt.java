package eu.bolt.driver.core.util;

/* compiled from: RetryBuilder.kt */
/* loaded from: classes5.dex */
public final class RetryBuilderKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[PHI: r10 
      PHI: (r10v4 java.lang.Object) = (r10v6 java.lang.Object), (r10v1 java.lang.Object) binds: [B:23:0x005a, B:17:0x0047] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0070 -> B:13:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(eu.bolt.driver.core.util.BackOffCalculator r8, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super T> r10) throws eu.bolt.driver.core.util.OutOfRetriesException {
        /*
            boolean r0 = r10 instanceof eu.bolt.driver.core.util.RetryBuilderKt$withRetry$1
            if (r0 == 0) goto L13
            r0 = r10
            eu.bolt.driver.core.util.RetryBuilderKt$withRetry$1 r0 = (eu.bolt.driver.core.util.RetryBuilderKt$withRetry$1) r0
            int r1 = r0.f41321i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f41321i = r1
            goto L18
        L13:
            eu.bolt.driver.core.util.RetryBuilderKt$withRetry$1 r0 = new eu.bolt.driver.core.util.RetryBuilderKt$withRetry$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f41320h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f41321i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r8 = r0.f41319g
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r0.f41318f
            eu.bolt.driver.core.util.BackOffCalculator r9 = (eu.bolt.driver.core.util.BackOffCalculator) r9
            kotlin.ResultKt.b(r10)
        L33:
            r7 = r9
            r9 = r8
            r8 = r7
            goto L50
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r8 = r0.f41319g
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r0.f41318f
            eu.bolt.driver.core.util.BackOffCalculator r9 = (eu.bolt.driver.core.util.BackOffCalculator) r9
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L4b
            goto L5d
        L4b:
            r10 = move-exception
            goto L62
        L4d:
            kotlin.ResultKt.b(r10)
        L50:
            r0.f41318f = r8     // Catch: java.lang.Throwable -> L5e
            r0.f41319g = r9     // Catch: java.lang.Throwable -> L5e
            r0.f41321i = r4     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r10 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L5e
            if (r10 != r1) goto L5d
            return r1
        L5d:
            return r10
        L5e:
            r10 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L62:
            long r5 = r9.a(r10)
            r0.f41318f = r9
            r0.f41319g = r8
            r0.f41321i = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.a(r5, r0)
            if (r10 != r1) goto L33
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.core.util.RetryBuilderKt.a(eu.bolt.driver.core.util.BackOffCalculator, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
