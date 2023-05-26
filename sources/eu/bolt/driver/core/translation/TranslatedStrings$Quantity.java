package eu.bolt.driver.core.translation;

import eu.bolt.driver.core.R$string;

/* compiled from: TranslatedStrings.kt */
/* loaded from: classes5.dex */
public enum TranslatedStrings$Quantity {
    ZERO("zero", R$string.plurals_quantity_zero),
    ONE("one", R$string.plurals_quantity_one),
    TWO("two", R$string.plurals_quantity_two),
    FEW("few", R$string.plurals_quantity_few),
    MANY("many", R$string.plurals_quantity_many),
    OTHER("other", R$string.plurals_quantity_other);
    

    /* renamed from: f  reason: collision with root package name */
    private final String f40997f;

    /* renamed from: g  reason: collision with root package name */
    private final int f40998g;

    TranslatedStrings$Quantity(String str, int i8) {
        this.f40997f = str;
        this.f40998g = i8;
    }

    public final int c() {
        return this.f40998g;
    }
}
