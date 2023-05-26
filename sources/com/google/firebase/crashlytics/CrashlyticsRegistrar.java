package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseCrashlytics b(ComponentContainer componentContainer) {
        return FirebaseCrashlytics.b((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.d(CrashlyticsNativeComponent.class), componentContainer.d(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.c(FirebaseCrashlytics.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.j(FirebaseInstallationsApi.class)).b(Dependency.a(CrashlyticsNativeComponent.class)).b(Dependency.a(AnalyticsConnector.class)).f(new ComponentFactory() { // from class: com.google.firebase.crashlytics.d
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                FirebaseCrashlytics b8;
                b8 = CrashlyticsRegistrar.this.b(componentContainer);
                return b8;
            }
        }).e().d(), LibraryVersionComponent.b("fire-cls", "18.2.12"));
    }
}
