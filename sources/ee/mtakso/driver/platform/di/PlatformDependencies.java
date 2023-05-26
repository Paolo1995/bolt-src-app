package ee.mtakso.driver.platform.di;

import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.push.PushManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;

/* compiled from: PlatformDependencies.kt */
/* loaded from: classes3.dex */
public interface PlatformDependencies {
    StoreIntegrityVerificationResultToRequestMapper H();

    ConfirmationCodeRetriever Y();

    PushManager j();

    StoreIntegrityCheck q1();
}
