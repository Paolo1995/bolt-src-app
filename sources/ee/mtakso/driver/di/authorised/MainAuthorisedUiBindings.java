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

/* compiled from: MainAuthorisedUiModule.kt */
@Module
/* loaded from: classes3.dex */
public interface MainAuthorisedUiBindings {
    @Binds
    @IntoMap
    ViewModel A(IncomingCallViewModel incomingCallViewModel);

    @Binds
    @IntoMap
    Fragment A0(MapExplanationFragment mapExplanationFragment);

    @Binds
    @IntoMap
    Fragment A1(SosDialogFragment sosDialogFragment);

    @Binds
    @IntoMap
    Fragment B(EarningsBreakdownFragment earningsBreakdownFragment);

    @Binds
    @IntoMap
    ViewModel B0(NavigatorChooserViewModel navigatorChooserViewModel);

    @Binds
    @IntoMap
    Fragment B1(ActiveCampaignsFragment activeCampaignsFragment);

    @Binds
    @IntoMap
    Fragment C(LanguageSettingsFragment languageSettingsFragment);

    @Binds
    @IntoMap
    Fragment C0(SafetyToolkitBottomSheetFragment safetyToolkitBottomSheetFragment);

    @Binds
    @IntoMap
    Fragment C1(InfoWebFragment infoWebFragment);

    @Binds
    @IntoMap
    Fragment D(ActiveIncidentDialogFragment activeIncidentDialogFragment);

    @Binds
    @IntoMap
    ViewModel D0(EarningsGoalExpensesViewModel earningsGoalExpensesViewModel);

    @Binds
    @IntoMap
    Fragment D1(RetryFileUploadFragment retryFileUploadFragment);

    @Binds
    @IntoMap
    ViewModel E(CallBackViewModel callBackViewModel);

    @Binds
    @IntoMap
    ViewModel E0(PricingSettingsViewModel pricingSettingsViewModel);

    @Binds
    @IntoMap
    Fragment E1(MapSettingsFragment mapSettingsFragment);

    @Binds
    @IntoMap
    Fragment F(PayToBoltFragment payToBoltFragment);

    @Binds
    @IntoMap
    Fragment F0(InboxFragment inboxFragment);

    @Binds
    @IntoMap
    ViewModel F1(SettingsViewModel settingsViewModel);

    @Binds
    @IntoMap
    Fragment G(RateMeCategoriesFragment rateMeCategoriesFragment);

    @Binds
    @IntoMap
    Fragment G0(SupportFragment supportFragment);

    @Binds
    @IntoMap
    ViewModel G1(DriverPriorityViewModel driverPriorityViewModel);

    @Binds
    @IntoMap
    ViewModel H(ScheduledOrdersViewModel scheduledOrdersViewModel);

    @Binds
    @IntoMap
    Fragment H0(PayoutHistoryFragment payoutHistoryFragment);

    @Binds
    @IntoMap
    ViewModel H1(ChoosePriceReviewViewModel choosePriceReviewViewModel);

    @Binds
    @IntoMap
    Fragment I(HomeFragment homeFragment);

    @Binds
    @IntoMap
    ViewModel I0(BoltClubViewModel boltClubViewModel);

    @Binds
    @IntoMap
    Fragment I1(DriverDestinationSearchFragment driverDestinationSearchFragment);

    @Binds
    @IntoMap
    Fragment J(ThemeSettingsFragment themeSettingsFragment);

    @Binds
    @IntoMap
    Fragment J0(EarningsGoalExpensesFragment earningsGoalExpensesFragment);

    @Binds
    @IntoMap
    ViewModel J1(PayoutRequestViewModel payoutRequestViewModel);

    @Binds
    @IntoMap
    Fragment K(PricingSettingsFragment pricingSettingsFragment);

    @Binds
    @IntoMap
    Fragment K0(DriverDestinationActiveStateFragment driverDestinationActiveStateFragment);

    @Binds
    @IntoMap
    ViewModel K1(ActiveCampaignsViewModel activeCampaignsViewModel);

    @Binds
    @IntoMap
    Fragment L(SettingsFragment settingsFragment);

    @Binds
    @IntoMap
    Fragment L0(DriverScoreExplanationFragment driverScoreExplanationFragment);

    @Binds
    @IntoMap
    Fragment L1(AccountSettingsFragment accountSettingsFragment);

    @Binds
    @IntoMap
    ViewModel M(DrivePriceViewModel drivePriceViewModel);

    @Binds
    @IntoMap
    ViewModel M0(OrderViewModel orderViewModel);

    @Binds
    @IntoMap
    ViewModel M1(VoipCallErrorViewModel voipCallErrorViewModel);

    @Binds
    @IntoMap
    Fragment N(WorkFragment workFragment);

    @Binds
    @IntoMap
    ViewModel N0(OrderDestinationViewModel orderDestinationViewModel);

    @Binds
    @IntoMap
    Fragment N1(AutoAcceptanceSettingsFragment autoAcceptanceSettingsFragment);

    @Binds
    @IntoMap
    ViewModel O(DidYouGetHelpViewModel didYouGetHelpViewModel);

    @Binds
    @IntoMap
    ViewModel O0(ThemeSettingsViewModel themeSettingsViewModel);

    @Binds
    @IntoMap
    Fragment O1(IncomingOrderFragment incomingOrderFragment);

    @Binds
    @IntoMap
    ViewModel P(DriverActivityViewModel driverActivityViewModel);

    @Binds
    @IntoMap
    ViewModel P0(VehicleListViewModel vehicleListViewModel);

    @Binds
    @IntoMap
    Fragment P1(WaybillFragment waybillFragment);

    @Binds
    @IntoMap
    ViewModel Q(OrderListViewModel orderListViewModel);

    @Binds
    @IntoMap
    Fragment Q0(TripCancellationBottomSheetFragment tripCancellationBottomSheetFragment);

    @Binds
    @IntoMap
    ViewModel Q1(CircleKLoyaltyViewModel circleKLoyaltyViewModel);

    @Binds
    @IntoMap
    ViewModel R(DispatchSettingsViewModel dispatchSettingsViewModel);

    @Binds
    @IntoMap
    Fragment R0(ChoosePriceReviewDialog choosePriceReviewDialog);

    @Binds
    @IntoMap
    Fragment R1(OrderPanelFragment orderPanelFragment);

    @Binds
    @IntoMap
    Fragment S(PastCampaignsFragment pastCampaignsFragment);

    @Binds
    @IntoMap
    Fragment S0(AppSettingsFragment appSettingsFragment);

    @Binds
    @IntoMap
    Fragment S1(NavigationSettingsTbtFragment navigationSettingsTbtFragment);

    @Binds
    @IntoMap
    Fragment T(AudioRecordingBottomSheetFragment audioRecordingBottomSheetFragment);

    @Binds
    @IntoMap
    Fragment T0(QuickAccessSettingsFragment quickAccessSettingsFragment);

    @Binds
    @IntoMap
    ViewModel T1(EarningsPayoutExplanationViewModel earningsPayoutExplanationViewModel);

    @Binds
    @IntoMap
    ViewModel U(SafetyToolkitViewModel safetyToolkitViewModel);

    @Binds
    @IntoMap
    ViewModel U0(ScheduledOrdersGroupViewModel scheduledOrdersGroupViewModel);

    @Binds
    @IntoMap
    Fragment U1(DidYouGetHelpFragment didYouGetHelpFragment);

    @Binds
    @IntoMap
    ViewModel V(ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallViewModel incomingCallViewModel);

    @Binds
    @IntoMap
    Fragment V0(VehicleListFragment vehicleListFragment);

    @Binds
    @IntoMap
    ViewModel V1(PayoutDetailsViewModel payoutDetailsViewModel);

    @Binds
    @IntoMap
    Fragment W(DriverBlockedFragment driverBlockedFragment);

    @Binds
    @IntoMap
    Fragment W0(BoltClubListingFragment boltClubListingFragment);

    @Binds
    @IntoMap
    ViewModel W1(NavigationSettingsTbtViewModel navigationSettingsTbtViewModel);

    @Binds
    @IntoMap
    ViewModel X(EmergencyAssistHelpViewModel emergencyAssistHelpViewModel);

    @Binds
    @IntoMap
    ViewModel X0(EarningsLandingViewModel earningsLandingViewModel);

    @Binds
    @IntoMap
    Fragment X1(NavigatorChooserFragment navigatorChooserFragment);

    @Binds
    @IntoMap
    Fragment Y(OrderHistoryDetailsFragment orderHistoryDetailsFragment);

    @Binds
    @IntoMap
    Fragment Y0(RateMeReasonsFragment rateMeReasonsFragment);

    @Binds
    @IntoMap
    Fragment Y1(ReferralCampaignDetailsFragment referralCampaignDetailsFragment);

    @Binds
    @IntoMap
    Fragment Z(DestinationFragment destinationFragment);

    @Binds
    @IntoMap
    ViewModel Z0(MapExplanationViewModel mapExplanationViewModel);

    @Binds
    @IntoMap
    ViewModel Z1(IncomingOrderViewModel incomingOrderViewModel);

    @Binds
    @IntoMap
    Fragment a(EarningsPayoutExplanationFragment earningsPayoutExplanationFragment);

    @Binds
    @IntoMap
    ViewModel a0(InprogressCallViewModel inprogressCallViewModel);

    @Binds
    @IntoMap
    ViewModel a1(SosDialogViewModel sosDialogViewModel);

    @Binds
    @IntoMap
    ViewModel a2(RateMeCategoryViewModel rateMeCategoryViewModel);

    @Binds
    @IntoMap
    ViewModel b(InboxViewModel inboxViewModel);

    @Binds
    @IntoMap
    Fragment b0(ConversationPagerFragment conversationPagerFragment);

    @Binds
    @IntoMap
    Fragment b1(OrderModalFragment orderModalFragment);

    @Binds
    @IntoMap
    ViewModel b2(HomeViewModel homeViewModel);

    @Binds
    @IntoMap
    Fragment c(CampaignDetailsFragment campaignDetailsFragment);

    @Binds
    @IntoMap
    Fragment c0(RateRiderDialogFragment rateRiderDialogFragment);

    @Binds
    @IntoMap
    Fragment c1(RequestWebUrlFragment requestWebUrlFragment);

    @Binds
    @IntoMap
    Fragment c2(OrderListFragment orderListFragment);

    @Binds
    @IntoMap
    Fragment d(CircleKLoyaltyStarterFragment circleKLoyaltyStarterFragment);

    @Binds
    @IntoMap
    ViewModel d0(PastCampaignsViewModel pastCampaignsViewModel);

    @Binds
    @IntoMap
    Fragment d1(PricePreviewFragment pricePreviewFragment);

    @Binds
    @IntoMap
    ViewModel d2(BoltClubOfferDetailsViewModel boltClubOfferDetailsViewModel);

    @Binds
    @IntoMap
    Fragment e(CustomPriceFragment customPriceFragment);

    @Binds
    @IntoMap
    ViewModel e0(CircleKLoyaltyStarterViewModel circleKLoyaltyStarterViewModel);

    @Binds
    @IntoMap
    ViewModel e1(ConversationPagerViewModel conversationPagerViewModel);

    @Binds
    @IntoMap
    Fragment e2(AddStopBottomSheetDialogFragment addStopBottomSheetDialogFragment);

    @Binds
    @IntoMap
    ViewModel f(TripCancellationViewModel tripCancellationViewModel);

    @Binds
    @IntoMap
    ViewModel f0(WorkViewModel workViewModel);

    @Binds
    @IntoMap
    Fragment f1(HowToRequestPayoutFragment howToRequestPayoutFragment);

    @Binds
    @IntoMap
    ViewModel f2(OrderHistoryDetailsViewModel orderHistoryDetailsViewModel);

    @Binds
    @IntoMap
    ViewModel g(RequestWebUrlViewModel requestWebUrlViewModel);

    @Binds
    @IntoMap
    Fragment g0(PayoutRequestFragment payoutRequestFragment);

    @Binds
    @IntoMap
    Fragment g1(RateRiderDisclaimerFragment rateRiderDisclaimerFragment);

    @Binds
    @IntoMap
    Fragment g2(EmergencyAssistHelpBottomSheetFragment emergencyAssistHelpBottomSheetFragment);

    @Binds
    ActiveOrdersSource h(ChatActiveOrderSource chatActiveOrderSource);

    @Binds
    @IntoMap
    Fragment h0(OrderMapFragment orderMapFragment);

    @Binds
    @IntoMap
    ViewModel h1(NoAnswerViewModel noAnswerViewModel);

    @Binds
    @IntoMap
    ViewModel h2(WorkMapViewModel workMapViewModel);

    @Binds
    @IntoMap
    ViewModel i(DriverScoreExplanationViewModel driverScoreExplanationViewModel);

    @Binds
    @IntoMap
    Fragment i0(WorkTimeFragment workTimeFragment);

    @Binds
    @IntoMap
    ViewModel i1(OptInChoiceViewModel optInChoiceViewModel);

    @Binds
    @IntoMap
    Fragment i2(CircleKLoyaltyFragment circleKLoyaltyFragment);

    @Binds
    @IntoMap
    Fragment j(PayoutDetailsInfoPageFragment payoutDetailsInfoPageFragment);

    @Binds
    @IntoMap
    ViewModel j0(SupportViewModel supportViewModel);

    @Binds
    @IntoMap
    Fragment j1(EarningsBalanceFragment earningsBalanceFragment);

    @Binds
    @IntoMap
    Fragment j2(PayoutDetailsProgressPageFragment payoutDetailsProgressPageFragment);

    @Binds
    @IntoMap
    Fragment k(AboutDriverDestinationsFragment aboutDriverDestinationsFragment);

    @Binds
    @IntoMap
    Fragment k0(EarningsLandingFragment earningsLandingFragment);

    @Binds
    @IntoMap
    ViewModel k1(LanguageSettingsViewModel languageSettingsViewModel);

    @Binds
    @IntoMap
    Fragment k2(NavigationSettingsFragment navigationSettingsFragment);

    @Binds
    @IntoMap
    ViewModel l(PayToBoltViewModel payToBoltViewModel);

    @Binds
    @IntoMap
    ViewModel l0(EarningsBalanceViewModel earningsBalanceViewModel);

    @Binds
    @IntoMap
    Fragment l1(MessageMenuFragment messageMenuFragment);

    @Binds
    @IntoMap
    Fragment l2(DriverAppDisabledFragment driverAppDisabledFragment);

    @Binds
    @IntoMap
    ViewModel m(DriverScoreViewModel driverScoreViewModel);

    @Binds
    @IntoMap
    ViewModel m0(InfoWebViewModel infoWebViewModel);

    @Binds
    @IntoMap
    ViewModel m1(ScheduledOrderDetailsViewModel scheduledOrderDetailsViewModel);

    @Binds
    @IntoMap
    Fragment m2(FileUploadConfirmationDialog fileUploadConfirmationDialog);

    @Binds
    @IntoMap
    Fragment n(BalanceFragment balanceFragment);

    @Binds
    @IntoMap
    ViewModel n0(CampaignDetailsViewModel campaignDetailsViewModel);

    @Binds
    @IntoMap
    Fragment n1(DriverActivityFragment driverActivityFragment);

    @Binds
    @IntoMap
    Fragment n2(ScheduledOrdersGroupFragment scheduledOrdersGroupFragment);

    @Binds
    @IntoMap
    Fragment o(EarningsGoalFragment earningsGoalFragment);

    @Binds
    @IntoMap
    Fragment o0(IncomingOrderMapFragment incomingOrderMapFragment);

    @Binds
    @IntoMap
    ViewModel o1(EarningsGoalViewModel earningsGoalViewModel);

    @Binds
    @IntoMap
    ViewModel o2(DriverAppDisabledViewModel driverAppDisabledViewModel);

    @Binds
    @IntoMap
    Fragment p(BoltClubOfferDetailsFragment boltClubOfferDetailsFragment);

    @Binds
    @IntoMap
    ViewModel p0(OptInCampaignViewModel optInCampaignViewModel);

    @Binds
    @IntoMap
    ViewModel p1(EarningsBreakdownViewModel earningsBreakdownViewModel);

    @Binds
    @IntoMap
    ViewModel p2(RateCallViewModel rateCallViewModel);

    @Binds
    @IntoMap
    ViewModel q(MapPaddingViewModel mapPaddingViewModel);

    @Binds
    @IntoMap
    Fragment q0(OrderDestinationFragment orderDestinationFragment);

    @Binds
    @IntoMap
    Fragment q1(RateRiderFragment rateRiderFragment);

    @Binds
    @IntoMap
    ViewModel q2(DriverDestinationActiveStateViewModel driverDestinationActiveStateViewModel);

    @Binds
    @IntoMap
    ViewModel r(StorySetViewModel storySetViewModel);

    @Binds
    @IntoMap
    ViewModel r0(HowToRequestPayoutViewModel howToRequestPayoutViewModel);

    @Binds
    @IntoMap
    Fragment r1(DriverPriorityFragment driverPriorityFragment);

    @Binds
    @IntoMap
    ViewModel r2(QuickAccessSettingsViewModel quickAccessSettingsViewModel);

    @Binds
    @IntoMap
    ViewModel s(WorkTimeViewModel workTimeViewModel);

    @Binds
    @IntoMap
    Fragment s0(ConversationFragment conversationFragment);

    @Binds
    @IntoMap
    Fragment s1(OperationResultFragment operationResultFragment);

    @Binds
    @IntoMap
    Fragment t(WorkMapFragment workMapFragment);

    @Binds
    @IntoMap
    Fragment t0(DriverScoreFragment driverScoreFragment);

    @Binds
    @IntoMap
    ViewModel t1(EarningsViewModel earningsViewModel);

    @Binds
    @IntoMap
    Fragment u(StorySetFragment storySetFragment);

    @Binds
    @IntoMap
    ViewModel u0(ReferralCampaignDetailsViewModel referralCampaignDetailsViewModel);

    @Binds
    @IntoMap
    Fragment u1(OrderMenuDialogFragment orderMenuDialogFragment);

    @Binds
    @IntoMap
    ViewModel v(ConversationViewModel conversationViewModel);

    @Binds
    @IntoMap
    Fragment v0(ScheduledOrdersFragment scheduledOrdersFragment);

    @Binds
    @IntoMap
    Fragment v1(OptInCampaignFragment optInCampaignFragment);

    @Binds
    @IntoMap
    ViewModel w(ContactOptionsViewModel contactOptionsViewModel);

    @Binds
    @IntoMap
    ViewModel w0(MapSettingsViewModel mapSettingsViewModel);

    @Binds
    @IntoMap
    Fragment w1(ScheduledOrderDetailsFragment scheduledOrderDetailsFragment);

    @Binds
    @IntoMap
    ViewModel x(AudioRecordingViewModel audioRecordingViewModel);

    @Binds
    @IntoMap
    Fragment x0(OptInChoiceActivationInfoFragment optInChoiceActivationInfoFragment);

    @Binds
    @IntoMap
    ViewModel x1(DriverDestinationSearchViewModel driverDestinationSearchViewModel);

    @Binds
    @IntoMap
    ViewModel y(AutoAcceptanceSettingsViewModel autoAcceptanceSettingsViewModel);

    @Binds
    @IntoMap
    ViewModel y0(WaybillViewModel waybillViewModel);

    @Binds
    @IntoMap
    Fragment y1(OptInChoiceFragment optInChoiceFragment);

    @Binds
    @IntoMap
    ViewModel z(PayoutHistoryViewModel payoutHistoryViewModel);

    @Binds
    @IntoMap
    ViewModel z0(CarChooserViewModel carChooserViewModel);

    @Binds
    @IntoMap
    ViewModel z1(DestinationsViewModel destinationsViewModel);
}
