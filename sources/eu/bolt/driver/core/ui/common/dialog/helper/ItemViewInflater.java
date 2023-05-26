package eu.bolt.driver.core.ui.common.dialog.helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.R$layout;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemViewInflater.kt */
/* loaded from: classes5.dex */
public final class ItemViewInflater {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f41105a;

    /* compiled from: ItemViewInflater.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41106a;

        static {
            int[] iArr = new int[UiKitRoundButtonType.values().length];
            try {
                iArr[UiKitRoundButtonType.f36161k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UiKitRoundButtonType.f36162l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UiKitRoundButtonType.f36163m.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UiKitRoundButtonType.f36164n.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UiKitRoundButtonType.f36166p.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UiKitRoundButtonType.f36165o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UiKitRoundButtonType.f36167q.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f41106a = iArr;
        }
    }

    public ItemViewInflater(LayoutInflater inflater) {
        Intrinsics.f(inflater, "inflater");
        this.f41105a = inflater;
    }

    private final void a(ViewGroup.LayoutParams layoutParams, Margins margins) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = margins.a();
            marginLayoutParams.topMargin = margins.d();
            marginLayoutParams.leftMargin = margins.b();
            marginLayoutParams.rightMargin = margins.c();
        }
    }

    public final RoundButton b(CharSequence text, ViewGroup parent, Margins margins) {
        Intrinsics.f(text, "text");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(margins, "margins");
        return h(text, new RoundButtonStyle(UiKitRoundButtonType.f36161k, UiKitRoundButtonSize.f36155i), parent, margins);
    }

    public final ImageView c(int i8, ViewGroup parent, Margins margins) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(margins, "margins");
        View inflate = this.f41105a.inflate(R$layout.f40786q, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) inflate;
        imageView.setImageResource(i8);
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        Intrinsics.e(params, "params");
        a(params, margins);
        parent.addView(imageView, params);
        return imageView;
    }

    public final TextView d(CharSequence text, ViewGroup parent, Margins margins) {
        Intrinsics.f(text, "text");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(margins, "margins");
        View inflate = this.f41105a.inflate(R$layout.f40787r, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(text);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        Intrinsics.e(params, "params");
        a(params, margins);
        parent.addView(textView, params);
        return textView;
    }

    public final RoundButton e(CharSequence text, ViewGroup parent, Margins margins) {
        Intrinsics.f(text, "text");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(margins, "margins");
        return h(text, new RoundButtonStyle(UiKitRoundButtonType.f36164n, UiKitRoundButtonSize.f36155i), parent, margins);
    }

    public final TextView f(CharSequence text, ViewGroup parent, Margins margins) {
        Intrinsics.f(text, "text");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(margins, "margins");
        View inflate = this.f41105a.inflate(R$layout.dialog_item_subtitle, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(text);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        Intrinsics.e(params, "params");
        a(params, margins);
        parent.addView(textView, params);
        return textView;
    }

    public final TextView g(CharSequence text, ViewGroup parent, Margins margins) {
        Intrinsics.f(text, "text");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(margins, "margins");
        View inflate = this.f41105a.inflate(R$layout.f40788t, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(text);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        Intrinsics.e(params, "params");
        a(params, margins);
        parent.addView(textView, params);
        return textView;
    }

    public final RoundButton h(CharSequence text, RoundButtonStyle style, ViewGroup parent, Margins margins) {
        int i8;
        Intrinsics.f(text, "text");
        Intrinsics.f(style, "style");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(margins, "margins");
        if (style.a() == UiKitRoundButtonSize.f36156j) {
            switch (WhenMappings.f41106a[style.b().ordinal()]) {
                case 1:
                    i8 = R$layout.f40773d;
                    break;
                case 2:
                    i8 = R$layout.f40779j;
                    break;
                case 3:
                    i8 = R$layout.f40775f;
                    break;
                case 4:
                    i8 = R$layout.f40783n;
                    break;
                case 5:
                    i8 = R$layout.f40781l;
                    break;
                case 6:
                    i8 = R$layout.f40785p;
                    break;
                case 7:
                    i8 = R$layout.f40777h;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            switch (WhenMappings.f41106a[style.b().ordinal()]) {
                case 1:
                    i8 = R$layout.f40772c;
                    break;
                case 2:
                    i8 = R$layout.f40778i;
                    break;
                case 3:
                    i8 = R$layout.f40774e;
                    break;
                case 4:
                    i8 = R$layout.f40782m;
                    break;
                case 5:
                    i8 = R$layout.f40780k;
                    break;
                case 6:
                    i8 = R$layout.f40784o;
                    break;
                case 7:
                    i8 = R$layout.f40776g;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        View inflate = this.f41105a.inflate(i8, parent, false);
        Intrinsics.d(inflate, "null cannot be cast to non-null type ee.mtakso.driver.uikit.widgets.RoundButton");
        RoundButton roundButton = (RoundButton) inflate;
        roundButton.setText(text);
        ViewGroup.LayoutParams params = roundButton.getLayoutParams();
        Intrinsics.e(params, "params");
        a(params, margins);
        parent.addView(roundButton, params);
        return roundButton;
    }
}
