package eu.bolt.android.stories.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StoryButtonStyleMapper_Factory implements Factory<StoryButtonStyleMapper> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final StoryButtonStyleMapper_Factory f37549a = new StoryButtonStyleMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static StoryButtonStyleMapper_Factory a() {
        return InstanceHolder.f37549a;
    }

    public static StoryButtonStyleMapper c() {
        return new StoryButtonStyleMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryButtonStyleMapper get() {
        return c();
    }
}
