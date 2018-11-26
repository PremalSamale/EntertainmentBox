package edu.sjsu.entertainmentbox.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class MoviePlayLog {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int logId;
    @ManyToOne
    private User user;
    @Column(name = "PLAY_STATUS")
    private String playStatus;
    @Column(name = "MOVIE_ID")
    private Movie movie;
    @Temporal(TemporalType.DATE)
    @Column(name = "MVE_START_TS")
    private Date mveStartTs;
    @Temporal(TemporalType.DATE)
    @Column(name = "MVE_END_TS")
    private Date mveEndTS;

    public MoviePlayLog() {
    }

    public MoviePlayLog(int logId, User user, String playStatus, Movie movie, Date mveStartTs, Date mveEndTS) {
        this.logId = logId;
        this.user = user;
        this.playStatus = playStatus;
        this.movie = movie;
        this.mveStartTs = mveStartTs;
        this.mveEndTS = mveEndTS;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getMveStartTs() {
        return mveStartTs;
    }

    public void setMveStartTs(Date mveStartTs) {
        this.mveStartTs = mveStartTs;
    }

    public Date getMveEndTS() {
        return mveEndTS;
    }

    public void setMveEndTS(Date mveEndTS) {
        this.mveEndTS = mveEndTS;
    }
}
