package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions T = new RequestOptions().h(DiskCacheStrategy.f10071c).c0(Priority.LOW).k0(true);
    private final Context F;
    private final RequestManager G;
    private final Class<TranscodeType> H;
    private final Glide I;
    private final GlideContext J;
    @NonNull
    private TransitionOptions<?, ? super TranscodeType> K;
    private Object L;
    private List<RequestListener<TranscodeType>> M;
    private RequestBuilder<TranscodeType> N;
    private RequestBuilder<TranscodeType> O;
    private Float P;
    private boolean Q = true;
    private boolean R;
    private boolean S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.RequestBuilder$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9790a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9791b;

        static {
            int[] iArr = new int[Priority.values().length];
            f9791b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9791b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9791b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9791b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f9790a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9790a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9790a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9790a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9790a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9790a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9790a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9790a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public RequestBuilder(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.I = glide;
        this.G = requestManager;
        this.H = cls;
        this.F = context;
        this.K = requestManager.q(cls);
        this.J = glide.i();
        x0(requestManager.o());
        a(requestManager.p());
    }

    private boolean C0(BaseRequestOptions<?> baseRequestOptions, Request request) {
        if (!baseRequestOptions.J() && request.h()) {
            return true;
        }
        return false;
    }

    @NonNull
    private RequestBuilder<TranscodeType> H0(Object obj) {
        if (H()) {
            return e().H0(obj);
        }
        this.L = obj;
        this.R = true;
        return g0();
    }

    private Request I0(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i8, int i9, Executor executor) {
        Context context = this.F;
        GlideContext glideContext = this.J;
        return SingleRequest.y(context, glideContext, obj, this.L, this.H, baseRequestOptions, i8, i9, priority, target, requestListener, this.M, requestCoordinator, glideContext.f(), transitionOptions.b(), executor);
    }

    private Request s0(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        return t0(new Object(), target, requestListener, null, this.K, baseRequestOptions.x(), baseRequestOptions.t(), baseRequestOptions.s(), baseRequestOptions, executor);
    }

    private Request t0(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i8, int i9, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        ErrorRequestCoordinator errorRequestCoordinator2;
        if (this.O != null) {
            errorRequestCoordinator2 = new ErrorRequestCoordinator(obj, requestCoordinator);
            errorRequestCoordinator = errorRequestCoordinator2;
        } else {
            errorRequestCoordinator = null;
            errorRequestCoordinator2 = requestCoordinator;
        }
        Request u02 = u0(obj, target, requestListener, errorRequestCoordinator2, transitionOptions, priority, i8, i9, baseRequestOptions, executor);
        if (errorRequestCoordinator == null) {
            return u02;
        }
        int t7 = this.O.t();
        int s7 = this.O.s();
        if (Util.t(i8, i9) && !this.O.R()) {
            t7 = baseRequestOptions.t();
            s7 = baseRequestOptions.s();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.O;
        ErrorRequestCoordinator errorRequestCoordinator3 = errorRequestCoordinator;
        errorRequestCoordinator3.p(u02, requestBuilder.t0(obj, target, requestListener, errorRequestCoordinator3, requestBuilder.K, requestBuilder.x(), t7, s7, this.O, executor));
        return errorRequestCoordinator3;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.BaseRequestOptions] */
    private Request u0(Object obj, Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i8, int i9, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        TransitionOptions<?, ? super TranscodeType> transitionOptions2;
        Priority w02;
        RequestBuilder<TranscodeType> requestBuilder = this.N;
        if (requestBuilder != null) {
            if (!this.S) {
                TransitionOptions<?, ? super TranscodeType> transitionOptions3 = requestBuilder.K;
                if (requestBuilder.Q) {
                    transitionOptions2 = transitionOptions;
                } else {
                    transitionOptions2 = transitionOptions3;
                }
                if (requestBuilder.K()) {
                    w02 = this.N.x();
                } else {
                    w02 = w0(priority);
                }
                Priority priority2 = w02;
                int t7 = this.N.t();
                int s7 = this.N.s();
                if (Util.t(i8, i9) && !this.N.R()) {
                    t7 = baseRequestOptions.t();
                    s7 = baseRequestOptions.s();
                }
                ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, requestCoordinator);
                Request I0 = I0(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i8, i9, executor);
                this.S = true;
                RequestBuilder<TranscodeType> requestBuilder2 = this.N;
                Request t02 = requestBuilder2.t0(obj, target, requestListener, thumbnailRequestCoordinator, transitionOptions2, priority2, t7, s7, requestBuilder2, executor);
                this.S = false;
                thumbnailRequestCoordinator.o(I0, t02);
                return thumbnailRequestCoordinator;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.P != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(obj, requestCoordinator);
            thumbnailRequestCoordinator2.o(I0(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i8, i9, executor), I0(obj, target, requestListener, baseRequestOptions.clone().j0(this.P.floatValue()), thumbnailRequestCoordinator2, transitionOptions, w0(priority), i8, i9, executor));
            return thumbnailRequestCoordinator2;
        } else {
            return I0(obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i8, i9, executor);
        }
    }

    @NonNull
    private Priority w0(@NonNull Priority priority) {
        int i8 = AnonymousClass1.f9791b[priority.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3 && i8 != 4) {
                    throw new IllegalArgumentException("unknown priority: " + x());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    @SuppressLint({"CheckResult"})
    private void x0(List<RequestListener<Object>> list) {
        for (RequestListener<Object> requestListener : list) {
            q0(requestListener);
        }
    }

    private <Y extends Target<TranscodeType>> Y z0(@NonNull Y y7, RequestListener<TranscodeType> requestListener, BaseRequestOptions<?> baseRequestOptions, Executor executor) {
        Preconditions.d(y7);
        if (this.R) {
            Request s02 = s0(y7, requestListener, baseRequestOptions, executor);
            Request c8 = y7.c();
            if (s02.i(c8) && !C0(baseRequestOptions, c8)) {
                if (!((Request) Preconditions.d(c8)).isRunning()) {
                    c8.j();
                }
                return y7;
            }
            this.G.n(y7);
            y7.g(s02);
            this.G.y(y7, s02);
            return y7;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @NonNull
    <Y extends Target<TranscodeType>> Y A0(@NonNull Y y7, RequestListener<TranscodeType> requestListener, Executor executor) {
        return (Y) z0(y7, requestListener, this, executor);
    }

    @NonNull
    public ViewTarget<ImageView, TranscodeType> B0(@NonNull ImageView imageView) {
        RequestBuilder<TranscodeType> requestBuilder;
        Util.b();
        Preconditions.d(imageView);
        if (!Q() && O() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f9790a[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestBuilder = clone().T();
                    break;
                case 2:
                    requestBuilder = clone().U();
                    break;
                case 3:
                case 4:
                case 5:
                    requestBuilder = clone().V();
                    break;
                case 6:
                    requestBuilder = clone().U();
                    break;
            }
            return (ViewTarget) z0(this.J.a(imageView, this.H), null, requestBuilder, Executors.b());
        }
        requestBuilder = this;
        return (ViewTarget) z0(this.J.a(imageView, this.H), null, requestBuilder, Executors.b());
    }

    @NonNull
    public RequestBuilder<TranscodeType> D0(RequestListener<TranscodeType> requestListener) {
        if (H()) {
            return e().D0(requestListener);
        }
        this.M = null;
        return q0(requestListener);
    }

    @NonNull
    public RequestBuilder<TranscodeType> E0(Integer num) {
        return H0(num).a(RequestOptions.s0(AndroidResourceSignature.c(this.F)));
    }

    @NonNull
    public RequestBuilder<TranscodeType> F0(Object obj) {
        return H0(obj);
    }

    @NonNull
    public RequestBuilder<TranscodeType> G0(String str) {
        return H0(str);
    }

    @NonNull
    public Target<TranscodeType> J0() {
        return K0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public Target<TranscodeType> K0(int i8, int i9) {
        return y0(PreloadTarget.h(this.G, i8, i9));
    }

    @NonNull
    public FutureTarget<TranscodeType> L0() {
        return M0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public FutureTarget<TranscodeType> M0(int i8, int i9) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i8, i9);
        return (FutureTarget) A0(requestFutureTarget, requestFutureTarget, Executors.a());
    }

    @NonNull
    public RequestBuilder<TranscodeType> q0(RequestListener<TranscodeType> requestListener) {
        if (H()) {
            return e().q0(requestListener);
        }
        if (requestListener != null) {
            if (this.M == null) {
                this.M = new ArrayList();
            }
            this.M.add(requestListener);
        }
        return g0();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* renamed from: r0 */
    public RequestBuilder<TranscodeType> a(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        Preconditions.d(baseRequestOptions);
        return (RequestBuilder) super.a(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* renamed from: v0 */
    public RequestBuilder<TranscodeType> e() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.K = (TransitionOptions<?, ? super TranscodeType>) requestBuilder.K.clone();
        if (requestBuilder.M != null) {
            requestBuilder.M = new ArrayList(requestBuilder.M);
        }
        RequestBuilder<TranscodeType> requestBuilder2 = requestBuilder.N;
        if (requestBuilder2 != null) {
            requestBuilder.N = requestBuilder2.e();
        }
        RequestBuilder<TranscodeType> requestBuilder3 = requestBuilder.O;
        if (requestBuilder3 != null) {
            requestBuilder.O = requestBuilder3.e();
        }
        return requestBuilder;
    }

    @NonNull
    public <Y extends Target<TranscodeType>> Y y0(@NonNull Y y7) {
        return (Y) A0(y7, null, Executors.b());
    }
}
