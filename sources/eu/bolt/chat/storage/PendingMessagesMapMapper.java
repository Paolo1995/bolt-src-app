package eu.bolt.chat.storage;

import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.storage.data.MqttMessageModel;
import eu.bolt.chat.storage.data.PendingRawMessageModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PendingMessagesMapMapper.kt */
/* loaded from: classes5.dex */
public final class PendingMessagesMapMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final PendingMessagesMapMapper f39640a = new PendingMessagesMapMapper();

    private PendingMessagesMapMapper() {
    }

    public final Map<String, LinkedHashSet<PendingRawMessage>> a(Map<String, ? extends List<PendingRawMessageModel>> model) {
        Intrinsics.f(model, "model");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ? extends List<PendingRawMessageModel>> entry : model.entrySet()) {
            String key = entry.getKey();
            Object obj = hashMap.get(key);
            if (obj == null) {
                obj = new LinkedHashSet();
                hashMap.put(key, obj);
            }
            LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
            for (PendingRawMessageModel pendingRawMessageModel : entry.getValue()) {
                linkedHashSet.add(new PendingRawMessage(pendingRawMessageModel.b(), new MqttMessage(pendingRawMessageModel.a().b(), pendingRawMessageModel.a().a())));
            }
        }
        return hashMap;
    }

    public final Map<String, List<PendingRawMessageModel>> b(Map<String, LinkedHashSet<PendingRawMessage>> messagesMap) {
        int v7;
        Intrinsics.f(messagesMap, "messagesMap");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, LinkedHashSet<PendingRawMessage>> entry : messagesMap.entrySet()) {
            String key = entry.getKey();
            LinkedHashSet<PendingRawMessage> value = entry.getValue();
            v7 = CollectionsKt__IterablesKt.v(value, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (PendingRawMessage pendingRawMessage : value) {
                arrayList.add(new PendingRawMessageModel(pendingRawMessage.b(), new MqttMessageModel(pendingRawMessage.a().c(), pendingRawMessage.a().b())));
            }
            hashMap.put(key, arrayList);
        }
        return hashMap;
    }
}
