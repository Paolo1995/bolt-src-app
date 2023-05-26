package ee.mtakso.driver.network.client.translations;

import ee.mtakso.driver.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.transform.Transform;

/* compiled from: Translations.kt */
@Root(name = "resources", strict = false)
/* loaded from: classes3.dex */
public final class ServiceTranslations {
    @ElementMap(attribute = true, entry = "string", inline = true, key = "name")

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f22883a;
    @ElementList(entry = "plurals", inline = true, required = false)

    /* renamed from: b  reason: collision with root package name */
    private List<Plurals> f22884b;

    /* compiled from: Translations.kt */
    /* loaded from: classes3.dex */
    public enum Quantity {
        ZERO("zero", R.string.plurals_quantity_zero),
        ONE("one", R.string.plurals_quantity_one),
        TWO("two", R.string.plurals_quantity_two),
        FEW("few", R.string.plurals_quantity_few),
        MANY("many", R.string.plurals_quantity_many),
        OTHER("other", R.string.plurals_quantity_other);
        
        private final int resId;
        private final String value;

        Quantity(String str, int i8) {
            this.value = str;
            this.resId = i8;
        }

        public final int getResId() {
            return this.resId;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: Translations.kt */
    /* loaded from: classes3.dex */
    public static final class QuantityTransform implements Transform<Quantity> {
        @Override // org.simpleframework.xml.transform.Transform
        /* renamed from: a */
        public Quantity read(String str) {
            Quantity quantity;
            Quantity[] values = Quantity.values();
            int length = values.length;
            int i8 = 0;
            while (true) {
                if (i8 < length) {
                    quantity = values[i8];
                    if (Intrinsics.a(quantity.getValue(), str)) {
                        break;
                    }
                    i8++;
                } else {
                    quantity = null;
                    break;
                }
            }
            if (quantity == null) {
                return Quantity.OTHER;
            }
            return quantity;
        }

        @Override // org.simpleframework.xml.transform.Transform
        /* renamed from: b */
        public String write(Quantity quantity) {
            String value;
            if (quantity == null || (value = quantity.getValue()) == null) {
                return "";
            }
            return value;
        }
    }

    public ServiceTranslations() {
        this(null, null, 3, null);
    }

    public ServiceTranslations(Map<String, String> translationList, List<Plurals> pluralsTranslationList) {
        Intrinsics.f(translationList, "translationList");
        Intrinsics.f(pluralsTranslationList, "pluralsTranslationList");
        this.f22883a = translationList;
        this.f22884b = pluralsTranslationList;
    }

    public final List<Plurals> a() {
        return this.f22884b;
    }

    public final Map<String, String> b() {
        return this.f22883a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceTranslations) {
            ServiceTranslations serviceTranslations = (ServiceTranslations) obj;
            return Intrinsics.a(this.f22883a, serviceTranslations.f22883a) && Intrinsics.a(this.f22884b, serviceTranslations.f22884b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22883a.hashCode() * 31) + this.f22884b.hashCode();
    }

    public String toString() {
        Map<String, String> map = this.f22883a;
        List<Plurals> list = this.f22884b;
        return "ServiceTranslations(translationList=" + map + ", pluralsTranslationList=" + list + ")";
    }

    /* compiled from: Translations.kt */
    @Element(name = "plurals")
    /* loaded from: classes3.dex */
    public static final class Plurals {
        @Attribute(name = "name")

        /* renamed from: a  reason: collision with root package name */
        private String f22885a;
        @ElementMap(attribute = true, entry = "item", inline = true, key = "quantity", keyType = Quantity.class)

        /* renamed from: b  reason: collision with root package name */
        private Map<Quantity, String> f22886b;

        public Plurals() {
            this(null, null, 3, null);
        }

        public Plurals(String name, Map<Quantity, String> items) {
            Intrinsics.f(name, "name");
            Intrinsics.f(items, "items");
            this.f22885a = name;
            this.f22886b = items;
        }

        public final Map<Quantity, String> a() {
            return this.f22886b;
        }

        public final String b() {
            return this.f22885a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Plurals) {
                Plurals plurals = (Plurals) obj;
                return Intrinsics.a(this.f22885a, plurals.f22885a) && Intrinsics.a(this.f22886b, plurals.f22886b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f22885a.hashCode() * 31) + this.f22886b.hashCode();
        }

        public String toString() {
            String str = this.f22885a;
            Map<Quantity, String> map = this.f22886b;
            return "Plurals(name=" + str + ", items=" + map + ")";
        }

        public /* synthetic */ Plurals(String str, Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? new LinkedHashMap() : map);
        }
    }

    public /* synthetic */ ServiceTranslations(Map map, List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new LinkedHashMap() : map, (i8 & 2) != 0 ? new ArrayList() : list);
    }
}
