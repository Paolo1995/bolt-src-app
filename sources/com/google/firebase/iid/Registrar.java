package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@Keep
@KeepForSdk
/* loaded from: classes3.dex */
public final class Registrar implements ComponentRegistrar {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class FIIDInternalAdapter implements FirebaseInstanceIdInternal {

        /* renamed from: a  reason: collision with root package name */
        final FirebaseInstanceId f16324a;

        public FIIDInternalAdapter(FirebaseInstanceId firebaseInstanceId) {
            this.f16324a = firebaseInstanceId;
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public String a() {
            return this.f16324a.n();
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public Task<String> b() {
            String n8 = this.f16324a.n();
            if (n8 != null) {
                return Tasks.forResult(n8);
            }
            return this.f16324a.j().continueWith(Registrar$FIIDInternalAdapter$$Lambda$0.f16323a);
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public void c(FirebaseInstanceIdInternal.NewTokenListener newTokenListener) {
            this.f16324a.a(newTokenListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.c(UserAgentPublisher.class), componentContainer.c(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ FirebaseInstanceIdInternal lambda$getComponents$1$Registrar(ComponentContainer componentContainer) {
        return new FIIDInternalAdapter((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.c(FirebaseInstanceId.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.i(UserAgentPublisher.class)).b(Dependency.i(HeartBeatInfo.class)).b(Dependency.j(FirebaseInstallationsApi.class)).f(Registrar$$Lambda$0.f16321a).c().d(), Component.c(FirebaseInstanceIdInternal.class).b(Dependency.j(FirebaseInstanceId.class)).f(Registrar$$Lambda$1.f16322a).d(), LibraryVersionComponent.b("fire-iid", "21.1.0"));
    }
}
