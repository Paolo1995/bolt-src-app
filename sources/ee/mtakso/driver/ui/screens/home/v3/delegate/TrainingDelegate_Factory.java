package ee.mtakso.driver.ui.screens.home.v3.delegate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TrainingDelegate_Factory implements Factory<TrainingDelegate> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final TrainingDelegate_Factory f29920a = new TrainingDelegate_Factory();

        private InstanceHolder() {
        }
    }

    public static TrainingDelegate_Factory a() {
        return InstanceHolder.f29920a;
    }

    public static TrainingDelegate c() {
        return new TrainingDelegate();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TrainingDelegate get() {
        return c();
    }
}
