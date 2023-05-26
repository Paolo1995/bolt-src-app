package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AnimationHandler {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<AnimationHandler> f6244g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    private AnimationFrameCallbackProvider f6248d;

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap<AnimationFrameCallback, Long> f6245a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<AnimationFrameCallback> f6246b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final AnimationCallbackDispatcher f6247c = new AnimationCallbackDispatcher();

    /* renamed from: e  reason: collision with root package name */
    long f6249e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6250f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AnimationCallbackDispatcher {
        AnimationCallbackDispatcher() {
        }

        void a() {
            AnimationHandler.this.f6249e = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.c(animationHandler.f6249e);
            if (AnimationHandler.this.f6246b.size() > 0) {
                AnimationHandler.this.e().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface AnimationFrameCallback {
        boolean a(long j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class AnimationFrameCallbackProvider {

        /* renamed from: a  reason: collision with root package name */
        final AnimationCallbackDispatcher f6252a;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f6252a = animationCallbackDispatcher;
        }

        abstract void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f6253b;

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f6254c;

        FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.f6253b = Choreographer.getInstance();
            this.f6254c = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j8) {
                    FrameCallbackProvider16.this.f6252a.a();
                }
            };
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void a() {
            this.f6253b.postFrameCallback(this.f6254c);
        }
    }

    AnimationHandler() {
    }

    private void b() {
        if (this.f6250f) {
            for (int size = this.f6246b.size() - 1; size >= 0; size--) {
                if (this.f6246b.get(size) == null) {
                    this.f6246b.remove(size);
                }
            }
            this.f6250f = false;
        }
    }

    public static AnimationHandler d() {
        ThreadLocal<AnimationHandler> threadLocal = f6244g;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return threadLocal.get();
    }

    private boolean f(AnimationFrameCallback animationFrameCallback, long j8) {
        Long l8 = this.f6245a.get(animationFrameCallback);
        if (l8 == null) {
            return true;
        }
        if (l8.longValue() < j8) {
            this.f6245a.remove(animationFrameCallback);
            return true;
        }
        return false;
    }

    public void a(AnimationFrameCallback animationFrameCallback, long j8) {
        if (this.f6246b.size() == 0) {
            e().a();
        }
        if (!this.f6246b.contains(animationFrameCallback)) {
            this.f6246b.add(animationFrameCallback);
        }
        if (j8 > 0) {
            this.f6245a.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j8));
        }
    }

    void c(long j8) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i8 = 0; i8 < this.f6246b.size(); i8++) {
            AnimationFrameCallback animationFrameCallback = this.f6246b.get(i8);
            if (animationFrameCallback != null && f(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.a(j8);
            }
        }
        b();
    }

    AnimationFrameCallbackProvider e() {
        if (this.f6248d == null) {
            this.f6248d = new FrameCallbackProvider16(this.f6247c);
        }
        return this.f6248d;
    }

    public void g(AnimationFrameCallback animationFrameCallback) {
        this.f6245a.remove(animationFrameCallback);
        int indexOf = this.f6246b.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.f6246b.set(indexOf, null);
            this.f6250f = true;
        }
    }
}
