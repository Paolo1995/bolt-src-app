package eu.bolt.chat.tools.deps;

import io.reactivex.Scheduler;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RxSchedulers.kt */
/* loaded from: classes5.dex */
public abstract class RxSchedulers {

    /* renamed from: a  reason: collision with root package name */
    private final Scheduler f39657a;

    /* renamed from: b  reason: collision with root package name */
    private final Scheduler f39658b;

    /* renamed from: c  reason: collision with root package name */
    private final Scheduler f39659c;

    /* renamed from: d  reason: collision with root package name */
    private final Scheduler f39660d;

    /* renamed from: e  reason: collision with root package name */
    private final Scheduler f39661e;

    public RxSchedulers(Scheduler main, Scheduler io2, Scheduler computation, Scheduler single, Scheduler computationSingle) {
        Intrinsics.f(main, "main");
        Intrinsics.f(io2, "io");
        Intrinsics.f(computation, "computation");
        Intrinsics.f(single, "single");
        Intrinsics.f(computationSingle, "computationSingle");
        this.f39657a = main;
        this.f39658b = io2;
        this.f39659c = computation;
        this.f39660d = single;
        this.f39661e = computationSingle;
    }

    public final Scheduler a() {
        return this.f39659c;
    }

    public final Scheduler b() {
        return this.f39658b;
    }

    public final Scheduler c() {
        return this.f39657a;
    }

    public final Scheduler d() {
        return this.f39660d;
    }
}
