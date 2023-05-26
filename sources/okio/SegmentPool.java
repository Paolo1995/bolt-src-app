package okio;

import androidx.camera.view.e;
import androidx.fragment.app.FragmentTransaction;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SegmentPool.kt */
/* loaded from: classes5.dex */
public final class SegmentPool {

    /* renamed from: a  reason: collision with root package name */
    public static final SegmentPool f52638a = new SegmentPool();

    /* renamed from: b  reason: collision with root package name */
    private static final int f52639b = 65536;

    /* renamed from: c  reason: collision with root package name */
    private static final Segment f52640c = new Segment(new byte[0], 0, 0, false, false);

    /* renamed from: d  reason: collision with root package name */
    private static final int f52641d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReference<Segment>[] f52642e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f52641d = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i8 = 0; i8 < highestOneBit; i8++) {
            atomicReferenceArr[i8] = new AtomicReference<>();
        }
        f52642e = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> a() {
        return f52642e[(int) (Thread.currentThread().getId() & (f52641d - 1))];
    }

    public static final void b(Segment segment) {
        boolean z7;
        AtomicReference<Segment> a8;
        Segment segment2;
        int i8;
        Intrinsics.f(segment, "segment");
        if (segment.f52636f == null && segment.f52637g == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (segment.f52634d || (segment2 = (a8 = f52638a.a()).get()) == f52640c) {
                return;
            }
            if (segment2 == null) {
                i8 = 0;
            } else {
                i8 = segment2.f52633c;
            }
            if (i8 >= f52639b) {
                return;
            }
            segment.f52636f = segment2;
            segment.f52632b = 0;
            segment.f52633c = i8 + FragmentTransaction.TRANSIT_EXIT_MASK;
            if (!e.a(a8, segment2, segment)) {
                segment.f52636f = null;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final Segment c() {
        AtomicReference<Segment> a8 = f52638a.a();
        Segment segment = f52640c;
        Segment andSet = a8.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            a8.set(null);
            return new Segment();
        }
        a8.set(andSet.f52636f);
        andSet.f52636f = null;
        andSet.f52633c = 0;
        return andSet;
    }
}
