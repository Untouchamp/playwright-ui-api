package infrastructure.entity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import infrastructure.data.constants.UserDataConstants;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

import static config.SetupConfig.APIEndpoints.*;
import static helpers.DataHub.convertObjectToMap;

@Data
@Builder
public class User {
    @Builder.Default
    private String username = UserDataConstants.DEFAULT_USERNAME;
    @Builder.Default
    private String email = UserDataConstants.DEFAULT_EMAIL;
    @SerializedName("first_name")
    @Builder.Default
    private String firstName = UserDataConstants.DEFAULT_FIRST_NAME;
    @SerializedName("last_name")
    @Builder.Default
    private String lastName = UserDataConstants.DEFAULT_LAST_NAME;
    @SerializedName("phone_number")
    @Builder.Default
    private String phoneNumber = UserDataConstants.DEFAULT_PHONE_NUMBER;
    @Builder.Default
    private String password = UserDataConstants.DEFAULT_PASSWORD;


    public static User createDefaultUser(APIRequestContext request) {
        User user = User.builder().build();
        Map<String, String> userMap = convertObjectToMap(user);
        request.post(apiPostAuthCreateUser,
                RequestOptions.create().setData(userMap));
        return getUserByUsername(request, UserDataConstants.DEFAULT_USERNAME);
    }

    public static User getUserByUsername(APIRequestContext request, String username) {
        APIResponse defaultUserResponse = request.get(apiGetUserFilter,
                RequestOptions.create().setQueryParam("username", username));

        return new Gson().fromJson(defaultUserResponse.text(), User.class);
    }
}
