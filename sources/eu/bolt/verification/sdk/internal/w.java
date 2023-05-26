package eu.bolt.verification.sdk.internal;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* loaded from: classes5.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f45479a = new w();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f45480b = new AccelerateDecelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private static final Interpolator f45481c = new LinearOutSlowInInterpolator();

    /* renamed from: d  reason: collision with root package name */
    private static final Interpolator f45482d = new FastOutLinearInInterpolator();

    /* renamed from: e  reason: collision with root package name */
    private static final AccelerateInterpolator f45483e = new AccelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private static final DecelerateInterpolator f45484f = new DecelerateInterpolator();

    private w() {
    }

    public final Interpolator a() {
        return f45480b;
    }

    public final Interpolator b() {
        return f45482d;
    }
}
