package ee.mtakso.driver.utils.logs;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class PersistPoeg_Factory implements Factory<PersistPoeg> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PersistPoeg_Factory f36446a = new PersistPoeg_Factory();

        private InstanceHolder() {
        }
    }

    public static PersistPoeg_Factory a() {
        return InstanceHolder.f36446a;
    }

    public static PersistPoeg c() {
        return new PersistPoeg();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PersistPoeg get() {
        return c();
    }
}
