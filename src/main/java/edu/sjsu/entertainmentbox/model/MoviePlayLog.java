package edu.sjsu.entertainmentbox.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class MoviePlayLog {

    private Integer logId;
    private Integer customerId;
    private String playStatus;
    private Integer movieId;
    private Date mveStartTs;
    private Date mveEndTS;

    public MoviePlayLog() {
    }

    public MoviePlayLog(Integer logId, Integer customerId, String playStatus, Integer movieId, Date mveStartTs, Date mveEndTS) {
        this.logId = logId;
        this.customerId = customerId;
        this.playStatus = playStatus;
        this.movieId = movieId;
        this.mveStartTs = mveStartTs;
        this.mveEndTS = mveEndTS;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOG_ID", nullable = false, unique = true)
    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    @Column(name = "CUST_ID", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "PLAY_STATUS")
    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
    }

    @Column(name = "MOVIE_ID")
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "MVE_START_TS")
    public Date getMveStartTs() {
        return mveStartTs;
    }

    public void setMveStartTs(Date mveStartTs) {
        this.mveStartTs = mveStartTs;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "MVE_END_TS")
    public Date getMveEndTS() {
        return mveEndTS;
    }

    public void setMveEndTS(Date mveEndTS) {
        this.mveEndTS = mveEndTS;
    }
}
