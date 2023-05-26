package ee.mtakso.driver.di.modules;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class UtilsModule_ProvideDefaultFragmentFactoryFactory implements Factory<FragmentFactory> {
    public static FragmentFactory a(UtilsModule utilsModule) {
        return (FragmentFactory) Preconditions.checkNotNullFromProvides(utilsModule.a());
    }
}
