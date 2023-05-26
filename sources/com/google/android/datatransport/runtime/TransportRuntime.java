package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class TransportRuntime implements TransportInternal {

    /* renamed from: e  reason: collision with root package name */
    private static volatile TransportRuntimeComponent f12114e;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f12115a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f12116b;

    /* renamed from: c  reason: collision with root package name */
    private final Scheduler f12117c;

    /* renamed from: d  reason: collision with root package name */
    private final Uploader f12118d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.f12115a = clock;
        this.f12116b = clock2;
        this.f12117c = scheduler;
        this.f12118d = uploader;
        workInitializer.c();
    }

    private EventInternal b(SendRequest sendRequest) {
        return EventInternal.a().i(this.f12115a.a()).k(this.f12116b.a()).j(sendRequest.g()).h(new EncodedPayload(sendRequest.b(), sendRequest.d())).g(sendRequest.c().a()).d();
    }

    public static TransportRuntime c() {
        TransportRuntimeComponent transportRuntimeComponent = f12114e;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<Encoding> d(Destination destination) {
        if (destination instanceof EncodedDestination) {
            return Collections.unmodifiableSet(((EncodedDestination) destination).a());
        }
        return Collections.singleton(Encoding.b("proto"));
    }

    public static void f(Context context) {
        if (f12114e == null) {
            synchronized (TransportRuntime.class) {
                if (f12114e == null) {
                    f12114e = DaggerTransportRuntimeComponent.e().a(context).build();
                }
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportInternal
    public void a(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.f12117c.a(sendRequest.f().f(sendRequest.c().c()), b(sendRequest), transportScheduleCallback);
    }

    public Uploader e() {
        return this.f12118d;
    }

    public TransportFactory g(Destination destination) {
        return new TransportFactoryImpl(d(destination), TransportContext.a().b(destination.getName()).c(destination.getExtras()).a(), this);
    }
}
