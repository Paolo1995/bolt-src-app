package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PayoutDetailsMapper_Factory implements Factory<PayoutDetailsMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PayoutDetailsMapper_Factory f28675a = new PayoutDetailsMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static PayoutDetailsMapper_Factory a() {
        return InstanceHolder.f28675a;
    }

    public static PayoutDetailsMapper c() {
        return new PayoutDetailsMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PayoutDetailsMapper get() {
        return c();
    }
}
