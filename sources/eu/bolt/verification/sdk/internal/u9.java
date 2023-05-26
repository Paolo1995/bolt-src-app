package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class u9 {
    @SuppressLint({"CheckResult"})
    private static final RequestBuilder<Drawable> a(Context context, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, v9 v9Var, boolean z7, boolean z8) {
        if (f2.h(context)) {
            Cloneable k02 = Glide.t(context).s(str).h(DiskCacheStrategy.f10070b).k0(z8);
            Intrinsics.e(k02, "with(context)\n        .l…oryCache(skipMemoryCache)");
            RequestBuilder<Drawable> requestBuilder = (RequestBuilder) k02;
            if (num != null) {
                requestBuilder.a0(num.intValue());
            }
            if (num2 != null) {
                requestBuilder.j(num2.intValue());
            }
            if (v9Var != null) {
                requestBuilder.D0(new ra(v9Var));
            }
            if (num3 != null) {
                requestBuilder.Y(context.getResources().getDimensionPixelSize(num3.intValue()));
            } else if (num4 == null || num5 == null) {
                requestBuilder.Z(Integer.MIN_VALUE, Integer.MIN_VALUE);
            } else {
                requestBuilder.Z(num4.intValue(), num5.intValue());
            }
            if (z7) {
                requestBuilder.d();
            }
            return requestBuilder;
        }
        return null;
    }

    public static final void b(Context context, String str, v9 v9Var) {
        Intrinsics.f(context, "<this>");
        if (f2.h(context)) {
            Glide.t(context).s(str).q0(v9Var != null ? new ra(v9Var) : null).J0();
        }
    }

    public static final void c(ImageView imageView) {
        Intrinsics.f(imageView, "<this>");
        if (imageView.isInEditMode()) {
            return;
        }
        Context context = imageView.getContext();
        Intrinsics.e(context, "context");
        if (f2.h(context)) {
            Glide.t(imageView.getContext()).m(imageView);
        }
    }

    public static final void d(ImageView imageView, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, v9 v9Var, boolean z7, boolean z8) {
        Intrinsics.f(imageView, "<this>");
        if (str2 == null || !Intrinsics.a(imageView.getTag(), str2)) {
            imageView.setTag(str2);
            Context context = imageView.getContext();
            Intrinsics.e(context, "this.context");
            RequestBuilder<Drawable> a8 = a(context, str, num, num2, num3, num6, num7, v9Var, z7, !z8);
            if (a8 != null) {
                u8 u8Var = (u8) a8.y0(new u8(imageView, num4, num5));
            }
        }
    }
}
