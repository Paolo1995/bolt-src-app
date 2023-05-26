package ee.mtakso.driver.di.anonymous;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateFragment;
import ee.mtakso.driver.ui.screens.authenticate.AuthenticateViewModel;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerFragment;
import ee.mtakso.driver.ui.screens.countypicker.CountryPickerViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingStepFragment;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.processing.DocumentsProcessingFragment;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginFragment;
import ee.mtakso.driver.ui.screens.login.v2.email.EmailLoginViewModel;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingFragment;
import ee.mtakso.driver.ui.screens.login.v2.landing.LandingViewModel;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginFragment;
import ee.mtakso.driver.ui.screens.login.v2.pswrd.PasswordLoginViewModel;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationFragment;
import ee.mtakso.driver.ui.screens.login.v2.verification.VerificationViewModel;
import ee.mtakso.driver.ui.screens.login.v3.common.SharedLoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.emailverification.EmailVerificationFragment;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.landing.LandingV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.login.LoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.password.PasswordLoginV3ViewModel;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3Fragment;
import ee.mtakso.driver.ui.screens.login.v3.verification.VerificationV3ViewModel;
import ee.mtakso.driver.ui.screens.signup.SignUpViewModel;
import ee.mtakso.driver.ui.screens.update.MandatoryUpdateFragment;

/* compiled from: AnonymousUiModule.kt */
@Module
/* loaded from: classes3.dex */
public interface AnonymousUiBindings {
    @Binds
    @IntoMap
    Fragment A(VerificationFragment verificationFragment);

    @Binds
    @IntoMap
    ViewModel B(PasswordLoginViewModel passwordLoginViewModel);

    @Binds
    @IntoMap
    Fragment C(LandingV3Fragment landingV3Fragment);

    @Binds
    @IntoMap
    ViewModel a(VerificationViewModel verificationViewModel);

    @Binds
    @IntoMap
    ViewModel b(VerificationV3ViewModel verificationV3ViewModel);

    @Binds
    @IntoMap
    Fragment c(CountryPickerFragment countryPickerFragment);

    @Binds
    @IntoMap
    ViewModel d(SharedLoginV3ViewModel sharedLoginV3ViewModel);

    @Binds
    @IntoMap
    Fragment e(AuthenticateFragment authenticateFragment);

    @Binds
    @IntoMap
    Fragment f(MandatoryUpdateFragment mandatoryUpdateFragment);

    @Binds
    @IntoMap
    ViewModel g(LoginV3ViewModel loginV3ViewModel);

    @Binds
    @IntoMap
    ViewModel h(SignUpViewModel signUpViewModel);

    @Binds
    @IntoMap
    Fragment i(EmailVerificationFragment emailVerificationFragment);

    @Binds
    @IntoMap
    ViewModel j(CountryPickerViewModel countryPickerViewModel);

    @Binds
    @IntoMap
    Fragment k(VerificationV3Fragment verificationV3Fragment);

    @Binds
    @IntoMap
    ViewModel l(EmailLoginViewModel emailLoginViewModel);

    @Binds
    @IntoMap
    Fragment m(PasswordLoginFragment passwordLoginFragment);

    @Binds
    @IntoMap
    ViewModel n(PasswordLoginV3ViewModel passwordLoginV3ViewModel);

    @Binds
    @IntoMap
    Fragment o(PasswordLoginV3Fragment passwordLoginV3Fragment);

    @Binds
    @IntoMap
    Fragment p(LandingFragment landingFragment);

    @Binds
    ViewModelProvider.Factory q(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    ViewModel r(LandingV3ViewModel landingV3ViewModel);

    @Binds
    @IntoMap
    ViewModel s(AuthenticateViewModel authenticateViewModel);

    @Binds
    @IntoMap
    Fragment t(DocumentsProcessingFragment documentsProcessingFragment);

    @Binds
    @IntoMap
    Fragment u(EmailLoginFragment emailLoginFragment);

    @Binds
    @IntoMap
    ViewModel v(DocumentsScannerViewModel documentsScannerViewModel);

    @Binds
    @IntoMap
    Fragment w(DocumentsOnBoardingStepFragment documentsOnBoardingStepFragment);

    @Binds
    @IntoMap
    ViewModel x(DocumentsOnBoardingViewModel documentsOnBoardingViewModel);

    @Binds
    @IntoMap
    ViewModel y(LandingViewModel landingViewModel);

    @Binds
    @IntoMap
    Fragment z(LoginV3Fragment loginV3Fragment);
}
