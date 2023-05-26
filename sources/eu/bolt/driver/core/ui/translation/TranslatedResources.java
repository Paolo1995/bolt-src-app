package eu.bolt.driver.core.ui.translation;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import eu.bolt.driver.core.R$plurals;
import eu.bolt.driver.core.ui.translation.Translations;
import eu.bolt.driver.core.util.StringUtilsKt;
import eu.bolt.kalev.Kalev;
import java.io.InputStream;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TranslatedResources.kt */
/* loaded from: classes5.dex */
public final class TranslatedResources extends Resources {

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f41201b = new Companion(null);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<String> f41202c = new SparseArray<>();
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private static final SparseArray<String> f41203d = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    private final Resources f41204a;

    /* compiled from: TranslatedResources.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranslatedResources(Resources baseRes) {
        super(baseRes.getAssets(), baseRes.getDisplayMetrics(), baseRes.getConfiguration());
        Intrinsics.f(baseRes, "baseRes");
        this.f41204a = baseRes;
    }

    private final String a(int i8, int i9) {
        Translations.Plurals plurals;
        SparseArray<String> sparseArray = f41203d;
        if (sparseArray.indexOfKey(i8) < 0) {
            sparseArray.put(i8, getResourceEntryName(i8));
        }
        Map<String, Translations.Plurals> a8 = TranslationManager.f41205b.a();
        Translations.Quantity quantity = null;
        if (a8 == null || (plurals = a8.get(sparseArray.get(i8))) == null) {
            return null;
        }
        String quantityString = this.f41204a.getQuantityString(R$plurals.plurals_matcher, i9);
        Intrinsics.e(quantityString, "baseRes.getQuantityStrin…lurals_matcher, quantity)");
        Translations.Quantity[] values = Translations.Quantity.values();
        int i10 = 0;
        int length = values.length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Translations.Quantity quantity2 = values[i10];
            if (Intrinsics.a(this.f41204a.getString(quantity2.c()), quantityString)) {
                quantity = quantity2;
                break;
            }
            i10++;
        }
        if (quantity == null) {
            quantity = Translations.Quantity.OTHER;
        }
        String str = plurals.a().get(quantity);
        if (str == null) {
            return plurals.a().get(Translations.Quantity.OTHER);
        }
        return str;
    }

    private final String b(int i8) {
        SparseArray<String> sparseArray = f41202c;
        if (sparseArray.indexOfKey(i8) < 0) {
            sparseArray.put(i8, getResourceEntryName(i8));
        }
        Map<String, String> b8 = TranslationManager.f41205b.b();
        if (b8 != null) {
            return b8.get(sparseArray.get(i8));
        }
        return null;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i8) {
        XmlResourceParser animation = this.f41204a.getAnimation(i8);
        Intrinsics.e(animation, "baseRes.getAnimation(id)");
        return animation;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i8) {
        return this.f41204a.getBoolean(i8);
    }

    @Override // android.content.res.Resources
    public int getColor(int i8) {
        return this.f41204a.getColor(i8);
    }

    @Override // android.content.res.Resources
    @SuppressLint({"UseCompatLoadingForColorStateLists"})
    public ColorStateList getColorStateList(int i8) {
        ColorStateList colorStateList = this.f41204a.getColorStateList(i8);
        Intrinsics.e(colorStateList, "baseRes.getColorStateList(id)");
        return colorStateList;
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        Configuration configuration = this.f41204a.getConfiguration();
        Intrinsics.e(configuration, "baseRes.getConfiguration()");
        return configuration;
    }

    @Override // android.content.res.Resources
    public float getDimension(int i8) {
        return this.f41204a.getDimension(i8);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i8) {
        return this.f41204a.getDimensionPixelOffset(i8);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i8) {
        return this.f41204a.getDimensionPixelSize(i8);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        DisplayMetrics displayMetrics = this.f41204a.getDisplayMetrics();
        Intrinsics.e(displayMetrics, "baseRes.getDisplayMetrics()");
        return displayMetrics;
    }

    @Override // android.content.res.Resources
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public Drawable getDrawable(int i8) {
        Drawable drawable = this.f41204a.getDrawable(i8);
        Intrinsics.e(drawable, "baseRes.getDrawable(id)");
        return drawable;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i8, int i9) {
        return this.f41204a.getDrawableForDensity(i8, i9);
    }

    @Override // android.content.res.Resources
    public float getFloat(int i8) {
        float f8;
        f8 = this.f41204a.getFloat(i8);
        return f8;
    }

    @Override // android.content.res.Resources
    public Typeface getFont(int i8) {
        Typeface font;
        font = this.f41204a.getFont(i8);
        Intrinsics.e(font, "baseRes.getFont(id)");
        return font;
    }

    @Override // android.content.res.Resources
    public float getFraction(int i8, int i9, int i10) {
        return this.f41204a.getFraction(i8, i9, i10);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f41204a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i8) {
        int[] intArray = this.f41204a.getIntArray(i8);
        Intrinsics.e(intArray, "baseRes.getIntArray(id)");
        return intArray;
    }

    @Override // android.content.res.Resources
    public int getInteger(int i8) {
        return this.f41204a.getInteger(i8);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i8) {
        XmlResourceParser layout = this.f41204a.getLayout(i8);
        Intrinsics.e(layout, "baseRes.getLayout(id)");
        return layout;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i8) {
        Movie movie = this.f41204a.getMovie(i8);
        Intrinsics.e(movie, "baseRes.getMovie(id)");
        return movie;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i8, int i9, Object... formatArgs) {
        Intrinsics.f(formatArgs, "formatArgs");
        String a8 = a(i8, i9);
        if (a8 == null) {
            String quantityString = this.f41204a.getQuantityString(i8, i9, Arrays.copyOf(formatArgs, formatArgs.length));
            Intrinsics.e(quantityString, "{\n            baseRes.ge…y, *formatArgs)\n        }");
            return quantityString;
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            Object[] copyOf = Arrays.copyOf(formatArgs, formatArgs.length);
            String format = String.format(a8, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.e(format, "format(format, *args)");
            return format;
        } catch (IllegalFormatException e8) {
            Kalev.o(e8).m("Plurals is malformatted in the live translations!");
            try {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
                String obj = this.f41204a.getQuantityText(i8, i9).toString();
                Object[] copyOf2 = Arrays.copyOf(formatArgs, formatArgs.length);
                String format2 = String.format(obj, Arrays.copyOf(copyOf2, copyOf2.length));
                Intrinsics.e(format2, "format(format, *args)");
                return format2;
            } catch (IllegalFormatException e9) {
                Kalev.o(e9).m("Plurals is malformatted in the APK resources!");
                return a8;
            }
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i8, int i9) {
        String a8 = a(i8, i9);
        if (a8 == null) {
            a8 = this.f41204a.getQuantityText(i8, i9).toString();
        }
        CharSequence a9 = StringUtilsKt.a(a8);
        if (a9 != null) {
            return a9;
        }
        return a8;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i8) {
        String resourceEntryName = this.f41204a.getResourceEntryName(i8);
        Intrinsics.e(resourceEntryName, "baseRes.getResourceEntryName(resid)");
        return resourceEntryName;
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i8) {
        String resourceName = this.f41204a.getResourceName(i8);
        Intrinsics.e(resourceName, "baseRes.getResourceName(resid)");
        return resourceName;
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i8) {
        String resourcePackageName = this.f41204a.getResourcePackageName(i8);
        Intrinsics.e(resourcePackageName, "baseRes.getResourcePackageName(resid)");
        return resourcePackageName;
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i8) {
        String resourceTypeName = this.f41204a.getResourceTypeName(i8);
        Intrinsics.e(resourceTypeName, "baseRes.getResourceTypeName(resid)");
        return resourceTypeName;
    }

    @Override // android.content.res.Resources
    public String getString(int i8) throws Resources.NotFoundException {
        String b8 = b(i8);
        if (b8 == null) {
            String string = this.f41204a.getString(i8);
            Intrinsics.e(string, "baseRes.getString(id)");
            return string;
        }
        return b8;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i8) {
        String[] stringArray = this.f41204a.getStringArray(i8);
        Intrinsics.e(stringArray, "baseRes.getStringArray(id)");
        return stringArray;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i8) {
        if (Build.VERSION.SDK_INT < 24) {
            String b8 = b(i8);
            if (b8 == null) {
                b8 = this.f41204a.getText(i8).toString();
            }
            Spanned fromHtml = Html.fromHtml(b8);
            Intrinsics.e(fromHtml, "{\n            Html.fromH…id).toString())\n        }");
            return fromHtml;
        }
        String b9 = b(i8);
        if (b9 == null) {
            b9 = this.f41204a.getText(i8).toString();
        }
        Spanned a8 = z4.b.a(b9, 63);
        Intrinsics.e(a8, "{\n            Html.fromH…L_MODE_COMPACT)\n        }");
        return a8;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i8) {
        CharSequence[] textArray = this.f41204a.getTextArray(i8);
        Intrinsics.e(textArray, "baseRes.getTextArray(id)");
        return textArray;
    }

    @Override // android.content.res.Resources
    public void getValue(int i8, TypedValue typedValue, boolean z7) {
        this.f41204a.getValue(i8, typedValue, z7);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i8, int i9, TypedValue typedValue, boolean z7) {
        this.f41204a.getValueForDensity(i8, i9, typedValue, z7);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i8) {
        XmlResourceParser xml = this.f41204a.getXml(i8);
        Intrinsics.e(xml, "baseRes.getXml(id)");
        return xml;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        TypedArray obtainAttributes = this.f41204a.obtainAttributes(attributeSet, iArr);
        Intrinsics.e(obtainAttributes, "baseRes.obtainAttributes(set, attrs)");
        return obtainAttributes;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i8) {
        TypedArray obtainTypedArray = this.f41204a.obtainTypedArray(i8);
        Intrinsics.e(obtainTypedArray, "baseRes.obtainTypedArray(id)");
        return obtainTypedArray;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i8) {
        InputStream openRawResource = this.f41204a.openRawResource(i8);
        Intrinsics.e(openRawResource, "baseRes.openRawResource(id)");
        return openRawResource;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i8) {
        AssetFileDescriptor openRawResourceFd = this.f41204a.openRawResourceFd(i8);
        Intrinsics.e(openRawResourceFd, "baseRes.openRawResourceFd(id)");
        return openRawResourceFd;
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f41204a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f41204a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        Resources resources = this.f41204a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i8, Resources.Theme theme) {
        int color;
        color = this.f41204a.getColor(i8, theme);
        return color;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i8, Resources.Theme theme) {
        ColorStateList colorStateList;
        colorStateList = this.f41204a.getColorStateList(i8, theme);
        Intrinsics.e(colorStateList, "baseRes.getColorStateList(id, theme)");
        return colorStateList;
    }

    @Override // android.content.res.Resources
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public Drawable getDrawable(int i8, Resources.Theme theme) {
        Drawable drawable = this.f41204a.getDrawable(i8, theme);
        Intrinsics.e(drawable, "baseRes.getDrawable(id, theme)");
        return drawable;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i8, int i9, Resources.Theme theme) {
        return this.f41204a.getDrawableForDensity(i8, i9, theme);
    }

    @Override // android.content.res.Resources
    public String getString(int i8, Object... formatArgs) throws Resources.NotFoundException {
        Intrinsics.f(formatArgs, "formatArgs");
        String b8 = b(i8);
        if (b8 == null) {
            String string = this.f41204a.getString(i8, Arrays.copyOf(formatArgs, formatArgs.length));
            Intrinsics.e(string, "{\n            baseRes.ge…d, *formatArgs)\n        }");
            return string;
        }
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            Object[] copyOf = Arrays.copyOf(formatArgs, formatArgs.length);
            String format = String.format(b8, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.e(format, "format(format, *args)");
            return format;
        } catch (IllegalFormatException e8) {
            Kalev.o(e8).m("String is malformatted in the live translations!");
            try {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
                String obj = this.f41204a.getText(i8).toString();
                Object[] copyOf2 = Arrays.copyOf(formatArgs, formatArgs.length);
                String format2 = String.format(obj, Arrays.copyOf(copyOf2, copyOf2.length));
                Intrinsics.e(format2, "format(format, *args)");
                return format2;
            } catch (IllegalFormatException e9) {
                Kalev.o(e9).m("String is malformatted in the APK resources!");
                return b8;
            }
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z7) {
        this.f41204a.getValue(str, typedValue, z7);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i8, TypedValue typedValue) {
        InputStream openRawResource = this.f41204a.openRawResource(i8, typedValue);
        Intrinsics.e(openRawResource, "baseRes.openRawResource(id, value)");
        return openRawResource;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i8, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT < 24) {
            String b8 = b(i8);
            if (b8 == null) {
                b8 = this.f41204a.getText(i8, charSequence).toString();
            }
            Spanned fromHtml = Html.fromHtml(b8);
            Intrinsics.e(fromHtml, "{\n            @Suppress(…ef).toString())\n        }");
            return fromHtml;
        }
        String b9 = b(i8);
        if (b9 == null) {
            b9 = this.f41204a.getText(i8, charSequence).toString();
        }
        Spanned a8 = z4.b.a(b9, 63);
        Intrinsics.e(a8, "{\n            Html.fromH…L_MODE_COMPACT)\n        }");
        return a8;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i8, int i9) {
        String a8 = a(i8, i9);
        if (a8 == null) {
            String quantityString = this.f41204a.getQuantityString(i8, i9);
            Intrinsics.e(quantityString, "baseRes.getQuantityString(id, quantity)");
            return quantityString;
        }
        return a8;
    }
}
