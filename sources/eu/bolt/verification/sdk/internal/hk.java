package eu.bolt.verification.sdk.internal;

import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.sdk.internal.sj;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class hk<T extends sj> implements c1 {

    /* renamed from: g  reason: collision with root package name */
    private static final a f43410g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final ik f43411a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ gk f43412b;

    /* renamed from: c  reason: collision with root package name */
    private T f43413c;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintLayout f43414d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f43415e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f43416f;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public hk(ik listener) {
        Intrinsics.f(listener, "listener");
        this.f43411a = listener;
        this.f43412b = new gk(listener);
    }

    private final void m(T t7) {
        ColorDrawable colorDrawable = new ColorDrawable(t7.c());
        ConstraintLayout constraintLayout = null;
        if (this.f43415e == null) {
            ConstraintLayout constraintLayout2 = this.f43414d;
            if (constraintLayout2 == null) {
                Intrinsics.w("contentView");
            } else {
                constraintLayout = constraintLayout2;
            }
            constraintLayout.setBackground(colorDrawable);
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{this.f43415e, colorDrawable});
            ConstraintLayout constraintLayout3 = this.f43414d;
            if (constraintLayout3 == null) {
                Intrinsics.w("contentView");
            } else {
                constraintLayout = constraintLayout3;
            }
            constraintLayout.setBackground(transitionDrawable);
            transitionDrawable.startTransition(400);
        }
        this.f43415e = colorDrawable;
    }

    public abstract void e(ConstraintLayout constraintLayout, Function0<Unit> function0, Function1<? super PointF, Unit> function1);

    public final void f(T slide, ConstraintLayout view, Function0<Unit> onDownFling, Function1<? super PointF, Unit> onSingleTap) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        Intrinsics.f(onDownFling, "onDownFling");
        Intrinsics.f(onSingleTap, "onSingleTap");
        ConstraintLayout constraintLayout = (ConstraintLayout) uq.j(view, o());
        this.f43414d = constraintLayout;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.w("contentView");
            constraintLayout = null;
        }
        j(slide, constraintLayout);
        ConstraintLayout constraintLayout3 = this.f43414d;
        if (constraintLayout3 == null) {
            Intrinsics.w("contentView");
        } else {
            constraintLayout2 = constraintLayout3;
        }
        e(constraintLayout2, onDownFling, onSingleTap);
    }

    public void g(tj tjVar, DesignImageView view) {
        Intrinsics.f(view, "view");
        this.f43412b.k(tjVar, view);
    }

    public void h(List<? extends DesignImageView> views) {
        Intrinsics.f(views, "views");
        this.f43412b.l(views);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(sj slide) {
        Intrinsics.f(slide, "slide");
        this.f43413c = slide;
        k(slide);
    }

    public void j(T slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        this.f43414d = view;
        d(slide, view);
    }

    public void k(T slide) {
        Intrinsics.f(slide, "slide");
        m(slide);
        c(slide);
    }

    public void l() {
        q();
        c();
        ConstraintLayout constraintLayout = this.f43414d;
        if (constraintLayout == null) {
            Intrinsics.w("contentView");
            constraintLayout = null;
        }
        constraintLayout.setBackgroundColor(-1);
        this.f43413c = null;
    }

    public final ConstraintLayout n() {
        ConstraintLayout constraintLayout = this.f43414d;
        if (constraintLayout == null) {
            Intrinsics.w("contentView");
            return null;
        }
        return constraintLayout;
    }

    public abstract int o();

    public final ik p() {
        return this.f43411a;
    }

    public void q() {
        this.f43412b.m();
    }

    public void r() {
        t();
        s();
    }

    public void s() {
        this.f43412b.o();
    }

    public void t() {
        if (this.f43416f) {
            this.f43416f = false;
            u();
        }
    }

    public void u() {
        this.f43412b.q();
    }

    public void v() {
        if (this.f43416f) {
            return;
        }
        this.f43416f = true;
        w();
    }

    public void w() {
        this.f43412b.r();
    }
}
