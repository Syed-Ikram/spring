package com.hibernate.hb04OneToManyUni.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail(){}

    public InstructorDetail(String youtubeChannel,String hobby){
        this.youtubeChannel=youtubeChannel;
        this.hobby=hobby;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public int getId() {
        return Id;
    }

    public String getHobby() {
        return hobby;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "Id=" + Id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
