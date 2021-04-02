package data.search.simplified;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.EpisodeSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.search.simplified.SearchEpisodesRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class SearchEpisodesExample {
  private static final String accessToken = "taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk";
  private static final String q = "Abba";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static final SearchEpisodesRequest searchEpisodesRequest = spotifyApi.searchEpisodes(q)
//          .market(CountryCode.SE)
//          .limit(10)
//          .offset(0)
//          .includeExternal("audio")
    .build();

  public static void searchEpisodes_Sync() {
    try {
      final Paging<EpisodeSimplified> episodeSimplifiedPaging = searchEpisodesRequest.execute();

      System.out.println("Total: " + episodeSimplifiedPaging.getTotal());
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void searchEpisodes_Async() {
    try {
      final CompletableFuture<Paging<EpisodeSimplified>> pagingFuture = searchEpisodesRequest.executeAsync();

      // Thread free to do other tasks...

      // Example Only. Never block in production code.
      final Paging<EpisodeSimplified> episodeSimplifiedPaging = pagingFuture.join();

      System.out.println("Total: " + episodeSimplifiedPaging.getTotal());
    } catch (CompletionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    } catch (CancellationException e) {
      System.out.println("Async operation cancelled.");
    }
  }

  public static void main(String[] args) {
    searchEpisodes_Sync();
    searchEpisodes_Async();
  }
}
