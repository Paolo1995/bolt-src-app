package eu.bolt.verification.sdk.internal;

import io.reactivex.Scheduler;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class xg {

    /* renamed from: a  reason: collision with root package name */
    private final Scheduler f45649a;

    /* renamed from: b  reason: collision with root package name */
    private final Scheduler f45650b;

    /* renamed from: c  reason: collision with root package name */
    private final Scheduler f45651c;

    /* renamed from: d  reason: collision with root package name */
    private final Scheduler f45652d;

    /* renamed from: e  reason: collision with root package name */
    private final Scheduler f45653e;

    /* renamed from: f  reason: collision with root package name */
    private final Scheduler f45654f;

    public xg(Scheduler main, Scheduler io2, Scheduler computation, Scheduler single, Scheduler computationSingle, Scheduler relayEmissionScheduler) {
        Intrinsics.f(main, "main");
        Intrinsics.f(io2, "io");
        Intrinsics.f(computation, "computation");
        Intrinsics.f(single, "single");
        Intrinsics.f(computationSingle, "computationSingle");
        Intrinsics.f(relayEmissionScheduler, "relayEmissionScheduler");
        this.f45649a = main;
        this.f45650b = io2;
        this.f45651c = computation;
        this.f45652d = single;
        this.f45653e = computationSingle;
        this.f45654f = relayEmissionScheduler;
    }

    public final Scheduler a() {
        return this.f45651c;
    }

    public final Scheduler b() {
        return this.f45650b;
    }

    public final Scheduler c() {
        return this.f45649a;
    }

    public final Scheduler d() {
        return this.f45654f;
    }
}
