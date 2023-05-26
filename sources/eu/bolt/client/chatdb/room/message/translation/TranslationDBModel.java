package eu.bolt.client.chatdb.room.message.translation;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationDBModel.kt */
/* loaded from: classes5.dex */
public final class TranslationDBModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f39899a;

    /* renamed from: b  reason: collision with root package name */
    private final TranslationAttributionDBModel f39900b;

    public TranslationDBModel() {
        this(null, null, 3, null);
    }

    public TranslationDBModel(String text, TranslationAttributionDBModel translationAttributionDBModel) {
        Intrinsics.f(text, "text");
        this.f39899a = text;
        this.f39900b = translationAttributionDBModel;
    }

    public final TranslationAttributionDBModel a() {
        return this.f39900b;
    }

    public final String b() {
        return this.f39899a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TranslationDBModel) {
            TranslationDBModel translationDBModel = (TranslationDBModel) obj;
            return Intrinsics.a(this.f39899a, translationDBModel.f39899a) && Intrinsics.a(this.f39900b, translationDBModel.f39900b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f39899a.hashCode() * 31;
        TranslationAttributionDBModel translationAttributionDBModel = this.f39900b;
        return hashCode + (translationAttributionDBModel == null ? 0 : translationAttributionDBModel.hashCode());
    }

    public String toString() {
        return "TranslationDBModel(text=" + this.f39899a + ", attribution=" + this.f39900b + ')';
    }

    public /* synthetic */ TranslationDBModel(String str, TranslationAttributionDBModel translationAttributionDBModel, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? null : translationAttributionDBModel);
    }
}
