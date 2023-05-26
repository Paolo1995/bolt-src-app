package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ComplexColorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Shader f5693a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f5694b;

    /* renamed from: c  reason: collision with root package name */
    private int f5695c;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i8) {
        this.f5693a = shader;
        this.f5694b = colorStateList;
        this.f5695c = i8;
    }

    @NonNull
    private static ComplexColorCompat a(@NonNull Resources resources, int i8, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i8);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.hashCode();
            if (!name.equals("gradient")) {
                if (name.equals("selector")) {
                    return c(ColorStateListInflaterCompat.b(resources, xml, asAttributeSet, theme));
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return d(GradientColorInflaterCompat.b(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComplexColorCompat b(int i8) {
        return new ComplexColorCompat(null, null, i8);
    }

    static ComplexColorCompat c(@NonNull ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    static ComplexColorCompat d(@NonNull Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    public static ComplexColorCompat g(@NonNull Resources resources, int i8, Resources.Theme theme) {
        try {
            return a(resources, i8, theme);
        } catch (Exception e8) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e8);
            return null;
        }
    }

    public int e() {
        return this.f5695c;
    }

    public Shader f() {
        return this.f5693a;
    }

    public boolean h() {
        if (this.f5693a != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        ColorStateList colorStateList;
        if (this.f5693a == null && (colorStateList = this.f5694b) != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f5694b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f5695c) {
                this.f5695c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i8) {
        this.f5695c = i8;
    }

    public boolean l() {
        if (!h() && this.f5695c == 0) {
            return false;
        }
        return true;
    }
}
