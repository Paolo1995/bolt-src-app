package ee.mtakso.driver.ui.screens.countypicker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.country.Country;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountryPickerViewModel.kt */
/* loaded from: classes3.dex */
public final class CountryPickerViewModel extends BaseViewModel {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f28124g = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    private static final List<Pair<Country, String>> f28125h;

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<List<Pair<Country, String>>> f28126f = new MutableLiveData<>();

    /* compiled from: CountryPickerViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List<Country> f02;
        f02 = ArraysKt___ArraysKt.f0(Country.values());
        ArrayList arrayList = new ArrayList();
        for (Country country : f02) {
            String[] h8 = country.h();
            ArrayList arrayList2 = new ArrayList(h8.length);
            for (String str : h8) {
                arrayList2.add(TuplesKt.a(country, str));
            }
            CollectionsKt__MutableCollectionsKt.A(arrayList, arrayList2);
        }
        f28125h = arrayList;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f28126f.o(f28125h);
    }

    public final LiveData<List<Pair<Country, String>>> D() {
        return this.f28126f;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlin.Pair<ee.mtakso.driver.service.country.Country, java.lang.String>> E(java.lang.CharSequence r9) {
        /*
            r8 = this;
            java.lang.String r0 = "rawQuery"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            java.lang.CharSequence r9 = kotlin.text.StringsKt.Y0(r9)
            int r0 = r9.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L19
            java.util.List<kotlin.Pair<ee.mtakso.driver.service.country.Country, java.lang.String>> r9 = ee.mtakso.driver.ui.screens.countypicker.CountryPickerViewModel.f28125h
            return r9
        L19:
            java.lang.String r9 = r9.toString()
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r3 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.e(r0, r3)
            java.lang.String r9 = r9.toLowerCase(r0)
            java.lang.String r0 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.e(r9, r0)
            java.util.List<kotlin.Pair<ee.mtakso.driver.service.country.Country, java.lang.String>> r0 = ee.mtakso.driver.ui.screens.countypicker.CountryPickerViewModel.f28125h
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L3a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L80
            java.lang.Object r4 = r0.next()
            r5 = r4
            kotlin.Pair r5 = (kotlin.Pair) r5
            java.lang.Object r6 = r5.a()
            ee.mtakso.driver.service.country.Country r6 = (ee.mtakso.driver.service.country.Country) r6
            java.lang.Object r5 = r5.b()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = r6.e()
            boolean r6 = kotlin.text.StringsKt.O(r6, r9, r1)
            if (r6 != 0) goto L79
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "+"
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 2
            r7 = 0
            boolean r5 = kotlin.text.StringsKt.Q(r5, r9, r2, r6, r7)
            if (r5 == 0) goto L77
            goto L79
        L77:
            r5 = 0
            goto L7a
        L79:
            r5 = 1
        L7a:
            if (r5 == 0) goto L3a
            r3.add(r4)
            goto L3a
        L80:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.countypicker.CountryPickerViewModel.E(java.lang.CharSequence):java.util.List");
    }

    public final void F(String search) {
        Intrinsics.f(search, "search");
        this.f28126f.o(E(search));
    }
}
