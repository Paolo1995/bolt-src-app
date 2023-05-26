package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f5811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListPlatformWrapper(Object obj) {
        this.f5811a = (LocaleList) obj;
    }

    @Override // androidx.core.os.LocaleListInterface
    public String a() {
        return this.f5811a.toLanguageTags();
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object b() {
        return this.f5811a;
    }

    public boolean equals(Object obj) {
        return this.f5811a.equals(((LocaleListInterface) obj).b());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i8) {
        return this.f5811a.get(i8);
    }

    public int hashCode() {
        return this.f5811a.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.f5811a.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f5811a.size();
    }

    public String toString() {
        return this.f5811a.toString();
    }
}
