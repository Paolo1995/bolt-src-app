package ee.mtakso.driver.log.strategy.memory;

import android.annotation.SuppressLint;
import ee.mtakso.driver.log.applog.ApplogUploader;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.network.client.applog.ApplogEntry;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalevipoeg;
import eu.bolt.kalev.LogEntry;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewStrategy.kt */
@Singleton
/* loaded from: classes3.dex */
public final class WebViewStrategy implements Kalevipoeg {

    /* renamed from: a  reason: collision with root package name */
    private final ApplogUploader f21179a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ApplogEntry> f21180b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantLock f21181c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f21182d;

    @Inject
    public WebViewStrategy(ApplogUploader applogUploader, DeviceFeatures deviceFeatures) {
        Intrinsics.f(applogUploader, "applogUploader");
        Intrinsics.f(deviceFeatures, "deviceFeatures");
        this.f21179a = applogUploader;
        this.f21180b = new ArrayList();
        this.f21181c = new ReentrantLock();
        this.f21182d = deviceFeatures.a().contains("webview");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean e(WebViewStrategy this$0) {
        Intrinsics.f(this$0, "this$0");
        return Boolean.valueOf(this$0.f21179a.c(this$0.f21180b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WebViewStrategy this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f21180b.clear();
        this$0.f21181c.unlock();
    }

    private final void h(LogEntry logEntry) {
        int b8;
        long j8;
        List<ApplogEntry> list = this.f21180b;
        Map<String, Object> c8 = logEntry.c();
        b8 = MapsKt__MapsJVMKt.b(c8.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(b8);
        Iterator<T> it = c8.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String a8 = ApplogUploader.f21057e.a(logEntry.e());
        String d8 = logEntry.d();
        Long h8 = logEntry.h();
        if (h8 != null) {
            j8 = h8.longValue();
        } else {
            j8 = 0;
        }
        list.add(new ApplogEntry(linkedHashMap, a8, d8, j8));
    }

    @Override // eu.bolt.kalev.Kalevipoeg
    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        if (this.f21182d && !this.f21181c.isLocked() && Intrinsics.a(entry.f(), "WebView Tracker")) {
            h(entry);
        }
    }

    @SuppressLint({"CheckResult"})
    public final void d() {
        this.f21181c.lock();
        Single u7 = Single.u(new Callable() { // from class: u1.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean e8;
                e8 = WebViewStrategy.e(WebViewStrategy.this);
                return e8;
            }
        });
        Intrinsics.e(u7, "fromCallable { applogUpl…der.uploadEntries(logs) }");
        SingleExtKt.d(u7).j(new Action() { // from class: u1.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                WebViewStrategy.f(WebViewStrategy.this);
            }
        }).G();
    }

    public final void g() {
        ReentrantLock reentrantLock = this.f21181c;
        reentrantLock.lock();
        try {
            this.f21180b.clear();
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
