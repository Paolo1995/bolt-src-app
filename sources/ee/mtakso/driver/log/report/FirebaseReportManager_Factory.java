package ee.mtakso.driver.log.report;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FirebaseReportManager_Factory implements Factory<FirebaseReportManager> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final FirebaseReportManager_Factory f21084a = new FirebaseReportManager_Factory();

        private InstanceHolder() {
        }
    }

    public static FirebaseReportManager_Factory a() {
        return InstanceHolder.f21084a;
    }

    public static FirebaseReportManager c() {
        return new FirebaseReportManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FirebaseReportManager get() {
        return c();
    }
}
