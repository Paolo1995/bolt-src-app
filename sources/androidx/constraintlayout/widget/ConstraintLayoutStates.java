package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.simpleframework.xml.strategy.Name;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintLayoutStates {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f5052a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintSet f5053b;

    /* renamed from: c  reason: collision with root package name */
    int f5054c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f5055d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<State> f5056e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<ConstraintSet> f5057f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private ConstraintsChangedListener f5058g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class State {

        /* renamed from: a  reason: collision with root package name */
        int f5059a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<Variant> f5060b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f5061c;

        /* renamed from: d  reason: collision with root package name */
        ConstraintSet f5062d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.f5061c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.G7);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.H7) {
                    this.f5059a = obtainStyledAttributes.getResourceId(index, this.f5059a);
                } else if (index == R$styleable.I7) {
                    this.f5061c = obtainStyledAttributes.getResourceId(index, this.f5061c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f5061c);
                    context.getResources().getResourceName(this.f5061c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f5062d = constraintSet;
                        constraintSet.f(context, this.f5061c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(Variant variant) {
            this.f5060b.add(variant);
        }

        public int b(float f8, float f9) {
            for (int i8 = 0; i8 < this.f5060b.size(); i8++) {
                if (this.f5060b.get(i8).a(f8, f9)) {
                    return i8;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Variant {

        /* renamed from: a  reason: collision with root package name */
        float f5063a;

        /* renamed from: b  reason: collision with root package name */
        float f5064b;

        /* renamed from: c  reason: collision with root package name */
        float f5065c;

        /* renamed from: d  reason: collision with root package name */
        float f5066d;

        /* renamed from: e  reason: collision with root package name */
        int f5067e;

        /* renamed from: f  reason: collision with root package name */
        ConstraintSet f5068f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f5063a = Float.NaN;
            this.f5064b = Float.NaN;
            this.f5065c = Float.NaN;
            this.f5066d = Float.NaN;
            this.f5067e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.e8);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.f8) {
                    this.f5067e = obtainStyledAttributes.getResourceId(index, this.f5067e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f5067e);
                    context.getResources().getResourceName(this.f5067e);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f5068f = constraintSet;
                        constraintSet.f(context, this.f5067e);
                    }
                } else if (index == R$styleable.g8) {
                    this.f5066d = obtainStyledAttributes.getDimension(index, this.f5066d);
                } else if (index == R$styleable.h8) {
                    this.f5064b = obtainStyledAttributes.getDimension(index, this.f5064b);
                } else if (index == R$styleable.i8) {
                    this.f5065c = obtainStyledAttributes.getDimension(index, this.f5065c);
                } else if (index == R$styleable.j8) {
                    this.f5063a = obtainStyledAttributes.getDimension(index, this.f5063a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f8, float f9) {
            if (!Float.isNaN(this.f5063a) && f8 < this.f5063a) {
                return false;
            }
            if (!Float.isNaN(this.f5064b) && f9 < this.f5064b) {
                return false;
            }
            if (!Float.isNaN(this.f5065c) && f8 > this.f5065c) {
                return false;
            }
            if (!Float.isNaN(this.f5066d) && f9 > this.f5066d) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i8) {
        this.f5052a = constraintLayout;
        a(context, i8);
    }

    private void a(Context context, int i8) {
        XmlResourceParser xml = context.getResources().getXml(i8);
        State state = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c8 = 1;
                if (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType != 2) {
                            continue;
                        } else {
                            String name = xml.getName();
                            switch (name.hashCode()) {
                                case -1349929691:
                                    if (name.equals("ConstraintSet")) {
                                        c8 = 4;
                                        break;
                                    }
                                    c8 = 65535;
                                    break;
                                case 80204913:
                                    if (name.equals("State")) {
                                        c8 = 2;
                                        break;
                                    }
                                    c8 = 65535;
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
                                        break;
                                    }
                                    c8 = 65535;
                                    break;
                                case 1657696882:
                                    if (name.equals("layoutDescription")) {
                                        c8 = 0;
                                        break;
                                    }
                                    c8 = 65535;
                                    break;
                                case 1901439077:
                                    if (name.equals("Variant")) {
                                        c8 = 3;
                                        break;
                                    }
                                    c8 = 65535;
                                    break;
                                default:
                                    c8 = 65535;
                                    break;
                            }
                            if (c8 != 2) {
                                if (c8 != 3) {
                                    if (c8 != 4) {
                                        continue;
                                    } else {
                                        b(context, xml);
                                        continue;
                                    }
                                } else {
                                    Variant variant = new Variant(context, xml);
                                    if (state != null) {
                                        state.a(variant);
                                        continue;
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                state = new State(context, xml);
                                this.f5056e.put(state.f5059a, state);
                                continue;
                            }
                        }
                    } else {
                        xml.getName();
                        continue;
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        int i8;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i9 = 0; i9 < attributeCount; i9++) {
            String attributeName = xmlPullParser.getAttributeName(i9);
            String attributeValue = xmlPullParser.getAttributeValue(i9);
            if (attributeName != null && attributeValue != null && Name.MARK.equals(attributeName)) {
                if (attributeValue.contains("/")) {
                    i8 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), Name.MARK, context.getPackageName());
                } else {
                    i8 = -1;
                }
                if (i8 == -1) {
                    if (attributeValue.length() > 1) {
                        i8 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.s(context, xmlPullParser);
                this.f5057f.put(i8, constraintSet);
                return;
            }
        }
    }

    public void c(ConstraintsChangedListener constraintsChangedListener) {
        this.f5058g = constraintsChangedListener;
    }

    public void d(int i8, float f8, float f9) {
        ConstraintSet constraintSet;
        int i9;
        State state;
        int b8;
        ConstraintSet constraintSet2;
        int i10;
        int i11 = this.f5054c;
        if (i11 == i8) {
            if (i8 == -1) {
                state = this.f5056e.valueAt(0);
            } else {
                state = this.f5056e.get(i11);
            }
            int i12 = this.f5055d;
            if ((i12 != -1 && state.f5060b.get(i12).a(f8, f9)) || this.f5055d == (b8 = state.b(f8, f9))) {
                return;
            }
            if (b8 == -1) {
                constraintSet2 = this.f5053b;
            } else {
                constraintSet2 = state.f5060b.get(b8).f5068f;
            }
            if (b8 == -1) {
                i10 = state.f5061c;
            } else {
                i10 = state.f5060b.get(b8).f5067e;
            }
            if (constraintSet2 == null) {
                return;
            }
            this.f5055d = b8;
            ConstraintsChangedListener constraintsChangedListener = this.f5058g;
            if (constraintsChangedListener != null) {
                constraintsChangedListener.b(-1, i10);
            }
            constraintSet2.c(this.f5052a);
            ConstraintsChangedListener constraintsChangedListener2 = this.f5058g;
            if (constraintsChangedListener2 != null) {
                constraintsChangedListener2.a(-1, i10);
                return;
            }
            return;
        }
        this.f5054c = i8;
        State state2 = this.f5056e.get(i8);
        int b9 = state2.b(f8, f9);
        if (b9 == -1) {
            constraintSet = state2.f5062d;
        } else {
            constraintSet = state2.f5060b.get(b9).f5068f;
        }
        if (b9 == -1) {
            i9 = state2.f5061c;
        } else {
            i9 = state2.f5060b.get(b9).f5067e;
        }
        if (constraintSet == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i8 + ", dim =" + f8 + ", " + f9);
            return;
        }
        this.f5055d = b9;
        ConstraintsChangedListener constraintsChangedListener3 = this.f5058g;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.b(i8, i9);
        }
        constraintSet.c(this.f5052a);
        ConstraintsChangedListener constraintsChangedListener4 = this.f5058g;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.a(i8, i9);
        }
    }
}
