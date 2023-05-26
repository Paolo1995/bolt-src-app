package ee.mtakso.driver.platform.google.security;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import ee.mtakso.driver.platform.security.SecurityManager;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GmsSecurityManager.kt */
/* loaded from: classes3.dex */
public final class GmsSecurityManager implements SecurityManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23338a;

    @Inject
    public GmsSecurityManager(Context context) {
        Intrinsics.f(context, "context");
        this.f23338a = context;
    }

    @Override // ee.mtakso.driver.platform.security.SecurityManager
    public void a() {
        try {
            ProviderInstaller.installIfNeeded(this.f23338a);
        } catch (GooglePlayServicesNotAvailableException e8) {
            Kalev.o(e8).b("Google Play Services fatal on provider install");
        } catch (GooglePlayServicesRepairableException e9) {
            Kalev.o(e9).b("Google Play Services failure on provider install");
        }
    }

    @Override // ee.mtakso.driver.platform.security.SecurityManager
    public void b() {
        ProviderInstaller.installIfNeededAsync(this.f23338a, new ProviderInstaller.ProviderInstallListener() { // from class: ee.mtakso.driver.platform.google.security.GmsSecurityManager$installSecurityPatchAsync$1
            @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
            public void onProviderInstallFailed(int i8, Intent intent) {
                Kalev.n("code", Integer.valueOf(i8)).b("Google Play Services fatal on provider install");
            }

            @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
            public void onProviderInstalled() {
            }
        });
    }
}
