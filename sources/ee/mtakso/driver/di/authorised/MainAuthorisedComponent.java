package ee.mtakso.driver.di.authorised;

import androidx.fragment.app.FragmentFactory;
import dagger.BindsInstance;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.identity.verification.IdentityVerificationInitializer;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.auth.AuthorisedServicesRunner;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseActivity;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallFragment;
import ee.mtakso.driver.ui.screens.destination.edit.DestinationEditBottomDialogFragment;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.mode.ModeChooserBottomDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsActivity;
import ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderActivity;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment;
import ee.mtakso.driver.ui.screens.shared.InviteDriversActivity;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog;
import eu.bolt.driver.core.time.AnchoredTimeSource;

/* compiled from: MainAuthorisedComponent.kt */
/* loaded from: classes3.dex */
public interface MainAuthorisedComponent {

    /* compiled from: MainAuthorisedComponent.kt */
    /* loaded from: classes3.dex */
    public interface Builder {
        @BindsInstance
        Builder a(DriverFeatures driverFeatures);

        @BindsInstance
        Builder b(DriverSettings driverSettings);

        AuthorisedComponent build();

        @BindsInstance
        Builder c(AnchoredTimeSource anchoredTimeSource);

        @BindsInstance
        Builder d(DriverConfig driverConfig);

        Builder e(ApplicationComponent applicationComponent);
    }

    void A(CarChooserActivity carChooserActivity);

    void B(SafetyToolkitBottomSheetFragment safetyToolkitBottomSheetFragment);

    void C(ModeChooserBottomDialog modeChooserBottomDialog);

    void D(PayoutDetailsActivity payoutDetailsActivity);

    void E(RideFinishActivity rideFinishActivity);

    AuthorisedServicesRunner F();

    void G(PermissionOnboardingActivity permissionOnboardingActivity);

    FragmentFactory b();

    void c(RateCallFragment rateCallFragment);

    void d(InviteDriversActivity inviteDriversActivity);

    void f(EmergencyAssistHelpBottomSheetFragment emergencyAssistHelpBottomSheetFragment);

    void g(EarningsActivity earningsActivity);

    void h(IncomingOrderActivity incomingOrderActivity);

    void i(ContactOptionsFragment contactOptionsFragment);

    void j(ContactMethodsBaseActivity contactMethodsBaseActivity);

    void k(ActiveRideActivity activeRideActivity);

    void l(NoAnswerFragment noAnswerFragment);

    void m(DestinationEditBottomDialogFragment destinationEditBottomDialogFragment);

    void n(IncomingCallFragment incomingCallFragment);

    void o(SimpleActivity simpleActivity);

    void p(DidYouGetHelpFragment didYouGetHelpFragment);

    void q(RateMeDialog rateMeDialog);

    void r(AudioRecordingBottomSheetFragment audioRecordingBottomSheetFragment);

    void s(InprogressCallFragment inprogressCallFragment);

    void t(VoipCallErrorFragment voipCallErrorFragment);

    void u(VoipFloatingActivity voipFloatingActivity);

    void w(CallBackFragment callBackFragment);

    void x(DispatchSettingsDialog dispatchSettingsDialog);

    IdentityVerificationInitializer z();
}
