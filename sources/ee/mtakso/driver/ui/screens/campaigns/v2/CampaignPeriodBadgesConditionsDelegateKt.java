package ee.mtakso.driver.ui.screens.campaigns.v2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.Coordinates;
import ee.mtakso.driver.network.client.campaign.DriverCampaign;
import ee.mtakso.driver.network.client.campaign.DriverCampaignBadge;
import ee.mtakso.driver.network.client.campaign.DriverCampaignCondition;
import ee.mtakso.driver.network.client.campaign.DriverCampaignPeriod;
import ee.mtakso.driver.network.client.campaign.DriverCampaignProgressCondition;
import ee.mtakso.driver.network.client.campaign.DriverCampaignStatus;
import ee.mtakso.driver.network.client.campaign.DriverCampaignStatusDetail;
import ee.mtakso.driver.network.client.campaign.DriverCampaignThresholdCondition;
import ee.mtakso.driver.uicore.components.views.ExpandableTextView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.utils.StringUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: CampaignPeriodBadgesConditionsDelegate.kt */
/* loaded from: classes3.dex */
public final class CampaignPeriodBadgesConditionsDelegateKt {

    /* compiled from: CampaignPeriodBadgesConditionsDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27303a;

        static {
            int[] iArr = new int[DriverCampaignBadge.values().length];
            try {
                iArr[DriverCampaignBadge.RUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverCampaignBadge.ACTIVATION_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverCampaignBadge.OPT_IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverCampaignBadge.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f27303a = iArr;
        }
    }

    public static final void f(Context context, View view, TextView campaignTitleView, ExpandableTextView campaignPeriodView, TextView textView, TextView textView2, LinearLayout campaignBadgeContainerView, LinearLayout campaignConditionContainerView, DriverCampaign driverCampaign, DateTimeConverter dateTimeConverter, View.OnClickListener onClickListener, boolean z7, boolean z8, Function1<? super DriverCampaignCondition, Unit> function1, Function0<Unit> function0, Function0<Unit> function02) {
        List e8;
        Intrinsics.f(context, "context");
        Intrinsics.f(campaignTitleView, "campaignTitleView");
        Intrinsics.f(campaignPeriodView, "campaignPeriodView");
        Intrinsics.f(campaignBadgeContainerView, "campaignBadgeContainerView");
        Intrinsics.f(campaignConditionContainerView, "campaignConditionContainerView");
        Intrinsics.f(driverCampaign, "driverCampaign");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        String g8 = driverCampaign.g();
        e8 = CollectionsKt__CollectionsJVMKt.e(driverCampaign.d());
        g(context, view, campaignTitleView, campaignPeriodView, textView, textView2, campaignBadgeContainerView, campaignConditionContainerView, g8, e8, driverCampaign.a(), driverCampaign.f().b(), driverCampaign.e(), driverCampaign.f(), driverCampaign.b(), dateTimeConverter, onClickListener, z7, z8, function1, function0, function02);
    }

    public static final void g(Context context, View view, TextView campaignTitleView, ExpandableTextView campaignPeriodView, TextView textView, TextView textView2, LinearLayout campaignBadgeContainerView, LinearLayout campaignConditionContainerView, String campaignTitle, List<DriverCampaignPeriod> campaignPeriods, List<? extends DriverCampaignBadge> campaignBadges, String str, List<Coordinates> list, DriverCampaignStatusDetail driverCampaignStatusDetail, List<? extends DriverCampaignCondition> campaignConditions, DateTimeConverter dateTimeConverter, View.OnClickListener onClickListener, boolean z7, boolean z8, Function1<? super DriverCampaignCondition, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02) {
        boolean z9;
        boolean y7;
        Intrinsics.f(context, "context");
        Intrinsics.f(campaignTitleView, "campaignTitleView");
        Intrinsics.f(campaignPeriodView, "campaignPeriodView");
        Intrinsics.f(campaignBadgeContainerView, "campaignBadgeContainerView");
        Intrinsics.f(campaignConditionContainerView, "campaignConditionContainerView");
        Intrinsics.f(campaignTitle, "campaignTitle");
        Intrinsics.f(campaignPeriods, "campaignPeriods");
        Intrinsics.f(campaignBadges, "campaignBadges");
        Intrinsics.f(campaignConditions, "campaignConditions");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        campaignTitleView.setText(campaignTitle);
        CampaignPeriodString r7 = r(context, dateTimeConverter, campaignPeriods);
        if (r7 != null) {
            if (r7.a() != null) {
                campaignPeriodView.setControlIconSize(Dimens.d(12));
                campaignPeriodView.setControlIconNewLinePadding(Dimens.d(10));
                campaignPeriodView.setCollapsedText(r7.b());
                campaignPeriodView.setExpandedText(r7.a());
                campaignPeriodView.setCollapseIconRes(R.drawable.ic_tree_chevron_up);
                campaignPeriodView.setCollapseIconTintColorRes(R.color.neutral600);
                campaignPeriodView.setCollapseIconPlacement(ExpandableTextView.IconPlacement.NEW_LINE);
                campaignPeriodView.setExpandIconRes(R.drawable.ic_tree_chevron_down);
                campaignPeriodView.setExpandIconTintColorRes(R.color.neutral600);
                campaignPeriodView.setExpandIconPlacement(ExpandableTextView.IconPlacement.INLINE);
                campaignPeriodView.setMaxCollapsedLines(2);
                campaignPeriodView.f();
                campaignPeriodView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CampaignPeriodBadgesConditionsDelegateKt.i(Function0.this, view2);
                    }
                });
            } else {
                campaignPeriodView.setText(r7.b());
                campaignPeriodView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CampaignPeriodBadgesConditionsDelegateKt.j(Function0.this, view2);
                    }
                });
            }
        }
        k(context, campaignBadgeContainerView, campaignBadges, driverCampaignStatusDetail != null ? driverCampaignStatusDetail.a() : null);
        m(context, campaignConditionContainerView, driverCampaignStatusDetail, campaignConditions, z8, function1, function02);
        if (z7) {
            if (!(list == null || list.isEmpty()) && textView2 != null) {
                ViewExtKt.e(textView2, true, 0, 2, null);
            }
        }
        if (!z8) {
            if (str != null) {
                y7 = StringsKt__StringsJVMKt.y(str);
                if (!y7) {
                    z9 = false;
                    if (!z9 && textView != null) {
                        ViewExtKt.e(textView, true, 0, 2, null);
                        textView.setText(StringUtilsKt.a(str));
                        return;
                    }
                }
            }
            z9 = true;
            if (!z9) {
                ViewExtKt.e(textView, true, 0, 2, null);
                textView.setText(StringUtilsKt.a(str));
                return;
            }
        }
        if (textView != null) {
            ViewExtKt.e(textView, false, 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 function0, View view) {
        ExpandableTextView expandableTextView;
        if (view instanceof ExpandableTextView) {
            expandableTextView = (ExpandableTextView) view;
        } else {
            expandableTextView = null;
        }
        if (expandableTextView != null) {
            expandableTextView.h();
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(android.content.Context r17, android.widget.LinearLayout r18, java.util.List<? extends ee.mtakso.driver.network.client.campaign.DriverCampaignBadge> r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.campaigns.v2.CampaignPeriodBadgesConditionsDelegateKt.k(android.content.Context, android.widget.LinearLayout, java.util.List, java.lang.String):void");
    }

    public static /* synthetic */ void l(Context context, LinearLayout linearLayout, List list, String str, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            str = null;
        }
        k(context, linearLayout, list, str);
    }

    @SuppressLint({"InflateParams"})
    public static final void m(Context context, LinearLayout campaignConditionContainer, DriverCampaignStatusDetail driverCampaignStatusDetail, List<? extends DriverCampaignCondition> campaignConditions, boolean z7, final Function1<? super DriverCampaignCondition, Unit> function1, final Function0<Unit> function0) {
        Intrinsics.f(context, "context");
        Intrinsics.f(campaignConditionContainer, "campaignConditionContainer");
        Intrinsics.f(campaignConditions, "campaignConditions");
        LayoutInflater from = LayoutInflater.from(context);
        campaignConditionContainer.removeAllViews();
        int i8 = -2;
        int i9 = -1;
        int i10 = R.color.neutral900;
        ViewGroup viewGroup = null;
        if (driverCampaignStatusDetail != null && driverCampaignStatusDetail.c() != DriverCampaignStatus.PENDING) {
            for (final DriverCampaignCondition driverCampaignCondition : campaignConditions) {
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i9, i8);
                if (driverCampaignCondition instanceof DriverCampaignProgressCondition) {
                    View inflate = from.inflate(R.layout.delegate_item_campaign_condition_progress, viewGroup);
                    View findViewById = inflate.findViewById(R.id.campaignConditionProgressTitle);
                    Intrinsics.e(findViewById, "conditionView.findViewBy…gnConditionProgressTitle)");
                    TextView textView = (TextView) findViewById;
                    View findViewById2 = inflate.findViewById(R.id.campaignConditionProgressStatusDescription);
                    Intrinsics.e(findViewById2, "conditionView.findViewBy…rogressStatusDescription)");
                    TextView textView2 = (TextView) findViewById2;
                    textView.setText(driverCampaignCondition.getTitle());
                    DriverCampaignProgressCondition driverCampaignProgressCondition = (DriverCampaignProgressCondition) driverCampaignCondition;
                    textView2.setText(driverCampaignProgressCondition.d());
                    View findViewById3 = inflate.findViewById(R.id.campaignConditionProgressProgress);
                    Intrinsics.e(findViewById3, "conditionView.findViewBy…onditionProgressProgress)");
                    ProgressBar progressBar = (ProgressBar) findViewById3;
                    progressBar.setMax(100);
                    progressBar.setProgress((int) (driverCampaignProgressCondition.e() * 100));
                    if (driverCampaignStatusDetail.c() == DriverCampaignStatus.ACTIVE) {
                        int color = ContextCompat.getColor(context, i10);
                        textView.setTextColor(color);
                        textView2.setTextColor(color);
                        progressBar.setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.horizontal_progress_bar_neutral300_neutral700));
                    } else {
                        int color2 = ContextCompat.getColor(context, R.color.neutral600);
                        textView.setTextColor(color2);
                        textView2.setTextColor(color2);
                        progressBar.setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.horizontal_progress_bar_neutral300_neutral600));
                    }
                    progressBar.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.m
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CampaignPeriodBadgesConditionsDelegateKt.p(Function0.this, view);
                        }
                    });
                    if (z7 && driverCampaignCondition.c() != null) {
                        View findViewById4 = inflate.findViewById(R.id.campaignConditionProgressIconTermsExplanation);
                        Intrinsics.d(findViewById4, "null cannot be cast to non-null type android.view.View");
                        ViewExtKt.e(findViewById4, true, 0, 2, null);
                        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.n
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CampaignPeriodBadgesConditionsDelegateKt.n(Function1.this, driverCampaignCondition, view);
                            }
                        });
                    } else {
                        View findViewById5 = inflate.findViewById(R.id.campaignConditionProgressIconTermsExplanation);
                        Intrinsics.d(findViewById5, "null cannot be cast to non-null type android.view.View");
                        ViewExtKt.e(findViewById5, false, 0, 2, null);
                    }
                    campaignConditionContainer.addView(inflate, layoutParams);
                } else {
                    ViewGroup viewGroup2 = viewGroup;
                    if (driverCampaignCondition instanceof DriverCampaignThresholdCondition) {
                        View inflate2 = from.inflate(R.layout.delegate_item_campaign_condition_threshold, viewGroup2);
                        View findViewById6 = inflate2.findViewById(R.id.campaignConditionThresholdTitle);
                        Intrinsics.e(findViewById6, "conditionView.findViewBy…nConditionThresholdTitle)");
                        TextView textView3 = (TextView) findViewById6;
                        View findViewById7 = inflate2.findViewById(R.id.campaignConditionThresholdStatusCurrent);
                        Intrinsics.e(findViewById7, "conditionView.findViewBy…onThresholdStatusCurrent)");
                        TextView textView4 = (TextView) findViewById7;
                        textView3.setText(driverCampaignCondition.getTitle());
                        View findViewById8 = inflate2.findViewById(R.id.campaignConditionStatusThreshold);
                        Intrinsics.d(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
                        DriverCampaignThresholdCondition driverCampaignThresholdCondition = (DriverCampaignThresholdCondition) driverCampaignCondition;
                        ((TextView) findViewById8).setText(driverCampaignThresholdCondition.e());
                        textView4.setText(driverCampaignThresholdCondition.d());
                        if (!driverCampaignCondition.a()) {
                            textView4.setTextColor(ContextCompat.getColor(context, R.color.yellow900));
                            if (driverCampaignStatusDetail.c() == DriverCampaignStatus.ACTIVE) {
                                textView3.setTextColor(ContextCompat.getColor(context, R.color.neutral900));
                            } else {
                                textView3.setTextColor(ContextCompat.getColor(context, R.color.neutral600));
                            }
                        } else if (driverCampaignStatusDetail.c() == DriverCampaignStatus.ACTIVE) {
                            int color3 = ContextCompat.getColor(context, R.color.neutral900);
                            textView3.setTextColor(color3);
                            textView4.setTextColor(color3);
                        } else {
                            int color4 = ContextCompat.getColor(context, R.color.neutral600);
                            textView3.setTextColor(color4);
                            textView4.setTextColor(color4);
                        }
                        if (z7 && driverCampaignCondition.c() != null) {
                            View findViewById9 = inflate2.findViewById(R.id.campaignConditionThresholdIconTermsExplanation);
                            Intrinsics.d(findViewById9, "null cannot be cast to non-null type android.view.View");
                            ViewExtKt.e(findViewById9, true, 0, 2, null);
                            ViewExtKt.e(findViewById9, true, 0, 2, null);
                            findViewById9.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.o
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    CampaignPeriodBadgesConditionsDelegateKt.o(Function1.this, driverCampaignCondition, view);
                                }
                            });
                        } else {
                            View findViewById10 = inflate2.findViewById(R.id.campaignConditionThresholdIconTermsExplanation);
                            Intrinsics.d(findViewById10, "null cannot be cast to non-null type android.view.View");
                            ViewExtKt.e(findViewById10, false, 0, 2, null);
                        }
                        campaignConditionContainer.addView(inflate2, layoutParams);
                    }
                }
                i8 = -2;
                i9 = -1;
                i10 = R.color.neutral900;
                viewGroup = null;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        View inflate3 = from.inflate(R.layout.delegate_item_campaign_condition_summary, (ViewGroup) null);
        Intrinsics.d(inflate3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView5 = (TextView) inflate3;
        textView5.setText(q(campaignConditions));
        if (z7) {
            textView5.setTextColor(ContextCompat.getColor(context, R.color.neutral900));
            textView5.setTextSize(2, 16.0f);
        } else {
            textView5.setTextColor(ContextCompat.getColor(context, R.color.neutral600));
            textView5.setTextSize(2, 14.0f);
        }
        campaignConditionContainer.addView(textView5, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 function1, DriverCampaignCondition it, View view) {
        Intrinsics.f(it, "$it");
        if (function1 != null) {
            function1.invoke(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 function1, DriverCampaignCondition it, View view) {
        Intrinsics.f(it, "$it");
        if (function1 != null) {
            function1.invoke(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    private static final String q(List<? extends DriverCampaignCondition> list) {
        int v7;
        String f02;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (DriverCampaignCondition driverCampaignCondition : list) {
            arrayList.add(driverCampaignCondition.b());
        }
        f02 = CollectionsKt___CollectionsKt.f0(arrayList, "\n", null, null, 0, null, new Function1<String, CharSequence>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.CampaignPeriodBadgesConditionsDelegateKt$createCampaignConditionsSummaryString$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CharSequence invoke(String it) {
                Intrinsics.f(it, "it");
                return "• " + it;
            }
        }, 30, null);
        return f02;
    }

    public static final CampaignPeriodString r(final Context context, final DateTimeConverter dateTimeConverter, List<DriverCampaignPeriod> campaignPeriods) {
        String f02;
        Object W;
        Object h02;
        String f03;
        Intrinsics.f(context, "context");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(campaignPeriods, "campaignPeriods");
        if (campaignPeriods.size() > 2) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            W = CollectionsKt___CollectionsKt.W(campaignPeriods);
            h02 = CollectionsKt___CollectionsKt.h0(campaignPeriods);
            String format = String.format("%s\n%s", Arrays.copyOf(new Object[]{s(context, dateTimeConverter, (DriverCampaignPeriod) W), t(context, ((DriverCampaignPeriod) h02).a(), dateTimeConverter)}, 2));
            Intrinsics.e(format, "format(format, *args)");
            f03 = CollectionsKt___CollectionsKt.f0(campaignPeriods, "\n", null, null, 0, null, new Function1<DriverCampaignPeriod, CharSequence>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.CampaignPeriodBadgesConditionsDelegateKt$createCampaignPeriodsString$longText$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CharSequence invoke(DriverCampaignPeriod it) {
                    Intrinsics.f(it, "it");
                    return CampaignPeriodBadgesConditionsDelegateKt.s(context, dateTimeConverter, it);
                }
            }, 30, null);
            return new CampaignPeriodString(format, f03);
        } else if (!(!campaignPeriods.isEmpty())) {
            return null;
        } else {
            f02 = CollectionsKt___CollectionsKt.f0(campaignPeriods, "\n", null, null, 0, null, new Function1<DriverCampaignPeriod, CharSequence>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.CampaignPeriodBadgesConditionsDelegateKt$createCampaignPeriodsString$periodString$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CharSequence invoke(DriverCampaignPeriod it) {
                    Intrinsics.f(it, "it");
                    return CampaignPeriodBadgesConditionsDelegateKt.s(context, dateTimeConverter, it);
                }
            }, 30, null);
            return new CampaignPeriodString(f02, null);
        }
    }

    public static final String s(Context context, DateTimeConverter dateTimeConverter, DriverCampaignPeriod campaignPeriod) {
        String x7;
        String str;
        Intrinsics.f(context, "context");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Intrinsics.f(campaignPeriod, "campaignPeriod");
        Calendar calendar = Calendar.getInstance();
        Calendar calendarStart = Calendar.getInstance();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        calendarStart.setTimeInMillis(timeUnit.toMillis(campaignPeriod.b()));
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTimeInMillis(timeUnit.toMillis(campaignPeriod.a()));
        if (calendarStart.get(6) == calendarEnd.get(6)) {
            if (calendarStart.get(6) == calendar.get(6)) {
                str = context.getString(R.string.today) + ", " + dateTimeConverter.c("HH:mm").format(calendarStart.getTime());
                x7 = dateTimeConverter.c("HH:mm").format(calendarEnd.getTime());
                Intrinsics.e(x7, "dateTimeConverter.getDat….format(calendarEnd.time)");
            } else {
                str = dateTimeConverter.c("d MMM, HH:mm").format(calendarStart.getTime());
                Intrinsics.e(str, "dateTimeConverter.getDat…ormat(calendarStart.time)");
                x7 = dateTimeConverter.c("HH:mm").format(calendarEnd.getTime());
                Intrinsics.e(x7, "dateTimeConverter.getDat….format(calendarEnd.time)");
            }
        } else {
            Intrinsics.e(calendarStart, "calendarStart");
            String x8 = x(context, calendarStart, false, dateTimeConverter, 4, null);
            Intrinsics.e(calendarEnd, "calendarEnd");
            x7 = x(context, calendarEnd, false, dateTimeConverter, 4, null);
            str = x8;
        }
        if (calendarStart.get(6) == calendarEnd.get(6)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            String format = String.format("%s–%s", Arrays.copyOf(new Object[]{str, x7}, 2));
            Intrinsics.e(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
        String format2 = String.format("%s – %s", Arrays.copyOf(new Object[]{str, x7}, 2));
        Intrinsics.e(format2, "format(format, *args)");
        return format2;
    }

    public static final String t(Context context, long j8, DateTimeConverter dateTimeConverter) {
        String format;
        Intrinsics.f(context, "context");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(TimeUnit.SECONDS.toMillis(j8));
        String string = context.getString(R.string.until_short);
        if (calendar2.get(6) == calendar.get(6)) {
            format = context.getString(R.string.today) + ", " + dateTimeConverter.c("HH:mm").format(calendar.getTime());
        } else {
            format = dateTimeConverter.c("d MMM").format(calendar.getTime());
        }
        return string + " " + format;
    }

    public static final String u(Context context, long j8, boolean z7, DateTimeConverter dateTimeConverter) {
        Intrinsics.f(context, "context");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTimeInMillis(TimeUnit.SECONDS.toMillis(j8));
        Intrinsics.e(calendarDate, "calendarDate");
        return v(context, calendarDate, z7, dateTimeConverter);
    }

    public static final String v(Context context, Calendar calendarDate, boolean z7, DateTimeConverter dateTimeConverter) {
        Intrinsics.f(context, "context");
        Intrinsics.f(calendarDate, "calendarDate");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        Calendar calendar = Calendar.getInstance();
        if (z7 && calendar.get(6) == calendarDate.get(6)) {
            String string = context.getString(R.string.today);
            String format = dateTimeConverter.c("HH:mm").format(calendarDate.getTime());
            return string + ", " + format;
        }
        String format2 = dateTimeConverter.c("d MMM, HH:mm").format(calendarDate.getTime());
        Intrinsics.e(format2, "{\n        dateTimeConver…(calendarDate.time)\n    }");
        return format2;
    }

    public static /* synthetic */ String w(Context context, long j8, boolean z7, DateTimeConverter dateTimeConverter, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = true;
        }
        return u(context, j8, z7, dateTimeConverter);
    }

    public static /* synthetic */ String x(Context context, Calendar calendar, boolean z7, DateTimeConverter dateTimeConverter, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = true;
        }
        return v(context, calendar, z7, dateTimeConverter);
    }
}
