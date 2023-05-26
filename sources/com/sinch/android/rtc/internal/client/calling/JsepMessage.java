package com.sinch.android.rtc.internal.client.calling;

import android.util.Log;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionClient;
import com.sinch.gson.JsonElement;
import com.sinch.gson.JsonObject;
import com.sinch.gson.JsonParser;
import com.sinch.gson.JsonSyntaxException;
import org.webrtc.IceCandidate;
import org.webrtc.SessionDescription;

/* loaded from: classes3.dex */
public class JsepMessage {
    private static final String SDP_DESCRIPTION = "sdp";
    private static final String SDP_MID = "sdpMid";
    private static final String SDP_MLINE_INDEX = "sdpMLI";
    private static final String SDP_NAME = "cand";
    private static final String SDP_TYPE = "type";
    private static final String TAG = DefaultPeerConnectionClient.class.getSimpleName();
    private String payload;
    private Type type;

    /* renamed from: com.sinch.android.rtc.internal.client.calling.JsepMessage$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$SessionDescription$Type;

        static {
            int[] iArr = new int[SessionDescription.Type.values().length];
            $SwitchMap$org$webrtc$SessionDescription$Type = iArr;
            try {
                iArr[SessionDescription.Type.OFFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$SessionDescription$Type[SessionDescription.Type.ANSWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum Type {
        Offer,
        Answer,
        PrAnswer,
        IceCandidate,
        RelayIceCandidate
    }

    public JsepMessage(String str, int i8) {
        this.payload = str;
        this.type = (i8 < 0 || Type.values().length <= i8) ? Type.Offer : Type.values()[i8];
    }

    public JsepMessage(String str, Type type) {
        this.payload = str;
        this.type = type;
    }

    public static JsepMessage fromIceCandidate(IceCandidate iceCandidate) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(SDP_NAME, iceCandidate.sdp);
        jsonObject.addProperty(SDP_TYPE, "candidate");
        jsonObject.addProperty(SDP_MLINE_INDEX, Integer.valueOf(iceCandidate.sdpMLineIndex));
        jsonObject.addProperty(SDP_MID, iceCandidate.sdpMid);
        return new JsepMessage(jsonObject.toString(), Type.IceCandidate);
    }

    public static JsepMessage fromSessionDescription(SessionDescription sessionDescription) {
        Type type;
        String str;
        JsonObject jsonObject = new JsonObject();
        int i8 = AnonymousClass1.$SwitchMap$org$webrtc$SessionDescription$Type[sessionDescription.type.ordinal()];
        if (i8 == 1) {
            type = Type.Offer;
            str = "offer";
        } else if (i8 != 2) {
            return null;
        } else {
            type = Type.Answer;
            str = "answer";
        }
        jsonObject.addProperty(SDP_TYPE, str);
        jsonObject.addProperty(SDP_DESCRIPTION, sessionDescription.description);
        return new JsepMessage(jsonObject.toString(), type);
    }

    public IceCandidate getIceCandidate() {
        Type type = this.type;
        if (type == Type.RelayIceCandidate || type == Type.IceCandidate) {
            try {
                JsonObject asJsonObject = new JsonParser().parse(this.payload).getAsJsonObject();
                JsonElement jsonElement = asJsonObject.get(SDP_MID);
                JsonElement jsonElement2 = asJsonObject.get(SDP_MLINE_INDEX);
                JsonElement jsonElement3 = asJsonObject.get(SDP_NAME);
                try {
                    if (jsonElement == null || jsonElement2 == null || jsonElement3 == null) {
                        throw new UnsupportedOperationException("some elements are null: " + this.payload);
                    }
                    return new IceCandidate(jsonElement.getAsString(), jsonElement2.getAsInt(), jsonElement3.getAsString());
                } catch (UnsupportedOperationException e8) {
                    String str = TAG;
                    Log.e(str, "onIceCandidate failed. iceCandidateJson = " + asJsonObject + ", " + e8);
                    return null;
                }
            } catch (JsonSyntaxException e9) {
                String str2 = TAG;
                Log.e(str2, "onIceCandidate failed. iceCandidateJson = " + ((Object) null) + ", " + e9);
                return null;
            } catch (IllegalStateException e10) {
                String str3 = TAG;
                Log.e(str3, "onIceCandidate failed. iceCandidateJson = " + ((Object) null) + ", " + e10);
                return null;
            }
        }
        return null;
    }

    public String getPayload() {
        return this.payload;
    }

    public SessionDescription getSessionDescription() {
        Type type = this.type;
        if (type == Type.Offer || type == Type.Answer) {
            try {
                JsonObject asJsonObject = new JsonParser().parse(this.payload).getAsJsonObject();
                JsonElement jsonElement = asJsonObject.get(SDP_TYPE);
                JsonElement jsonElement2 = asJsonObject.get(SDP_DESCRIPTION);
                try {
                    if (jsonElement == null || jsonElement2 == null) {
                        throw new UnsupportedOperationException("some elements are null: " + this.payload);
                    }
                    String asString = jsonElement.getAsString();
                    String asString2 = jsonElement2.getAsString();
                    SessionDescription.Type type2 = asString.equalsIgnoreCase("offer") ? SessionDescription.Type.OFFER : asString.equalsIgnoreCase("pranwer") ? SessionDescription.Type.PRANSWER : asString.equalsIgnoreCase("answer") ? SessionDescription.Type.ANSWER : null;
                    if (type2 == null) {
                        String str = TAG;
                        Log.e(str, "onSdp failed. Can't derive sdpType. sdp = " + this.payload);
                        return null;
                    }
                    return new SessionDescription(type2, asString2);
                } catch (UnsupportedOperationException e8) {
                    String str2 = TAG;
                    Log.e(str2, "onSdp failed. sdp = " + this.payload + ", " + e8);
                    return null;
                }
            } catch (JsonSyntaxException e9) {
                String str3 = TAG;
                Log.e(str3, "onSdp failed. sdp = " + this.payload + ", " + e9);
                return null;
            } catch (IllegalStateException e10) {
                String str4 = TAG;
                Log.e(str4, "onSdp failed. sdp = " + this.payload + ", " + e10);
                return null;
            }
        }
        return null;
    }

    public Type getType() {
        return this.type;
    }
}
