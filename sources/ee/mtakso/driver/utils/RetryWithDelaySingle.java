package ee.mtakso.driver.utils;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* loaded from: classes5.dex */
public class RetryWithDelaySingle implements Function<Flowable<Throwable>, Publisher<?>> {

    /* renamed from: f  reason: collision with root package name */
    private final int f36313f;

    /* renamed from: g  reason: collision with root package name */
    private final long f36314g;

    /* renamed from: h  reason: collision with root package name */
    private int f36315h = 0;

    public RetryWithDelaySingle(int i8, long j8) {
        this.f36313f = i8;
        this.f36314g = j8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource c(Throwable th) throws Exception {
        int i8 = this.f36315h + 1;
        this.f36315h = i8;
        if (i8 < this.f36313f) {
            return Single.P(this.f36314g, TimeUnit.MILLISECONDS, Schedulers.c());
        }
        return Single.error(th);
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: b */
    public Publisher<?> apply(Flowable<Throwable> flowable) throws Exception {
        return flowable.D(new Function() { // from class: ee.mtakso.driver.utils.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource c8;
                c8 = RetryWithDelaySingle.this.c((Throwable) obj);
                return c8;
            }
        });
    }
}
