package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltUiDelegate;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltUiDelegate.kt */
/* loaded from: classes3.dex */
public final class PayToBoltUiDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f28634a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<String, Unit> f28635b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, View> f28636c;

    /* JADX WARN: Multi-variable type inference failed */
    public PayToBoltUiDelegate(View containerView, Function1<? super String, Unit> function1) {
        Intrinsics.f(containerView, "containerView");
        this.f28636c = new LinkedHashMap();
        this.f28634a = containerView;
        this.f28635b = function1;
    }

    private final Spannable c(String str) {
        SpannableString spannableString = new SpannableString(str);
        SpannableStringBuilderUtils.b(spannableString, new ForegroundColorSpan(ContextUtilsKt.b(g(), R.attr.contentPrimary)));
        return spannableString;
    }

    private final Spannable d(String str) {
        SpannableString spannableString = new SpannableString(str);
        SpannableStringBuilderUtils.b(spannableString, new ForegroundColorSpan(ContextUtilsKt.b(g(), R.attr.accentRed)));
        SpannableStringBuilderUtils.b(spannableString, new RelativeSizeSpan(1.5f));
        SpannableStringBuilderUtils.b(spannableString, new StyleSpan(1));
        return spannableString;
    }

    private final Spannable e(DebtInfo debtInfo) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) c(debtInfo.a())).append((CharSequence) " ").append((CharSequence) d(debtInfo.b()));
        return spannableStringBuilder;
    }

    private final Context g() {
        Context context = f().getContext();
        Intrinsics.e(context, "containerView.context");
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PayToBoltUiDelegate this$0, String link, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(link, "$link");
        Function1<String, Unit> function1 = this$0.f28635b;
        if (function1 != null) {
            function1.invoke(link);
        }
    }

    public View b(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28636c;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View f8 = f();
            if (f8 == null || (findViewById = f8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public View f() {
        return this.f28634a;
    }

    public final void h(PayToBoltInfo payToBoltInfo) {
        boolean z7;
        boolean z8;
        boolean z9 = true;
        ViewExtKt.e(f(), !PayToBoltUiDelegateKt.b(payToBoltInfo), 0, 2, null);
        if (payToBoltInfo != null && !PayToBoltUiDelegateKt.a(payToBoltInfo)) {
            int i8 = R.id.payToBoltHint;
            TextView payToBoltHint = (TextView) b(i8);
            Intrinsics.e(payToBoltHint, "payToBoltHint");
            if (payToBoltInfo.c() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.e(payToBoltHint, z7, 0, 2, null);
            String c8 = payToBoltInfo.c();
            if (c8 != null) {
                ((TextView) b(i8)).setText(c8);
            }
            int i9 = R.id.payToBoltTitle;
            TextView payToBoltTitle = (TextView) b(i9);
            Intrinsics.e(payToBoltTitle, "payToBoltTitle");
            if (payToBoltInfo.a() != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            ViewExtKt.e(payToBoltTitle, z8, 0, 2, null);
            DebtInfo a8 = payToBoltInfo.a();
            if (a8 != null) {
                ((TextView) b(i9)).setText(e(a8));
            }
            int i10 = R.id.payToBoltButton;
            RoundButton payToBoltButton = (RoundButton) b(i10);
            Intrinsics.e(payToBoltButton, "payToBoltButton");
            if (payToBoltInfo.b() == null) {
                z9 = false;
            }
            ViewExtKt.e(payToBoltButton, z9, 0, 2, null);
            final String b8 = payToBoltInfo.b();
            if (b8 != null) {
                ((RoundButton) b(i10)).setOnClickListener(new View.OnClickListener() { // from class: o3.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PayToBoltUiDelegate.i(PayToBoltUiDelegate.this, b8, view);
                    }
                });
            }
        }
    }
}
