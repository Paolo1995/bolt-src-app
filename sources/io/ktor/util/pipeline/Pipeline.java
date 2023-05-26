package io.ktor.util.pipeline;

import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Pipeline.kt */
/* loaded from: classes5.dex */
public class Pipeline<TSubject, TContext> {
    private volatile /* synthetic */ Object _interceptors;

    /* renamed from: a  reason: collision with root package name */
    private final Attributes f47123a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47124b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Object> f47125c;

    /* renamed from: d  reason: collision with root package name */
    private int f47126d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f47127e;

    /* renamed from: f  reason: collision with root package name */
    private PipelinePhase f47128f;

    public Pipeline(PipelinePhase... phases) {
        List<Object> q8;
        Intrinsics.f(phases, "phases");
        this.f47123a = AttributesJvmKt.a(true);
        q8 = CollectionsKt__CollectionsKt.q(Arrays.copyOf(phases, phases.length));
        this.f47125c = q8;
        this._interceptors = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.m(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.jvm.functions.Function3<io.ktor.util.pipeline.PipelineContext<TSubject, TContext>, TSubject, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> b() {
        /*
            r7 = this;
            int r0 = r7.f47126d
            if (r0 != 0) goto L10
            java.util.List r0 = kotlin.collections.CollectionsKt.k()
            r7.m(r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.k()
            return r0
        L10:
            java.util.List<java.lang.Object> r1 = r7.f47125c
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 != r4) goto L40
            int r0 = kotlin.collections.CollectionsKt.m(r1)
            if (r0 < 0) goto L40
            r4 = 0
        L1e:
            java.lang.Object r5 = r1.get(r4)
            boolean r6 = r5 instanceof io.ktor.util.pipeline.PhaseContent
            if (r6 == 0) goto L29
            io.ktor.util.pipeline.PhaseContent r5 = (io.ktor.util.pipeline.PhaseContent) r5
            goto L2a
        L29:
            r5 = r2
        L2a:
            if (r5 != 0) goto L2d
            goto L3b
        L2d:
            boolean r6 = r5.h()
            if (r6 != 0) goto L3b
            java.util.List r0 = r5.i()
            r7.p(r5)
            return r0
        L3b:
            if (r4 == r0) goto L40
            int r4 = r4 + 1
            goto L1e
        L40:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r4 = kotlin.collections.CollectionsKt.m(r1)
            if (r4 < 0) goto L62
        L4b:
            java.lang.Object r5 = r1.get(r3)
            boolean r6 = r5 instanceof io.ktor.util.pipeline.PhaseContent
            if (r6 == 0) goto L56
            io.ktor.util.pipeline.PhaseContent r5 = (io.ktor.util.pipeline.PhaseContent) r5
            goto L57
        L56:
            r5 = r2
        L57:
            if (r5 != 0) goto L5a
            goto L5d
        L5a:
            r5.b(r0)
        L5d:
            if (r3 == r4) goto L62
            int r3 = r3 + 1
            goto L4b
        L62:
            r7.m(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.Pipeline.b():java.util.List");
    }

    private final PipelineContext<TSubject, TContext> c(TContext tcontext, TSubject tsubject, CoroutineContext coroutineContext) {
        return PipelineContextKt.a(tcontext, q(), tsubject, coroutineContext, g());
    }

    private final PhaseContent<TSubject, TContext> e(PipelinePhase pipelinePhase) {
        List<Object> list = this.f47125c;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            if (obj == pipelinePhase) {
                PhaseContent<TSubject, TContext> phaseContent = new PhaseContent<>(pipelinePhase, PipelinePhaseRelation.Last.f47133a);
                list.set(i8, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent<TSubject, TContext> phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.e() == pipelinePhase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    private final int f(PipelinePhase pipelinePhase) {
        List<Object> list = this.f47125c;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            if (obj == pipelinePhase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).e() == pipelinePhase)) {
                return i8;
            }
        }
        return -1;
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> h() {
        return (List) this._interceptors;
    }

    private final boolean i(PipelinePhase pipelinePhase) {
        List<Object> list = this.f47125c;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            if (obj != pipelinePhase) {
                if ((obj instanceof PhaseContent) && ((PhaseContent) obj).e() == pipelinePhase) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private final void m(List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        o(list);
        this.f47127e = false;
        this.f47128f = null;
    }

    private final void n() {
        o(null);
        this.f47127e = false;
        this.f47128f = null;
    }

    private final void o(List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list) {
        this._interceptors = list;
    }

    private final void p(PhaseContent<TSubject, TContext> phaseContent) {
        o(phaseContent.i());
        this.f47127e = false;
        this.f47128f = phaseContent.e();
    }

    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> q() {
        if (h() == null) {
            b();
        }
        this.f47127e = true;
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> h8 = h();
        Intrinsics.c(h8);
        return h8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r(PipelinePhase pipelinePhase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Object h02;
        int m8;
        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> h8 = h();
        if (this.f47125c.isEmpty() || h8 == null || this.f47127e || !TypeIntrinsics.l(h8)) {
            return false;
        }
        if (Intrinsics.a(this.f47128f, pipelinePhase)) {
            h8.add(function3);
            return true;
        }
        h02 = CollectionsKt___CollectionsKt.h0(this.f47125c);
        if (!Intrinsics.a(pipelinePhase, h02)) {
            int f8 = f(pipelinePhase);
            m8 = CollectionsKt__CollectionsKt.m(this.f47125c);
            if (f8 != m8) {
                return false;
            }
        }
        PhaseContent<TSubject, TContext> e8 = e(pipelinePhase);
        Intrinsics.c(e8);
        e8.a(function3);
        h8.add(function3);
        return true;
    }

    public void a() {
    }

    public final Object d(TContext tcontext, TSubject tsubject, Continuation<? super TSubject> continuation) {
        return c(tcontext, tsubject, continuation.getContext()).a(tsubject, continuation);
    }

    public boolean g() {
        return this.f47124b;
    }

    public final void j(PipelinePhase reference, PipelinePhase phase) {
        int m8;
        PhaseContent phaseContent;
        PipelinePhaseRelation f8;
        PipelinePhase a8;
        Intrinsics.f(reference, "reference");
        Intrinsics.f(phase, "phase");
        if (i(phase)) {
            return;
        }
        int f9 = f(reference);
        if (f9 != -1) {
            int i8 = f9 + 1;
            m8 = CollectionsKt__CollectionsKt.m(this.f47125c);
            if (i8 <= m8) {
                while (true) {
                    Object obj = this.f47125c.get(i8);
                    PipelinePhaseRelation.After after = null;
                    if (obj instanceof PhaseContent) {
                        phaseContent = (PhaseContent) obj;
                    } else {
                        phaseContent = null;
                    }
                    if (phaseContent != null && (f8 = phaseContent.f()) != null) {
                        if (f8 instanceof PipelinePhaseRelation.After) {
                            after = (PipelinePhaseRelation.After) f8;
                        }
                        if (after != null && (a8 = after.a()) != null && Intrinsics.a(a8, reference)) {
                            f9 = i8;
                        }
                        if (i8 == m8) {
                            break;
                        }
                        i8++;
                    } else {
                        break;
                    }
                }
            }
            this.f47125c.add(f9 + 1, new PhaseContent(phase, new PipelinePhaseRelation.After(reference)));
            return;
        }
        throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
    }

    public final void k(PipelinePhase reference, PipelinePhase phase) {
        Intrinsics.f(reference, "reference");
        Intrinsics.f(phase, "phase");
        if (i(phase)) {
            return;
        }
        int f8 = f(reference);
        if (f8 != -1) {
            this.f47125c.add(f8, new PhaseContent(phase, new PipelinePhaseRelation.Before(reference)));
            return;
        }
        throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
    }

    public final void l(PipelinePhase phase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.f(phase, "phase");
        Intrinsics.f(block, "block");
        PhaseContent<TSubject, TContext> e8 = e(phase);
        if (e8 != null) {
            Function3 function3 = (Function3) TypeIntrinsics.e(block, 3);
            if (r(phase, block)) {
                this.f47126d++;
                return;
            }
            e8.a(block);
            this.f47126d++;
            n();
            a();
            return;
        }
        throw new InvalidPhaseException("Phase " + phase + " was not registered for this pipeline");
    }
}
