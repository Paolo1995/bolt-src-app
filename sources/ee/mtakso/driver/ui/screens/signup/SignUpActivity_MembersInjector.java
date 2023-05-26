package ee.mtakso.driver.ui.screens.signup;

import androidx.fragment.app.FragmentFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import eu.bolt.driver.core.permission.PermissionManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SignUpActivity_MembersInjector implements MembersInjector<SignUpActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.deepLinkParser")
    public static void a(SignUpActivity signUpActivity, DeepLinkParser deepLinkParser) {
        signUpActivity.f33336m = deepLinkParser;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.deeplinkDelegate")
    public static void b(SignUpActivity signUpActivity, DeeplinkDelegate deeplinkDelegate) {
        signUpActivity.f33339p = deeplinkDelegate;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.deviceFeatures")
    public static void c(SignUpActivity signUpActivity, DeviceFeatures deviceFeatures) {
        signUpActivity.f33337n = deviceFeatures;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.deviceSettings")
    public static void d(SignUpActivity signUpActivity, DeviceSettings deviceSettings) {
        signUpActivity.f33338o = deviceSettings;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.environmentDataProvider")
    public static void e(SignUpActivity signUpActivity, EnvironmentDataProvider environmentDataProvider) {
        signUpActivity.f33335l = environmentDataProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.fragmentFactory")
    public static void f(SignUpActivity signUpActivity, FragmentFactory fragmentFactory) {
        signUpActivity.f33332i = fragmentFactory;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.permissionManager")
    public static void g(SignUpActivity signUpActivity, PermissionManager permissionManager) {
        signUpActivity.f33331h = permissionManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.screenAnalytics")
    public static void h(SignUpActivity signUpActivity, ScreenAnalytics screenAnalytics) {
        signUpActivity.f33329f = screenAnalytics;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.systemUrlLauncher")
    public static void i(SignUpActivity signUpActivity, SystemUrlLauncher systemUrlLauncher) {
        signUpActivity.f33334k = systemUrlLauncher;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.urlLauncher")
    public static void j(SignUpActivity signUpActivity, CompositeUrlLauncher compositeUrlLauncher) {
        signUpActivity.f33333j = compositeUrlLauncher;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.signup.SignUpActivity.viewModelFactory")
    public static void k(SignUpActivity signUpActivity, ViewModelFactory viewModelFactory) {
        signUpActivity.f33330g = viewModelFactory;
    }
}
