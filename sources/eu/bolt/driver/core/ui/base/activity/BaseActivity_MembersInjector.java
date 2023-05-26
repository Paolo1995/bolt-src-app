package eu.bolt.driver.core.ui.base.activity;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.permission.PermissionManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
    @InjectedFieldSignature("eu.bolt.driver.core.ui.base.activity.BaseActivity.fragmentFactory")
    public static void a(BaseActivity baseActivity, CoreFragmentFactory coreFragmentFactory) {
        baseActivity.f41000f = coreFragmentFactory;
    }

    @InjectedFieldSignature("eu.bolt.driver.core.ui.base.activity.BaseActivity.permissionManager")
    public static void b(BaseActivity baseActivity, PermissionManager permissionManager) {
        baseActivity.f41001g = permissionManager;
    }
}
