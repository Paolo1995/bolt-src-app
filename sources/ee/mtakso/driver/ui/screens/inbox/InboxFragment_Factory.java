package ee.mtakso.driver.ui.screens.inbox;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.stories.StoryManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class InboxFragment_Factory implements Factory<InboxFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30356a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<StoryManager> f30357b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RoutingManager> f30358c;

    public InboxFragment_Factory(Provider<BaseUiDependencies> provider, Provider<StoryManager> provider2, Provider<RoutingManager> provider3) {
        this.f30356a = provider;
        this.f30357b = provider2;
        this.f30358c = provider3;
    }

    public static InboxFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<StoryManager> provider2, Provider<RoutingManager> provider3) {
        return new InboxFragment_Factory(provider, provider2, provider3);
    }

    public static InboxFragment c(BaseUiDependencies baseUiDependencies, StoryManager storyManager, RoutingManager routingManager) {
        return new InboxFragment(baseUiDependencies, storyManager, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InboxFragment get() {
        return c(this.f30356a.get(), this.f30357b.get(), this.f30358c.get());
    }
}
