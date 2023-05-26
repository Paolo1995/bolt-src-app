package eu.bolt.verification.sdk.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.stories.view.storyprogress.StoryProgressView;
import eu.bolt.client.stories.view.storyslide.StorySlideView;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;

/* loaded from: classes5.dex */
public final class wq implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f45585a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final xq f45586b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f45587c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final MaterialCardView f45588d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f45589e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final StorySlideView f45590f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final DesignImageView f45591g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final StoryProgressView f45592h;

    private wq(@NonNull View view, @NonNull xq xqVar, @NonNull ProgressBar progressBar, @NonNull MaterialCardView materialCardView, @NonNull ConstraintLayout constraintLayout, @NonNull StorySlideView storySlideView, @NonNull DesignImageView designImageView, @NonNull StoryProgressView storyProgressView) {
        this.f45585a = view;
        this.f45586b = xqVar;
        this.f45587c = progressBar;
        this.f45588d = materialCardView;
        this.f45589e = constraintLayout;
        this.f45590f = storySlideView;
        this.f45591g = designImageView;
        this.f45592h = storyProgressView;
    }

    @NonNull
    public static wq a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R$layout.view_story, viewGroup);
            return b(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public static wq b(@NonNull View view) {
        int i8 = R$id.errorContent;
        View a8 = ViewBindings.a(view, i8);
        if (a8 != null) {
            xq b8 = xq.b(a8);
            i8 = R$id.f41734s0;
            ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, i8);
            if (progressBar != null) {
                i8 = R$id.M0;
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.a(view, i8);
                if (materialCardView != null) {
                    i8 = R$id.slideContent;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i8);
                    if (constraintLayout != null) {
                        i8 = R$id.S0;
                        StorySlideView storySlideView = (StorySlideView) ViewBindings.a(view, i8);
                        if (storySlideView != null) {
                            i8 = R$id.Z0;
                            DesignImageView designImageView = (DesignImageView) ViewBindings.a(view, i8);
                            if (designImageView != null) {
                                i8 = R$id.f41717a1;
                                StoryProgressView storyProgressView = (StoryProgressView) ViewBindings.a(view, i8);
                                if (storyProgressView != null) {
                                    return new wq(view, b8, progressBar, materialCardView, constraintLayout, storySlideView, designImageView, storyProgressView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i8)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f45585a;
    }
}
