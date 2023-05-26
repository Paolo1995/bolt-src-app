package ee.mtakso.driver.identity.verification;

import android.app.Application;
import ee.mtakso.driver.di.Injector;
import eu.bolt.driver.verification.identity.IdentityVerificationSdk;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityVerificationManager.kt */
/* loaded from: classes3.dex */
public final class IdentityVerificationManager {

    /* renamed from: a  reason: collision with root package name */
    private final PartnerIdentityVerificationInitializer f20980a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f20981b;

    @Inject
    public IdentityVerificationManager(PartnerIdentityVerificationInitializer partnerIdentityVerificationInitializer) {
        Lazy b8;
        Intrinsics.f(partnerIdentityVerificationInitializer, "partnerIdentityVerificationInitializer");
        this.f20980a = partnerIdentityVerificationInitializer;
        b8 = LazyKt__LazyJVMKt.b(new Function0<IdentityVerificationInitializer>() { // from class: ee.mtakso.driver.identity.verification.IdentityVerificationManager$identityVerificationInitializer$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final IdentityVerificationInitializer invoke() {
                return Injector.f20166d.b().Y1().z();
            }
        });
        this.f20981b = b8;
    }

    private final IdentityVerificationInitializer a() {
        return (IdentityVerificationInitializer) this.f20981b.getValue();
    }

    public final void b(Application application) {
        Intrinsics.f(application, "application");
        a().d(application);
    }

    public final void c(Application application) {
        Intrinsics.f(application, "application");
        this.f20980a.d(application);
    }

    public final void d(String flowRunId) {
        Intrinsics.f(flowRunId, "flowRunId");
        eu.bolt.driver.verification.identity.IdentityVerificationManager a8 = IdentityVerificationSdk.f41584a.a();
        if (a8 != null) {
            a8.b(flowRunId);
        }
    }
}
