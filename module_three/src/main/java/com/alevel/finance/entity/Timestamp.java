package com.alevel.finance.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.Instant;

@Embeddable
public class Timestamp {

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at", nullable = false)
    private Instant modifiedAt;

    public Timestamp() {
    }

    public Timestamp(Instant createdAt, Instant modifiedAt) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static Timestamp now() {
        var now = Instant.now();
        return new Timestamp(now, now);
    }

}