package ee.mtakso.driver.di.anonymous;

import androidx.fragment.app.FragmentFactory;
import dagger.Component;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.ui.screens.AnonymousSimpleActivity;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerActivity;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingActivity;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.signup.SignUpActivity;
import eu.bolt.driver.core.ui.routing.RoutingManager;

/* compiled from: AnonymousComponent.kt */
@Component(dependencies = {ApplicationComponent.class}, modules = {AnonymousUiModule.class, AnonymousStaffModule.class})
/* loaded from: classes3.dex */
public interface AnonymousComponent {
    FragmentFactory b();

    RoutingManager c();

    DeeplinkDelegate d();

    void e(AnonymousSimpleActivity anonymousSimpleActivity);

    void f(DocumentsScannerActivity documentsScannerActivity);

    void g(SignUpActivity signUpActivity);

    void h(DocumentsOnBoardingActivity documentsOnBoardingActivity);
}
