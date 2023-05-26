package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.earnings.PaymentButton;
import ee.mtakso.driver.network.client.generic.ValueMark;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PaymentUiDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.LocaleExtKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonTypeKt;
import ee.mtakso.driver.utils.StringUtilsKt;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentUiDelegate.kt */
/* loaded from: classes3.dex */
public final class PaymentUiDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f28646a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f28647b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f28648c;

    /* renamed from: d  reason: collision with root package name */
    private final Function1<String, Unit> f28649d;

    /* renamed from: e  reason: collision with root package name */
    private final Function0<Unit> f28650e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f28651f;

    /* compiled from: PaymentUiDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28652a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f28653b;

        static {
            int[] iArr = new int[PaymentButton.values().length];
            try {
                iArr[PaymentButton.PAY_TO_BOLT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentButton.REQUEST_PAYOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaymentButton.HOW_TO_REQUEST_PAYOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f28652a = iArr;
            int[] iArr2 = new int[ValueMark.values().length];
            try {
                iArr2[ValueMark.IMPORTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            f28653b = iArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaymentUiDelegate(View containerView, Function0<Unit> onLinkClickedListener, Function0<Unit> onHistoryClickedListener, Function1<? super String, Unit> onHowtoClickedListener, Function0<Unit> onPayoutRequestedListener) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(onLinkClickedListener, "onLinkClickedListener");
        Intrinsics.f(onHistoryClickedListener, "onHistoryClickedListener");
        Intrinsics.f(onHowtoClickedListener, "onHowtoClickedListener");
        Intrinsics.f(onPayoutRequestedListener, "onPayoutRequestedListener");
        this.f28651f = new LinkedHashMap();
        this.f28646a = containerView;
        this.f28647b = onLinkClickedListener;
        this.f28648c = onHistoryClickedListener;
        this.f28649d = onHowtoClickedListener;
        this.f28650e = onPayoutRequestedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(PaymentUiDelegate this$0, PayInfo.HowTo payToBoltInfo, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(payToBoltInfo, "$payToBoltInfo");
        this$0.f28649d.invoke(payToBoltInfo.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(PaymentUiDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f28648c.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(PaymentUiDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f28650e.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(PaymentUiDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f28647b.invoke();
    }

    private final Context r() {
        Context context = q().getContext();
        Intrinsics.e(context, "containerView.context");
        return context;
    }

    private final int s(ValueMark valueMark) {
        int i8;
        if (valueMark == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f28653b[valueMark.ordinal()];
        }
        if (i8 == 1) {
            return ContextUtilsKt.b(r(), R.attr.accentRed);
        }
        return ContextUtilsKt.b(r(), R.attr.contentPrimary);
    }

    public View f(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28651f;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View q8 = q();
            if (q8 == null || (findViewById = q8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void g(final PayInfo.HowTo payToBoltInfo) {
        Intrinsics.f(payToBoltInfo, "payToBoltInfo");
        TextView payButtontHint = (TextView) f(R.id.payButtontHint);
        Intrinsics.e(payButtontHint, "payButtontHint");
        ViewExtKt.e(payButtontHint, false, 0, 2, null);
        ((TextView) f(R.id.howToButton)).setOnClickListener(new View.OnClickListener() { // from class: o3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentUiDelegate.h(PaymentUiDelegate.this, payToBoltInfo, view);
            }
        });
    }

    public final void i() {
        TextView payButtontHint = (TextView) f(R.id.payButtontHint);
        Intrinsics.e(payButtontHint, "payButtontHint");
        ViewExtKt.e(payButtontHint, false, 0, 2, null);
        RoundButton payButton = (RoundButton) f(R.id.payButton);
        Intrinsics.e(payButton, "payButton");
        ViewExtKt.e(payButton, false, 0, 2, null);
    }

    public final void j(PayInfoState payInfoState) {
        int i8;
        boolean z7;
        boolean z8;
        String str;
        int i9;
        boolean z9;
        String str2;
        int i10;
        int i11;
        Object obj;
        boolean z10;
        int i12;
        Intrinsics.f(payInfoState, "payInfoState");
        PayInfo c8 = payInfoState.c().c();
        boolean d8 = payInfoState.d();
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (LocaleExtKt.b(locale)) {
            i8 = R.drawable.ic_chevron_right;
        } else {
            i8 = R.drawable.ic_chevron_left;
        }
        Drawable drawable = ContextCompat.getDrawable(r(), i8);
        View q8 = q();
        if (c8 != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(q8, z7, 0, 2, null);
        if (c8 == null) {
            return;
        }
        int i13 = R.id.balanceText;
        ((TextView) f(i13)).setText(StringUtilsKt.a(c8.a().c()));
        ((TextView) f(i13)).setTextColor(s(c8.a().b()));
        TextView textView = (TextView) f(R.id.balanceComment);
        String a8 = c8.a().a();
        String str3 = "";
        textView.setText((a8 == null || (r5 = StringUtilsKt.a(a8)) == null) ? "" : "");
        boolean e8 = c8.e();
        int i14 = R.id.historyButton;
        TextView historyButton = (TextView) f(i14);
        Intrinsics.e(historyButton, "historyButton");
        ViewExtKt.e(historyButton, e8, 0, 2, null);
        View historyDelimiter = f(R.id.historyDelimiter);
        Intrinsics.e(historyDelimiter, "historyDelimiter");
        ViewExtKt.e(historyDelimiter, e8, 0, 2, null);
        ((TextView) f(i14)).setOnClickListener(new View.OnClickListener() { // from class: o3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentUiDelegate.k(PaymentUiDelegate.this, view);
            }
        });
        if (c8.b() == PaymentButton.HOW_TO_REQUEST_PAYOUT) {
            z8 = true;
        } else {
            z8 = false;
        }
        int i15 = R.id.howToButton;
        int color = ContextCompat.getColor(((TextView) f(i15)).getContext(), R.color.transparent);
        if (drawable == null) {
            str = "howToButton";
            i9 = i15;
            z9 = z8;
            str2 = "historyButton";
            i10 = i14;
        } else {
            TextView howToButton = (TextView) f(i15);
            Intrinsics.e(howToButton, "howToButton");
            str = "howToButton";
            i9 = i15;
            z9 = z8;
            str2 = "historyButton";
            i10 = i14;
            TextViewExtKt.c(howToButton, drawable, null, null, 6, null);
            TextView textView2 = (TextView) f(i10);
            Intrinsics.e(textView2, str2);
            TextViewExtKt.c(textView2, drawable, null, null, 6, null);
        }
        RippleProvider rippleProvider = RippleProvider.f35730a;
        TextView textView3 = (TextView) f(i9);
        Intrinsics.e(textView3, str);
        RippleProvider.b(rippleProvider, textView3, color, 0, 2, null);
        TextView textView4 = (TextView) f(i10);
        Intrinsics.e(textView4, str2);
        RippleProvider.b(rippleProvider, textView4, color, 0, 2, null);
        TextView textView5 = (TextView) f(i9);
        Intrinsics.e(textView5, str);
        boolean z11 = z9;
        ViewExtKt.e(textView5, z11, 0, 2, null);
        View howToDelimiter = f(R.id.howToDelimiter);
        Intrinsics.e(howToDelimiter, "howToDelimiter");
        ViewExtKt.e(howToDelimiter, z11, 0, 2, null);
        View q9 = q();
        if (!z11 && !e8) {
            i11 = Dimens.d(16);
        } else {
            i11 = 0;
        }
        q9.setPadding(q9.getPaddingLeft(), q9.getPaddingTop(), q9.getPaddingRight(), i11);
        ViewExtKt.e(q(), c8.d(), 0, 2, null);
        int i16 = R.id.payButton;
        RoundButton payButton = (RoundButton) f(i16);
        Intrinsics.e(payButton, "payButton");
        if (!z11 && c8.b() != null) {
            obj = null;
            z10 = true;
        } else {
            obj = null;
            z10 = false;
        }
        ViewExtKt.e(payButton, z10, 0, 2, obj);
        ((RoundButton) f(i16)).setEnabled(c8.c());
        PaymentButton b8 = c8.b();
        if (b8 != null) {
            Context r7 = r();
            int i17 = WhenMappings.f28652a[b8.ordinal()];
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3) {
                        i12 = R.string.debt_pay_howto_request;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i12 = R.string.debt_pay_request_cashout;
                }
            } else {
                i12 = R.string.debt_pay_to_bolt;
            }
            String string = r7.getString(i12);
            if (string != null) {
                str3 = string;
            }
        }
        ((RoundButton) f(i16)).setText(str3);
        ((RoundButton) f(i16)).setOnClickListener(new View.OnClickListener() { // from class: o3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentUiDelegate.l(view);
            }
        });
        if (d8) {
            ((RoundButton) f(i16)).k();
        } else {
            ((RoundButton) f(i16)).g();
        }
        if (c8.b() == PaymentButton.PAY_TO_BOLT) {
            RoundButton payButton2 = (RoundButton) f(i16);
            Intrinsics.e(payButton2, "payButton");
            UiKitRoundButtonTypeKt.b(payButton2, UiKitRoundButtonType.f36161k);
        } else {
            RoundButton payButton3 = (RoundButton) f(i16);
            Intrinsics.e(payButton3, "payButton");
            UiKitRoundButtonTypeKt.b(payButton3, UiKitRoundButtonType.f36164n);
        }
        ((RoundButton) f(i16)).setEnabled(c8.c());
        if (c8 instanceof PayInfo.ToBolt) {
            o((PayInfo.ToBolt) c8);
        } else if (c8 instanceof PayInfo.Payout) {
            m((PayInfo.Payout) c8);
        } else if (c8 instanceof PayInfo.HowTo) {
            g((PayInfo.HowTo) c8);
        } else if (c8 instanceof PayInfo.OnlyBalance) {
            i();
        }
    }

    public final void m(PayInfo.Payout payToBoltInfo) {
        boolean z7;
        Intrinsics.f(payToBoltInfo, "payToBoltInfo");
        int i8 = R.id.payButtontHint;
        TextView payButtontHint = (TextView) f(i8);
        Intrinsics.e(payButtontHint, "payButtontHint");
        if (payToBoltInfo.f() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(payButtontHint, z7, 0, 2, null);
        String f8 = payToBoltInfo.f();
        if (f8 != null) {
            TextView textView = (TextView) f(i8);
            CharSequence a8 = StringUtilsKt.a(f8);
            if (a8 == null) {
                a8 = "";
            }
            textView.setText(a8);
        }
        ((RoundButton) f(R.id.payButton)).setOnClickListener(new View.OnClickListener() { // from class: o3.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentUiDelegate.n(PaymentUiDelegate.this, view);
            }
        });
    }

    public final void o(PayInfo.ToBolt payToBoltInfo) {
        boolean z7;
        Intrinsics.f(payToBoltInfo, "payToBoltInfo");
        int i8 = R.id.payButtontHint;
        TextView payButtontHint = (TextView) f(i8);
        Intrinsics.e(payButtontHint, "payButtontHint");
        if (payToBoltInfo.f() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(payButtontHint, z7, 0, 2, null);
        String f8 = payToBoltInfo.f();
        if (f8 != null) {
            TextView textView = (TextView) f(i8);
            CharSequence a8 = StringUtilsKt.a(f8);
            if (a8 == null) {
                a8 = "";
            }
            textView.setText(a8);
        }
        ((RoundButton) f(R.id.payButton)).setOnClickListener(new View.OnClickListener() { // from class: o3.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentUiDelegate.p(PaymentUiDelegate.this, view);
            }
        });
    }

    public View q() {
        return this.f28646a;
    }
}
