package ee.mtakso.driver.ui.screens.destination.search;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchSuggestionState.kt */
/* loaded from: classes3.dex */
public final class SearchSuggestionState {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListModel> f28245a;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSuggestionState(List<? extends ListModel> suggestions) {
        Intrinsics.f(suggestions, "suggestions");
        this.f28245a = suggestions;
    }

    public final List<ListModel> a() {
        return this.f28245a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchSuggestionState) && Intrinsics.a(this.f28245a, ((SearchSuggestionState) obj).f28245a);
    }

    public int hashCode() {
        return this.f28245a.hashCode();
    }

    public String toString() {
        List<ListModel> list = this.f28245a;
        return "SearchSuggestionState(suggestions=" + list + ")";
    }
}
