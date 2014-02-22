package com.m12y.flippy_bird.core.analytics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.m12y.flippy_bird.core.FlippyBird;

public class Analytics {
    private String sessionId;
    private String userId;
    private Json json;

    public Analytics(String platform) {
        sessionId = MathUtils.random(100000) + "-" + MathUtils.random(100000);

        if (FlippyBird.instance.preferences.contains("user_id")) {
            userId = FlippyBird.instance.preferences.getString("user_id");
        } else {
            userId = MathUtils.random(100000) + "-" + MathUtils.random(100000);
            FlippyBird.instance.preferences.putString("user_id", userId);
            FlippyBird.instance.preferences.flush();
        }

        json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);

        sendUserEvent(platform);
    }

    private void sendUserEvent(String platform) {
        UserEvent userEvent = new UserEvent();
        userEvent.user_id = userId;
        userEvent.session_id = sessionId;
        userEvent.platorm = platform;
        userEvent.build = "1";

        send("user", json.toJson(userEvent));
    }


    public void gameOver(int score) {
        DesignEvent event = new DesignEvent();
        event.event_id = "game_over";
        event.value = score;
        event.session_id = sessionId;
        event.user_id = userId;
        event.build = "1";

        send("design", json.toJson(event));
    }

    private void send(String type, String body) {
        Net.HttpRequest req = new Net.HttpRequest(Net.HttpMethods.POST);
        req.setContent(body);
        req.setUrl("http://flippyanalyticsproxy.herokuapp.com/1/aa4c71d567b270405dde94c2602e6cd9/" + type);
        Gdx.net.sendHttpRequest(req, null);
    }
}
