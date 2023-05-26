package eu.bolt.driver.core.ui.translation;

import eu.bolt.driver.core.R$string;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Translations.kt */
/* loaded from: classes5.dex */
public final class Translations {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f41214a;

    /* renamed from: b  reason: collision with root package name */
    private List<Plurals> f41215b;

    /* compiled from: Translations.kt */
    /* loaded from: classes5.dex */
    public enum Quantity {
        ZERO("zero", R$string.plurals_quantity_zero),
        ONE("one", R$string.plurals_quantity_one),
        TWO("two", R$string.plurals_quantity_two),
        FEW("few", R$string.plurals_quantity_few),
        MANY("many", R$string.plurals_quantity_many),
        OTHER("other", R$string.plurals_quantity_other);
        

        /* renamed from: f  reason: collision with root package name */
        private final String f41225f;

        /* renamed from: g  reason: collision with root package name */
        private final int f41226g;

        Quantity(String str, int i8) {
            this.f41225f = str;
            this.f41226g = i8;
        }

        public final int c() {
            return this.f41226g;
        }
    }

    public Translations() {
        this(null, null, 3, null);
    }

    public Translations(Map<String, String> translationList, List<Plurals> pluralsTranslationList) {
        Intrinsics.f(translationList, "translationList");
        Intrinsics.f(pluralsTranslationList, "pluralsTranslationList");
        this.f41214a = translationList;
        this.f41215b = pluralsTranslationList;
    }

    public final List<Plurals> a() {
        return this.f41215b;
    }

    public final Map<String, String> b() {
        return this.f41214a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Translations) {
            Translations translations = (Translations) obj;
            return Intrinsics.a(this.f41214a, translations.f41214a) && Intrinsics.a(this.f41215b, translations.f41215b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f41214a.hashCode() * 31) + this.f41215b.hashCode();
    }

    public String toString() {
        Map<String, String> map = this.f41214a;
        List<Plurals> list = this.f41215b;
        return "Translations(translationList=" + map + ", pluralsTranslationList=" + list + ")";
    }

    /* compiled from: Translations.kt */
    /* loaded from: classes5.dex */
    public static final class Plurals {

        /* renamed from: a  reason: collision with root package name */
        private String f41216a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Quantity, String> f41217b;

        public Plurals() {
            this(null, null, 3, null);
        }

        public Plurals(String name, Map<Quantity, String> items) {
            Intrinsics.f(name, "name");
            Intrinsics.f(items, "items");
            this.f41216a = name;
            this.f41217b = items;
        }

        public final Map<Quantity, String> a() {
            return this.f41217b;
        }

        public final String b() {
            return this.f41216a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Plurals) {
                Plurals plurals = (Plurals) obj;
                return Intrinsics.a(this.f41216a, plurals.f41216a) && Intrinsics.a(this.f41217b, plurals.f41217b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f41216a.hashCode() * 31) + this.f41217b.hashCode();
        }

        public String toString() {
            String str = this.f41216a;
            Map<Quantity, String> map = this.f41217b;
            return "Plurals(name=" + str + ", items=" + map + ")";
        }

        public /* synthetic */ Plurals(String str, Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? new LinkedHashMap() : map);
        }
    }

    public /* synthetic */ Translations(Map map, List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new LinkedHashMap() : map, (i8 & 2) != 0 ? new ArrayList() : list);
    }
}
