package ee.mtakso.driver.service.translations;

import ee.mtakso.driver.network.client.translations.ServiceTranslations;
import ee.mtakso.driver.network.client.translations.TranslationsClient;
import ee.mtakso.driver.service.translations.TranslationService;
import eu.bolt.driver.core.ui.translation.TranslationUpdateProvider;
import eu.bolt.driver.core.ui.translation.Translations;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationService.kt */
@Singleton
/* loaded from: classes3.dex */
public final class TranslationService implements TranslationUpdateProvider {

    /* renamed from: a  reason: collision with root package name */
    private final TranslationsClient f26095a;

    /* compiled from: TranslationService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26096a;

        static {
            int[] iArr = new int[ServiceTranslations.Quantity.values().length];
            try {
                iArr[ServiceTranslations.Quantity.ZERO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServiceTranslations.Quantity.ONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ServiceTranslations.Quantity.TWO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ServiceTranslations.Quantity.FEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ServiceTranslations.Quantity.MANY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ServiceTranslations.Quantity.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f26096a = iArr;
        }
    }

    @Inject
    public TranslationService(TranslationsClient apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        this.f26095a = apiClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Translations c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Translations) tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.core.ui.translation.TranslationUpdateProvider
    public Single<Translations> a(String locale) {
        Intrinsics.f(locale, "locale");
        Single<ServiceTranslations> a8 = this.f26095a.a(locale);
        final Function1<ServiceTranslations, Translations> function1 = new Function1<ServiceTranslations, Translations>() { // from class: ee.mtakso.driver.service.translations.TranslationService$getUpdatedTransactions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Translations invoke(ServiceTranslations it) {
                Intrinsics.f(it, "it");
                return TranslationService.this.f(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: i2.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Translations c8;
                c8 = TranslationService.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "override fun getUpdatedT…pTranslations(it) }\n    }");
        return x7;
    }

    public final Translations.Plurals d(ServiceTranslations.Plurals servicePlurals) {
        int v7;
        Map q8;
        Map u7;
        Intrinsics.f(servicePlurals, "servicePlurals");
        String b8 = servicePlurals.b();
        Set<Map.Entry<ServiceTranslations.Quantity, String>> entrySet = servicePlurals.a().entrySet();
        v7 = CollectionsKt__IterablesKt.v(entrySet, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(TuplesKt.a(e((ServiceTranslations.Quantity) entry.getKey()), (String) entry.getValue()));
        }
        q8 = MapsKt__MapsKt.q(arrayList);
        u7 = MapsKt__MapsKt.u(q8);
        return new Translations.Plurals(b8, u7);
    }

    public final Translations.Quantity e(ServiceTranslations.Quantity serviceQuantity) {
        Intrinsics.f(serviceQuantity, "serviceQuantity");
        switch (WhenMappings.f26096a[serviceQuantity.ordinal()]) {
            case 1:
                return Translations.Quantity.ZERO;
            case 2:
                return Translations.Quantity.ONE;
            case 3:
                return Translations.Quantity.TWO;
            case 4:
                return Translations.Quantity.FEW;
            case 5:
                return Translations.Quantity.MANY;
            case 6:
                return Translations.Quantity.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Translations f(ServiceTranslations serviceTranslations) {
        int v7;
        List J0;
        Intrinsics.f(serviceTranslations, "serviceTranslations");
        Map<String, String> b8 = serviceTranslations.b();
        List<ServiceTranslations.Plurals> a8 = serviceTranslations.a();
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ServiceTranslations.Plurals plurals : a8) {
            arrayList.add(d(plurals));
        }
        J0 = CollectionsKt___CollectionsKt.J0(arrayList);
        return new Translations(b8, J0);
    }
}
