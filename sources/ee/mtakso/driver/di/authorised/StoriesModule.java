package ee.mtakso.driver.di.authorised;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import eu.bolt.driver.stories.ui.screen.StoryFragment;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import eu.bolt.driver.stories.ui.screen.StorySetViewModel;
import eu.bolt.driver.stories.ui.screen.StoryViewModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoriesModule.kt */
@Module
/* loaded from: classes3.dex */
public final class StoriesModule {
    @Provides
    @IntoMap
    public final Fragment a(StoryFragment impl) {
        Intrinsics.f(impl, "impl");
        return impl;
    }

    @Provides
    @IntoMap
    public final Fragment b(StorySetFragment impl) {
        Intrinsics.f(impl, "impl");
        return impl;
    }

    @Provides
    @IntoMap
    public final ViewModel c(StorySetViewModel impl) {
        Intrinsics.f(impl, "impl");
        return impl;
    }

    @Provides
    @IntoMap
    public final ViewModel d(StoryViewModel impl) {
        Intrinsics.f(impl, "impl");
        return impl;
    }
}
