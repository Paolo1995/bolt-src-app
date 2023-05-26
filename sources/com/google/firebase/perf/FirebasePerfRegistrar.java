package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class FirebasePerfRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ FirebasePerformance lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebasePerformance((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.c(RemoteConfigComponent.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.c(TransportFactory.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.c(FirebasePerformance.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.k(RemoteConfigComponent.class)).b(Dependency.j(FirebaseInstallationsApi.class)).b(Dependency.k(TransportFactory.class)).f(FirebasePerfRegistrar$$Lambda$1.b()).e().d(), LibraryVersionComponent.b("fire-perf", "19.1.1"));
    }
}
