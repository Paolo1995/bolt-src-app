package ee.mtakso.driver.service.time;

import ee.mtakso.driver.service.time.clock.Clock;
import eu.bolt.kalev.Kalev;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class AnchoredTrueTimeProvider implements TrueTimeProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f26021a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f26022b;

    /* renamed from: c  reason: collision with root package name */
    private long f26023c = Long.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private long f26024d = Long.MIN_VALUE;

    @Inject
    public AnchoredTrueTimeProvider(Clock clock, Clock clock2) {
        this.f26021a = clock;
        this.f26022b = clock2;
    }

    @Override // ee.mtakso.driver.service.time.TrueTimeProvider
    public long a() {
        return TimeUnit.MILLISECONDS.toSeconds(b());
    }

    @Override // ee.mtakso.driver.service.time.TrueTimeProvider
    public synchronized long b() {
        if (!d()) {
            return this.f26022b.a();
        }
        return this.f26023c + (this.f26021a.a() - this.f26024d);
    }

    public synchronized void c(long j8) {
        if (d()) {
            Kalev.b("Ignoring second backend time init.");
            return;
        }
        this.f26023c = j8;
        this.f26024d = this.f26021a.a();
    }

    public synchronized boolean d() {
        boolean z7;
        if (this.f26023c > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        return z7;
    }
}
