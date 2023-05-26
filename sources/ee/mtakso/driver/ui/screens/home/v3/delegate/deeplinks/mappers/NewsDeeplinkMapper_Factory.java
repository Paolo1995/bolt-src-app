package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NewsDeeplinkMapper_Factory implements Factory<NewsDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final NewsDeeplinkMapper_Factory f29992a = new NewsDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static NewsDeeplinkMapper_Factory a() {
        return InstanceHolder.f29992a;
    }

    public static NewsDeeplinkMapper c() {
        return new NewsDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NewsDeeplinkMapper get() {
        return c();
    }
}
