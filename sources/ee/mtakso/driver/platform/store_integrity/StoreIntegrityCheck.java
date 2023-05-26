package ee.mtakso.driver.platform.store_integrity;

import io.reactivex.Single;

/* compiled from: StoreIntegrityCheck.kt */
/* loaded from: classes3.dex */
public interface StoreIntegrityCheck {
    Single<StoreIntegrityVerificationResult> a(String str, String str2);
}
