package com.sinch.android.rtc.internal.service.pubnub;

import com.sinch.gson.JsonArray;
import com.sinch.gson.JsonElement;
import com.sinch.gson.JsonParseException;
import com.sinch.gson.JsonParser;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PubNubResponse {
    private boolean isValid;
    private ArrayList<String> messages;
    private Long timeToken;

    /* loaded from: classes3.dex */
    public static class Builder {
        private boolean isValid;
        private ArrayList<String> messages = new ArrayList<>();
        private Long timeToken;

        public Builder addMessage(String str) {
            this.messages.add(str);
            return this;
        }

        public PubNubResponse build() {
            return new PubNubResponse(this.timeToken, this.isValid, this.messages);
        }

        public Builder setIsValid(boolean z7) {
            this.isValid = z7;
            return this;
        }

        public Builder setTimeToken(Long l8) {
            this.timeToken = l8;
            return this;
        }
    }

    public PubNubResponse(Long l8, boolean z7, ArrayList<String> arrayList) {
        this.timeToken = l8;
        this.isValid = z7;
        this.messages = arrayList;
    }

    public static PubNubResponse parse(String str) {
        Builder builder = new Builder();
        if (str != null) {
            try {
                JsonElement parse = new JsonParser().parse(str);
                if (parse.isJsonArray()) {
                    JsonArray asJsonArray = parse.getAsJsonArray();
                    if (asJsonArray.size() != 2) {
                        return builder.setIsValid(false).build();
                    }
                    builder.setTimeToken(Long.valueOf(asJsonArray.get(1).getAsLong()));
                    JsonArray asJsonArray2 = asJsonArray.get(0).getAsJsonArray();
                    for (int i8 = 0; i8 < asJsonArray2.size(); i8++) {
                        builder.addMessage(asJsonArray2.get(i8).getAsString());
                    }
                    return builder.setIsValid(true).build();
                }
                return builder.setIsValid(false).build();
            } catch (JsonParseException | ClassCastException | IllegalStateException | NumberFormatException unused) {
            }
        }
        return builder.setIsValid(false).build();
    }

    public ArrayList<String> getMessages() {
        return this.messages;
    }

    public String[] getMessagesAsArray() {
        String[] strArr = new String[this.messages.size()];
        this.messages.toArray(strArr);
        return strArr;
    }

    public Long getTimeToken() {
        return this.timeToken;
    }

    public boolean isValid() {
        return this.isValid;
    }
}
