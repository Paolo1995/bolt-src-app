package ee.mtakso.driver.ui.screens.campaigns.v2.optin;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.OptInCampaignChoice;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInChoiceDelegate;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptInChoiceDelegate.kt */
/* loaded from: classes3.dex */
public final class OptInChoiceDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f27634a;

    /* renamed from: b  reason: collision with root package name */
    private final OptInCampaignChoice f27635b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27636c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27637d;

    /* renamed from: e  reason: collision with root package name */
    private final int f27638e;

    /* renamed from: f  reason: collision with root package name */
    private final int f27639f;

    /* renamed from: g  reason: collision with root package name */
    private Function2<? super OptInCampaignChoice, ? super Boolean, Unit> f27640g;

    /* renamed from: h  reason: collision with root package name */
    private Function1<? super OptInCampaignChoice, Unit> f27641h;

    /* renamed from: i  reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f27642i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnClickListener f27643j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f27644k;

    public OptInChoiceDelegate(View containerView, OptInCampaignChoice optInChoice) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(optInChoice, "optInChoice");
        this.f27644k = new LinkedHashMap();
        this.f27634a = containerView;
        this.f27635b = optInChoice;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: y2.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                OptInChoiceDelegate.f(OptInChoiceDelegate.this, compoundButton, z7);
            }
        };
        this.f27642i = onCheckedChangeListener;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: y2.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OptInChoiceDelegate.g(OptInChoiceDelegate.this, view);
            }
        };
        this.f27643j = onClickListener;
        Context context = d().getContext();
        Intrinsics.e(context, "containerView.context");
        this.f27636c = ContextUtilsKt.b(context, R.attr.backSecondary);
        Context context2 = d().getContext();
        Intrinsics.e(context2, "containerView.context");
        this.f27637d = ContextUtilsKt.b(context2, R.attr.backTertiary);
        Context context3 = d().getContext();
        Intrinsics.e(context3, "containerView.context");
        this.f27638e = ContextUtilsKt.b(context3, R.attr.contentSecondary);
        Context context4 = d().getContext();
        Intrinsics.e(context4, "containerView.context");
        this.f27639f = ContextUtilsKt.b(context4, R.attr.contentPrimary);
        ((CheckBox) c(R.id.optInChoiceRadioButton)).setOnCheckedChangeListener(onCheckedChangeListener);
        ((CardView) c(R.id.optInChoiceInfoContainer)).setOnClickListener(onClickListener);
        ((TextView) c(R.id.optInChoiceTitle)).setText(optInChoice.getTitle());
        ((TextView) c(R.id.optInChoiceDescription)).setText(optInChoice.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(OptInChoiceDelegate this$0, CompoundButton compoundButton, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        Function2<? super OptInCampaignChoice, ? super Boolean, Unit> function2 = this$0.f27640g;
        if (function2 != null) {
            function2.s(this$0.f27635b, Boolean.valueOf(z7));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(OptInChoiceDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        Function1<? super OptInCampaignChoice, Unit> function1 = this$0.f27641h;
        if (function1 != null) {
            function1.invoke(this$0.f27635b);
        }
    }

    public View c(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27644k;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View d8 = d();
            if (d8 == null || (findViewById = d8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public View d() {
        return this.f27634a;
    }

    public final OptInCampaignChoice e() {
        return this.f27635b;
    }

    public final void h(Function1<? super OptInCampaignChoice, Unit> listener) {
        Intrinsics.f(listener, "listener");
        this.f27641h = listener;
    }

    public final void i(Function2<? super OptInCampaignChoice, ? super Boolean, Unit> listener) {
        Intrinsics.f(listener, "listener");
        this.f27640g = listener;
    }

    public final void j(boolean z7, boolean z8) {
        int i8 = R.id.optInChoiceRadioButton;
        ((CheckBox) c(i8)).setOnCheckedChangeListener(null);
        ((CheckBox) c(i8)).setChecked(z7);
        ((CheckBox) c(i8)).setOnCheckedChangeListener(this.f27642i);
        if (!z7 && z8) {
            int i9 = R.id.optInChoiceInfoContainer;
            ((CardView) c(i9)).setCardBackgroundColor(this.f27637d);
            ((CardView) c(i9)).setCardElevation(0.0f);
            ((TextView) c(R.id.optInChoiceTitle)).setTextColor(this.f27638e);
            return;
        }
        int i10 = R.id.optInChoiceInfoContainer;
        ((CardView) c(i10)).setCardBackgroundColor(this.f27636c);
        ((CardView) c(i10)).setCardElevation(Dimens.c(4));
        ((TextView) c(R.id.optInChoiceTitle)).setTextColor(this.f27639f);
    }
}
