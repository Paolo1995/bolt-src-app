package eu.bolt.driver.voip.service.call.tone;

import android.media.ToneGenerator;
import eu.bolt.driver.voip.service.call.tone.ToneManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToneManager.kt */
/* loaded from: classes5.dex */
public final class ToneManager {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f41644d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private ToneGenerator f41645a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f41646b = Executors.newScheduledThreadPool(1);

    /* renamed from: c  reason: collision with root package name */
    private volatile ScheduledFuture<?> f41647c;

    /* compiled from: ToneManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ToneManager this$0) {
        Intrinsics.f(this$0, "this$0");
        ToneGenerator toneGenerator = this$0.f41645a;
        if (toneGenerator != null) {
            toneGenerator.startTone(34, 1500);
        }
    }

    public final void b() {
        this.f41645a = new ToneGenerator(0, 80);
        this.f41647c = this.f41646b.scheduleAtFixedRate(new Runnable() { // from class: l7.a
            @Override // java.lang.Runnable
            public final void run() {
                ToneManager.c(ToneManager.this);
            }
        }, 0L, 3500L, TimeUnit.MILLISECONDS);
    }

    public final void d() {
        ScheduledFuture<?> scheduledFuture = this.f41647c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.f41647c = null;
        ToneGenerator toneGenerator = this.f41645a;
        if (toneGenerator != null) {
            toneGenerator.stopTone();
        }
        ToneGenerator toneGenerator2 = this.f41645a;
        if (toneGenerator2 != null) {
            toneGenerator2.release();
        }
        this.f41645a = null;
    }
}
