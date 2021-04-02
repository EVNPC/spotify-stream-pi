package com.stream_pi.spotify.playsong;

import com.stream_pi.action_api.actionproperty.property.Property;
import com.stream_pi.action_api.actionproperty.property.Type;
import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.util.alert.StreamPiAlert;
import com.stream_pi.util.version.Version;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.player.AddItemToUsersPlaybackQueueRequest;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import javafx.scene.control.Button;

public class playsong extends NormalAction
{

    public playsong()
    {
        setName("Spotify Play");
        setAuthor("quimo");
        setHelpLink("https://github.com/stream-pi/essentialactions");
        setVersion(new Version(1,0,0));

        setCategory("Essential Actions");

    }

    @Override
    public void initProperties() throws Exception {
        //Called First

        Property property1 = new Property("song_name", Type.STRING);
        property1.SetDisplayName("Song Name");
        property1.setCanBeBlank(false);

        Property property2 = new Property("spotifyToken", Type.STRING);
        property1.SetDisplayName("Spotify Token");
        property2.setCanBeBlank(false);

        Property property3 = new Property("spotifySongURL", Type.STRING);
        property1.SetDisplayName("Spotify Song URL CODE (e.g. enter 4uLU6hMCjMI75M1A2tKUQC?si=ecb4a394fcc7445a and not https://open.spotify.com/track/4uLU6hMCjMI75M1A2tKUQC?si=ecb4a394fcc7445a");
        property3.setCanBeBlank(false);


        addClientProperties(
                property1,
                property2,
                property3
        );
    }


    @Override
    public void initAction()  {

            SpotifyApi spotifyApi = new SpotifyApi.Builder();
            Property token = getClientProperties().getSingleProperty("spotifyToken")
            .setAccessToken(token.getStringValue())
            .build();

    }


    @Override
    public void onActionClicked()
    {
        public static class AddItemToUsersPlaybackQueueExample {
            static Property token = getClientProperties().getSingleProperty("spotifyToken");
            static Property url = getClientProperties().getSingleProperty("spotifySongURL");
            private static final String accessToken = token.getStringValue();
            private static final String trackUri = url.getStringValue();
          
            private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
              .setAccessToken(accessToken)
              .build();
            private static final AddItemToUsersPlaybackQueueRequest addItemToUsersPlaybackQueueRequest = spotifyApi
              .addItemToUsersPlaybackQueue(trackUri)
          //    .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
              .build();
          
            public static void addItemToUsersPlaybackQueue_Sync() {
              try {
                final String string = addItemToUsersPlaybackQueueRequest.execute();
          
                System.out.println("Null: " + string);
              } catch (IOException | SpotifyWebApiException | ParseException e) {
                System.out.println("Error: " + e.getMessage());
              }

            }

        }

    }

}