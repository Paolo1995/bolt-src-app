package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewTreeOnBackPressedDispatcherOwner.kt */
/* loaded from: classes.dex */
public final class ViewTreeOnBackPressedDispatcherOwner {
    public static final void a(View view, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R$id.f770a, onBackPressedDispatcherOwner);
    }
}
