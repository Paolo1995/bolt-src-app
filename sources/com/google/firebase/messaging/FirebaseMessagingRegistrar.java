package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@Keep
@KeepForSdk
/* loaded from: classes3.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    private static class DevNullTransport<T> implements Transport<T> {
        private DevNullTransport() {
        }

        @Override // com.google.android.datatransport.Transport
        public void a(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
            transportScheduleCallback.a(null);
        }

        @Override // com.google.android.datatransport.Transport
        public void b(Event<T> event) {
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class DevNullTransportFactory implements TransportFactory {
        @Override // com.google.android.datatransport.TransportFactory
        public <T> Transport<T> a(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
            return new DevNullTransport();
        }
    }

    static TransportFactory determineFactory(TransportFactory transportFactory) {
        if (transportFactory == null) {
            return new DevNullTransportFactory();
        }
        try {
            transportFactory.a("test", String.class, Encoding.b("json"), FirebaseMessagingRegistrar$$Lambda$1.f16512a);
            return transportFactory;
        } catch (IllegalArgumentException unused) {
            return new DevNullTransportFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.get(FirebaseInstanceIdInternal.class), componentContainer.c(UserAgentPublisher.class), componentContainer.c(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), determineFactory((TransportFactory) componentContainer.get(TransportFactory.class)), (Subscriber) componentContainer.get(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.c(FirebaseMessaging.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.h(FirebaseInstanceIdInternal.class)).b(Dependency.i(UserAgentPublisher.class)).b(Dependency.i(HeartBeatInfo.class)).b(Dependency.h(TransportFactory.class)).b(Dependency.j(FirebaseInstallationsApi.class)).b(Dependency.j(Subscriber.class)).f(FirebaseMessagingRegistrar$$Lambda$0.f16511a).c().d(), LibraryVersionComponent.b("fire-fcm", "20.1.7_1p"));
    }
}
