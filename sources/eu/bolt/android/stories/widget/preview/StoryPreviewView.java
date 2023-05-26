package eu.bolt.android.stories.widget.preview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.card.MaterialCardView;
import eu.bolt.android.stories.R$color;
import eu.bolt.android.stories.R$dimen;
import eu.bolt.android.stories.R$id;
import eu.bolt.android.stories.R$layout;
import eu.bolt.android.stories.model.StoryPreview;
import eu.bolt.android.stories.widget.helper.LineInfoProviderImpl;
import eu.bolt.android.stories.widget.helper.RoundedBackgroundSpan;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: StoryPreviewView.kt */
/* loaded from: classes5.dex */
public final class StoryPreviewView extends ConstraintLayout {
    private final TextView E;
    private final ImageView F;
    private final MaterialCardView G;
    public Map<Integer, View> H;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryPreviewView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.H = new LinkedHashMap();
        View.inflate(context, R$layout.view_story_preview_content, this);
        View findViewById = findViewById(R$id.storyPreviewTitle);
        Intrinsics.e(findViewById, "findViewById(R.id.storyPreviewTitle)");
        this.E = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.storyPreviewImage);
        Intrinsics.e(findViewById2, "findViewById(R.id.storyPreviewImage)");
        this.F = (ImageView) findViewById2;
        View findViewById3 = findViewById(R$id.previewImageBackground);
        Intrinsics.e(findViewById3, "findViewById(R.id.previewImageBackground)");
        this.G = (MaterialCardView) findViewById3;
    }

    private final int B(int i8) {
        return ContextCompat.getColor(getContext(), i8);
    }

    private final float C(int i8) {
        return getResources().getDimension(i8);
    }

    private final int D(int i8) {
        return getResources().getDimensionPixelSize(i8);
    }

    private final void F(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(C(R$dimen.story_preview_corner_radius));
        gradientDrawable.setStroke(D(R$dimen.story_preview_stroke_width), B(R$color.story_preview_stroke_color));
        setBackground(gradientDrawable);
    }

    private final void G(String str) {
        int d8;
        int d9;
        int B = B(R$color.f37426h);
        int D = D(R$dimen.story_preview_text_background_horizontal_padding);
        float C = C(R$dimen.story_preview_text_background_radius);
        TextView textView = this.E;
        d8 = RangesKt___RangesKt.d(getPaddingLeft(), D);
        int paddingTop = getPaddingTop();
        d9 = RangesKt___RangesKt.d(getPaddingRight(), D);
        textView.setPadding(d8, paddingTop, d9, getPaddingBottom());
        this.E.setShadowLayer(D, 0.0f, 0.0f, 0);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new RoundedBackgroundSpan(B, D, C, new LineInfoProviderImpl(this.E)), 0, str.length(), 18);
        this.E.setText(spannableString);
    }

    public final void E(StoryPreview data) {
        Intrinsics.f(data, "data");
        G(data.d());
        String c8 = data.c();
        this.F.setVisibility(0);
        this.G.setVisibility(0);
        Glide.u(this.F).s(c8).D0(new RequestListener<Drawable>() { // from class: eu.bolt.android.stories.widget.preview.StoryPreviewView$showStoryPreview$1$1
            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a */
            public boolean j(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z7) {
                Kalev.d("Loading");
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean h(GlideException glideException, Object obj, Target<Drawable> target, boolean z7) {
                if (glideException != null) {
                    glideException.printStackTrace();
                    return false;
                }
                return false;
            }
        }).B0(this.F);
        F(data.a());
    }

    public /* synthetic */ StoryPreviewView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
