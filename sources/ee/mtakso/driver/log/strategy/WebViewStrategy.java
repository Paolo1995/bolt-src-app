package ee.mtakso.driver.log.strategy;

import ee.mtakso.driver.log.storage.ApplogSync;
import ee.mtakso.driver.log.storage.LogEntity;
import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.LogEntry;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewStrategy.kt */
/* loaded from: classes3.dex */
public final class WebViewStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f21167a;

    /* renamed from: b  reason: collision with root package name */
    private final LogStorage f21168b;

    @Inject
    public WebViewStrategy(DriverProvider driverProvider, LogStorage logStorage) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(logStorage, "logStorage");
        this.f21167a = driverProvider;
        this.f21168b = logStorage;
    }

    public void a(LogEntry entry) {
        int v7;
        Intrinsics.f(entry, "entry");
        if (this.f21167a.p().d().contains("webview") && Intrinsics.a(entry.f(), "WebView Tracker")) {
            List<LogEntity> f8 = this.f21168b.f("WebView Tracker");
            LogStorage logStorage = this.f21168b;
            v7 = CollectionsKt__IterablesKt.v(f8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (LogEntity logEntity : f8) {
                arrayList.add(new ApplogSync(logEntity.f(), false, 2, null));
            }
            logStorage.a(arrayList);
        }
    }
}
