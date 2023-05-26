package eu.bolt.driver.stories.ui.screen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.stories.mapper.StoryMapper;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.driver.stories.service.analytic.StoryAnalyticDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StorySetFragment_Factory implements Factory<StorySetFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseFragmentParams> f41567a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ViewModelFactory> f41568b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<StoryMapper> f41569c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<StoryAnalyticDelegate> f41570d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HtmlEngine> f41571e;

    public StorySetFragment_Factory(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2, Provider<StoryMapper> provider3, Provider<StoryAnalyticDelegate> provider4, Provider<HtmlEngine> provider5) {
        this.f41567a = provider;
        this.f41568b = provider2;
        this.f41569c = provider3;
        this.f41570d = provider4;
        this.f41571e = provider5;
    }

    public static StorySetFragment_Factory a(Provider<BaseFragmentParams> provider, Provider<ViewModelFactory> provider2, Provider<StoryMapper> provider3, Provider<StoryAnalyticDelegate> provider4, Provider<HtmlEngine> provider5) {
        return new StorySetFragment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static StorySetFragment c(BaseFragmentParams baseFragmentParams, ViewModelFactory viewModelFactory, StoryMapper storyMapper, StoryAnalyticDelegate storyAnalyticDelegate, HtmlEngine htmlEngine) {
        return new StorySetFragment(baseFragmentParams, viewModelFactory, storyMapper, storyAnalyticDelegate, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StorySetFragment get() {
        return c(this.f41567a.get(), this.f41568b.get(), this.f41569c.get(), this.f41570d.get(), this.f41571e.get());
    }
}
