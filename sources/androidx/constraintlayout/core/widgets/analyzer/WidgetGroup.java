package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class WidgetGroup {

    /* renamed from: g  reason: collision with root package name */
    static int f4738g;

    /* renamed from: b  reason: collision with root package name */
    int f4740b;

    /* renamed from: d  reason: collision with root package name */
    int f4742d;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ConstraintWidget> f4739a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    boolean f4741c = false;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<MeasureResult> f4743e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f4744f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MeasureResult {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<ConstraintWidget> f4745a;

        /* renamed from: b  reason: collision with root package name */
        int f4746b;

        /* renamed from: c  reason: collision with root package name */
        int f4747c;

        /* renamed from: d  reason: collision with root package name */
        int f4748d;

        /* renamed from: e  reason: collision with root package name */
        int f4749e;

        /* renamed from: f  reason: collision with root package name */
        int f4750f;

        /* renamed from: g  reason: collision with root package name */
        int f4751g;

        public MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i8) {
            this.f4745a = new WeakReference<>(constraintWidget);
            this.f4746b = linearSystem.x(constraintWidget.O);
            this.f4747c = linearSystem.x(constraintWidget.P);
            this.f4748d = linearSystem.x(constraintWidget.Q);
            this.f4749e = linearSystem.x(constraintWidget.R);
            this.f4750f = linearSystem.x(constraintWidget.S);
            this.f4751g = i8;
        }
    }

    public WidgetGroup(int i8) {
        int i9 = f4738g;
        f4738g = i9 + 1;
        this.f4740b = i9;
        this.f4742d = i8;
    }

    private String e() {
        int i8 = this.f4742d;
        if (i8 == 0) {
            return "Horizontal";
        }
        if (i8 == 1) {
            return "Vertical";
        }
        if (i8 == 2) {
            return "Both";
        }
        return "Unknown";
    }

    private int j(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i8) {
        int x7;
        int x8;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).K();
        linearSystem.D();
        constraintWidgetContainer.g(linearSystem, false);
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            arrayList.get(i9).g(linearSystem, false);
        }
        if (i8 == 0 && constraintWidgetContainer.X0 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i8 == 1 && constraintWidgetContainer.Y0 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.z();
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        this.f4743e = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            this.f4743e.add(new MeasureResult(arrayList.get(i10), linearSystem, i8));
        }
        if (i8 == 0) {
            x7 = linearSystem.x(constraintWidgetContainer.O);
            x8 = linearSystem.x(constraintWidgetContainer.Q);
            linearSystem.D();
        } else {
            x7 = linearSystem.x(constraintWidgetContainer.P);
            x8 = linearSystem.x(constraintWidgetContainer.R);
            linearSystem.D();
        }
        return x8 - x7;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f4739a.contains(constraintWidget)) {
            return false;
        }
        this.f4739a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList<WidgetGroup> arrayList) {
        int size = this.f4739a.size();
        if (this.f4744f != -1 && size > 0) {
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                WidgetGroup widgetGroup = arrayList.get(i8);
                if (this.f4744f == widgetGroup.f4740b) {
                    g(this.f4742d, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f4740b;
    }

    public int d() {
        return this.f4742d;
    }

    public int f(LinearSystem linearSystem, int i8) {
        if (this.f4739a.size() == 0) {
            return 0;
        }
        return j(linearSystem, this.f4739a, i8);
    }

    public void g(int i8, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.f4739a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.a(next);
            if (i8 == 0) {
                next.I0 = widgetGroup.c();
            } else {
                next.J0 = widgetGroup.c();
            }
        }
        this.f4744f = widgetGroup.f4740b;
    }

    public void h(boolean z7) {
        this.f4741c = z7;
    }

    public void i(int i8) {
        this.f4742d = i8;
    }

    public String toString() {
        Iterator<ConstraintWidget> it;
        String str = e() + " [" + this.f4740b + "] <";
        while (this.f4739a.iterator().hasNext()) {
            str = str + " " + it.next().t();
        }
        return str + " >";
    }
}
