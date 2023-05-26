package ee.mtakso.driver.uicore.components.views.order_stops_view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.SpannableUtilsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStopsView.kt */
/* loaded from: classes5.dex */
public final class OrderStopsView extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<Stop> f35643f;

    /* renamed from: g  reason: collision with root package name */
    private final float f35644g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f35645h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f35646i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, View> f35647j;

    /* compiled from: OrderStopsView.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35648a;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.PICK_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.PICK_UP_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.COMMON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemType.FINAL_DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ItemType.RIDE_CANCELLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ItemType.RIDE_DECLINED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f35648a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrderStopsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderStopsView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35647j = new LinkedHashMap();
        this.f35643f = new ArrayList<>();
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f34735z2);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…styleable.OrderStopsView)");
        this.f35644g = obtainStyledAttributes.getDimension(R$styleable.A2, Dimens.a(14.0f));
        this.f35645h = obtainStyledAttributes.getBoolean(R$styleable.B2, true);
        setTimelineTint(obtainStyledAttributes.getColorStateList(R$styleable.C2));
        obtainStyledAttributes.recycle();
    }

    private final void a() {
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        for (Stop stop : this.f35643f) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            OrderStopItem orderStopItem = new OrderStopItem(context, null, 0, 6, null);
            orderStopItem.setTitle(b(stop));
            orderStopItem.setTimeText(stop.b());
            orderStopItem.setTitleTextSize(this.f35644g);
            orderStopItem.setTitleColor(stop.e());
            orderStopItem.setStartImageSrc(stop.c());
            orderStopItem.setStartTimelineTint(this.f35646i);
            orderStopItem.setIconMarginLeft(stop.d());
            switch (WhenMappings.f35648a[stop.g().ordinal()]) {
                case 1:
                    orderStopItem.B(R$id.timeLineBegin).setVisibility(0);
                    orderStopItem.B(R$id.timeLineFinish).setVisibility(8);
                    orderStopItem.B(R$id.timeLineContinueTop).setVisibility(8);
                    orderStopItem.B(R$id.timeLineContinueBottom).setVisibility(8);
                    orderStopItem.B(R$id.f34605x).setVisibility(0);
                    break;
                case 2:
                    orderStopItem.B(R$id.timeLineBegin).setVisibility(8);
                    orderStopItem.B(R$id.timeLineFinish).setVisibility(8);
                    orderStopItem.B(R$id.timeLineContinueTop).setVisibility(8);
                    orderStopItem.B(R$id.timeLineContinueBottom).setVisibility(8);
                    orderStopItem.B(R$id.f34605x).setVisibility(0);
                    break;
                case 3:
                    orderStopItem.B(R$id.timeLineBegin).setVisibility(8);
                    orderStopItem.B(R$id.timeLineFinish).setVisibility(8);
                    orderStopItem.B(R$id.timeLineContinueTop).setVisibility(0);
                    orderStopItem.B(R$id.timeLineContinueBottom).setVisibility(0);
                    orderStopItem.B(R$id.f34605x).setVisibility(0);
                    break;
                case 4:
                    orderStopItem.B(R$id.timeLineBegin).setVisibility(8);
                    orderStopItem.B(R$id.timeLineFinish).setVisibility(0);
                    orderStopItem.B(R$id.timeLineContinueTop).setVisibility(8);
                    orderStopItem.B(R$id.timeLineContinueBottom).setVisibility(8);
                    orderStopItem.B(R$id.f34605x).setVisibility(8);
                    break;
                case 5:
                    orderStopItem.B(R$id.f34605x).setVisibility(8);
                    break;
                case 6:
                    orderStopItem.B(R$id.f34605x).setVisibility(8);
                    break;
            }
            if (!this.f35645h) {
                orderStopItem.B(R$id.f34605x).setVisibility(4);
            }
            orderStopItem.setLayoutParams(layoutParams);
            addView(orderStopItem);
        }
    }

    private final SpannableStringBuilder b(Stop stop) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stop.f());
        if (stop.a() != null) {
            spannableStringBuilder.append((CharSequence) SpannableUtilsKt.a(" • ", ContextCompat.getColor(getContext(), R$color.white500))).append((CharSequence) SpannableUtilsKt.a(stop.a(), ContextCompat.getColor(getContext(), R$color.f34587l)));
        }
        return spannableStringBuilder;
    }

    public final ColorStateList getTimelineTint() {
        return this.f35646i;
    }

    public final void setItems(List<Stop> items) {
        Intrinsics.f(items, "items");
        this.f35643f.clear();
        this.f35643f.addAll(items);
        a();
    }

    public final void setTimelineTint(ColorStateList colorStateList) {
        OrderStopItem orderStopItem;
        this.f35646i = colorStateList;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            Intrinsics.e(childAt, "getChildAt(index)");
            if (childAt instanceof OrderStopItem) {
                orderStopItem = (OrderStopItem) childAt;
            } else {
                orderStopItem = null;
            }
            if (orderStopItem != null) {
                orderStopItem.setStartTimelineTint(colorStateList);
            }
        }
    }

    public /* synthetic */ OrderStopsView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
