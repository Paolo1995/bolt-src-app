package eu.bolt.client.chatdb.room.message.mapper;

import eu.bolt.chat.chatcore.entity.TranslationAttribution;
import eu.bolt.client.chatdb.room.message.translation.TranslationAttributionDBModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationAttributionMapper.kt */
/* loaded from: classes5.dex */
public final class TranslationAttributionMapper {
    public final TranslationAttribution a(TranslationAttributionDBModel attribution) {
        Intrinsics.f(attribution, "attribution");
        return new TranslationAttribution(attribution.b(), attribution.a());
    }

    public final TranslationAttributionDBModel b(TranslationAttribution attribution) {
        Intrinsics.f(attribution, "attribution");
        return new TranslationAttributionDBModel(attribution.b(), attribution.a());
    }
}
