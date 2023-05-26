package eu.bolt.driver.stories.service.analytic;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StoryAnalyticDelegate_Factory implements Factory<StoryAnalyticDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StoryAnalytics> f41553a;

    public StoryAnalyticDelegate_Factory(Provider<StoryAnalytics> provider) {
        this.f41553a = provider;
    }

    public static StoryAnalyticDelegate_Factory a(Provider<StoryAnalytics> provider) {
        return new StoryAnalyticDelegate_Factory(provider);
    }

    public static StoryAnalyticDelegate c(StoryAnalytics storyAnalytics) {
        return new StoryAnalyticDelegate(storyAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryAnalyticDelegate get() {
        return c(this.f41553a.get());
    }
}
