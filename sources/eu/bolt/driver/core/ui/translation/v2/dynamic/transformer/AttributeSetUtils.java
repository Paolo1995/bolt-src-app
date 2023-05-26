package eu.bolt.driver.core.ui.translation.v2.dynamic.transformer;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import java.io.IOException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AttributeUtils.kt */
/* loaded from: classes5.dex */
public final class AttributeSetUtils {
    public static final SparseArray<MenuItemStrings> a(int i8, Resources resources) {
        Intrinsics.f(resources, "resources");
        XmlResourceParser layout = resources.getLayout(i8);
        Intrinsics.e(layout, "resources.getLayout(menuRes)");
        AttributeSet attributeSet = Xml.asAttributeSet(layout);
        try {
            Intrinsics.e(attributeSet, "attributeSet");
            return d(layout, attributeSet);
        } catch (IOException unused) {
            return new SparseArray<>();
        } catch (XmlPullParserException unused2) {
            return new SparseArray<>();
        }
    }

    public static final CharSequence[] b(int i8, Resources resources) {
        Intrinsics.f(resources, "resources");
        try {
            return resources.getTextArray(i8);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final CharSequence c(int i8, Resources resources) {
        Intrinsics.f(resources, "resources");
        try {
            return resources.getText(i8);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final SparseArray<MenuItemStrings> d(XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Pair<Integer, MenuItemStrings> e8;
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                Intrinsics.e(name, "xmlPullParser.name");
                if (Intrinsics.a(name, "menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        SparseArray<MenuItemStrings> sparseArray = new SparseArray<>();
        boolean z7 = false;
        while (!z7) {
            if (eventType != 1) {
                if (eventType == 2) {
                    String name2 = xmlPullParser.getName();
                    Intrinsics.e(name2, "xmlPullParser.name");
                    if (Intrinsics.a(name2, "item") && (e8 = e(attributeSet)) != null) {
                        sparseArray.put(e8.d().intValue(), e8.e());
                    }
                }
            } else {
                z7 = true;
            }
            eventType = xmlPullParser.next();
        }
        return sparseArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0091, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlin.Pair<java.lang.Integer, eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.MenuItemStrings> e(android.util.AttributeSet r11) {
        /*
            int r0 = r11.getAttributeCount()
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = 0
            r5 = 0
        L9:
            if (r3 >= r0) goto L95
            java.lang.String r6 = r11.getAttributeName(r3)
            if (r6 == 0) goto L91
            int r7 = r6.hashCode()
            r8 = 3
            r9 = 2
            java.lang.String r10 = "@"
            switch(r7) {
                case -1735877235: goto L6d;
                case 3355: goto L5f;
                case 110371416: goto L56;
                case 504469935: goto L31;
                case 722953734: goto L28;
                case 1529604634: goto L1e;
                default: goto L1c;
            }
        L1c:
            goto L91
        L1e:
            java.lang.String r7 = "android:titleCondensed"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L3a
            goto L91
        L28:
            java.lang.String r7 = "android:id"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L68
            goto L91
        L31:
            java.lang.String r7 = "titleCondensed"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L3a
            goto L91
        L3a:
            java.lang.String r6 = r11.getAttributeValue(r3)
            if (r6 == 0) goto L95
            boolean r6 = kotlin.text.StringsKt.L(r6, r10, r2, r9, r1)
            if (r6 != 0) goto L47
            goto L95
        L47:
            if (r4 != 0) goto L4e
            eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.MenuItemStrings r4 = new eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.MenuItemStrings
            r4.<init>(r2, r2, r8, r1)
        L4e:
            int r6 = r11.getAttributeResourceValue(r3, r2)
            r4.d(r6)
            goto L91
        L56:
            java.lang.String r7 = "title"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L76
            goto L91
        L5f:
            java.lang.String r7 = "id"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L68
            goto L91
        L68:
            int r5 = r11.getAttributeResourceValue(r3, r2)
            goto L91
        L6d:
            java.lang.String r7 = "android:title"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L76
            goto L91
        L76:
            java.lang.String r6 = r11.getAttributeValue(r3)
            if (r6 == 0) goto L95
            boolean r6 = kotlin.text.StringsKt.L(r6, r10, r2, r9, r1)
            if (r6 != 0) goto L83
            goto L95
        L83:
            if (r4 != 0) goto L8a
            eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.MenuItemStrings r4 = new eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.MenuItemStrings
            r4.<init>(r2, r2, r8, r1)
        L8a:
            int r6 = r11.getAttributeResourceValue(r3, r2)
            r4.c(r6)
        L91:
            int r3 = r3 + 1
            goto L9
        L95:
            if (r5 == 0) goto La2
            if (r4 == 0) goto La2
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
            r1.<init>(r11, r4)
        La2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.core.ui.translation.v2.dynamic.transformer.AttributeSetUtils.e(android.util.AttributeSet):kotlin.Pair");
    }

    public static final void f(int i8, Menu menu, Resources resources) {
        MenuItem findItem;
        MenuItem findItem2;
        Intrinsics.f(menu, "menu");
        Intrinsics.f(resources, "resources");
        SparseArray<MenuItemStrings> a8 = a(i8, resources);
        int size = a8.size();
        for (int i9 = 0; i9 < size; i9++) {
            int keyAt = a8.keyAt(i9);
            MenuItemStrings valueAt = a8.valueAt(i9);
            if (valueAt.a() != 0 && (findItem2 = menu.findItem(keyAt)) != null) {
                findItem2.setTitle(resources.getString(valueAt.a()));
            }
            if (valueAt.b() != 0 && (findItem = menu.findItem(keyAt)) != null) {
                findItem.setTitleCondensed(resources.getString(valueAt.b()));
            }
        }
    }
}
