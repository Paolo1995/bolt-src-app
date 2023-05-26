package ee.mtakso.driver.di.authorised;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource;
import ee.mtakso.driver.ui.common.map.MapPaddingViewModel;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel;
import ee.mtakso.driver.ui.screens.blocking.DriverBlockedFragment;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsFragment;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsViewModel;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInChoiceActivationInfoFragment;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallViewModel;
import ee.mtakso.driver.ui.screens.destination.DestinationFragment;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateFragment;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateViewModel;
import ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment;
import ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoriesFragment;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.balance.BalanceFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsInfoPageFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsProgressPageFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlViewModel;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel;
import ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog;
import ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment;
import ee.mtakso.driver.ui.screens.history.list.OrderListFragment;
import ee.mtakso.driver.ui.screens.history.list.OrderListViewModel;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.about.AboutDriverDestinationsFragment;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import ee.mtakso.driver.ui.screens.home.v3.HomeViewModel;
import ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment;
import ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel;
import ee.mtakso.driver.ui.screens.inbox.InboxFragment;
import ee.mtakso.driver.ui.screens.inbox.InboxViewModel;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebViewModel;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserViewModel;
import ee.mtakso.driver.ui.screens.operation_result.OperationResultFragment;
import ee.mtakso.driver.ui.screens.order.add_stop.AddStopBottomSheetDialogFragment;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewDialog;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDialogFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDisclaimerFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationViewModel;
import ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment;
import ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel;
import ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalFragment;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsViewModel;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupViewModel;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel;
import ee.mtakso.driver.ui.screens.order.v2.OrderViewModel;
import ee.mtakso.driver.ui.screens.order.v2.map.OrderMapFragment;
import ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.ActiveIncidentDialogFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel;
import ee.mtakso.driver.ui.screens.score.DriverScoreExplanationFragment;
import ee.mtakso.driver.ui.screens.score.DriverScoreExplanationViewModel;
import ee.mtakso.driver.ui.screens.score.DriverScoreFragment;
import ee.mtakso.driver.ui.screens.score.DriverScoreViewModel;
import ee.mtakso.driver.ui.screens.settings.AccountSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.AppSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.NavigationSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.QuickAccessSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.QuickAccessSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.SettingsFragment;
import ee.mtakso.driver.ui.screens.settings.SettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtFragment;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtViewModel;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsViewModel;
import ee.mtakso.driver.ui.screens.sos.SosDialogFragment;
import ee.mtakso.driver.ui.screens.sos.SosDialogViewModel;
import ee.mtakso.driver.ui.screens.support.SupportFragment;
import ee.mtakso.driver.ui.screens.support.SupportViewModel;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeFragment;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeViewModel;
import ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment;
import ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel;
import ee.mtakso.driver.ui.screens.waybill.WaybillFragment;
import ee.mtakso.driver.ui.screens.waybill.WaybillViewModel;
import ee.mtakso.driver.ui.screens.work.WorkFragment;
import ee.mtakso.driver.ui.screens.work.WorkViewModel;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationFragment;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationViewModel;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsViewModel;
import eu.bolt.driver.chat.ActiveOrdersSource;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerViewModel;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu.MessageMenuFragment;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import eu.bolt.driver.stories.ui.screen.StorySetViewModel;
import eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel;

/* compiled from: AuthorisedUiModule.kt */
@Module
/* loaded from: classes3.dex */
public interface AuthorisedUiBindings extends MainAuthorisedUiBindings {
    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel A(IncomingCallViewModel incomingCallViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment A0(MapExplanationFragment mapExplanationFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment A1(SosDialogFragment sosDialogFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment B(EarningsBreakdownFragment earningsBreakdownFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel B0(NavigatorChooserViewModel navigatorChooserViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment B1(ActiveCampaignsFragment activeCampaignsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment C(LanguageSettingsFragment languageSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment C0(SafetyToolkitBottomSheetFragment safetyToolkitBottomSheetFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment C1(InfoWebFragment infoWebFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment D(ActiveIncidentDialogFragment activeIncidentDialogFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel D0(EarningsGoalExpensesViewModel earningsGoalExpensesViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment D1(RetryFileUploadFragment retryFileUploadFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel E(CallBackViewModel callBackViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel E0(PricingSettingsViewModel pricingSettingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment E1(MapSettingsFragment mapSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment F(PayToBoltFragment payToBoltFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment F0(InboxFragment inboxFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel F1(SettingsViewModel settingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment G(RateMeCategoriesFragment rateMeCategoriesFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment G0(SupportFragment supportFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel G1(DriverPriorityViewModel driverPriorityViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel H(ScheduledOrdersViewModel scheduledOrdersViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment H0(PayoutHistoryFragment payoutHistoryFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel H1(ChoosePriceReviewViewModel choosePriceReviewViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment I(HomeFragment homeFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel I0(BoltClubViewModel boltClubViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment I1(DriverDestinationSearchFragment driverDestinationSearchFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment J(ThemeSettingsFragment themeSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment J0(EarningsGoalExpensesFragment earningsGoalExpensesFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel J1(PayoutRequestViewModel payoutRequestViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment K(PricingSettingsFragment pricingSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment K0(DriverDestinationActiveStateFragment driverDestinationActiveStateFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel K1(ActiveCampaignsViewModel activeCampaignsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment L(SettingsFragment settingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment L0(DriverScoreExplanationFragment driverScoreExplanationFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment L1(AccountSettingsFragment accountSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel M(DrivePriceViewModel drivePriceViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel M0(OrderViewModel orderViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel M1(VoipCallErrorViewModel voipCallErrorViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment N(WorkFragment workFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel N0(OrderDestinationViewModel orderDestinationViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment N1(AutoAcceptanceSettingsFragment autoAcceptanceSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel O(DidYouGetHelpViewModel didYouGetHelpViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel O0(ThemeSettingsViewModel themeSettingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment O1(IncomingOrderFragment incomingOrderFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel P(DriverActivityViewModel driverActivityViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel P0(VehicleListViewModel vehicleListViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment P1(WaybillFragment waybillFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel Q(OrderListViewModel orderListViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment Q0(TripCancellationBottomSheetFragment tripCancellationBottomSheetFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel Q1(CircleKLoyaltyViewModel circleKLoyaltyViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel R(DispatchSettingsViewModel dispatchSettingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment R0(ChoosePriceReviewDialog choosePriceReviewDialog);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment R1(OrderPanelFragment orderPanelFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment S(PastCampaignsFragment pastCampaignsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment S0(AppSettingsFragment appSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment S1(NavigationSettingsTbtFragment navigationSettingsTbtFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment T(AudioRecordingBottomSheetFragment audioRecordingBottomSheetFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment T0(QuickAccessSettingsFragment quickAccessSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel T1(EarningsPayoutExplanationViewModel earningsPayoutExplanationViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel U(SafetyToolkitViewModel safetyToolkitViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel U0(ScheduledOrdersGroupViewModel scheduledOrdersGroupViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment U1(DidYouGetHelpFragment didYouGetHelpFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel V(ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallViewModel incomingCallViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment V0(VehicleListFragment vehicleListFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel V1(PayoutDetailsViewModel payoutDetailsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment W(DriverBlockedFragment driverBlockedFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment W0(BoltClubListingFragment boltClubListingFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel W1(NavigationSettingsTbtViewModel navigationSettingsTbtViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel X(EmergencyAssistHelpViewModel emergencyAssistHelpViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel X0(EarningsLandingViewModel earningsLandingViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment X1(NavigatorChooserFragment navigatorChooserFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment Y(OrderHistoryDetailsFragment orderHistoryDetailsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment Y0(RateMeReasonsFragment rateMeReasonsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment Y1(ReferralCampaignDetailsFragment referralCampaignDetailsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment Z(DestinationFragment destinationFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel Z0(MapExplanationViewModel mapExplanationViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel Z1(IncomingOrderViewModel incomingOrderViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment a(EarningsPayoutExplanationFragment earningsPayoutExplanationFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel a0(InprogressCallViewModel inprogressCallViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel a1(SosDialogViewModel sosDialogViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel a2(RateMeCategoryViewModel rateMeCategoryViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel b(InboxViewModel inboxViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment b0(ConversationPagerFragment conversationPagerFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment b1(OrderModalFragment orderModalFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel b2(HomeViewModel homeViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment c(CampaignDetailsFragment campaignDetailsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment c0(RateRiderDialogFragment rateRiderDialogFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment c1(RequestWebUrlFragment requestWebUrlFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment c2(OrderListFragment orderListFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment d(CircleKLoyaltyStarterFragment circleKLoyaltyStarterFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel d0(PastCampaignsViewModel pastCampaignsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment d1(PricePreviewFragment pricePreviewFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel d2(BoltClubOfferDetailsViewModel boltClubOfferDetailsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment e(CustomPriceFragment customPriceFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel e0(CircleKLoyaltyStarterViewModel circleKLoyaltyStarterViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel e1(ConversationPagerViewModel conversationPagerViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment e2(AddStopBottomSheetDialogFragment addStopBottomSheetDialogFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel f(TripCancellationViewModel tripCancellationViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel f0(WorkViewModel workViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment f1(HowToRequestPayoutFragment howToRequestPayoutFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel f2(OrderHistoryDetailsViewModel orderHistoryDetailsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel g(RequestWebUrlViewModel requestWebUrlViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment g0(PayoutRequestFragment payoutRequestFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment g1(RateRiderDisclaimerFragment rateRiderDisclaimerFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment g2(EmergencyAssistHelpBottomSheetFragment emergencyAssistHelpBottomSheetFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    /* synthetic */ ActiveOrdersSource h(ChatActiveOrderSource chatActiveOrderSource);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment h0(OrderMapFragment orderMapFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel h1(NoAnswerViewModel noAnswerViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel h2(WorkMapViewModel workMapViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel i(DriverScoreExplanationViewModel driverScoreExplanationViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment i0(WorkTimeFragment workTimeFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel i1(OptInChoiceViewModel optInChoiceViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment i2(CircleKLoyaltyFragment circleKLoyaltyFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment j(PayoutDetailsInfoPageFragment payoutDetailsInfoPageFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel j0(SupportViewModel supportViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment j1(EarningsBalanceFragment earningsBalanceFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment j2(PayoutDetailsProgressPageFragment payoutDetailsProgressPageFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment k(AboutDriverDestinationsFragment aboutDriverDestinationsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment k0(EarningsLandingFragment earningsLandingFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel k1(LanguageSettingsViewModel languageSettingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment k2(NavigationSettingsFragment navigationSettingsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel l(PayToBoltViewModel payToBoltViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel l0(EarningsBalanceViewModel earningsBalanceViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment l1(MessageMenuFragment messageMenuFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment l2(DriverAppDisabledFragment driverAppDisabledFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel m(DriverScoreViewModel driverScoreViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel m0(InfoWebViewModel infoWebViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel m1(ScheduledOrderDetailsViewModel scheduledOrderDetailsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment m2(FileUploadConfirmationDialog fileUploadConfirmationDialog);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment n(BalanceFragment balanceFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel n0(CampaignDetailsViewModel campaignDetailsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment n1(DriverActivityFragment driverActivityFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment n2(ScheduledOrdersGroupFragment scheduledOrdersGroupFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment o(EarningsGoalFragment earningsGoalFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment o0(IncomingOrderMapFragment incomingOrderMapFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel o1(EarningsGoalViewModel earningsGoalViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel o2(DriverAppDisabledViewModel driverAppDisabledViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment p(BoltClubOfferDetailsFragment boltClubOfferDetailsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel p0(OptInCampaignViewModel optInCampaignViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel p1(EarningsBreakdownViewModel earningsBreakdownViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel p2(RateCallViewModel rateCallViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel q(MapPaddingViewModel mapPaddingViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment q0(OrderDestinationFragment orderDestinationFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment q1(RateRiderFragment rateRiderFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel q2(DriverDestinationActiveStateViewModel driverDestinationActiveStateViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel r(StorySetViewModel storySetViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel r0(HowToRequestPayoutViewModel howToRequestPayoutViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment r1(DriverPriorityFragment driverPriorityFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel r2(QuickAccessSettingsViewModel quickAccessSettingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel s(WorkTimeViewModel workTimeViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment s0(ConversationFragment conversationFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment s1(OperationResultFragment operationResultFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment t(WorkMapFragment workMapFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment t0(DriverScoreFragment driverScoreFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel t1(EarningsViewModel earningsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment u(StorySetFragment storySetFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel u0(ReferralCampaignDetailsViewModel referralCampaignDetailsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment u1(OrderMenuDialogFragment orderMenuDialogFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel v(ConversationViewModel conversationViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment v0(ScheduledOrdersFragment scheduledOrdersFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment v1(OptInCampaignFragment optInCampaignFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel w(ContactOptionsViewModel contactOptionsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel w0(MapSettingsViewModel mapSettingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment w1(ScheduledOrderDetailsFragment scheduledOrderDetailsFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel x(AudioRecordingViewModel audioRecordingViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment x0(OptInChoiceActivationInfoFragment optInChoiceActivationInfoFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel x1(DriverDestinationSearchViewModel driverDestinationSearchViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel y(AutoAcceptanceSettingsViewModel autoAcceptanceSettingsViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel y0(WaybillViewModel waybillViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ Fragment y1(OptInChoiceFragment optInChoiceFragment);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel z(PayoutHistoryViewModel payoutHistoryViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel z0(CarChooserViewModel carChooserViewModel);

    @Override // ee.mtakso.driver.di.authorised.MainAuthorisedUiBindings
    @Binds
    @IntoMap
    /* synthetic */ ViewModel z1(DestinationsViewModel destinationsViewModel);
}
