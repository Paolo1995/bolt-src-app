package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AnimatorInflaterCompat {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {

        /* renamed from: a  reason: collision with root package name */
        private PathParser.PathDataNode[] f7943a;

        PathDataEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public PathParser.PathDataNode[] evaluate(float f8, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (PathParser.b(pathDataNodeArr, pathDataNodeArr2)) {
                if (!PathParser.b(this.f7943a, pathDataNodeArr)) {
                    this.f7943a = PathParser.f(pathDataNodeArr);
                }
                for (int i8 = 0; i8 < pathDataNodeArr.length; i8++) {
                    this.f7943a[i8].d(pathDataNodeArr[i8], pathDataNodeArr2[i8], f8);
                }
                return this.f7943a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private AnimatorInflaterCompat() {
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f8) throws XmlPullParserException, IOException {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.animation.Animator b(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.b(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static Keyframe c(Keyframe keyframe, float f8) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f8);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f8);
        }
        return Keyframe.ofObject(f8);
    }

    private static void d(Keyframe[] keyframeArr, float f8, int i8, int i9) {
        float f9 = f8 / ((i9 - i8) + 2);
        while (i8 <= i9) {
            keyframeArr[i8].setFraction(keyframeArr[i8 - 1].getFraction() + f9);
            i8++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i8, int i9, int i10, String str) {
        boolean z7;
        int i11;
        boolean z8;
        int i12;
        boolean z9;
        ArgbEvaluator argbEvaluator;
        int i13;
        int i14;
        int i15;
        float f8;
        PropertyValuesHolder ofFloat;
        float f9;
        float f10;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i9);
        if (peekValue != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            i11 = peekValue.type;
        } else {
            i11 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i10);
        if (peekValue2 != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            i12 = peekValue2.type;
        } else {
            i12 = 0;
        }
        if (i8 == 4) {
            if ((z7 && h(i11)) || (z8 && h(i12))) {
                i8 = 3;
            } else {
                i8 = 0;
            }
        }
        if (i8 == 0) {
            z9 = true;
        } else {
            z9 = false;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        if (i8 == 2) {
            String string = typedArray.getString(i9);
            String string2 = typedArray.getString(i10);
            PathParser.PathDataNode[] d8 = PathParser.d(string);
            PathParser.PathDataNode[] d9 = PathParser.d(string2);
            if (d8 == null && d9 == null) {
                return null;
            }
            if (d8 != null) {
                PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
                if (d9 != null) {
                    if (PathParser.b(d8, d9)) {
                        ofObject = PropertyValuesHolder.ofObject(str, pathDataEvaluator, d8, d9);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else {
                    ofObject = PropertyValuesHolder.ofObject(str, pathDataEvaluator, d8);
                }
                return ofObject;
            } else if (d9 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), d9);
            }
        }
        if (i8 == 3) {
            argbEvaluator = ArgbEvaluator.a();
        } else {
            argbEvaluator = null;
        }
        if (z9) {
            if (z7) {
                if (i11 == 5) {
                    f9 = typedArray.getDimension(i9, 0.0f);
                } else {
                    f9 = typedArray.getFloat(i9, 0.0f);
                }
                if (z8) {
                    if (i12 == 5) {
                        f10 = typedArray.getDimension(i10, 0.0f);
                    } else {
                        f10 = typedArray.getFloat(i10, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f9, f10);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f9);
                }
            } else {
                if (i12 == 5) {
                    f8 = typedArray.getDimension(i10, 0.0f);
                } else {
                    f8 = typedArray.getFloat(i10, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f8);
            }
            propertyValuesHolder = ofFloat;
        } else if (z7) {
            if (i11 == 5) {
                i14 = (int) typedArray.getDimension(i9, 0.0f);
            } else if (h(i11)) {
                i14 = typedArray.getColor(i9, 0);
            } else {
                i14 = typedArray.getInt(i9, 0);
            }
            if (z8) {
                if (i12 == 5) {
                    i15 = (int) typedArray.getDimension(i10, 0.0f);
                } else if (h(i12)) {
                    i15 = typedArray.getColor(i10, 0);
                } else {
                    i15 = typedArray.getInt(i10, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i14, i15);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i14);
            }
        } else if (z8) {
            if (i12 == 5) {
                i13 = (int) typedArray.getDimension(i10, 0.0f);
            } else if (h(i12)) {
                i13 = typedArray.getColor(i10, 0);
            } else {
                i13 = typedArray.getInt(i10, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i13);
        }
        if (propertyValuesHolder != null && argbEvaluator != null) {
            propertyValuesHolder.setEvaluator(argbEvaluator);
            return propertyValuesHolder;
        }
        return propertyValuesHolder;
    }

    private static int f(TypedArray typedArray, int i8, int i9) {
        boolean z7;
        int i10;
        int i11;
        TypedValue peekValue = typedArray.peekValue(i8);
        boolean z8 = true;
        if (peekValue != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            i10 = peekValue.type;
        } else {
            i10 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i9);
        if (peekValue2 == null) {
            z8 = false;
        }
        if (z8) {
            i11 = peekValue2.type;
        } else {
            i11 = 0;
        }
        if ((!z7 || !h(i10)) && (!z8 || !h(i11))) {
            return 0;
        }
        return 3;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        boolean z7;
        TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7923j);
        int i8 = 0;
        TypedValue l8 = TypedArrayUtils.l(k8, xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        if (l8 != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && h(l8.type)) {
            i8 = 3;
        }
        k8.recycle();
        return i8;
    }

    private static boolean h(int i8) {
        return i8 >= 28 && i8 <= 31;
    }

    public static Animator i(Context context, int i8) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i8);
        }
        return j(context, context.getResources(), context.getTheme(), i8);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i8) throws Resources.NotFoundException {
        return k(context, resources, theme, i8, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i8, float f8) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i8);
                    return a(context, resources, theme, xmlResourceParser, f8);
                } catch (IOException e8) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i8));
                    notFoundException.initCause(e8);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e9) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i8));
                notFoundException2.initCause(e9);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f8, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7920g);
        TypedArray k9 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7924k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, k8, k9, f8, xmlPullParser);
        int h8 = TypedArrayUtils.h(k8, xmlPullParser, "interpolator", 0, 0);
        if (h8 > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.a(context, h8));
        }
        k8.recycle();
        if (k9 != null) {
            k9.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i8, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z7;
        Keyframe ofInt;
        TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7923j);
        float f8 = TypedArrayUtils.f(k8, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue l8 = TypedArrayUtils.l(k8, xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        if (l8 != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i8 == 4) {
            if (z7 && h(l8.type)) {
                i8 = 3;
            } else {
                i8 = 0;
            }
        }
        if (z7) {
            if (i8 != 0) {
                if (i8 != 1 && i8 != 3) {
                    ofInt = null;
                } else {
                    ofInt = Keyframe.ofInt(f8, TypedArrayUtils.g(k8, xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, 0, 0));
                }
            } else {
                ofInt = Keyframe.ofFloat(f8, TypedArrayUtils.f(k8, xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, 0, 0.0f));
            }
        } else if (i8 == 0) {
            ofInt = Keyframe.ofFloat(f8);
        } else {
            ofInt = Keyframe.ofInt(f8);
        }
        int h8 = TypedArrayUtils.h(k8, xmlPullParser, "interpolator", 1, 0);
        if (h8 > 0) {
            ofInt.setInterpolator(AnimationUtilsCompat.a(context, h8));
        }
        k8.recycle();
        return ofInt;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f8, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f8, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i8) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i8 == 4) {
                    i8 = g(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe m8 = m(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i8, xmlPullParser);
                if (m8 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(m8);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i9 = 0; i9 < size; i9++) {
                Keyframe keyframe3 = keyframeArr[i9];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i9 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i10 = size - 1;
                        if (i9 == i10) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i11 = i9;
                            for (int i12 = i9 + 1; i12 < i10 && keyframeArr[i12].getFraction() < 0.0f; i12++) {
                                i11 = i12;
                            }
                            d(keyframeArr, keyframeArr[i11 + 1].getFraction() - keyframeArr[i9 - 1].getFraction(), i9, i11);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i8 == 3) {
                propertyValuesHolder.setEvaluator(ArgbEvaluator.a());
            }
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i8;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray k8 = TypedArrayUtils.k(resources, theme, attributeSet, AndroidResources.f7922i);
                    String i9 = TypedArrayUtils.i(k8, xmlPullParser, "propertyName", 3);
                    int g8 = TypedArrayUtils.g(k8, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder o8 = o(context, resources, theme, xmlPullParser, i9, g8);
                    if (o8 == null) {
                        o8 = e(k8, g8, 0, 1, i9);
                    }
                    if (o8 != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(o8);
                    }
                    k8.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i8 = 0; i8 < size; i8++) {
                propertyValuesHolderArr[i8] = (PropertyValuesHolder) arrayList.get(i8);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f8, XmlPullParser xmlPullParser) {
        long g8 = TypedArrayUtils.g(typedArray, xmlPullParser, "duration", 1, 300);
        long g9 = TypedArrayUtils.g(typedArray, xmlPullParser, "startOffset", 2, 0);
        int g10 = TypedArrayUtils.g(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.j(xmlPullParser, "valueFrom") && TypedArrayUtils.j(xmlPullParser, "valueTo")) {
            if (g10 == 4) {
                g10 = f(typedArray, 5, 6);
            }
            PropertyValuesHolder e8 = e(typedArray, g10, 5, 6, "");
            if (e8 != null) {
                valueAnimator.setValues(e8);
            }
        }
        valueAnimator.setDuration(g8);
        valueAnimator.setStartDelay(g9);
        valueAnimator.setRepeatCount(TypedArrayUtils.g(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.g(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, g10, f8, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i8, float f8, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String i9 = TypedArrayUtils.i(typedArray, xmlPullParser, "pathData", 1);
        if (i9 != null) {
            String i10 = TypedArrayUtils.i(typedArray, xmlPullParser, "propertyXName", 2);
            String i11 = TypedArrayUtils.i(typedArray, xmlPullParser, "propertyYName", 3);
            if (i8 != 2) {
            }
            if (i10 == null && i11 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            s(PathParser.e(i9), objectAnimator, f8 * 0.5f, i10, i11);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.i(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f8, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f9 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f10 = 0.0f;
        do {
            f10 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f10));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f10 / f8)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f11 = f10 / (min - 1);
        int i8 = 0;
        int i9 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i8 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f9 - ((Float) arrayList.get(i9)).floatValue(), fArr3, null);
            fArr[i8] = fArr3[0];
            fArr2[i8] = fArr3[1];
            f9 += f11;
            int i10 = i9 + 1;
            if (i10 < arrayList.size() && f9 > ((Float) arrayList.get(i10)).floatValue()) {
                pathMeasure2.nextContour();
                i9 = i10;
            }
            i8++;
        }
        if (str != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str, fArr);
        } else {
            propertyValuesHolder2 = null;
        }
        if (str2 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(propertyValuesHolder);
        } else if (propertyValuesHolder == null) {
            objectAnimator.setValues(propertyValuesHolder2);
        } else {
            objectAnimator.setValues(propertyValuesHolder2, propertyValuesHolder);
        }
    }
}
