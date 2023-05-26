package ee.mtakso.driver.uicore.components.views.order_stops_view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStopItem.kt */
/* loaded from: classes5.dex */
public final class OrderStopItem extends ConstraintLayout {
    public Map<Integer, View> E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderStopItem(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.E = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R$layout.content_order_stop, (ViewGroup) this, true);
        setMinHeight(Dimens.d(32));
    }

    public View B(int i8) {
        Map<Integer, View> map = this.E;
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

    public final void setIconMarginLeft(int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = ((ImageView) B(R$id.iconStart)).getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.setMarginStart(i8);
    }

    public final void setStartImageSrc(int i8) {
        ((ImageView) B(R$id.iconStart)).setImageResource(i8);
    }

    public final void setStartTimelineTint(ColorStateList colorStateList) {
        ViewCompat.x0(B(R$id.timeLineBegin), colorStateList);
        ViewCompat.x0(B(R$id.timeLineFinish), colorStateList);
        ViewCompat.x0(B(R$id.timeLineContinueTop), colorStateList);
        ViewCompat.x0(B(R$id.timeLineContinueBottom), colorStateList);
    }

    public final void setTimeText(String str) {
        if (str == null) {
            int i8 = R$id.textEnd;
            ((TextView) B(i8)).setVisibility(8);
            ((TextView) B(i8)).setText("00:00");
            return;
        }
        int i9 = R$id.textEnd;
        ((TextView) B(i9)).setVisibility(0);
        ((TextView) B(i9)).setText(str);
    }

    public final void setTitle(CharSequence title) {
        Intrinsics.f(title, "title");
        ((TextView) B(R$id.textTitle)).setText(title);
    }

    public final void setTitleColor(int i8) {
        ((TextView) B(R$id.textTitle)).setTextColor(i8);
    }

    public final void setTitleTextSize(float f8) {
        ((TextView) B(R$id.textTitle)).setTextSize(0, f8);
    }

    public /* synthetic */ OrderStopItem(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
