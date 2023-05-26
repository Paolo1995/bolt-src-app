package eu.bolt.driver.core.ui.translation;

import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.Translations;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class TranslationManager {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41205b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static volatile Map<String, String> f41206c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile Map<String, Translations.Plurals> f41207d;

    /* renamed from: a  reason: collision with root package name */
    private final TranslationUpdateProvider f41208a;

    /* compiled from: TranslationManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, Translations.Plurals> a() {
            return TranslationManager.f41207d;
        }

        public final Map<String, String> b() {
            return TranslationManager.f41206c;
        }

        public final void c(Map<String, Translations.Plurals> map) {
            TranslationManager.f41207d = map;
        }

        public final void d(Map<String, String> map) {
            TranslationManager.f41206c = map;
        }
    }

    @Inject
    public TranslationManager(TranslationUpdateProvider translationUpdateProvider) {
        Intrinsics.f(translationUpdateProvider, "translationUpdateProvider");
        this.f41208a = translationUpdateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexedTranslations k(Translations translations) {
        for (Map.Entry<String, String> entry : translations.b().entrySet()) {
            if (entry.getValue() != null) {
                translations.b().put(entry.getKey(), TranslationManagerKt.a(entry.getValue()));
            }
        }
        List<Translations.Plurals> a8 = translations.a();
        ArrayList<Translations.Plurals> arrayList = new ArrayList(CollectionsKt.v(a8, 10));
        for (Translations.Plurals plurals : a8) {
            for (Map.Entry<Translations.Quantity, String> entry2 : plurals.a().entrySet()) {
                if (entry2.getValue() != null) {
                    plurals.a().put(entry2.getKey(), TranslationManagerKt.a(entry2.getValue()));
                }
            }
            arrayList.add(plurals);
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
        for (Translations.Plurals plurals2 : arrayList) {
            arrayList2.add(TuplesKt.a(plurals2.b(), plurals2));
        }
        return new IndexedTranslations(translations, translations.b(), MapsKt.r(arrayList2, new LinkedHashMap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IndexedTranslations m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (IndexedTranslations) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Translations o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Translations) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void j() {
        f41206c = MapsKt.f();
        f41207d = MapsKt.f();
    }

    public final Single<Translations> l(String locale) {
        Intrinsics.f(locale, "locale");
        Kalev.b("Used language code: " + locale + " for updating resources.");
        Single<Translations> a8 = this.f41208a.a(locale);
        final Function1<Translations, IndexedTranslations> function1 = new Function1<Translations, IndexedTranslations>() { // from class: eu.bolt.driver.core.ui.translation.TranslationManager$updateTranslations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final IndexedTranslations invoke(Translations translations) {
                IndexedTranslations k8;
                Intrinsics.f(translations, "translations");
                k8 = TranslationManager.this.k(translations);
                return k8;
            }
        };
        Single<R> x7 = a8.x(new Function() { // from class: eu.bolt.driver.core.ui.translation.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                IndexedTranslations m8;
                m8 = TranslationManager.m(Function1.this, obj);
                return m8;
            }
        });
        final TranslationManager$updateTranslations$2 translationManager$updateTranslations$2 = new Function1<IndexedTranslations, Unit>() { // from class: eu.bolt.driver.core.ui.translation.TranslationManager$updateTranslations$2
            public final void b(IndexedTranslations indexedTranslations) {
                TranslationManager.Companion companion = TranslationManager.f41205b;
                companion.d(indexedTranslations.b());
                companion.c(indexedTranslations.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IndexedTranslations indexedTranslations) {
                b(indexedTranslations);
                return Unit.f50853a;
            }
        };
        Single o8 = x7.o(new Consumer() { // from class: eu.bolt.driver.core.ui.translation.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TranslationManager.n(Function1.this, obj);
            }
        });
        final TranslationManager$updateTranslations$3 translationManager$updateTranslations$3 = new Function1<IndexedTranslations, Translations>() { // from class: eu.bolt.driver.core.ui.translation.TranslationManager$updateTranslations$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Translations invoke(IndexedTranslations it) {
                Intrinsics.f(it, "it");
                return it.c();
            }
        };
        Single x8 = o8.x(new Function() { // from class: eu.bolt.driver.core.ui.translation.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Translations o9;
                o9 = TranslationManager.o(Function1.this, obj);
                return o9;
            }
        });
        final TranslationManager$updateTranslations$4 translationManager$updateTranslations$4 = new Function1<Throwable, Unit>() { // from class: eu.bolt.driver.core.ui.translation.TranslationManager$updateTranslations$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to download translations!");
            }
        };
        Single<Translations> l8 = x8.l(new Consumer() { // from class: eu.bolt.driver.core.ui.translation.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TranslationManager.p(Function1.this, obj);
            }
        });
        Intrinsics.e(l8, "fun updateTranslations(l…d translations!\") }\n    }");
        return l8;
    }
}
