package ee.mtakso.driver.service.language;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import ee.mtakso.App;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.language.LanguageListProviderImpl;
import eu.bolt.driver.core.language.Language;
import eu.bolt.driver.core.ui.translation.language.LanguageListProvider;
import eu.bolt.kalev.Kalev;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: LanguageListProviderImpl.kt */
/* loaded from: classes3.dex */
public final class LanguageListProviderImpl implements LanguageListProvider {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f24584b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final StoreLanguage f24585c = new StoreLanguage("en", "US", "English");

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f24586a;

    /* compiled from: LanguageListProviderImpl.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LanguageListProviderImpl.kt */
    /* loaded from: classes3.dex */
    public static final class StoreLanguage {
        @SerializedName("languageCode")

        /* renamed from: a  reason: collision with root package name */
        private final String f24587a;
        @SerializedName("countryCode")

        /* renamed from: b  reason: collision with root package name */
        private final String f24588b;
        @SerializedName("languageName")

        /* renamed from: c  reason: collision with root package name */
        private final String f24589c;

        public StoreLanguage(String languageCode, String countryCode, String languageName) {
            Intrinsics.f(languageCode, "languageCode");
            Intrinsics.f(countryCode, "countryCode");
            Intrinsics.f(languageName, "languageName");
            this.f24587a = languageCode;
            this.f24588b = countryCode;
            this.f24589c = languageName;
        }

        public final String a() {
            return this.f24588b;
        }

        public final String b() {
            return this.f24587a;
        }

        public final String c() {
            return this.f24589c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StoreLanguage) {
                StoreLanguage storeLanguage = (StoreLanguage) obj;
                return Intrinsics.a(this.f24587a, storeLanguage.f24587a) && Intrinsics.a(this.f24588b, storeLanguage.f24588b) && Intrinsics.a(this.f24589c, storeLanguage.f24589c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f24587a.hashCode() * 31) + this.f24588b.hashCode()) * 31) + this.f24589c.hashCode();
        }

        public String toString() {
            String str = this.f24587a;
            String str2 = this.f24588b;
            String str3 = this.f24589c;
            return "StoreLanguage(languageCode=" + str + ", countryCode=" + str2 + ", languageName=" + str3 + ")";
        }
    }

    @Inject
    public LanguageListProviderImpl() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<List<? extends StoreLanguage>>() { // from class: ee.mtakso.driver.service.language.LanguageListProviderImpl$languages$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends LanguageListProviderImpl.StoreLanguage> invoke() {
                LanguageListProviderImpl.StoreLanguage storeLanguage;
                List<? extends LanguageListProviderImpl.StoreLanguage> e8;
                String g8;
                try {
                    Gson gson = new Gson();
                    LanguageListProviderImpl languageListProviderImpl = LanguageListProviderImpl.this;
                    App app = App.getInstance();
                    Intrinsics.e(app, "getInstance()");
                    g8 = languageListProviderImpl.g(app, R.raw.languages);
                    Object fromJson = gson.fromJson(g8, new TypeToken<List<? extends LanguageListProviderImpl.StoreLanguage>>() { // from class: ee.mtakso.driver.service.language.LanguageListProviderImpl$languages$2.1
                    }.getType());
                    Intrinsics.e(fromJson, "{\n            Gson().fro…ge>>() {}.type)\n        }");
                    return (List) fromJson;
                } catch (Exception e9) {
                    Kalev.e(e9, "Unable to parse languages!");
                    storeLanguage = LanguageListProviderImpl.f24585c;
                    e8 = CollectionsKt__CollectionsJVMKt.e(storeLanguage);
                    return e8;
                }
            }
        });
        this.f24586a = b8;
    }

    private final List<StoreLanguage> e() {
        return (List) this.f24586a.getValue();
    }

    private final Language f(StoreLanguage storeLanguage) {
        return new Language(storeLanguage.b(), storeLanguage.a(), storeLanguage.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(Context context, int i8) {
        InputStream openRawResource = context.getResources().openRawResource(i8);
        Intrinsics.e(openRawResource, "context.resources.openRawResource(jsonResId)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, Charsets.f51135b));
        try {
            String f8 = TextStreamsKt.f(bufferedReader);
            CloseableKt.a(bufferedReader, null);
            return f8;
        } finally {
        }
    }

    @Override // eu.bolt.driver.core.ui.translation.language.LanguageListProvider
    public Language a() {
        return f(f24585c);
    }

    @Override // eu.bolt.driver.core.ui.translation.language.LanguageListProvider
    public List<Language> b() {
        int v7;
        List<StoreLanguage> e8 = e();
        v7 = CollectionsKt__IterablesKt.v(e8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (StoreLanguage storeLanguage : e8) {
            arrayList.add(f(storeLanguage));
        }
        return arrayList;
    }
}
