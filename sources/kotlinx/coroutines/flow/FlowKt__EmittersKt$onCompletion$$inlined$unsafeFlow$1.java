package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
/* loaded from: classes5.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Flow f51513f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Function3 f51514g;

    /* compiled from: SafeCollector.common.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {114, 121, 128}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f51515f;

        /* renamed from: g  reason: collision with root package name */
        int f51516g;

        /* renamed from: i  reason: collision with root package name */
        Object f51518i;

        /* renamed from: j  reason: collision with root package name */
        Object f51519j;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f51515f = obj;
            this.f51516g |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.a(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.f51513f = flow;
        this.f51514g = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlinx.coroutines.flow.FlowCollector<? super T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f51516g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f51516g = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f51515f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f51516g
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L54
            if (r2 == r5) goto L46
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r9 = r0.f51518i
            kotlinx.coroutines.flow.internal.SafeCollector r9 = (kotlinx.coroutines.flow.internal.SafeCollector) r9
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L34
            goto L88
        L34:
            r10 = move-exception
            goto L92
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            java.lang.Object r9 = r0.f51518i
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.ResultKt.b(r10)
            goto Lac
        L46:
            java.lang.Object r9 = r0.f51519j
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r2 = r0.f51518i
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r2 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r2
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L52
            goto L67
        L52:
            r9 = move-exception
            goto L98
        L54:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.flow.Flow r10 = r8.f51513f     // Catch: java.lang.Throwable -> L96
            r0.f51518i = r8     // Catch: java.lang.Throwable -> L96
            r0.f51519j = r9     // Catch: java.lang.Throwable -> L96
            r0.f51516g = r5     // Catch: java.lang.Throwable -> L96
            java.lang.Object r10 = r10.a(r9, r0)     // Catch: java.lang.Throwable -> L96
            if (r10 != r1) goto L66
            return r1
        L66:
            r2 = r8
        L67:
            kotlinx.coroutines.flow.internal.SafeCollector r10 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r4 = r0.getContext()
            r10.<init>(r9, r4)
            kotlin.jvm.functions.Function3 r9 = r2.f51514g     // Catch: java.lang.Throwable -> L8e
            r0.f51518i = r10     // Catch: java.lang.Throwable -> L8e
            r0.f51519j = r6     // Catch: java.lang.Throwable -> L8e
            r0.f51516g = r3     // Catch: java.lang.Throwable -> L8e
            r2 = 6
            kotlin.jvm.internal.InlineMarker.c(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r9 = r9.l(r10, r6, r0)     // Catch: java.lang.Throwable -> L8e
            r0 = 7
            kotlin.jvm.internal.InlineMarker.c(r0)     // Catch: java.lang.Throwable -> L8e
            if (r9 != r1) goto L87
            return r1
        L87:
            r9 = r10
        L88:
            r9.releaseIntercepted()
            kotlin.Unit r9 = kotlin.Unit.f50853a
            return r9
        L8e:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L92:
            r9.releaseIntercepted()
            throw r10
        L96:
            r9 = move-exception
            r2 = r8
        L98:
            kotlinx.coroutines.flow.ThrowingCollector r10 = new kotlinx.coroutines.flow.ThrowingCollector
            r10.<init>(r9)
            kotlin.jvm.functions.Function3 r2 = r2.f51514g
            r0.f51518i = r9
            r0.f51519j = r6
            r0.f51516g = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt__EmittersKt.a(r10, r2, r9, r0)
            if (r10 != r1) goto Lac
            return r1
        Lac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
