package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

/* loaded from: classes.dex */
final class TransportImpl<T> implements Transport<T> {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f12109a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12110b;

    /* renamed from: c  reason: collision with root package name */
    private final Encoding f12111c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<T, byte[]> f12112d;

    /* renamed from: e  reason: collision with root package name */
    private final TransportInternal f12113e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.f12109a = transportContext;
        this.f12110b = str;
        this.f12111c = encoding;
        this.f12112d = transformer;
        this.f12113e = transportInternal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Exception exc) {
    }

    @Override // com.google.android.datatransport.Transport
    public void a(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        this.f12113e.a(SendRequest.a().e(this.f12109a).c(event).f(this.f12110b).d(this.f12112d).b(this.f12111c).a(), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public void b(Event<T> event) {
        a(event, new TransportScheduleCallback() { // from class: com.google.android.datatransport.runtime.a
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void a(Exception exc) {
                TransportImpl.d(exc);
            }
        });
    }
}
