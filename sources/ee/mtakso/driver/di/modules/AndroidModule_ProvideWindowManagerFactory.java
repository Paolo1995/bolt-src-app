package ee.mtakso.driver.di.modules;

import android.content.Context;
import android.view.WindowManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AndroidModule_ProvideWindowManagerFactory implements Factory<WindowManager> {
    public static WindowManager a(Context context) {
        return (WindowManager) Preconditions.checkNotNullFromProvides(AndroidModule.n(context));
    }
}
