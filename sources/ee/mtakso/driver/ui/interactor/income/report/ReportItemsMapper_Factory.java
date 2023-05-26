package ee.mtakso.driver.ui.interactor.income.report;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ReportItemsMapper_Factory implements Factory<ReportItemsMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ReportItemsMapper_Factory f26587a = new ReportItemsMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ReportItemsMapper_Factory a() {
        return InstanceHolder.f26587a;
    }

    public static ReportItemsMapper c() {
        return new ReportItemsMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ReportItemsMapper get() {
        return c();
    }
}
