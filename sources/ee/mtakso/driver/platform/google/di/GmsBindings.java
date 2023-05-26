package ee.mtakso.driver.platform.google.di;

import dagger.Binds;
import dagger.Module;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.geo.GeoLocationSource;
import ee.mtakso.driver.platform.google.ads.GmsAdvertiserIdProvider;
import ee.mtakso.driver.platform.google.autofill.GmsSmsRetriever;
import ee.mtakso.driver.platform.google.check.GmsAvailabilityManager;
import ee.mtakso.driver.platform.google.core.GmsPlatformManager;
import ee.mtakso.driver.platform.google.geo.GmsLocationSource;
import ee.mtakso.driver.platform.google.installation.FirebaseInstallationIdProvider;
import ee.mtakso.driver.platform.google.push.FirebasePushTokenManager;
import ee.mtakso.driver.platform.google.security.GmsSecurityManager;
import ee.mtakso.driver.platform.google.store_integrity.GoogleIntegrityCheck;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.platform.security.SecurityManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;

/* compiled from: GmsModule.kt */
@Module
/* loaded from: classes3.dex */
public interface GmsBindings {
    @Binds
    TokenProvider a(FirebasePushTokenManager firebasePushTokenManager);

    @Binds
    GeoLocationSource b(GmsLocationSource gmsLocationSource);

    @Binds
    InstallationIdProvider c(FirebaseInstallationIdProvider firebaseInstallationIdProvider);

    @Binds
    AdvertiserIdProvider d(GmsAdvertiserIdProvider gmsAdvertiserIdProvider);

    @Binds
    PlatformAvailabilityManager e(GmsAvailabilityManager gmsAvailabilityManager);

    @Binds
    PlatformManager f(GmsPlatformManager gmsPlatformManager);

    @Binds
    SecurityManager g(GmsSecurityManager gmsSecurityManager);

    @Binds
    StoreIntegrityCheck h(GoogleIntegrityCheck googleIntegrityCheck);

    @Binds
    ConfirmationCodeRetriever i(GmsSmsRetriever gmsSmsRetriever);
}
