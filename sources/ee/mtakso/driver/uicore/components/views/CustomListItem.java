package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: CustomListItem.kt */
/* loaded from: classes5.dex */
public final class CustomListItem extends ConstraintLayout {
    private View.OnClickListener E;
    private View.OnClickListener F;
    public Map<Integer, View> G;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomListItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomListItem(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.G = new LinkedHashMap();
        this.E = new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.views.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomListItem.L(view);
            }
        };
        this.F = new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.views.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomListItem.K(view);
            }
        };
        LayoutInflater.from(context).inflate(R$layout.item_custom_list, (ViewGroup) this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.D0, 0, 0);
            Intrinsics.e(obtainStyledAttributes, "context.theme.obtainStyl…ble.CustomListItem, 0, 0)");
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.G0, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.F0, -1);
            int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.N0, -1);
            int i9 = R$styleable.O0;
            int resourceId4 = obtainStyledAttributes.getResourceId(i9, -1);
            String string = obtainStyledAttributes.getString(i9);
            int color = obtainStyledAttributes.getColor(R$styleable.E0, 0);
            int color2 = obtainStyledAttributes.getColor(R$styleable.J0, -1);
            int color3 = obtainStyledAttributes.getColor(R$styleable.I0, -1);
            String string2 = obtainStyledAttributes.getString(R$styleable.K0);
            int color4 = obtainStyledAttributes.getColor(R$styleable.L0, -1);
            float dimension = obtainStyledAttributes.getDimension(R$styleable.M0, Dimens.a(20.0f));
            int color5 = obtainStyledAttributes.getColor(R$styleable.H0, 0);
            int i10 = R$id.textEndView;
            TextView textEndView = (TextView) D(i10);
            Intrinsics.e(textEndView, "textEndView");
            ViewExtKt.e(textEndView, string2 != null, 0, 2, null);
            if (string2 != null) {
                setEndText(string2);
            }
            setEndTextColor(color4);
            ((TextView) D(i10)).setTextSize(0, dimension);
            setBackgroundColor(color);
            setTitleColor(color2);
            setSubTitleColor(color3);
            setStartImageSrc(resourceId);
            setStartImageTint(color5);
            setEndImageSrc(resourceId2);
            if (string != null) {
                I(string, resourceId3, color2);
            } else if (resourceId4 != -1) {
                H(resourceId4, resourceId3, color2);
            }
            obtainStyledAttributes.recycle();
        }
        setMinHeight(Dimens.d(56));
    }

    private final void G(final TextView textView, String str, int i8, final int i9) {
        Drawable drawable;
        ImageSpan imageSpan = null;
        if (i8 != -1) {
            drawable = ContextCompat.getDrawable(textView.getContext(), i8);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, Dimens.d(20), Dimens.d(20));
            imageSpan = new ImageSpan(drawable, 0);
        }
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: ee.mtakso.driver.uicore.components.views.CustomListItem$setSpannableStringWithIcon$imageClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                View.OnClickListener onClickListener;
                Intrinsics.f(widget, "widget");
                onClickListener = CustomListItem.this.F;
                onClickListener.onClick(widget);
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: ee.mtakso.driver.uicore.components.views.CustomListItem$setSpannableStringWithIcon$textClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                View.OnClickListener onClickListener;
                Intrinsics.f(widget, "widget");
                onClickListener = CustomListItem.this.E;
                onClickListener.onClick(textView);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.f(ds, "ds");
                int i10 = i9;
                ds.linkColor = i10;
                ds.setColor(i10);
                ds.setUnderlineText(false);
            }
        };
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (imageSpan != null) {
            spannableStringBuilder.append((CharSequence) "   ");
            spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(clickableSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableStringBuilder.setSpan(clickableSpan2, 0, spannableStringBuilder.length() - 1, 33);
        }
        textView.setText(spannableStringBuilder);
    }

    public static /* synthetic */ void J(CustomListItem customListItem, String str, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = -1;
        }
        if ((i10 & 4) != 0) {
            i9 = -1;
        }
        customListItem.I(str, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(View view) {
    }

    private final void setStartImageTint(int i8) {
        ImageView iconStart = (ImageView) D(R$id.iconStart);
        Intrinsics.e(iconStart, "iconStart");
        ImageViewExtKt.a(iconStart, new Color.Static(i8));
    }

    public View D(int i8) {
        Map<Integer, View> map = this.G;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final void H(int i8, int i9, int i10) {
        String string = getContext().getString(i8);
        Intrinsics.e(string, "context.getString(titleRes)");
        TextView textTitle = (TextView) D(R$id.textTitle);
        Intrinsics.e(textTitle, "textTitle");
        G(textTitle, string, i9, i10);
    }

    public final void I(String title, int i8, int i9) {
        Intrinsics.f(title, "title");
        TextView textTitle = (TextView) D(R$id.textTitle);
        Intrinsics.e(textTitle, "textTitle");
        G(textTitle, title, i8, i9);
    }

    public final ImageView getEndImageView() {
        return (ImageView) D(R$id.iconEnd);
    }

    public final ProgressBar getEndProgress() {
        return (ProgressBar) D(R$id.progressEnd);
    }

    public final TextView getEndTextView() {
        return (TextView) D(R$id.textEndView);
    }

    public final ImageView getStartImageView() {
        return (ImageView) D(R$id.iconStart);
    }

    public final TextView getTitleView() {
        return (TextView) D(R$id.textTitle);
    }

    public final void setEndImageSrc(int i8) {
        if (i8 != -1) {
            int i9 = R$id.iconEnd;
            ((ImageView) D(i9)).setVisibility(0);
            ((ImageView) D(i9)).setImageResource(i8);
            return;
        }
        ((ImageView) D(R$id.iconEnd)).setVisibility(8);
    }

    public final void setEndText(CharSequence charSequence) {
        ((TextView) D(R$id.textEndView)).setText(charSequence);
    }

    public final void setEndTextColor(int i8) {
        ((TextView) D(R$id.textEndView)).setTextColor(i8);
    }

    public final void setEndTextRes(int i8) {
        ((TextView) D(R$id.textEndView)).setText(i8);
    }

    public final void setEndTextSize(float f8) {
        ((TextView) D(R$id.textEndView)).setTextSize(0, f8);
    }

    public final void setStartImageSrc(int i8) {
        if (i8 != -1) {
            int i9 = R$id.iconStart;
            ((ImageView) D(i9)).setVisibility(0);
            ((ImageView) D(i9)).setImageResource(i8);
            return;
        }
        ((ImageView) D(R$id.iconStart)).setVisibility(8);
    }

    public final void setSubTitle(String str) {
        boolean z7;
        boolean y7;
        int i8 = R$id.textSubTitle;
        TextView textSubTitle = (TextView) D(i8);
        Intrinsics.e(textSubTitle, "textSubTitle");
        if (str != null) {
            y7 = StringsKt__StringsJVMKt.y(str);
            if (!y7) {
                z7 = false;
                ViewExtKt.e(textSubTitle, true ^ z7, 0, 2, null);
                ((TextView) D(i8)).setText(str);
            }
        }
        z7 = true;
        ViewExtKt.e(textSubTitle, true ^ z7, 0, 2, null);
        ((TextView) D(i8)).setText(str);
    }

    public final void setSubTitleColor(int i8) {
        ((TextView) D(R$id.textSubTitle)).setTextColor(i8);
    }

    public final void setTextIconClickListener(View.OnClickListener listener) {
        Intrinsics.f(listener, "listener");
        this.F = listener;
    }

    public final void setTitleColor(int i8) {
        ((TextView) D(R$id.textTitle)).setTextColor(i8);
    }

    public final void setTitleTextClickListener(View.OnClickListener listener) {
        Intrinsics.f(listener, "listener");
        this.E = listener;
    }

    public /* synthetic */ CustomListItem(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
