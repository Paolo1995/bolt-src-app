package ee.mtakso.driver.log;

import ee.mtakso.driver.log.applog.AppLogWatcher;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.BaseService;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogService.kt */
/* loaded from: classes3.dex */
public final class LogService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final DriverFeatures f21020a;

    /* renamed from: b  reason: collision with root package name */
    private final BigQueryLogWatcher f21021b;

    /* renamed from: c  reason: collision with root package name */
    private final AppLogWatcher f21022c;

    /* renamed from: d  reason: collision with root package name */
    private final LogManager f21023d;

    /* renamed from: e  reason: collision with root package name */
    private final StorageConsumer f21024e;

    /* renamed from: f  reason: collision with root package name */
    private final OrderStateStrategy f21025f;

    @Inject
    public LogService(DriverFeatures driverFeatures, BigQueryLogWatcher bigQueryLogWatcher, AppLogWatcher appLogWatcher, LogManager logManager, StorageConsumer storageConsumer, OrderStateStrategy orderStateStrategy) {
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(bigQueryLogWatcher, "bigQueryLogWatcher");
        Intrinsics.f(appLogWatcher, "appLogWatcher");
        Intrinsics.f(logManager, "logManager");
        Intrinsics.f(storageConsumer, "storageConsumer");
        Intrinsics.f(orderStateStrategy, "orderStateStrategy");
        this.f21020a = driverFeatures;
        this.f21021b = bigQueryLogWatcher;
        this.f21022c = appLogWatcher;
        this.f21023d = logManager;
        this.f21024e = storageConsumer;
        this.f21025f = orderStateStrategy;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        if (this.f21020a.l()) {
            this.f21021b.start();
        }
        if (!this.f21020a.d().isEmpty()) {
            this.f21022c.start();
        }
        if (this.f21020a.l() || (!this.f21020a.d().isEmpty())) {
            this.f21023d.b(this.f21024e);
        }
        if (this.f21020a.e().contains("did_not_respond")) {
            this.f21023d.b(this.f21025f);
            return false;
        }
        return false;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f21023d.c();
        this.f21022c.stop();
        this.f21021b.stop();
    }
}
