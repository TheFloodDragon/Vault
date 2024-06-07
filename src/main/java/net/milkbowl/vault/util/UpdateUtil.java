package net.milkbowl.vault.util;

import net.milkbowl.vault.Vault;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateUtil implements Listener {

    private static final String REPO_API_URL = "https://api.github.com/repos/Foulest/Vault/releases/latest";
    private static final String DOWNLOAD_URL = "https://github.com/Foulest/Vault/releases/latest";

    /**
     * Checks for updates and logs the result.
     */
    public static void checkForUpdates() {
        Vault plugin = Vault.getInstance();

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            String latestVersion = getLatestReleaseVersion();
            String currentVersion = plugin.getDescription().getVersion();

            if (latestVersion != null) {
                if (!latestVersion.equals(currentVersion)) {
                    MessageUtil.log(Level.WARNING, "A new version is available."
                            + " (Current: " + currentVersion + ", Latest: " + latestVersion + ")");

                    MessageUtil.log(Level.WARNING, "Download it at: " + DOWNLOAD_URL);
                }
            } else {
                MessageUtil.log(Level.WARNING, "Failed to fetch the latest release version.");
            }
        });
    }

    /**
     * Fetches the latest release version from the GitHub API.
     *
     * @return The latest release version or null if an error occurred.
     */
    private static @Nullable String getLatestReleaseVersion() {
        try {
            URL url = new URL(REPO_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();
            return extractVersion(content.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Extracts the version from the JSON response.
     *
     * @param jsonResponse The JSON response.
     * @return The version or null if not found.
     */
    private static @Nullable String extractVersion(String jsonResponse) {
        String versionRegex = "\"tag_name\":\"(.*?)\"";
        Pattern pattern = Pattern.compile(versionRegex);
        Matcher matcher = pattern.matcher(jsonResponse);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
