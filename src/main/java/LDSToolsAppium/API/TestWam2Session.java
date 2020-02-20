package LDSToolsAppium.API;

import java.time.Instant;

class TestWam2Session {
    final String cookie;
    final Instant expiration;

    public TestWam2Session(String cookie, Instant expiration) {
        this.cookie = cookie;
        this.expiration = expiration;
    }

    public boolean isExpired() {
        return Instant.now().isAfter(expiration);
    }
}
