package eu.bolt.android.stories.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class StoryAssetDimensionMapper_Factory implements Factory<StoryAssetDimensionMapper> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final StoryAssetDimensionMapper_Factory f37548a = new StoryAssetDimensionMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static StoryAssetDimensionMapper_Factory a() {
        return InstanceHolder.f37548a;
    }

    public static StoryAssetDimensionMapper c() {
        return new StoryAssetDimensionMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public StoryAssetDimensionMapper get() {
        return c();
    }
}
