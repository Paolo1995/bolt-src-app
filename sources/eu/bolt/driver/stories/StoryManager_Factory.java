package eu.bolt.driver.stories;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StoryManager_Factory implements Factory<StoryManager> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final StoryManager_Factory f41544a = new StoryManager_Factory();

        private InstanceHolder() {
        }
    }

    public static StoryManager_Factory a() {
        return InstanceHolder.f41544a;
    }

    public static StoryManager c() {
        return new StoryManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryManager get() {
        return c();
    }
}
