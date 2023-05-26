package eu.bolt.verification.sdk.internal;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ra implements RequestListener<Drawable> {

    /* renamed from: f  reason: collision with root package name */
    private final v9 f44806f;

    public ra(v9 listener) {
        Intrinsics.f(listener, "listener");
        this.f44806f = listener;
    }

    @Override // com.bumptech.glide.request.RequestListener
    /* renamed from: a */
    public boolean j(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z7) {
        Unit unit;
        if (drawable != null) {
            this.f44806f.b(drawable);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f44806f.a(new NullPointerException("Load if finished but image is null"));
            return false;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean h(GlideException glideException, Object obj, Target<Drawable> target, boolean z7) {
        v9 v9Var = this.f44806f;
        Throwable th = glideException;
        if (glideException == null) {
            th = new UnknownError();
        }
        v9Var.a(th);
        return false;
    }
}
