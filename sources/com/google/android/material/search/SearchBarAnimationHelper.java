package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
class SearchBarAnimationHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Object> f13930a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<AnimatorListenerAdapter> f13931b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<AnimatorListenerAdapter> f13932c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    private boolean f13933d = true;

    /* renamed from: e  reason: collision with root package name */
    private Animator f13934e = null;

    SearchBarAnimationHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z7) {
        this.f13933d = z7;
    }
}
