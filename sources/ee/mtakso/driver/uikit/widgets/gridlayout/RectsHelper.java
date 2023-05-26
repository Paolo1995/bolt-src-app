package ee.mtakso.driver.uikit.widgets.gridlayout;

import android.graphics.Rect;
import com.google.android.gms.common.api.Api;
import ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannedGridLayoutManager.kt */
/* loaded from: classes5.dex */
public class RectsHelper {

    /* renamed from: a  reason: collision with root package name */
    private final SpannedGridLayoutManager f36231a;

    /* renamed from: b  reason: collision with root package name */
    private final SpannedGridLayoutManager.Orientation f36232b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f36233c;

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<Rect> f36234d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f36235e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, Rect> f36236f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Rect> f36237g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f36238h;

    /* compiled from: SpannedGridLayoutManager.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36239a;

        static {
            int[] iArr = new int[SpannedGridLayoutManager.Orientation.values().length];
            try {
                iArr[SpannedGridLayoutManager.Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpannedGridLayoutManager.Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f36239a = iArr;
        }
    }

    public RectsHelper(SpannedGridLayoutManager layoutManager, SpannedGridLayoutManager.Orientation orientation, Integer num) {
        Rect rect;
        Intrinsics.f(layoutManager, "layoutManager");
        Intrinsics.f(orientation, "orientation");
        this.f36231a = layoutManager;
        this.f36232b = orientation;
        this.f36233c = num;
        this.f36234d = new Comparator() { // from class: ee.mtakso.driver.uikit.widgets.gridlayout.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k8;
                k8 = RectsHelper.k(RectsHelper.this, (Rect) obj, (Rect) obj2);
                return k8;
            }
        };
        this.f36235e = new LinkedHashMap();
        this.f36236f = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        this.f36237g = arrayList;
        if (orientation == SpannedGridLayoutManager.Orientation.VERTICAL) {
            rect = new Rect(0, 0, layoutManager.q2(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            rect = new Rect(0, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER, layoutManager.q2());
        }
        this.f36238h = rect;
        arrayList.add(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(RectsHelper this$0, Rect rect, Rect rect2) {
        Intrinsics.f(this$0, "this$0");
        int i8 = WhenMappings.f36239a[this$0.f36232b.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                int i9 = rect.left;
                int i10 = rect2.left;
                if (i9 == i10) {
                    if (rect.top < rect2.top) {
                        return -1;
                    }
                } else if (i9 < i10) {
                    return -1;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            int i11 = rect.top;
            int i12 = rect2.top;
            if (i11 == i12) {
                if (rect.left < rect2.left) {
                    return -1;
                }
            } else if (i11 < i12) {
                return -1;
            }
        }
        return 1;
    }

    public final void b() {
        this.f36236f.clear();
        this.f36237g.clear();
        this.f36237g.add(this.f36238h);
    }

    public final Set<Integer> c(int i8) {
        Set<Integer> b8;
        Set<Integer> set = this.f36235e.get(Integer.valueOf(i8));
        if (set == null) {
            b8 = SetsKt__SetsKt.b();
            return b8;
        }
        return set;
    }

    public final Rect d(int i8, SpanSize spanSize) {
        Intrinsics.f(spanSize, "spanSize");
        Rect rect = this.f36236f.get(Integer.valueOf(i8));
        if (rect == null) {
            return e(spanSize);
        }
        return rect;
    }

    protected Rect e(SpanSize spanSize) {
        Intrinsics.f(spanSize, "spanSize");
        for (Rect rect : this.f36237g) {
            int i8 = rect.left;
            if (rect.contains(new Rect(i8, rect.top, spanSize.b() + i8, rect.top + spanSize.a()))) {
                int i9 = rect.left;
                return new Rect(i9, rect.top, spanSize.b() + i9, rect.top + spanSize.a());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final int f() {
        Integer num = this.f36233c;
        if (num != null) {
            return num.intValue();
        }
        return g();
    }

    public final int g() {
        return i() / this.f36231a.q2();
    }

    public final Map<Integer, Set<Integer>> h() {
        return this.f36235e;
    }

    public final int i() {
        int h02;
        int paddingBottom;
        if (this.f36232b == SpannedGridLayoutManager.Orientation.VERTICAL) {
            h02 = this.f36231a.v0() - this.f36231a.getPaddingLeft();
            paddingBottom = this.f36231a.getPaddingRight();
        } else {
            h02 = this.f36231a.h0() - this.f36231a.getPaddingTop();
            paddingBottom = this.f36231a.getPaddingBottom();
        }
        return h02 - paddingBottom;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.K0(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.K0(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(int r5, android.graphics.Rect r6) {
        /*
            r4 = this;
            java.lang.String r0 = "rect"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager$Orientation r0 = r4.f36232b
            ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager$Orientation r1 = ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager.Orientation.VERTICAL
            if (r0 != r1) goto Le
            int r0 = r6.top
            goto L10
        Le:
            int r0 = r6.left
        L10:
            java.util.Map<java.lang.Integer, java.util.Set<java.lang.Integer>> r2 = r4.f36235e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.Object r2 = r2.get(r3)
            java.util.Set r2 = (java.util.Set) r2
            if (r2 == 0) goto L24
            java.util.Set r2 = kotlin.collections.CollectionsKt.K0(r2)
            if (r2 != 0) goto L29
        L24:
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
        L29:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r2.add(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.util.Map<java.lang.Integer, java.util.Set<java.lang.Integer>> r3 = r4.f36235e
            r3.put(r0, r2)
            ee.mtakso.driver.uikit.widgets.gridlayout.SpannedGridLayoutManager$Orientation r0 = r4.f36232b
            if (r0 != r1) goto L40
            int r0 = r6.bottom
            goto L42
        L40:
            int r0 = r6.right
        L42:
            java.util.Map<java.lang.Integer, java.util.Set<java.lang.Integer>> r1 = r4.f36235e
            int r0 = r0 + (-1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r1.get(r2)
            java.util.Set r1 = (java.util.Set) r1
            if (r1 == 0) goto L58
            java.util.Set r1 = kotlin.collections.CollectionsKt.K0(r1)
            if (r1 != 0) goto L5d
        L58:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
        L5d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r1.add(r2)
            java.util.Map<java.lang.Integer, java.util.Set<java.lang.Integer>> r2 = r4.f36235e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r0, r1)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.util.Map<java.lang.Integer, android.graphics.Rect> r0 = r4.f36236f
            r0.put(r5, r6)
            r4.l(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uikit.widgets.gridlayout.RectsHelper.j(int, android.graphics.Rect):void");
    }

    protected void l(Rect subtractedRect) {
        Object obj;
        Object obj2;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Intrinsics.f(subtractedRect, "subtractedRect");
        List<Rect> list = this.f36237g;
        ArrayList<Rect> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Rect rect = (Rect) next;
            if ((SpannedGridLayoutManagerKt.b(rect, subtractedRect) || SpannedGridLayoutManagerKt.a(rect, subtractedRect)) ? true : true) {
                arrayList.add(next);
            }
        }
        ArrayList<Rect> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Rect rect2 : arrayList) {
            if (SpannedGridLayoutManagerKt.b(rect2, subtractedRect) && !subtractedRect.contains(rect2)) {
                arrayList3.add(rect2);
            } else {
                this.f36237g.remove(rect2);
                if (rect2.left < subtractedRect.left) {
                    arrayList2.add(new Rect(rect2.left, rect2.top, subtractedRect.left, rect2.bottom));
                }
                if (rect2.right > subtractedRect.right) {
                    arrayList2.add(new Rect(subtractedRect.right, rect2.top, rect2.right, rect2.bottom));
                }
                if (rect2.top < subtractedRect.top) {
                    arrayList2.add(new Rect(rect2.left, rect2.top, rect2.right, subtractedRect.top));
                }
                if (rect2.bottom > subtractedRect.bottom) {
                    arrayList2.add(new Rect(rect2.left, subtractedRect.bottom, rect2.right, rect2.bottom));
                }
            }
        }
        for (Rect rect3 : arrayList2) {
            Iterator it2 = arrayList3.iterator();
            while (true) {
                obj = null;
                if (it2.hasNext()) {
                    obj2 = it2.next();
                    Rect rect4 = (Rect) obj2;
                    if (!Intrinsics.a(rect4, rect3) && rect4.contains(rect3)) {
                        z10 = true;
                        continue;
                    } else {
                        z10 = false;
                        continue;
                    }
                    if (z10) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            if (obj2 != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next2 = it3.next();
                    Rect rect5 = (Rect) next2;
                    if (!Intrinsics.a(rect5, rect3) && rect5.contains(rect3)) {
                        z9 = true;
                        continue;
                    } else {
                        z9 = false;
                        continue;
                    }
                    if (z9) {
                        obj = next2;
                        break;
                    }
                }
                if (obj != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (!z8) {
                    this.f36237g.add(rect3);
                }
            }
        }
        CollectionsKt__MutableCollectionsJVMKt.z(this.f36237g, this.f36234d);
    }
}
