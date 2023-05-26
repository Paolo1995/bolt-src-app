package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GestureDetectorCompat;
import eu.bolt.client.design.button.a;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$id;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ak implements c1 {

    /* renamed from: g  reason: collision with root package name */
    public static final a f42086g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final zj f42087a;

    /* renamed from: b  reason: collision with root package name */
    private eu.bolt.client.design.button.a f42088b;

    /* renamed from: c  reason: collision with root package name */
    private ri f42089c;

    /* renamed from: d  reason: collision with root package name */
    private sj f42090d;

    /* renamed from: e  reason: collision with root package name */
    private ConstraintLayout f42091e;

    /* renamed from: f  reason: collision with root package name */
    private GestureDetectorCompat f42092f;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends qa {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ eu.bolt.client.design.button.a f42093f;

        b(eu.bolt.client.design.button.a aVar) {
            this.f42093f = aVar;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e8) {
            Intrinsics.f(e8, "e");
            this.f42093f.performClick();
            return true;
        }
    }

    public ak(zj listener) {
        Intrinsics.f(listener, "listener");
        this.f42087a = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ak this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        sj sjVar = this$0.f42090d;
        if (sjVar != null) {
            this$0.f42087a.b(sjVar, this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(ak this$0, View view, MotionEvent motionEvent) {
        Intrinsics.f(this$0, "this$0");
        view.getParent().requestDisallowInterceptTouchEvent(true);
        GestureDetectorCompat gestureDetectorCompat = this$0.f42092f;
        if (gestureDetectorCompat != null) {
            gestureDetectorCompat.a(motionEvent);
        }
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void i(sj sjVar) {
        ConstraintLayout constraintLayout = this.f42091e;
        if (sjVar.d() == null || constraintLayout == null) {
            c();
            this.f42088b = null;
            this.f42089c = null;
            return;
        }
        ri d8 = sjVar.d().d();
        if (Intrinsics.a(this.f42089c, d8)) {
            return;
        }
        this.f42089c = d8;
        eu.bolt.client.design.button.a aVar = this.f42088b;
        if (aVar != null) {
            constraintLayout.removeView(aVar);
        }
        a.C0024a c0024a = eu.bolt.client.design.button.a.f39995x;
        Context context = constraintLayout.getContext();
        Intrinsics.e(context, "storySlideView.context");
        eu.bolt.client.design.button.a a8 = c0024a.a(context, d8.a());
        this.f42092f = new GestureDetectorCompat(a8.getContext(), new b(a8));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        Context context2 = a8.getContext();
        Intrinsics.e(context2, "this.context");
        int i8 = R$dimen.f41699b;
        int n8 = f2.n(context2, i8);
        Context context3 = a8.getContext();
        Intrinsics.e(context3, "this.context");
        int i9 = R$dimen.f41700i;
        int n9 = f2.n(context3, i9);
        Context context4 = a8.getContext();
        Intrinsics.e(context4, "this.context");
        int n10 = f2.n(context4, i8);
        Context context5 = a8.getContext();
        Intrinsics.e(context5, "this.context");
        marginLayoutParams.setMargins(n8, n9, n10, f2.n(context5, i9));
        a8.setLayoutParams(marginLayoutParams);
        a8.setId(R$id.T0);
        a8.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ak.g(ak.this, view);
            }
        });
        a8.setOnTouchListener(new View.OnTouchListener() { // from class: eu.bolt.verification.sdk.internal.ca
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean h8;
                h8 = ak.h(ak.this, view, motionEvent);
                return h8;
            }
        });
        constraintLayout.addView(a8);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.g(constraintLayout);
        Context context6 = constraintLayout.getContext();
        Intrinsics.e(context6, "storySlideView.context");
        int a9 = f2.a(context6, 24.0f);
        constraintSet.j(a8.getId(), 4, 0, 4, a9);
        constraintSet.j(a8.getId(), 6, 0, 6, a9);
        constraintSet.j(a8.getId(), 7, 0, 7, a9);
        constraintSet.c(constraintLayout);
        this.f42088b = a8;
    }

    @Override // eu.bolt.verification.sdk.internal.jf
    public void a() {
        eu.bolt.client.design.button.a aVar = this.f42088b;
        if (aVar != null) {
            eu.bolt.client.design.button.a.v(aVar, true, false, 2, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.jf
    public void b() {
        eu.bolt.client.design.button.a aVar = this.f42088b;
        if (aVar != null) {
            eu.bolt.client.design.button.a.v(aVar, false, false, 2, null);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void c() {
        b();
        eu.bolt.client.design.button.a aVar = this.f42088b;
        if (aVar == null) {
            return;
        }
        uq.C(aVar, false);
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void c(sj slide) {
        Intrinsics.f(slide, "slide");
        this.f42090d = slide;
        b();
        yj d8 = slide.d();
        if (d8 == null) {
            c();
            return;
        }
        i(slide);
        eu.bolt.client.design.button.a aVar = this.f42088b;
        if (aVar != null) {
            uq.C(aVar, qk.b(d8.e()));
        }
        eu.bolt.client.design.button.a aVar2 = this.f42088b;
        if (aVar2 == null) {
            return;
        }
        aVar2.setText(d8.e());
    }

    @Override // eu.bolt.verification.sdk.internal.c1
    public void d(sj slide, ConstraintLayout view) {
        Intrinsics.f(slide, "slide");
        Intrinsics.f(view, "view");
        this.f42091e = view;
        i(slide);
    }
}
