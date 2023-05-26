package eu.bolt.verification.sdk.internal;

import eu.bolt.logger.StaticLogger;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* loaded from: classes5.dex */
public class ag implements Function<Flowable<Throwable>, Publisher<?>> {

    /* renamed from: k  reason: collision with root package name */
    private static final Function<Throwable, Boolean> f42077k = new Function() { // from class: eu.bolt.verification.sdk.internal.b6
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            Boolean e8;
            e8 = ag.e((Throwable) obj);
            return e8;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f42078f;

    /* renamed from: g  reason: collision with root package name */
    private final int f42079g;

    /* renamed from: h  reason: collision with root package name */
    private int f42080h;

    /* renamed from: i  reason: collision with root package name */
    private final Function<Throwable, Boolean> f42081i;

    /* renamed from: j  reason: collision with root package name */
    private final Scheduler f42082j;

    public ag(int i8, int i9) {
        this(i8, i9, Schedulers.a());
    }

    public ag(int i8, int i9, Scheduler scheduler) {
        this.f42078f = i8;
        this.f42079g = i9;
        this.f42080h = 0;
        this.f42081i = f42077k;
        this.f42082j = scheduler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Single c(Throwable th) {
        if (this.f42081i.apply(th).booleanValue()) {
            int i8 = this.f42080h;
            this.f42080h = i8 + 1;
            if (i8 < this.f42078f) {
                StaticLogger staticLogger = StaticLogger.f41686a;
                int i9 = this.f42079g;
                staticLogger.a(th, "Retrying interval " + i9);
                return Single.P(this.f42079g, TimeUnit.MILLISECONDS, this.f42082j);
            }
        }
        return Single.error(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean e(Throwable th) {
        return Boolean.TRUE;
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: d */
    public Publisher<?> apply(Flowable<Throwable> flowable) {
        return flowable.D(new Function() { // from class: eu.bolt.verification.sdk.internal.i0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Single c8;
                c8 = ag.this.c((Throwable) obj);
                return c8;
            }
        });
    }
}
