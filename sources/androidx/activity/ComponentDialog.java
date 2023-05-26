package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComponentDialog.kt */
/* loaded from: classes.dex */
public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner {

    /* renamed from: f  reason: collision with root package name */
    private LifecycleRegistry f751f;

    /* renamed from: g  reason: collision with root package name */
    private final OnBackPressedDispatcher f752g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context, int i8) {
        super(context, i8);
        Intrinsics.f(context, "context");
        this.f752g = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                ComponentDialog.d(ComponentDialog.this);
            }
        });
    }

    private final LifecycleRegistry b() {
        LifecycleRegistry lifecycleRegistry = this.f751f;
        if (lifecycleRegistry == null) {
            LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
            this.f751f = lifecycleRegistry2;
            return lifecycleRegistry2;
        }
        return lifecycleRegistry;
    }

    private final void c() {
        Window window = getWindow();
        Intrinsics.c(window);
        ViewTreeLifecycleOwner.a(window.getDecorView(), this);
        Window window2 = getWindow();
        Intrinsics.c(window2);
        View decorView = window2.getDecorView();
        Intrinsics.e(decorView, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.a(decorView, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ComponentDialog this$0) {
        Intrinsics.f(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.f(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return b();
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f752g;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f752g.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            this.f752g.g(getOnBackInvokedDispatcher());
        }
        b().h(Lifecycle.Event.ON_CREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b().h(Lifecycle.Event.ON_RESUME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onStop() {
        b().h(Lifecycle.Event.ON_DESTROY);
        this.f751f = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i8) {
        c();
        super.setContentView(i8);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Intrinsics.f(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.f(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
