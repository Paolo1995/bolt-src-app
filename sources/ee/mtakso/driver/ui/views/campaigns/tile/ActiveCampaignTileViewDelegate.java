package ee.mtakso.driver.ui.views.campaigns.tile;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveCampaignTileViewDelegate.kt */
/* loaded from: classes5.dex */
public final class ActiveCampaignTileViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final CardView f34347a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f34348b;

    /* compiled from: ActiveCampaignTileViewDelegate.kt */
    /* loaded from: classes5.dex */
    public enum LeftActionMode {
        DISMISS,
        CHEVRON,
        NONE
    }

    /* compiled from: ActiveCampaignTileViewDelegate.kt */
    /* loaded from: classes5.dex */
    public enum ViewMode {
        TILE,
        LIST_ITEM
    }

    /* compiled from: ActiveCampaignTileViewDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34356a;

        static {
            int[] iArr = new int[LeftActionMode.values().length];
            try {
                iArr[LeftActionMode.DISMISS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LeftActionMode.CHEVRON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f34356a = iArr;
        }
    }

    public ActiveCampaignTileViewDelegate(View includeView, ViewMode viewMode, LeftActionMode leftActionMode) {
        Intrinsics.f(includeView, "includeView");
        Intrinsics.f(viewMode, "viewMode");
        Intrinsics.f(leftActionMode, "leftActionMode");
        this.f34348b = new LinkedHashMap();
        this.f34347a = (CardView) includeView;
        ViewMode viewMode2 = ViewMode.TILE;
        if (viewMode == viewMode2) {
            b().setRadius(Dimens.d(4));
            b().setCardElevation(Dimens.d(4));
        } else {
            b().setRadius(0.0f);
            b().setCardElevation(0.0f);
            b().setUseCompatPadding(false);
            b().setPadding(0, 0, 0, 0);
            b().setBackgroundColor(ContextCompat.getColor(b().getContext(), R.color.white));
        }
        int i8 = WhenMappings.f34356a[leftActionMode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                ((ConstraintLayout) a(R.id.containerActiveCampaign)).setVisibility(8);
                return;
            }
            int i9 = R.id.iconCampaignLeftAction;
            ViewGroup.LayoutParams layoutParams = ((AppCompatImageView) a(i9)).getLayoutParams();
            Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (viewMode == viewMode2) {
                layoutParams2.height = Dimens.d(12);
                layoutParams2.width = Dimens.d(12);
                layoutParams2.setMarginEnd(Dimens.d(8));
            } else {
                layoutParams2.rightMargin = Dimens.d(12);
            }
            ((AppCompatImageView) a(i9)).setLayoutParams(layoutParams2);
            return;
        }
        int i10 = R.id.iconCampaignLeftAction;
        ((AppCompatImageView) a(i10)).setScaleType(ImageView.ScaleType.FIT_START);
        int dimension = (int) b().getContext().getResources().getDimension(R.dimen.padding_bottom_start_active_campaign_tile_dismiss);
        ((LinearLayout) a(R.id.campaignLeftAction)).setPadding(dimension, 0, 0, dimension);
        ((AppCompatImageView) a(i10)).setImageResource(R.drawable.ic_close_small);
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f34348b;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View b8 = b();
            if (b8 == null || (findViewById = b8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    /* renamed from: c */
    public CardView b() {
        return this.f34347a;
    }

    public final void d(Integer num) {
        if (num == null) {
            ((AppCompatImageView) a(R.id.imgCampaign)).setVisibility(8);
            return;
        }
        int i8 = R.id.imgCampaign;
        ((AppCompatImageView) a(i8)).setVisibility(0);
        ((AppCompatImageView) a(i8)).setImageResource(num.intValue());
    }

    public final void e(Drawable drawable) {
        ((AppCompatImageView) a(R.id.imgCampaign)).setBackground(drawable);
    }

    public final void f(int i8) {
        int d8 = Dimens.d(i8);
        ((AppCompatImageView) a(R.id.imgCampaign)).setPadding(d8, d8, d8, d8);
    }

    public final void g(int i8) {
        ImageViewCompat.c((AppCompatImageView) a(R.id.imgCampaign), ColorStateList.valueOf(ContextCompat.getColor(b().getContext(), i8)));
    }

    public final void h(View.OnClickListener listener) {
        Intrinsics.f(listener, "listener");
        ((LinearLayout) a(R.id.campaignLeftAction)).setOnClickListener(listener);
    }

    public final void i(CharSequence charSequence) {
        int i8 = R.id.subtitleCampaign;
        ((TextView) a(i8)).setText(charSequence);
        if (charSequence == null) {
            ((TextView) a(i8)).setVisibility(8);
        } else {
            ((TextView) a(i8)).setVisibility(0);
        }
    }

    public final void j(int i8) {
        ((TextView) a(R.id.subtitleCampaign)).setTextColor(i8);
    }

    public final void k(CharSequence charSequence) {
        ((TextView) a(R.id.titleCampaign)).setText(charSequence);
    }
}
