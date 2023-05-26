package ee.mtakso.driver.platform.google.network.store_integrity;

import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultRequest;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayStoreVerificationResultToRequestMapper.kt */
/* loaded from: classes3.dex */
public final class PlayStoreVerificationResultToRequestMapper implements StoreIntegrityVerificationResultToRequestMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f23332a = new Companion(null);

    /* compiled from: PlayStoreVerificationResultToRequestMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper
    public StoreIntegrityVerificationResultRequest a(StoreIntegrityVerificationResult result) {
        Intrinsics.f(result, "result");
        if (result instanceof StoreIntegrityVerificationResult.Success) {
            return new PlayStoreVerificationResultRequest("google", result.a(), ((StoreIntegrityVerificationResult.Success) result).b());
        } else if (result instanceof StoreIntegrityVerificationResult.Error) {
            StoreIntegrityVerificationResult.Error error = (StoreIntegrityVerificationResult.Error) result;
            return new PlayStoreVerificationResultErrorRequest("google", result.a(), error.getMessage(), error.getMessage());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
