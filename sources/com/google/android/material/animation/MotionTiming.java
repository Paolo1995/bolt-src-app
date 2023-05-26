package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class MotionTiming {

    /* renamed from: a  reason: collision with root package name */
    private long f12735a;

    /* renamed from: b  reason: collision with root package name */
    private long f12736b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f12737c;

    /* renamed from: d  reason: collision with root package name */
    private int f12738d;

    /* renamed from: e  reason: collision with root package name */
    private int f12739e;

    public MotionTiming(long j8, long j9) {
        this.f12737c = null;
        this.f12738d = 0;
        this.f12739e = 1;
        this.f12735a = j8;
        this.f12736b = j9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static MotionTiming b(@NonNull ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        motionTiming.f12738d = valueAnimator.getRepeatCount();
        motionTiming.f12739e = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return AnimationUtils.f12722c;
            }
            if (interpolator instanceof DecelerateInterpolator) {
                return AnimationUtils.f12723d;
            }
            return interpolator;
        }
        return AnimationUtils.f12721b;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f12735a;
    }

    public long d() {
        return this.f12736b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f12737c;
        if (timeInterpolator == null) {
            return AnimationUtils.f12721b;
        }
        return timeInterpolator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (c() != motionTiming.c() || d() != motionTiming.d() || g() != motionTiming.g() || h() != motionTiming.h()) {
            return false;
        }
        return e().getClass().equals(motionTiming.e().getClass());
    }

    public int g() {
        return this.f12738d;
    }

    public int h() {
        return this.f12739e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public MotionTiming(long j8, long j9, @NonNull TimeInterpolator timeInterpolator) {
        this.f12738d = 0;
        this.f12739e = 1;
        this.f12735a = j8;
        this.f12736b = j9;
        this.f12737c = timeInterpolator;
    }
}
