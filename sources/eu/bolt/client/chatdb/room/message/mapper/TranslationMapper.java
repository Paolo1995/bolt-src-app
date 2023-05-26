package eu.bolt.client.chatdb.room.message.mapper;

import eu.bolt.chat.chatcore.entity.ChatMessageTranslation;
import eu.bolt.chat.chatcore.entity.TranslationAttribution;
import eu.bolt.client.chatdb.room.message.translation.TranslationAttributionDBModel;
import eu.bolt.client.chatdb.room.message.translation.TranslationDBModel;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationMapper.kt */
/* loaded from: classes5.dex */
public final class TranslationMapper {

    /* renamed from: a  reason: collision with root package name */
    private final TranslationAttributionMapper f39895a;

    @Inject
    public TranslationMapper(TranslationAttributionMapper attributionMapper) {
        Intrinsics.f(attributionMapper, "attributionMapper");
        this.f39895a = attributionMapper;
    }

    public final ChatMessageTranslation a(TranslationDBModel translation) {
        TranslationAttribution translationAttribution;
        Intrinsics.f(translation, "translation");
        String b8 = translation.b();
        TranslationAttributionDBModel a8 = translation.a();
        if (a8 != null) {
            translationAttribution = this.f39895a.a(a8);
        } else {
            translationAttribution = null;
        }
        return new ChatMessageTranslation(b8, translationAttribution);
    }

    public final TranslationDBModel b(ChatMessageTranslation translation) {
        TranslationAttributionDBModel translationAttributionDBModel;
        Intrinsics.f(translation, "translation");
        String b8 = translation.b();
        TranslationAttribution a8 = translation.a();
        if (a8 != null) {
            translationAttributionDBModel = this.f39895a.b(a8);
        } else {
            translationAttributionDBModel = null;
        }
        return new TranslationDBModel(b8, translationAttributionDBModel);
    }
}
