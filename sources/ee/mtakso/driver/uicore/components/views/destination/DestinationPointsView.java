package ee.mtakso.driver.uicore.components.views.destination;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$drawable;
import ee.mtakso.driver.uicore.components.views.CustomListItem;
import ee.mtakso.driver.uicore.components.views.destination.Destination;
import ee.mtakso.driver.uicore.components.views.destination.DestinationPointsView;
import ee.mtakso.driver.uicore.utils.Dimens;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationPointsView.kt */
/* loaded from: classes5.dex */
public final class DestinationPointsView extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private String f35591f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<Destination> f35592g;

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f35593h;

    /* renamed from: i  reason: collision with root package name */
    private Function1<? super Integer, Unit> f35594i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f35595j;

    /* renamed from: k  reason: collision with root package name */
    private String f35596k;

    /* renamed from: l  reason: collision with root package name */
    private final int f35597l;

    /* renamed from: m  reason: collision with root package name */
    private final float f35598m;

    /* compiled from: DestinationPointsView.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35599a;

        static {
            int[] iArr = new int[Destination.StopType.values().length];
            try {
                iArr[Destination.StopType.DESTINATION_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Destination.StopType.NEXT_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Destination.StopType.COMMON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Destination.StopType.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f35599a = iArr;
        }
    }

    private final void b() {
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = Dimens.d(1);
        layoutParams.topMargin = Dimens.d(1);
        for (final Destination destination : this.f35592g) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            CustomListItem customListItem = new CustomListItem(context, null, 0, 6, null);
            customListItem.setBackgroundColor(getResources().getColor(R$color.f34585f));
            String a8 = destination.a();
            if (a8 == null) {
                String str = this.f35591f;
                if (str == null) {
                    Intrinsics.w("setDestinationPlaceholder");
                    str = null;
                }
                CustomListItem.J(customListItem, str, 0, 0, 6, null);
                customListItem.setOnClickListener(this.f35593h);
            } else {
                CustomListItem.J(customListItem, a8, 0, 0, 6, null);
                customListItem.setOnClickListener(new View.OnClickListener() { // from class: w5.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DestinationPointsView.c(DestinationPointsView.this, destination, view);
                    }
                });
            }
            int i8 = WhenMappings.f35599a[destination.c().ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            customListItem.setStartImageSrc(R$drawable.pin_location_neutral900);
                            if (this.f35595j) {
                                customListItem.setEndText(this.f35596k);
                                customListItem.setEndTextColor(this.f35597l);
                                customListItem.setEndTextSize(this.f35598m);
                                customListItem.getEndTextView().setVisibility(0);
                                customListItem.getEndTextView().setOnClickListener(this.f35593h);
                            } else {
                                customListItem.getEndTextView().setVisibility(8);
                            }
                        }
                    } else {
                        customListItem.setStartImageSrc(R$drawable.pin_location_neutral900);
                        customListItem.getEndTextView().setVisibility(4);
                    }
                } else {
                    customListItem.setStartImageSrc(R$drawable.pin_location_purple);
                    customListItem.getEndTextView().setVisibility(4);
                }
            } else {
                customListItem.setStartImageSrc(R$drawable.pin_location_red);
                if (this.f35595j) {
                    customListItem.setEndText(this.f35596k);
                    customListItem.setEndTextColor(this.f35597l);
                    customListItem.setEndTextSize(this.f35598m);
                    customListItem.getEndTextView().setVisibility(0);
                    customListItem.getEndTextView().setOnClickListener(this.f35593h);
                } else {
                    customListItem.getEndTextView().setVisibility(8);
                }
            }
            customListItem.setLayoutParams(layoutParams);
            addView(customListItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DestinationPointsView this$0, Destination dest, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(dest, "$dest");
        Function1<? super Integer, Unit> function1 = this$0.f35594i;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(dest.b()));
        }
    }

    public final void setChangeText(CharSequence changeText) {
        Intrinsics.f(changeText, "changeText");
        this.f35596k = changeText.toString();
        b();
    }

    public final void setOnChangeDestinationClickListener(View.OnClickListener listener) {
        Intrinsics.f(listener, "listener");
        this.f35593h = listener;
    }

    public final void setOnStopClickListener(Function1<? super Integer, Unit> listener) {
        Intrinsics.f(listener, "listener");
        this.f35594i = listener;
    }
}
