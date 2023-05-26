package eu.bolt.driver.stories.ui.screen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StoryViewModel_Factory implements Factory<StoryViewModel> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final StoryViewModel_Factory f41576a = new StoryViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static StoryViewModel_Factory a() {
        return InstanceHolder.f41576a;
    }

    public static StoryViewModel c() {
        return new StoryViewModel();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryViewModel get() {
        return c();
    }
}
