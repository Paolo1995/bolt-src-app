package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface VisibilityAnimatorProvider {
    Animator a(@NonNull ViewGroup viewGroup, @NonNull View view);

    Animator b(@NonNull ViewGroup viewGroup, @NonNull View view);
}
