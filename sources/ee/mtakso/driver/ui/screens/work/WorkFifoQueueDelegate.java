package ee.mtakso.driver.ui.screens.work;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.work.dashboard.DashboardState;
import ee.mtakso.driver.ui.screens.work.fifo.FifoCategoryItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Lottie;
import ee.mtakso.driver.uikit.utils.LottieExt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkFifoQueueDelegate.kt */
/* loaded from: classes5.dex */
public final class WorkFifoQueueDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f33679a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<DriverButtonAction, Unit> f33680b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f33681c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f33682d;

    /* renamed from: e  reason: collision with root package name */
    private final DiffAdapter f33683e;

    /* renamed from: f  reason: collision with root package name */
    private Lottie f33684f;

    /* renamed from: g  reason: collision with root package name */
    private Lottie f33685g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f33686h;

    /* JADX WARN: Multi-variable type inference failed */
    public WorkFifoQueueDelegate(View containerView, Function1<? super DriverButtonAction, Unit> actionListener, Function0<Unit> closeListener, Function0<Unit> retryListener) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(actionListener, "actionListener");
        Intrinsics.f(closeListener, "closeListener");
        Intrinsics.f(retryListener, "retryListener");
        this.f33686h = new LinkedHashMap();
        this.f33679a = containerView;
        this.f33680b = actionListener;
        this.f33681c = closeListener;
        this.f33682d = retryListener;
        DiffAdapter P = new DiffAdapter().P(new StaticItemDelegate(R.layout.content_work_fifo_item_stub)).P(new FifoCategoryItemDelegate()).P(new ButtonItemDelegate(new WorkFifoQueueDelegate$adapter$1(this)));
        this.f33683e = P;
        int i8 = R.id.H9;
        ((RecyclerView) c(i8)).setLayoutManager(new LinearLayoutManager(i().getContext()));
        ((RecyclerView) c(i8)).setAdapter(P);
        int i9 = R.id.infoLottie;
        ((LottieAnimationView) c(i9)).i(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.ui.screens.work.WorkFifoQueueDelegate.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.f(animation, "animation");
                WorkFifoQueueDelegate.this.l();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.f(animation, "animation");
                WorkFifoQueueDelegate.this.l();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.f(animation, "animation");
            }
        });
        ((LottieAnimationView) c(i9)).setRepeatCount(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WorkFifoQueueDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f33681c.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(WorkFifoQueueDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f33682d.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(ButtonItemDelegate.Model<DriverButtonAction> model) {
        DriverButtonAction t7 = model.t();
        if (t7 != null) {
            this.f33680b.invoke(t7);
        }
    }

    private final void k(Lottie lottie) {
        this.f33684f = lottie;
        if (lottie != null) {
            LottieExt lottieExt = LottieExt.f36047a;
            LottieAnimationView infoLottie = (LottieAnimationView) c(R.id.infoLottie);
            Intrinsics.e(infoLottie, "infoLottie");
            lottieExt.a(lottie, infoLottie);
        }
        ((LottieAnimationView) c(R.id.infoLottie)).x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        Lottie lottie = this.f33685g;
        if (lottie == null) {
            return;
        }
        this.f33685g = null;
        k(lottie);
    }

    public View c(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33686h;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View i9 = i();
            if (i9 == null || (findViewById = i9.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void f(DashboardState.FifoQueue state) {
        boolean z7;
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z8;
        Image image;
        boolean z9;
        Lottie lottie;
        boolean z10;
        CharSequence charSequence3;
        boolean z11;
        Text c8;
        Image a8;
        Text a9;
        Text b8;
        Intrinsics.f(state, "state");
        Context context = i().getContext();
        ConstraintLayout headerLayout = (ConstraintLayout) c(R.id.headerLayout);
        Intrinsics.e(headerLayout, "headerLayout");
        boolean z12 = true;
        if (state.b() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(headerLayout, z7, 0, 2, null);
        TextView textView = (TextView) c(R.id.cc);
        DashboardState.FifoQueue.Header b9 = state.b();
        if (b9 != null && (b8 = b9.b()) != null) {
            Intrinsics.e(context, "context");
            charSequence = TextKt.a(b8, context);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        TextView textView2 = (TextView) c(R.id.tb);
        DashboardState.FifoQueue.Header b10 = state.b();
        if (b10 != null && (a9 = b10.a()) != null) {
            Intrinsics.e(context, "context");
            charSequence2 = TextKt.a(a9, context);
        } else {
            charSequence2 = null;
        }
        textView2.setText(charSequence2);
        View headerLoadingLayout = c(R.id.headerLoadingLayout);
        Intrinsics.e(headerLoadingLayout, "headerLoadingLayout");
        ViewExtKt.d(headerLoadingLayout, state.e(), 0, 2, null);
        ConstraintLayout infoLayout = (ConstraintLayout) c(R.id.infoLayout);
        Intrinsics.e(infoLayout, "infoLayout");
        if (state.c() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.d(infoLayout, z8, 0, 2, null);
        int i8 = R.id.infoImage;
        ImageView infoImage = (ImageView) c(i8);
        Intrinsics.e(infoImage, "infoImage");
        DashboardState.FifoQueue.Info c9 = state.c();
        if (c9 != null) {
            image = c9.a();
        } else {
            image = null;
        }
        if (image != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        ViewExtKt.d(infoImage, z9, 0, 2, null);
        DashboardState.FifoQueue.Info c10 = state.c();
        if (c10 != null) {
            lottie = c10.b();
        } else {
            lottie = null;
        }
        int i9 = R.id.infoLottie;
        LottieAnimationView infoLottie = (LottieAnimationView) c(i9);
        Intrinsics.e(infoLottie, "infoLottie");
        if (lottie != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewExtKt.d(infoLottie, z10, 0, 2, null);
        if (!Intrinsics.a(this.f33684f, lottie)) {
            if (((LottieAnimationView) c(i9)).s()) {
                this.f33685g = lottie;
            } else {
                k(lottie);
            }
        }
        DashboardState.FifoQueue.Info c11 = state.c();
        if (c11 != null && (a8 = c11.a()) != null) {
            ImageView infoImage2 = (ImageView) c(i8);
            Intrinsics.e(infoImage2, "infoImage");
            ImageKt.b(a8, infoImage2, null, 2, null);
        }
        TextView textView3 = (TextView) c(R.id.infoText);
        DashboardState.FifoQueue.Info c12 = state.c();
        if (c12 != null && (c8 = c12.c()) != null) {
            Intrinsics.e(context, "context");
            charSequence3 = TextKt.a(c8, context);
        } else {
            charSequence3 = null;
        }
        textView3.setText(charSequence3);
        RecyclerView recyclerView = (RecyclerView) c(R.id.H9);
        Intrinsics.e(recyclerView, "recyclerView");
        if (state.f() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        ViewExtKt.d(recyclerView, z11, 0, 2, null);
        DiffAdapter.V(this.f33683e, state.d(), null, 2, null);
        int i10 = R.id.f19838z2;
        RoundButton closeButton = (RoundButton) c(i10);
        Intrinsics.e(closeButton, "closeButton");
        ViewExtKt.d(closeButton, state.a(), 0, 2, null);
        ((RoundButton) c(i10)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkFifoQueueDelegate.g(WorkFifoQueueDelegate.this, view);
            }
        });
        View retryLayout = c(R.id.retryLayout);
        Intrinsics.e(retryLayout, "retryLayout");
        if (state.f() == null) {
            z12 = false;
        }
        ViewExtKt.d(retryLayout, z12, 0, 2, null);
        ((RoundButton) c(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkFifoQueueDelegate.h(WorkFifoQueueDelegate.this, view);
            }
        });
    }

    public View i() {
        return this.f33679a;
    }
}
