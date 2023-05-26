package ee.mtakso.driver.service.polling.message;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollMessageCache_Factory implements Factory<PollMessageCache> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PollMessageCache_Factory f25577a = new PollMessageCache_Factory();

        private InstanceHolder() {
        }
    }

    public static PollMessageCache_Factory a() {
        return InstanceHolder.f25577a;
    }

    public static PollMessageCache c() {
        return new PollMessageCache();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollMessageCache get() {
        return c();
    }
}
