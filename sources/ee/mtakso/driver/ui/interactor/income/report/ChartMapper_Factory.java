package ee.mtakso.driver.ui.interactor.income.report;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChartMapper_Factory implements Factory<ChartMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ChartMapper_Factory f26586a = new ChartMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ChartMapper_Factory a() {
        return InstanceHolder.f26586a;
    }

    public static ChartMapper c() {
        return new ChartMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChartMapper get() {
        return c();
    }
}
