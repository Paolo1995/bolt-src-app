package ee.mtakso.driver.service.voip.noanswer;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NoAnswerCallCache_Factory implements Factory<NoAnswerCallCache> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final NoAnswerCallCache_Factory f26184a = new NoAnswerCallCache_Factory();

        private InstanceHolder() {
        }
    }

    public static NoAnswerCallCache_Factory a() {
        return InstanceHolder.f26184a;
    }

    public static NoAnswerCallCache c() {
        return new NoAnswerCallCache();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NoAnswerCallCache get() {
        return c();
    }
}
