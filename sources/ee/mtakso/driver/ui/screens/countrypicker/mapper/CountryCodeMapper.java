package ee.mtakso.driver.ui.screens.countrypicker.mapper;

import ee.mtakso.driver.service.country.Country;
import ee.mtakso.driver.ui.screens.countypicker.item.CountryDividerDelegate;
import ee.mtakso.driver.ui.screens.countypicker.item.CountryItemDelegate;
import ee.mtakso.driver.ui.screens.countypicker.item.CountryLetterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: CountryCodeMapper.kt */
/* loaded from: classes3.dex */
public final class CountryCodeMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final CountryCodeMapper f28108a = new CountryCodeMapper();

    private CountryCodeMapper() {
    }

    private final List<ListModel> a(List<CountryItemDelegate.Model> list) {
        Sequence O;
        Sequence n8;
        SortedMap e8;
        Sequence O2;
        Sequence A;
        Sequence q8;
        List e9;
        List p02;
        List S;
        O = CollectionsKt___CollectionsKt.O(list);
        n8 = SequencesKt___SequencesKt.n(O, new Function1<CountryItemDelegate.Model, Boolean>() { // from class: ee.mtakso.driver.ui.screens.countrypicker.mapper.CountryCodeMapper$createIndexedList$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(CountryItemDelegate.Model it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it.n().e().length() > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : n8) {
            Character valueOf = Character.valueOf(((CountryItemDelegate.Model) obj).n().e().charAt(0));
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        e8 = MapsKt__MapsJVMKt.e(linkedHashMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : e8.entrySet()) {
            CountryLetterDelegate.Model model = new CountryLetterDelegate.Model(null, new Text.Value(String.valueOf(entry.getKey())), 1, null);
            Object value = entry.getValue();
            Intrinsics.e(value, "section.value");
            O2 = CollectionsKt___CollectionsKt.O((Iterable) value);
            A = SequencesKt___SequencesKt.A(O2, new Comparator() { // from class: ee.mtakso.driver.ui.screens.countrypicker.mapper.CountryCodeMapper$createIndexedList$lambda$2$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t7, T t8) {
                    int a8;
                    a8 = ComparisonsKt__ComparisonsKt.a(((CountryItemDelegate.Model) t7).n().e(), ((CountryItemDelegate.Model) t8).n().e());
                    return a8;
                }
            });
            q8 = SequencesKt___SequencesKt.q(A, new Function1<CountryItemDelegate.Model, List<? extends ListModel>>() { // from class: ee.mtakso.driver.ui.screens.countrypicker.mapper.CountryCodeMapper$createIndexedList$3$countriesWithDividers$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final List<ListModel> invoke(CountryItemDelegate.Model country) {
                    List<ListModel> n9;
                    Intrinsics.f(country, "country");
                    n9 = CollectionsKt__CollectionsKt.n(country, new CountryDividerDelegate.Model(""));
                    return n9;
                }
            });
            e9 = CollectionsKt__CollectionsJVMKt.e(model);
            p02 = CollectionsKt___CollectionsKt.p0(e9, q8);
            S = CollectionsKt___CollectionsKt.S(p02, 1);
            CollectionsKt__MutableCollectionsKt.A(arrayList, S);
        }
        return arrayList;
    }

    private final List<ListModel> b(List<CountryItemDelegate.Model> list) {
        Sequence O;
        Sequence q8;
        List D;
        List<ListModel> S;
        O = CollectionsKt___CollectionsKt.O(list);
        q8 = SequencesKt___SequencesKt.q(O, new Function1<CountryItemDelegate.Model, List<? extends ListModel>>() { // from class: ee.mtakso.driver.ui.screens.countrypicker.mapper.CountryCodeMapper$createNonIndexedList$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ListModel> invoke(CountryItemDelegate.Model country) {
                List<ListModel> n8;
                Intrinsics.f(country, "country");
                n8 = CollectionsKt__CollectionsKt.n(country, new CountryDividerDelegate.Model(null, 1, null));
                return n8;
            }
        });
        D = SequencesKt___SequencesKt.D(q8);
        S = CollectionsKt___CollectionsKt.S(D, 1);
        return S;
    }

    private final List<CountryItemDelegate.Model> c(List<? extends Pair<? extends Country, String>> list) {
        int v7;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Country country = (Country) pair.a();
            Text.Value value = new Text.Value(country.e());
            arrayList.add(new CountryItemDelegate.Model(null, country, value, new Text.Value("+" + ((String) pair.b())), new Image.Res(country.f()), 1, null));
        }
        return arrayList;
    }

    public final List<ListModel> d(List<? extends Pair<? extends Country, String>> from) {
        Intrinsics.f(from, "from");
        List<CountryItemDelegate.Model> c8 = c(from);
        if (from.size() >= 0) {
            return a(c8);
        }
        return b(c8);
    }
}
