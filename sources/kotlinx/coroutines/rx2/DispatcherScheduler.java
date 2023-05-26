package kotlinx.coroutines.rx2;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.rx2.DispatcherScheduler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
/* loaded from: classes5.dex */
public final class DispatcherScheduler extends Scheduler {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f51863f = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter");

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineDispatcher f51864c;

    /* renamed from: d  reason: collision with root package name */
    private final CompletableJob f51865d;

    /* renamed from: e  reason: collision with root package name */
    private final CoroutineScope f51866e;
    private volatile /* synthetic */ long workerCounter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RxScheduler.kt */
    /* loaded from: classes5.dex */
    public static final class DispatcherWorker extends Scheduler.Worker {

        /* renamed from: f  reason: collision with root package name */
        private final long f51871f;

        /* renamed from: g  reason: collision with root package name */
        private final CoroutineDispatcher f51872g;

        /* renamed from: h  reason: collision with root package name */
        private final CompletableJob f51873h;

        /* renamed from: i  reason: collision with root package name */
        private final CoroutineScope f51874i;

        /* renamed from: j  reason: collision with root package name */
        private final Channel<Function1<Continuation<? super Unit>, Object>> f51875j;

        /* compiled from: RxScheduler.kt */
        @DebugMetadata(c = "kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1", f = "RxScheduler.kt", l = {189, 82}, m = "invokeSuspend")
        /* renamed from: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            Object f51876g;

            /* renamed from: h  reason: collision with root package name */
            Object f51877h;

            /* renamed from: i  reason: collision with root package name */
            int f51878i;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: h */
            public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #0 {all -> 0x0077, blocks: (B:22:0x0052, B:24:0x005a), top: B:37:0x0052 }] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:17:0x003f). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r1 = r8.f51878i
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L31
                    if (r1 == r3) goto L23
                    if (r1 != r2) goto L1b
                    java.lang.Object r1 = r8.f51877h
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r4 = r8.f51876g
                    kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                    kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L7a
                    r9 = r1
                    goto L3e
                L1b:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L23:
                    java.lang.Object r1 = r8.f51877h
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r4 = r8.f51876g
                    kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                    kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L7a
                    r5 = r4
                    r4 = r8
                    goto L51
                L31:
                    kotlin.ResultKt.b(r9)
                    kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker r9 = kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.this
                    kotlinx.coroutines.channels.Channel r4 = kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.e(r9)
                    kotlinx.coroutines.channels.ChannelIterator r9 = r4.iterator()     // Catch: java.lang.Throwable -> L7a
                L3e:
                    r1 = r8
                L3f:
                    r1.f51876g = r4     // Catch: java.lang.Throwable -> L7a
                    r1.f51877h = r9     // Catch: java.lang.Throwable -> L7a
                    r1.f51878i = r3     // Catch: java.lang.Throwable -> L7a
                    java.lang.Object r5 = r9.a(r1)     // Catch: java.lang.Throwable -> L7a
                    if (r5 != r0) goto L4c
                    return r0
                L4c:
                    r7 = r1
                    r1 = r9
                    r9 = r5
                    r5 = r4
                    r4 = r7
                L51:
                    r6 = 0
                    java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L77
                    boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L77
                    if (r9 == 0) goto L71
                    java.lang.Object r9 = r1.next()     // Catch: java.lang.Throwable -> L77
                    kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9     // Catch: java.lang.Throwable -> L77
                    r4.f51876g = r5     // Catch: java.lang.Throwable -> L77
                    r4.f51877h = r1     // Catch: java.lang.Throwable -> L77
                    r4.f51878i = r2     // Catch: java.lang.Throwable -> L77
                    java.lang.Object r9 = r9.invoke(r4)     // Catch: java.lang.Throwable -> L77
                    if (r9 != r0) goto L6d
                    return r0
                L6d:
                    r9 = r1
                    r1 = r4
                    r4 = r5
                    goto L3f
                L71:
                    kotlinx.coroutines.channels.ChannelsKt.a(r5, r6)
                    kotlin.Unit r9 = kotlin.Unit.f50853a
                    return r9
                L77:
                    r9 = move-exception
                    r4 = r5
                    goto L7b
                L7a:
                    r9 = move-exception
                L7b:
                    throw r9     // Catch: java.lang.Throwable -> L7c
                L7c:
                    r0 = move-exception
                    kotlinx.coroutines.channels.ChannelsKt.a(r4, r9)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public DispatcherWorker(long j8, CoroutineDispatcher coroutineDispatcher, Job job) {
            this.f51871f = j8;
            this.f51872g = coroutineDispatcher;
            CompletableJob a8 = SupervisorKt.a(job);
            this.f51873h = a8;
            CoroutineScope a9 = CoroutineScopeKt.a(a8.s0(coroutineDispatcher));
            this.f51874i = a9;
            this.f51875j = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);
            BuildersKt__Builders_commonKt.d(a9, null, null, new AnonymousClass1(null), 3, null);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j8, TimeUnit timeUnit) {
            Disposable e8;
            e8 = RxSchedulerKt.e(this.f51874i, runnable, timeUnit.toMillis(j8), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$schedule$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Runnable invoke(final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                    final DispatcherScheduler.DispatcherWorker dispatcherWorker = DispatcherScheduler.DispatcherWorker.this;
                    return new Runnable() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$schedule$1$invoke$$inlined$Runnable$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DispatcherScheduler.DispatcherWorker.this.f51875j.u(function1);
                        }
                    };
                }
            });
            return e8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SendChannel.DefaultImpls.a(this.f51875j, null, 1, null);
            Job.DefaultImpls.a(this.f51873h, null, 1, null);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return !CoroutineScopeKt.f(this.f51874i);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f51872g);
            sb.append(" (worker ");
            sb.append(this.f51871f);
            sb.append(", ");
            if (isDisposed()) {
                str = "disposed";
            } else {
                str = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
            }
            sb.append(str);
            sb.append(')');
            return sb.toString();
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new DispatcherWorker(f51863f.getAndIncrement(this), this.f51864c, this.f51865d);
    }

    @Override // io.reactivex.Scheduler
    public Disposable e(Runnable runnable, long j8, TimeUnit timeUnit) {
        Disposable e8;
        e8 = RxSchedulerKt.e(this.f51866e, runnable, timeUnit.toMillis(j8), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$scheduleDirect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Runnable invoke(final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                final DispatcherScheduler dispatcherScheduler = DispatcherScheduler.this;
                return new Runnable() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CoroutineScope coroutineScope;
                        coroutineScope = DispatcherScheduler.this.f51866e;
                        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new DispatcherScheduler$scheduleDirect$1$1$1(function1, null), 3, null);
                    }
                };
            }
        });
        return e8;
    }

    public String toString() {
        return this.f51864c.toString();
    }
}
