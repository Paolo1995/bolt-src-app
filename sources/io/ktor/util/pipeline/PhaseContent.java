package io.ktor.util.pipeline;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhaseContent.kt */
/* loaded from: classes5.dex */
public final class PhaseContent<TSubject, Call> {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f47117e = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private static final List<Object> f47118f = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private final PipelinePhase f47119a;

    /* renamed from: b  reason: collision with root package name */
    private final PipelinePhaseRelation f47120b;

    /* renamed from: c  reason: collision with root package name */
    private List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> f47121c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f47122d;

    /* compiled from: PhaseContent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PhaseContent(PipelinePhase phase, PipelinePhaseRelation relation, List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> interceptors) {
        Intrinsics.f(phase, "phase");
        Intrinsics.f(relation, "relation");
        Intrinsics.f(interceptors, "interceptors");
        this.f47119a = phase;
        this.f47120b = relation;
        this.f47121c = interceptors;
        this.f47122d = true;
    }

    private final void d() {
        this.f47121c = c();
        this.f47122d = false;
    }

    public final void a(Function3<? super PipelineContext<TSubject, Call>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> interceptor) {
        Intrinsics.f(interceptor, "interceptor");
        if (this.f47122d) {
            d();
        }
        this.f47121c.add(interceptor);
    }

    public final void b(List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> destination) {
        Intrinsics.f(destination, "destination");
        List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> list = this.f47121c;
        if (destination instanceof ArrayList) {
            ((ArrayList) destination).ensureCapacity(destination.size() + list.size());
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            destination.add(list.get(i8));
        }
    }

    public final List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f47121c);
        return arrayList;
    }

    public final PipelinePhase e() {
        return this.f47119a;
    }

    public final PipelinePhaseRelation f() {
        return this.f47120b;
    }

    public final int g() {
        return this.f47121c.size();
    }

    public final boolean h() {
        return this.f47121c.isEmpty();
    }

    public final List<Function3<PipelineContext<TSubject, Call>, TSubject, Continuation<? super Unit>, Object>> i() {
        this.f47122d = true;
        return this.f47121c;
    }

    public String toString() {
        return "Phase `" + this.f47119a.a() + "`, " + g() + " handlers";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PhaseContent(io.ktor.util.pipeline.PipelinePhase r3, io.ktor.util.pipeline.PipelinePhaseRelation r4) {
        /*
            r2 = this;
            java.lang.String r0 = "phase"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.String r0 = "relation"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.util.List<java.lang.Object> r0 = io.ktor.util.pipeline.PhaseContent.f47118f
            java.util.List r1 = kotlin.jvm.internal.TypeIntrinsics.c(r0)
            r2.<init>(r3, r4, r1)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L1a
            return
        L1a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "The shared empty array list has been modified"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.PhaseContent.<init>(io.ktor.util.pipeline.PipelinePhase, io.ktor.util.pipeline.PipelinePhaseRelation):void");
    }
}
