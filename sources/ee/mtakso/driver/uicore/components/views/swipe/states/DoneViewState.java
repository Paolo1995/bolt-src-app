package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.drawables.AnimatedPathDrawable;
import ee.mtakso.driver.uicore.utils.AlphaAnimatorHelper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DoneViewState.kt */
/* loaded from: classes5.dex */
public final class DoneViewState extends ViewState {

    /* renamed from: f  reason: collision with root package name */
    private AnimatedPathDrawable f35698f;

    /* renamed from: g  reason: collision with root package name */
    private final AppCompatImageView f35699g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoneViewState(Context context, ViewGroup parent) {
        super(context, parent, R$layout.content_swipe_button_done_state);
        Intrinsics.f(context, "context");
        Intrinsics.f(parent, "parent");
        this.f35698f = AnimatedPathDrawable.f34776p.a(-65536);
        View findViewById = parent.findViewById(R$id.doneImageView);
        Intrinsics.e(findViewById, "parent.findViewById(R.id.doneImageView)");
        this.f35699g = (AppCompatImageView) findViewById;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator d() {
        return AlphaAnimatorHelper.f35720a.d(this.f35699g);
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator j() {
        this.f35699g.setImageDrawable(this.f35698f);
        this.f35698f.start();
        return AlphaAnimatorHelper.f35720a.c(this.f35699g);
    }

    public final void k(int i8) {
        this.f35698f = AnimatedPathDrawable.f34776p.a(i8);
    }
}
