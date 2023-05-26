package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public final class Schedulers {

    /* renamed from: a  reason: collision with root package name */
    static final Scheduler f49886a = RxJavaPlugins.h(new SingleTask());

    /* renamed from: b  reason: collision with root package name */
    static final Scheduler f49887b = RxJavaPlugins.e(new ComputationTask());

    /* renamed from: c  reason: collision with root package name */
    static final Scheduler f49888c = RxJavaPlugins.f(new IOTask());

    /* renamed from: d  reason: collision with root package name */
    static final Scheduler f49889d = TrampolineScheduler.g();

    /* renamed from: e  reason: collision with root package name */
    static final Scheduler f49890e = RxJavaPlugins.g(new NewThreadTask());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ComputationHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f49891a = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    /* loaded from: classes5.dex */
    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return ComputationHolder.f49891a;
        }
    }

    /* loaded from: classes5.dex */
    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return IoHolder.f49892a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class IoHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f49892a = new IoScheduler();

        IoHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class NewThreadHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f49893a = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    /* loaded from: classes5.dex */
    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return NewThreadHolder.f49893a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f49894a = new SingleScheduler();

        SingleHolder() {
        }
    }

    /* loaded from: classes5.dex */
    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Scheduler call() throws Exception {
            return SingleHolder.f49894a;
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    public static Scheduler a() {
        return RxJavaPlugins.r(f49887b);
    }

    public static Scheduler b(Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    public static Scheduler c() {
        return RxJavaPlugins.t(f49888c);
    }

    public static Scheduler d() {
        return RxJavaPlugins.v(f49886a);
    }

    public static Scheduler e() {
        return f49889d;
    }
}
