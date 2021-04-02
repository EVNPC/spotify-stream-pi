package com.stream_pi.spotify.pause;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.player.PauseUsersPlaybackRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;


public class Pause extends NormalAction
{

    public PauseSong()
    {
        setName("Spotify Pause");
        setAuthor("quimo");
        setHelpLink("https://github.com/stream-pi/essentialactions");
        setVersion(new Version(1,0,0));

        setCategory("Essential Actions");

    }

    @Override
    public void initProperties() throws Exception {
 
        Property property2 = new Property("spotifyToken", Type.STRING);
        property2.SetDisplayName("Set Spotify API Token");

        addClientProperties(
                property2
        );
    }


    @Override
    public void initAction()  {

        SpotifyApi spotifyApi = new SpotifyApi.Builder()
        .setAccessToken(getClientProperties().getSingleProperty("spotifyToken"))
        .build();

    }


    @Override
    public void onActionClicked()
    {           
    public class PauseUsersPlaybackExample {
        private static final String accessToken = getClientProperties().getSingleProperty("spotifyToken");
  
        private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
        .setAccessToken(accessToken)
        .build();
        private static final PauseUsersPlaybackRequest pauseUsersPlaybackRequest = spotifyApi.pauseUsersPlayback()
            .build();
  
            public static void pauseUsersPlayback_Sync() {
            try {
                final String string = pauseUsersPlaybackRequest.execute();
  
                System.out.println("Null: " + string);
            } catch (IOException | SpotifyWebApiException | ParseException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
