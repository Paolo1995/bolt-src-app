package io.ktor.utils.io.internal;

/* compiled from: SequentialCopyTo.kt */
/* loaded from: classes5.dex */
public final class SequentialCopyToKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00e7 -> B:53:0x010b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ee -> B:52:0x0103). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0100 -> B:52:0x0103). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(io.ktor.utils.io.ByteChannelSequentialBase r19, io.ktor.utils.io.ByteChannelSequentialBase r20, long r21, kotlin.coroutines.Continuation<? super java.lang.Long> r23) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.b(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #0 {all -> 0x00b7, blocks: (B:26:0x0077, B:28:0x0080, B:31:0x0097, B:23:0x005d), top: B:43:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[Catch: all -> 0x00b7, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b7, blocks: (B:26:0x0077, B:28:0x0080, B:31:0x0097, B:23:0x005d), top: B:43:0x005d }] */
    /* JADX WARN: Type inference failed for: r9v10, types: [io.ktor.utils.io.core.internal.ChunkBuffer] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(io.ktor.utils.io.ByteChannelSequentialBase r8, io.ktor.utils.io.ByteChannelSequentialBase r9, long r10, kotlin.coroutines.Continuation<? super java.lang.Long> r12) {
        /*
            boolean r0 = r12 instanceof io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1
            if (r0 == 0) goto L13
            r0 = r12
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1 r0 = (io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1) r0
            int r1 = r0.f47470j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47470j = r1
            goto L18
        L13:
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1 r0 = new io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f47469i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f47470j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            int r8 = r0.f47468h
            java.lang.Object r9 = r0.f47466f
            io.ktor.utils.io.core.internal.ChunkBuffer r9 = (io.ktor.utils.io.core.internal.ChunkBuffer) r9
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L4c
            goto La8
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.f47467g
            r9 = r8
            io.ktor.utils.io.core.internal.ChunkBuffer r9 = (io.ktor.utils.io.core.internal.ChunkBuffer) r9
            java.lang.Object r8 = r0.f47466f
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L4c
            r7 = r9
            r9 = r8
            r8 = r12
            r12 = r7
            goto L77
        L4c:
            r8 = move-exception
            goto Lb9
        L4e:
            kotlin.ResultKt.b(r12)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r12 = io.ktor.utils.io.core.internal.ChunkBuffer.f47400j
            io.ktor.utils.io.pool.ObjectPool r12 = r12.c()
            java.lang.Object r12 = r12.u0()
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = (io.ktor.utils.io.core.internal.ChunkBuffer) r12
            int r2 = r12.f()     // Catch: java.lang.Throwable -> Lb7
            long r5 = (long) r2     // Catch: java.lang.Throwable -> Lb7
            long r10 = kotlin.ranges.RangesKt.h(r10, r5)     // Catch: java.lang.Throwable -> Lb7
            int r11 = (int) r10     // Catch: java.lang.Throwable -> Lb7
            r12.t(r11)     // Catch: java.lang.Throwable -> Lb7
            r0.f47466f = r9     // Catch: java.lang.Throwable -> Lb7
            r0.f47467g = r12     // Catch: java.lang.Throwable -> Lb7
            r0.f47470j = r4     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r8 = r8.l(r12, r0)     // Catch: java.lang.Throwable -> Lb7
            if (r8 != r1) goto L77
            return r1
        L77:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Throwable -> Lb7
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> Lb7
            r10 = -1
            if (r8 != r10) goto L97
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r8 = io.ktor.utils.io.core.internal.ChunkBuffer.f47400j     // Catch: java.lang.Throwable -> Lb7
            io.ktor.utils.io.pool.ObjectPool r9 = r8.c()     // Catch: java.lang.Throwable -> Lb7
            r12.E(r9)     // Catch: java.lang.Throwable -> Lb7
            r9 = 0
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.c(r9)     // Catch: java.lang.Throwable -> Lb7
            io.ktor.utils.io.pool.ObjectPool r8 = r8.c()
            r12.E(r8)
            return r9
        L97:
            r0.f47466f = r12     // Catch: java.lang.Throwable -> Lb7
            r10 = 0
            r0.f47467g = r10     // Catch: java.lang.Throwable -> Lb7
            r0.f47468h = r8     // Catch: java.lang.Throwable -> Lb7
            r0.f47470j = r3     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r9 = r9.k(r12, r0)     // Catch: java.lang.Throwable -> Lb7
            if (r9 != r1) goto La7
            return r1
        La7:
            r9 = r12
        La8:
            long r10 = (long) r8
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.c(r10)     // Catch: java.lang.Throwable -> L4c
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r10 = io.ktor.utils.io.core.internal.ChunkBuffer.f47400j
            io.ktor.utils.io.pool.ObjectPool r10 = r10.c()
            r9.E(r10)
            return r8
        Lb7:
            r8 = move-exception
            r9 = r12
        Lb9:
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r10 = io.ktor.utils.io.core.internal.ChunkBuffer.f47400j
            io.ktor.utils.io.pool.ObjectPool r10 = r10.c()
            r9.E(r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.c(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
