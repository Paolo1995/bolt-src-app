package ee.mtakso.driver.ui.screens.earnings.v2.balance;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReportPageMapper_Factory implements Factory<ReportPageMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ReportPageMapper_Factory f28570a = new ReportPageMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ReportPageMapper_Factory a() {
        return InstanceHolder.f28570a;
    }

    public static ReportPageMapper c() {
        return new ReportPageMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReportPageMapper get() {
        return c();
    }
}
