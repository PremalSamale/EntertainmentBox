package edu.sjsu.entertainmentbox.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class MoviePlayLog {

    private Integer logId;
   // private Integer customerId;
    private String playStatus;
    //private Integer movieId;
    private Date mveStartTs;
    private Date mveEndTS;
    private Movie movie;

    public MoviePlayLog() {
    }

    public MoviePlayLog(String playStatus,  Date mveStartTs, Date mveEndTS) {

        this.playStatus = playStatus;
        this.mveStartTs = mveStartTs;
        this.mveEndTS = mveEndTS;
    }

    public MoviePlayLog(Integer logId, String playStatus, Date mveStartTs, Date mveEndTS, Movie movie) {
        this.logId = logId;
        this.playStatus = playStatus;
        this.mveStartTs = mveStartTs;
        this.mveEndTS = mveEndTS;
        this.movie = movie;
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

    @Column(name = "PLAY_STATUS")
    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID", nullable = false)
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
