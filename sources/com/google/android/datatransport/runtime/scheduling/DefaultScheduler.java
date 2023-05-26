package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

/* loaded from: classes.dex */
public class DefaultScheduler implements Scheduler {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f12198f = Logger.getLogger(TransportRuntime.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final WorkScheduler f12199a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f12200b;

    /* renamed from: c  reason: collision with root package name */
    private final BackendRegistry f12201c;

    /* renamed from: d  reason: collision with root package name */
    private final EventStore f12202d;

    /* renamed from: e  reason: collision with root package name */
    private final SynchronizationGuard f12203e;

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f12200b = executor;
        this.f12201c = backendRegistry;
        this.f12199a = workScheduler;
        this.f12202d = eventStore;
        this.f12203e = synchronizationGuard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(TransportContext transportContext, EventInternal eventInternal) {
        this.f12202d.X0(transportContext, eventInternal);
        this.f12199a.a(transportContext, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = this.f12201c.get(transportContext.b());
            if (transportBackend == null) {
                String format = String.format("Transport backend '%s' is not registered", transportContext.b());
                f12198f.warning(format);
                transportScheduleCallback.a(new IllegalArgumentException(format));
                return;
            }
            final EventInternal a8 = transportBackend.a(eventInternal);
            this.f12203e.c(new SynchronizationGuard.CriticalSection() { // from class: u.b
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Object d8;
                    d8 = DefaultScheduler.this.d(transportContext, a8);
                    return d8;
                }
            });
            transportScheduleCallback.a(null);
        } catch (Exception e8) {
            Logger logger = f12198f;
            logger.warning("Error scheduling event " + e8.getMessage());
            transportScheduleCallback.a(e8);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public void a(final TransportContext transportContext, final EventInternal eventInternal, final TransportScheduleCallback transportScheduleCallback) {
        this.f12200b.execute(new Runnable() { // from class: u.a
            @Override // java.lang.Runnable
            public final void run() {
                DefaultScheduler.this.e(transportContext, transportScheduleCallback, eventInternal);
            }
        });
    }
}
