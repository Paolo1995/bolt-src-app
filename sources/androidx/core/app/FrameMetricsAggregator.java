package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window$OnFrameMetricsAvailableListener;
import androidx.annotation.NonNull;
import j$.util.Spliterator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {

    /* renamed from: a  reason: collision with root package name */
    private final FrameMetricsBaseImpl f5561a;

    /* loaded from: classes.dex */
    private static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {

        /* renamed from: e  reason: collision with root package name */
        private static HandlerThread f5562e;

        /* renamed from: f  reason: collision with root package name */
        private static Handler f5563f;

        /* renamed from: a  reason: collision with root package name */
        int f5564a;

        /* renamed from: b  reason: collision with root package name */
        SparseIntArray[] f5565b = new SparseIntArray[9];

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<WeakReference<Activity>> f5566c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        Window$OnFrameMetricsAvailableListener f5567d = new Window$OnFrameMetricsAvailableListener() { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i8) {
                FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl.f5564a & 1) != 0) {
                    frameMetricsApi24Impl.c(frameMetricsApi24Impl.f5565b[0], frameMetrics.getMetric(8));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl2.f5564a & 2) != 0) {
                    frameMetricsApi24Impl2.c(frameMetricsApi24Impl2.f5565b[1], frameMetrics.getMetric(1));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl3.f5564a & 4) != 0) {
                    frameMetricsApi24Impl3.c(frameMetricsApi24Impl3.f5565b[2], frameMetrics.getMetric(3));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl4.f5564a & 8) != 0) {
                    frameMetricsApi24Impl4.c(frameMetricsApi24Impl4.f5565b[3], frameMetrics.getMetric(4));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl5.f5564a & 16) != 0) {
                    frameMetricsApi24Impl5.c(frameMetricsApi24Impl5.f5565b[4], frameMetrics.getMetric(5));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl6.f5564a & 64) != 0) {
                    frameMetricsApi24Impl6.c(frameMetricsApi24Impl6.f5565b[6], frameMetrics.getMetric(7));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl7.f5564a & 32) != 0) {
                    frameMetricsApi24Impl7.c(frameMetricsApi24Impl7.f5565b[5], frameMetrics.getMetric(6));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl8.f5564a & 128) != 0) {
                    frameMetricsApi24Impl8.c(frameMetricsApi24Impl8.f5565b[7], frameMetrics.getMetric(0));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl9.f5564a & Spliterator.NONNULL) != 0) {
                    frameMetricsApi24Impl9.c(frameMetricsApi24Impl9.f5565b[8], frameMetrics.getMetric(2));
                }
            }
        };

        FrameMetricsApi24Impl(int i8) {
            this.f5564a = i8;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void a(Activity activity) {
            if (f5562e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f5562e = handlerThread;
                handlerThread.start();
                f5563f = new Handler(f5562e.getLooper());
            }
            for (int i8 = 0; i8 <= 8; i8++) {
                SparseIntArray[] sparseIntArrayArr = this.f5565b;
                if (sparseIntArrayArr[i8] == null && (this.f5564a & (1 << i8)) != 0) {
                    sparseIntArrayArr[i8] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f5567d, f5563f);
            this.f5566c.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] b(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f5566c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.f5566c.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f5567d);
            return this.f5565b;
        }

        void c(SparseIntArray sparseIntArray, long j8) {
            if (sparseIntArray != null) {
                int i8 = (int) ((500000 + j8) / 1000000);
                if (j8 >= 0) {
                    sparseIntArray.put(i8, sparseIntArray.get(i8) + 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b(Activity activity) {
            return null;
        }
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void a(@NonNull Activity activity) {
        this.f5561a.a(activity);
    }

    public SparseIntArray[] b(@NonNull Activity activity) {
        return this.f5561a.b(activity);
    }

    public FrameMetricsAggregator(int i8) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f5561a = new FrameMetricsApi24Impl(i8);
        } else {
            this.f5561a = new FrameMetricsBaseImpl();
        }
    }
}
