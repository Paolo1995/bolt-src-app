package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewState.kt */
/* loaded from: classes5.dex */
public abstract class ViewState {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f35715a;

    /* renamed from: b  reason: collision with root package name */
    private final int f35716b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f35717c;

    /* renamed from: d  reason: collision with root package name */
    private final LayoutInflater f35718d;

    /* renamed from: e  reason: collision with root package name */
    private Animator f35719e;

    public ViewState(Context context, ViewGroup parent, int i8) {
        Intrinsics.f(context, "context");
        Intrinsics.f(parent, "parent");
        this.f35715a = parent;
        this.f35716b = i8;
        this.f35717c = new Rect();
        LayoutInflater from = LayoutInflater.from(context);
        this.f35718d = from;
        from.inflate(i8, parent, true);
    }

    public final void a() {
        Animator animator = this.f35719e;
        if (animator == null) {
            return;
        }
        if (animator.isRunning()) {
            animator.removeAllListeners();
            animator.cancel();
        }
        this.f35719e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Rect b() {
        return this.f35717c;
    }

    public final void c() {
        a();
        this.f35719e = d();
    }

    protected abstract Animator d();

    public void e() {
    }

    public boolean f(MotionEvent event) {
        Intrinsics.f(event, "event");
        return false;
    }

    public final void g(Rect viewBounds) {
        Intrinsics.f(viewBounds, "viewBounds");
        this.f35717c.set(viewBounds);
    }

    public boolean h(MotionEvent event) {
        Intrinsics.f(event, "event");
        return false;
    }

    public final void i() {
        a();
        this.f35719e = j();
    }

    protected abstract Animator j();
}
