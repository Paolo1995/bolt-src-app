package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* loaded from: classes.dex */
public class Uploader {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12231a;

    /* renamed from: b  reason: collision with root package name */
    private final BackendRegistry f12232b;

    /* renamed from: c  reason: collision with root package name */
    private final EventStore f12233c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkScheduler f12234d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f12235e;

    /* renamed from: f  reason: collision with root package name */
    private final SynchronizationGuard f12236f;

    /* renamed from: g  reason: collision with root package name */
    private final Clock f12237g;

    /* renamed from: h  reason: collision with root package name */
    private final Clock f12238h;

    /* renamed from: i  reason: collision with root package name */
    private final ClientHealthMetricsStore f12239i;

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f12231a = context;
        this.f12232b = backendRegistry;
        this.f12233c = eventStore;
        this.f12234d = workScheduler;
        this.f12235e = executor;
        this.f12236f = synchronizationGuard;
        this.f12237g = clock;
        this.f12238h = clock2;
        this.f12239i = clientHealthMetricsStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(TransportContext transportContext) {
        return Boolean.valueOf(this.f12233c.h0(transportContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(TransportContext transportContext) {
        return this.f12233c.t0(transportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, TransportContext transportContext, long j8) {
        this.f12233c.i0(iterable);
        this.f12233c.A(transportContext, this.f12237g.a() + j8);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f12233c.p(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f12239i.a();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f12239i.g(((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(TransportContext transportContext, long j8) {
        this.f12233c.A(transportContext, this.f12237g.a() + j8);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(TransportContext transportContext, int i8) {
        this.f12234d.a(transportContext, i8 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final TransportContext transportContext, final int i8, Runnable runnable) {
        try {
            try {
                SynchronizationGuard synchronizationGuard = this.f12236f;
                final EventStore eventStore = this.f12233c;
                Objects.requireNonNull(eventStore);
                synchronizationGuard.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.e
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Integer.valueOf(EventStore.this.o());
                    }
                });
                if (!k()) {
                    this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.f
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object s7;
                            s7 = Uploader.this.s(transportContext, i8);
                            return s7;
                        }
                    });
                } else {
                    u(transportContext, i8);
                }
            } catch (SynchronizationException unused) {
                this.f12234d.a(transportContext, i8 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public EventInternal j(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.f12236f;
        final ClientHealthMetricsStore clientHealthMetricsStore = this.f12239i;
        Objects.requireNonNull(clientHealthMetricsStore);
        return transportBackend.a(EventInternal.a().i(this.f12237g.a()).k(this.f12238h.a()).j("GDT_CLIENT_METRICS").h(new EncodedPayload(Encoding.b("proto"), ((ClientMetrics) synchronizationGuard.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.d
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                return ClientHealthMetricsStore.this.e();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12231a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    BackendResponse u(final TransportContext transportContext, int i8) {
        BackendResponse b8;
        TransportBackend transportBackend = this.f12232b.get(transportContext.b());
        long j8 = 0;
        BackendResponse e8 = BackendResponse.e(0L);
        while (true) {
            final long j9 = j8;
            while (((Boolean) this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.g
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean l8;
                    l8 = Uploader.this.l(transportContext);
                    return l8;
                }
            })).booleanValue()) {
                final Iterable<PersistedEvent> iterable = (Iterable) this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.h
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Iterable m8;
                        m8 = Uploader.this.m(transportContext);
                        return m8;
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return e8;
                }
                if (transportBackend == null) {
                    Logging.b("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                    b8 = BackendResponse.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (PersistedEvent persistedEvent : iterable) {
                        arrayList.add(persistedEvent.b());
                    }
                    if (transportContext.e()) {
                        arrayList.add(j(transportBackend));
                    }
                    b8 = transportBackend.b(BackendRequest.a().b(arrayList).c(transportContext.c()).a());
                }
                e8 = b8;
                if (e8.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.i
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object n8;
                            n8 = Uploader.this.n(iterable, transportContext, j9);
                            return n8;
                        }
                    });
                    this.f12234d.b(transportContext, i8 + 1, true);
                    return e8;
                }
                this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.j
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Object o8;
                        o8 = Uploader.this.o(iterable);
                        return o8;
                    }
                });
                if (e8.c() == BackendResponse.Status.OK) {
                    j8 = Math.max(j9, e8.b());
                    if (transportContext.e()) {
                        this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.k
                            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                            public final Object execute() {
                                Object p8;
                                p8 = Uploader.this.p();
                                return p8;
                            }
                        });
                    }
                } else if (e8.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    for (PersistedEvent persistedEvent2 : iterable) {
                        String j10 = persistedEvent2.b().j();
                        if (!hashMap.containsKey(j10)) {
                            hashMap.put(j10, 1);
                        } else {
                            hashMap.put(j10, Integer.valueOf(((Integer) hashMap.get(j10)).intValue() + 1));
                        }
                    }
                    this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.l
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object q8;
                            q8 = Uploader.this.q(hashMap);
                            return q8;
                        }
                    });
                }
            }
            this.f12236f.c(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.m
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Object r7;
                    r7 = Uploader.this.r(transportContext, j9);
                    return r7;
                }
            });
            return e8;
        }
    }

    public void v(final TransportContext transportContext, final int i8, final Runnable runnable) {
        this.f12235e.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.c
            @Override // java.lang.Runnable
            public final void run() {
                Uploader.this.t(transportContext, i8, runnable);
            }
        });
    }
}
