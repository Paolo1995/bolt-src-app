package ee.mtakso.driver.ui.base;

import androidx.fragment.app.FragmentFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import eu.bolt.driver.core.permission.PermissionManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.base.BaseActivity.fragmentFactory")
    public static void a(BaseActivity baseActivity, FragmentFactory fragmentFactory) {
        baseActivity.f26225g = fragmentFactory;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.base.BaseActivity.permissionManager")
    public static void b(BaseActivity baseActivity, PermissionManager permissionManager) {
        baseActivity.f26224f = permissionManager;
    }
}
