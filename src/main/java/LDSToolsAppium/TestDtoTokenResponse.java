package LDSToolsAppium;

import com.google.gson.annotations.SerializedName;

class TestDtoTokenResponse {
    @SerializedName("access_token")
    private String accessToken = "";
    @SerializedName("refresh_token")
    private String refreshToken = "";
    private String scope = "";
    @SerializedName("id_token")
    private String idToken = "";
    @SerializedName("token_type")
    private String tokenType = "";
    @SerializedName("expires_in")
    private long expiresIn = 0L;
    private String nonce = "";
    private String error = "";
    @SerializedName("error_description")
    private String errorDescription = "";

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        if (accessToken != null) {
            this.accessToken = accessToken;
        }
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        if (refreshToken != null) {
            this.refreshToken = refreshToken;
        }
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        if (scope != null) {
            this.scope = scope;
        }
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        if (idToken != null) {
            this.idToken = idToken;
        }
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        if (tokenType != null) {
            this.tokenType = tokenType;
        }
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        if (nonce != null) {
            this.nonce = nonce;
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        if (error != null) {
            this.error = error;
        }
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        if (errorDescription != null) {
            this.errorDescription = errorDescription;
        }
    }
}
